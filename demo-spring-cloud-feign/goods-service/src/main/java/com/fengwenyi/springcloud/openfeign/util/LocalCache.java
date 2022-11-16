package com.fengwenyi.springcloud.openfeign.util;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-16
 */
public class LocalCache {

    private static final ConcurrentMap<String, ConcurrentMap<String, Object>> map = new ConcurrentHashMap<>();

    public static void set(String bizCode, String key, Object data) {
        ConcurrentMap<String, Object> dataMap = map.get(bizCode);
        if (CollectionUtils.isEmpty(dataMap)) {
            dataMap = new ConcurrentHashMap<>();
        }
        dataMap.put(key, data);
        map.put(bizCode, dataMap);
    }

    public static Object get(String bizCode, String key) {
        ConcurrentMap<String, Object> dataMap = map.get(bizCode);
        if (CollectionUtils.isEmpty(dataMap)) {
            return null;
        }
        return dataMap.get(key);
    }

    public static List<Object> get(String bizCode) {
        ConcurrentMap<String, Object> dataMap = map.get(bizCode);
        if (CollectionUtils.isEmpty(dataMap)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(dataMap.values());
    }

    public static void delete(String bizCode, String key) {
        ConcurrentMap<String, Object> dataMap = map.get(bizCode);
        if (CollectionUtils.isEmpty(dataMap)) {
            return;
        }
        dataMap.remove(key);
    }

    public static void deleteBiz(String bizCode) {
        map.remove(bizCode);
    }

    public static void deleteAll() {
        if (CollectionUtils.isEmpty(map)) {
            return;
        }
        for (Map.Entry<String, ConcurrentMap<String, Object>> entry : map.entrySet()) {
            map.remove(entry.getKey());
        }
    }
}
