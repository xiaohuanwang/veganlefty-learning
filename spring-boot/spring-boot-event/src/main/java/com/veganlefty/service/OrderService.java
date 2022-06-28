package com.veganlefty.service;

import com.veganlefty.event.MessageEvent;
import com.veganlefty.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author wxh_work@163.com
 * @date 2022/6/28 16:02
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    /*
    发布者：发布事件，通过ApplicationEventPublisher发布事件。
    发布者负责发布消息，Spring容器中默认的ApplicationEventPublisher是AbstractApplicationContext，
    同时AbstractApplicationContext也是ApplicationContext的一个子类，
    也就是说，Spring默认使用AbstractApplicationContext发布事件。
    有三种实现方式:
    1：直接使用ApplicationEventPublisher(推荐)
    2：实现ApplicationEventPublisherAware接口(推荐)
    3：使用ApplicationContext#publishEvent(ApplicationEvent)发布
    */
    @Autowired
    private ApplicationEventPublisher publisher;

    public String buyOrder(String orderId) {
        long startTime = System.currentTimeMillis();
        //1.查询商品信息
        log.info("查询商品信息{}",orderId);
        //2.校验商品价格
        publisher.publishEvent(new OrderEvent(this,orderId));
        //3.购买成功，发送消息
        publisher.publishEvent(new MessageEvent(this,orderId));
        long endTime = System.currentTimeMillis();
        log.info("任务全部完成，总耗时：{}毫秒", endTime - startTime);
        return "商品下单成功";
    }
}
