package com.veganlefty.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/12 22:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 392365881428311040L;

    /**
     * 订单ID
     */
    private long orderId;

    /**
     *订单名称
     */
    private String orderName;
    /**
     *订单状态
     */
    private int orderStatus;
}
