package test.custom.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author daxing.cao
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor,Ordered {

    private int order = 2147483647;

    private Set<String> lockProperties;

    public CustomBeanFactoryPostProcessor(){
        this.lockProperties = new HashSet<>(10);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for(String beanName : beanNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                @Nullable
                @Override
                public String resolveStringValue(String s) {
                    return isLock(s) ? "******" : s;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(beanDefinition);
        }
    }

    public boolean isLock(String property){
        if(this.lockProperties.contains(property.toUpperCase())){
            return true;
        }
        return false;
    }

    public void setLockProperties(Set<String> lockProperties){
        this.lockProperties.clear();
        for(String property : lockProperties){
            this.lockProperties.add(property.toUpperCase());
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }

    public void setOrder(int order){
        this.order = order;
    }
}
