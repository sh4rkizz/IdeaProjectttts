package sh4rkizz.Lab_B_11;

public class ThreadsOperation {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Threads();
            thread.start();
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        System.out.println("Total threads time: " + result);

        startTime = System.currentTimeMillis();
        Threads main = new Threads();

        for (int i = 0; i < 10; i++)
            main.run();

        endTime = System.currentTimeMillis();
        System.out.println("Total runs: " + Threads.getCountRuns());
        System.out.println("Total main thread time: " + (endTime - startTime));

        result -= endTime - startTime;
        System.out.println("The difference between timers equals: " + result);
    }
}
