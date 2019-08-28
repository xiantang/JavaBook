package NIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class MonitoringTest {
    public static void createBusyThread(){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run(){
                while(true)//第41行
;
            }
        },"testBusyThread");
        thread.start();
    }
    /**
     *线程锁等待演示
     */
    public static void createLockThread(final Object lock){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(lock){
                    try{
                        System.out.println(111);
                        lock.wait();
                        System.out.println(222);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
        // 创建一个等待线程
        createBusyThread();
        Object obj=new Object();
        createLockThread(obj);
        TimeUnit.SECONDS.sleep(2);
        createLockThread(obj);
//        synchronized (obj) {
//            obj.notify();
//        }
//        br.readLine();


    }

}