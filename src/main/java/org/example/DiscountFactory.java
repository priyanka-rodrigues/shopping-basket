package org.example;

import com.sun.source.tree.CaseTree;

public class DiscountFactory {

    public DiscountOffer getOfferType(Items item) {
        return switch (item) {
            case MELONS -> new BuyOneGetOne();
            case LIMES -> new Buy3Get2Offer();
            default -> new NoDiscount();

        };
    }
}