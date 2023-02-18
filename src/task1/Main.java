package task1;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {


    public static void main(String[] args) {
        Resources resources = new Resources();
        Random random = new Random();
        CountDownLatch latch = new CountDownLatch(3);
        int countMT = 0;

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


  /*
    import java.util.concurrent.CountDownLatch;

    public class Main {

        public static void main(String[] args) throws InterruptedException {
            CountDownLatch latch = new CountDownLatch(3);

            // создание "числовых" потоков
            for (int i = 0; i < 3; i++) {
                new NumericThread(latch).start();
            }

            // создание "управляющих" потоков
            for (int i = 0; i < 2; i++) {
                new ControlThread(latch).start();
            }

            // ждем, пока все потоки завершат работу
            Thread.sleep(5000);
        }
    }

    class NumericThread extends Thread {
        private CountDownLatch latch;

        public NumericThread(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            // увеличиваем значение общего ресурса на 1
            SharedResource.increment();
            System.out.println("Numeric thread incremented value to " + SharedResource.getValue());

            // блокируемся, пока не получим сигнал от "управляющего" потока
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ControlThread extends Thread {
        private CountDownLatch latch;

        public ControlThread(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            // отправляем сигнал "числовым" потокам
            latch.countDown();
            System.out.println("Control thread sent signal");

            // ждем 1 секунду, чтобы дать "числовым" потокам время на выполнение
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class SharedResource {
        private static int value = 0;

        public static void increment() {
            value++;
        }

        public static int getValue() {
            return value;
        }
    }
*/
}