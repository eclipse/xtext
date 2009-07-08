/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.WeakHashMap;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleCache<Key, Value> {

	private final WeakHashMap<Key, Value> content;
	private final Function<Key, Value> f;

	public SimpleCache(Function<Key, Value> f) {
		if (f == null) {
			throw new IllegalArgumentException("function may not be null");
		}
		this.f = f;
		this.content = new WeakHashMap<Key, Value>();
	}

	public synchronized Value get(Key k) {
		Value result = content.get(k);
		if (result == null && !content.containsKey(k)) {
			result = f.apply(k);
			content.put(k, result);
		}
		return result;
	}

	public synchronized void clear() {
		content.clear();
	}

	public synchronized void discard(Key k) {
		content.remove(k);
	}
	
	// for testing purpose
	
	public synchronized boolean hasCachedValue(Key key) {
		return content.containsKey(key);
	}
	
	public synchronized int getSize() {
		return content.size();
	}

	public synchronized boolean isEmpty() {
		return content.isEmpty();
	}

}
