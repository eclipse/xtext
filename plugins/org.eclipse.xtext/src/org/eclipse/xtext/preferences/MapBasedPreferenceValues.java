/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.Map;

public class MapBasedPreferenceValues implements IPreferenceValues {
	private final Map<String, String> values;

	public MapBasedPreferenceValues(Map<String, String> values) {
		this.values = values;
	}

	public String getPreference(PreferenceKey key) {
		String value = values.get(key.getId());
		return value == null ? key.getDefaultValue() : value;
	}

	public void put(String key, String value) {
		values.put(key, value);
	}

	public void clear() {
		values.clear();
	}

	public Map<String, String> getValues() {
		return values;
	}

}