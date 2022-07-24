package com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/24 09:09
 */
public class PayFaceMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayFaceMode.class);


    @Override
    public boolean security(String uId) {
        logger.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
