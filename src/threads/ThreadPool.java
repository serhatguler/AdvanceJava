package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Threadler oldukca maliyetli yapilardir.
CPU,memory de kaynak ayrilir.
Bu sebeple ayni anda aktif olarak kullanmak istedigimiz threadlerin sayisini sinirlandirabiliriz
Threadpool maliyeti azaltir,CPU ya asiri yuklenmeyi onler
Yeni bir Thread olusturmak yerine Belirtilen sayidaki threadin bir kere baslatilarak tekrar tekrar kullanilmasini saglar.
 */
public class ThreadPool {

    public static void main(String[] args) {

        //Thread pool olusturalim.6 tane Thread maliyetli bu yuzden az thread olusturup farkli gorevleri verelim
        ExecutorService service =Executors.newFixedThreadPool(2);//6 gorevi 2 tane Thread yapsin.

        ThreadCreator thread1 = new ThreadCreator("A");
        ThreadCreator thread2 = new ThreadCreator("B");
        ThreadCreator thread3 = new ThreadCreator("C");
        ThreadCreator thread4 = new ThreadCreator("D");
        ThreadCreator thread5 = new ThreadCreator("E");
        ThreadCreator thread6 = new ThreadCreator("F");
        //THREADLERI BASLATALIM
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);

        service.shutdown();//kapatmazsak Threadler havuzda beklemeye devam eder.



    }
}


class ThreadCreator extends Thread{

    private String name;

    public ThreadCreator(String name){
        this.name=name;
    }

    @Override
    public void run() {
        String threadName= Thread.currentThread().getName();
        System.out.println(threadName+" calismaya basladi.");
        System.out.println(threadName+" "+" isi yapiyor.");
        //Thread bir sure calisiyor.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+" calismayi bitirdi.");
    }
}
