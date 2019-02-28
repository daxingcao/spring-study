package test.custom.processor.bean;

import entity.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;


/**
 * @author daxing.cao
 */
public class CustomInstanceBeanPostProcessor implements InstantiationAwareBeanPostProcessor,BeanFactoryAware {

    private BeanFactory beanFactory;

    public CustomInstanceBeanPostProcessor(){
        System.out.println("InstantiationAwareBeanPostProcessor被初始化了:"+this.toString());
    }

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
        //如果返回false则不会进行属性注入
        return true;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

}
