package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 更新ip_listener */
public class CtelbIplistenerUpdateApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbIplistenerUpdateApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "POST", "/v4/iplistener/update", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public IplistenerUpdateResponse send(Credential credential, IplistenerUpdateRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        ctReq.writeJson(request, template.contentType);
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(IplistenerUpdateResponse.class);
    }

    public static class IplistenerUpdateRequest {
        /** 资源池 ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 监听器 ID */
        @JsonProperty("ipListenerID")
        private String ipListenerID;

        /** 支持拉丁字母、中文、数字，下划线，连字符，中文 / 英文字母开头，不能以 http: / https: 开头，长度 2 - 32 */
        @JsonProperty("name")
        private String name;

        /** 后端组 ID */
        @JsonProperty("targetGroupID")
        private String targetGroupID;

        /** 转发权重, 取值范围 0 - 256 */
        @JsonProperty("weight")
        private Integer weight;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getIpListenerID() {
            return this.ipListenerID;
        }

        public void setIpListenerID(String ipListenerID) {
            this.ipListenerID = ipListenerID;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTargetGroupID() {
            return this.targetGroupID;
        }

        public void setTargetGroupID(String targetGroupID) {
            this.targetGroupID = targetGroupID;
        }

        public Integer getWeight() {
            return this.weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }

    public static class IplistenerUpdateResponse {
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
        private IplistenerUpdateReturnObjResponse returnObj;

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

        public IplistenerUpdateReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(IplistenerUpdateReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }
    }

    public static class IplistenerUpdateReturnObjResponse {
        /** 监听器 id */
        @JsonProperty("ipListenerID")
        private String ipListenerID;

        public String getIpListenerID() {
            return this.ipListenerID;
        }

        public void setIpListenerID(String ipListenerID) {
            this.ipListenerID = ipListenerID;
        }
    }
}
