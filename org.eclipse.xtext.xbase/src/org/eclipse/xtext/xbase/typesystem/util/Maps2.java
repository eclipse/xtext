/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

/**
 * Provides {@link #newLinkedHashMapWithExpectedSize(int)}. Everything else should be obtained from {@link Maps}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Maps2 {

	/**
	 * Creates a {@code LinkedHashMap} instance, with a high enough "initial capacity" that it <i>should</i> hold
	 * {@code expectedSize} elements without growth. This behavior cannot be broadly guaranteed, but it is observed to
	 * be true for OpenJDK 1.6. It also can't be guaranteed that the method isn't inadvertently <i>oversizing</i> the
	 * returned map.
	 * 
	 * @param expectedSize
	 *            the number of elements you expect to add to the returned map
	 * @return a new, empty {@code LinkedHashMap} with enough capacity to hold {@code expectedSize} elements without resizing
	 * @throws IllegalArgumentException
	 *             if {@code expectedSize} is negative
	 */
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int expectedSize) {
		return new LinkedHashMap<K, V>(capacity(expectedSize)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void clear() {
				if (isEmpty())
					return;
				super.clear();
			}
		};
	}
	
	/**
	 * Puts a value into a map that supports lists as values.
	 * The list is created on-demand.
	 */
	public static <K, V> void putIntoListMap(K key, V value, Map<? super K, List<V>> map) {
		List<V> list = map.get(key);
		if (list == null) {
			list = Lists.newArrayListWithCapacity(2);
			map.put(key, list);
		}
		list.add(value);
	}
	
	/**
	 * Puts a value into a map that supports lists as values.
	 * The list is created on-demand.
	 */
	public static <K, V> void putIntoSetMap(K key, V value, Map<? super K, Set<V>> map) {
		Set<V> list = map.get(key);
		if (list == null) {
			list = Sets.newHashSetWithExpectedSize(2);
			map.put(key, list);
		}
		list.add(value);
	}
	
	/**
	 * Puts a value into a map that supports lists as values.
	 * The list is created on-demand.
	 */
	public static <K, V> void putAllIntoListMap(K key, Collection<? extends V> values, Map<? super K, List<V>> map) {
		List<V> list = map.get(key);
		if (list == null) {
			list = Lists.newArrayList(values);
			map.put(key, list);
		} else {
			list.addAll(values);
		}
	}

	/**
	 * Copied from {@link Maps#capacity(int)}.
	 */
	private static int capacity(int expectedSize) {
		if (expectedSize < 3) {
			Preconditions.checkArgument(expectedSize >= 0);
			return expectedSize + 1;
		}
		if (expectedSize < Ints.MAX_POWER_OF_TWO) {
			return expectedSize + expectedSize / 3;
		}
		return Integer.MAX_VALUE; // any large value
	}

}
