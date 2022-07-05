package com.veganlefty.designpattern.behavioral.statedesign.design.impl;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
import com.veganlefty.designpattern.behavioral.statedesign.design.ActivityState;

/**
 * 活动状态；审核拒绝
 */
public class RefuseState extends ActivityState {

    @Override
    public ActivityResult arraignment(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "已审核状态不可重复提审");
    }

    @Override
    public ActivityResult checkPass(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "已审核状态不可重复审核");
    }

    @Override
    public ActivityResult checkRefuse(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Refuse);
        return new ActivityResult("0000", "活动审核拒绝不可重复审核");
    }

    @Override
    public ActivityResult checkRevoke(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Editing);
        return new ActivityResult("0000", "撤销审核完成");
    }

    @Override
    public ActivityResult close(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Close);
        return new ActivityResult("0000", "活动审核关闭完成");
    }

    @Override
    public ActivityResult open(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "非关闭活动不可开启");
    }

    @Override
    public ActivityResult doing(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "审核拒绝不可执行活动为进行中");
    }

}
