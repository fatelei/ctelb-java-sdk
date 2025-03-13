package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建监听器 */
public class CtelbCreateListenerApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbCreateListenerApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/create-listener", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public CreateListenerResponse send(Credential credential, CreateListenerRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(CreateListenerResponse.class);
    }

    public static class CreateListenerRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡实例ID */
        @JsonProperty("loadBalancerID")
        private String loadBalancerID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /**
         * 支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\|《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

        /** 监听协议。取值范围：TCP、UDP、HTTP、HTTPS */
        @JsonProperty("protocol")
        private String protocol;

        /** 负载均衡实例监听端口。取值：1-65535 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

        /** 证书ID。当protocol为HTTPS时,此参数必选 */
        @JsonProperty("certificateID")
        private String certificateID;

        /** 是否开启双向认证。false（不开启）、true（开启） */
        @JsonProperty("caEnabled")
        private Boolean caEnabled;

        /** 双向认证的证书ID */
        @JsonProperty("clientCertificateID")
        private String clientCertificateID;

        /** 默认规则动作 */
        @JsonProperty("defaultAction")
        private CreateListenerDefaultActionRequest defaultAction;

        /** 访问控制ID */
        @JsonProperty("accessControlID")
        private String accessControlID;

        /** 访问控制类型。取值范围：Close（未启用）、White（白名单）、Black（黑名单） */
        @JsonProperty("accessControlType")
        private String accessControlType;

        /** x forward for功能。false（未开启）、true（开启） */
        @JsonProperty("forwardedForEnabled")
        private Boolean forwardedForEnabled;

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

        public String getLoadBalancerID() {
            return this.loadBalancerID;
        }

        public void setLoadBalancerID(String loadBalancerID) {
            this.loadBalancerID = loadBalancerID;
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

        public String getProtocol() {
            return this.protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public Integer getProtocolPort() {
            return this.protocolPort;
        }

        public void setProtocolPort(Integer protocolPort) {
            this.protocolPort = protocolPort;
        }

        public String getCertificateID() {
            return this.certificateID;
        }

        public void setCertificateID(String certificateID) {
            this.certificateID = certificateID;
        }

        public Boolean getCaEnabled() {
            return this.caEnabled;
        }

        public void setCaEnabled(Boolean caEnabled) {
            this.caEnabled = caEnabled;
        }

        public String getClientCertificateID() {
            return this.clientCertificateID;
        }

        public void setClientCertificateID(String clientCertificateID) {
            this.clientCertificateID = clientCertificateID;
        }

        public CreateListenerDefaultActionRequest getDefaultAction() {
            return this.defaultAction;
        }

        public void setDefaultAction(CreateListenerDefaultActionRequest defaultAction) {
            this.defaultAction = defaultAction;
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

        public Boolean getForwardedForEnabled() {
            return this.forwardedForEnabled;
        }

        public void setForwardedForEnabled(Boolean forwardedForEnabled) {
            this.forwardedForEnabled = forwardedForEnabled;
        }
    }

    public static class CreateListenerDefaultActionRequest {
        /** 默认规则动作类型。取值范围：forward、redirect */
        @JsonProperty("type")
        private String type;

        /** 转发配置，当type为forward时，此字段必填 */
        @JsonProperty("forwardConfig")
        private CreateListenerDefaultActionForwardConfigRequest forwardConfig;

        /** 重定向监听器ID，当type为redirect时，此字段必填 */
        @JsonProperty("redirectListenerID")
        private String redirectListenerID;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public CreateListenerDefaultActionForwardConfigRequest getForwardConfig() {
            return this.forwardConfig;
        }

        public void setForwardConfig(
                CreateListenerDefaultActionForwardConfigRequest forwardConfig) {
            this.forwardConfig = forwardConfig;
        }

        public String getRedirectListenerID() {
            return this.redirectListenerID;
        }

        public void setRedirectListenerID(String redirectListenerID) {
            this.redirectListenerID = redirectListenerID;
        }
    }

    public static class CreateListenerDefaultActionForwardConfigRequest {
        /** 后端服务组 */
        @JsonProperty("targetGroups")
        private List<CreateListenerDefaultActionForwardConfigTargetGroupsRequest> targetGroups;

        public List<CreateListenerDefaultActionForwardConfigTargetGroupsRequest> getTargetGroups() {
            return this.targetGroups;
        }

        public void setTargetGroups(
                List<CreateListenerDefaultActionForwardConfigTargetGroupsRequest> targetGroups) {
            this.targetGroups = targetGroups;
        }
    }

    public static class CreateListenerDefaultActionForwardConfigTargetGroupsRequest {
        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 后端主机权重，取值范围：1-256。默认为100 */
        @JsonProperty("weight")
        private Integer weight;

        public String getTargetGroupID() {
            return this.targetGroupID;
        }

        public void setTargetGroupID(String targetGroupID) {
            this.targetGroupID = targetGroupID;
        }

        public Integer getWeight() {
            return this.weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

    public static class CreateListenerResponse {
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
        private List<CreateListenerReturnObjResponse> returnObj;

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

        public List<CreateListenerReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<CreateListenerReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class CreateListenerReturnObjResponse {
        /** 监听器 ID */
        @JsonProperty("ID")
        private String iD;

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }
    }
}
