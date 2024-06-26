package org.example;

import java.math.BigDecimal;

public class BuyOneGetOne implements DiscountOffer {
    @Override
    public BigDecimal calculateDiscount(long quantity, BigDecimal price) {

        long count = quantity / 2;
        long rem = quantity % 2;
        quantity = count + rem;
        return new BigDecimal(quantity).multiply(price);

    }


}
