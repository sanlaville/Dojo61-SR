package org.java.dojo.srp;

import java.util.Date;
import java.util.Random;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class CartMailVisitorTest {

	private static final String NEW_LINE = System.getProperty("line.separator");

	@Test
	public void visitCart_Should_DefineTheMailContentHead() {
		// Given
		CartMailVisitor mailVisitor = new CartMailVisitor();

		Date creationDate = Mockito.mock(Date.class);
		String creationDateStr = "MOCK CREATION DATE";
		Mockito.when(creationDate.toString()).thenReturn(creationDateStr);

		// When
		mailVisitor.visitCart(creationDate);

		// Then
		String expectedMailContentHead = "Bonjour," + NEW_LINE + "Votre panier composé le "
				+ creationDate + " comporte les éléments suivants :" + NEW_LINE;
		Assertions.assertThat(mailVisitor.mailContentHead).isEqualTo(
				expectedMailContentHead);
	}

	@Test
	public void visitProduct_forTheFirstProduct_Should_StartTheMailContentProductWithANewProduct() {
		// Given
		CartMailVisitor mailVisitor = new CartMailVisitor();

		String productName = "MOCK PRODUCT NAME";
		float productPrice = new Random().nextFloat();

		// When
		mailVisitor.visitProduct(productName, productPrice);

		// Then
		String expectedContent = "- " + productName + " au prix de "
				+ productPrice + NEW_LINE;
		Assertions.assertThat(mailVisitor.mailContentProduct).isEqualTo(
				expectedContent);
	}

	@Test
	public void visitProduct_forAnotherProduct_Should_AddANewProductToTheMailContent() {
		// Given
		CartMailVisitor mailVisitor = new CartMailVisitor();

		String productName = "MOCK PRODUCT NAME";
		float productPrice = new Random().nextFloat();

		String startMailContextProduct = "MOCK MAIL CONTEXT PRODUCT" + NEW_LINE;
		mailVisitor.mailContentProduct = startMailContextProduct;

		// When
		mailVisitor.visitProduct(productName, productPrice);

		// Then
		String expectedContent = startMailContextProduct + "- " + productName
				+ " au prix de " + productPrice + NEW_LINE;
		Assertions.assertThat(mailVisitor.mailContentProduct).isEqualTo(
				expectedContent);
	}
	
	@Test
	public void computeMailContent_ShouldReturn_TheMailContentHeadFollowingByTheMailContextProduct()
	{
		// Given
		CartMailVisitor mailVisitor = new CartMailVisitor();
		String mailContextHead = "MOCK MAIL CONTEXT HEAD" + NEW_LINE;
		mailVisitor.mailContentHead = mailContextHead;
		String mailContextProduct = "MOCK MAIL CONTEXT PRODUCT" + NEW_LINE;
		mailVisitor.mailContentProduct = mailContextProduct;
		
		// When
		String actualMailContent = mailVisitor.computeMailContent();
		
		// Then
		String expectedMailContent = mailContextHead + mailContextProduct;
		Assertions.assertThat(actualMailContent).isEqualTo(expectedMailContent);
		
	}

}
