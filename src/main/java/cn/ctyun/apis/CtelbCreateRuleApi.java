package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 创建转发规则 */
public class CtelbCreateRuleApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbCreateRuleApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/create-rule", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public CreateRuleResponse send(Credential credential, CreateRuleRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(CreateRuleResponse.class);
    }

    public static class CreateRuleRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器ID */
        @JsonProperty("listenerID")
        private String listenerID;

        /** 优先级，数字越小优先级越高，取值范围为：1-100(目前不支持配置此参数,只取默认值100) */
        @JsonProperty("priority")
        private Integer priority;

        /** 匹配规则数据 */
        @JsonProperty("conditions")
        private List<CreateRuleConditionsRequest> conditions;

        /** 规则目标 */
        @JsonProperty("action")
        private CreateRuleActionRequest action;

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

        public Integer getPriority() {
            return this.priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public List<CreateRuleConditionsRequest> getConditions() {
            return this.conditions;
        }

        public void setConditions(List<CreateRuleConditionsRequest> conditions) {
            this.conditions = conditions;
        }

        public CreateRuleActionRequest getAction() {
            return this.action;
        }

        public void setAction(CreateRuleActionRequest action) {
            this.action = action;
        }
    }

    public static class CreateRuleConditionsRequest {
        /** 类型。取值范围：server_name（服务名称）、url_path（匹配路径） */
        @JsonProperty("type")
        private String type;

        /** 服务名称 */
        @JsonProperty("serverNameConfig")
        private CreateRuleConditionsServerNameConfigRequest serverNameConfig;

        /** 匹配路径 */
        @JsonProperty("urlPathConfig")
        private CreateRuleConditionsUrlPathConfigRequest urlPathConfig;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public CreateRuleConditionsServerNameConfigRequest getServerNameConfig() {
            return this.serverNameConfig;
        }

        public void setServerNameConfig(
                CreateRuleConditionsServerNameConfigRequest serverNameConfig) {
            this.serverNameConfig = serverNameConfig;
        }

        public CreateRuleConditionsUrlPathConfigRequest getUrlPathConfig() {
            return this.urlPathConfig;
        }

        public void setUrlPathConfig(CreateRuleConditionsUrlPathConfigRequest urlPathConfig) {
            this.urlPathConfig = urlPathConfig;
        }
    }

    public static class CreateRuleActionRequest {
        /** 默认规则动作类型。取值范围：forward、redirect、deny(目前暂不支持配置为deny) */
        @JsonProperty("type")
        private String type;

        /** 转发配置 */
        @JsonProperty("forwardConfig")
        private CreateRuleActionForwardConfigRequest forwardConfig;

        /** 重定向监听器ID，当type为redirect时，此字段必填 */
        @JsonProperty("redirectListenerID")
        private String redirectListenerID;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public CreateRuleActionForwardConfigRequest getForwardConfig() {
            return this.forwardConfig;
        }

        public void setForwardConfig(CreateRuleActionForwardConfigRequest forwardConfig) {
            this.forwardConfig = forwardConfig;
        }

        public String getRedirectListenerID() {
            return this.redirectListenerID;
        }

        public void setRedirectListenerID(String redirectListenerID) {
            this.redirectListenerID = redirectListenerID;
        }
    }

    public static class CreateRuleConditionsServerNameConfigRequest {
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

    public static class CreateRuleConditionsUrlPathConfigRequest {
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

    public static class CreateRuleActionForwardConfigRequest {
        /** 后端服务组 */
        @JsonProperty("targetGroups")
        private List<CreateRuleActionForwardConfigTargetGroupsRequest> targetGroups;

        public List<CreateRuleActionForwardConfigTargetGroupsRequest> getTargetGroups() {
            return this.targetGroups;
        }

        public void setTargetGroups(
                List<CreateRuleActionForwardConfigTargetGroupsRequest> targetGroups) {
            this.targetGroups = targetGroups;
        }
    }

    public static class CreateRuleActionForwardConfigTargetGroupsRequest {
        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 权重，取值范围：1-256。默认为100 */
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

    public static class CreateRuleResponse {
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
        private List<CreateRuleReturnObjResponse> returnObj;

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

        public List<CreateRuleReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<CreateRuleReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class CreateRuleReturnObjResponse {
        /** 转发规则 ID */
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
