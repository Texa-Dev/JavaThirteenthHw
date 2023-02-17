package pack;

import java.util.concurrent.CountDownLatch;

public class Main {


    public static void main(String[] args) {
        Resources resources = new Resources();


        CountDownLatch latch = new CountDownLatch(3);
        try {



        } catch (Exception e) {
            e.printStackTrace();
        }

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