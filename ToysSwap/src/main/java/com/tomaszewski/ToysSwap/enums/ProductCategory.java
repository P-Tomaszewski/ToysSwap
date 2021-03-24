package com.tomaszewski.ToysSwap.enums;

public enum ProductCategory {
    EDUCATION_AND_DEVELOPMENT("Edukacja i rozwój"),
    FIGURINES("Figurki"),
    GAMES("Gry"),
    BLOCKS("Klocki"),
    DOLLS_ACCESSORIES("Lalki i akcesoria"),
    SOFT_TOYS("Pluszaki"),
    VEHICLES("Pojazdy");


    private final String displayValue;

    ProductCategory(String displayValue){this.displayValue = displayValue;}
    public String getDisplayValue() {
        return displayValue;
    }
}
