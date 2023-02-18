package task1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {


    public static void main(String[] args) {
        Resources resources = new Resources();
        Random random = new Random();
        CountDownLatch latch = new CountDownLatch(3);
        int countMT = 0;  //число управляющих потоков

        do {
            Thread thread = threadMaker(random, resources, latch);
            thread.start();
            if (thread.getClass() == ManagerThread.class) countMT++;


        } while (countMT < 3);

        System.out.println("Resource value: " + resources.val);

    }

    static Thread threadMaker(Random random, Resources res, CountDownLatch latch) {
        int choose = random.nextInt(0, 5); //тут поставил от 0 до 5 чтобы было больше числовых потоков
        if (choose == 0) return new ManagerThread(latch);
        else return new NumericThread(res, latch);

    }

}