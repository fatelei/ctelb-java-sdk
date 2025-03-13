package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查询策略地址组详情，访问控制采用黑、白名单方式实现，此接口为查询黑、白名单的地址组。 */
public class CtelbShowAccessControlApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbShowAccessControlApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/show-access-control", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ShowAccessControlResponse send(Credential credential, ShowAccessControlRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        if (request.id != null) {
            ctReq.addParam("id", request.id);
        }
        if (request.accessControlID != null) {
            ctReq.addParam("accessControlID", request.accessControlID);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ShowAccessControlResponse.class);
    }

    public static class ShowAccessControlRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 访问控制ID, 该字段后续废弃 */
        @JsonProperty("id")
        private String id;

        /** 访问控制ID, 推荐使用该字段, 当同时使用 id 和 accessControlID 时，优先使用 accessControlID */
        @JsonProperty("accessControlID")
        private String accessControlID;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAccessControlID() {
            return this.accessControlID;
        }

        public void setAccessControlID(String accessControlID) {
            this.accessControlID = accessControlID;
        }
    }

    public static class ShowAccessControlResponse {
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
        private ShowAccessControlReturnObjResponse returnObj;

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

        public ShowAccessControlReturnObjResponse getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(ShowAccessControlReturnObjResponse returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ShowAccessControlReturnObjResponse {
        /** 可用区名称 */
        @JsonProperty("azName")
        private String azName;

        /** 项目ID */
        @JsonProperty("projectID")
        private String projectID;

        /** 访问控制ID */
        @JsonProperty("ID")
        private String iD;

        /** 访问控制名称 */
        @JsonProperty("name")
        private String name;

        /** 描述 */
        @JsonProperty("description")
        private String description;

        /** IP地址的集合或者CIDR */
        @JsonProperty("sourceIps")
        private List<String> sourceIps;

        /** 创建时间，为UTC格式 */
        @JsonProperty("createTime")
        private String createTime;

        public String getAzName() {
            return this.azName;
        }

        public void setAzName(String azName) {
            this.azName = azName;
        }

        public String getProjectID() {
            return this.projectID;
        }

        public void setProjectID(String projectID) {
            this.projectID = projectID;
        }

        public String getID() {
            return this.iD;
        }

        public void setID(String iD) {
            this.iD = iD;
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

        public List<String> getSourceIps() {
            return this.sourceIps;
        }

        public void setSourceIps(List<String> sourceIps) {
            this.sourceIps = sourceIps;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
