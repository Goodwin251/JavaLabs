package com.solodkyi.java_labs.Lab7Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.solodkyi.java_labs.Lab7.*;

class ProductTest {

    @Test
    void testValidProductCreation() {
        Product product = new Product(1, "Processor", 1000.0, 10);
        assertEquals(1, product.getId());
        assertEquals("Phone", product.getName());
        assertEquals(500.0, product.getPrice());
        assertEquals(10, product.getStock());
    }

    @Test
    void testSetNegativePrice() {
        Product product = new Product(1, "Processor", 1000.0, 10);
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(-50.0));
    }

    @Test
    void testSetNegativeStock() {
        Product product = new Product(1, "Processor", 1000.0, 10);
        assertThrows(IllegalArgumentException.class, () -> product.setStock(-5));
    }

    @Test
    void testSetNullProductName() {
        Product product = new Product(1, "Processor", 1000.0, 10);
        assertThrows(IllegalArgumentException.class, () -> product.setName(null));
    }
}