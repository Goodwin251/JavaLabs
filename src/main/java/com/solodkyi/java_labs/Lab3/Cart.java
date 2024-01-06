package com.solodkyi.java_labs.Lab3;
import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
	private ArrayList<Product> products = new ArrayList<Product>();

	public Cart() {
		this.products = new ArrayList<Product>();
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product... p) 
	{
		products.addAll(Arrays.asList(p));
	}
	public void removeProduct(Product p) 
	{
		boolean result = products.remove(p);
		if(!result) {throw new IllegalArgumentException("This product doesn't presented at cart!");}
	}
	
	
}
