package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBasketServiceTest {
    public ShoppingBasketService basketService;

    @BeforeEach
    void setUp() {
        basketService = new ShoppingBasketService();

    }

    @Test
    public void shouldReturnCorrectItemsWithCountInBasket() {
        List<String> itemsToBeInserted = List.of("Apple", "Banana", "Banana", "Apple", "Melon", "Melon", "Banana", "Banana");

        Map<Items, Long> actualdResult = basketService.createBasket(itemsToBeInserted);
        Assertions.assertEquals(3, actualdResult.size());
    }

    @Test
    public void shouldThrowExceptionIfListIsEmpty() {

        List<String> itemsToBeInserted = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.createBasket(itemsToBeInserted));

    }


    @Test
    public void shouldReturnCorrectOuputWhenInputNoDiscountPresent() {
        List<String> itemsToBeInserted = List.of("Apple", "Banana", "Banana", "Apple", "Banana", "Banana");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("£1.50",actual);
    }

    @Test
    public void shouldReturnCorrectOuputWhenEvenBuyOneGetOnePresent() {
        List<String> itemsToBeInserted = List.of("Apple", "Banana", "Banana", "Apple", "Banana", "Melon", "Banana","Melon");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("£2.00",actual);
    }

    @Test
    public void shouldReturnCorrectOuputWhenOddBuyOneGetOnePresent() {
        List<String> itemsToBeInserted = List.of("Melon","Apple", "Banana", "Banana", "Apple", "Banana", "Melon", "Banana","Melon","Melon");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("£2.50",actual);
    }

    @Test
    public void shouldReturnCorrectOuputWhenEvenBuyTwoGetThreePresent() {
        List<String> itemsToBeInserted = List.of("Lime", "Lime","Melon","Apple", "Banana", "Banana", "Apple", "Lime","Banana", "Melon", "Banana","Melon","Melon");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("£2.80",actual);
    }

    @Test
    public void shouldReturnCorrectOuputWhenOddBuyTwoGetThreePresent() {
        List<String> itemsToBeInserted = List.of("Melon","Apple", "Banana", "Banana", "Apple", "Banana", "Melon", "Banana","Melon","Melon", "Lime","Lime","Lime");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("£2.80",actual);
    }

    @Test
    public void shouldReturnCorrectInputWhenOnlyLimesPresent() {
        List<String> itemsToBeInserted = List.of("Lime", "Lime","Lime","Lime", "Lime","Lime","Lime");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("75p",actual);

    }
    @Test
    public void shouldReturnCorrectInputWhenOnlyLimesPresent1() {
        List<String> itemsToBeInserted = List.of("Lime", "Lime","Lime","Lime");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("45p",actual);

    }

    @Test
    public void shouldReturnCorrectInputWhenOnlyMelonsPresent() {
        List<String> itemsToBeInserted = List.of("Melon", "Melon","Melon","Melon", "Melon","Melon","Melon");
        Map<Items, Long> shoppingItems = basketService.createBasket(itemsToBeInserted);
        String actual = basketService.getBasketAmount(shoppingItems);
        assertEquals("£2.00",actual);

    }
}