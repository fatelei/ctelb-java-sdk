package cn.ctyun.sdk;

import okhttp3.Request;
import okhttp3.Response;

public interface HttpHook {

    /**
     * 发起调用前执行
     *
     * @param request 请求
     */
    void beforeRequest(Request request);

    /**
     * 发起调用后执行
     *
     * @param response 响应
     */
    void afterResponse(Response response);
}
