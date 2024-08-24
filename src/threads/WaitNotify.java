package threads;

/*
Bir ogrencinin banka hesiba para YATIRMA VE CEKME ISLEMLerini icin uygulama
hesapta para yoksa yatrilmasini beklesin
Bakiye artinca para cekme gerceklessin

wait ve notify:Threadler arasindaki iletisimi saglar
wait ve notify: bir ya da daha fazla threadlerin islemini tamamlayablimesi icin deger threadin
yapacagin islemin tamamlamasi gerektigi durumlar da kullanilir.
 */
public class WaitNotify {

    public static int balance=0;//her iki trad de bakiyeyi degistirmek istiyor bundan dolayi senkron etmemiz lazim

    public static void main(String[] args) {

        WaitNotify waitNotify =new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.withdraw(1000);
            }
        });
        thread1.setName("student");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                waitNotify.deposit(2000);
            }
        });
        thread2.setName("parent");
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
                throw new RuntimeException(e);
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
        notify();// bekleyen threalere bildirim gonderir.
        //notifyAll(); birden fazla bekeyen  threalere bildirim gonderir.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Notify() metodu tamamlanana kadar objeyi birakmaz. ");
    }

}
