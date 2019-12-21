package com.example.demo.test;

public class Test {
    public static void main(String args[]){
        String a = "a";
        String b= "a";
        String c = a;
        System.out.println(a==b);
        System.out.println(a=="a");
        System.out.println(a==c);
        System.out.println(a.equals(b));
        System.out.println("a".equals(a));
        System.out.println(a.equals(c));
    }
}
