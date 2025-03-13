package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 创建ip_listener */
public class CtelbIplistenerCreateApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbIplistenerCreateApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/iplistener/create", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public IplistenerCreateResponse send(Credential credential, IplistenerCreateRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(IplistenerCreateResponse.class);
    }

    public static class IplistenerCreateRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 网关负载均衡 ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

        /** 支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /** 动作配置 */
        @JsonProperty("action")
        private IplistenerCreateActionRequest action;

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

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public IplistenerCreateActionRequest getAction() {
            return this.action;
        }

        public void setAction(IplistenerCreateActionRequest action) {
            this.action = action;
        }
    }

    public static class IplistenerCreateActionRequest {
        /** 默认规则动作类型。取值范围：forward */
        @JsonProperty("type")
        private String type;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class IplistenerCreateResponse {
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
        private IplistenerCreateReturnObjResponse returnObj;

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

        public IplistenerCreateReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(IplistenerCreateReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class IplistenerCreateReturnObjResponse {
        /** 监听器 id */
        @JsonProperty("ipListenerID")
        private String ipListenerID;

        public String getIpListenerID() {
            return this.ipListenerID;
        }

        public void setIpListenerID(String ipListenerID) {
            this.ipListenerID = ipListenerID;
        }
    }
}
