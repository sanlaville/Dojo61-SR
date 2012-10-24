package org.java.dojo.srp;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private Cart cart = null;
	
	private Logger logger = LoggerFactory.getLogger("org.java.dojo.srp.Main");

	
	public static void main(String[] args) {
		Main main = new Main();
		
		main.initCart();
		main.displayMailContent();
	}

	private void initCart() {
		Date date = new Date();
		
		cart = new Cart(null, date);
		Random ran = new Random();
		for (int i = 0; i < 5; i++) {
			cart.addProduct(new Product("product" + i, ran.nextFloat()));
		}		
	}

	private void displayMailContent() {
		logger.info(NEW_LINE + "********** Display MailContent - Method 1: use of method cart.computeMailContent() **********" + NEW_LINE + cart.computeMailContent());
	}
	
}
