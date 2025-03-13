package cn.ctyun.sdk;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CtyunClient {

    private final CtyunClientConfig config;
    private final EndpointRegistry registry;

    public CtyunClient(CtyunClientConfig config) {
        this.config = config;
        this.registry = EndpointRegistry.defaultEndpointRegistry();
    }

    /**
     * 生产环境配置
     *
     * @return 生产环境配置
     * @throws CtyunRequestException 异常
     */
    public static CtyunClientConfig clientConfigForProd() throws CtyunRequestException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectionPool(new ConnectionPool(5, 5, TimeUnit.MINUTES))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        return new CtyunClientConfig(builder.build());
    }

    /**
     * 测试环境配置
     *
     * @return 生产环境配置
     * @throws CtyunRequestException 异常
     */
    public static CtyunClientConfig clientConfigForTest() throws CtyunRequestException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        final TrustManager[] trustAllCerts =
                new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {}

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {}

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[] {};
                        }
                    }
                };

        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new CtyunRequestException("init SSLContext error", e);
        }

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
        builder.hostnameVerifier((hostname, session) -> true);

        // 设置超时为无限
        builder.connectTimeout(0, TimeUnit.MILLISECONDS);
        builder.readTimeout(0, TimeUnit.MILLISECONDS);
        builder.writeTimeout(0, TimeUnit.MILLISECONDS);

        return new CtyunClientConfig(builder.build()).addHook(new HttpHooks.PrintLogHttpHook());
    }

    /**
     * 生产环境客户端
     *
     * @return 客户端
     * @throws CtyunRequestException 异常
     */
    public static CtyunClient clientForProd() throws CtyunRequestException {
        return new CtyunClient(clientConfigForProd());
    }

    /**
     * 测试环境客户端
     *
     * @return 客户端
     * @throws CtyunRequestException 异常
     */
    public static CtyunClient clientForTest() throws CtyunRequestException {
        return new CtyunClient(clientConfigForTest());
    }

    /**
     * 默认客户端（生产环境）
     *
     * @return 客户端
     * @throws CtyunRequestException 异常
     */
    public static CtyunClient defaultClient() throws CtyunRequestException {
        return new CtyunClient(clientConfigForTest());
    }

    /**
     * 注册端点
     *
     * @param endpoint 注册的端点
     */
    public void registerEndpoint(Endpoint endpoint) {
        this.registry.register(endpoint);
    }

    /**
     * 请求端点
     *
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    public CtyunResponse requestToEndpoint(CtyunRequest request) throws CtyunRequestException {
        String defaultUrl = this.registry.getEndpointUrl(request.getEndpointName());
        return send(request.buildRequest(defaultUrl));
    }

    /**
     * 实际发起请求
     *
     * @param request 请求
     * @return 响应
     * @throws CtyunRequestException 异常
     */
    private CtyunResponse send(Request request) throws CtyunRequestException {
        for (HttpHook hook : this.config.hooks) {
            hook.beforeRequest(request);
        }
        try (Response response = this.config.client.newCall(request).execute()) {
            for (HttpHook hook : this.config.hooks) {
                hook.afterResponse(response);
            }
            if (!response.isSuccessful()) {
                throw new CtyunRequestException(
                        "request to url: ["
                                + request.url()
                                + "] error, status: "
                                + response.code()
                                + " , message"
                                + response.message());
            }
            byte[] bytes = new byte[0];
            if (response.body() != null) {
                bytes = response.body().bytes();
            }
            System.out.println("response.body String: " + new String(bytes));
            return new CtyunResponse(request, response, bytes);
        } catch (IOException e) {
            throw new CtyunRequestException("request to url: [" + request.url() + "] error", e);
        }
    }

    public static class CtyunClientConfig {

        private final OkHttpClient client;
        private final List<HttpHook> hooks = new ArrayList<>();

        public CtyunClientConfig(OkHttpClient client) {
            this.client = client;
        }

        /**
         * 添加钩子
         *
         * @param hook 钩子
         * @return 配置
         */
        public CtyunClientConfig addHook(HttpHook hook) {
            Objects.requireNonNull(hook);
            this.hooks.add(hook);
            return this;
        }
    }
}
