package com.tomaszewski.ToysSwap.enums;

public enum Brand {
    FISHER_PRICE("fisher price"),
    LEGO("Lego"),
    TREFL("Trefl"),
    PLAYMOBIL("Playmobil"),
    HOTWHEELS("HotWheels");


    private final String displayValue;

    Brand(String displayValue){this.displayValue = displayValue;}
    public String getDisplayValue() {
        return displayValue;
    }
}
