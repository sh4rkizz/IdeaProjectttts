package sh4rkizz.Lab11;

import java.util.concurrent.atomic.AtomicLong;

public class Threads extends Thread {
    private static AtomicLong countRuns = new AtomicLong(0);

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + operations());
    }

    public static long operations() {
        long number = 900_000_000;
        final long num = 700_000_000;

        for (int i = 0; i < 9_000_000; i++) {
            number = (long) (num - Math.sqrt(num * num) - Math.sqrt((Math.sqrt(num)
                    * (long) (Math.random() * Math.sqrt(Math.sqrt(num) * num))
                    / Math.sqrt(num - num * (long) (Math.random())) + num)));
            raiseCountRuns();
        }
        return number;
    }

    public static void raiseCountRuns() {
        countRuns.incrementAndGet();
    }

    public static AtomicLong getCountRuns(){
        return countRuns;
    }
}