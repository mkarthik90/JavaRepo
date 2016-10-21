package design.pattern.singleton;

public class SingletonNotThreadSafe {

	// If at class loading this singleton is not created. Then singleton cannot
	// be created at all
	// public static Singleton singleton = new Singleton();
	// So having it as null

	public static SingletonNotThreadSafe singleton = null;

	private SingletonNotThreadSafe() {
	}

	public static SingletonNotThreadSafe getInstance() {
		if (singleton == null) {
			singleton = new SingletonNotThreadSafe();
		}
		return singleton;
	}

}
