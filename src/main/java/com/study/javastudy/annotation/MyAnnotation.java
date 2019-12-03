package com.study.javastudy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wentianlou
 * @date 2019/12/3 20:15
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value() default "unknown";
}
