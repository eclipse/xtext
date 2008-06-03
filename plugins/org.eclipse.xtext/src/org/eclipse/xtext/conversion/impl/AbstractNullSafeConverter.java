package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.IValueConverter;

public abstract class AbstractNullSafeConverter implements IValueConverter {

	public final String toString(Object value) {
		if (value == null)
			return null;
		return internalToString(value);
	}

	protected abstract String internalToString(Object value);

	public final Object toValue(String string) {
		if (string == null)
			return null;
		return internalToValue(string);
	}

	protected abstract Object internalToValue(String string);

}
