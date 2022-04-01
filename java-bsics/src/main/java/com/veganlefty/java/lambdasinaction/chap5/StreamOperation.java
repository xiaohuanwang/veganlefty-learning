package com.veganlefty.java.lambdasinaction.chap5;

import com.veganlefty.java.lambdasinaction.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        //流支持limit(n)方法，该方法会返回一个不超过给定长度的流。所需的长度作为参数传递 给limit。
        // 如果流是有序的，则最多会返回前n个元素。
        List<Dish> limitDishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        limitDishes.forEach(System.out::println);

        //流还支持skip(n)方法，返回一个扔掉了前n个元素的流。
        // 如果流中元素不足n个，则返回一 个空流。
        // 请注意，limit(n)和skip(n)是互补的
        List<Dish> skipDishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        skipDishes.forEach(System.out::println);

        //流支持map方法，它会接受一个函数作为参数。
        // 这个函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        dishNames.forEach(System.out::println);


        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        wordLengths.forEach(System.out::println);

        List<Integer> dishNameLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        dishNameLengths.forEach(System.out::println);

        List<String> words1 = Arrays.asList("Hello", "World");
        words1.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        // flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接 起来成为一个流。
        List<String> uniqueCharacters = words1.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters.toString());

        // [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());

        //anyMatch 检查是否至少匹配一个元素
        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        // allMatch 检查是否匹配所有元素
        boolean isHealthy = Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);
        //noneMatch  确保流中没有任何元素与给定的匹配
        boolean isHealthy1 = Dish.menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy1);
        //findAny  方法将返回当前流中的任意元素
        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        //findFirst  查找第一个元素
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();

        List<Integer> number = Arrays.asList(3, 4, 5, 1, 2);
        int sum = number.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
        int sum1 = number.stream().reduce(0, Integer::sum);
        System.out.println(sum1);
        Optional<Integer> sum2 = number.stream().reduce((a, b) -> (a + b));
        System.out.println(sum2);
        Optional<Integer> max = number.stream().reduce(Integer::max);
        System.out.println(max);
        Optional<Integer> min = number.stream().reduce(Integer::min);
        System.out.println(min);

    }
}
