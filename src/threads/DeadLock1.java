package threads;

public class DeadLock1 {
    public static void main(String[] args) {
        final String lock1 = "lock1";
        final String lock2 = "lock2";

        Thread tread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock1) {
                    System.out.println("Thread1 has locked String lock1");

                    try {
                        Thread.sleep(1000); //burada bekledigimiz icin thread2 calisiyor
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) { // Thread2 already locked lock2
                        System.out.println("Thread1 has locked String lock2");
                    }

                }

            }
        });
        tread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock2) { //lock2 ye thread2 erisiyor. bu yuzden thread1 icindeki lock2 calismaz.
                    System.out.println("Thread2 has locked String lock2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock1) { // Thread1 already locked lock1
                        System.out.println("Thread2 has locked String lock1");
                    }


                }

            }
        });

        thread2.start();

    }
}
