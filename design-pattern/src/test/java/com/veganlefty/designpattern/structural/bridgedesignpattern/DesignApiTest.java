package com.veganlefty.designpattern.structural.bridgedesignpattern;

import com.veganlefty.designpattern.structural.bridgedesignpattern.basics.PayController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class DesignApiTest {
    private final Logger logger = LoggerFactory.getLogger(DesignApiTest.class);

    @Test
    public void test() {
        PayController payController = new PayController();
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        payController.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        payController.doPay("jlu19dlxo111", "100000109894", new BigDecimal(100), 2, 3);
    }

}
