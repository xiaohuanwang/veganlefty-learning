package com.veganlefty.designpattern.behavioral.statedesign.design.impl;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
import com.veganlefty.designpattern.behavioral.statedesign.design.ActivityState;

/**
 * 活动状态；活动关闭
 */
public class CloseState extends ActivityState {

    @Override
    public ActivityResult arraignment(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动关闭不可提审");
    }

    @Override
    public ActivityResult checkPass(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动关闭不可审核通过");
    }

    @Override
    public ActivityResult checkRefuse(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动关闭不可审核拒绝");
    }

    @Override
    public ActivityResult checkRevoke(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动关闭不可撤销审核");
    }

    @Override
    public ActivityResult close(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动关闭不可重复关闭");
    }

    @Override
    public ActivityResult open(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Open);
        return new ActivityResult("0000", "活动开启完成");
    }

    @Override
    public ActivityResult doing(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "活动关闭不可变更活动中");
    }

}
