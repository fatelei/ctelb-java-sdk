package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 关闭IDC */
public class CtelbElbDisableIDCApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbElbDisableIDCApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/elb/disable-idc", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ElbDisableIDCResponse send(Credential credential, ElbDisableIDCRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.vpcID != null) {
            ctReq.addParam("vpcID", request.vpcID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ElbDisableIDCResponse.class);
    }

    public static class ElbDisableIDCRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 虚拟私有云 ID */
        @JsonProperty("vpcID")
        private String vpcID;

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
    }

    public static class ElbDisableIDCResponse {
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
        private ElbDisableIDCReturnObjResponse returnObj;

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

        public ElbDisableIDCReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(ElbDisableIDCReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class ElbDisableIDCReturnObjResponse {
        /** 虚拟私有云 id */
        @JsonProperty("vpcID")
        private String vpcID;

        public String getVpcID() {
            return this.vpcID;
        }

        public void setVpcID(String vpcID) {
            this.vpcID = vpcID;
        }
    }
}
