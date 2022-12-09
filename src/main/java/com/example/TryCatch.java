package com.example;

public class TryCatch {

    public void result(int a) {
        int num = a;
        System.out.println("result=" + num);
    }

    public void result(int a, int b){
        int num = a+b;
        System.out.println("result="+num);
    }

    public void result(String name) {
        String result = name;
        System.out.println("result="+result);
    }

    public static void main(String[] args) {
        TryCatch result = new TryCatch();
        result.result(1);
        result.result(1, 2);
        result.result("dog");

    }
}
