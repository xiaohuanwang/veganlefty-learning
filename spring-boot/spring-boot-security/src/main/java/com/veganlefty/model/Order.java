package com.veganlefty.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/6 16:17
 */
@Data
@Builder
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
     * 订单金额
     */
    private BigDecimal orderPrice;
}
