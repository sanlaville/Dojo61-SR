package org.java.dojo.srp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private List<Product> products = new ArrayList<Product>();

	private Client client;

	private boolean hasPaid = false;

	private final Date creationDate;

	public Cart(Client client, Date creationDate) {
		this.client = client;
		this.creationDate = creationDate;
	}

	public void addProduct(Product prod) {
		products.add(prod);
	}

	public void removeProduct(Product prod) {
		products.remove(prod);
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<String> getProductsNames() {
		List<String> names = new ArrayList<String>();
		for (Product product : products) {
			names.add(product.getName());
		}
		return names;
	}

	public float totalPrice() {
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}

	public boolean validate() {
		boolean ok = true;
		if (client.isSolvent()) {
			client.pay(totalPrice());
			hasPaid = true;
		} else {
			ok = false;
		}
		return ok;
	}

	public void save() throws IOException {
		ObjectOutputStream stream = new ObjectOutputStream(
				new FileOutputStream("cart.ser"));
		stream.writeObject(this);
		stream.close();
	}

	public String computeMailContent() {
		String content = "Bonjour," + NEW_LINE + "Votre panier composé le " + creationDate
				+ " comporte les éléments suivants :" + NEW_LINE;
		for (Product product : products) {
			content += "- " + product.getName() + " au prix de "
					+ product.getPrice() + NEW_LINE;
		}
		return content;
	}
}
