package test.custom.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author daxing.cao
 * @version 1.0
 * 商品上下架事件类
 */
public class ShopStatusEvent extends ApplicationEvent {

    public ShopStatusEvent(Object source) {
        super(source);
    }

    public void doEvent(){
        System.out.println("");
    }

}
