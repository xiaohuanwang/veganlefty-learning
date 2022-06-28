package com.veganlefty.listener;

import com.veganlefty.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 监听器
 * 监听器负责接收和处理事件。
 * 有两种实现方法：实现ApplicationListener接口或者使用@EventListener注解。
 * 可以使用@EventListener在同一个类中用不同的方法监听多个不同的事件。
 * 相对于实现ApplicationListener接口，使用@EventListener会更加灵活。
 *
 * @author wxh_work@163.com
 * @date 2022/6/28 15:56
 */
@Slf4j
@Component
public class OrderListener {

    @EventListener
    public void onApplicationEvent(OrderEvent event) throws InterruptedException {
        String orderId = event.getOrderId();
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        log.info("{}:校验当前商品价格耗时:{}毫秒",orderId,(endTime-startTime));

    }
}
