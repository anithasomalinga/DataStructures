package designpattern.creational.singleton;

public class MySingleton {

    // Early initialization
    private static final MySingleton eagerInstance = new MySingleton();

    private static MySingleton staticInstance;

    static {
        staticInstance = new MySingleton();
    }

    private static MySingleton instance;

    private MySingleton() {}

    // Lazy initialization
    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    // Thread safe singleton - synchronized method - costly
    public synchronized static MySingleton getInstance1() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    // Thread safe singleton - double locking - synchronized block
    public static MySingleton getInstance2() {
        if (instance == null) {
            synchronized(MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }

}
