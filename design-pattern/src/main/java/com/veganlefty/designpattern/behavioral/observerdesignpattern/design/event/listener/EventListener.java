package com.veganlefty.designpattern.behavioral.observerdesignpattern.design.event.listener;

import com.veganlefty.designpattern.behavioral.observerdesignpattern.design.LotteryResult;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/1 00:10
 */
public interface EventListener {

    void doEvent(LotteryResult result);

}
