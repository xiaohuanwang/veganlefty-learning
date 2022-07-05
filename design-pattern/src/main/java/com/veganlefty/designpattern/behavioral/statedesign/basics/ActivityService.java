package com.veganlefty.designpattern.behavioral.statedesign.basics;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityInfo;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/5 14:36
 */
public class ActivityService {

    private static Map<String, Enum<ActivityStatusEnum>> activityStatusMap = new ConcurrentHashMap<String, Enum<ActivityStatusEnum>>();

    /**
     * 初始化模拟查询活动信息
     *
     * @param activityStatusEnum 活动状态
     * @param activityId         活动ID
     * @author wxh_work@163.com
     * @date 2022/7/5 14:47
     */
    public static void init(String activityId, Enum<ActivityStatusEnum> activityStatusEnum) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(activityStatusEnum);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        activityStatusMap.put(activityId, activityStatusEnum);
    }

    /**
     * 查询活动信息
     *
     * @param activityId 活动ID
     * @return 查询结果
     */
    public static ActivityInfo queryActivityInfo(String activityId) {
        // 模拟查询活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(activityStatusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    /**
     * 查询活动状态
     *
     * @param activityId 活动ID
     * @return 查询结果
     */
    public static Enum<ActivityStatusEnum> queryActivityStatus(String activityId) {
        return activityStatusMap.get(activityId);
    }

    /**
     * 执行状态变更
     *
     * @param activityId   活动ID
     * @param beforeStatus 变更前状态
     * @param afterStatus  变更后状态
     */
    public static synchronized void execStatus(String activityId, Enum<ActivityStatusEnum> beforeStatus, Enum<ActivityStatusEnum> afterStatus) {
        if (!beforeStatus.equals(activityStatusMap.get(activityId))) {
            return;
        }
        activityStatusMap.put(activityId, afterStatus);
    }

}
