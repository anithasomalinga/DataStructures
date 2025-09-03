package multithreading;

import java.util.Scanner;

public class Example1 {
    // This implementation sleeps the main thread
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have 5 seconds to enter your name.");
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted.");
            }
            if(i == 5){
                System.out.print("Times's up");
            }
        }
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s!", name);

        scanner.close();
    }*/

    public static void main(String[] args) {
        int coreThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Core threads: " + coreThreads);
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have 5 seconds to enter your name.");
        Example1Thread runnable = new Example1Thread();
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s!", name);

        scanner.close();
    }
}
