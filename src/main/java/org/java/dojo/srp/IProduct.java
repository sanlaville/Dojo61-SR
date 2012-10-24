package org.java.dojo.srp;

public interface IProduct {

	public float getPrice();

	public String getName();

	public void acceptProfileVisitor(IMailVisitor mailVisitor);

}