package com.study.javastudy.thread;

/**
 * volatile关键字demo
 * @author wentianlou
 * @date 2020/1/7 19:40
 **/
public class VolatileDemo extends Thread{
    volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning){

        }
        System.out.println("线程被停止了!");
    }

    public static void main(String[] args) {
        try {
            VolatileDemo demo = new VolatileDemo();
            demo.start();
            Thread.sleep(1000);
            demo.setRunning(false);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
