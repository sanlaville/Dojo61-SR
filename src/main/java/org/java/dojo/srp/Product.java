package org.java.dojo.srp;

public class Product implements IProduct {

	private String name = null;
	private float price = 0;
	
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
