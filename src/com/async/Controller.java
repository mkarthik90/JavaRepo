package com.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Controller {

    public static void main(String[] args) throws Exception {
        AsyncService asyncService1 = new AsyncService(1);
        AsyncService asyncService2 = new AsyncService(2);
        AsyncService asyncService3 = new AsyncService(3);
        FutureTask<String> futureTask1 = new FutureTask<String>(asyncService1);
        FutureTask<String> futureTask2 = new FutureTask<String>(asyncService2);
        FutureTask<String> futureTask3 = new FutureTask<String>(asyncService3);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        executor.execute(futureTask3);
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
    }

}
