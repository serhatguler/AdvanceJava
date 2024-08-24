package threads;
//Threads birden fazla isin yapilmasini saglar
//dosya indirirken diger taraftan web gezinmek gibi faydasi var
public class ThreadCreationWays {
    public static void main(String[] args) {
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());

        //Thread extend ederek
        MyThread thread1 = new MyThread();
       // thread1.run();//run icindeki kodlar calistirir.Ancak Thread olusturulmaz
        thread1.start();//override ettigimiz run metodunu cagirir ve olusturdugumuz threadi baslatir.


        //Runnable implemente ederek
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();
        thread2.setName("yeni thread");//Thread ismini degistirdik

        //Runnable(functional) implemente ederek
        // annonymous(isimsiz) class ile Thread olusturma
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //Thread3 basladiktan sonra islemleri 5sn durdur
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Mevcut thread: "+Thread.currentThread().getName());
                System.out.println("Bu Thread anonymous class ile olusturuldu ");
            }
        },"yeni thread ismini boyle de verebiliriz");
        thread3.start();

        Thread thread4 = new Thread(()->{
            System.out.println("Mevcut thread: "+Thread.currentThread().getName());
            System.out.println("Bu thread lambda expression ile olsturuldu.");

        }
                );
        thread4.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread islemi burada bitti");

    }

}

//thread olusturmak icn yontemler
//1.yontem:Thread classini extend ederek

class MyThread extends Thread{

    @Override//threade yaptirmak istedigimiz islemi bu run metodu ile yaptir
    public void run() {
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());
        System.out.println("MyThread threadi calisiyor.");
        //run metodu biterse thread biter.
    }
}

//2.yontem:Runnable interfacini implement ederek
class MyRunnable implements Runnable{


    @Override
    public void run() {
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());
        System.out.println("MyRunnable ile olusturulan threadi calisiyor.");
    }
}















