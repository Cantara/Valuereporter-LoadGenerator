package org.valuereporter.load;

/**
 * Created by baardl on 26.07.15.
 */
public class LoadThread implements Runnable {

    private final int sleepMillis;

    public LoadThread(int sleepMillis) {
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        do {
            System.out.println("Hello You at " + System.currentTimeMillis());
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                //sleep interupted
            }
        } while (true);
    }
}
