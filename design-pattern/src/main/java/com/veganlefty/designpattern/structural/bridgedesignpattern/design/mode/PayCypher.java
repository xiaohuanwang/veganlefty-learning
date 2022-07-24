package com.veganlefty.designpattern.structural.bridgedesignpattern.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/24 09:12
 */
public class PayCypher implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);


    @Override
    public boolean security(String uId) {
        logger.info("密码支付，风控校验环境安全");
        return true;
    }
}
