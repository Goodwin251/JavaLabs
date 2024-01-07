package com.solodkyi.java_labs.Lab7;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails = new HashMap<>();
    private double totalPrice;

    public Order(Integer id, Integer userId, Map<Product, Integer> orderDetails) {
        if (orderDetails == null || orderDetails.isEmpty()) {
            throw new IllegalArgumentException("Order details cannot be null or empty.");
        }

        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("Product in order details cannot be null.");
            }

            if (entry.getValue() <= 0) {
                throw new IllegalArgumentException("Product quantity in order details must be greater than zero.");
            }
        }

        this.id = id;
        this.userId = userId;
        this.orderDetails.putAll(orderDetails);
        calculateTotalPrice();
    }
    private void calculateTotalPrice() {
        totalPrice = 0;
        for(Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
    }

    public Integer getId() { return id; }
    public void setId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Order ID cannot be null.");
        }
        this.id = id;
    }


    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null.");
        }
        this.userId = userId;
    }

    public Map<Product, Integer> getOrderDetails() { return orderDetails; }

    public double getTotalPrice() { 
        calculateTotalPrice();
        return totalPrice; 
    }
}