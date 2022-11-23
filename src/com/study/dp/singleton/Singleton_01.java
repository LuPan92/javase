package com.study.dp.singleton;

/**
 * @Author: PAN.LU
 * @Date: 2022/11/23 00:31
 */
public class Singleton_01 {
    // 必须加上 volatile, 否则会在对象初始化的时候可能发生指令重排序, 在多线程的情况下会存在对象半初始化情况。
    private static volatile Singleton_01 INSTANCE;

    private Singleton_01(){}

    public static Singleton_01 getInstance(){
        // DCL: Double Check Lock
        if (INSTANCE == null){
            // synchronized 可以保证可见性
            synchronized (Singleton_01.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton_01();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton_01 s1 = getInstance();
        Singleton_01 s2 = getInstance();
        System.out.print(s1.equals(s2));
    }
}
