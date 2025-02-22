package com.expensetracker.expenses;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ExpenseCategory {
    FOOD,
    SPORT,
    HOUSE,
    DOGS,
    COSMETIC,
    TRANSPORT,
    HEALTH,
    ENTERTAINMENT,
    OTHER;

    @JsonCreator
    public static ExpenseCategory fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}
