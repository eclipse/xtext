package org.eclipse.xpect.util;

import java.math.BigInteger;

public abstract class AbstractIntegerProvider implements ITypedProvider {

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

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType) {
		if (expectedType == Byte.class || expectedType == Byte.TYPE)
			return (T) new Byte(getValue());
		if (expectedType == Short.class || expectedType == Short.TYPE)
			return (T) new Short(getValue());
		if (expectedType == Integer.class || expectedType == Integer.TYPE)
			return (T) new Integer(getValue());
		if (expectedType == Long.class || expectedType == Long.TYPE)
			return (T) new Long(getValue());
		if (expectedType == BigInteger.class)
			return (T) new BigInteger(getValue());
		if (expectedType == String.class)
			return (T) getValue();
		return null;
	}

	protected abstract String getValue();

}
