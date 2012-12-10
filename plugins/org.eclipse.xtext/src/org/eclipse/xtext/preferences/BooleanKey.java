/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;


/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sven Efftinge
 */
public class BooleanKey extends IPreferenceKey.AbstractKey<Boolean> {

	private final boolean defaultValue;

	public BooleanKey(String name, boolean defaultValue) {
		super(name);
		this.defaultValue = defaultValue;
	}
	
	public Boolean stringToValue(String value) {
		return Boolean.parseBoolean(value);
	}

	public String valueToString(Boolean value) {
		return String.valueOf(value);
	}

	public Boolean getDefaultValue() {
		return defaultValue;
	}

}
