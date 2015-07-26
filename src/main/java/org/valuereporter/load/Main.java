package org.valuereporter.load;

import org.dummy.load.LoadThread;
import org.slf4j.Logger;

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

    public Main() {
        int threadPoolSize = THREAD_POOL_DEFAULT_SIZE;
        executor = new ThreadPoolExecutor(threadPoolSize,threadPoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    }

    protected void startLoad(){
        log.info("Starting new thread.");
        LoadThread loadThread = new LoadThread(1000);
        executor.submit(loadThread);
    }

    public static void main( String[] args ) {
        Main main = new Main();
        main.startLoad();
    }
}
