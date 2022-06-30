package com.veganlefty.designpattern.behavioral.observerdesignpattern.design.event.listener;

import com.veganlefty.designpattern.behavioral.observerdesignpattern.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/1 00:17
 */
public class MessageEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知：{}", result.getuId(), result.getMsg());
    }
}
