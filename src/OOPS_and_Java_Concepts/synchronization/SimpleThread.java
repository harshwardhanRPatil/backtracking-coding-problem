package OOPS_and_Java_Concepts.FunctionInterface.synchronization;


import java.util.concurrent.atomic.AtomicInteger;

class MyThread extends Thread{
    @Override
   public void run(){
        System.out.println("we are in thread ::"+ Thread.currentThread().getName());
    }
}

public class SimpleThread {
    static AtomicInteger share_resourse=new AtomicInteger(0);

    public static void main(String args[]) throws InterruptedException {
//    Thread thread1 =new MyThread();
//    thread1.start();

    Runnable task = () -> {
        for(int i=0;i<100000;i++){
            share_resourse.incrementAndGet();
        }

    };
        Thread thread1 =new Thread(task);
        Thread thread2 =new Thread(task);
        thread1.start();
        thread2.start();
        thread2.join();
        thread1.join();

        System.out.println("Comman share resousre is now ::"+share_resourse);

}}
