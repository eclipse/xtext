package org.eclipse.xpect.lib;

public interface ITypedAdapter {
	ITypedProvider adapt(ITypedProvider provider, Class<?> expectedType);

	boolean canAdapt(ITypedProvider provider, Class<?> expectedType);
}
