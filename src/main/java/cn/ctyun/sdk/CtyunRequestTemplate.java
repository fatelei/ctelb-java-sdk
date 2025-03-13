package cn.ctyun.sdk;

import java.util.Objects;

public class CtyunRequestTemplate {

    public final String endpointName;
    public final String method;
    public final String urlPath;
    public final String contentType;

    public CtyunRequestTemplate(
            String endpointName, String method, String urlPath, String contentType) {
        Objects.requireNonNull(method);
        Objects.requireNonNull(urlPath);
        Objects.requireNonNull(contentType);
        this.method = method;
        this.urlPath = urlPath;
        this.endpointName = endpointName;
        this.contentType = contentType;
    }
}
