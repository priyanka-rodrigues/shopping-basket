package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> shoppingBasket = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the items(Apple,Banana,Lime,Melon) to add to your basket. Enter stop to finish");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("stop")) {
                break;
            } else {
                shoppingBasket.add(input);
            }
        }

        scanner.close();

        ShoppingBasketService basket = new ShoppingBasketService();
        Map<Items, Long> shoppingItems = basket.createBasket(shoppingBasket);
        String result = basket.getBasketAmount(shoppingItems);
        System.out.println("Total amount: " + result);

    }

}