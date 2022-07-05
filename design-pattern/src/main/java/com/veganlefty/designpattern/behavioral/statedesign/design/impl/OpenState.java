package com.veganlefty.designpattern.behavioral.statedesign.design.impl;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
import com.veganlefty.designpattern.behavioral.statedesign.design.ActivityState;

/**
 * 活动状态；活动开启
 */
public class OpenState extends ActivityState {

    @Override
    public ActivityResult arraignment(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动开启不可提审");
    }

    @Override
    public ActivityResult checkPass(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动开启不可审核通过");
    }

    @Override
    public ActivityResult checkRefuse(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动开启不可审核拒绝");
    }

    @Override
    public ActivityResult checkRevoke(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动开启不可撤销审核");
    }

    @Override
    public ActivityResult close(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Close);
        return new ActivityResult("0000", "活动关闭完成");
    }

    @Override
    public ActivityResult open(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动不可重复开启");
    }

    @Override
    public ActivityResult doing(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Doing);
        return new ActivityResult("0000", "活动变更活动中完成");
    }

}