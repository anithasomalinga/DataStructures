package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileExample {
    public static void main(String[] args) {

        final VolatileExampleHelper helper = new VolatileExampleHelper();
        final int threads = 20;
        final int iter = 10000;
            try(final ExecutorService executorService = Executors.newFixedThreadPool(threads)) {
            for(int t = 0; t < threads; t++) {
                    executorService.submit(()->{
                        for(int i = 0; i < iter; i++) {
                            helper.increment();
                        }
                    });
                }
            System.out.println(helper.getCounter());
        }
    }
    public void testWait() throws InterruptedException {
        wait();
    }
}
