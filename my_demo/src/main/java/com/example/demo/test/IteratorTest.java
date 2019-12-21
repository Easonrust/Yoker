package com.example.demo.test;

import java.util.*;

public class IteratorTest {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 5; i++){
            list.add(new Integer(i));
        }
        ListIterator<Integer> listIterator = list.listIterator();
        listIterator.add(new Integer(0));
        listIterator.add(new Integer(1));
        System.out.println(list);
        while (listIterator.hasNext()){
            int j = listIterator.next();
            if (j == 2) {
                System.out.println("====" + listIterator.previous());
                System.out.println("====" + listIterator.hasPrevious());
                break;
            }
        }

        Iterator<Integer> iterator = list.iterator();
        if (iterator.hasNext()){
            int k = iterator.next();
            System.out.println("====" + list);
            if (k == 0){
                iterator.remove();
            }
        }
        System.out.println("====" + list);
    }
}
