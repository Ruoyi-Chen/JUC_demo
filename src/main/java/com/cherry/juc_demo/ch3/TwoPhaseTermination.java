package com.cherry.juc_demo.ch3;

import lombok.extern.slf4j.Slf4j;
@Slf4j(topic = "c.TwoPhaseTermination")
public class TwoPhaseTermination {
    private Thread monitor;

    // 启动监控线程
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000); // 情况1
                    log.debug("执行监控记录"); // 情况2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // sleep中被打断后会清除打断标记
                    current.interrupt(); // 重新设置打断标记
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }

}

@Slf4j(topic = "c.Test3")
class Test3{
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();

        Thread.sleep(3000);

        twoPhaseTermination.stop();
    }

}