package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 获取多证书 */
public class CtelbListDomainCertLinksApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListDomainCertLinksApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-domain-cert-links", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListDomainCertLinksResponse send(
            Credential credential, ListDomainCertLinksRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.listenerID != null) {
            ctReq.addParam("listenerID", request.listenerID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListDomainCertLinksResponse.class);
    }

    public static class ListDomainCertLinksRequest {
        /** 资源池ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器 ID */
        @JsonProperty("listenerID")
        private String listenerID;

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
    }

    public static class ListDomainCertLinksResponse {
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
        private List<ListDomainCertLinksReturnObjResponse> returnObj;

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

        public List<ListDomainCertLinksReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListDomainCertLinksReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class ListDomainCertLinksReturnObjResponse {
        /** 多证书 id */
        @JsonProperty("certificateName")
        private String certificateName;

        /** 类型类型: ca / certificate */
        @JsonProperty("certificateType")
        private String certificateType;

        /** 扩展域名 */
        @JsonProperty("extDomainName")
        private String extDomainName;

        /** 创建时间 */
        @JsonProperty("createdTime")
        private String createdTime;

        /** 多证书 id */
        @JsonProperty("domainCertID")
        private String domainCertID;

        public String getCertificateName() {
            return this.certificateName;
        }

        public void setCertificateName(String certificateName) {
            this.certificateName = certificateName;
        }

        public String getCertificateType() {
            return this.certificateType;
        }

        public void setCertificateType(String certificateType) {
            this.certificateType = certificateType;
        }

        public String getExtDomainName() {
            return this.extDomainName;
        }

        public void setExtDomainName(String extDomainName) {
            this.extDomainName = extDomainName;
        }

        public String getCreatedTime() {
            return this.createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getDomainCertID() {
            return this.domainCertID;
        }

        public void setDomainCertID(String domainCertID) {
            this.domainCertID = domainCertID;
        }
    }
}
