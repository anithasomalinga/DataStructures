package multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WaitNotifySharedBuffer buffer = new WaitNotifySharedBuffer();
        Thread producerThread = new Thread(() -> {
            for(int i = 1; i<=5;i++){
                buffer.produce(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        });
        Thread consumerThread = new Thread(() -> {
            for(int i = 1; i<=5;i++){
                buffer.consume();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {

                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
