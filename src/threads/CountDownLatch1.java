package threads;

//CountDownLatch is used to make sure that task waits for before other task starts.
//oncelikle worker threadlerini calistiri. ondan sonra geriye kalan mesala main threadini calistirir.
//normalde main thread i once de calisabilirdi.
import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {

        //Create the counter
        CountDownLatch latch = new CountDownLatch(4);

        //Create the workers
        Worker worker1 = new Worker(latch);//3
        Worker worker2 = new Worker(latch);//2
        Worker worker3 = new Worker(latch);//1
        Worker worker4 = new Worker(latch);//0

        //Start the workers
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        //Active the counter
        latch.await();
        System.out.println("MAIN THREAD IS WORKING NOW!!");




    }


}
class Worker extends Thread{

    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" is running");
            latch.countDown();//count u azaltiyoruz.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
