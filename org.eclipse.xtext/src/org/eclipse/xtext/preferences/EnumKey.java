/*******************************************************************************
 * Copyright (c) 2021 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.26
 */
public class EnumKey<E extends Enum<E>> extends TypedPreferenceKey<E> {

	private final Class<E> type;

	protected EnumKey(String id, E defaultValue, Class<E> type) {
		super(id, defaultValue != null ? defaultValue.name() : null);
		this.type = type;
	}

	@Override
	public String toString(E value) {
		if (value != null) {
			return value.name();
		}
		return null;
	}

	@Override
	public E toValue(String string) {
		if (string != null) {
			return Enum.valueOf(type, string);
		}
		return null;
	}

}
