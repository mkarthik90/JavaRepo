package design.pattern.singleton;

public class SingletonThreadSafeElegant {

    private static volatile SingletonThreadSafeElegant singletonThreadSafeElegant = null;

    private SingletonThreadSafeElegant() {

    }

    public static SingletonThreadSafeElegant getInstance() {
        if (singletonThreadSafeElegant == null) { // check 1
            synchronized (SingletonThreadSafeElegant.class) {
                if (singletonThreadSafeElegant == null) { // check 2
                    // Sometimes it will take lot of time to create the object.
                    // So when thread 2 checks for singletonThreadSafeElegant in
                    // check 1, thread 2 will see singletonThreadSafeElegant is
                    // not null, but that object will be half initialized and
                    // thread 2 will return a half initialized object
                    // To prevent this we declare the object as volatile. So
                    // when it is volatile, if the object is initializing we get
                    // a null and in check 2 the object would be completely
                    // initialized
                    singletonThreadSafeElegant = new SingletonThreadSafeElegant();
                }
            }
        }
        return singletonThreadSafeElegant;
    }

}
