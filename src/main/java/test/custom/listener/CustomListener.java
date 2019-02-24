package test.custom.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import test.custom.listener.event.ShopStatusEvent;

/**
 * @author daxing.cao
 * @version 1.0
 * 自定义非注解spring监听类
 */
public class CustomListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ShopStatusEvent) {
            ShopStatusEvent event = (ShopStatusEvent) applicationEvent;
            System.out.println("非注解形式监听类:事件类-->"+event.getSource());
        }
    }
}