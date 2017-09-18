package org.valuereporter.load;

import org.dummy.load.LoadThread;
import org.dummy.load.ObservedActivityThread;
import org.slf4j.Logger;
import org.valuereporter.ValuereporterException;
import org.valuereporter.activity.ObservedActivity;
import org.valuereporter.client.activity.ObservedActivityDistributer;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Hello world!
 *
 */
public class Main {
    private static final Logger log = getLogger(Main.class);
    private static final  int THREAD_POOL_DEFAULT_SIZE = 10;
    private ThreadPoolExecutor executor = null;
    private final ObservedActivityDistributer observedActivityDistributer;

    public Main() {
        observedActivityDistributer = ObservedActivityDistributer.getInstance();
        if (observedActivityDistributer == null) {
            throw new ValuereporterException("Failed to find ObservedActivityDistrubutor. It should have been setup via javaagent." +
                    " Please read the README.md for instructions.");
        }
        int threadPoolSize = THREAD_POOL_DEFAULT_SIZE;
        executor = new ThreadPoolExecutor(threadPoolSize,threadPoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    }

    protected void startLoad(){
        log.info("Starting new threads.");
        LoadThread loadThread = new LoadThread(1000);
        executor.submit(loadThread);
        ObservedActivityThread observedActivityThread = new ObservedActivityThread(1000);
        executor.submit(observedActivityThread);
    }

    public static void main( String[] args ) {
        Main main = new Main();
        main.startLoad();
    }
}
