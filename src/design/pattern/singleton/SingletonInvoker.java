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

	static void callSingletonThreadSafeElegant() {
		SingletonThreadSafeElegant singleton = SingletonThreadSafeElegant.getInstance();
		System.out.println("Singleton thread safe elegant" + singleton);

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

		ExecutorService service3 = Executors.newFixedThreadPool(2);
		service3.submit(SingletonInvoker::callSingletonThreadSafeElegant);
		service3.submit(SingletonInvoker::callSingletonThreadSafeElegant);
		service3.shutdown();

	}
}
