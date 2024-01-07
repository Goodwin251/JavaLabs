package com.solodkyi.java_labs.Lab3Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.solodkyi.java_labs.Lab3.*;

public class ProgramTest {
	@Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        cart.addProduct(new Product("basic_need_1", "Water", 5.6));
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product product = new Product("sweets_cupcake_1", "Cupcake", 124.4);
        cart.addProduct(product);
        cart.removeProduct(product);
        assertEquals(0, cart.getProducts().size());
    }
    
    @Test
    public void testPlaceOrder() {
        Cart cart = mock(Cart.class);
        Product product = new Product("drink1", "CocaCola", 21.4);
        ArrayList<Product> p = new ArrayList<Product>();
        p.add(product);
        when(cart.getProducts()).thenReturn(p);
        Order order = new Order(1, cart);
        assertEquals(p, cart.getProducts());
        assertEquals(p.size(), order.getProducts().size());
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    public void testUpdateOrderStatus() {
        Order order = new Order(1, new Cart());
        order.setStatus(OrderStatus.PROCESSED);
        assertEquals(OrderStatus.PROCESSED, order.getStatus());
    }

    @Test
    public void testGetOrderStatus() {
        Order order = mock(Order.class);
        when(order.getStatus()).thenReturn(OrderStatus.PROCESSED);
        OrderStatus status = order.getStatus();
        assertEquals(OrderStatus.PROCESSED, status);
    }
}
