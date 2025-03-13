package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 保障型负载均衡续订询价 */
public class CtelbQueryRenewPgelbPriceApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbQueryRenewPgelbPriceApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/query-renew-price", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public QueryRenewPgelbPriceResponse send(
            Credential credential, QueryRenewPgelbPriceRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(QueryRenewPgelbPriceResponse.class);
    }

    public static class QueryRenewPgelbPriceRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡 ID */
        @JsonProperty("elbID")
        private String elbID;

        /** 订购类型：month（包月） / year（包年） */
        @JsonProperty("cycleType")
        private String cycleType;

        /** 订购时长, 当 cycleType = month, 支持续订 1 - 11 个月; 当 cycleType = year, 支持续订 1 - 3 年 */
        @JsonProperty("cycleCount")
        private Integer cycleCount;

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

        public String getElbID() {
            return this.elbID;
        }

        public void setElbID(String elbID) {
            this.elbID = elbID;
        }

        public String getCycleType() {
            return this.cycleType;
        }

        public void setCycleType(String cycleType) {
            this.cycleType = cycleType;
        }

        public Integer getCycleCount() {
            return this.cycleCount;
        }

        public void setCycleCount(Integer cycleCount) {
            this.cycleCount = cycleCount;
        }
    }

    public static class QueryRenewPgelbPriceResponse {
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

        /** 业务数据 */
        @JsonProperty("returnObj")
        private QueryRenewPgelbPriceReturnObjResponse returnObj;

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

        public QueryRenewPgelbPriceReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(QueryRenewPgelbPriceReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class QueryRenewPgelbPriceReturnObjResponse {
        /** 总价格 */
        @JsonProperty("totalPrice")
        private Double totalPrice;

        /** 折后价格，云主机相关产品有 */
        @JsonProperty("discountPrice")
        private Double discountPrice;

        /** 最终价格 */
        @JsonProperty("finalPrice")
        private Double finalPrice;

        /** 子订单价格信息 */
        @JsonProperty("subOrderPrices")
        private List<QueryRenewPgelbPriceReturnObjSubOrderPricesResponse> subOrderPrices;

        public Double getTotalPrice() {
            return this.totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Double getDiscountPrice() {
            return this.discountPrice;
        }

        public void setDiscountPrice(Double discountPrice) {
            this.discountPrice = discountPrice;
        }

        public Double getFinalPrice() {
            return this.finalPrice;
        }

        public void setFinalPrice(Double finalPrice) {
            this.finalPrice = finalPrice;
        }

        public List<QueryRenewPgelbPriceReturnObjSubOrderPricesResponse> getSubOrderPrices() {
            return this.subOrderPrices;
        }

        public void setSubOrderPrices(
                List<QueryRenewPgelbPriceReturnObjSubOrderPricesResponse> subOrderPrices) {
            this.subOrderPrices = subOrderPrices;
        }
    }

    public static class QueryRenewPgelbPriceReturnObjSubOrderPricesResponse {
        /** 服务类型 */
        @JsonProperty("serviceTag")
        private String serviceTag;

        /** 子订单总价格 */
        @JsonProperty("totalPrice")
        private Double totalPrice;

        /** 最终价格 */
        @JsonProperty("finalPrice")
        private Double finalPrice;

        /** item价格信息 */
        @JsonProperty("orderItemPrices")
        private List<QueryRenewPgelbPriceReturnObjSubOrderPricesOrderItemPricesResponse>
                orderItemPrices;

        public String getServiceTag() {
            return this.serviceTag;
        }

        public void setServiceTag(String serviceTag) {
            this.serviceTag = serviceTag;
        }

        public Double getTotalPrice() {
            return this.totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Double getFinalPrice() {
            return this.finalPrice;
        }

        public void setFinalPrice(Double finalPrice) {
            this.finalPrice = finalPrice;
        }

        public List<QueryRenewPgelbPriceReturnObjSubOrderPricesOrderItemPricesResponse>
                getOrderItemPrices() {
            return this.orderItemPrices;
        }

        public void setOrderItemPrices(
                List<QueryRenewPgelbPriceReturnObjSubOrderPricesOrderItemPricesResponse>
                        orderItemPrices) {
            this.orderItemPrices = orderItemPrices;
        }
    }

    public static class QueryRenewPgelbPriceReturnObjSubOrderPricesOrderItemPricesResponse {
        /** 资源类型 */
        @JsonProperty("resourceType")
        private String resourceType;

        /** 总价格 */
        @JsonProperty("totalPrice")
        private String totalPrice;

        /** 最终价格 */
        @JsonProperty("finalPrice")
        private String finalPrice;

        public String getResourceType() {
            return this.resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
        }

        public String getTotalPrice() {
            return this.totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getFinalPrice() {
            return this.finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }
    }
}
