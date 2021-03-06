package com.veganlefty.java;

import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @date: 2021/10/27 11:08 下午
 * @author: 王小欢
 */
public class Test {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2022, 5, 1);
        LocalDate endDate = LocalDate.of(2022, 7, 1);
        List<LocalDate> thatDayList = Test.listLocalDateOfTimePageReqByDayDesc(startDate, endDate);
        System.out.println(thatDayList.toString());
    }

    public static List listLocalDateOfTimePageReqByDayDesc(LocalDate startDate, LocalDate endDate) {

        return Stream.iterate(startDate, localDate -> localDate.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
                .collect(Collectors.toList());
    }
}
