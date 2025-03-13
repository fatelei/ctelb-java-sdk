package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看负载均衡历史监控。 */
public class CtelbNewQueryElbHistoryMonitorApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbNewQueryElbHistoryMonitorApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/elb/new-query-history-monitor",
                        "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public NewQueryElbHistoryMonitorResponse send(
            Credential credential, NewQueryElbHistoryMonitorRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(NewQueryElbHistoryMonitorResponse.class);
    }

    public static class NewQueryElbHistoryMonitorRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡 ID 列表 */
        @JsonProperty("deviceIDs")
        private List<String> deviceIDs;

        /** 监控指标 */
        @JsonProperty("metricNames")
        private List<String> metricNames;

        /** 开始时间，YYYY-mmm-dd HH:MM:SS（只允许dd和HH中间有一个空格） */
        @JsonProperty("startTime")
        private String startTime;

        /** 开始时间，YYYY-mmm-dd HH:MM:SS（只允许dd和HH中间有一个空格） */
        @JsonProperty("endTime")
        private String endTime;

        /** 可选参数，聚合周期，单位：秒，默认60，例14400 */
        @JsonProperty("period")
        private Integer period;

        /** 列表的页码，默认值为 1 */
        @JsonProperty("pageNumber")
        private Integer pageNumber;

        /** 列表的页码，默认值为 1, 推荐使用该字段, pageNumber 后续会废弃 */
        @JsonProperty("pageNo")
        private Integer pageNo;

        /** 每页数据量大小，取值 1-50 */
        @JsonProperty("pageSize")
        private Integer pageSize;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public List<String> getDeviceIDs() {
            return this.deviceIDs;
        }

        public void setDeviceIDs(List<String> deviceIDs) {
            this.deviceIDs = deviceIDs;
        }

        public List<String> getMetricNames() {
            return this.metricNames;
        }

        public void setMetricNames(List<String> metricNames) {
            this.metricNames = metricNames;
        }

        public String getStartTime() {
            return this.startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return this.endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public Integer getPeriod() {
            return this.period;
        }

        public void setPeriod(Integer period) {
            this.period = period;
        }

        public Integer getPageNumber() {
            return this.pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public Integer getPageNo() {
            return this.pageNo;
        }

        public void setPageNo(Integer pageNo) {
            this.pageNo = pageNo;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class NewQueryElbHistoryMonitorResponse {
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
        private NewQueryElbHistoryMonitorReturnObjResponse returnObj;

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

        public NewQueryElbHistoryMonitorReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(NewQueryElbHistoryMonitorReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class NewQueryElbHistoryMonitorReturnObjResponse {
        /** 监控数据 */
        @JsonProperty("monitors")
        private List<NewQueryElbHistoryMonitorReturnObjMonitorsResponse> monitors;

        /** 列表条目数 */
        @JsonProperty("totalCount")
        private Integer totalCount;

        /** 分页查询时每页的行数。 */
        @JsonProperty("currentCount")
        private Integer currentCount;

        /** 总页数 */
        @JsonProperty("totalPage")
        private Integer totalPage;

        public List<NewQueryElbHistoryMonitorReturnObjMonitorsResponse> getMonitors() {
            return this.monitors;
        }

        public void setMonitors(List<NewQueryElbHistoryMonitorReturnObjMonitorsResponse> monitors) {
            this.monitors = monitors;
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

    public static class NewQueryElbHistoryMonitorReturnObjMonitorsResponse {
        /** 最近更新时间 */
        @JsonProperty("lastUpdated")
        private String lastUpdated;

        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 弹性公网 IP */
        @JsonProperty("deviceID")
        private String deviceID;

        /**
         * 监控项值列表，这里 itemAggregateList 是一个数组，每个数组是一个字典，每个字典的对应一个数组，每个字典的 key 对应 metricNames 中的一个元素.
         */
        @JsonProperty("itemAggregateList")
        private List<NewQueryElbHistoryMonitorReturnObjMonitorsItemAggregateListResponse>
                itemAggregateList;

        public String getLastUpdated() {
            return this.lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getDeviceID() {
            return this.deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public List<NewQueryElbHistoryMonitorReturnObjMonitorsItemAggregateListResponse>
                getItemAggregateList() {
            return this.itemAggregateList;
        }

        public void setItemAggregateList(
                List<NewQueryElbHistoryMonitorReturnObjMonitorsItemAggregateListResponse>
                        itemAggregateList) {
            this.itemAggregateList = itemAggregateList;
        }
    }

    public static class NewQueryElbHistoryMonitorReturnObjMonitorsItemAggregateListResponse {}
}
