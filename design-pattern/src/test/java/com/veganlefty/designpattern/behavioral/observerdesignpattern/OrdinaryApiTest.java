package com.veganlefty.designpattern.behavioral.observerdesignpattern;

import com.alibaba.fastjson.JSON;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryResult;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryService;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("2344566788");
        logger.info("测试结果:{}", JSON.toJSONString(result));

    }
}
