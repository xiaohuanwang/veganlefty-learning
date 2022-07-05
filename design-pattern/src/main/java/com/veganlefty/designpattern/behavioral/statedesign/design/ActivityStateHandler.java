package com.veganlefty.designpattern.behavioral.statedesign.design;

import com.veganlefty.designpattern.behavioral.statedesign.ActivityResult;
import com.veganlefty.designpattern.behavioral.statedesign.ActivityStatusEnum;
import com.veganlefty.designpattern.behavioral.statedesign.design.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/5 15:29
 */
public class ActivityStateHandler {

    private Map<Enum<ActivityStatusEnum>, ActivityState> stateMap = new ConcurrentHashMap<Enum<ActivityStatusEnum>, ActivityState>();

    public ActivityStateHandler() {
        stateMap.put(ActivityStatusEnum.Check, new CheckState());     // 待审核
        stateMap.put(ActivityStatusEnum.Close, new CloseState());     // 已关闭
        stateMap.put(ActivityStatusEnum.Doing, new DoingState());     // 活动中
        stateMap.put(ActivityStatusEnum.Editing, new EditingState()); // 编辑中
        stateMap.put(ActivityStatusEnum.Open, new OpenState());       // 已开启
        stateMap.put(ActivityStatusEnum.Pass, new PassState());       // 审核通过
        stateMap.put(ActivityStatusEnum.Refuse, new RefuseState());   // 审核拒绝
    }

    public ActivityResult arraignment(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public ActivityResult checkPass(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public ActivityResult checkRefuse(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    public ActivityResult checkRevoke(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public ActivityResult close(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    public ActivityResult open(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    public ActivityResult doing(String activityId, Enum<ActivityStatusEnum> currentStatus) {
        return stateMap.get(currentStatus).doing(activityId, currentStatus);
    }
}
