package com.veganlefty.java.lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/3/29 4:02 下午
 */
public class StreamOperation {
    public static void main(String[] args) {
        //流还支持一个叫作distinct的方法，它会返回一个元素各异(根据流所生成元素的 hashCode和equals方法实现)的流。
        // 例如，以下代码会筛选出列表中所有的偶数，并确保没有 重复。
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

    }
}
