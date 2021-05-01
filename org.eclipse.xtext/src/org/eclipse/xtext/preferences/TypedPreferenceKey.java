/*******************************************************************************
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * Typed extension to {@link PreferenceKey preference keys}
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.26
 */
public abstract class TypedPreferenceKey<T> extends PreferenceKey {

	/**
	 * Constructor that uses the internal representation of the default value.
	 * Concrete implementations are expected to offer a constructor with a 
	 * type-safe default value.
	 */
	protected TypedPreferenceKey(String id, String defaultValue) {
		super(id, defaultValue);
	}

	/**
	 * Convert the given value to its string representation.
	 * 
	 * A null value is converted to a null string.
	 */
	public abstract String toString(T value);

	/**
	 * Convert the given string to its type-safe value.
	 * 
	 * The null string is converted to the null value.
	 * 
	 * @throws IllegalArgumentException if the given string is not a valid representation.
	 */
	public abstract T toValue(String string);
	
}
