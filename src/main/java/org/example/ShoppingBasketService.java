package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingBasketService {
    public Map<Items, Long>  createBasket(List<String> shoppingList) {
        if (shoppingList.isEmpty()) throw new IllegalArgumentException("No items present");
       return shoppingList.stream()
               .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Items::getItemName, Collectors.counting()));
    }

    public String getBasketAmount(Map<Items, Long> myMap) {

        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Items, Long> mapCount : myMap.entrySet()) {

            Items item = mapCount.getKey();
            long quantity = mapCount.getValue();
            DiscountFactory discountFactory = new DiscountFactory();
            DiscountOffer offer = discountFactory.getOfferType(item);
            total = total.add(offer.calculateDiscount(quantity, item.getPrice()));
        }
       return formatAmount( total);
    }

    private static String formatAmount(BigDecimal totalAmount) {
        String output = "";
        if (totalAmount.compareTo(new BigDecimal("100")) >= 0) {
            BigDecimal pounds = totalAmount.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
            output = "£" + pounds.setScale(2,BigDecimal.ROUND_HALF_UP);
        } else {
            output = totalAmount.toString() + "p";
        }
        return output;
    }
}



