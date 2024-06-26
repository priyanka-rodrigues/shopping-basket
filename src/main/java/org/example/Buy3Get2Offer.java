package org.example;

import java.math.BigDecimal;

public class Buy3Get2Offer implements DiscountOffer {
    @Override
    public BigDecimal calculateDiscount(long quantity, BigDecimal price) {

           quantity -= quantity/3;

        return new BigDecimal(quantity).multiply(price);


    }
}
