package cn.ctyun.sdk;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // 禁用在遇到空的Bean类时抛出异常
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // 禁用在遇到未知属性时抛出异常
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 不序列化transient修饰的字段
        OBJECT_MAPPER.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);

        // 不序列化null的对象
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 获取objectMapper
     *
     * @return objectMapper实例
     */
    public static ObjectMapper getObjectMapperInstance() {
        return OBJECT_MAPPER;
    }
}
