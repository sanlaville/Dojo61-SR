package org.java.dojo.srp;

import java.util.Date;
import java.util.Random;

import org.fest.assertions.api.Assertions;
import org.junit.Test;


public class CartIT {
	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	@Test
	public void define_Cart_computeMailContent()
	{
		// Given
		Date date = new Date();
		Cart cart = new Cart(null, date);
		
		
		Random ran = new Random();
		Product product = null;
		String expectedContentMail = "Bonjour," + NEW_LINE + "Votre panier composé le " + date
				+ " comporte les éléments suivants :" + NEW_LINE;
		for (int i = 0; i < 5; i++) {
			product = new Product("product" + i, ran.nextFloat());
			cart.addProduct(product);
			expectedContentMail += "- " + product.getName() + " au prix de "
					+ product.getPrice() + NEW_LINE;
		}	
		
		// When
		String actualMailContent = cart.computeMailContent();
		
		// Then
		Assertions.assertThat(actualMailContent).isEqualTo(expectedContentMail);
	}
}
