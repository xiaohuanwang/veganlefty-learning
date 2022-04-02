package com.veganlefty.java.lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/3/31 6:07 下午
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
      /*(1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。
        (2) 交易员都在哪些不同的城市工作过?
        (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        (5) 有没有交易员是在米兰工作的?
        (6) 打印生活在剑桥的交易员的所有交易额。
        (7) 所有交易中，最高的交易额是多少?
        (8) 找到交易额最小的交易。*/


        //(1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(tr2011.toString());

        //(2) 交易员都在哪些不同的城市工作过?
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);
        Set<String> cities1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(cities1);

        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders.toString());

        //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        //优化
        String traderStr1 =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining());
        System.out.println(traderStr1);

        //(5) 有没有交易员是在米兰工作的?
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        //(6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //(7) 所有交易中，最高的交易额是多少?
        Optional<Integer> highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);
        System.out.println(highestValue);

        //(8) 找到交易额最小的交易。
        Optional<Integer> minValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::min);
        System.out.println(minValue);

        Optional<Transaction> minValue1 =
                transactions.stream()
                        .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(minValue1);

        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .min(comparing(Transaction::getValue));
        System.out.println(smallestTransaction);

    }
}
