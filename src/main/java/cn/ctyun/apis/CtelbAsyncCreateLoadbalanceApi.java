package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 创建负载均衡实例，该接口为异步接口，第一次请求会返回资源在创建中，需要用户发起多次请求，直到 status 为 done 为止。 */
public class CtelbAsyncCreateLoadbalanceApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbAsyncCreateLoadbalanceApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME,
                        "POST",
                        "/v4/elb/async-create-loadbalance",
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
    public AsyncCreateLoadbalanceResponse send(
            Credential credential, AsyncCreateLoadbalanceRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(AsyncCreateLoadbalanceResponse.class);
    }

    public static class AsyncCreateLoadbalanceRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** vpc的ID */
        @JsonProperty("vpcID")
        private String vpcID;

        /** 子网的ID */
        @JsonProperty("subnetID")
        private String subnetID;

        /** 唯一。支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /** 弹性公网IP的ID。当resourceType=external为必填 */
        @JsonProperty("eipID")
        private String eipID;

        /** 资源类型。internal：内网负载均衡，external：公网负载均衡 */
        @JsonProperty("resourceType")
        private String resourceType;

        /** 负载均衡的私有IP地址，不指定则自动分配 */
        @JsonProperty("privateIpAddress")
        private String privateIpAddress;

        public String getClientToken() {
            return this.clientToken;
        }

        public void setClientToken(String clientToken) {
            this.clientToken = clientToken;
        }

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
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

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEipID() {
            return this.eipID;
        }

        public void setEipID(String eipID) {
            this.eipID = eipID;
        }

        public String getResourceType() {
            return this.resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
        }

        public String getPrivateIpAddress() {
            return this.privateIpAddress;
        }

        public void setPrivateIpAddress(String privateIpAddress) {
            this.privateIpAddress = privateIpAddress;
        }
    }

    public static class AsyncCreateLoadbalanceResponse {
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
        private AsyncCreateLoadbalanceReturnObjResponse returnObj;

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

        public AsyncCreateLoadbalanceReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(AsyncCreateLoadbalanceReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class AsyncCreateLoadbalanceReturnObjResponse {
        /** 创建进度: in_progress / done */
        @JsonProperty("status")
        private String status;

        /** 进度说明 */
        @JsonProperty("message")
        private String message;

        /** 负载均衡ID，可能为 null */
        @JsonProperty("loadBalanceID")
        private String loadBalanceID;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getLoadBalanceID() {
            return this.loadBalanceID;
        }

        public void setLoadBalanceID(String loadBalanceID) {
            this.loadBalanceID = loadBalanceID;
        }
    }
}
