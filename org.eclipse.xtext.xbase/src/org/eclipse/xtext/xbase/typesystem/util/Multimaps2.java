/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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

import com.google.common.base.Supplier;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * Provides static creating a {@link #newLinkedHashListMultimap() LinkedHashListMultimap}.
 * 
 * @see Multimaps
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Multimaps2 {

	/**
	 * Creates a new, empty {@code ListMultimap} with the default initial capacities that uses a linked map internally.
	 */
	public static <K, V> ListMultimap<K, V> newLinkedHashListMultimap() {
		return Multimaps.newListMultimap(Maps.<K, Collection<V>> newLinkedHashMap(), new Supplier<List<V>>() {
			@Override
			public List<V> get() {
				return Lists.newArrayList();
			}
		});
	}

	/**
	 * Constructs an empty {@code ListMultimap} with enough capacity to hold the specified numbers of keys and values
	 * without resizing. It uses a linked map internally.
	 * 
	 * @param expectedKeys
	 *            the expected number of distinct keys
	 * @param expectedValuesPerKey
	 *            the expected average number of values per key
	 * @throws IllegalArgumentException
	 *             if {@code expectedKeys} or {@code expectedValuesPerKey} is negative
	 */
	public static <K, V> ListMultimap<K, V> newLinkedHashListMultimap(int expectedKeys, final int expectedValuesPerKey) {
		return Multimaps.newListMultimap(new LinkedHashMap<K, Collection<V>>(expectedKeys), new Supplier<List<V>>() {
			@Override
			public List<V> get() {
				return Lists.newArrayListWithCapacity(expectedValuesPerKey);
			}
		});
	}

	/**
	 * Constructs an {@code ArrayListMultimap} with the same mappings as the specified multimap. It uses a linked map
	 * internally..
	 * 
	 * @param multimap
	 *            the multimap whose contents are copied to this multimap
	 */
	public static <K, V> ListMultimap<K, V> newLinkedHashListMultimap(Multimap<K, V> multimap) {
		int keySetSize = multimap.keySet().size();
		int expectedKeys = Math.max(keySetSize, 2);
		ListMultimap<K, V> result = newLinkedHashListMultimap(expectedKeys,	Math.max(3, multimap.size() / expectedKeys));
		result.putAll(multimap);
		return result;
	}

}
