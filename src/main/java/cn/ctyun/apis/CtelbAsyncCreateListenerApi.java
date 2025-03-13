package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建监听器 */
public class CtelbAsyncCreateListenerApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbAsyncCreateListenerApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/async-create-listener", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public AsyncCreateListenerResponse send(
            Credential credential, AsyncCreateListenerRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(AsyncCreateListenerResponse.class);
    }

    public static class AsyncCreateListenerRequest {
        /** 客户端存根，用于保证订单幂等性。要求单个云平台账户内唯一,1-64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡实例ID */
        @JsonProperty("loadBalanceID")
        private String loadBalanceID;

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

        /** 后端服务组 */
        @JsonProperty("targetGroup")
        private AsyncCreateListenerTargetGroupRequest targetGroup;

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

        public String getLoadBalanceID() {
            return this.loadBalanceID;
        }

        public void setLoadBalanceID(String loadBalanceID) {
            this.loadBalanceID = loadBalanceID;
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

        public AsyncCreateListenerTargetGroupRequest getTargetGroup() {
            return this.targetGroup;
        }

        public void setTargetGroup(AsyncCreateListenerTargetGroupRequest targetGroup) {
            this.targetGroup = targetGroup;
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

    public static class AsyncCreateListenerTargetGroupRequest {
        /** 后端服务组名字 */
        @JsonProperty("name")
        private String name;

        /** 负载均衡算法，支持: rr (轮询), lc (最少链接) */
        @JsonProperty("algorithm")
        private String algorithm;

        /** 后端服务 */
        @JsonProperty("targets")
        private List<AsyncCreateListenerTargetGroupTargetsRequest> targets;

        /** 健康检查配置 */
        @JsonProperty("healthCheck")
        private AsyncCreateListenerTargetGroupHealthCheckRequest healthCheck;

        /** 会话保持 */
        @JsonProperty("sessionSticky")
        private AsyncCreateListenerTargetGroupSessionStickyRequest sessionSticky;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlgorithm() {
            return this.algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public List<AsyncCreateListenerTargetGroupTargetsRequest> getTargets() {
            return this.targets;
        }

        public void setTargets(List<AsyncCreateListenerTargetGroupTargetsRequest> targets) {
            this.targets = targets;
        }

        public AsyncCreateListenerTargetGroupHealthCheckRequest getHealthCheck() {
            return this.healthCheck;
        }

        public void setHealthCheck(AsyncCreateListenerTargetGroupHealthCheckRequest healthCheck) {
            this.healthCheck = healthCheck;
        }

        public AsyncCreateListenerTargetGroupSessionStickyRequest getSessionSticky() {
            return this.sessionSticky;
        }

        public void setSessionSticky(
                AsyncCreateListenerTargetGroupSessionStickyRequest sessionSticky) {
            this.sessionSticky = sessionSticky;
        }
    }

    public static class AsyncCreateListenerTargetGroupTargetsRequest {
        /** 后端服务主机 id */
        @JsonProperty("instanceID")
        private String instanceID;

        /** 后端服务监听端口1-65535 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

        /** 后端服务主机类型,仅支持vm类型 */
        @JsonProperty("instanceType")
        private String instanceType;

        /** 后端服务主机权重: 1 - 256 */
        @JsonProperty("weight")
        private Integer weight;

        /** 后端服务主机主网卡所在的 IP */
        @JsonProperty("address")
        private String address;

        public String getInstanceID() {
            return this.instanceID;
        }

        public void setInstanceID(String instanceID) {
            this.instanceID = instanceID;
        }

        public Integer getProtocolPort() {
            return this.protocolPort;
        }

        public void setProtocolPort(Integer protocolPort) {
            this.protocolPort = protocolPort;
        }

        public String getInstanceType() {
            return this.instanceType;
        }

        public void setInstanceType(String instanceType) {
            this.instanceType = instanceType;
        }

        public Integer getWeight() {
            return this.weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class AsyncCreateListenerTargetGroupHealthCheckRequest {
        /** 健康检查协议。取值范围：TCP、UDP、HTTP */
        @JsonProperty("protocol")
        private String protocol;

        /** 健康检查响应的最大超时时间，取值范围：2-60秒，默认为2秒 */
        @JsonProperty("timeout")
        private Integer timeout;

        /** 负载均衡进行健康检查的时间间隔，取值范围：1-20940秒，默认为5秒 */
        @JsonProperty("interval")
        private Integer interval;

        /** 最大重试次数，取值范围：1-10次，默认为2次 */
        @JsonProperty("maxRetry")
        private Integer maxRetry;

        /** 仅当protocol为HTTP时必填且生效,HTTP请求的方法默认GET，{GET/HEAD} */
        @JsonProperty("httpMethod")
        private String httpMethod;

        /** 仅当protocol为HTTP时必填且生效,默认为'/',支持的最大字符长度：80 */
        @JsonProperty("httpUrlPath")
        private String httpUrlPath;

        /** 仅当protocol为HTTP时必填且生效，最长支持64个字符，只能是三位数，可以以,分隔表示多个，或者以-分割表示范围，默认200 */
        @JsonProperty("httpExpectedCodes")
        private String httpExpectedCodes;

        public String getProtocol() {
            return this.protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public Integer getTimeout() {
            return this.timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getInterval() {
            return this.interval;
        }

        public void setInterval(Integer interval) {
            this.interval = interval;
        }

        public Integer getMaxRetry() {
            return this.maxRetry;
        }

        public void setMaxRetry(Integer maxRetry) {
            this.maxRetry = maxRetry;
        }

        public String getHttpMethod() {
            return this.httpMethod;
        }

        public void setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
        }

        public String getHttpUrlPath() {
            return this.httpUrlPath;
        }

        public void setHttpUrlPath(String httpUrlPath) {
            this.httpUrlPath = httpUrlPath;
        }

        public String getHttpExpectedCodes() {
            return this.httpExpectedCodes;
        }

        public void setHttpExpectedCodes(String httpExpectedCodes) {
            this.httpExpectedCodes = httpExpectedCodes;
        }
    }

    public static class AsyncCreateListenerTargetGroupSessionStickyRequest {
        /** 会话保持类型。取值范围：APP_COOKIE、HTTP_COOKIE、SOURCE_IP */
        @JsonProperty("sessionType")
        private String sessionType;

        /** cookie名称，当 sessionType 为 APP_COOKIE 时，为必填参数 */
        @JsonProperty("cookieName")
        private String cookieName;

        /** 会话过期时间，当 sessionType 为 APP_COOKIE 或 SOURCE_IP 时，为必填参数 */
        @JsonProperty("persistenceTimeout")
        private Integer persistenceTimeout;

        public String getSessionType() {
            return this.sessionType;
        }

        public void setSessionType(String sessionType) {
            this.sessionType = sessionType;
        }

        public String getCookieName() {
            return this.cookieName;
        }

        public void setCookieName(String cookieName) {
            this.cookieName = cookieName;
        }

        public Integer getPersistenceTimeout() {
            return this.persistenceTimeout;
        }

        public void setPersistenceTimeout(Integer persistenceTimeout) {
            this.persistenceTimeout = persistenceTimeout;
        }
    }

    public static class AsyncCreateListenerResponse {
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
        private AsyncCreateListenerReturnObjResponse returnObj;

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

        public AsyncCreateListenerReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(AsyncCreateListenerReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class AsyncCreateListenerReturnObjResponse {
        /** 创建进度: in_progress / done */
        @JsonProperty("status")
        private String status;

        /** 进度说明 */
        @JsonProperty("message")
        private String message;

        /** 监听器，可能为 null */
        @JsonProperty("listenerID")
        private String listenerID;

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

        public String getListenerID() {
            return this.listenerID;
        }

        public void setListenerID(String listenerID) {
            this.listenerID = listenerID;
        }
    }
}
