package test.custom.processor.bean;

import entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author daxing.cao
 */
public class CustomInstanceBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        if(beanClass.getSimpleName() == "Person"){
//
//        }
        System.out.println(beanClass.getSimpleName());
        System.out.println("sssssssss------------------>"+beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            Person person = (Person) bean;
            person.setPropertyValue("aaaa");
            person.say();
        }
        System.out.println("bean instance after->"+bean.toString());
        return true;
    }
}
