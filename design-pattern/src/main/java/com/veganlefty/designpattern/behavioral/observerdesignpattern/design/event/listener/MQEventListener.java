package com.veganlefty.designpattern.behavioral.observerdesignpattern.design.event.listener;

import com.veganlefty.designpattern.behavioral.observerdesignpattern.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/1 00:19
 */
public class MQEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);


    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户{} 摇号结果: {}", result.getuId(), result.getMsg());
    }
}
