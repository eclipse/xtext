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
 * A boolean preference key.
 * 
 * Valid representations are "true" and "false".
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.26
 */
public class BooleanKey extends TypedPreferenceKey<Boolean> {

	public BooleanKey(String id, Boolean defaultValue) {
		super(id, defaultValue != null ? defaultValue.toString() : null);
	}

	@Override
	public String toString(Boolean value) {
		if (value != null) {
			return value.toString();
		}
		return null;
	}

	
	@Override
	public Boolean toValue(String string) {
		if (string == null) {
			return null;
		}
		switch(string) {
		case "true" : return Boolean.TRUE;
		case "false": return Boolean.FALSE;
		default:
			throw new IllegalArgumentException(string + " is not a valid boolean preference value");
		}
	}

}
