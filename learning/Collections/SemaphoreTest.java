package learning.Collections;

// java program to demonstrate
// use of semaphores Locks
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


class MyThread extends Thread {
    Semaphore sem;
    String threadName;
   static AtomicInteger count = new AtomicInteger();

    public MyThread(Semaphore sem, String threadName) {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // run by thread A
       /* if(this.getName().equals("A"))
        {*/
        System.out.println("Starting " + threadName);
        try {
            // First, get a permit.
            System.out.println(threadName + " is waiting for a permit.");

            // acquiring the lock
            sem.acquire();

            System.out.println(threadName + " gets a permit.");

            // Now, accessing the shared resource.
            // other waiting threads will wait, until this
            // thread release the lock
            for (int i = 0; i < 5; i++) {
                //Shared.count++;
                Thread.sleep(i * 1000);
                System.out.println(threadName + ": " + count.incrementAndGet());

                // Now, allowing a context switch -- if possible.
                // for thread B to execute
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // Release the permit.
        System.out.println(threadName + " releases the permit.");
        sem.release();
        sem.release();


    }

    public int getCount() {
        return this.count.get();
    }

}

// Driver class
public class SemaphoreTest
{
    public static void main(String[] args) throws InterruptedException
    {
        // creating a Semaphore object
        // with number of permits 1
        Semaphore sem = new Semaphore(2);

        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        //MyThread mt = new MyThread();
        MyThread mt1 = new MyThread(sem, "A");
        MyThread mt2 = new MyThread(sem, "B");

        // stating threads A and B
        mt1.start();
        mt2.start();

        // waiting for threads A and B
        mt1.join();
       mt2.join();

        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("count: " + mt1.count);
    }
}

