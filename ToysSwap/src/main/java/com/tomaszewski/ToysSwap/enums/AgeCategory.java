package com.tomaszewski.ToysSwap.enums;

public enum AgeCategory {
    ZERO_TWO("0-2"),
    THREE_FIVE("3-5"),
    SIX_EIGHT("6-8"),
    NINE_MORE("9+");

    private final String displayValue;

    AgeCategory(String displayValue){this.displayValue = displayValue;}
    public String getDisplayValue() {
        return displayValue;
    }
}
