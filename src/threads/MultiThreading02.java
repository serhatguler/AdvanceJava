package threads;

public class MultiThreading02 {
    public static int counter=0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" Calismaya basladi");
                Counter.count();
                System.out.println("burada baska kodlar var");
            }
        });
        thread1.setName("Tom");
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //thread1.join(); tum islemlerin beklemeye gerek yok
                System.out.println(Thread.currentThread().getName()+" Calismaya basladi");
                Counter.count();
                System.out.println("burada ortak dataya erismeyen kodlar var");
            }
        });
        thread2.setName("Jerry");
        thread2.start();


    }
}

class Counter{
    //counter degiskenin  degerini 1000 kez artirip yazdiralim
    //synchronized ile metoda erisen threadleri siraya koymus oluruz
    //bu metoda sadece bir tane thread erissin
    public synchronized static void count(){
        for (int i = 1; i <= 1000; i++) {
            MultiThreading02.counter++;
        }
        System.out.println(Thread.currentThread().getName()+ "Counter: "+MultiThreading02.counter);//beklenen deger 2000
    }

}