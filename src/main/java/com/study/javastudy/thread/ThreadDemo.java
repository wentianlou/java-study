package com.study.javastudy.thread;

import java.util.concurrent.*;

/**
 * @author wentianlou
 * @date 2019/12/13 16:02
 **/
public class ThreadDemo {
    private ExecutorService executorService;

    public ThreadDemo(){
        this.executorService = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                ThreadFactoryUtil.getSimpleNameThreadFactory("ThreadDemo"));
    }

    public void addTask(Runnable task){
        this.executorService.submit(task);
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        for(int i = 0; i < 20; i++){
            Task task = new Task();
            demo.addTask(task);
        }
    }
}
