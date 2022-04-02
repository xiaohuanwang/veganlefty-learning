package com.veganlefty.java.lambdasinaction.chap5;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/4/2 2:01 下午
 */
public class BuildingStreams {
    public static void main(String[] args) {
        //由值创建流
        Stream<String> stringStream = Stream.of("Java", "Lambdas", "In", "Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        //使用empty得到一个空流
        Stream<String> emptyStream = Stream.empty();

        //由数据创建流
        int[] numbers = {2, 3, 5, 6, 7, 8, 9, 11, 14, 15};
        int sum = Arrays.stream(numbers).sum();

        //由函数生成数据流：创建无限流
        //迭代
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        //生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


    }
}
