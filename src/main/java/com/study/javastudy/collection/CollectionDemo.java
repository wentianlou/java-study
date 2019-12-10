package com.study.javastudy.collection;

import java.util.*;

/**
 * Java集合框架
 * 1、接口和实现分离,队列可以用数组实现也可以用链表实现，都实现同一个接口。
 * 2、集合类的基本接口是Collection类。
 * 3、Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
 * 4、List , Set, Map都是接口，前两个继承至Collection接口，Map为独立接口。
 *    Set：HashSet，LinkedHashSet，TreeSet。
 *    List：ArrayList，Vector，LinkedList
 *    Map：Hashtable，LinkedHashMap，HashMap，TreeMap
 *
 *
 * List 有序,可重复
 * ArrayList
 * 优点: 底层数据结构是数组，查询快，增删慢。
 * 缺点: 线程不安全，效率高
 * Vector
 * 优点: 底层数据结构是数组，查询快，增删慢。
 * 缺点: 线程安全，效率低
 * LinkedList
 * 优点: 底层数据结构是链表，查询慢，增删快。
 * 缺点: 线程不安全，效率高
 *
 *
 * @author wentianlou
 * @date 2019/12/7 11:22
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //map.keySet():取所有的key, map.get(key) 取值
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //Map.entrySet.iterator() 获取Iterator对象，然后再利用Iterator对象获取key、value
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //map.entrySet(),推荐容量大时使用
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //map.values,直接遍历值，不能遍历key
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

        //根据key直接读取值
        System.out.println(map.get("1"));

        Vector<Object> objects = new Vector<>();
        objects.add(100);
        objects.add(200);
        objects.add(300);
        objects.addElement(400);
        for (Object o : objects){
            System.out.println("o:" + o);
        }

        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);
        System.out.println("hashSet length="+hashSet.size());

        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(1);
        System.out.println("treeSet length="+treeSet.size());

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("1","100");
        linkedHashMap.put(null,null);
    }

}
