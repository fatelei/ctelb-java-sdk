package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 删除网关负载均衡 */
public class CtelbGwlbDeleteApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbDeleteApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/gwlb/delete", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public GwlbDeleteResponse send(Credential credential, GwlbDeleteRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbDeleteResponse.class);
    }

    public static class GwlbDeleteRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 企业项目ID，默认"0" */
        @JsonProperty("projectID")
        private String projectID;

        /** 网关负载均衡ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getClientToken() {
            return this.clientToken;
        }

        public void setClientToken(String clientToken) {
            this.clientToken = clientToken;
        }

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getGwLbID() {
            return this.gwLbID;
        }

        public void setGwLbID(String gwLbID) {
            this.gwLbID = gwLbID;
        }
    }

    public static class GwlbDeleteResponse {
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

        /** 接口业务数据 */
        @JsonProperty("returnObj")
        private GwlbDeleteReturnObjResponse returnObj;

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

        public GwlbDeleteReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbDeleteReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbDeleteReturnObjResponse {
        /** 订单id。 */
        @JsonProperty("masterOrderID")
        private String masterOrderID;

        /** 订单编号, 可以为 null。 */
        @JsonProperty("masterOrderNO")
        private String masterOrderNO;

        /** 可用区id。 */
        @JsonProperty("regionID")
        private String regionID;

        public String getMasterOrderID() {
            return this.masterOrderID;
        }

        public void setMasterOrderID(String masterOrderID) {
            this.masterOrderID = masterOrderID;
        }

        public String getMasterOrderNO() {
            return this.masterOrderNO;
        }

        public void setMasterOrderNO(String masterOrderNO) {
            this.masterOrderNO = masterOrderNO;
        }

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }
    }
}
