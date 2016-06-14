/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BooleanKey extends TypedPreferenceKey<Boolean> {

	public BooleanKey(String id, Boolean defaultValue) {
		super(id, defaultValue.toString());
	}

	@Override
	public String toString(Boolean value) {
		return value.toString();
	}

	@Override
	public Boolean toValue(String string) {
		if (string != null)
			return Boolean.valueOf(string);
		return Boolean.valueOf(getDefaultValue());
	}

}
