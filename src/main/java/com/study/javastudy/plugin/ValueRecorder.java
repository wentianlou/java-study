package com.study.javastudy.plugin;

/**
 * 用于返回特定类型对象日志记录字符串
 */
public interface ValueRecorder {

    String record(Object obj);

    boolean test(Class clazz);

}
