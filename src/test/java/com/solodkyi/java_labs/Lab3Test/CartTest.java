package com.solodkyi.java_labs.Lab3Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab3.*;

public class CartTest {
    
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void testAddItems() {
        Product prod1 = new Product("testId0", "testProd0", 100);
        Product prod2 = new Product("testId1", "testProd1", 111.11);

        cart.addProduct(prod1, prod2);
        ArrayList<Product> productsInCart = cart.getProducts();

        assertTrue(productsInCart.contains(prod1));
        assertTrue(productsInCart.contains(prod2));
    }

    @Test
    void testDelExistingItem() {
        Product product1 = new Product("testId0", "testProd0", 100);
        cart.addProduct(product1);
        cart.removeProduct(product1);
        ArrayList<Product> productsInCart = cart.getProducts();
        assertFalse(productsInCart.contains(product1));
    }

    @Test
    void testDelNonExistingItem() {
        Product product1 = new Product("testId1", "testProd0", 100);
        assertThrows(RuntimeException.class, () -> cart.removeProduct(product1));
    }
}