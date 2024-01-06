package com.solodkyi.java_labs.Lab3;

public class Product {

	private String id;
	private String name;
	private double price;

	public Product(String id, String name, double price) {
		if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price can't be <= 0");
        }
		
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price <= 0) {
            throw new IllegalArgumentException("Price can't be <= 0");
        }
		this.price = price;
	}
}
