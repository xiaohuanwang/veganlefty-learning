package com.veganlefty.designpattern.behavioral.statedesign.basics;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/5 14:52
 */
public class ActivityExecStatusController {

    /**
     * 活动状态变更
     * 1. 编辑中 -> 提审、关闭
     * 2. 审核通过 -> 拒绝、关闭、活动中
     * 3. 审核拒绝 -> 撤审、关闭
     * 4. 活动中 -> 关闭
     * 5. 活动关闭 -> 开启
     * 6. 活动开启 -> 关闭
     *
     * @param activityId   活动ID
     * @param beforeStatus 变更前状态
     * @param afterStatus  变更后状态
     * @return 返回结果
     */
    public ActivityResult execStatus(String activityId, Enum<ActivityStatusEnum> beforeStatus, Enum<ActivityStatusEnum> afterStatus) {

        // 1. 编辑中 -> 提审、关闭
        if (ActivityStatusEnum.Editing.equals(beforeStatus)) {
            if (ActivityStatusEnum.Check.equals(afterStatus) || ActivityStatusEnum.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new ActivityResult("0000", "变更状态成功");
            } else {
                return new ActivityResult("0001", "变更状态拒绝");
            }
        }

        // 2. 审核通过 -> 拒绝、关闭、活动中
        if (ActivityStatusEnum.Pass.equals(beforeStatus)) {
            if (ActivityStatusEnum.Refuse.equals(afterStatus) || ActivityStatusEnum.Doing.equals(afterStatus) || ActivityStatusEnum.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new ActivityResult("0000", "变更状态成功");
            } else {
                return new ActivityResult("0001", "变更状态拒绝");
            }
        }

        // 3. 审核拒绝 -> 撤审、关闭
        if (ActivityStatusEnum.Refuse.equals(beforeStatus)) {
            if (ActivityStatusEnum.Editing.equals(afterStatus) || ActivityStatusEnum.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new ActivityResult("0000", "变更状态成功");
            } else {
                return new ActivityResult("0001", "变更状态拒绝");
            }
        }

        // 4. 活动中 -> 关闭
        if (ActivityStatusEnum.Doing.equals(beforeStatus)) {
            if (ActivityStatusEnum.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new ActivityResult("0000", "变更状态成功");
            } else {
                return new ActivityResult("0001", "变更状态拒绝");
            }
        }

        // 5. 活动关闭 -> 开启
        if (ActivityStatusEnum.Close.equals(beforeStatus)) {
            if (ActivityStatusEnum.Open.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new ActivityResult("0000", "变更状态成功");
            } else {
                return new ActivityResult("0001", "变更状态拒绝");
            }
        }

        // 6. 活动开启 -> 关闭
        if (ActivityStatusEnum.Open.equals(beforeStatus)) {
            if (ActivityStatusEnum.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new ActivityResult("0000", "变更状态成功");
            } else {
                return new ActivityResult("0001", "变更状态拒绝");
            }
        }

        return new ActivityResult("0001", "非可处理的活动状态变更");

    }
}
