package com.study.interview.printabc;

/**
 * @Description: 用三个线程，按顺序输出 ABC ABC ABC
 * @Author: PAN.LU
 * @Date: 2022/11/22 22:46
 * @ref: https://gist.github.com/zzh7982/249883f379b50c5ae50eacd48736b5e2
 */
public class ThreadPrintABC_02 {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i <= 10){
            Thread a = new Thread(() -> {
                System.out.print("A");
            },"ThreadA");

            Thread b = new Thread(() -> {
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");
            },"ThreadB");

            Thread c = new Thread(() -> {
                try {
                    b.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            },"ThreadC");

            a.start();
            b.start();
            c.start();
            c.join();
            i++;
        }
    }
}
