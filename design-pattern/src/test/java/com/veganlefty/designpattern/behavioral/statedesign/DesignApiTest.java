package com.veganlefty.designpattern.behavioral.statedesign;

import com.alibaba.fastjson.JSON;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
import com.veganlefty.designpattern.behavioral.statedesign.design.ActivityStateHandler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DesignApiTest {
    private final Logger logger = LoggerFactory.getLogger(DesignApiTest.class);

    @Test
    public void test_Editing2Arraignment() {
        String activityId = "100001";
        ActivityService.init(activityId, ActivityStatusEnum.Editing);
        ActivityStateHandler stateHandler = new ActivityStateHandler();
        ActivityResult result = stateHandler.arraignment(activityId, ActivityStatusEnum.Editing);
        logger.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @Test
    public void test_Editing2Open() {
        String activityId = "100001";
        ActivityService.init(activityId, ActivityStatusEnum.Editing);
        ActivityStateHandler stateHandler = new ActivityStateHandler();
        ActivityResult result = stateHandler.open(activityId, ActivityStatusEnum.Editing);
        logger.info("测试结果(编辑中To开启活动)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @Test
    public void test_Refuse2Doing() {
        String activityId = "100001";
        ActivityService.init(activityId, ActivityStatusEnum.Refuse);
        ActivityStateHandler stateHandler = new ActivityStateHandler();
        ActivityResult result = stateHandler.doing(activityId, ActivityStatusEnum.Refuse);
        logger.info("测试结果(拒绝To活动中)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @Test
    public void test_Refuse2Revoke() {
        String activityId = "100001";
        ActivityService.init(activityId, ActivityStatusEnum.Refuse);
        ActivityStateHandler stateHandler = new ActivityStateHandler();
        ActivityResult result = stateHandler.checkRevoke(activityId, ActivityStatusEnum.Refuse);
        logger.info("测试结果(拒绝To撤审)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }


}
