package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建转发规则 */
public class CtelbAsyncCreatePolicyApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbAsyncCreatePolicyApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/async-create-policy", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public AsyncCreatePolicyResponse send(Credential credential, AsyncCreatePolicyRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(AsyncCreatePolicyResponse.class);
    }

    public static class AsyncCreatePolicyRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /** 支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /**
         * 支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\|《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

        /** 匹配规则数据 */
        @JsonProperty("conditions")
        private List<AsyncCreatePolicyConditionsRequest> conditions;

        /** 后端服务组 */
        @JsonProperty("targetGroup")
        private AsyncCreatePolicyTargetGroupRequest targetGroup;

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

        public List<AsyncCreatePolicyConditionsRequest> getConditions() {
            return this.conditions;
        }

        public void setConditions(List<AsyncCreatePolicyConditionsRequest> conditions) {
            this.conditions = conditions;
        }

        public AsyncCreatePolicyTargetGroupRequest getTargetGroup() {
            return this.targetGroup;
        }

        public void setTargetGroup(AsyncCreatePolicyTargetGroupRequest targetGroup) {
            this.targetGroup = targetGroup;
        }
    }

    public static class AsyncCreatePolicyConditionsRequest {
        /** 规则类型，支持 HOST（按照域名）、PATH（请求路径） */
        @JsonProperty("ruleType")
        private String ruleType;

        /** 匹配类型，支持 STARTS_WITH（前缀匹配）、EQUAL_TO（精确匹配）、REGEX（正则匹配） */
        @JsonProperty("matchType")
        private String matchType;

        /** 被匹配的值，如果 ruleType 为 PATH，不能用 / 进行匹配 */
        @JsonProperty("matchValue")
        private String matchValue;

        public String getRuleType() {
            return this.ruleType;
        }

        public void setRuleType(String ruleType) {
            this.ruleType = ruleType;
        }

        public String getMatchType() {
            return this.matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getMatchValue() {
            return this.matchValue;
        }

        public void setMatchValue(String matchValue) {
            this.matchValue = matchValue;
        }
    }

    public static class AsyncCreatePolicyTargetGroupRequest {
        /** 后端服务组名字 */
        @JsonProperty("name")
        private String name;

        /** 负载均衡算法，支持: rr (轮询), lc (最少链接) */
        @JsonProperty("algorithm")
        private String algorithm;

        /** 后端服务 */
        @JsonProperty("targets")
        private List<AsyncCreatePolicyTargetGroupTargetsRequest> targets;

        /** 健康检查配置 */
        @JsonProperty("healthCheck")
        private AsyncCreatePolicyTargetGroupHealthCheckRequest healthCheck;

        /** 会话保持 */
        @JsonProperty("sessionSticky")
        private AsyncCreatePolicyTargetGroupSessionStickyRequest sessionSticky;

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

        public List<AsyncCreatePolicyTargetGroupTargetsRequest> getTargets() {
            return this.targets;
        }

        public void setTargets(List<AsyncCreatePolicyTargetGroupTargetsRequest> targets) {
            this.targets = targets;
        }

        public AsyncCreatePolicyTargetGroupHealthCheckRequest getHealthCheck() {
            return this.healthCheck;
        }

        public void setHealthCheck(AsyncCreatePolicyTargetGroupHealthCheckRequest healthCheck) {
            this.healthCheck = healthCheck;
        }

        public AsyncCreatePolicyTargetGroupSessionStickyRequest getSessionSticky() {
            return this.sessionSticky;
        }

        public void setSessionSticky(
                AsyncCreatePolicyTargetGroupSessionStickyRequest sessionSticky) {
            this.sessionSticky = sessionSticky;
        }
    }

    public static class AsyncCreatePolicyTargetGroupTargetsRequest {
        /** 后端服务主机 id */
        @JsonProperty("instanceID")
        private String instanceID;

        /** 后端服务监听端口 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

        /** 后端服务主机类型，目前支持 vm */
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

    public static class AsyncCreatePolicyTargetGroupHealthCheckRequest {
        /** 健康检查协议。取值范围：TCP、UDP、HTTP */
        @JsonProperty("protocol")
        private String protocol;

        /** 健康检查响应的最大超时时间，取值范围：2-60秒,默认为2秒 */
        @JsonProperty("timeout")
        private Integer timeout;

        /** 负载均衡进行健康检查的时间间隔，取值范围：1-20940秒，默认5秒 */
        @JsonProperty("interval")
        private Integer interval;

        /** 最大重试次数，取值范围：1-10次，默认2次 */
        @JsonProperty("maxRetry")
        private Integer maxRetry;

        /** 仅当protocol为HTTP时必填且生效,HTTP请求的方法默认GET，{GET/HEAD} */
        @JsonProperty("httpMethod")
        private String httpMethod;

        /** 仅当protocol为HTTP时必填且生效,支持的最大字符长度：80 */
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

    public static class AsyncCreatePolicyTargetGroupSessionStickyRequest {
        /** cookie名称，当 sessionType 为 APP_COOKIE 时，为必填参数 */
        @JsonProperty("cookieName")
        private String cookieName;

        /** 会话过期时间，当 sessionType 为 APP_COOKIE 或 SOURCE_IP 时，为必填参数 */
        @JsonProperty("persistenceTimeout")
        private Integer persistenceTimeout;

        /** 会话保持类型。取值范围：APP_COOKIE、HTTP_COOKIE、SOURCE_IP */
        @JsonProperty("sessionType")
        private String sessionType;

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

        public String getSessionType() {
            return this.sessionType;
        }

        public void setSessionType(String sessionType) {
            this.sessionType = sessionType;
        }
    }

    public static class AsyncCreatePolicyResponse {
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
        private AsyncCreatePolicyReturnObjResponse returnObj;

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

        public AsyncCreatePolicyReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(AsyncCreatePolicyReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class AsyncCreatePolicyReturnObjResponse {
        /** 创建进度: in_progress / done */
        @JsonProperty("status")
        private String status;

        /** 进度说明 */
        @JsonProperty("message")
        private String message;

        /** 转发策略 ID，可能为 null */
        @JsonProperty("policyID")
        private String policyID;

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

        public String getPolicyID() {
            return this.policyID;
        }

        public void setPolicyID(String policyID) {
            this.policyID = policyID;
        }
    }
}
