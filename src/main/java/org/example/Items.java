package org.example;

import java.lang.invoke.StringConcatFactory;
import java.math.BigDecimal;
import java.util.Arrays;

public enum Items {

    APPLES(new BigDecimal("35"),"apple"),
    BANANAS(new BigDecimal("20"),"banana"),
    MELONS(new BigDecimal("50"),"melon"),
    LIMES(new BigDecimal("15"),"lime");

    final BigDecimal price;
    final String description;
    Items(BigDecimal price, String description) {
        this.price = price;
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static Items getItemName(String description) {
        return Arrays.stream(Items.values())
                .filter(s-> s.getDescription().equals(description))
                .findFirst().orElseThrow(()-> new IllegalArgumentException("Item: "+ description +" does not exists"));
}


}
