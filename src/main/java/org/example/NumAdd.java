package org.example;

public class NumAdd {
    private static int num = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock)
            {
                for(int i = 0; i < 50; i++)
                {
                    num++;
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 50; i++)
            {
                synchronized (lock) {
                    num++;
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(num);
    }
}
