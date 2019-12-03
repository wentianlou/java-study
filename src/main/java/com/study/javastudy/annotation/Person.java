package com.study.javastudy.annotation;

/**
 * @author wentianlou
 * @date 2019/12/3 20:16
 **/
public class Person {
    /**
     * @Deprecated，意味着empty()方法，不再被建议使用
     * @MyAnnotation, 意味着empty() 方法对应的MyAnnotation的value值是默认值"unknown"
     */
    @MyAnnotation
    @Deprecated
    public void empty(){
        System.out.println("empty");
    }


    /**
     * @MyAnnotation(value={"girl","boy"}), 意味着MyAnnotation的value值是{"girl","boy"}
     */
    @MyAnnotation(value={"girl","boy"})
    public void somebody(String name, int age){
        System.out.println("somebody: "+name+", "+age);
    }
}
