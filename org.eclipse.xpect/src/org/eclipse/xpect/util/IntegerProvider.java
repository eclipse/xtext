package org.eclipse.xpect.util;

public class IntegerProvider extends AbstractIntegerProvider {

	private String value;

	public IntegerProvider(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

}
