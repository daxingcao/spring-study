package test.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import test.custom.processor.bean.CustomInstanceBeanPostProcessor;

//@Component
public class CustomBeanFactoryTest implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if(beanFactory instanceof ConfigurableListableBeanFactory){
            ConfigurableListableBeanFactory factory = (ConfigurableListableBeanFactory) beanFactory;
            factory.registerSingleton("test",new CustomInstanceBeanPostProcessor());
        }
    }
}
