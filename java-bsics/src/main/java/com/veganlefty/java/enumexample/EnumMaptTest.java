package com.veganlefty.java.enumexample;

import sun.text.normalizer.Utility;

import java.util.EnumMap;
import java.util.Map;

import static com.veganlefty.java.enumexample.OrderStatusEnum.*;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/4 23:22
 */
public class EnumMaptTest {
    public static void main(String[] args) {
        EnumMap<OrderStatusEnum, String> enumMap = new EnumMap<OrderStatusEnum, String>(OrderStatusEnum.class);
        enumMap.put(UNPAID, "未支付");
        enumMap.put(CANCEL, "已取消");

        for (Map.Entry<OrderStatusEnum, String> entry : enumMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        try {
            System.out.println(enumMap.get(PAID));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
