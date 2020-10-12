package sh4rkizz;

import java.util.ArrayList;

public class Threads {
    static long totalSum;
    static int[] sum = new int[4];

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));

        for (int i = 0; i < 4; i++) {
            totalSum += sum[i];
        }

        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        int k = start / 1000;

        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            sum[k]++;
        }

        return a;
    }
}