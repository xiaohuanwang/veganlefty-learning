package com.veganlefty.java.lambdasinaction.chap4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Cause {

    public static final List<Cause> menu =
            Arrays.asList(
                    new Cause(LocalDate.of(2022, 7, 13), CaseFailureCauseEnum.CODE_BUG),
                    new Cause(LocalDate.of(2022, 7, 12), CaseFailureCauseEnum.CODE_BUG),
                    new Cause(LocalDate.of(2022, 7, 11), CaseFailureCauseEnum.CODE_BUG),
                    new Cause(LocalDate.of(2022, 7, 12), CaseFailureCauseEnum.INNER_ENV),
                    new Cause(LocalDate.of(2022, 7, 11), CaseFailureCauseEnum.INNER_ENV),
                    new Cause(LocalDate.of(2022, 7, 13), CaseFailureCauseEnum.OUTER_ENV),
                    new Cause(LocalDate.of(2022, 7, 11), CaseFailureCauseEnum.OUTER_ENV),
                    new Cause(LocalDate.of(2022, 7, 13), CaseFailureCauseEnum.POCKET),
                    new Cause(LocalDate.of(2022, 7, 10), CaseFailureCauseEnum.POCKET));
    private final LocalDate data;
    private final CaseFailureCauseEnum failureCauseCategory;

    public Cause(LocalDate data, CaseFailureCauseEnum failureCauseCategory) {
        this.data = data;
        this.failureCauseCategory = failureCauseCategory;
    }

    public LocalDate getData() {
        return data;
    }


    public CaseFailureCauseEnum getFailureCauseCategory() {
        return failureCauseCategory;
    }


}