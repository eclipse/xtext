/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * To Be Discussed:
 * #emptySortedSet
 * #emptySortedMap
 * #immutableSortedMap
 * #immutableSortedSet
 */
public class CollectionLiterals {

	public static final <T> List<T> emptyList() {
		return Collections.emptyList();
    }
	
	public static final <T> Set<T> emptySet() {
		return Collections.emptySet();
    }
	
	public static final <K,V> Map<K,V> emptyMap() {
		return Collections.emptyMap();
    }
	
	public static final <T> List<T> newImmutableList(T... elements) {
		return ImmutableList.of(elements);
	}
	
	public static final <T> Set<T> newImmutableSet(T... elements) {
		return ImmutableSet.of(elements);
	}
	
	public static final <K,V> Map<K,V> newImmutableMap(Pair<K, V>... entries) {
		if (entries == null || entries.length == 0)
			return emptyMap();
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		for(Pair<K, V> entry: entries) {
			builder.put(entry.getKey(), entry.getValue());
		}
		return builder.build();
	}
	
	public static final <T> ArrayList<T> newArrayList(T... initial) {
		return Lists.newArrayList(initial);
	}
	
	public static final <T> LinkedList<T> newLinkedList(T... initial) {
		if (initial != null && initial.length > 0)
			return Lists.newLinkedList(Arrays.asList(initial));
		return Lists.newLinkedList();
	}
	
	public static final <T> HashSet<T> newHashSet(T... initial) {
		return Sets.newHashSet(initial);
	}
	
	public static final <T> LinkedHashSet<T> newLinkedHashSet(T... initial) {
		if (initial != null && initial.length > 0)
			return Sets.newLinkedHashSet(Arrays.asList(initial));
		return Sets.newLinkedHashSet();
	}

	public static final <T> TreeSet<T> newTreeSet(Comparator<? super T> comparator, T... initial) {
		TreeSet<T> result = Sets.newTreeSet(comparator);
		if (initial != null && initial.length > 0)
			result.addAll(Arrays.asList(initial));
		return result;
	}
	
	public static final <K, V> HashMap<K, V> newHashMap(Pair<K, V>... initial) {
		HashMap<K, V> result = Maps.newHashMap();
		putAll(result, initial);
		return result;
	}
	
	public static final <K, V> LinkedHashMap<K, V> newLinkedHashMap(Pair<K, V>... initial) {
		LinkedHashMap<K, V> result = Maps.newLinkedHashMap();
		putAll(result, initial);
		return result;
	}
	
	public static final <K, V> TreeMap<K, V> newTreeMap(Comparator<? super K> comparator, Pair<K, V>... initial) {
		TreeMap<K, V> result = Maps.newTreeMap(comparator);
		putAll(result, initial);
		return result;
	}

	private static <K, V> void putAll(Map<K, V> result, Pair<K, V>... entries) {
		if (entries != null) {
			for(Pair<? extends K, ? extends V> entry: entries) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
	}
	
}
