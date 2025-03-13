package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看后端服务列表 */
public class CtelbListVmApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListVmApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-vm", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListVmResponse send(Credential credential, ListVmRequest request)
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
        if (request.loadBalanceID != null) {
            ctReq.addParam("loadBalanceID", request.loadBalanceID);
        }
        if (request.queryContent != null) {
            ctReq.addParam("queryContent", request.queryContent);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListVmResponse.class);
    }

    public static class ListVmRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 负载均衡 ID */
        @JsonProperty("loadBalanceID")
        private String loadBalanceID;

        /** 模糊查询 */
        @JsonProperty("queryContent")
        private String queryContent;

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

        public String getLoadBalanceID() {
            return this.loadBalanceID;
        }

        public void setLoadBalanceID(String loadBalanceID) {
            this.loadBalanceID = loadBalanceID;
        }

        public String getQueryContent() {
            return this.queryContent;
        }

        public void setQueryContent(String queryContent) {
            this.queryContent = queryContent;
        }
    }

    public static class ListVmResponse {
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
        private List<ListVmReturnObjResponse> returnObj;

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

        public List<ListVmReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListVmReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ListVmReturnObjResponse {
        /** 后端服务ID */
        @JsonProperty("targetID")
        private String targetID;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** 实例类型 */
        @JsonProperty("instanceType")
        private String instanceType;

        /** 实例ID */
        @JsonProperty("instanceID")
        private String instanceID;

        /** 协议端口 */
        @JsonProperty("protocolPort")
        private Integer protocolPort;

        /** 权重 */
        @JsonProperty("weight")
        private Integer weight;

        /** IPv4的健康检查状态 */
        @JsonProperty("healthCheckStatus")
        private String healthCheckStatus;

        /** IPv6的健康检查状态 */
        @JsonProperty("healthCheckStatusIpv6")
        private String healthCheckStatusIpv6;

        /** 管理状态 */
        @JsonProperty("status")
        private String status;

        public String getTargetID() {
            return this.targetID;
        }

        public void setTargetID(String targetID) {
            this.targetID = targetID;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getInstanceType() {
            return this.instanceType;
        }

        public void setInstanceType(String instanceType) {
            this.instanceType = instanceType;
        }

        public String getInstanceID() {
            return this.instanceID;
        }

        public void setInstanceID(String instanceID) {
            this.instanceID = instanceID;
        }

        public Integer getProtocolPort() {
            return this.protocolPort;
        }

        public void setProtocolPort(Integer protocolPort) {
            this.protocolPort = protocolPort;
        }

        public Integer getWeight() {
            return this.weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getHealthCheckStatus() {
            return this.healthCheckStatus;
        }

        public void setHealthCheckStatus(String healthCheckStatus) {
            this.healthCheckStatus = healthCheckStatus;
        }

        public String getHealthCheckStatusIpv6() {
            return this.healthCheckStatusIpv6;
        }

        public void setHealthCheckStatusIpv6(String healthCheckStatusIpv6) {
            this.healthCheckStatusIpv6 = healthCheckStatusIpv6;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
