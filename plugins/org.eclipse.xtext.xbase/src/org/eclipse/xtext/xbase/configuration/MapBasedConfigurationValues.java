/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

import java.util.Map;

import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MapBasedConfigurationValues extends AbstractConfigurationValues {

	private final Map<IConfigurationKey<?>, ? super Object> key2value;

	public MapBasedConfigurationValues(IConfigurationKeys keys) {
		super(keys);
		this.key2value = Maps.newLinkedHashMap();
	}

	public MapBasedConfigurationValues(IConfigurationKeys keys, Map<String, String> values) {
		this(keys);
		load(values);
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

	public void load(Map<String, String> values) {
		Function<String, String> map = Functions.forMap(values, null);
		for (IConfigurationKey<?> key : getKeys().getKeys())
			if (key instanceof IConfigurationKeyWithStorage<?>)
				key2value.put(key, ((IConfigurationKeyWithStorage<?>) key).load(map));
	}

	public <T> void put(IConfigurationKey<T> key, T value) {
		key2value.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> store() {
		final Map<String, String> stored = Maps.newLinkedHashMap();
		IAcceptor<Pair<String, String>> acceptor = new IAcceptor<Pair<String, String>>() {
			public void accept(Pair<String, String> t) {
				stored.put(t.getFirst(), t.getSecond());
			}
		};
		for (IConfigurationKey<?> key : getKeys().getKeys())
			if (key instanceof IConfigurationKeyWithStorage<?>)
				((IConfigurationKeyWithStorage<Object>) key).store(get(key), acceptor);
		return stored;
	}

}
