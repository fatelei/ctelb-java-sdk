package cn.ctyun.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EndpointRegistry {

    private String defaultUrl;
    private Map<String, String> mapping;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private EndpointRegistry() {}

    /**
     * 构建端点注册中心
     *
     * @param defaultUrl 默认url
     * @return 端点注册中心
     */
    public static EndpointRegistry defaultEndpointRegistry(String defaultUrl) {
        EndpointRegistry endpointRegistry = new EndpointRegistry();
        endpointRegistry.mapping = new HashMap<>(0);
        endpointRegistry.defaultUrl = defaultUrl;
        return endpointRegistry;
    }

    /**
     * 构建端点注册中心
     *
     * @return 端点注册中心
     */
    public static EndpointRegistry defaultEndpointRegistry() {
        return defaultEndpointRegistry(null);
    }

    /**
     * 获取端点信息
     *
     * @param endpointName 名称
     * @return 获取端点信息
     */
    public String getEndpointUrl(String endpointName) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        String result = this.mapping.getOrDefault(endpointName, this.defaultUrl);
        readLock.unlock();
        return result;
    }

    /**
     * 注册端点
     *
     * @param endpoint 端点
     */
    public void register(Endpoint endpoint) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        if (this.mapping.containsKey(endpoint.name)) {
            throw new IllegalArgumentException(
                    "endpoint name: [" + endpoint.name + "] already registered!");
        }
        this.mapping.put(endpoint.name, endpoint.url);
        writeLock.unlock();
    }
}
