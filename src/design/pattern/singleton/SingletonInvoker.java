package design.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonInvoker {

	static void callSingletonNotThreadSafe()
	{
		SingletonNotThreadSafe singleton = SingletonNotThreadSafe.getInstance();
		System.out.println("singleton not thread safe" + singleton);
	}

	static void callSingletonThreadSafe() {
		SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
		System.out.println("Singleton thread safe" + singleton);
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(SingletonInvoker::callSingletonNotThreadSafe);
		service.submit(SingletonInvoker::callSingletonNotThreadSafe);
		service.shutdown();

		ExecutorService service2 = Executors.newFixedThreadPool(2);
		service2.submit(SingletonInvoker::callSingletonThreadSafe);
		service2.submit(SingletonInvoker::callSingletonThreadSafe);
		service2.shutdown();

	}

}
