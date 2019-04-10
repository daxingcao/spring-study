package test;

import com.alibaba.fastjson.JSON;
import test.entry.Person;

import java.util.*;

public class VolatileTest {

    public static void main(String[] args){
//        Person per1 = new Person("zhangsan",18);
//        Person per2 = new Person("zhangsan",18);
//        Collection c = new HashSet();
//        c.add(per1);
//        System.out.println("------------");
//        c.add(per2);
//        System.out.println("------------");
//        System.out.println(per1.equals(per2));
//        System.out.println("------------");
//        System.out.println(per1.hashCode());
//        System.out.println(per2.hashCode());
//        System.out.println(c);
        Map<Object,Object> map = new Hashtable<>();
        map.put(null,"");
        System.out.println(JSON.toJSONString(map));
    }

    public static class Test{

        private static volatile int a = 1;

        public static void add(){
            a++;
            a = 4;
        }

    }

}
