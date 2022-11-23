package com.study.interview.printabc;

/**
 * @Author: PAN.LU
 * @Date: 2022/11/22 22:57
 */
public class ThreadPrintABC_03 {
    private volatile int status = 1;

    public static void main(String[] args) {
        ThreadPrintABC_03 t03 = new ThreadPrintABC_03();

        Thread a = new Thread(() -> {
            while (t03.status != 1){
                try {
                    t03.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            t03.status = 2;
            t03.notifyAll();
        });

        Thread b = new Thread(() -> {
            while (t03.status != 2){
                try {
                    t03.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            t03.status = 3;
            t03.notifyAll();
        });

        Thread c = new Thread(() -> {
            while (t03.status != 3){
                try {
                    t03.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("C");
            t03.status = 1;
            t03.notifyAll();
        });

        a.start();
        b.start();
        c.start();
    }
}
