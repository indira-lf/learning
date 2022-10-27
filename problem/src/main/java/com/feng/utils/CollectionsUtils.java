package com.feng.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author
 * @time 2022/10/27 21:41
 * @Description- 集合工具类
 */
public class CollectionsUtils {
    /**
     * 多个list合并成一个list
     */
    public static List<?> mergeLists(List<?> ...lists) {
        return Arrays.stream(lists).flatMap(List::stream).collect(Collectors.toList());
    }

    /**
     * 多个map合并
     */
    public static <K, V> Map mergeMaps(Map<K, V>... maps) {
        Class clazz = maps[0].getClass(); // 获取传入map的类型
        Map<K, V> map = null;
        try {
            map = (Map) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0, len = maps.length; i < len; i++) {
            map.putAll(maps[i]);
        }
        return map;
    }

}
