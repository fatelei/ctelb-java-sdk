package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 创建证书，该接口为异步接口，第一次请求会返回资源在创建中，需要用户发起多次请求，直到 status 为 done 为止。 */
public class CtelbAsyncCreateCertificateApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbAsyncCreateCertificateApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/elb/async-create-certificate",
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
    public AsyncCreateCertificateResponse send(
            Credential credential, AsyncCreateCertificateRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(AsyncCreateCertificateResponse.class);
    }

    public static class AsyncCreateCertificateRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 资源池ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 企业项目ID，默认为'0' */
        @JsonProperty("projectID")
        private String projectID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /**
         * 支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\|《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

        /** 证书类型。取值范围：Server（服务器证书）、Ca（Ca证书） */
        @JsonProperty("type")
        private String type;

        /** 服务器证书私钥，服务器证书此字段必填 */
        @JsonProperty("privateKey")
        private String privateKey;

        /** type为Server该字段表示服务器证书公钥Pem内容;type为Ca该字段表示Ca证书Pem内容 */
        @JsonProperty("certificate")
        private String certificate;

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

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPrivateKey() {
            return this.privateKey;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }

        public String getCertificate() {
            return this.certificate;
        }

        public void setCertificate(String certificate) {
            this.certificate = certificate;
        }
    }

    public static class AsyncCreateCertificateResponse {
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
        private AsyncCreateCertificateReturnObjResponse returnObj;

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

        public AsyncCreateCertificateReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(AsyncCreateCertificateReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class AsyncCreateCertificateReturnObjResponse {
        /** 创建进度: in_progress / done */
        @JsonProperty("status")
        private String status;

        /** 进度说明 */
        @JsonProperty("message")
        private String message;

        /** 负载均衡ID，可能为 null */
        @JsonProperty("certificateID")
        private String certificateID;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCertificateID() {
            return this.certificateID;
        }

        public void setCertificateID(String certificateID) {
            this.certificateID = certificateID;
        }
    }
}
