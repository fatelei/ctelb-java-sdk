package cn.ctyun.apis;

import static cn.ctyun.apis.Apis.ENDPOINT_NAME;

import cn.ctyun.sdk.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/** 查询策略地址组，访问控制采用黑、白名单方式实现，此接口为查询黑、白名单的地址组。 */
public class CtelbListAccessControlApi {
    private final CtyunRequestTemplate template;
    private final CtyunClient client;

    public CtelbListAccessControlApi(CtyunClient client) {
        this.client = client;
        this.template =
                new CtyunRequestTemplate(
                        ENDPOINT_NAME, "GET", "/v4/elb/list-access-control", "application/json");
    }

    /**
     * 发起请求
     *
     * @param credential 用户信息
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public ListAccessControlResponse send(Credential credential, ListAccessControlRequest request)
            throws CtyunRequestException {
        CtyunRequestBuilder builder = new CtyunRequestBuilder(template);
        builder.withCredential(credential);
        CtyunRequest ctReq = builder.build();
        if (request.regionID != null) {
            ctReq.addParam("regionID", request.regionID);
        }
        for (String ele0 : request.iDs) {
            if (ele0 != null) {
                ctReq.addParam("IDs", ele0);
            }
        }
        if (request.name != null) {
            ctReq.addParam("name", request.name);
        }
        CtyunResponse response = this.client.requestToEndpoint(ctReq);
        return response.parse(ListAccessControlResponse.class);
    }

    public static class ListAccessControlRequest {
        /** 区域ID */
        @JsonProperty("regionID")
        private String regionID;

        /** 访问控制ID列表 */
        @JsonProperty("IDs")
        private List<String> iDs;

        /** 访问控制名称,只能由数字，字母，-组成不能以数字和-开头，最大长度32 */
        @JsonProperty("name")
        private String name;

        public String getRegionID() {
            return this.regionID;
        }

        public void setRegionID(String regionID) {
            this.regionID = regionID;
        }

        public List<String> getIDs() {
            return this.iDs;
        }

        public void setIDs(List<String> iDs) {
            this.iDs = iDs;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ListAccessControlResponse {
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
        private List<ListAccessControlReturnObjResponse> returnObj;

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

        public List<ListAccessControlReturnObjResponse> getReturnObj() {
            return this.returnObj;
        }

        public void setReturnObj(List<ListAccessControlReturnObjResponse> returnObj) {
            this.returnObj = returnObj;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class ListAccessControlReturnObjResponse {
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
