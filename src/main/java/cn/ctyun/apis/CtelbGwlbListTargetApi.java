package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看target列表 */
public class CtelbGwlbListTargetApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbListTargetApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/gwlb/list-target", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public GwlbListTargetResponse send(Credential credential, GwlbListTargetRequest request)
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
        if (request.targetID != null) {
            ctReq.addParam("targetID", request.targetID);
        }
        if (request.pageNumber != null) {
            ctReq.addParam("pageNumber", String.valueOf(request.pageNumber));
        }
        if (request.pageSize != null) {
            ctReq.addParam("pageSize", String.valueOf(request.pageSize));
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbListTargetResponse.class);
    }

    public static class GwlbListTargetRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 后端服务组 ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 后端服务 ID */
        @JsonProperty("targetID")
        private String targetID;

        /** 列表的页码，默认值为 1。 */
        @JsonProperty("pageNumber")
        private Integer pageNumber;

        /** 分页查询时每页的行数，最大值为 50，默认值为 10。 */
        @JsonProperty("pageSize")
        private Integer pageSize;

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

        public String getTargetID() {
            return this.targetID;
        }

        public void setTargetID(String targetID) {
            this.targetID = targetID;
        }

        public Integer getPageNumber() {
            return this.pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class GwlbListTargetResponse {
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
        private GwlbListTargetReturnObjResponse returnObj;

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

        public GwlbListTargetReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbListTargetReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbListTargetReturnObjResponse {
        /** 接口业务数据 */
        @JsonProperty("results")
        private List<GwlbListTargetReturnObjResultsResponse> results;

        /** 列表条目数 */
        @JsonProperty("totalCount")
        private Integer totalCount;

        /** 分页查询时每页的行数。 */
        @JsonProperty("currentCount")
        private Integer currentCount;

        /** 总页数 */
        @JsonProperty("totalPage")
        private Integer totalPage;

        public List<GwlbListTargetReturnObjResultsResponse> getResults() {
            return this.results;
        }

        public void setResults(List<GwlbListTargetReturnObjResultsResponse> results) {
            this.results = results;
        }

        public Integer getTotalCount() {
            return this.totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getCurrentCount() {
            return this.currentCount;
        }

        public void setCurrentCount(Integer currentCount) {
            this.currentCount = currentCount;
        }

        public Integer getTotalPage() {
            return this.totalPage;
        }

        public void setTotalPage(Integer totalPage) {
            this.totalPage = totalPage;
        }
    }

    public static class GwlbListTargetReturnObjResultsResponse {
        /** 后端服务ID */
        @JsonProperty("targetID")
        private String targetID;

        /** 后端服务组ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 实例类型，取值有: VM / BMS/ CBM */
        @JsonProperty("instanceType")
        private String instanceType;

        /** 实例 ID */
        @JsonProperty("instanceID")
        private String instanceID;

        /** 实例所在的 vpc */
        @JsonProperty("instanceVpc")
        private String instanceVpc;

        /** 权重 */
        @JsonProperty("weight")
        private Integer weight;

        /** ipv4 健康检查状态，取值: unknown / online / offline */
        @JsonProperty("healthCheckStatus")
        private String healthCheckStatus;

        /** ipv6 健康检查状态，取值: unknown / online / offline */
        @JsonProperty("healthCheckStatusIpv6")
        private String healthCheckStatusIpv6;

        /** 创建时间 */
        @JsonProperty("createdAt")
        private String createdAt;

        /** 更新时间 */
        @JsonProperty("updatedAt")
        private String updatedAt;

        public String getTargetID() {
            return this.targetID;
        }

        public void setTargetID(String targetID) {
            this.targetID = targetID;
        }

        public String getTargetGroupID() {
            return this.targetGroupID;
        }

        public void setTargetGroupID(String targetGroupID) {
            this.targetGroupID = targetGroupID;
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

        public String getInstanceVpc() {
            return this.instanceVpc;
        }

        public void setInstanceVpc(String instanceVpc) {
            this.instanceVpc = instanceVpc;
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

        public String getCreatedAt() {
            return this.createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return this.updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
