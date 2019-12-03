package com.study.javastudy.annotation;

/**
 * 定义：JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性。
 *      这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。
 *      jvm会给每个类，创建一个Class类型的对象，来记录各个类的信息，包括类的名称，类有哪些属性，各个属性的类型，类有哪些方法，各个方法的名称参数列表返回值等。
 *
 * 相关类：
 *      Class类	代表类的实体，在运行的Java应用程序中表示类和接口
 *      Field类	代表类的成员变量（成员变量也称为类的属性）
 *      Method类	代表类的方法
 *      Constructor类	代表类的构造方法
 *
 * 作用：1、可以在运行时动态获取类的类型信息，包括成员变量信息、类的方法、类的构造方法信息、类方法上的注解等信息。
 *      2、开发各种通用框架，在spring中，从容器中获取Bean来依赖注入时，容器会读取配置，而配置中给的就是类的信息，spring根据这些类信息动态的创建这些类对象。
 *      3、反射可以和注解结合实现一些aop编程。
 *
 * @author wentianlou
 * @date 2019/12/2 20:16
 **/
public class ReflexDemo {
    public static void main(String[] args) {
        try {
            // 创建对象
            ReflectClass.reflectNewInstance();

            // 反射私有的构造方法
            ReflectClass.reflectPrivateConstructor();

            // 反射私有属性
            ReflectClass.reflectPrivateField();

            // 反射私有方法
            ReflectClass.reflectPrivateMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("...end...");
    }
}
