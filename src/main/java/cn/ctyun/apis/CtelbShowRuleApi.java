package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 获取转发规则详情 */
public class CtelbShowRuleApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbShowRuleApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/show-rule", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ShowRuleResponse send(Credential credential, ShowRuleRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.iD != null) {
            ctReq.addParam("ID", request.iD);
        }
        if (request.policyID != null) {
            ctReq.addParam("policyID", request.policyID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ShowRuleResponse.class);
    }

    public static class ShowRuleRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 转发规则ID, 该字段后续废弃 */
        @JsonProperty("ID")
        private String iD;

        /** 转发规则ID, 推荐使用该字段, 当同时使用 ID 和 policyID 时，优先使用 policyID */
        @JsonProperty("policyID")
        private String policyID;

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

        public String getPolicyID() {
            return this.policyID;
        }

        public void setPolicyID(String policyID) {
            this.policyID = policyID;
        }
    }

    public static class ShowRuleResponse {
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
        private ShowRuleReturnObjResponse returnObj;

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

        public ShowRuleReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(ShowRuleReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ShowRuleReturnObjResponse {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 可用区名称 */
        @JsonProperty("azName")
        private String azName;

        /** 项目ID */
        @JsonProperty("projectID")
        private String projectID;

        /** 转发规则ID */
        @JsonProperty("ID")
        private String iD;

        /** 负载均衡ID */
        @JsonProperty("loadBalancerID")
        private String loadBalancerID;

        /** 监听器ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** 匹配规则数据 */
        @JsonProperty("conditions")
        private List<ShowRuleReturnObjConditionsResponse> conditions;

        /** 规则目标 */
        @JsonProperty("action")
        private ShowRuleReturnObjActionResponse action;

        /** 状态: ACTIVE / DOWN */
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

        public String getLoadBalancerID() {
            return this.loadBalancerID;
        }

        public void setLoadBalancerID(String loadBalancerID) {
            this.loadBalancerID = loadBalancerID;
        }

        public String getListenerID() {
            return this.listenerID;
        }

        public void setListenerID(String listenerID) {
            this.listenerID = listenerID;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<ShowRuleReturnObjConditionsResponse> getConditions() {
            return this.conditions;
        }

        public void setConditions(List<ShowRuleReturnObjConditionsResponse> conditions) {
            this.conditions = conditions;
        }

        public ShowRuleReturnObjActionResponse getAction() {
            return this.action;
        }

        public void setAction(ShowRuleReturnObjActionResponse action) {
            this.action = action;
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

    public static class ShowRuleReturnObjConditionsResponse {
        /** 类型。取值范围：server_name（服务名称）、url_path（匹配路径） */
        @JsonProperty("type")
        private String type;

        /** 服务名称 */
        @JsonProperty("serverNameConfig")
        private ShowRuleReturnObjConditionsServerNameConfigResponse serverNameConfig;

        /** 匹配路径 */
        @JsonProperty("urlPathConfig")
        private ShowRuleReturnObjConditionsUrlPathConfigResponse urlPathConfig;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public ShowRuleReturnObjConditionsServerNameConfigResponse getServerNameConfig() {
            return this.serverNameConfig;
        }

        public void setServerNameConfig(
                ShowRuleReturnObjConditionsServerNameConfigResponse serverNameConfig) {
            this.serverNameConfig = serverNameConfig;
        }

        public ShowRuleReturnObjConditionsUrlPathConfigResponse getUrlPathConfig() {
            return this.urlPathConfig;
        }

        public void setUrlPathConfig(
                ShowRuleReturnObjConditionsUrlPathConfigResponse urlPathConfig) {
            this.urlPathConfig = urlPathConfig;
        }
    }

    public static class ShowRuleReturnObjActionResponse {
        /** 默认规则动作类型: forward / redirect */
        @JsonProperty("type")
        private String type;

        /** 转发配置 */
        @JsonProperty("forwardConfig")
        private ShowRuleReturnObjActionForwardConfigResponse forwardConfig;

        /** 重定向监听器ID */
        @JsonProperty("redirectListenerID")
        private String redirectListenerID;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public ShowRuleReturnObjActionForwardConfigResponse getForwardConfig() {
            return this.forwardConfig;
        }

        public void setForwardConfig(ShowRuleReturnObjActionForwardConfigResponse forwardConfig) {
            this.forwardConfig = forwardConfig;
        }

        public String getRedirectListenerID() {
            return this.redirectListenerID;
        }

        public void setRedirectListenerID(String redirectListenerID) {
            this.redirectListenerID = redirectListenerID;
        }
    }

    public static class ShowRuleReturnObjConditionsServerNameConfigResponse {
        /** 服务名称 */
        @JsonProperty("serverName")
        private String serverName;

        public String getServerName() {
            return this.serverName;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }
    }

    public static class ShowRuleReturnObjConditionsUrlPathConfigResponse {
        /** 匹配路径 */
        @JsonProperty("urlPaths")
        private String urlPaths;

        /** 匹配类型。取值范围：ABSOLUTE，PREFIX，REG */
        @JsonProperty("matchType")
        private String matchType;

        public String getUrlPaths() {
            return this.urlPaths;
        }

        public void setUrlPaths(String urlPaths) {
            this.urlPaths = urlPaths;
        }

        public String getMatchType() {
            return this.matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }
    }

    public static class ShowRuleReturnObjActionForwardConfigResponse {}
}
