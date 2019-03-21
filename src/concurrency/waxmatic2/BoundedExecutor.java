package concurrency.waxmatic2;

import org.junit.runner.notification.RunListener;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

@RunListener.ThreadSafe
public class BoundedExecutor {
    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, Semaphore semaphore) {
        this.exec = exec;
        this.semaphore = semaphore;
    }
    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (Exception e) {
            semaphore.release();
        }

    }
}
