package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 检查CA证书合法性 */
public class CtelbCheckCaCertApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbCheckCaCertApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/check-ca-cert", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public CheckCaCertResponse send(Credential credential, CheckCaCertRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(CheckCaCertResponse.class);
    }

    public static class CheckCaCertRequest {
        /** Ca证书Pem内容 */
        @JsonProperty("certificate")
        private String certificate;

        public String getCertificate() {
            return this.certificate;
        }

        public void setCertificate(String certificate) {
            this.certificate = certificate;
        }
    }

    public static class CheckCaCertResponse {
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

        /** 接口业务数据 */
        @JsonProperty("returnObj")
        private CheckCaCertReturnObjResponse returnObj;

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

        public CheckCaCertReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(CheckCaCertReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class CheckCaCertReturnObjResponse {
        /** 是否合法 */
        @JsonProperty("isValid")
        private Boolean isValid;

        public Boolean getIsValid() {
            return this.isValid;
        }

        public void setIsValid(Boolean isValid) {
            this.isValid = isValid;
        }
    }
}
