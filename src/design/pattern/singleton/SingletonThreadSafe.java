package design.pattern.singleton;

public class SingletonThreadSafe {

	// If eagerly created, then there is no problem with thread safe
	// public static SingletonThreadSafe s = new SingletonThreadSafe();
	// But it is always recommended to do lazy loading.

	public static SingletonThreadSafe singletonThreadSafe = null;

	private SingletonThreadSafe() {
		
	}

	/**
	 * Synchronized helps to allow only one thread at a time
	 * 
	 * @return
	 */
	public static synchronized SingletonThreadSafe getInstance() {
		if (singletonThreadSafe == null) {
			singletonThreadSafe = new SingletonThreadSafe();
		}
		return singletonThreadSafe;
	}

}
