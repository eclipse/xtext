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
 * A representation of an integer valued preference.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.26
 */
public class IntegerKey extends TypedPreferenceKey<Integer> {

	public IntegerKey(String id, Integer defaultValue) {
		super(id, defaultValue != null ? defaultValue.toString() : null);
	}

	@Override
	public String toString(Integer value) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}

	@Override
	public Integer toValue(String string) {
		try {
			if (string != null) {
				return Integer.valueOf(string);
			}
			return null;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(string + " is not a valid integer preference value", e);
		}
	}

}
