/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.web.test;

import java.util.HashMap;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

public class HashMapSession implements ISession {
	private final HashMap<Object, Object> map = new HashMap<Object, Object>();

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> T get(Object key) {
		return (T) this.map.get(key);
	}

	@Override
	public <T extends Object> T get(Object key, Function0<? extends T> factory) {
		synchronized (this.map) {
			T sessionValue = this.<T>get(key);
			if (sessionValue != null) {
				return sessionValue;
			} else {
				T factoryValue = factory.apply();
				put(key, factoryValue);
				return factoryValue;
			}
		}
	}

	@Override
	public void put(Object key, Object value) {
		map.put(key, value);
	}

	@Override
	public void remove(Object key) {
		map.remove(key);
	}
}
