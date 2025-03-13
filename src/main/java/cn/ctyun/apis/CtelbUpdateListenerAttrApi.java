package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 更新监听器 */
public class CtelbUpdateListenerAttrApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbUpdateListenerAttrApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/update-listener-attr", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public UpdateListenerAttrResponse send(Credential credential, UpdateListenerAttrRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(UpdateListenerAttrResponse.class);
    }

    public static class UpdateListenerAttrRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器 ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /**
         * 描述,支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\|《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

        /** 访问控制ID */
        @JsonProperty("accessControlID")
        private String accessControlID;

        /** 访问控制类型。取值范围：Close（未启用）、White（白名单）、Black（黑名单） */
        @JsonProperty("accessControlType")
        private String accessControlType;

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

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAccessControlID() {
            return this.accessControlID;
        }

        public void setAccessControlID(String accessControlID) {
            this.accessControlID = accessControlID;
        }

        public String getAccessControlType() {
            return this.accessControlType;
        }

        public void setAccessControlType(String accessControlType) {
            this.accessControlType = accessControlType;
        }
    }

    public static class UpdateListenerAttrResponse {
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
    }
}
