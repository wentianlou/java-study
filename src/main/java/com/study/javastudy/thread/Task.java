package com.study.javastudy.thread;

/**
 * @author wentianlou
 * @date 2019/12/13 16:05
 **/
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("task start -- " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        System.out.println("task end -- " + Thread.currentThread().getName());
    }
}
