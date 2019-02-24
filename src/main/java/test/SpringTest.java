package test;

import entity.Person;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import test.custom.context.CustomApplicationContext;
import test.custom.listener.CustomListener;
import test.custom.listener.event.MessageEvent;
import test.custom.listener.event.ShopStatusEvent;
import test.custom.processor.factory.CustomBeanFactoryPostProcessor;

/**
 * @author daxing.cao
 */
public class SpringTest{

    public static void main(String[] args){

//        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring/spring-core.xml"));
//        BeanFactoryPostProcessor postProcessor = factory.getBean("myBeanFactoryPostProcessor", CustomBeanFactoryPostProcessor.class);
//        postProcessor.postProcessBeanFactory(factory);
//        Person person = factory.getBean("person", Person.class);
//        person.say();
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-core.xml");

        ApplicationContext context = new CustomApplicationContext("spring/spring-core.xml");
        context.publishEvent(new MessageEvent("msg"));
        context.publishEvent(new ShopStatusEvent("shop"));
//        Person person1 = context.getBean("person", Person.class);
//        person1.say();
//        ClassLoader loader = SpringTest.class.getClassLoader();
//        System.out.println(loader);
//        System.out.println(loader.getResource("spring/spring-core.xml"));
    }

}