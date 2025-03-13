package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 获取转发规则列表 */
public class CtelbListQueryApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListQueryApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-rule", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListQueryResponse send(Credential credential, ListQueryRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.iDs != null) {
            ctReq.addParam("IDs", request.iDs);
        }
        if (request.loadBalancerID != null) {
            ctReq.addParam("loadBalancerID", request.loadBalancerID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListQueryResponse.class);
    }

    public static class ListQueryRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 转发规则ID列表，以,分隔 */
        @JsonProperty("IDs")
        private String iDs;

        /** 负载均衡实例ID */
        @JsonProperty("loadBalancerID")
        private String loadBalancerID;

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

        public String getLoadBalancerID() {
            return this.loadBalancerID;
        }

        public void setLoadBalancerID(String loadBalancerID) {
            this.loadBalancerID = loadBalancerID;
        }
    }

    public static class ListQueryResponse {
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
        private List<ListQueryReturnObjResponse> returnObj;

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

        public List<ListQueryReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListQueryReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ListQueryReturnObjResponse {
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
        private List<ListQueryReturnObjConditionsResponse> conditions;

        /** 规则目标 */
        @JsonProperty("action")
        private ListQueryReturnObjActionResponse action;

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

        public List<ListQueryReturnObjConditionsResponse> getConditions() {
            return this.conditions;
        }

        public void setConditions(List<ListQueryReturnObjConditionsResponse> conditions) {
            this.conditions = conditions;
        }

        public ListQueryReturnObjActionResponse getAction() {
            return this.action;
        }

        public void setAction(ListQueryReturnObjActionResponse action) {
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

    public static class ListQueryReturnObjConditionsResponse {
        /** 类型。取值范围：server_name（服务名称）、url_path（匹配路径） */
        @JsonProperty("type")
        private String type;

        /** 服务名称 */
        @JsonProperty("serverNameConfig")
        private ListQueryReturnObjConditionsServerNameConfigResponse serverNameConfig;

        /** 匹配路径 */
        @JsonProperty("urlPathConfig")
        private ListQueryReturnObjConditionsUrlPathConfigResponse urlPathConfig;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public ListQueryReturnObjConditionsServerNameConfigResponse getServerNameConfig() {
            return this.serverNameConfig;
        }

        public void setServerNameConfig(
                ListQueryReturnObjConditionsServerNameConfigResponse serverNameConfig) {
            this.serverNameConfig = serverNameConfig;
        }

        public ListQueryReturnObjConditionsUrlPathConfigResponse getUrlPathConfig() {
            return this.urlPathConfig;
        }

        public void setUrlPathConfig(
                ListQueryReturnObjConditionsUrlPathConfigResponse urlPathConfig) {
            this.urlPathConfig = urlPathConfig;
        }
    }

    public static class ListQueryReturnObjActionResponse {
        /** 默认规则动作类型 */
        @JsonProperty("type")
        private String type;

        /** 转发配置 */
        @JsonProperty("forwardConfig")
        private ListQueryReturnObjActionForwardConfigResponse forwardConfig;

        /** 重定向监听器ID */
        @JsonProperty("redirectListenerID")
        private String redirectListenerID;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public ListQueryReturnObjActionForwardConfigResponse getForwardConfig() {
            return this.forwardConfig;
        }

        public void setForwardConfig(ListQueryReturnObjActionForwardConfigResponse forwardConfig) {
            this.forwardConfig = forwardConfig;
        }

        public String getRedirectListenerID() {
            return this.redirectListenerID;
        }

        public void setRedirectListenerID(String redirectListenerID) {
            this.redirectListenerID = redirectListenerID;
        }
    }

    public static class ListQueryReturnObjConditionsServerNameConfigResponse {
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

    public static class ListQueryReturnObjConditionsUrlPathConfigResponse {
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

    public static class ListQueryReturnObjActionForwardConfigResponse {
        /** 后端服务组 */
        @JsonProperty("targetGroups")
        private List<ListQueryReturnObjActionForwardConfigTargetGroupsResponse> targetGroups;

        public List<ListQueryReturnObjActionForwardConfigTargetGroupsResponse> getTargetGroups() {
            return this.targetGroups;
        }

        public void setTargetGroups(
                List<ListQueryReturnObjActionForwardConfigTargetGroupsResponse> targetGroups) {
            this.targetGroups = targetGroups;
        }
    }

    public static class ListQueryReturnObjActionForwardConfigTargetGroupsResponse {
        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 权重 */
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
}
