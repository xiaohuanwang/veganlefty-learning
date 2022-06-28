package com.veganlefty.event;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/6/28 17:35
 */
@Data
@ToString
public class MessageEvent extends ApplicationEvent {
    private String orderId;

    public MessageEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
