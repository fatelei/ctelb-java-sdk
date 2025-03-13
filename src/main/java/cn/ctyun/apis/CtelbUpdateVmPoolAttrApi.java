package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 更新后端服务组 */
public class CtelbUpdateVmPoolAttrApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbUpdateVmPoolAttrApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/update-vm-pool", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public UpdateVmPoolAttrResponse send(Credential credential, UpdateVmPoolAttrRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(UpdateVmPoolAttrResponse.class);
    }

    public static class UpdateVmPoolAttrRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /** 当后端组已经有健康配置时，如果更新不传健康配置信息，表示移除当前后端组的健康检查配置 */
        @JsonProperty("healthCheck")
        private List<UpdateVmPoolAttrHealthCheckRequest> healthCheck;

        /** 当后端组已经有会话配置时，如果更新不传会话配置信息，表示移除当前后端组的会话配置 */
        @JsonProperty("sessionSticky")
        private List<UpdateVmPoolAttrSessionStickyRequest> sessionSticky;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getTargetGroupID() {
            return this.targetGroupID;
        }

        public void setTargetGroupID(String targetGroupID) {
            this.targetGroupID = targetGroupID;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<UpdateVmPoolAttrHealthCheckRequest> getHealthCheck() {
            return this.healthCheck;
        }

        public void setHealthCheck(List<UpdateVmPoolAttrHealthCheckRequest> healthCheck) {
            this.healthCheck = healthCheck;
        }

        public List<UpdateVmPoolAttrSessionStickyRequest> getSessionSticky() {
            return this.sessionSticky;
        }

        public void setSessionSticky(List<UpdateVmPoolAttrSessionStickyRequest> sessionSticky) {
            this.sessionSticky = sessionSticky;
        }
    }

    public static class UpdateVmPoolAttrHealthCheckRequest {
        /** 健康检查协议。取值范围：TCP、UDP、HTTP */
        @JsonProperty("protocol")
        private String protocol;

        /** 健康检查响应的最大超时时间，取值范围：2-60秒,默认2秒 */
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

    public static class UpdateVmPoolAttrSessionStickyRequest {
        /** cookie名称 */
        @JsonProperty("cookieName")
        private String cookieName;

        /** 会话过期时间，1-86400 */
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

    public static class UpdateVmPoolAttrResponse {
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
    }
}
