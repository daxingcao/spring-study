package test.custom.listener.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import test.custom.listener.event.MessageEvent;

/**
 * @author daxing.cao
 * @version 1.0
 * 注解形式的spring监听类
 */
@Component
public class ApplicationListener {

    @EventListener
    public void messageListener(MessageEvent messageEvent){
        System.out.println("注解形式监听类:事件类-->"+messageEvent.getSource());
    }

}
