package com.veganlefty.constant;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/6 16:21
 */
public enum OrderStatusEnum {
    // 待支付，
    WAIT_PAYMENT,
    //支付
    PAYED,
    //待发货，
    WAIT_DELIVER,
    //发货
    DELIVERY,
    //待收货，
    WAIT_RECEIVE,
    //确认收货
    RECEIVED,
    //订单结束
    FINISH;
}
