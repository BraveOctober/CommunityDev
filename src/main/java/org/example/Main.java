package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface lambda{
    public abstract int runn(int x, int y);
}

public class Main {
    public static void main(String[] args) {
        fun();
        System.out.println("2");

//        System.gc();
        int sum = run(3,5,(x,y)->x*y);
        System.out.println(sum);

        List<String> s1 = Arrays.asList("a","bc","asd");
        System.out.println(s1.stream().filter(x->x.length()>1).collect(Collectors.toList()));

        List<Integer> l = Arrays.asList(1,2,3);
        long t = l.stream()
                .count();
        System.out.println(t);

        List<String> s2 = Arrays.asList("a","bc","asd");
        s2.stream().forEach(x->System.out.println(x));

    }
    public static void fun(){
        Main m = new Main();
        System.out.println("1");
//        System.gc();
    }
    public static int run(int x,int y,lambda l)
    {
        return l.runn(x,y);
    }

    @Override
    public void finalize(){
        System.out.println("3");
    }
}