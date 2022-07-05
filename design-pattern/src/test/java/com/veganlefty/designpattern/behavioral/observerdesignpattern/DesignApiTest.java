package com.veganlefty.designpattern.behavioral.observerdesignpattern;

import com.alibaba.fastjson.JSON;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryResult;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryService;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DesignApiTest {
    private final Logger logger = LoggerFactory.getLogger(DesignApiTest.class);

    @Test
    public void test() throws Exception {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("2765789109877");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }

}
