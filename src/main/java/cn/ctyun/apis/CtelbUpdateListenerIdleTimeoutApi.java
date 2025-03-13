package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 设置监听器 Idle Timeout */
public class CtelbUpdateListenerIdleTimeoutApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbUpdateListenerIdleTimeoutApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/elb/update-listener-idle-timeout",
                        "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public UpdateListenerIdleTimeoutResponse send(
            Credential credential, UpdateListenerIdleTimeoutRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(UpdateListenerIdleTimeoutResponse.class);
    }

    public static class UpdateListenerIdleTimeoutRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /** 链接空闲断开超时时间，单位秒，取值范围：1 - 300 */
        @JsonProperty("idleTimeout")
        private Integer idleTimeout;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getListenerID() {
            return this.listenerID;
        }

        public void setListenerID(String listenerID) {
            this.listenerID = listenerID;
        }

        public Integer getIdleTimeout() {
            return this.idleTimeout;
        }

        public void setIdleTimeout(Integer idleTimeout) {
            this.idleTimeout = idleTimeout;
        }
    }

    public static class UpdateListenerIdleTimeoutResponse {
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

        /** statusCode为900时为业务细分错误码，三段式：product.module.code; statusCode为800时为SUCCESS */
        @JsonProperty("error")
        private String error;

        /** ID */
        @JsonProperty("returnObj")
        private UpdateListenerIdleTimeoutReturnObjResponse returnObj;

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

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public UpdateListenerIdleTimeoutReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(UpdateListenerIdleTimeoutReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class UpdateListenerIdleTimeoutReturnObjResponse {
        /** ID */
        @JsonProperty("listenerID")
        private String listenerID;

        public String getListenerID() {
            return this.listenerID;
        }

        public void setListenerID(String listenerID) {
            this.listenerID = listenerID;
        }
    }
}
