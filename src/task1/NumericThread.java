package task1;

import java.util.concurrent.CountDownLatch;

public class NumericThread extends Thread {
    private final Resources resources;
    private final CountDownLatch latch;

    public NumericThread(Resources res, CountDownLatch latch) {
        this.resources=res;
        this.latch=latch;
    }
    @Override
    public void run() {
        resources.val++;
       // System.out.print("Numeric, value: " +resources.val+"\n");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
