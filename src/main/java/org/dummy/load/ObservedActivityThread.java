package org.dummy.load;

import org.slf4j.Logger;
import org.valuereporter.activity.ObservedActivity;
import org.valuereporter.client.MonitorReporter;

import static org.slf4j.LoggerFactory.getLogger;
import static org.valuereporter.activity.ObservedActivity.Builder.observe;

/**
 * Created by baardl on 18.09.17.
 */
public class ObservedActivityThread implements Runnable {
    private static final Logger log = getLogger(ObservedActivityThread.class);

    private final int sleepMillis;

    public ObservedActivityThread(int sleepMillis) {
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
        ObservedActivity observedActivity = observe("dummy-load").setActivityName("visibleLoad").build();
        MonitorReporter.reportActivity(observedActivity);
        log.trace("ObservedActivity: {} ", observedActivity.toString());
    }

}
