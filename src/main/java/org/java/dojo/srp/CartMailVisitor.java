package org.java.dojo.srp;

import java.util.Date;

public class CartMailVisitor implements IMailVisitor {
	private static final String NEW_LINE = System.getProperty("line.separator");
	protected String mailContentHead = null;
	protected String mailContentProduct = null;
	
	public CartMailVisitor()
	{
		mailContentHead = new String();
		mailContentProduct = new String();
	}
	
	public void visitCart(Date creationDate) {
		mailContentHead = "Bonjour," + NEW_LINE + "Votre panier composé le " + creationDate
		+ " comporte les éléments suivants :" + NEW_LINE;
		
	}

	public void visitProduct(String productName, float productPrice) {
		mailContentProduct += "- " + productName + " au prix de "
				+ productPrice + NEW_LINE;
		
	}

	public String computeMailContent() {
		return mailContentHead + mailContentProduct;
		
	}

}
