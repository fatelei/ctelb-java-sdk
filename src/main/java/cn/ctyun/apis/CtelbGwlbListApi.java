package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看网关负载均衡列表 */
public class CtelbGwlbListApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbListApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(ENDPOINT_NAME, "GET", "/v4/gwlb/list", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public GwlbListResponse send(Credential credential, GwlbListRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.projectID != null) {
            ctReq.addParam("projectID", request.projectID);
        }
        if (request.gwLbID != null) {
            ctReq.addParam("gwLbID", request.gwLbID);
        }
        if (request.pageNumber != null) {
            ctReq.addParam("pageNumber", String.valueOf(request.pageNumber));
        }
        if (request.pageSize != null) {
            ctReq.addParam("pageSize", String.valueOf(request.pageSize));
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbListResponse.class);
    }

    public static class GwlbListRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 企业项目ID，默认"0" */
        @JsonProperty("projectID")
        private String projectID;

        /** 网关负载均衡ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

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

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getGwLbID() {
            return this.gwLbID;
        }

        public void setGwLbID(String gwLbID) {
            this.gwLbID = gwLbID;
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

    public static class GwlbListResponse {
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
        private GwlbListReturnObjResponse returnObj;

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

        public GwlbListReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbListReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbListReturnObjResponse {
        /** 接口业务数据 */
        @JsonProperty("results")
        private List<GwlbListReturnObjResultsResponse> results;

        /** 列表条目数 */
        @JsonProperty("totalCount")
        private Integer totalCount;

        /** 分页查询时每页的行数。 */
        @JsonProperty("currentCount")
        private Integer currentCount;

        /** 总页数 */
        @JsonProperty("totalPage")
        private Integer totalPage;

        public List<GwlbListReturnObjResultsResponse> getResults() {
            return this.results;
        }

        public void setResults(List<GwlbListReturnObjResultsResponse> results) {
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

    public static class GwlbListReturnObjResultsResponse {
        /** 网关负载均衡 ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

        /** 名字 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** 虚拟私有云 ID */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 子网 ID */
        @JsonProperty("subnetID")
        private String subnetID;

        /** 网卡 ID */
        @JsonProperty("portID")
        private String portID;

        /** 是否开启 ipv6 */
        @JsonProperty("ipv6Enabled")
        private Boolean ipv6Enabled;

        /** 私有 IP 地址 */
        @JsonProperty("privateIpAddress")
        private String privateIpAddress;

        /** ipv6 地址 */
        @JsonProperty("ipv6Address")
        private String ipv6Address;

        /** 规格 */
        @JsonProperty("slaName")
        private String slaName;

        /** 是否开启删除保护 */
        @JsonProperty("deleteProtection")
        private Boolean deleteProtection;

        /** 创建时间 */
        @JsonProperty("createdAt")
        private String createdAt;

        /** 更新时间 */
        @JsonProperty("updatedAt")
        private String updatedAt;

        public String getGwLbID() {
            return this.gwLbID;
        }

        public void setGwLbID(String gwLbID) {
            this.gwLbID = gwLbID;
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

        public String getSubnetID() {
            return this.subnetID;
        }

        public void setSubnetID(String subnetID) {
            this.subnetID = subnetID;
        }

        public String getPortID() {
            return this.portID;
        }

        public void setPortID(String portID) {
            this.portID = portID;
        }

        public Boolean getIpv6Enabled() {
            return this.ipv6Enabled;
        }

        public void setIpv6Enabled(Boolean ipv6Enabled) {
            this.ipv6Enabled = ipv6Enabled;
        }

        public String getPrivateIpAddress() {
            return this.privateIpAddress;
        }

        public void setPrivateIpAddress(String privateIpAddress) {
            this.privateIpAddress = privateIpAddress;
        }

        public String getIpv6Address() {
            return this.ipv6Address;
        }

        public void setIpv6Address(String ipv6Address) {
            this.ipv6Address = ipv6Address;
        }

        public String getSlaName() {
            return this.slaName;
        }

        public void setSlaName(String slaName) {
            this.slaName = slaName;
        }

        public Boolean getDeleteProtection() {
            return this.deleteProtection;
        }

        public void setDeleteProtection(Boolean deleteProtection) {
            this.deleteProtection = deleteProtection;
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
