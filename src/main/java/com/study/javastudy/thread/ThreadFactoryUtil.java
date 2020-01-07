package com.study.javastudy.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wentianlou
 * @date 2019/12/13 16:52
 **/
public class ThreadFactoryUtil {
    private static final ConcurrentHashMap<String, AtomicInteger> NAME_COUNT_MAP = new ConcurrentHashMap();

    public static ThreadFactory getSimpleNameThreadFactory(String name) {
        AtomicInteger count = (AtomicInteger)NAME_COUNT_MAP.get(name);
        if (count != null) {
            return buildThreadFactory(name, count);
        } else {
            synchronized(NAME_COUNT_MAP) {
                count = (AtomicInteger)NAME_COUNT_MAP.get(name);
                if (count == null) {
                    count = new AtomicInteger(0);
                    NAME_COUNT_MAP.put(name, count);
                }
            }

            return buildThreadFactory(name, count);
        }
    }

    private static ThreadFactory buildThreadFactory(String name, AtomicInteger counter) {
        return (r) -> {
            Thread thread = new Thread(r);
            thread.setName(name + "-" + counter.incrementAndGet());
            return thread;
        };
    }
}
