package com.veganlefty.java.enumexample;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/2 22:13
 */
public enum OrderStatusEnum {
    /**
     * 未支付
     */
    UNPAID("未支付"),
    /**
     * 已支付
     */
    PAID("已支付"),
    /**
     * 部分支付
     */
    PARTIAL_PAYMENT("部分支付"),
    /**
     * 已取消
     */
    CANCEL("已取消");

    private final String desc;

    private OrderStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
