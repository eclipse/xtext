/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.Map;

import org.eclipse.xtext.preferences.IPreferenceValues.AbstractPreferenceValues;

public class MapBasedPreferenceValues extends AbstractPreferenceValues {
	private final Map<String,String> values ;
	
	public MapBasedPreferenceValues(Map<String, String> values) {
		this.values = values;
	}

	@Override
	protected String internalGet(String id) {
		return values.get(id);
	}
	
	public <T> void put(IPreferenceKey<T> key, T value) {
		this.put(key.getId(), key.valueToString(value));
	}
	
	public void put(String key, String value) {
		values.put(key, value);
	}
}