package com.study.javastudy.annotation;

import java.lang.annotation.*;

/**
 * Annotation 实现类的语法定义
 * @interface: 声明一个注解
 *
 * @Documented: 可以出现在 javadoc 中
 * @Target(ElementType.TYPE) :指定 Annotation 的类型属性
 * @Retention(RetentionPolicy.RUNTIME) : 指定 Annotation 的策略属性。
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {

}
