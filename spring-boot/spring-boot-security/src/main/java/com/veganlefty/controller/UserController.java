package com.veganlefty.controller;

import com.veganlefty.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/8/25 16:41
 */
@RestController
public class UserController {

    @RequestMapping("/userInfo")
    public Order userInfo(){
        return Order.builder()
                .orderId(1L)
                .orderName("订单")
                .orderPrice(new BigDecimal(12.23))
                .build();
    }
}
