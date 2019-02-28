package test.aop.aspect.pojo;

import org.springframework.stereotype.Component;

/**
 * @author daxing.cao
 * @version 1.0
 * spring aop测试类2
 */
@Component
public class TestBeanTwo {

    public void test(String msg){
        System.out.println("I am test two!");
        System.out.println(msg);
    }
}
