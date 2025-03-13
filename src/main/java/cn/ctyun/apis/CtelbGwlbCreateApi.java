package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 创建网关负载均衡 */
public class CtelbGwlbCreateApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbGwlbCreateApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/gwlb/create", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public GwlbCreateResponse send(Credential credential, GwlbCreateRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(GwlbCreateResponse.class);
    }

    public static class GwlbCreateRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 客户端存根，用于保证订单幂等性。要求单个云平台账户内唯一 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 企业项目ID，默认"0" */
        @JsonProperty("projectID")
        private String projectID;

        /** 子网 ID */
        @JsonProperty("subnetID")
        private String subnetID;

        /** 支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /** 私有 ip 地址 */
        @JsonProperty("privateIpAddress")
        private String privateIpAddress;

        /** ipv6 地址 */
        @JsonProperty("ipv6Address")
        private String ipv6Address;

        /** 是否开启删除保护，默认为 False */
        @JsonProperty("deleteProtection")
        private Boolean deleteProtection;

        /** 是否开启 ipv6，默认为 False */
        @JsonProperty("ipv6Enabled")
        private Boolean ipv6Enabled;

        /** 仅支持按需 */
        @JsonProperty("cycleType")
        private String cycleType;

        /** 代金券金额，支持到小数点后两位 */
        @JsonProperty("payVoucherPrice")
        private String payVoucherPrice;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getClientToken() {
            return this.clientToken;
        }

        public void setClientToken(String clientToken) {
            this.clientToken = clientToken;
        }

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getSubnetID() {
            return this.subnetID;
        }

        public void setSubnetID(String subnetID) {
            this.subnetID = subnetID;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
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

        public Boolean getDeleteProtection() {
            return this.deleteProtection;
        }

        public void setDeleteProtection(Boolean deleteProtection) {
            this.deleteProtection = deleteProtection;
        }

        public Boolean getIpv6Enabled() {
            return this.ipv6Enabled;
        }

        public void setIpv6Enabled(Boolean ipv6Enabled) {
            this.ipv6Enabled = ipv6Enabled;
        }

        public String getCycleType() {
            return this.cycleType;
        }

        public void setCycleType(String cycleType) {
            this.cycleType = cycleType;
        }

        public String getPayVoucherPrice() {
            return this.payVoucherPrice;
        }

        public void setPayVoucherPrice(String payVoucherPrice) {
            this.payVoucherPrice = payVoucherPrice;
        }
    }

    public static class GwlbCreateResponse {
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
        private GwlbCreateReturnObjResponse returnObj;

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

        public GwlbCreateReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(GwlbCreateReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class GwlbCreateReturnObjResponse {
        /** 订单id。 */
        @JsonProperty("masterOrderID")
        private String masterOrderID;

        /** 订单编号, 可以为 null。 */
        @JsonProperty("masterOrderNO")
        private String masterOrderNO;

        /**
         * 资源状态: started（启用） / renewed（续订） / refunded（退订） / destroyed（销毁） / failed（失败） /
         * starting（正在启用） / changed（变配）/ expired（过期）/ unknown（未知）
         */
        @JsonProperty("masterResourceStatus")
        private String masterResourceStatus;

        /** 资源 ID 可以为 null。 */
        @JsonProperty("masterResourceID")
        private String masterResourceID;

        /** 可用区id。 */
        @JsonProperty("regionID")
        private String regionID;

        /** 网关负载均衡 ID */
        @JsonProperty("gwLbID")
        private String gwLbID;

        public String getMasterOrderID() {
            return this.masterOrderID;
        }

        public void setMasterOrderID(String masterOrderID) {
            this.masterOrderID = masterOrderID;
        }

        public String getMasterOrderNO() {
            return this.masterOrderNO;
        }

        public void setMasterOrderNO(String masterOrderNO) {
            this.masterOrderNO = masterOrderNO;
        }

        public String getMasterResourceStatus() {
            return this.masterResourceStatus;
        }

        public void setMasterResourceStatus(String masterResourceStatus) {
            this.masterResourceStatus = masterResourceStatus;
        }

        public String getMasterResourceID() {
            return this.masterResourceID;
        }

        public void setMasterResourceID(String masterResourceID) {
            this.masterResourceID = masterResourceID;
        }

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getGwLbID() {
            return this.gwLbID;
        }

        public void setGwLbID(String gwLbID) {
            this.gwLbID = gwLbID;
        }
    }
}
