package cn.ctyun.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CtyunRequestBuilder {

    private final String method;
    private String urlPath;
    private Credential credential;
    private String endpointName;

    public CtyunRequestBuilder(CtyunRequestTemplate template) {
        this.endpointName = template.endpointName;
        this.method = template.method;
        this.urlPath = template.urlPath;
    }

    /**
     * 替换路径中的目标值，例如把/orders/{masterOrderId}替换为/orders/1
     *
     * @param src 目标路径
     * @param target 替换的字符串
     * @return 构造器
     */
    public CtyunRequestBuilder replaceUrl(String src, Object target) {
        if (target == null) {
            return this;
        }
        String replace = null;
        try {
            replace = URLEncoder.encode(target.toString(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException ignored) {
        }
        replace = replace.replaceAll("\\+", "%20");
        this.urlPath = this.urlPath.replace("{" + src + "}", replace);
        return this;
    }

    /**
     * 添加用户信息
     *
     * @param credential 用户敏感信息
     * @return 请求
     */
    public CtyunRequestBuilder withCredential(Credential credential) {
        this.credential = credential;
        return this;
    }

    /**
     * 添加端点名称
     *
     * @param endpointName 端点名称
     * @return 请求
     */
    public CtyunRequestBuilder withEndpointName(String endpointName) {
        this.endpointName = endpointName;
        return this;
    }

    /**
     * 构造
     *
     * @return 请求
     */
    public CtyunRequest build() {
        return new CtyunRequest(this.method, this.urlPath, this.credential, this.endpointName);
    }
}
