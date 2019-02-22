
/*class MyRunnable implements Runnable {
    public static int counter = 0;
    public static int turn = 0;
    public static Object lock = new Object();

    @Override
    public void run() {
        while (counter < 50) {
            synchronized (lock) {
                if (turn == 0) {

                    System.out.println(counter++ + " from thread "
                            + Thread.currentThread().getName());
                    turn = 1;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    turn = 0;
                    lock.notify();
                }

            }
        }
    }
}*/

import java.util.concurrent.Semaphore;

class ThreadPrinter implements Runnable {
    int counter;
    Semaphore ins, outs;

    ThreadPrinter(int counter, Semaphore ins, Semaphore outs) {
        this.counter = counter;
        this.ins = ins;
        this.outs = outs;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                ins.acquire(); // wait for permission to run
                System.out.println("Thead:"+Thread.currentThread().getName()+ "::" + counter);
                outs.release();  // allow another thread to run


                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 2;
        }
    }
}

public class AlternateThreadsPrintingNumbersInSequence {
    public static void main(String [] args){
       /* Thread threadA = new Thread(new MyRunnable());
        Thread threadB = new Thread(new MyRunnable ());
        Thread threadC = new Thread(new MyRunnable ());
        threadA.start();
        threadB.start();*/
      //  threadC.start();
        Semaphore a = new Semaphore(1);  // first thread is allowed to run immediately
        Semaphore b = new Semaphore(0); // second thread has to wait
        Thread tp1 = new Thread(new ThreadPrinter(1, a, b));
        Thread tp2 = new Thread(new ThreadPrinter(2, b, a));
        tp1.start();
        tp2.start();

    }
}
