package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterrptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");

    }
}

class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read()");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted())
                System.out.println("Interrupted from block I/O");
            else
                throw new RuntimeException(e);
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true)
            Thread.yield();
    }

    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting  {
    private static ExecutorService exec =
            Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        // 调用cancel 可以用来中断特定任务
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting "+r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupting send to "  + r.getClass().getName());

    }

    public static void main(String[] args) throws InterruptedException {
//        test(new SleepBlocked());
//        test(new IOBlocked(System.in));
//        test(new SynchronizedBlocked());
//        TimeUnit.SECONDS.sleep(3);
//        System.exit(0);

        for (int i = 0; i <5 ; i++) {
            exec.execute(new Thread(new IOBlocked(System.in)));
        }
        exec.shutdownNow();

    }
}
