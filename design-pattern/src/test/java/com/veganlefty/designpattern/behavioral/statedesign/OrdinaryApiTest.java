package com.veganlefty.designpattern.behavioral.statedesign;

import com.alibaba.fastjson.JSON;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryResult;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryService;
import com.veganlefty.designpattern.behavioral.observerdesignpattern.basics.LotteryServiceImpl;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityExecStatusController;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
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
        // 初始化数据
        String activityId = "100001";
        ActivityService.init(activityId, ActivityStatusEnum.Editing);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        ActivityResult resultRefuse = activityExecStatusController.execStatus(activityId, ActivityStatusEnum.Editing, ActivityStatusEnum.Refuse);
        logger.info("测试结果(编辑中To审核拒绝)：{}", JSON.toJSONString(resultRefuse));

        ActivityResult resultCheck = activityExecStatusController.execStatus(activityId, ActivityStatusEnum.Editing, ActivityStatusEnum.Check);
        logger.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));
    }
}
