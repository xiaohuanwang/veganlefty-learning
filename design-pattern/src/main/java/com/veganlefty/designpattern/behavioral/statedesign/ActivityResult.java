package com.veganlefty.designpattern.behavioral.statedesign;

import lombok.Data;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/5 14:32
 */
@Data
public class ActivityResult {
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String info;

    public ActivityResult(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
