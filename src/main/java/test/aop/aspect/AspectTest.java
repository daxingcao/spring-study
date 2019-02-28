package test.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author daxing.cao
 * @version 1.0
 * springAOP测试类
 */
@Aspect
@Component
public class AspectTest {

    @Before("execution(* test.aop..*.*(..))")
    public void beforeTest(){
        System.out.println("<------before------>");
    }

    @After("execution(* test..*.test(..))")
    public void afterTest(){
        System.out.println("<------after------>");
    }

    @Around("execution(* test..*.test(..))")
    public Object aroundTest(ProceedingJoinPoint point){
        System.out.println("-------around before------");
        Object o = null;
        try {
            o = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("------around after------");
        return o;
    }

}
