package multithreading;

public class Example1Thread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted.");
            }
            if(i == 5){
                System.out.print("Times's up");
                System.exit(0);
            }
        }
    }
}
