package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 创建多证书 */
public class CtelbCreateDomainCertLinkApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbCreateDomainCertLinkApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/elb/create-domain-cert-links",
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
    public CreateDomainCertLinkResponse send(
            Credential credential, CreateDomainCertLinkRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(CreateDomainCertLinkResponse.class);
    }

    public static class CreateDomainCertLinkRequest {
        /** 资源池ID */
        @JsonProperty("regionID")
        private String regionID;

        /**
         * 整个域名的总长度不能超过 255 个字符，每个子域名（包括顶级域名）的长度不能超过 63
         * 个字符，域名中的字符集包括大写字母、小写字母、数字和连字符（减号），连字符不能位于域名的开头
         */
        @JsonProperty("domainName")
        private String domainName;

        /** 证书 ID */
        @JsonProperty("certificateID")
        private String certificateID;

        /** 监听器 ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /**
         * 支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getDomainName() {
            return this.domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public String getCertificateID() {
            return this.certificateID;
        }

        public void setCertificateID(String certificateID) {
            this.certificateID = certificateID;
        }

        public String getListenerID() {
            return this.listenerID;
        }

        public void setListenerID(String listenerID) {
            this.listenerID = listenerID;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class CreateDomainCertLinkResponse {
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

        /** 检查结果 */
        @JsonProperty("returnObj")
        private CreateDomainCertLinkReturnObjResponse returnObj;

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

        public CreateDomainCertLinkReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(CreateDomainCertLinkReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class CreateDomainCertLinkReturnObjResponse {
        /** 多证书 id */
        @JsonProperty("domainCertID")
        private String domainCertID;

        public String getDomainCertID() {
            return this.domainCertID;
        }

        public void setDomainCertID(String domainCertID) {
            this.domainCertID = domainCertID;
        }
    }
}
