package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建健康检查 */
public class CtelbCreateHealthCheckApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbCreateHealthCheckApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/create-health-check", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public CreateHealthCheckResponse send(Credential credential, CreateHealthCheckRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(CreateHealthCheckResponse.class);
    }

    public static class CreateHealthCheckRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /**
         * 支持拉丁字母、中文、数字, 特殊字符：~!@#$%^&*()_-+= <>?:{},./;'[]·~！@#￥%……&*（） ——
         * -+={}\|《》？：“”【】、；‘'，。、，不能以 http: / https: 开头，长度 0 - 128
         */
        @JsonProperty("description")
        private String description;

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

        /**
         * 仅当protocol为HTTP时必填且生效,HTTP请求的方法默认GET，{GET/HEAD/POST/PUT/DELETE/TRACE/OPTIONS/CONNECT/PATCH}
         */
        @JsonProperty("httpMethod")
        private String httpMethod;

        /** 仅当protocol为HTTP时必填且生效,默认为'/',支持的最大字符长度：80 */
        @JsonProperty("httpUrlPath")
        private String httpUrlPath;

        /**
         * 仅当protocol为HTTP时必填且生效,支持http_2xx/http_3xx/http_4xx/http_5xx，一个或者多个的列表, 当 protocol 为 HTTP
         * 时, 不填默认为 http_2xx
         */
        @JsonProperty("httpExpectedCodes")
        private List<String> httpExpectedCodes;

        /** 健康检查端口 1 - 65535 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

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

        public List<String> getHttpExpectedCodes() {
            return this.httpExpectedCodes;
        }

        public void setHttpExpectedCodes(List<String> httpExpectedCodes) {
            this.httpExpectedCodes = httpExpectedCodes;
        }

        public Integer getProtocolPort() {
            return this.protocolPort;
        }

        public void setProtocolPort(Integer protocolPort) {
            this.protocolPort = protocolPort;
        }
    }

    public static class CreateHealthCheckResponse {
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
        private List<CreateHealthCheckReturnObjResponse> returnObj;

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

        public List<CreateHealthCheckReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<CreateHealthCheckReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class CreateHealthCheckReturnObjResponse {
        /** 健康检查ID */
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
