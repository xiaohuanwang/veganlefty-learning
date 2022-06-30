package com.veganlefty.designpattern.behavioral.observerdesignpattern.design;

import com.veganlefty.designpattern.behavioral.observerdesignpattern.MinibusTargetService;

import java.util.Date;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/1 00:33
 */
public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();


    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }
}
