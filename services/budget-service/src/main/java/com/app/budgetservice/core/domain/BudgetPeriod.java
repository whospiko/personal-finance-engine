package com.app.budgetservice.core.domain;

import java.time.YearMonth;
import java.util.Objects;

public record BudgetPeriod(YearMonth yearMonth) {
    public BudgetPeriod {
        Objects.requireNonNull(yearMonth, "YearMonth must not be null");
    }
    public static BudgetPeriod current() {
        return new BudgetPeriod(YearMonth.now());
    }
    public static BudgetPeriod of(int year, int month) {
        return new BudgetPeriod(YearMonth.of(year, month));
    }
    public static BudgetPeriod parse(String yearMonthStr) { // e.g. "2026-10"
        return new BudgetPeriod(YearMonth.parse(yearMonthStr));
    }
    public String toIsoString() {
        return yearMonth.toString(); // Outputs "2026-10"
    }
    public BudgetPeriod nextMonth() {
        return new BudgetPeriod(yearMonth.plusMonths(1));
    }
}
