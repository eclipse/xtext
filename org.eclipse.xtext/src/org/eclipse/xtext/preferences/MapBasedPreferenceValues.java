/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @since 2.26
 */
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
		this(null, new LinkedHashMap<>());
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
		return Collections.unmodifiableMap(values);
	}

	/**
	 * Put the given preference value under the given key into this store.
	 * If the value is null, it's being removed from this store.
	 */
	public void put(PreferenceKey key, Object value) {
		if (value == null) {
			values.remove(key.getId());
		} else {
			put(key.getId(), value.toString());
		}
	}

	/**
	 * Put the given preference value under the given key into this store.
	 * If the value is null, it's being removed from this store.
	 */
	public void put(String key, String value) {
		if (value == null) {
			values.remove(key);
		} else {
			values.put(key, value);
		}
	}

	/**
	 * Put the given preference value under the given key into this store.
	 * If the value is null, it's being removed from this store.
	 */
	public <T> void put(TypedPreferenceKey<T> key, T value) {
		put(key.getId(), key.toString(value));
	}

	@Override
	public String toString() {
		return values.toString();
	}

}