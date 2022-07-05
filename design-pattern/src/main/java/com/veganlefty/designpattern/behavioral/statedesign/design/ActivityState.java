package com.veganlefty.designpattern.behavioral.statedesign.design;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/5 15:27
 */
public abstract class ActivityState {
    /**
     * 活动提审
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult arraignment(String activityId, Enum<ActivityStatusEnum> currentStatus);

    /**
     * 审核通过
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult checkPass(String activityId, Enum<ActivityStatusEnum> currentStatus);

    /**
     * 审核拒绝
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult checkRefuse(String activityId, Enum<ActivityStatusEnum> currentStatus);

    /**
     * 撤审撤销
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult checkRevoke(String activityId, Enum<ActivityStatusEnum> currentStatus);

    /**
     * 活动关闭
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult close(String activityId, Enum<ActivityStatusEnum> currentStatus);

    /**
     * 活动开启
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult open(String activityId, Enum<ActivityStatusEnum> currentStatus);

    /**
     * 活动执行
     *
     * @param activityId    活动ID
     * @param currentStatus 当前状态
     * @return 执行结果
     */
    public abstract ActivityResult doing(String activityId, Enum<ActivityStatusEnum> currentStatus);
}
