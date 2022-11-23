package com.study.interview.huawei;

/**
 * @Author: PAN.LU
 * @Date: 2022/11/23 09:49
 */
public class VersionCompare {

    /**
     *
     * @param v1
     * @param v2
     * @return
     */
    public static String compare(String v1, String v2){
        if (v1 == "" && v2 != ""){
            return v2;
        }
        if (v2 == ""){
            return v1;
        }
        String[] v1_array = v1.split("[\\.|-]");
        String[] v2_array = v2.split("[\\.|-]");
        for (int i = 0; i < v1_array.length; i++) {
            if (v2_array.length == i){
                return v1;
            }
            if (i != 3){
                // 比较大版本号
                if (Long.parseLong(v1_array[i]) > Long.parseLong(v2_array[i])){
                    return v1;
                }else if (Long.parseLong(v1_array[i]) > Long.parseLong(v2_array[i])){
                    return v2;
                }else {
                    if (i != v1_array.length-1){
                        continue;
                    }else {
                        if (v2_array.length-1 > i){
                            return v2;
                        }
                    }
                }
            }else {
                // 比较小版本号
                if (v1_array[3].compareTo(v2_array[3]) > 0){
                    return v1;
                }else if(v1_array[3].compareTo(v2_array[3]) == 0){
                    return v1;
                }else {
                    return v2;
                }
            }
        }
        return v1;
    }


    public static void main(String[] args) {
        System.out.println(compare("1.3.11-S2","1.3.11-S13"));
        System.out.println(compare("1.05.1","1.5.01"));
        System.out.println(compare("1.5","1.5.0"));
        System.out.println(compare("1.5.0","1.5"));
        System.out.println(compare("1.5.1-A","1.5.1-a"));
        System.out.println(compare("1.05.1","1.5.01-a"));
    }
}
