public class ShutDownHookTest
{
    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                System.out.println("Shutdown Hook is running !");
            }
        });
        System.out.println("Application Terminating ...");
     //   Thread.currentThread().sleep(1000);// Shutdownhook will be called unless
        //forcefully termination done
        System.exit(1); // Shutdown hook will be called
    }
}