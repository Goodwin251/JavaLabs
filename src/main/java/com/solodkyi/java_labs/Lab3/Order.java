package com.solodkyi.java_labs.Lab3;

import java.util.ArrayList;

public class Order {

    private final int orderId;
    private ArrayList<Product> products;
    private OrderStatus status;
 
       
    public Order(int orderId, Cart cart)
    {
        this.orderId = orderId;
        this.products = cart.getProducts();
        this.status = OrderStatus.CREATED;
    }

    public void PlaceOrder()
    {
        if(status == OrderStatus.PROCESSED) {
            throw new RuntimeException("Attempt to place already processed order");
        }
        if(products.isEmpty()) {
            throw new IllegalArgumentException("Attempt to place an order with no products");
        }
        this.status = OrderStatus.PENDING;
    }

    public void ProcessOrder()
    {
        if(status != OrderStatus.PENDING) {
            throw new IllegalArgumentException("Impossible to process non-placed order");
        }
        this.status = OrderStatus.PROCESSED;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProduts(ArrayList<Product> products) {
        if(status == OrderStatus.PROCESSED) {
            throw new RuntimeException("Order in process");
        }
        this.products = products;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }
}