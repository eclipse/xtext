/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.google.common.base.Function;

/**
 * A primitive cache implementation. The SimpleCache allows to cache 
 * lazily computable values. Subsequent calls to the computation algorithm with equal
 * parameters have to yield equal results.
 * Attention: The algorithm may not depend on itself in a circular manner. E.g. the following will lead 
 * to a stack overflow:
 * <pre>
 * SimpleCache&lt;K, V&gt; cache = new SimpleCache&lt;K, V&gt;(new Function&lt;K, V&gt;() {
 *   public V apply(K k) {
 *     // DON'T DO THIS
 *     if (k == k1) {
 *       return cache.get(k2).method();
 *     } else if (k == k2) {
 *       return cache.get(k1).method();
 *     }
 *     return null;
 *   }
 * });
 * </pre>
 * The cache uses weak references to the keys but the values are strongly referenced. This leads
 * to the conclusion, that the computed values should not refer to the keys because no cache entry
 * will be reclaimend automatically. In such cases, clients have to discard the values for a key explicitly.
 * 
 * Please note that {@link Function#apply(Object)} may be invoked concurrently while the cache
 * itself is threadsafe.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleCache<Key, Value> {

	private final Map<Key, Value> content;
	private final ReentrantReadWriteLock readWriteLock;
	private final ReadLock readLock;
	private final WriteLock writeLock;
	private final Function<Key, Value> f;

	public SimpleCache(Function<Key, Value> f) {
		if (f == null) {
			throw new IllegalArgumentException("function may not be null");
		}
		this.readWriteLock = new ReentrantReadWriteLock();
		this.readLock = readWriteLock.readLock();
		this.writeLock = readWriteLock.writeLock();
		this.f = f;
		this.content = new WeakHashMap<Key, Value>();
	}

	public Value get(Key k) {
		Value result = null;
		try {
			readLock.lock();
			result = content.get(k);
			if (result != null || content.containsKey(k))
				return result;
		} finally {
			readLock.unlock();
		}
		result = f.apply(k);
		try {
			writeLock.lock();
			// f.apply(k) should produce equal results for equal keys
			// it is save to put the new result without checking for a
			// value that has been set meanwhile
			content.put(k, result);
		} finally {
			writeLock.unlock();
		}
		return result;
	}

	public void clear() {
		try {
			writeLock.lock();
			if (!content.isEmpty())
				content.clear();
		} finally {
			writeLock.unlock();
		}
	}

	public void discard(Key k) {
		try {
			writeLock.lock();
			content.remove(k);
		} finally {
			writeLock.unlock();
		}
	}
	
	// for testing purpose
	
	public boolean hasCachedValue(Key key) {
		try {
			readLock.lock();
			return content.containsKey(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public int getSize() {
		try {
			readLock.lock();
			return content.size();
		} finally {
			readLock.unlock();
		}
	}

	public boolean isEmpty() {
		try {
			readLock.lock();
			return content.isEmpty();
		} finally {
			readLock.unlock();
		}
	}

}
