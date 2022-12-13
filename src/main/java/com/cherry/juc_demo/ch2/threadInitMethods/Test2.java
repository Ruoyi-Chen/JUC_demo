package com.cherry.juc_demo.ch2.threadInitMethods;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                log.info("hi..t2 running..");
            }
        };

        Thread t2 = new Thread(r, "t2");
        t2.start();


        // lambda
        Runnable r2 = () -> log.info("lambda t2 running..");
        Thread t3 = new Thread(r2, "t2");
        t3.start();


    }
}
