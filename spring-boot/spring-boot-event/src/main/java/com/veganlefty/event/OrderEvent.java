package com.veganlefty.event;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 事件类：定义事件，继承ApplicationEvent的类成为一个事件类。
 *
 * @author wxh_work@163.com
 * @date 2022/6/28 15:53
 */
@Data
@ToString
public class OrderEvent extends ApplicationEvent {
    /** 该类型事件携带的信息 */
    private String orderId;
    public OrderEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
