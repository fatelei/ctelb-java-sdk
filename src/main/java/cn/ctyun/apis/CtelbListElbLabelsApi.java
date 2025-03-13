package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 获取负载均衡绑定的标签 */
public class CtelbListElbLabelsApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListElbLabelsApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-labels", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListElbLabelsResponse send(Credential credential, ListElbLabelsRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.elbID != null) {
            ctReq.addParam("elbID", request.elbID);
        }
        if (request.pageNo != null) {
            ctReq.addParam("pageNo", String.valueOf(request.pageNo));
        }
        if (request.pageSize != null) {
            ctReq.addParam("pageSize", String.valueOf(request.pageSize));
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListElbLabelsResponse.class);
    }

    public static class ListElbLabelsRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡 ID */
        @JsonProperty("elbID")
        private String elbID;

        /** 列表的页码，默认值为 1, 推荐使用该字段, pageNumber 后续会废弃 */
        @JsonProperty("pageNo")
        private Integer pageNo;

        /** 分页查询时每页的行数，最大值为 50，默认值为 10。 */
        @JsonProperty("pageSize")
        private Integer pageSize;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getElbID() {
            return this.elbID;
        }

        public void setElbID(String elbID) {
            this.elbID = elbID;
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

    public static class ListElbLabelsResponse {
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

        /** 列表条目数 */
        @JsonProperty("totalCount")
        private Integer totalCount;

        /** 分页查询时每页的行数。 */
        @JsonProperty("currentCount")
        private Integer currentCount;

        /** 总页数 */
        @JsonProperty("totalPage")
        private Integer totalPage;

        /** 返回结果 */
        @JsonProperty("returnObj")
        private List<ListElbLabelsReturnObjResponse> returnObj;

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

        public List<ListElbLabelsReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListElbLabelsReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ListElbLabelsReturnObjResponse {
        /** 绑定的标签列表 */
        @JsonProperty("results")
        private List<ListElbLabelsReturnObjResultsResponse> results;

        public List<ListElbLabelsReturnObjResultsResponse> getResults() {
            return this.results;
        }

        public void setResults(List<ListElbLabelsReturnObjResultsResponse> results) {
            this.results = results;
        }
    }

    public static class ListElbLabelsReturnObjResultsResponse {
        /** 标签 id */
        @JsonProperty("labelID")
        private String labelID;

        /** 标签名 */
        @JsonProperty("labelKey")
        private String labelKey;

        /** 标签值 */
        @JsonProperty("labelValue")
        private String labelValue;

        public String getLabelID() {
            return this.labelID;
        }

        public void setLabelID(String labelID) {
            this.labelID = labelID;
        }

        public String getLabelKey() {
            return this.labelKey;
        }

        public void setLabelKey(String labelKey) {
            this.labelKey = labelKey;
        }

        public String getLabelValue() {
            return this.labelValue;
        }

        public void setLabelValue(String labelValue) {
            this.labelValue = labelValue;
        }
    }
}
