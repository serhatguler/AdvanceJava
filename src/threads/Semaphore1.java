package threads;
/*
Java’da Semaphore kullanımının temel nedeni, birden fazla thread’in kaynaklara erişimini kontrol etmek ve senkronize etmektir.
Semaphore, belirli bir kaynağın aynı anda kullanılabileceği maksimum thread sayısını belirler.
u, özellikle sınırlı kaynaklara sahip durumlarda veya kaynakların sırayla ve
güvenli bir şekilde kullanılmasını sağlamak istediğinizde önemlidir.
 */

//Semaphore park yeri diyelim . Thread de araba olsun .Thread1 isi bittikten sonra Semaphore bos olacak
//Thread2 nu kez gelecek butun islerini yapip bosaltacak
import java.util.concurrent.Semaphore;

public class Semaphore1 {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);
        Thread.sleep(2000);

        System.out.println("Parking Space Count: "+ semaphore.availablePermits());//kullanima uygun yerleri gosterir.

        Car car1 = new Car("Car1",semaphore);
        car1.start();
        Car car2 = new Car("Car2",semaphore);
        car2.start();
        Car car3 = new Car("Car3",semaphore);
        car3.start();
        Car car4 = new Car("Car4",semaphore);
        car4.start();
        Car car5 = new Car("Car5",semaphore);
        car5.start();
        Car car6 = new Car("Car6",semaphore);
        car6.start();

    }



}

class Car extends Thread{

    private String name; //Car1,Car2 etc..

    Semaphore semaphore;//PArking lot

    public Car(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(name+"is trying to park their car.");
            semaphore.acquire();//burada yeri talep ediyoruz.

            System.out.println(name+"has parked their car.");

            for(int i=1; i<5; i++){
                System.out.println(name+"has been staying in the parking space for "+i+" hours");
            }
            System.out.println(name+" has left the parking space");
            semaphore.release();//isimiz bittikten sonra yeri bosaltiyoruz.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
