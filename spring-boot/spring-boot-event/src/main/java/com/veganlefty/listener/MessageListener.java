package com.veganlefty.listener;

import com.veganlefty.event.MessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/6/28 17:37
 */
@Slf4j
@Component
public class MessageListener {

    @Async
    @EventListener
    public void sendMessage(MessageEvent event) throws InterruptedException {
        String orderId = event.getOrderId();
        long startTime = System.currentTimeMillis();
        log.info("开发发送短信");
        log.info("开发发送邮件");
        Thread.sleep(4000);
        long endTime = System.currentTimeMillis();
        log.info("{}：发送短信、邮件耗时：{}毫秒", orderId, (endTime - startTime));
    }
}
