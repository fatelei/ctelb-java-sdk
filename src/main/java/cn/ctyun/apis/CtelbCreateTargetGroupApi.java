package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建后端服务组 */
public class CtelbCreateTargetGroupApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbCreateTargetGroupApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/create-target-group", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public CreateTargetGroupResponse send(Credential credential, CreateTargetGroupRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(CreateTargetGroupResponse.class);
    }

    public static class CreateTargetGroupRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 支持 TCP / UDP / HTTP / HTTPS */
        @JsonProperty("protocol")
        private String protocol;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /** vpc ID */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 健康检查ID */
        @JsonProperty("healthCheckID")
        private String healthCheckID;

        /** 调度算法。取值范围：rr（轮询）、wrr（带权重轮询）、lc（最少连接）、sh（源IP哈希） */
        @JsonProperty("algorithm")
        private String algorithm;

        /** 会话保持配置 */
        @JsonProperty("sessionSticky")
        private CreateTargetGroupSessionStickyRequest sessionSticky;

        /** 1 开启，0 关闭 */
        @JsonProperty("proxyProtocol")
        private Integer proxyProtocol;

        public String getClientToken() {
            return this.clientToken;
        }

        public void setClientToken(String clientToken) {
            this.clientToken = clientToken;
        }

        public String getProtocol() {
            return this.protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
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

        public String getVpcID() {
            return this.vpcID;
        }

        public void setVpcID(String vpcID) {
            this.vpcID = vpcID;
        }

        public String getHealthCheckID() {
            return this.healthCheckID;
        }

        public void setHealthCheckID(String healthCheckID) {
            this.healthCheckID = healthCheckID;
        }

        public String getAlgorithm() {
            return this.algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public CreateTargetGroupSessionStickyRequest getSessionSticky() {
            return this.sessionSticky;
        }

        public void setSessionSticky(CreateTargetGroupSessionStickyRequest sessionSticky) {
            this.sessionSticky = sessionSticky;
        }

        public Integer getProxyProtocol() {
            return this.proxyProtocol;
        }

        public void setProxyProtocol(Integer proxyProtocol) {
            this.proxyProtocol = proxyProtocol;
        }
    }

    public static class CreateTargetGroupSessionStickyRequest {
        /**
         * 会话保持模式，支持取值：CLOSE（关闭）、INSERT（插入）、REWRITE（重写），当 algorithm 为 lc / sh 时，sessionStickyMode
         * 必须为 CLOSE
         */
        @JsonProperty("sessionStickyMode")
        private String sessionStickyMode;

        /** cookie过期时间。INSERT模式必填 */
        @JsonProperty("cookieExpire")
        private Integer cookieExpire;

        /** cookie重写名称，REWRITE模式必填 */
        @JsonProperty("rewriteCookieName")
        private String rewriteCookieName;

        /** 源IP会话保持超时时间。SOURCE_IP模式必填 */
        @JsonProperty("sourceIpTimeout")
        private Integer sourceIpTimeout;

        public String getSessionStickyMode() {
            return this.sessionStickyMode;
        }

        public void setSessionStickyMode(String sessionStickyMode) {
            this.sessionStickyMode = sessionStickyMode;
        }

        public Integer getCookieExpire() {
            return this.cookieExpire;
        }

        public void setCookieExpire(Integer cookieExpire) {
            this.cookieExpire = cookieExpire;
        }

        public String getRewriteCookieName() {
            return this.rewriteCookieName;
        }

        public void setRewriteCookieName(String rewriteCookieName) {
            this.rewriteCookieName = rewriteCookieName;
        }

        public Integer getSourceIpTimeout() {
            return this.sourceIpTimeout;
        }

        public void setSourceIpTimeout(Integer sourceIpTimeout) {
            this.sourceIpTimeout = sourceIpTimeout;
        }
    }

    public static class CreateTargetGroupResponse {
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
        private List<CreateTargetGroupReturnObjResponse> returnObj;

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

        public List<CreateTargetGroupReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<CreateTargetGroupReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class CreateTargetGroupReturnObjResponse {
        /** 后端服务组ID */
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
