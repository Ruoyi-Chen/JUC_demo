package com.cherry.juc_demo.ch2.交替执行;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMultiThread {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                log.info("t1");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                log.info("t2");
            }
        }).start();
    }
}
