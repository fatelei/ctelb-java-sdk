package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 删除负载均衡实例 */
public class CtelbDeleteLoadBalancerApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbDeleteLoadBalancerApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/delete-loadbalancer", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public DeleteLoadBalancerResponse send(Credential credential, DeleteLoadBalancerRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(DeleteLoadBalancerResponse.class);
    }

    public static class DeleteLoadBalancerRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 企业项目 ID，默认为'0' */
        @JsonProperty("projectID")
        private String projectID;

        /** 负载均衡ID, 该字段后续废弃 */
        @JsonProperty("ID")
        private String iD;

        /** 负载均衡ID, 推荐使用该字段, 当同时使用 ID 和 elbID 时，优先使用 elbID */
        @JsonProperty("elbID")
        private String elbID;

        public String getClientToken() {
            return this.clientToken;
        }

        public void setClientToken(String clientToken) {
            this.clientToken = clientToken;
        }

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getElbID() {
            return this.elbID;
        }

        public void setElbID(String elbID) {
            this.elbID = elbID;
        }
    }

    public static class DeleteLoadBalancerResponse {
        /** 返回状态码（800为成功，900为失败） */
        @JsonProperty("statusCode")
        private Integer statusCode;

        /** statusCode为900时的错误信息; statusCode为800时为success, 英文 */
        @JsonProperty("message")
        private String message;

        /** statusCode为900时的错误信息; statusCode为800时为成功, 中文 */
        @JsonProperty("description")
        private String description;

        /** statusCode为900时为业务细分错误码，三段式：product.module.code; statusCode为800时为SUCCESS */
        @JsonProperty("errorCode")
        private String errorCode;

        /** 返回结果 */
        @JsonProperty("returnObj")
        private List<DeleteLoadBalancerReturnObjResponse> returnObj;

        /** statusCode为900时为业务细分错误码，三段式：product.module.code; statusCode为800时为SUCCESS */
        @JsonProperty("error")
        private String error;

        public Integer getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public List<DeleteLoadBalancerReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<DeleteLoadBalancerReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class DeleteLoadBalancerReturnObjResponse {
        /** 负载均衡ID */
        @JsonProperty("ID")
        private String iD;

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }
    }
}
