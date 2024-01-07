package com.solodkyi.java_labs.Lab7Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab7.*;
import com.solodkyi.java_labs.Lab7.platform.ECommercePlatform;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ECommercePlatformTest {

    private ECommercePlatform platform;
    private User user1;
    private Product product1;

    @BeforeEach
    void setUp() {
        platform = new ECommercePlatform();
        user1 = new User(1, "Jeb");
        product1 = new Product(1, "Processor", 1000.0, 10);
    }

    @Test
    void testAddUser() {
        platform.addUser(user1);
        List<User> users = platform.listUsers();
        assertTrue(users.contains(user1));
    }

    @Test
    void testAddUserWithExistingId() {
        platform.addUser(user1);
        assertThrows(IllegalArgumentException.class, () -> platform.addUser(user1));
    }

    @Test
    void testAddProduct() {
        platform.addProduct(product1);
        List<Product> products = platform.listAvailableProducts();
        assertTrue(products.contains(product1));
    }

    @Test
    void testAddProductWithExistingId() {
        platform.addProduct(product1);
        assertThrows(IllegalArgumentException.class, () -> platform.addProduct(product1));
    }

    @Test
    void testCreateOrder() {
        platform.addUser(user1);
        platform.addProduct(product1);
        user1.addToCart(product1, 1);
        platform.createOrder(user1.getId());
        List<Order> orders = platform.listOrders();
        assertFalse(orders.isEmpty());
    }

    @Test
    void testCreateOrderForNonexistentUser() {
        assertThrows(IllegalArgumentException.class, () -> platform.createOrder(999));
    }

    @Test
    void testUpdateProductStock() {
        platform.addProduct(product1);
        platform.updateProductStock(product1.getId(), 20);
        assertEquals(20, product1.getStock());
    }

    @Test
    void testUpdateProductStockForNonexistentProduct() {
        assertThrows(IllegalArgumentException.class, () -> platform.updateProductStock(999, 10));
    }

    @Test
    void testUpdateProductStockToNegativeValue() {
        platform.addProduct(product1);
        assertThrows(IllegalArgumentException.class, () -> platform.updateProductStock(product1.getId(), -10));
    }

    @Test
    void testListProductsSortedByName() {
        Product product2 = new Product(2, "Apple", 5.0, 50);
        platform.addProduct(product1);
        platform.addProduct(product2);
        List<Product> sortedProducts = platform.listProductsSortedByName();
        assertEquals(product2, sortedProducts.get(0));
    }

    @Test
    void testListProductsSortedByStock() {
        Product product2 = new Product(2, "Apple", 5.0, 50);
        platform.addProduct(product1);
        platform.addProduct(product2);
        List<Product> sortedProducts = platform.listProductsSortedByStock();
        assertEquals(product1, sortedProducts.get(0));
    }

    @Test
    void testFilterProductsByAvailability() {
        Product product2 = new Product(2, "Apple", 5.0, 0);
        platform.addProduct(product1);
        platform.addProduct(product2);
        List<Product> availableProducts = platform.filterProductsByAvailability();
        assertFalse(availableProducts.contains(product2));
    }
}