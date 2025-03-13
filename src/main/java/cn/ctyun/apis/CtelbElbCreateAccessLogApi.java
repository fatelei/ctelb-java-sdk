package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建elb流日志 */
public class CtelbElbCreateAccessLogApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbElbCreateAccessLogApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/add-access-log", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ElbCreateAccessLogResponse send(Credential credential, ElbCreateAccessLogRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ElbCreateAccessLogResponse.class);
    }

    public static class ElbCreateAccessLogRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡ID */
        @JsonProperty("elbID")
        private String elbID;

        /** 日志项目ID */
        @JsonProperty("projectCode")
        private String projectCode;

        /** 日志项目名称 */
        @JsonProperty("projectName")
        private String projectName;

        /** 日志单元ID */
        @JsonProperty("unitCode")
        private String unitCode;

        /** 日志单元名称 */
        @JsonProperty("unitName")
        private String unitName;

        /** 0:关闭日志收集 1:启用日志收集 */
        @JsonProperty("logCollection")
        private Integer logCollection;

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

        public String getElbID() {
            return this.elbID;
        }

        public void setElbID(String elbID) {
            this.elbID = elbID;
        }

        public String getProjectCode() {
            return this.projectCode;
        }

        public void setProjectCode(String projectCode) {
            this.projectCode = projectCode;
        }

        public String getProjectName() {
            return this.projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getUnitCode() {
            return this.unitCode;
        }

        public void setUnitCode(String unitCode) {
            this.unitCode = unitCode;
        }

        public String getUnitName() {
            return this.unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public Integer getLogCollection() {
            return this.logCollection;
        }

        public void setLogCollection(Integer logCollection) {
            this.logCollection = logCollection;
        }
    }

    public static class ElbCreateAccessLogResponse {
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
        private List<ElbCreateAccessLogReturnObjResponse> returnObj;

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

        public List<ElbCreateAccessLogReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ElbCreateAccessLogReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class ElbCreateAccessLogReturnObjResponse {
        /** 访问日志ID */
        @JsonProperty("id")
        private String id;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
