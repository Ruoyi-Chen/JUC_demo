package com.cherry.juc_demo.ch2.threadInitMethods;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Test3")
public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                log.info("running...");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread t3 = new Thread(futureTask,"t3");
        t3.start();
        // 阻塞等待
        log.debug("{}", futureTask.get());
    }
}
