/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.configuration;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractConfigurationKeys implements IConfigurationKeys {

	private Map<String, IConfigurationKey<?>> name2key = null;

	protected Map<String, IConfigurationKey<?>> collectKeys() {
		Map<String, IConfigurationKey<?>> result = Maps.newLinkedHashMap();
		for (Field field : getClass().getFields()) {
			if (IConfigurationKey.class.isAssignableFrom(field.getType())) {
				try {
					IConfigurationKey<?> key = (IConfigurationKey<?>) field.get(this);
					result.put(key.getName(), key);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public IConfigurationKey<?> getKey(String keyName) {
		return getName2Keys().get(keyName);
	}

	public Collection<IConfigurationKey<?>> getKeys() {
		return getName2Keys().values();
	}

	protected Map<String, IConfigurationKey<?>> getName2Keys() {
		if (name2key == null)
			name2key = collectKeys();
		return name2key;
	}

}
