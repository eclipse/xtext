package org.xpect.util;

public interface ITypedProvider {
	<T> T get(Class<T> expectedType);

	boolean canProvide(Class<?> expectedType);
}
