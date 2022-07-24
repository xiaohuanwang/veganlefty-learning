package com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/24 09:11
 */
public class PayFingerprintMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayFingerprintMode.class);

    @Override
    public boolean security(String uId) {
        logger.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
