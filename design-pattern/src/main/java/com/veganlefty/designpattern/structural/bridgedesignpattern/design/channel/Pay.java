package com.veganlefty.designpattern.structural.bridgedesignpattern.design.channel;

import com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/24 09:02
 */
public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
