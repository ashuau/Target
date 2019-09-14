public class ShutDownHookTest
{
    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown Hook is running !");
        }));
        System.out.println("Application Terminating ...");
        Thread.sleep(1000);// Shutdownhook will be called unless
        //forcefully termination done
        System.exit(0); // Shutdown hook will be called
    }
}