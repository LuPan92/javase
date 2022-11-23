package com.study.interview.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: PAN.LU
 * @Date: 2022/11/23 11:15
 */
public class Test {

    public static void findGarbageMsg(int[][] msg_list,int send_id){
        List<Integer> a_send = new ArrayList<>();
        List<Integer> a_revice = new ArrayList<>();
        int[] a = new int[101];
        for (int i = 0; i < msg_list.length; i++) {
            int[] msg = msg_list[i];
            if (msg[0] == send_id){
                a_send.add(msg[1]);
                a[msg[1]] = a[msg[1]] + 1;
            }
            if (msg[1] == send_id){
                // 发送给 a 的人
                a_revice.add(msg[0]);
                a[msg[0]] = a[msg[0]] -1;
            }
        }

        int l = 0;
        for (int i = 0; i < a_send.size(); i++) {
            if(!a_revice.contains(a_send.get(i))){
                l++;
            }
        }

        // A 发送的短信数 - A 收到的短信数
        int m = a_send.size() - a_revice.size();

        // 判断是否存在 X 的情况
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 5){
                System.out.println("true "+ l +" " + m);
                return;
            }
        }

        // 判断是否是垃圾短信
        if (l > 5 || m > 10 ){
            System.out.println("true "+l+" " + m);
        }else {
            System.out.println("false "+l+" " + m);
        }

    }

    public static void main(String[] args) {
//        int[][] msg_list = {{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{2,1}};
//        int[][] msg_list = {{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12},{1,13},{1,14},{14,1},{1,15}};
//        findGarbageMsg(msg_list,1);
//        findGarbageMsg(msg_list,2);
    }

}
