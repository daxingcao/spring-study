package test.aop.aspect.pojo;

import org.springframework.stereotype.Component;

/**
 * @author daxing.cao
 * @version 1.0
 * aop横向编程测试类1
 */
@Component
public class TestBeanOne {

    public void test(){
        System.out.println("I am test one!");
    }

    public void test2(){System.out.println("I am test one2!");}

}
