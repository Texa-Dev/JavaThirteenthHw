package task1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ManagerThread extends Thread {
    private final CountDownLatch latch;
    public ManagerThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
       // System.out.println("Manager");
        latch.countDown();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
