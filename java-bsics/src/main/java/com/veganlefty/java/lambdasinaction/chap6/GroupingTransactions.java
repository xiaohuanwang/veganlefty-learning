package com.veganlefty.java.lambdasinaction.chap6;


import com.veganlefty.java.lambdasinaction.chap4.Dish;

import java.util.*;
import java.util.stream.Collectors;


/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/4/2 5:52 下午
 */
public class GroupingTransactions {
    public static List<Transaction> transactions = Arrays.asList(new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0));

    public static void main(String[] args) {
        groupImperatively();
        groupFunctionally();

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostComparator = Dish.menu.stream()
                .collect(Collectors.maxBy(dishComparator));
        System.out.println(mostComparator);

        int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        double avgCalories = Dish.menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics menuStatistics = Dish.menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));
        System.out.println(shortMenu);

        int totalCaloriesSum = Dish.menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCaloriesSum);
        int totalCaloriesMap = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum).get();
        System.out.println(totalCaloriesMap);
        int totalCaloriesSum1 = Dish.menu.stream()
                .mapToInt(Dish::getCalories).sum();
        System.out.println(totalCaloriesSum1);

        Map<Dish.Type, List<Dish>> deshesByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(deshesByType);

        Map<Dish.CaloricLevel, List<Dish>> disHeaByCaroricLevel = Dish.menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return Dish.CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return Dish.CaloricLevel.NORMAL;
                    } else {
                        return Dish.CaloricLevel.FAT;
                    }
                }));
        System.out.println(disHeaByCaroricLevel);

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return Dish.CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return Dish.CaloricLevel.NORMAL;
                                    } else {
                                        return Dish.CaloricLevel.FAT;
                                    }
                                }
                        ))
                );
        System.out.println(dishesByTypeCaloricLevel);

        Map<Dish.Type, Long> typesCount = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream()
                .collect(Collectors.groupingBy
                        (Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) {
                                return Dish.CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return Dish.CaloricLevel.NORMAL;
                            } else {
                                return Dish.CaloricLevel.FAT;
                            }
                        }, Collectors.toSet()
                )));
        System.out.println(caloricLevelByType);

        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)
                                ), Optional::get)
                        )
                );
        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    private static void groupImperatively() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        System.out.println(transactionsByCurrencies);

    }

    private static void groupFunctionally() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println(transactionsByCurrencies);
    }

    public enum Currency {
        EUR, USD, JPY, GBP, CHF
    }

    public static class Transaction {
        private final Currency currency;
        private final double value;

        public Transaction(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }

}
