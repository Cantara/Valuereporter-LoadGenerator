package org.dummy.load;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by baardl on 26.07.15.
 */
public class LoadThread implements Runnable {
    private static final Logger log = getLogger(LoadThread.class);

    private final int sleepMillis;

    public LoadThread(int sleepMillis) {
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        do {
            performVisibleLoad();
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                //sleep interupted
            }
        } while (true);
    }

    public void performVisibleLoad() {
        log.trace("Hello You at " + System.currentTimeMillis());
    }
}
