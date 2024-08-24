package threads;

//Synchronized metod veya bloklar icin kullanulir
//bloga erisen thread hangi obje ile erisirse bu objeyi monitor etmek icin this kullanilir.
public class SynchronizedKeyword02 {

    public static void main(String[] args) {

        Brackets02 brackets= new Brackets02();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9 ; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9 ; i++) {
                    brackets.generateBrackets();
                }
            }
        });
        thread2.start();

    }


}


//Ayni anda ulsasilan metod icersinde asenkron calismasinda  problem olmayacak kodlar varsa
class Brackets02{
    //Synchnorized ile metoda ulasan threadin objeyi monitor(kitlemek) etmesini saglar.
    public  void generateBrackets(){
        synchronized (this){ //sadece ihtiyacimiz olan yeri senkron eder
            for (int i = 1; i <=10 ; i++) {
                if (i<=5){
                    System.out.print(" [ " );
                }else {
                    System.out.print(" ] ");
                }
            }
            System.out.println();
        }



        //baska kodlar var ve sirasi onemli degil
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}