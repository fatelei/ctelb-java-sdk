package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 网关负载均衡开启删除保护 */
public class CtelbGwlbEnableDeleteProtectionApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbEnableDeleteProtectionApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/gwlb/enable-delete-protection",
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
    public GwlbEnableDeleteProtectionResponse send(
            Credential credential, GwlbEnableDeleteProtectionRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbEnableDeleteProtectionResponse.class);
    }

    public static class GwlbEnableDeleteProtectionRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 网关负载均衡ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getGwLbID() {
            return this.gwLbID;
        }

        public void setGwLbID(String gwLbID) {
            this.gwLbID = gwLbID;
        }
    }

    public static class GwlbEnableDeleteProtectionResponse {
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
        private GwlbEnableDeleteProtectionReturnObjResponse returnObj;

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

        public GwlbEnableDeleteProtectionReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbEnableDeleteProtectionReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbEnableDeleteProtectionReturnObjResponse {
        /** 网关负载均衡 ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

        public String getGwLbID() {
            return this.gwLbID;
        }

        public void setGwLbID(String gwLbID) {
            this.gwLbID = gwLbID;
        }
    }
}
