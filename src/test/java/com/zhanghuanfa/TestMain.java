package com.zhanghuanfa;

/**
 * @author zhanghuanfa
 * @date 2018-01-06 16:40
 */

public class TestMain {

    private static String s = "A";

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(s);
    }
    private static String test(){
        try {
            System.out.println("A");
            return s = "A";
        } finally {
            System.out.println("B");
            s = "B";
        }
    }
}
