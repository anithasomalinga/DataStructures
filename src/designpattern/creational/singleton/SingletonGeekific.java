package designpattern.creational.singleton;

public class SingletonGeekific {

    private static volatile SingletonGeekific instance;
    private String data;
    private SingletonGeekific(String data) {
        this.data = data;
    }
    /*private static SingletonGeekific getInstance(String data) {
        if (instance == null) { // volatile read #1
            synchronized (SingletonGeekific.class) {
                if (instance == null) { // volatile read #2
                    instance = new SingletonGeekific(data); // volatile write
                }
            }
        }
        return instance; // volatile read #3
    }*/
    //################# Local Variable Optimization for Volatile Read Performance@###################
    private static SingletonGeekific getInstance(String data) {
        SingletonGeekific result = instance;    //volatile read #1  -> cached locally
        if (result == null) {
            synchronized (SingletonGeekific.class) {
                result = instance; // volatile read #2
                if (result == null) {
                    result = instance = new SingletonGeekific(data); // volatile write
                }
            }
        }
        return result; // just a local var — no volatile read
    }

    /**
     *
     10:32 AM
     Difference: Local Variable Optimization for Volatile Read Performance
     Both implement double-checked locking, but differ in how they handle the volatile field.

     Commented-out version
     java
     if (instance == null) {                    // volatile read #1
     synchronized (...) {
     if (instance == null) {            // volatile read #2
     instance = new SingletonGeekific(data);  // volatile write
     }
     }
     }
     return instance;                           // volatile read #3
     Accesses the volatile field 3 times in the common (already-initialized) path.

     Active version
     java
     SingletonGeekific result = instance;       // volatile read #1 → cached locally
     if (result == null) {
     synchronized (...) {
     result = instance;                 // volatile read #2
     if (result == null) {
     result = instance = new SingletonGeekific(data);
     }
     }
     }
     return result;                             // just a local var — no volatile read
     Accesses volatile only once in the common path (when already initialized).

     Why this matters
     volatile reads/writes are more expensive than regular ones — they bypass CPU caches and enforce memory visibility guarantees. After the singleton is initialized (which is 99.99% of calls), the active version:

     Copies instance into the local result once
     All subsequent checks and the return use the cheap local variable
     Avoids redundant volatile reads on the hot path
     Summary table
     Commented	Active
     Pattern	Double-checked locking	Double-checked locking
     Volatile reads (initialized)	3	1
     Extra local variable	No	Yes (result)
     Thread-safe	✅	✅
     Performance (hot path)	Slower	Faster
     This is a well-known micro-optimization documented in Effective Java (Bloch, Item 83) — the local variable trick is described explicitly as a way to improve performance of double-checked locking on volatile fields.
     */
}
