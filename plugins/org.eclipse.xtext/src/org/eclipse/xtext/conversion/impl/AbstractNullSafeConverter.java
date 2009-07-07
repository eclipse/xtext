/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.Stable;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <T>
 */
@Stable(since="0.7.0")
public abstract class AbstractNullSafeConverter<T> extends AbstractValueConverter<T> {

	public String toString(T value) {
		if (value == null)
			return null;
		return internalToString(value);
	}

	protected abstract String internalToString(T value);

	public T toValue(String string, AbstractNode node) throws ValueConverterException {
		if (string == null)
			return null;
		return internalToValue(string, node);
	}

	protected abstract T internalToValue(String string, AbstractNode node) throws ValueConverterException;

}
