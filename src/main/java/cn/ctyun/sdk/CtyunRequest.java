package cn.ctyun.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;

import okhttp3.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CtyunRequest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");
    private final String endpointName;
    private final Credential credential;

    private final String method;
    private final String urlPath;
    private CtyunRequestBody body;
    private final Map<String, List<String>> headers = new HashMap<>(0);
    private final Map<String, List<String>> params = new HashMap<>(0);

    protected CtyunRequest(
            String method, String urlPath, Credential credential, String endpointName) {
        this.method = method;
        this.urlPath = urlPath;
        this.credential = credential;
        this.endpointName = endpointName;
    }

    /**
     * 添加请求头
     *
     * @param key 键
     * @param value 值
     * @return 构造器
     */
    public CtyunRequest addHeader(String key, String value) {
        this.headers.computeIfAbsent(key, (k) -> new ArrayList<>()).add(value);
        return this;
    }

    /**
     * 添加请求头
     *
     * @param key 键
     * @param values 值
     * @return 构造器
     */
    public CtyunRequest addHeaders(String key, String... values) {
        for (String value : values) {
            addHeader(key, value);
        }
        return this;
    }

    /**
     * 添加参数
     *
     * @param key 键
     * @param value 值
     * @return 构造器
     */
    public CtyunRequest addParam(String key, String value) {
        this.params.computeIfAbsent(key, (k) -> new ArrayList<>()).add(value);
        return this;
    }

    /**
     * 添加参数
     *
     * @param key 键
     * @param values 值
     * @return 构造器
     */
    public CtyunRequest addParams(String key, String... values) {
        for (String value : values) {
            addParam(key, value);
        }
        return this;
    }

    /**
     * 以json方式写入
     *
     * @param data 数据
     * @return 构造器
     * @throws CtyunRequestException 异常
     */
    public CtyunRequest writeJson(Object data, String contentType) throws CtyunRequestException {
        try {
            this.body =
                    new CtyunRequestBody(
                            contentType,
                            JacksonUtils.getObjectMapperInstance().writeValueAsBytes(data));
        } catch (JsonProcessingException e) {
            throw new CtyunRequestException("write json error", e);
        }
        return this;
    }

    /**
     * 以String方式写入
     *
     * @param data 数据
     * @return 构造器
     * @throws CtyunRequestException 异常
     */
    public CtyunRequest writeString(String data, String contentType) throws CtyunRequestException {
        try {
            this.body = new CtyunRequestBody(contentType, data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new CtyunRequestException("write String error", e);
        }
        return this;
    }

    /**
     * 构建请求
     *
     * @param host 域名前缀
     * @return 请求
     */
    public Request buildRequest(String host) {
        // 构造url
        HttpUrl httpUrl = buildHttpUrl(host);
        // 构造headers
        Headers headers = buildRequestHeader(httpUrl.encodedQuery());
        // 构造body
        RequestBody requestBody = buildRequestBody();
        // 构造请求
        return new Request.Builder()
                .method(this.method, requestBody)
                .url(httpUrl)
                .headers(headers)
                .build();
    }

    /**
     * 构造httpUrl
     *
     * @param host 域名前缀
     * @return httpUrl
     */
    private HttpUrl buildHttpUrl(String host) {
        HttpUrl baseHttpUrl = HttpUrl.parse(host + urlPath);
        if (baseHttpUrl == null) {
            throw new IllegalArgumentException("url: [" + host + urlPath + "] error");
        }
        HttpUrl.Builder httpUrlBuilder = baseHttpUrl.newBuilder();
        this.params.forEach(
                (key, values) -> {
                    values.forEach(
                            (value) -> {
                                httpUrlBuilder.addQueryParameter(key, value);
                            });
                });
        return httpUrlBuilder.build();
    }

    /**
     * 构造headers
     *
     * @param query 查询参数
     * @return headers
     */
    private Headers buildRequestHeader(String query) {
        Headers.Builder headerBuilder = new Headers.Builder();
        this.headers.forEach(
                (key, values) -> {
                    values.forEach(
                            (value) -> {
                                headerBuilder.add(key, value);
                            });
                });
        String eopDate =
                DATE_TIME_FORMATTER.format(
                        ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        String id = UUID.randomUUID().toString();
        byte[] body =
                Optional.ofNullable(this.body).map(x -> x.content).orElseGet(() -> new byte[0]);
        query = handleQueryForSign(query);
        String sign = getSign(query, body, eopDate, id, this.credential);
        headerBuilder.add(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)"
                    + " Chrome/83.0.4103.116 Safari/537.36");
        headerBuilder.add("ctyun-eop-request-id", id);
        headerBuilder.add("Eop-Authorization", sign);
        headerBuilder.add("Eop-date", eopDate);
        return headerBuilder.build();
    }

    /**
     * 按照标准请求方式去处理query参数
     *
     * @param query query参数
     */
    private String handleQueryForSign(String query) {
        if (query == null || query.isEmpty()) {
            return "";
        }
        String[] params = query.split("&");
        Arrays.sort(params);
        return String.join("&", params);
    }

    /**
     * 构造请求body
     *
     * @return body
     */
    private RequestBody buildRequestBody() {
        if (this.body == null || this.body.content == null || this.body.content.length == 0) {
            return null;
        }
        return RequestBody.create(MediaType.get(this.body.mediaType), this.body.content);
    }

    /**
     * 加签
     *
     * @param query 查询参数
     * @param body 请求体
     * @param date 请求日期
     * @param id id
     * @param credential 用户信息
     * @return 签名
     */
    private static String getSign(
            String query, byte[] body, String date, String id, Credential credential) {
        String calculateContentHash = DigestUtils.sha256Hex(body);
        String signature =
                String.format(
                        "ctyun-eop-request-id:%s\neop-date:%s\n\n%s\n%s",
                        id, date, query, calculateContentHash);
        String singerDate = date.substring(0, 8);
        byte[] s = HmacUtils.hmacSha256(credential.sk, date);
        byte[] kAk = HmacUtils.hmacSha256(s, credential.ak.getBytes(StandardCharsets.UTF_8));
        byte[] kDate = HmacUtils.hmacSha256(kAk, singerDate.getBytes(StandardCharsets.UTF_8));
        byte[] signatureSha256 =
                HmacUtils.hmacSha256(kDate, signature.getBytes(StandardCharsets.UTF_8));
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureSha256);
        return credential.ak
                + " Headers=ctyun-eop-request-id;eop-date Signature="
                + signatureBase64;
    }

    /** 请求body存放模型 */
    private static class CtyunRequestBody {
        private final String mediaType;
        private final byte[] content;

        private CtyunRequestBody(String mediaType, byte[] content) {
            this.mediaType = mediaType;
            this.content = content;
        }
    }

    public String getEndpointName() {
        return endpointName;
    }
}
