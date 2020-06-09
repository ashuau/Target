package interview.sapient;

class MyThread implements Runnable {

    private int data;
    MyThread(int data){
        this.data = data;
    }
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Test1"))
            printThread1("test1");
        else
            printThread2("test2");
    }

    private void printThread2(String name) {
        synchronized (this){
            System.out.println("printing "+name);
            System.out.println(this.data);
        }
    }

    private void printThread1(String name) {
        synchronized (this){
            System.out.println("printing "+name);
            try {
                System.out.println("Waiting for 4 sec...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.data);
        }
    }
}

public class MultiThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(5);
        MyThread myThread1 = new MyThread(10);

        Thread t1 = new Thread(myThread);
        t1.setName("Test1");
        t1.start();
        Thread t2 = new Thread(myThread);
        t2.setName("test2");
        t2.start();
    }
}
