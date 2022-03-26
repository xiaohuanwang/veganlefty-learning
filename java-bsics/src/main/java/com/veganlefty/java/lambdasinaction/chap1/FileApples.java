package com.veganlefty.java.lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/3/26 12:09 上午
 */
public class FileApples {
    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = fileGreenApples(apples);
        System.out.println(greenApples.toString());

        List<Apple> heavyApples = fileHeavyApples(apples);
        System.out.println(heavyApples.toString());

        List<Apple> greenApples1 = filterApple(apples, FileApples::isGreenApple);
        System.out.println(greenApples1);

        List<Apple> heavyApples1 = filterApple(apples, FileApples::isHeavyApple);
        System.out.println(heavyApples1);

        System.out.println(filterApple(apples, (Apple a) -> a.getColor().equals("green")));

        System.out.println(filterApple(apples, (Apple a) -> a.getWeight() > 150));

    }

    public static List<Apple> fileGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals("green")) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> fileHeavyApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return apple.getColor().equals("green");
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }


    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
