package com.veganlefty.model;

import com.veganlefty.constant.OrderStatusEnum;
import lombok.Data;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/6 16:17
 */
@Data
public class Order {

    /**
     * 订单ID
     */
    private long orderId;
    /**
     * 订单名称
     */
    private String orderName;
    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;
}
