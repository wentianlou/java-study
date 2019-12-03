package com.study.javastudy.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wentianlou
 * @date 2019/12/2 20:23
 **/
public class ReflectClass {
    private final static String TAG = "com.study.javastudy.annotation.ReflectClass--";

    /**
     * 创建Book对象
     */
    public static void reflectNewInstance() {
        try {
            //根据类名返回类的对象(这个对象记录了这个类的类型信息,所有属性和方法)
            Class<?> classBook = Class.forName("com.study.javastudy.annotation.Book");
            //创建一个实例
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("Jave学习");
            book.setAuthor("61教授");
            System.out.println(TAG + "reflectNewInstance book = " + book.toString());

            Annotation[] annotations = classBook.getDeclaredAnnotations();
            System.out.println("annotations len:" + annotations.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有的构造方法
     */
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.study.javastudy.annotation.Book");
            //获得该类中与参数类型匹配的构造方法，可以是私有构造方法
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            //在java的反射使用中,如果字段是私有的,那么必须要对这个字段设置为true，否则会抛IllegalAccessException异常
            declaredConstructorBook.setAccessible(true);
            //调用私有的构造方法生成对象
            Object objectBook = declaredConstructorBook.newInstance("Jave学习2","61教授2");
            Book book = (Book) objectBook;
            System.out.println(TAG + "reflectPrivateConstructor book =" + book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有属性
     */
    public static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.study.javastudy.annotation.Book");
            Object objectBook = classBook.newInstance();
            //获得某个属性对象
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println(TAG + "reflectPrivateField tag = " + tag);

            //获得所有属性对象
            Field[] allField = classBook.getDeclaredFields();
            for (Field field : allField){
                System.out.println(TAG + "field = " + field.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有方法
     */
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.study.javastudy.annotation.Book");
            //获得该类某个方法
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook,0);
            System.out.println(TAG + "reflectPrivateMethod string = " + string);

            //获得该类所有方法(不包括构造方法)
            Method[] methods = classBook.getDeclaredMethods();
            for (Method method : methods){
                System.out.println(TAG + "Method string = " + method.getName());
            }

            //获得该类所有公有的方法,包括Object对象的共有方法
            methods = classBook.getMethods();
            for (Method method : methods){
                System.out.println(TAG + "Method string2 = " + method.getName());
            }

            //获得该类的所有公有构造方法
            classBook.getConstructors();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
