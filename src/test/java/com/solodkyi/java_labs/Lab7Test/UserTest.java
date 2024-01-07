package com.solodkyi.java_labs.Lab7Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.solodkyi.java_labs.Lab7.*;

class UserTest {

    Product product = new Product(1, "Keyboard", 500.0, 10);
    Product product2 = new Product(2, "Processor", 1000.0, 5);

    @Test
    void testAddProductToCart() {
        User user = new User(1, "Bob");
        user.addToCart(product, 2);
        assertEquals(2, user.getCart().get(product).intValue());
    }

    @Test
    void testRemoveProductFromCart() {
        User user = new User(1, "Bob");
        user.addToCart(product, 2);
        user.removeFromCart(product);
        assertFalse(user.getCart().containsKey(product));
    }

    @Test
    void testRemoveNonExistentProductFromCart() {
        User user = new User(1, "Bob");
        assertThrows(IllegalArgumentException.class, () -> user.removeFromCart(product2));
    }

    @Test
    void testAddNegativeQuantityToCart() {
        User user = new User(1, "Bob");
        assertThrows(IllegalArgumentException.class, () -> user.addToCart(product, -5));
    }

    @Test
    void testSetNullUsername() {
        User user = new User(1, "Bob");
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null));
    }
}