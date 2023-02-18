package task2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    static int counter;
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        Random rnd = new Random();

        while (true) {
            int threadCount = rnd.nextInt(6)+1;
            for (int i = 0; i < threadCount; i++) {
                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println("Th acquire " + counter);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                        System.out.println("Th release " + counter++);
                    }
                }).start();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
