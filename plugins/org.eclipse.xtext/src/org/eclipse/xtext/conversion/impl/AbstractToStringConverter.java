package org.eclipse.xtext.conversion.impl;


public abstract class AbstractToStringConverter extends AbstractNullSafeConverter {

	public final String internalToString(Object value) {
		return value.toString();
	}

}
