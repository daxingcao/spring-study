package test.custom.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.custom.processor.bean.CustomInstanceBeanPostProcessor;
import test.custom.processor.factory.CustomBeanFactoryPostProcessor2;

/**
 * @author daxing.cao
 * @version 1.0
 * 自定义ApplicationContext
 */
public class CustomApplicationContext extends ClassPathXmlApplicationContext {

    public CustomApplicationContext(String configLocation) throws BeansException {
        super(configLocation);
    }

    /**
     * 重写AbstractApplicationContext中postProcessBeanFactory方法;
     * 以硬编码方式添加一个BeanFactoryProcessor后处理类
     * @param beanFactory
     */
    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        this.addBeanFactoryPostProcessor(new CustomBeanFactoryPostProcessor2());
        beanFactory.registerSingleton("customInstanceBeanPostProcessor",new CustomInstanceBeanPostProcessor());
    }
}
