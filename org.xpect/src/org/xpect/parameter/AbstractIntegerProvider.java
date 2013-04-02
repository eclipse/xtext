/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameter;

import java.lang.annotation.Annotation;
import java.math.BigInteger;
import java.util.Map;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractIntegerProvider implements IParameterProvider {

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

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType, Map<Class<? extends Annotation>, IParameterProvider> context) {
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
