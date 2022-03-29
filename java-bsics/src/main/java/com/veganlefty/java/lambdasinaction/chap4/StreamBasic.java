package com.veganlefty.java.lambdasinaction.chap4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/3/28 5:40 下午
 */
public class StreamBasic {
    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

        dishesGroupByType(Dish.menu).forEach(((type, dishList) -> {
            System.out.println(type + "///" + dishList.toString());
        }));

        threeHighCaloricDishNames(Dish.menu).forEach(System.out::println);

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        //    s.forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishList) {
        //通过新建一个list,用for循环的方式，判断筛选数据累加数据
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dis : dishList) {
            if (dis.getCalories() < 400) {
                lowCaloricDishes.add(dis);
            }
        }
        //用匿名类对list进行比较排序
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        //处理排名好的数据
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishList) {
        //通过stream流,筛选数据，对筛选的进行排序，对排序的数据提取，最后返回list
        return dishList.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static Map<Dish.Type, List<Dish>> dishesGroupByType(List<Dish> dishes) {
        return dishes.stream().
                collect(Collectors.groupingBy(Dish::getType));

    }

    public static List<String> threeHighCaloricDishNames(List<Dish> dishList) {
        return dishList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
    }
}
