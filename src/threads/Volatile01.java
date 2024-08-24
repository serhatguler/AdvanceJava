package threads;
/*
Cok cekirdekli isletim sistemlerinde her cekirdegin kendi cache yapisi olur.
Sik kullanilan degisken degerlerinin kopyasi cache e alinarak islem yapilir.
Belirli araliklarla main memorydeki deger guncellenir.

Multithreading bir yapida her Thread  farkli cekirdeklerde calisabilir.
Ortak bir degiskenin kullanimi soz konu ise ,degiskenin degeri cachede tutulursa,
guncel degerinden diger Threadin haberi olmayabilir.Bu uygulamamizin sonsuz donguye girmesine
sebep olabilir.

Volatile Keywordu ise degiskenin main memory de saklanmsini ve burada okunmasini saglar ,garanti eder
Threadlerin degiskenlere erisimini siraya koymak icin yeterli degildir.Synchronized kullanilmalidir.

//Cache: on bellek

//Volatile: degiskeni olustururken degistirlrn degerin main memoryden(RAM) alinmasini saglar.
//Degisiklik yaparsak yine main memory e yazar.

 */



public class Volatile01 {

    public volatile static int flag = 0;//flag degiskenin degerinin main memory den okunmasini/yazilmasini garanti etmek icin
                                //volatile  kullaniyoruz.
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag==0){
                    System.out.println("Threadlerle calismak harika");
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("Flag degeri 1 olarak degistirildi.");
            }
        });
        thread2.start();
    }
}
