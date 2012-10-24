package org.java.dojo.srp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;


public class CartTest {
	
	@Test
	public void acceptMailVisitor_ShouldVisitThis_AndAcceptVisitorOnProducts()
	{
		// Given
		Date creationDate = Mockito.mock(Date.class);
	    Cart cart = new Cart(null, creationDate);
	    List<IProduct> products = new ArrayList<IProduct>();
	    for (int i = 0; i < 4; ++i) {
	      cart.addProduct(Mockito.mock(IProduct.class));
	    }
	    
	    IMailVisitor mailVisitor = Mockito.mock(IMailVisitor.class);

	    // When
	    cart.acceptMailVisitor(mailVisitor);

	    // Then
	    Mockito.verify(mailVisitor).visitCart(creationDate);
	    for (IProduct product : products) {
	      Mockito.verify(product).acceptProfileVisitor(mailVisitor);
	    }
	}

}
