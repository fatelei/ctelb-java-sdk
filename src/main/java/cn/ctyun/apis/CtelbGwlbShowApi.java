package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 查看网关负载均衡详情 */
public class CtelbGwlbShowApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbShowApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(ENDPOINT_NAME, "GET", "/v4/gwlb/show", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public GwlbShowResponse send(Credential credential, GwlbShowRequest request)
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
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbShowResponse.class);
    }

    public static class GwlbShowRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 企业项目ID，默认"0" */
        @JsonProperty("projectID")
        private String projectID;

        /** 网关负载均衡ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

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
    }

    public static class GwlbShowResponse {
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
        private GwlbShowReturnObjResponse returnObj;

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

        public GwlbShowReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbShowReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbShowReturnObjResponse {
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
