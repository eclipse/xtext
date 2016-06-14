/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Maps;

public class MapBasedPreferenceValues implements ITypedPreferenceValues, IPreferenceValuesProvider {
	private final IPreferenceValues delegate;
	private final Map<String, String> values;

	/**
	 * Creates preference values that are backed by the given {@code values} {@link Map}.
	 * The values map is used as is. Subsequent changes to {@code values} will be reflected
	 * by this preference instance and modifying operations on the preferences will be done
	 * on the given map.
	 */
	public MapBasedPreferenceValues(IPreferenceValues delegate, Map<String, String> values) {
		this.delegate = delegate;
		this.values = values;
	}

	public MapBasedPreferenceValues(Map<String, String> values) {
		this(null, values);
	}
	
	public MapBasedPreferenceValues() {
		this(null, Maps.<String, String>newLinkedHashMap());
	}

	public void clear() {
		values.clear();
	}

	public IPreferenceValues getDelegate() {
		return delegate;
	}

	@Override
	public String getPreference(PreferenceKey key) {
		String value = values.get(key.getId());
		if (value != null)
			return value;
		if (delegate != null)
			return delegate.getPreference(key);
		return key.getDefaultValue();
	}

	@Override
	public <T> T getPreference(TypedPreferenceKey<T> key) {
		String string = getPreference((PreferenceKey) key);
		T result = key.toValue(string);
		return result;
	}

	@Override
	public IPreferenceValues getPreferenceValues(Resource context) {
		return this;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void put(PreferenceKey key, Object value) {
		put(key.getId(), value.toString());
	}

	public void put(String key, String value) {
		values.put(key, value);
	}

	public <T> void put(TypedPreferenceKey<T> key, T value) {
		put(key.getId(), key.toString(value));
	}

	@Override
	public String toString() {
		return values.toString();
	}

}