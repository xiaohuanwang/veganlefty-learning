package com.veganlefty.java.lambdasinaction.chap6;


import com.veganlefty.java.lambdasinaction.chap4.CaseFailureCauseEnum;
import com.veganlefty.java.lambdasinaction.chap4.Cause;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/4/2 5:52 下午
 */
public class GroupingCause {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2022, 7, 10);
        LocalDate endDate = LocalDate.of(2022, 7, 15);
        List<LocalDate> thatDayList = GroupingCause.listLocalDateOfTimePageReqByDayDesc(startDate, endDate);
        Map<String, Object> map = new HashMap<>();

        Map<CaseFailureCauseEnum, Map<LocalDate, Long>> groupByType = Cause.menu.stream()
                .collect(Collectors.groupingBy(Cause::getFailureCauseCategory, Collectors.groupingBy(Cause::getData, Collectors.counting())));
        System.out.println(groupByType);
    }

    public static List listLocalDateOfTimePageReqByDayDesc(LocalDate startDate, LocalDate endDate) {

        return Stream.iterate(startDate, localDate -> localDate.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
                .collect(Collectors.toList());
    }
}
