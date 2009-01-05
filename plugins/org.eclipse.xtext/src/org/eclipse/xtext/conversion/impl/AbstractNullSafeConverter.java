/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

public abstract class AbstractNullSafeConverter<T> implements IValueConverter<T> {

	public final String toString(T value) {
		if (value == null)
			return null;
		return internalToString(value);
	}

	protected abstract String internalToString(T value);

	public final T toValue(String string, AbstractNode node) {
		if (string == null)
			return null;
		return internalToValue(string, node);
	}

	protected abstract T internalToValue(String string, AbstractNode node);

}
