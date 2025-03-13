package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 获取健康检查列表 */
public class CtelbListHealthCheckApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListHealthCheckApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-health-check", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListHealthCheckResponse send(Credential credential, ListHealthCheckRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.clientToken != null) {
            ctReq.addParam("clientToken", request.clientToken);
        }
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        for (String ele0 : request.iDs) {
            if (ele0 != null) {
                ctReq.addParam("IDs", ele0);
            }
        }
        if (request.name != null) {
            ctReq.addParam("name", request.name);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListHealthCheckResponse.class);
    }

    public static class ListHealthCheckRequest {
        /** 客户端存根，用于保证订单幂等性。要求单个云平台账户内唯一 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 健康检查ID列表 */
        @JsonProperty("IDs")
        private List<String> iDs;

        /** 健康检查名称, 只能由数字，字母，-组成不能以数字和-开头，最大长度32 */
        @JsonProperty("name")
        private String name;

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

        public List<String> getIDs() {
            return this.iDs;
        }

        public void setIDs(List<String> iDs) {
            this.iDs = iDs;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ListHealthCheckResponse {
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
        private List<ListHealthCheckReturnObjResponse> returnObj;

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

        public List<ListHealthCheckReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListHealthCheckReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ListHealthCheckReturnObjResponse {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 可用区名称 */
        @JsonProperty("azName")
        private String azName;

        /** 项目ID */
        @JsonProperty("projectID")
        private String projectID;

        /** 健康检查ID */
        @JsonProperty("ID")
        private String iD;

        /** 健康检查名称 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** 健康检查协议: TCP / UDP / HTTP */
        @JsonProperty("protocol")
        private String protocol;

        /** 健康检查端口 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

        /** 健康检查响应的最大超时时间 */
        @JsonProperty("timeout")
        private Integer timeout;

        /** 负载均衡进行健康检查的时间间隔 */
        @JsonProperty("Integererval")
        private Integer integererval;

        /** 最大重试次数 */
        @JsonProperty("maxRetry")
        private Integer maxRetry;

        /** HTTP请求的方法 */
        @JsonProperty("httpMethod")
        private String httpMethod;

        /** HTTP请求url路径 */
        @JsonProperty("httpUrlPath")
        private String httpUrlPath;

        /** HTTP预期码 */
        @JsonProperty("httpExpectedCodes")
        private String httpExpectedCodes;

        /** 状态 1 表示 UP, 0 表示 DOWN */
        @JsonProperty("status")
        private Integer status;

        /** 创建时间，为UTC格式 */
        @JsonProperty("createTime")
        private String createTime;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getAzName() {
            return this.azName;
        }

        public void setAzName(String azName) {
            this.azName = azName;
        }

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
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

        public Integer getTimeout() {
            return this.timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getIntegererval() {
            return this.integererval;
        }

        public void setIntegererval(Integer integererval) {
            this.integererval = integererval;
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

        public Integer getStatus() {
            return this.status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
