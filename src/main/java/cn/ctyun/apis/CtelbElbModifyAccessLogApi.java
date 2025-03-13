package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 修改elb流日志 */
public class CtelbElbModifyAccessLogApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbElbModifyAccessLogApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/modify-access-log", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ElbModifyAccessLogResponse send(Credential credential, ElbModifyAccessLogRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ElbModifyAccessLogResponse.class);
    }

    public static class ElbModifyAccessLogRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 访问日志ID */
        @JsonProperty("accesslogID")
        private String accesslogID;

        /** 0:关闭日志收集 1:启用日志收集 */
        @JsonProperty("logCollection")
        private Integer logCollection;

        /** 日志项目code */
        @JsonProperty("projectCode")
        private String projectCode;

        /** 日志单元code */
        @JsonProperty("unitCode")
        private String unitCode;

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

        public String getAccesslogID() {
            return this.accesslogID;
        }

        public void setAccesslogID(String accesslogID) {
            this.accesslogID = accesslogID;
        }

        public Integer getLogCollection() {
            return this.logCollection;
        }

        public void setLogCollection(Integer logCollection) {
            this.logCollection = logCollection;
        }

        public String getProjectCode() {
            return this.projectCode;
        }

        public void setProjectCode(String projectCode) {
            this.projectCode = projectCode;
        }

        public String getUnitCode() {
            return this.unitCode;
        }

        public void setUnitCode(String unitCode) {
            this.unitCode = unitCode;
        }
    }

    public static class ElbModifyAccessLogResponse {
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
        private List<ElbModifyAccessLogReturnObjResponse> returnObj;

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

        public List<ElbModifyAccessLogReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ElbModifyAccessLogReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class ElbModifyAccessLogReturnObjResponse {
        /** 返回码 */
        @JsonProperty("Code")
        private String code;

        public String getCode() {
            return this.code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
