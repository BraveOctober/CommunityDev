package org.example;

import javax.swing.plaf.TableHeaderUI;

public class PrintOddEven {
    private static final Object lock =new Object();
    private static int count = 1;
    private static final int MAX_COUNT = 10;
    public static void main(String[] args)
    {
        Runnable printOdd = () -> {
            synchronized (lock){
                while(count <= MAX_COUNT)
                {
                    if (count % 2 == 1)
                    {
                        System.out.println(Thread.currentThread().getName()+":"+count++);
                        lock.notify();
                    }
                    else{
                        try{
                            lock.wait();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Runnable printEven = () -> {
            synchronized (lock){
                while(count <= MAX_COUNT)
                {
                    if (count % 2 == 0)
                    {
                        System.out.println(Thread.currentThread().getName()+":"+count++);
                        lock.notify();
                    }
                    else{
                        try{
                            lock.wait();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread threadOdd = new Thread(printOdd,"printOdd");
        Thread threadEven = new Thread(printEven,"printEven");

        threadOdd.start();
        threadEven.start();
    }
}
