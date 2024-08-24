package threads;
/*
        Bir ogrencinin banka hesiba para YATIRMA VE CEKME ISLEMLerini icin uygulama
        hesapta para yoksa yatrilmasini beklesin
        Bakiye artinca para cekme gerceklessin


        */

public class WaitInterrupt {
    public static int balance= 0;
    public static void main(String[] args) {
        WaitInterrupt object = new WaitInterrupt();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.withdraw(1000);
            }
        });
        thread1.setName("tuketici");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                object.deposit(2000);
                thread1.interrupt();//thread2 thread1 i zorla durdurma islemi yapiyor.
                                    //wait() islemi durduruldu
            }
        });
        thread2.setName("uretici");
        thread2.start();



    }

    //para cekme methodu
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para cekmek istiyor");
        if (balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz. Mevcut bakiye"+balance);
            System.out.println("Bakiyenin guncellenmesi bekleniyor.");
            try {
                wait();//monitor edilen obje gecici olarak serbet kalir
            } catch (InterruptedException e) {
                System.out.println("tuketici threadin calismasi kesildi");
                System.out.println("Lutfen bakiyeyi kontrol ediniz.");
            }
        }
        //..notify cagrilinca bekleme sona erer.

        if (balance>=amount){
            balance=balance-amount;
            System.out.println("para cekme islemi gerceklesti. mevcut bakiyeniz "+balance);
        }else {
            System.out.println("Sonra tekrar kontrol ediniz.");
        }


    }

    //para yatirma metodu
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatirmak istiyor");
        balance = balance+amount;
        System.out.println("Para yatirma islemi gercekleti. Mevcut bakiye :"+balance);

    }


}
