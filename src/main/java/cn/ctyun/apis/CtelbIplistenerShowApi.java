package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 查看ip_listener详情 */
public class CtelbIplistenerShowApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbIplistenerShowApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/iplistener/show", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public IplistenerShowResponse send(Credential credential, IplistenerShowRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.ipListenerID != null) {
            ctReq.addParam("ipListenerID", request.ipListenerID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(IplistenerShowResponse.class);
    }

    public static class IplistenerShowRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器 ID */
        @JsonProperty("ipListenerID")
        private String ipListenerID;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getIpListenerID() {
            return this.ipListenerID;
        }

        public void setIpListenerID(String ipListenerID) {
            this.ipListenerID = ipListenerID;
        }
    }

    public static class IplistenerShowResponse {
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
        private IplistenerShowReturnObjResponse returnObj;

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

        public IplistenerShowReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(IplistenerShowReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class IplistenerShowReturnObjResponse {
        /** 网关负载均衡 ID */
        @JsonProperty("gwElbID")
        private String gwElbID;

        /** 名字 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** 监听器 id */
        @JsonProperty("ipListenerID")
        private String ipListenerID;

        /** 转发配置 */
        @JsonProperty("action")
        private IplistenerShowReturnObjActionResponse action;

        public String getGwElbID() {
            return this.gwElbID;
        }

        public void setGwElbID(String gwElbID) {
            this.gwElbID = gwElbID;
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

        public String getIpListenerID() {
            return this.ipListenerID;
        }

        public void setIpListenerID(String ipListenerID) {
            this.ipListenerID = ipListenerID;
        }

        public IplistenerShowReturnObjActionResponse getAction() {
            return this.action;
        }

        public void setAction(IplistenerShowReturnObjActionResponse action) {
            this.action = action;
        }
    }

    public static class IplistenerShowReturnObjActionResponse {
        /** 默认规则动作类型: forward / redirect */
        @JsonProperty("type")
        private String type;

        /** 转发配置 */
        @JsonProperty("forwardConfig")
        private IplistenerShowReturnObjActionForwardConfigResponse forwardConfig;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public IplistenerShowReturnObjActionForwardConfigResponse getForwardConfig() {
            return this.forwardConfig;
        }

        public void setForwardConfig(
                IplistenerShowReturnObjActionForwardConfigResponse forwardConfig) {
            this.forwardConfig = forwardConfig;
        }
    }

    public static class IplistenerShowReturnObjActionForwardConfigResponse {}
}
