package org.eclipse.xtext.service.examples;

public class FooBar implements IFoo,IBar{
	private final String name;

	public FooBar(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
