package com.solodkyi.java_labs.Lab3Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.solodkyi.java_labs.Lab3.*;

public class OrderTest {
    private Cart cart;
    @BeforeEach
    void setUp() {
        cart = new Cart();

        Product product1 = new Product("testId1", "testProd0", 100);
        Product product2 = new Product("testId2", "testProd1", 111.11);

        cart.addProduct(product1, product2);
    }

    @Test
    public void testGetOrderStatus() {
        Order order = new Order(1, cart);
        assertEquals(OrderStatus.CREATED, order.getStatus());

        order.PlaceOrder();
        assertEquals(OrderStatus.PENDING, order.getStatus());

        order.ProcessOrder();
        assertEquals(OrderStatus.PROCESSED, order.getStatus());
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order(1, cart);
        assertEquals(1, order.getOrderId());
        assertEquals(OrderStatus.CREATED, order.getStatus());
        assertEquals(cart.getProducts(), order.getProducts());
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order(1, cart);
        order.PlaceOrder();
        assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    public void testPlaceEmptyOrder() {
        Order order = new Order(1, new Cart());
        assertThrows(IllegalArgumentException.class, order::PlaceOrder);
    }
    @Test
    public void testPlaceProcessedOrder() {
    	Order order = new Order(1, cart);
    	order.PlaceOrder();
    	order.ProcessOrder();
    	
    	assertThrows(RuntimeException.class, order::PlaceOrder);
    }
    @Test
    public void testProcessOrder() {
        Order order = new Order(1, cart);

        order.PlaceOrder();
        order.ProcessOrder();

        assertEquals(OrderStatus.PROCESSED, order.getStatus());
    }

    @Test
    public void testProcessNonPlacedOrder() {
        Order order = new Order(1, cart);
        assertThrows(IllegalArgumentException.class, order::ProcessOrder);
    }

    @Test
    public void testSetProductsOnProcessedOrder() {
        Order order = new Order(1, cart);

        order.PlaceOrder();
        order.ProcessOrder();
        
        assertThrows(RuntimeException.class, () -> order.setProduts(new ArrayList<>()));
    }
}