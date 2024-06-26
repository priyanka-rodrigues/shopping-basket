package org.example;

import java.math.BigDecimal;

public interface DiscountOffer {

    public BigDecimal calculateDiscount(long quantity, BigDecimal price);
}
