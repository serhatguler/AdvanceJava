package threads;

public class MultiThreading01 {
    public static void main(String[] args) {

        //Task:1 den 10 a kadar 2 defa consola yazdirma islemi

        Long start=System.currentTimeMillis();
        CounterWithoutMultiThread counter1 =new CounterWithoutMultiThread("Jason");
        counter1.countMe();
        System.out.println("==============================================");
        CounterWithoutMultiThread counter2 =new CounterWithoutMultiThread("alice");
        counter2.countMe();
        Long finish=System.currentTimeMillis();
        System.out.println("CounterWithoutMultiThread ile gecen sure : "+(finish-start));

        System.out.println("==============================================");

        Long startTime=System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread("Jace");
        counter3.start();
        CounterWithMultiThread counter4 = new CounterWithMultiThread("Ser");
        counter4.start();

        try {
            counter3.join();//icinde bulundugu Threadi(main) counter3 threadinin isi bitene kadar bekletir.
            counter4.join();//icinde bulundugu Threadi(main) counter4 threadinin isi bitene kadar bekletir.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //sleep sureyi dogru hesaplamak icin cozum olmadi
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Long endTime=System.currentTimeMillis();
        System.out.println("CounterWithMultiThread ile gecen sure : "+(endTime-startTime));





    }

}

class CounterWithoutMultiThread{
    public String name;

    //constructor
    public CounterWithoutMultiThread(String name) {

        this.name = name;
    }
    //Thread kullanmadan 1 den 10 a kadar yazdiran method
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0,5 sn bekle main thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i: "+i+"  "+this.name);
        }
    }
}
//MultiThreading ile ayni gorevleri yapalim
class CounterWithMultiThread extends Thread{
    public String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        countMe();
    }

    //Thread kullanarak 1 den 10 a kadar yazdiran method
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0,5 sn bekle main thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i: "+i+"  "+this.name);
        }
    }

}
