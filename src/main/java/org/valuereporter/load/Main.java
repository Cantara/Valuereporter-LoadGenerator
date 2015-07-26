package org.valuereporter.load;

import org.dummy.load.LoadThread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class Main {
    private static final  int THREAD_POOL_DEFAULT_SIZE = 10;
    private ThreadPoolExecutor executor = null;

    public Main() {
        int threadPoolSize = THREAD_POOL_DEFAULT_SIZE;
        executor = new ThreadPoolExecutor(threadPoolSize,threadPoolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    }

    protected void startLoad(){
        LoadThread loadThread = new LoadThread(1000);
        executor.submit(loadThread);
    }

    public static void main( String[] args ) {
        Main main = new Main();
        main.startLoad();
    }
}
