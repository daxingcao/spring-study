package test;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {

    public static void main(String[] args){
        String a = new String("hello");
        String b = a;
        System.out.println("a:"+a+"b:"+b);
        add(a);
        System.out.println("a:"+a+"b:"+b);
    }

    public static void add(String a){
        a = "world";
    }

}
