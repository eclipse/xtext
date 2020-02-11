/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractNullSafeConverter<T> extends AbstractValueConverter<T> {

	@Override
	public String toString(T value) {
		if (value == null)
			return null;
		return internalToString(value);
	}

	protected abstract String internalToString(T value);

	@Override
	public T toValue(String string, INode node) throws ValueConverterException {
		if (string == null)
			return null;
		return internalToValue(string, node);
	}

	protected abstract T internalToValue(String string, INode node) throws ValueConverterException;

}
