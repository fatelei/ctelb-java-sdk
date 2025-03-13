package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 查看target_group详情 */
public class CtelbGwlbShowTargetGroupApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbShowTargetGroupApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/gwlb/show-target-group", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public GwlbShowTargetGroupResponse send(
            Credential credential, GwlbShowTargetGroupRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.targetGroupID != null) {
            ctReq.addParam("targetGroupID", request.targetGroupID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbShowTargetGroupResponse.class);
    }

    public static class GwlbShowTargetGroupRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 后端服务组 ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

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
    }

    public static class GwlbShowTargetGroupResponse {
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
        private GwlbShowTargetGroupReturnObjResponse returnObj;

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

        public GwlbShowTargetGroupReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbShowTargetGroupReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbShowTargetGroupReturnObjResponse {
        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 名称 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** vpc id */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 健康检查 ID */
        @JsonProperty("healthCheckID")
        private String healthCheckID;

        /** 故障转移类型 */
        @JsonProperty("failoverType")
        private Integer failoverType;

        /** 旁路类型 */
        @JsonProperty("bypassType")
        private Integer bypassType;

        /** 流保持类型,0:五元组, 4:二元组, 5:三元组 */
        @JsonProperty("sessionStickyMode")
        private Integer sessionStickyMode;

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

        public Integer getFailoverType() {
            return this.failoverType;
        }

        public void setFailoverType(Integer failoverType) {
            this.failoverType = failoverType;
        }

        public Integer getBypassType() {
            return this.bypassType;
        }

        public void setBypassType(Integer bypassType) {
            this.bypassType = bypassType;
        }

        public Integer getSessionStickyMode() {
            return this.sessionStickyMode;
        }

        public void setSessionStickyMode(Integer sessionStickyMode) {
            this.sessionStickyMode = sessionStickyMode;
        }
    }
}
