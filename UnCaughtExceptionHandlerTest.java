/**
 * Created by Lenovo on 6/13/2017.
 */
class Task implements Runnable
{
    @Override
    public void run()
    {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());

        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("234"));
        System.out.println(Integer.parseInt("345"));
        System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
        System.out.println(Integer.parseInt("456"));
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler
{
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n", t.getName());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace();
        System.out.printf("Thread status: %s\n", t.getState());
       // new Thread(new Task()).start();
    }
}

public class UnCaughtExceptionHandlerTest
{
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("alive :: "+thread.isAlive());
        System.out.println(thread.getName());
        thread.join();
        System.out.println("alive :: "+thread.isAlive());

        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
    }
}