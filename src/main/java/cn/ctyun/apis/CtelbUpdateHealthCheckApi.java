package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 更新健康检查 */
public class CtelbUpdateHealthCheckApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbUpdateHealthCheckApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/update-health-check", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public UpdateHealthCheckResponse send(Credential credential, UpdateHealthCheckRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(UpdateHealthCheckResponse.class);
    }

    public static class UpdateHealthCheckRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID,公共参数不支持修改 */
        @JsonProperty("regionID")
        private String regionID;

        /** 健康检查ID, 后续废弃该字段 */
        @JsonProperty("ID")
        private String iD;

        /** 健康检查ID, 推荐使用该字段, 当同时使用 ID 和 healthCheckID 时，优先使用 healthCheckID */
        @JsonProperty("healthCheckID")
        private String healthCheckID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /**
         * 支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\|《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

        /** 健康检查响应的最大超时时间，取值范围：2-60秒，默认为2秒 */
        @JsonProperty("timeout")
        private Integer timeout;

        /** 最大重试次数，取值范围：1-10次，默认为2次 */
        @JsonProperty("maxRetry")
        private Integer maxRetry;

        /** 负载均衡进行健康检查的时间间隔，取值范围：1-20940秒，默认为5秒 */
        @JsonProperty("interval")
        private Integer interval;

        /**
         * HTTP请求的方法默认GET，{GET/HEAD/POST/PUT/DELETE/TRACE/OPTIONS/CONNECT/PATCH}（创建时仅当protocol为HTTP时必填且生效）
         */
        @JsonProperty("httpMethod")
        private String httpMethod;

        /** 创建时仅当protocol为HTTP时必填且生效,支持的最大字符长度：80 */
        @JsonProperty("httpUrlPath")
        private String httpUrlPath;

        /** 仅当protocol为HTTP时必填且生效,支持{http_2xx/http_3xx/http_4xx/http_5xx} */
        @JsonProperty("httpExpectedCodes")
        private List<String> httpExpectedCodes;

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

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getHealthCheckID() {
            return this.healthCheckID;
        }

        public void setHealthCheckID(String healthCheckID) {
            this.healthCheckID = healthCheckID;
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

        public Integer getTimeout() {
            return this.timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getMaxRetry() {
            return this.maxRetry;
        }

        public void setMaxRetry(Integer maxRetry) {
            this.maxRetry = maxRetry;
        }

        public Integer getInterval() {
            return this.interval;
        }

        public void setInterval(Integer interval) {
            this.interval = interval;
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

        public List<String> getHttpExpectedCodes() {
            return this.httpExpectedCodes;
        }

        public void setHttpExpectedCodes(List<String> httpExpectedCodes) {
            this.httpExpectedCodes = httpExpectedCodes;
        }
    }

    public static class UpdateHealthCheckResponse {
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
