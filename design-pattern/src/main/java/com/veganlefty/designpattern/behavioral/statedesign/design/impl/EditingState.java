package com.veganlefty.designpattern.behavioral.statedesign.design.impl;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;
import com.veganlefty.designpattern.behavioral.statedesign.basics.ActivityService;
import com.veganlefty.designpattern.behavioral.statedesign.design.ActivityState;

/**
 * 活动状态；编辑中
 */
public class EditingState extends ActivityState {

    @Override
    public ActivityResult arraignment(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Check);
        return new ActivityResult("0000", "活动提审成功");
    }

    @Override
    public ActivityResult checkPass(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "编辑中不可审核通过");
    }

    @Override
    public ActivityResult checkRefuse(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "编辑中不可审核拒绝");
    }

    @Override
    public ActivityResult checkRevoke(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "编辑中不可撤销审核");
    }

    @Override
    public ActivityResult close(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatusEnum.Close);
        return new ActivityResult("0000", "活动关闭成功");
    }

    @Override
    public ActivityResult open(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "非关闭活动不可开启");
    }

    @Override
    public ActivityResult doing(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return new ActivityResult("0001", "编辑中活动不可执行活动中变更");
    }

}
