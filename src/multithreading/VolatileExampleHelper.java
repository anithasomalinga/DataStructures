package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileExampleHelper {
    private final AtomicInteger counter = new AtomicInteger();
    public void increment(){
     this.counter.incrementAndGet();
    }
    public int getCounter(){
        return this.counter.get();
    }
}
