package com.solodkyi.java_labs.Lab7;

import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart = new HashMap<>();

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.username = username;
    }

    public Map<Product, Integer> getCart() { return cart; }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }


    public void removeFromCart(Product product) {
        if (!cart.containsKey(product)) {
            throw new IllegalArgumentException("Product not found in cart.");
        }
        cart.remove(product);
    }


    public void updateCart(Product product, int quantity) {
        if(cart.containsKey(product)) {
            cart.put(product, quantity);
        }
    }

    public void clearCart() {
        cart.clear();
    }
}
