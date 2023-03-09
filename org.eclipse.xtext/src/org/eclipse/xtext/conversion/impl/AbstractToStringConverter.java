/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.IValueConverter;

/**
 * Abstract implementation of a {@link IValueConverter}, that does not fail on
 * <code>null</code>-Values and uses a simple {@link Object#toString()} to obtain
 * the {@link String} representation.
 */
public abstract class AbstractToStringConverter<T> extends AbstractNullSafeConverter<T> {

	@Override
	public final String internalToString(T value) {
		return value.toString();
	}

}
