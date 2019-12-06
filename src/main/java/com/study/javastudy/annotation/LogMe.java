package com.study.javastudy.annotation;

import java.lang.annotation.*;

/**
 * 此注解用于表示被标注的类或方法需要记录方法开始和结束日志
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogMe {
    /**
     * 是否记录方法的参数
     */
    boolean logParam() default false;

    /**
     * 是否记录返回值
     */
    boolean logReturn() default false;

    /**
     * 传递到日志中的信息
     */
    String info() default "";
}
