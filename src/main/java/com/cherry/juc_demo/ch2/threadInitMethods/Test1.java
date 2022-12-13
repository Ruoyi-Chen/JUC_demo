package com.cherry.juc_demo.ch2.threadInitMethods;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("running..");
            }
        };
        t1.start();
    }




}
