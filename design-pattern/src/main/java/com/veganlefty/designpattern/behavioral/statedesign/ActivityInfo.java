package com.veganlefty.designpattern.behavioral.statedesign;

import lombok.Data;

import java.util.Date;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/5 14:28
 */
@Data
public class ActivityInfo {
    /**
     * 活动ID
     */
    private String activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动状态
     */
    private Enum<ActivityStatusEnum> status;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
}
