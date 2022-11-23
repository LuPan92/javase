package com.study.interview.printabc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 用三个线程，按顺序输出 ABC ABC ABC
 * @Author: PAN.LU
 * @Date: 2022/11/22 21:53
 */
public class ThreadPrintABC_01 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition cA = lock.newCondition();
    private static Condition cB = lock.newCondition();
    private static Condition cC = lock.newCondition();

    private static CountDownLatch latchB = new CountDownLatch(1);
    private static CountDownLatch latchC = new CountDownLatch(1);

    public static void main(String[] args) {
        // 思路：三个线程，三个不同的队列 A 唤醒 B，B 唤醒 C
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    cB.signal();
                    if (i == 0) latchB.countDown();
                    cA.await();
                }
                cB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "ThreadA");

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    cC.signal();
                    cC.await();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"ThreadB");

        threadA.start();
        threadB.start();

    }
}
