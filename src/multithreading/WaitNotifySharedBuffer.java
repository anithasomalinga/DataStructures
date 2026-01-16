package multithreading;

public class WaitNotifySharedBuffer {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        try {
            while (hasData) {
                wait(); // wait this consumer consumes
            }
            data = value;
            hasData = true;
            System.out.println("Produced: " + value);
            notify(); // notify consumer
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public synchronized void consume() {
        try {
            while (!hasData) {
                wait(); // wait until producer produces
            }
            System.out.println("Consumed: " + data);
            hasData = false;
            notify(); // notify producer
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
