package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看后端服务组列表 */
public class CtelbListTargetGroupApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListTargetGroupApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-target-group", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListTargetGroupResponse send(Credential credential, ListTargetGroupRequest request)
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
        if (request.iDs != null) {
            ctReq.addParam("IDs", request.iDs);
        }
        if (request.vpcID != null) {
            ctReq.addParam("vpcID", request.vpcID);
        }
        if (request.healthCheckID != null) {
            ctReq.addParam("healthCheckID", request.healthCheckID);
        }
        if (request.name != null) {
            ctReq.addParam("name", request.name);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListTargetGroupResponse.class);
    }

    public static class ListTargetGroupRequest {
        /** 客户端存根，用于保证订单幂等性。要求单个云平台账户内唯一 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 后端服务组ID列表，以,分隔 */
        @JsonProperty("IDs")
        private String iDs;

        /** vpc ID */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 健康检查ID */
        @JsonProperty("healthCheckID")
        private String healthCheckID;

        /** 后端服务组名称 */
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

        public String getIDs() {
            return this.iDs;
        }

        public void setIDs(String iDs) {
            this.iDs = iDs;
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

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ListTargetGroupResponse {
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
        private List<ListTargetGroupReturnObjResponse> returnObj;

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

        public List<ListTargetGroupReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListTargetGroupReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class ListTargetGroupReturnObjResponse {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 可用区名称 */
        @JsonProperty("azName")
        private String azName;

        /** 项目ID */
        @JsonProperty("projectID")
        private String projectID;

        /** 后端服务组ID */
        @JsonProperty("ID")
        private String iD;

        /** 后端服务组名称 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** vpc ID */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 健康检查ID */
        @JsonProperty("healthCheckID")
        private String healthCheckID;

        /** 调度算法 */
        @JsonProperty("algorithm")
        private String algorithm;

        /** 会话保持配置 */
        @JsonProperty("sessionSticky")
        private List<ListTargetGroupReturnObjSessionStickyResponse> sessionSticky;

        /** 状态: DOWN / ACTIVE */
        @JsonProperty("status")
        private String status;

        /** 创建时间，为UTC格式 */
        @JsonProperty("createdTime")
        private String createdTime;

        /** 更新时间，为UTC格式 */
        @JsonProperty("updatedTime")
        private String updatedTime;

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

        public List<ListTargetGroupReturnObjSessionStickyResponse> getSessionSticky() {
            return this.sessionSticky;
        }

        public void setSessionSticky(
                List<ListTargetGroupReturnObjSessionStickyResponse> sessionSticky) {
            this.sessionSticky = sessionSticky;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedTime() {
            return this.createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getUpdatedTime() {
            return this.updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }
    }

    public static class ListTargetGroupReturnObjSessionStickyResponse {
        /** 会话保持模式，支持取值：CLOSE（关闭）、INSERT（插入）、REWRITE（重写 */
        @JsonProperty("sessionStickyMode")
        private String sessionStickyMode;

        /** cookie过期时间 */
        @JsonProperty("cookieExpire")
        private Integer cookieExpire;

        /** cookie重写名称 */
        @JsonProperty("rewriteCookieName")
        private String rewriteCookieName;

        /** 源IP会话保持超时时间。 */
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
}
