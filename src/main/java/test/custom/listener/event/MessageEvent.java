package test.custom.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author daxing.cao
 * @version 1.0
 * 消息事件类
 */
public class MessageEvent extends ApplicationEvent {

    public MessageEvent(Object source){
        super(source);
    }
}
