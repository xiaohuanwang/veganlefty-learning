package com.veganlefty.java.enumexample;

import java.util.EnumSet;

import static com.veganlefty.java.enumexample.OrderStatusEnum.*;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/4 22:59
 */
public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<OrderStatusEnum> orderStatusEnum = EnumSet.noneOf(OrderStatusEnum.class);
        System.out.println(orderStatusEnum);

        orderStatusEnum.add(SHIPPED);
        System.out.println(orderStatusEnum);

        orderStatusEnum.addAll(EnumSet.of(UNPAID, PAID));
        System.out.println(orderStatusEnum);

        orderStatusEnum = EnumSet.allOf(OrderStatusEnum.class);
        System.out.println(orderStatusEnum);

        orderStatusEnum.removeAll(EnumSet.of(UNPAID, PAID));
        System.out.println(orderStatusEnum);

        orderStatusEnum.removeAll(EnumSet.range(SHIPPED, COMLETED));
        System.out.println(orderStatusEnum);

        orderStatusEnum = EnumSet.complementOf(orderStatusEnum);
        System.out.println(orderStatusEnum);

    }
}
