package com.study.javastudy.plugin;

/**
 * 参数记录器，使用场景: 比如传进的参数是密码，可以实现记录器返回其他字符串
 */
public interface ParameterRecorder {

    String record(String paramName, Object obj);

    boolean test(String paramName, Class valueClazz);

}
