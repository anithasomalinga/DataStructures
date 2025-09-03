package multithreading;

public class DeadlockTest {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();
    public static void main(String[] args) {
        Thread t1 = processThread1();
        Thread t2 = processThread2();
        t1.start();
        t2.start();
        // Locks Resource 1 and 2 are in circular dependency
    }
    private static Thread processThread1() {
        return new Thread(() -> {
            System.out.println("Inside processThread1");
            System.out.println("Thread1 is trying to acquire lock on Resource1");
            synchronized (resource1) {
                System.out.println("Thread1 acquired lock on Resource1");
                System.out.println("Thread1 sleeping for 5 seconds");
                sleep(1000);
                System.out.println("Thread1 is trying to acquire lock on Resource2");

                synchronized (resource2) {
                    System.out.println("Thread1 acquired lock on Resource2");
                }
                System.out.println("Thread1 released lock on Resource2");
            }
            System.out.println("Thread1 released lock on Resource1");
        });
    }

    private static Thread processThread2() {
        return new Thread(() -> {
            System.out.println("Inside processThread2");
            System.out.println("Thread2 is trying to acquire lock on Resource2");
            synchronized (resource2) {
                System.out.println("Thread2 acquired lock on Resource2");
                System.out.println("Thread2 sleeping for 5 seconds");
                sleep(1000);
                System.out.println("Thread2 is trying to acquire lock on Resource1");
                synchronized (resource1) {
                    System.out.println("Thread2 acquired lock on Resource1");
                }
                System.out.println("Thread2 released lock on Resource1");
            }
            System.out.println("Thread2 released lock on Resource2");
        });
    }
    private static void sleep(int timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            System.out.printf("Thread sleep interrupted");
        }
    }
}
