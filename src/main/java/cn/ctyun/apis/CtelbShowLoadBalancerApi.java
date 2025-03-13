package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查看负载均衡实例 */
public class CtelbShowLoadBalancerApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbShowLoadBalancerApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/show-loadbalancer", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ShowLoadBalancerResponse send(Credential credential, ShowLoadBalancerRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.iD != null) {
            ctReq.addParam("ID", request.iD);
        }
        if (request.elbID != null) {
            ctReq.addParam("elbID", request.elbID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ShowLoadBalancerResponse.class);
    }

    public static class ShowLoadBalancerRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡ID, 该字段后续废弃 */
        @JsonProperty("ID")
        private String iD;

        /** 负载均衡ID, 推荐使用该字段 */
        @JsonProperty("elbID")
        private String elbID;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getElbID() {
            return this.elbID;
        }

        public void setElbID(String elbID) {
            this.elbID = elbID;
        }
    }

    public static class ShowLoadBalancerResponse {
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
        private List<ShowLoadBalancerReturnObjResponse> returnObj;

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

        public List<ShowLoadBalancerReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ShowLoadBalancerReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ShowLoadBalancerReturnObjResponse {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 可用区名称 */
        @JsonProperty("azName")
        private String azName;

        /** 负载均衡ID */
        @JsonProperty("ID")
        private String iD;

        /** 项目ID */
        @JsonProperty("projectID")
        private String projectID;

        /** 名称 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** VPC ID */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 子网ID */
        @JsonProperty("subnetID")
        private String subnetID;

        /** 负载均衡实例默认创建port ID */
        @JsonProperty("portID")
        private String portID;

        /** 负载均衡实例的内网VIP */
        @JsonProperty("privateIpAddress")
        private String privateIpAddress;

        /** 负载均衡实例的IPv6地址 */
        @JsonProperty("ipv6Address")
        private String ipv6Address;

        /** 规格名称 */
        @JsonProperty("slaName")
        private String slaName;

        /** 弹性公网IP信息 */
        @JsonProperty("eipInfo")
        private List<ShowLoadBalancerReturnObjEipInfoResponse> eipInfo;

        /** 删除保护。开启，不开启 */
        @JsonProperty("deleteProtection")
        private Boolean deleteProtection;

        /** 管理状态: DOWN / ACTIVE */
        @JsonProperty("adminStatus")
        private String adminStatus;

        /** 负载均衡状态: DOWN / ACTIVE */
        @JsonProperty("status")
        private String status;

        /** 负载均衡类型: external / internal */
        @JsonProperty("resourceType")
        private String resourceType;

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

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
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

        public List<ShowLoadBalancerReturnObjEipInfoResponse> getEipInfo() {
            return this.eipInfo;
        }

        public void setEipInfo(List<ShowLoadBalancerReturnObjEipInfoResponse> eipInfo) {
            this.eipInfo = eipInfo;
        }

        public Boolean getDeleteProtection() {
            return this.deleteProtection;
        }

        public void setDeleteProtection(Boolean deleteProtection) {
            this.deleteProtection = deleteProtection;
        }

        public String getAdminStatus() {
            return this.adminStatus;
        }

        public void setAdminStatus(String adminStatus) {
            this.adminStatus = adminStatus;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getResourceType() {
            return this.resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
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

    public static class ShowLoadBalancerReturnObjEipInfoResponse {
        /** 计费类资源ID */
        @JsonProperty("resourceID")
        private String resourceID;

        /** 弹性公网IP的ID */
        @JsonProperty("eipID")
        private String eipID;

        /** 弹性公网IP的带宽 */
        @JsonProperty("bandwidth")
        private Integer bandwidth;

        /** 是否按需资源 */
        @JsonProperty("isTalkOrder")
        private Boolean isTalkOrder;

        public String getResourceID() {
            return this.resourceID;
        }

        public void setResourceID(String resourceID) {
            this.resourceID = resourceID;
        }

        public String getEipID() {
            return this.eipID;
        }

        public void setEipID(String eipID) {
            this.eipID = eipID;
        }

        public Integer getBandwidth() {
            return this.bandwidth;
        }

        public void setBandwidth(Integer bandwidth) {
            this.bandwidth = bandwidth;
        }

        public Boolean getIsTalkOrder() {
            return this.isTalkOrder;
        }

        public void setIsTalkOrder(Boolean isTalkOrder) {
            this.isTalkOrder = isTalkOrder;
        }
    }
}
