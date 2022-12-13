package com.cherry.juc_demo.ch3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test6")
public class BoilTea {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.debug("烧开水");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "AA");

        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶");
            Sleeper.sleep(1);
            log.debug("洗茶杯");
            Sleeper.sleep(2);
            log.debug("拿茶叶");
            Sleeper.sleep(1);
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("泡茶");
        }, "BB");

        t1.start();
        t2.start();
    }
}


class Sleeper {
    public static void sleep(long millis){
        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        try{
            sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}