package sh4rkizz.Lab11;

import java.util.ArrayList;

public class ThreadsOperation {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Threads();
            thread.start();
            threads.add(thread);
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total runs: " + Threads.getCountRuns());
        System.out.println("Total time: " + (endTime - startTime));
    }
}
