package com.study.javastudy.cache;

/**
 * 定义：ehcache的是将数据放入jvm内存中，也就是说当次缓存在本次服务器启动期间有效，下次服务器启动将会失效。
 *
 * ehcache缓存的3种清空策略：
 *  1 FIFO，先进先出
 *  2 LFU，最少被使用，缓存的元素有一个hit属性，hit值最小的将会被清出缓存。
 *  3 LRU，最近最少使用的，缓存的元素有一个时间戳，当缓存容量满了，而又需要腾出地方来缓存新的元素的时候，
 *         那么现有缓存元素中时间戳离当前时间最远的元素将被清出缓存。
 *
 * ehcache参数配置：
 *      maxInMemory - 设定内存中创建对象的最大值。
 *      eternal - 设置元素是否永久驻留。如果是，将忽略超时限制且元素永不消亡。
 *      timeToIdleSeconds - 设置某个元素消亡前的停顿时间。也就是在一个元素消亡之前，两次访问时间的最大时间间隔值。这只能在元素不是永久驻留时有效，如果对象永恒不灭，则设置该属性也无用。
 *                          如果该值是 0 就意味着元素可以停顿无穷长的时间。
 *      timeToLiveSeconds - 为元素设置消亡前的生存时间。也就是一个元素从构建到消亡的最大时间间隔值。这只能在元素不是永久驻留时有效。
 *      overflowToDisk - 设置当内存中缓存达到maxInMemory 限制时元素是否可写到磁盘上。
 *
 * 引入pom：
 *  <dependency>
 *         <groupId>org.springframework.boot</groupId>
 *         <artifactId>spring-boot-starter-cache</artifactId>
 *     </dependency>
 *
 * @author wentianlou
 * @date 2019/12/6 11:05
 **/
public class EhCacheDemo {
}
