package com.veganlefty.designpattern.structural.bridgedesignpattern;

import com.alibaba.fastjson.JSON;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityExecStatusController;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
import com.veganlefty.designpattern.structural.bridgedesignpattern.design.channel.Pay;
import com.veganlefty.designpattern.structural.bridgedesignpattern.design.channel.WxPay;
import com.veganlefty.designpattern.structural.bridgedesignpattern.design.channel.ZfbPay;
import com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode.PayFaceMode;
import com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode.PayFingerprintMode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2021/11/21 10:05 上午
 */
public class OrdinaryApiTest {
    private final Logger logger = LoggerFactory.getLogger(OrdinaryApiTest.class);

    @Test
    public void test() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }
}
