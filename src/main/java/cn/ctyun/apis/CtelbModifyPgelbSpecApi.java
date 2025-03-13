package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 保障型负载均衡变配 */
public class CtelbModifyPgelbSpecApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbModifyPgelbSpecApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/modify-pgelb-spec", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ModifyPgelbSpecResponse send(Credential credential, ModifyPgelbSpecRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ModifyPgelbSpecResponse.class);
    }

    public static class ModifyPgelbSpecRequest {
        /** 客户端存根，用于保证订单幂等性, 长度 1 - 64 */
        @JsonProperty("clientToken")
        private String clientToken;

        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 负载均衡 ID */
        @JsonProperty("elbID")
        private String elbID;

        /**
         * lb的规格名称,
         * 支持:elb.s2.small，elb.s3.small，elb.s4.small，elb.s5.small，elb.s2.large，elb.s3.large，elb.s4.large，elb.s5.large
         */
        @JsonProperty("slaName")
        private String slaName;

        /** 代金券金额，支持到小数点后两位 */
        @JsonProperty("payVoucherPrice")
        private String payVoucherPrice;

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

        public String getSlaName() {
            return this.slaName;
        }

        public void setSlaName(String slaName) {
            this.slaName = slaName;
        }

        public String getPayVoucherPrice() {
            return this.payVoucherPrice;
        }

        public void setPayVoucherPrice(String payVoucherPrice) {
            this.payVoucherPrice = payVoucherPrice;
        }
    }

    public static class ModifyPgelbSpecResponse {
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
        private ModifyPgelbSpecReturnObjResponse returnObj;

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

        public ModifyPgelbSpecReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(ModifyPgelbSpecReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ModifyPgelbSpecReturnObjResponse {
        /** 订单id。 */
        @JsonProperty("masterOrderID")
        private String masterOrderID;

        /** 订单编号, 可以为 null。 */
        @JsonProperty("masterOrderNO")
        private String masterOrderNO;

        /** 可用区id。 */
        @JsonProperty("regionID")
        private String regionID;

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

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }
    }
}
