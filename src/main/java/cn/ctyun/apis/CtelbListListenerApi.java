package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看监听器列表 */
public class CtelbListListenerApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListListenerApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-listener", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListListenerResponse send(Credential credential, ListListenerRequest request)
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
        if (request.projectID != null) {
            ctReq.addParam("projectID", request.projectID);
        }
        if (request.iDs != null) {
            ctReq.addParam("IDs", request.iDs);
        }
        if (request.name != null) {
            ctReq.addParam("name", request.name);
        }
        if (request.loadBalancerID != null) {
            ctReq.addParam("loadBalancerID", request.loadBalancerID);
        }
        if (request.accessControlID != null) {
            ctReq.addParam("accessControlID", request.accessControlID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListListenerResponse.class);
    }

    public static class ListListenerRequest {
        /** 客户端存根，用于保证订单幂等性。要求单个云平台账户内唯一, 公共参数不支持修改, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 企业项目ID，默认为'0' */
        @JsonProperty("projectID")
        private String projectID;

        /** 监听器ID列表，以','分隔 */
        @JsonProperty("IDs")
        private String iDs;

        /** 监听器名称 */
        @JsonProperty("name")
        private String name;

        /** 负载均衡实例ID */
        @JsonProperty("loadBalancerID")
        private String loadBalancerID;

        /** 访问控制ID */
        @JsonProperty("accessControlID")
        private String accessControlID;

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

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getIDs() {
            return this.iDs;
        }

        public void setIDs(String iDs) {
            this.iDs = iDs;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLoadBalancerID() {
            return this.loadBalancerID;
        }

        public void setLoadBalancerID(String loadBalancerID) {
            this.loadBalancerID = loadBalancerID;
        }

        public String getAccessControlID() {
            return this.accessControlID;
        }

        public void setAccessControlID(String accessControlID) {
            this.accessControlID = accessControlID;
        }
    }

    public static class ListListenerResponse {
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
        private List<ListListenerReturnObjResponse> returnObj;

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

        public List<ListListenerReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListListenerReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ListListenerReturnObjResponse {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 可用区名称 */
        @JsonProperty("azName")
        private String azName;

        /** 项目ID */
        @JsonProperty("projectID")
        private String projectID;

        /** 监听器ID */
        @JsonProperty("ID")
        private String iD;

        /** 监听器名称 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** 负载均衡实例ID */
        @JsonProperty("loadBalancerID")
        private String loadBalancerID;

        /** 监听协议: TCP / UDP / HTTP / HTTPS */
        @JsonProperty("protocol")
        private String protocol;

        /** 监听端口 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

        /** 证书ID */
        @JsonProperty("certificateID")
        private String certificateID;

        /** 是否开启双向认证 */
        @JsonProperty("caEnabled")
        private Boolean caEnabled;

        /** 双向认证的证书ID */
        @JsonProperty("clientCertificateID")
        private String clientCertificateID;

        /** 默认规则动作 */
        @JsonProperty("defaultAction")
        private List<ListListenerReturnObjDefaultActionResponse> defaultAction;

        /** 访问控制ID */
        @JsonProperty("accessControlID")
        private String accessControlID;

        /** 访问控制类型: Close / White / Black */
        @JsonProperty("accessControlType")
        private String accessControlType;

        /** 是否开启x forward for功能 */
        @JsonProperty("forwardedForEnabled")
        private Boolean forwardedForEnabled;

        /** 监听器状态: DOWN / ACTIVE */
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

        public String getLoadBalancerID() {
            return this.loadBalancerID;
        }

        public void setLoadBalancerID(String loadBalancerID) {
            this.loadBalancerID = loadBalancerID;
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

        public String getCertificateID() {
            return this.certificateID;
        }

        public void setCertificateID(String certificateID) {
            this.certificateID = certificateID;
        }

        public Boolean getCaEnabled() {
            return this.caEnabled;
        }

        public void setCaEnabled(Boolean caEnabled) {
            this.caEnabled = caEnabled;
        }

        public String getClientCertificateID() {
            return this.clientCertificateID;
        }

        public void setClientCertificateID(String clientCertificateID) {
            this.clientCertificateID = clientCertificateID;
        }

        public List<ListListenerReturnObjDefaultActionResponse> getDefaultAction() {
            return this.defaultAction;
        }

        public void setDefaultAction(
                List<ListListenerReturnObjDefaultActionResponse> defaultAction) {
            this.defaultAction = defaultAction;
        }

        public String getAccessControlID() {
            return this.accessControlID;
        }

        public void setAccessControlID(String accessControlID) {
            this.accessControlID = accessControlID;
        }

        public String getAccessControlType() {
            return this.accessControlType;
        }

        public void setAccessControlType(String accessControlType) {
            this.accessControlType = accessControlType;
        }

        public Boolean getForwardedForEnabled() {
            return this.forwardedForEnabled;
        }

        public void setForwardedForEnabled(Boolean forwardedForEnabled) {
            this.forwardedForEnabled = forwardedForEnabled;
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

    public static class ListListenerReturnObjDefaultActionResponse {
        /** 默认规则动作类型: forward / redirect */
        @JsonProperty("type")
        private String type;

        /** 转发配置 */
        @JsonProperty("forwardConfig")
        private List<ListListenerReturnObjDefaultActionForwardConfigResponse> forwardConfig;

        /** 重定向监听器ID */
        @JsonProperty("redirectListenerID")
        private String redirectListenerID;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ListListenerReturnObjDefaultActionForwardConfigResponse> getForwardConfig() {
            return this.forwardConfig;
        }

        public void setForwardConfig(
                List<ListListenerReturnObjDefaultActionForwardConfigResponse> forwardConfig) {
            this.forwardConfig = forwardConfig;
        }

        public String getRedirectListenerID() {
            return this.redirectListenerID;
        }

        public void setRedirectListenerID(String redirectListenerID) {
            this.redirectListenerID = redirectListenerID;
        }
    }

    public static class ListListenerReturnObjDefaultActionForwardConfigResponse {
        /** 后端服务组 */
        @JsonProperty("targetGroups")
        private List<ListListenerReturnObjDefaultActionForwardConfigTargetGroupsResponse>
                targetGroups;

        public List<ListListenerReturnObjDefaultActionForwardConfigTargetGroupsResponse>
                getTargetGroups() {
            return this.targetGroups;
        }

        public void setTargetGroups(
                List<ListListenerReturnObjDefaultActionForwardConfigTargetGroupsResponse>
                        targetGroups) {
            this.targetGroups = targetGroups;
        }
    }

    public static class ListListenerReturnObjDefaultActionForwardConfigTargetGroupsResponse {
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
