package com.veganlefty.designpattern.structural.bridgedesignpattern.design.channel;

import com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode.IPayMode;

import java.math.BigDecimal;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/24 09:06
 */
public class WxPay extends Pay {


    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟微信渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}
