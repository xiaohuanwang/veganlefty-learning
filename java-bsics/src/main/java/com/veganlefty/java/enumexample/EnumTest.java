package com.veganlefty.java.enumexample;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/2 22:14
 */
public class EnumTest {
    public static void main(String[] args) {
        OrderStatusEnum orderStatus = OrderStatusEnum.UNPAID;
        System.out.println(orderStatus);

        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            System.out.println(orderStatusEnum + ":" + orderStatusEnum.ordinal());
        }

        OrderStatusEnum[] values = OrderStatusEnum.values();
        Enum e = OrderStatusEnum.PAID;
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }

    }
}
