package com.veganlefty.designpattern.create.factorymethod.basics.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2021/11/21 9:17 上午
 */
@AllArgsConstructor
@Data
public class CouponResult {
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String info;
}
