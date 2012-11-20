/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting;

import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.core.formatting.AbstractConfigurationValues;
import org.eclipse.xtend.core.formatting.IConfigurationKey;
import org.eclipse.xtend.core.formatting.IConfigurationKeyWithStorage;
import org.eclipse.xtend.core.formatting.IConfigurationKeys;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PreferenceStoreBasedConfigurationValues extends AbstractConfigurationValues {

	private final Map<IConfigurationKey<?>, ? super Object> key2value;

	public PreferenceStoreBasedConfigurationValues(IConfigurationKeys keys) {
		super(keys);
		this.key2value = Maps.newLinkedHashMap();
	}

	public PreferenceStoreBasedConfigurationValues(IConfigurationKeys keys, IPreferenceStore store) {
		this(keys);
		load(store);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(IConfigurationKey<T> key) {
		T result = (T) key2value.get(key);
		if (result != null)
			return result;
		return key.getDefaultValue();
	}

	public Map<IConfigurationKey<?>, ?> getKeyToValueMap() {
		return key2value;
	}

	public void load(final IPreferenceStore store) {
		Function<String, String> storeAccess = new Function<String, String>() {
			public String apply(String val) {
				return store.getString(val);
			}
		};
		for (IConfigurationKey<?> key : getKeys().getKeys())
			if (key instanceof IConfigurationKeyWithStorage<?>)
				key2value.put(key, ((IConfigurationKeyWithStorage<?>) key).load(storeAccess));
	}

}
