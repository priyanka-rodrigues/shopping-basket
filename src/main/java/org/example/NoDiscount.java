package org.example;

import java.math.BigDecimal;

public class NoDiscount implements DiscountOffer {


    @Override
    public BigDecimal calculateDiscount(long quantity, BigDecimal price) {
        return new BigDecimal(quantity).multiply(price);
    }
}
