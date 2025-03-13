package cn.ctyun.sdk;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CtyunResponse {

    private final Request request;
    private final Response response;
    private final byte[] responseBody;

    protected CtyunResponse(Request request, Response response, byte[] responseBody) {
        this.request = request;
        this.response = response;
        this.responseBody = responseBody;
    }

    /**
     * 解析数据
     *
     * @param cls 解析类型模板
     * @param <T> 类型
     * @return 解析后的实例
     * @throws CtyunRequestException 异常
     */
    public <T> T parse(Class<T> cls) throws CtyunRequestException {
        if (responseBody == null || responseBody.length == 0) {
            return null;
        }
        try {
            return JacksonUtils.getObjectMapperInstance().readValue(responseBody, cls);
        } catch (IOException e) {
            throw new CtyunRequestException(
                    "error to parse response body: [ "
                            + new String(responseBody)
                            + " ] for class: ["
                            + cls.toString()
                            + "]",
                    e);
        }
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public byte[] getResponseBody() {
        return responseBody;
    }
}
