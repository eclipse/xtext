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
public class IntegerKey extends IPreferenceKey.AbstractKey<Integer> {

	private Integer defaultValue;

	public IntegerKey(String name, Integer defaultValue) {
		super(name);
		this.defaultValue = defaultValue;
	}
	
	public Integer stringToValue(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public String valueToString(Integer value) {
		return String.valueOf(value);
	}

	public Integer getDefaultValue() {
		return defaultValue;
	}

}
