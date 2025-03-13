package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 设置监听器 Nat64 */
public class CtelbUpdateListenerNat64Api {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbUpdateListenerNat64Api(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/update-listener-nat64", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public UpdateListenerNat64Response send(
            Credential credential, UpdateListenerNat64Request request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(UpdateListenerNat64Response.class);
    }

    public static class UpdateListenerNat64Request {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /** 是否开启 nat64 */
        @JsonProperty("enableNat64")
        private boolean enableNat64;

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

        public boolean getEnableNat64() {
            return this.enableNat64;
        }

        public void setEnableNat64(boolean enableNat64) {
            this.enableNat64 = enableNat64;
        }
    }

    public static class UpdateListenerNat64Response {
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
        private UpdateListenerNat64ReturnObjResponse returnObj;

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

        public UpdateListenerNat64ReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(UpdateListenerNat64ReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class UpdateListenerNat64ReturnObjResponse {
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
