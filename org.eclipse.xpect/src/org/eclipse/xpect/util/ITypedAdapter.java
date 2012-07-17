package org.eclipse.xpect.util;

public interface ITypedAdapter {
	ITypedProvider adapt(ITypedProvider provider, Class<?> expectedType);

	boolean canAdapt(ITypedProvider provider, Class<?> expectedType);
}
