package com.solodkyi.java_labs.Lab7.platform;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import com.solodkyi.java_labs.Lab7.Order;
import com.solodkyi.java_labs.Lab7.Product;
import com.solodkyi.java_labs.Lab7.User;
import com.solodkyi.java_labs.Lab7.comparators.ProductNameComparator;
import com.solodkyi.java_labs.Lab7.comparators.ProductStockComparator;

import java.util.ArrayList;

public class ECommercePlatform {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Product> products = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();
    private int orderIdCounter = 1;

    public void addUser(User user) {
        if (users.containsKey(user.getId())) {
            throw new IllegalArgumentException("User with this ID already exists.");
        }
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product with this ID already exists.");
        }
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        Order order = new Order(orderIdCounter++, userId, user.getCart());
        orders.put(order.getId(), order);
        user.clearCart();
    }

    public List<Product> listAvailableProducts() {
        return products.values().stream().filter(p -> p.getStock() > 0).collect(Collectors.toList());
    }

    public List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }

    public void updateProductStock(int productId, int newStock) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found.");
        }
        Product product = products.get(productId);
        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        product.setStock(newStock);
    }

    public List<Product> listProductsSortedByName() {
        return products.values().stream().sorted(new ProductNameComparator()).collect(Collectors.toList());
    }

    public List<Product> listProductsSortedByStock() {
        return products.values().stream().sorted(new ProductStockComparator()).collect(Collectors.toList());
    }

    public List<Product> filterProductsByAvailability() {
        return products.values().stream().filter(p -> p.getStock() > 0).collect(Collectors.toList());
    }
}