package org.java.dojo.srp;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;

public class ProductTest {

	@Test
	public void acceptMailVisitor_Should_VisitThis()
	{
		// Given
		String expectedName = "MOCK PRODUCT NAME";
		float expectedPrice = new Random().nextFloat();
		IProduct product = new Product(expectedName,expectedPrice);
		
		IMailVisitor mailVisitor = Mockito.mock(IMailVisitor.class);
		
		// When
		product.acceptProfileVisitor(mailVisitor);
		
		// Then
		Mockito.verify(mailVisitor).visitProduct(expectedName, expectedPrice);
		Mockito.verifyNoMoreInteractions(mailVisitor);
	}
}
