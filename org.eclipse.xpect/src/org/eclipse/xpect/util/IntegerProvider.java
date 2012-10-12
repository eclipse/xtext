package org.eclipse.xpect.util;

import java.math.BigInteger;

public class IntegerProvider implements ITypedProvider {

	private String value;

	public IntegerProvider(String value) {
		this.value = value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType) {
		if (expectedType == Byte.class || expectedType == Byte.TYPE)
			return (T) new Byte(value);
		if (expectedType == Short.class || expectedType == Short.TYPE)
			return (T) new Short(value);
		if (expectedType == Integer.class || expectedType == Integer.TYPE)
			return (T) new Integer(value);
		if (expectedType == Long.class || expectedType == Long.TYPE)
			return (T) new Long(value);
		if (expectedType == BigInteger.class)
			return (T) new BigInteger(value);
		if (expectedType == String.class)
			return (T) value;
		return null;
	}

	@Override
	public boolean canProvide(Class<?> expectedType) {
		return expectedType == Byte.class || //
				expectedType == Byte.TYPE || //
				expectedType == Short.class || //
				expectedType == Short.TYPE || //
				expectedType == Integer.class || //
				expectedType == Integer.TYPE || //
				expectedType == Long.class || //
				expectedType == Long.TYPE || //
				expectedType == BigInteger.class || //
				expectedType == String.class;
	}

}
