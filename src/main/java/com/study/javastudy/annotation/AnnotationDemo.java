package com.study.javastudy.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 定义：Java 标注，是 JDK5.0 引入的一种注释机制，可以通过反射获取标注内容，Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容。
 *
 * 注解分类：
 *      1、内置的注解:java自己定义的注解。
 *         @Override：检查该方法是否是重载方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
 *         @Deprecated：标记过时方法。如果使用该方法，会报编译警告。
 *         @SuppressWarnings：指示编译器去忽略注解中声明的警告。
 *         元注解（作用在注解上的注解）
 *         @Retention:标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
 *         @Documented:标记这些注解是否包含在用户文档中。
 *         @Target:标记这个注解应该是哪种 Java 成员。
 *         @Inherited：标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)。
 *         @SafeVarargs：Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
 *         @FunctionalInterface： Java 8 开始支持，标识一个匿名函数或函数式接口。
 *         @Repeatable： Java 8 开始支持，标识某注解可以在同一个声明上使用多次。
 *
 *
 * 作用：Annotation 是一个辅助类，它在 Junit、Struts、Spring 等工具框架中被广泛使用。
 *      1、编译检查：例如，@SuppressWarnings, @Deprecated 和 @Override 都具有编译检查作用。
 *      2、在反射中使用 Annotation：在反射中提供了很多关于注解的方法，可以在反射中解析并使用注解。
 *      3、根据 Annotation 生成帮助文档：通过给 Annotation 注解加上 @Documented 标签，能使该 Annotation 标签出现在 javadoc 中。
 *      4、通过自定义 Annotation 来实现一些功能：@interface
 *
 * 反射注解的工作原理总结：
 *      1、通过键值对的形式可以为注解属性赋值，像这样：@Hello（value = "hello"）。
 *      2、编译器将在编译期扫描每个类或者方法上的注解，会做一个基本的检查，你的这个注解是否允许作用在当前位置，最后会将注解信息写入元素的属性表。
 *      3、进行反射的时候，虚拟机将所有生命周期在RUNTIME的注解取出来放到一个 map 中，并创建一个 AnnotationInvocationHandler 实例，把这个 map 传递给它。
 *      4、虚拟机将采用JDK动态代理机制生成一个目标注解的代理类。
 *
 * 我理解的注解：是一种由jvm在不同的时机进行解释的标签，和反射结合使用，可以发挥更大的威力。
 *
 * @author wentianlou
 * @date 2019/12/3 19:45
 **/
public class AnnotationDemo {

    public static void main(String[] args) throws Exception{
        Person person = new Person();
        Class<Person> c = Person.class;
        Method mSomebody = c.getMethod("somebody", new Class[]{String.class, int.class});
        // 执行该方法
        mSomebody.invoke(person, new Object[]{"lily", 18});
        iteratorAnnotations(mSomebody);


        // 获取 somebody() 方法的Method实例
        Method mEmpty = c.getMethod("empty", new Class[]{});
        // 执行该方法
        mEmpty.invoke(person, new Object[]{});
        iteratorAnnotations(mEmpty);
    }

    public static void iteratorAnnotations(Method method) {
        // 判断方法是否包含MyAnnotation注解
        if(method.isAnnotationPresent(MyAnnotation.class)){
            // 获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for(String str:values){
                System.out.printf(str+", ");
            }
            System.out.println();
        }

        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            //可以获取注解上的内容(注解名称、注解内容)
            //@com.study.javastudy.annotation.MyAnnotation(value=[girl, boy])
            System.out.println("annotation:" + annotation);
        }
    }
}
