package test.custom.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @author daxing.cao
 */
public class CustomBeanFactoryPostProcessor2 implements BeanFactoryPostProcessor,Ordered {

    private int order = 2147483647;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("我是自定义BeanFactoryPostProcessor,我被调用了!!!");
    }

    @Override
    public int getOrder() {
        return 0;
    }

    public void setOrder(int order){
        this.order = order;
    }
}
