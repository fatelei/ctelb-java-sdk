package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看负载均衡实时监控。 */
public class CtelbQueryElbReatimeMetricApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbQueryElbReatimeMetricApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/elb/query-realtime-monitor",
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
    public QueryElbReatimeMetricResponse send(
            Credential credential, QueryElbReatimeMetricRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(QueryElbReatimeMetricResponse.class);
    }

    public static class QueryElbReatimeMetricRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡 ID 列表 */
        @JsonProperty("deviceIDs")
        private List<String> deviceIDs;

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

    public static class QueryElbReatimeMetricResponse {
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
        private List<QueryElbReatimeMetricReturnObjResponse> returnObj;

        /** 列表条目数 */
        @JsonProperty("totalCount")
        private Integer totalCount;

        /** 分页查询时每页的行数。 */
        @JsonProperty("currentCount")
        private Integer currentCount;

        /** 总页数 */
        @JsonProperty("totalPage")
        private Integer totalPage;

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

        public List<QueryElbReatimeMetricReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<QueryElbReatimeMetricReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
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

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class QueryElbReatimeMetricReturnObjResponse {
        /** 最近更新时间 */
        @JsonProperty("lastUpdated")
        private String lastUpdated;

        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 弹性公网 IP */
        @JsonProperty("deviceID")
        private String deviceID;

        /** 监控项值列表 */
        @JsonProperty("itemList")
        private List<QueryElbReatimeMetricReturnObjItemListResponse> itemList;

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

        public List<QueryElbReatimeMetricReturnObjItemListResponse> getItemList() {
            return this.itemList;
        }

        public void setItemList(List<QueryElbReatimeMetricReturnObjItemListResponse> itemList) {
            this.itemList = itemList;
        }
    }

    public static class QueryElbReatimeMetricReturnObjItemListResponse {
        /** 请求频率 */
        @JsonProperty("lbReqRate")
        private String lbReqRate;

        /** 出吞吐量 */
        @JsonProperty("lbLbin")
        private String lbLbin;

        /** 入带宽峰值 */
        @JsonProperty("lbLbout")
        private String lbLbout;

        /** HTTP 其它状态码统计数量 */
        @JsonProperty("lbHrspOther")
        private String lbHrspOther;

        /** HTTP 2xx 状态码统计数量 */
        @JsonProperty("lbHrsp2xx")
        private String lbHrsp2xx;

        /** HTTP 3xx 状态码统计数量 */
        @JsonProperty("lbHrsp3xx")
        private String lbHrsp3xx;

        /** HTTP 4xx 状态码统计数量 */
        @JsonProperty("lbHrsp4xx")
        private String lbHrsp4xx;

        /** HTTP 5xx 状态码统计数量 */
        @JsonProperty("lbHrsp5xx")
        private String lbHrsp5xx;

        /** HTTP 新创建的链接数 */
        @JsonProperty("lbNewcreate")
        private String lbNewcreate;

        /** HTTP */
        @JsonProperty("lbScur")
        private String lbScur;

        /** 出带宽峰值 */
        @JsonProperty("lbInpkts")
        private String lbInpkts;

        /** 出带宽峰值 */
        @JsonProperty("lbOutpkts")
        private String lbOutpkts;

        /** HTTP 活跃的链接数 */
        @JsonProperty("lbActconn")
        private String lbActconn;

        /** 采样时间 */
        @JsonProperty("samplingTime")
        private Integer samplingTime;

        public String getLbReqRate() {
            return this.lbReqRate;
        }

        public void setLbReqRate(String lbReqRate) {
            this.lbReqRate = lbReqRate;
        }

        public String getLbLbin() {
            return this.lbLbin;
        }

        public void setLbLbin(String lbLbin) {
            this.lbLbin = lbLbin;
        }

        public String getLbLbout() {
            return this.lbLbout;
        }

        public void setLbLbout(String lbLbout) {
            this.lbLbout = lbLbout;
        }

        public String getLbHrspOther() {
            return this.lbHrspOther;
        }

        public void setLbHrspOther(String lbHrspOther) {
            this.lbHrspOther = lbHrspOther;
        }

        public String getLbHrsp2xx() {
            return this.lbHrsp2xx;
        }

        public void setLbHrsp2xx(String lbHrsp2xx) {
            this.lbHrsp2xx = lbHrsp2xx;
        }

        public String getLbHrsp3xx() {
            return this.lbHrsp3xx;
        }

        public void setLbHrsp3xx(String lbHrsp3xx) {
            this.lbHrsp3xx = lbHrsp3xx;
        }

        public String getLbHrsp4xx() {
            return this.lbHrsp4xx;
        }

        public void setLbHrsp4xx(String lbHrsp4xx) {
            this.lbHrsp4xx = lbHrsp4xx;
        }

        public String getLbHrsp5xx() {
            return this.lbHrsp5xx;
        }

        public void setLbHrsp5xx(String lbHrsp5xx) {
            this.lbHrsp5xx = lbHrsp5xx;
        }

        public String getLbNewcreate() {
            return this.lbNewcreate;
        }

        public void setLbNewcreate(String lbNewcreate) {
            this.lbNewcreate = lbNewcreate;
        }

        public String getLbScur() {
            return this.lbScur;
        }

        public void setLbScur(String lbScur) {
            this.lbScur = lbScur;
        }

        public String getLbInpkts() {
            return this.lbInpkts;
        }

        public void setLbInpkts(String lbInpkts) {
            this.lbInpkts = lbInpkts;
        }

        public String getLbOutpkts() {
            return this.lbOutpkts;
        }

        public void setLbOutpkts(String lbOutpkts) {
            this.lbOutpkts = lbOutpkts;
        }

        public String getLbActconn() {
            return this.lbActconn;
        }

        public void setLbActconn(String lbActconn) {
            this.lbActconn = lbActconn;
        }

        public Integer getSamplingTime() {
            return this.samplingTime;
        }

        public void setSamplingTime(Integer samplingTime) {
            this.samplingTime = samplingTime;
        }
    }
}
