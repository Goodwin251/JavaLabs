package com.solodkyi.java_labs.Lab3Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab3.*;

public class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("testId1", "testProd0", 12.3);
    }
    @Test
    void productWithIllegalName() {
        assertThrows(IllegalArgumentException.class, () -> new Product("testId1", "", 2.2));
    }
    @Test
    void productWithIllegalPrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("testId1", "testProduct0", 0));
        assertThrows(IllegalArgumentException.class, () -> new Product("testId2", "testProduct0", -1));
    }
    @Test
    void setProductWithIllegalPrice() {
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(0));
        assertThrows(IllegalArgumentException.class, () -> product.setPrice(-10));
    }
}
