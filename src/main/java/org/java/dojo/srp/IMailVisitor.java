package org.java.dojo.srp;

import java.util.Date;

public interface IMailVisitor {

	public void visitCart(Date creationDate);

	public void visitProduct(String productName, float productPrice);
	
	public String computeMailContent();

}
