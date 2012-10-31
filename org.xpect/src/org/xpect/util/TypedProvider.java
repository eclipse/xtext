package org.xpect.util;

public class TypedProvider implements ITypedProvider {

	private Object value;

	public TypedProvider(Object value) {
		super();
		this.value = value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType) {
		if (expectedType.isInstance(value))
			return (T) value;
		return null;
	}

	@Override
	public boolean canProvide(Class<?> expectedType) {
		return expectedType.isInstance(value);
	}

}
