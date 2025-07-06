package ru.javawebinar.basejava;

public class DeadLock {
    private static final Object LOCK0 = new Object();
    private static final Object LOCK1 = new Object();

    public static void main(String[] args) {
        Thread thread0 = new Thread(() -> {
            System.out.println("Starting thread0");
            synchronized (LOCK0) {
                System.out.println("Lock0 thread0");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LOCK1) {
                    System.out.println("Lock1 thread0");
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("Lock1 thread1");
                synchronized (LOCK0) {
                    System.out.println("Lock0 thread1");
                }
            }
        });

        thread0.start();
        thread1.start();
    }
}
