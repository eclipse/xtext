package org.eclipse.xpect.lib;

public interface ITypedProvider {
	<T> T get(Class<T> expectedType);

	boolean canProvide(Class<?> expectedType);
}
