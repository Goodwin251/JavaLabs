package com.solodkyi.java_labs.Lab3;

public class App {

	public static void main(String[] args) {
		
        Product prod1 = new Product("bread1", "Bread", 14.11);
        Product prod2 = new Product("drink13", "CocaCola", 24.99);
        Product prod3 = new Product("beer6", "Obolon", 43.23);
        		
        Cart cart = new Cart();
        
        cart.addProduct(prod1, prod2, prod3);
        System.out.println(cart.getProducts().toString());
        
        cart.removeProduct(prod2);
        System.out.println(cart.getProducts().toString());
        
        Order order = new Order(0, cart);
        System.out.println(order.getStatus());

        order.PlaceOrder();
        System.out.println(order.getStatus());
        
        order.ProcessOrder();
        System.out.println(order.getStatus());
        
        
	}

}
