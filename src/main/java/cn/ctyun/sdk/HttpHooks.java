package cn.ctyun.sdk;

import okhttp3.Request;
import okhttp3.Response;

public class HttpHooks {

    public static class PrintLogHttpHook implements HttpHook {

        @Override
        public void beforeRequest(Request request) {
            // 打印请求信息
            System.out.println("Request url: " + request.url() + "\n");
            System.out.println("Request headers: " + request.headers() + "\n");
            if (request.body() != null) {
                System.out.println("Request body: " + request.body() + "\n");
            }
        }

        @Override
        public void afterResponse(Response response) {
            // 打印响应信息
            System.out.println("Response headers: " + response.headers() + "\n");
            if (response.body() != null) {
                System.out.println("Response body: " + response.body() + "\n");
            }
        }
    }
}
