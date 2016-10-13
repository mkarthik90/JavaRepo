package com.async;

import java.util.concurrent.Callable;

public class AsyncService implements Callable<String> {

    private int threadNumber = 0;

    public AsyncService(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Runniing thread " + this.threadNumber);
        Thread.sleep(10000);
        System.out.println("Exiting from thread " + this.threadNumber);
        return "Thread Name " + threadNumber;
    }
}
