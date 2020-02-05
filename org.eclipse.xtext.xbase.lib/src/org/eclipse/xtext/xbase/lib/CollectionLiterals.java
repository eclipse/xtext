/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

/**
 * This is an extension library for {@link java.util.Collection collections}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@GwtCompatible public class CollectionLiterals {

	/**
	 * Returns the empty, immutable list.
	 * 
	 * @return an empty, immutable list.
	 * @see Collections#emptyList()
	 */
	@Pure
	public static <T> List<T> emptyList() {
		return Collections.emptyList();
	}

	/**
	 * Returns the empty, immutable set.
	 * 
	 * @return an empty, immutable set.
	 * @see Collections#emptySet()
	 */
	@Pure
	public static <T> Set<T> emptySet() {
		return Collections.emptySet();
	}

	/**
	 * Returns the empty, immutable map.
	 * 
	 * @return an empty, immutable map.
	 * @see Collections#emptyMap()
	 */
	@Pure
	public static <K, V> Map<K, V> emptyMap() {
		return Collections.emptyMap();
	}

	/**
	 * Returns an immutable list containing the given elements, in order.
	 * 
	 * @param elements
	 *            the elements that should be contained in the list. May not be <code>null</code> or contain any
	 *            <code>null</code> values.
	 * @return an immutable list containing the given elements.
	 * @throws NullPointerException
	 *             if {@code elements} or any of items in {@code elements} is <code>null</code>
	 */
	@Pure
	@SafeVarargs
	public static <T> List<T> newImmutableList(T... elements) {
		return ImmutableList.copyOf(elements);
	}

	/**
	 * Returns an immutable set containing the given elements. Repeated occurrences of an element (according to
	 * {@link Object#equals}) after the first are ignored
	 * 
	 * @param elements
	 *            the elements that should be contained in the set. May not be <code>null</code> or contain any
	 *            <code>null</code> values.
	 * @return an immutable set containing the given elements.
	 * @throws NullPointerException
	 *             if {@code elements} or any of items in {@code elements} is <code>null</code>
	 */
	@Pure
	@SafeVarargs
	public static <T> Set<T> newImmutableSet(T... elements) {
		return ImmutableSet.copyOf(elements);
	}

	/**
	 * Returns an immutable map containing the given entries. Repeated occurrences of a keys will cause an
	 * {@link IllegalArgumentException}.
	 * 
	 * @param entries
	 *            the entries that should be contained in the map. May not be <code>null</code> and may
	 *            not contain any <code>null</code> keys or values.
	 * @return an immutable map containing the given entries.
	 * @throws NullPointerException
	 *             if {@code entries} or any key or value in {@code entries} is <code>null</code>
	 * @throws IllegalArgumentException
	 *             if duplicate keys are contained in {@code entries}.
	 */
	@Pure
	@SafeVarargs
	public static <K, V> Map<K, V> newImmutableMap(Pair<? extends K, ? extends V>... entries) {
		if (entries.length == 0)
			return emptyMap();
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		for (Pair<? extends K, ? extends V> entry : entries) {
			builder.put(entry.getKey(), entry.getValue());
		}
		return builder.build();
	}

	/**
	 * Creates an empty mutable {@link ArrayList} instance.
	 * 
	 * @return a new {@link ArrayList}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <T> ArrayList<T> newArrayList() {
		return new ArrayList<T>();
	}

	/**
	 * Creates a mutable {@link ArrayList} instance containing the given initial elements.
	 * 
	 * @param initial
	 *            the initial elements that the list should contain, in order. May not be <code>null</code> but may
	 *            contain <code>null</code> values.
	 * @return a new {@link ArrayList} containing those elements
	 */
	@SafeVarargs
	@Pure
	public static <T> ArrayList<T> newArrayList(T... initial) {
		if (initial.length > 0)
			return Lists.newArrayList(initial);
		return newArrayList();
	}

	/**
	 * Creates an empty mutable {@link LinkedList} instance.
	 * 
	 * @return a new {@link LinkedList}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <T> LinkedList<T> newLinkedList() {
		return new LinkedList<T>();
	}

	/**
	 * Creates a mutable {@link LinkedList} instance containing the given initial elements.
	 * 
	 * @param initial
	 *            the initial elements that the list should contain, in order. May not be <code>null</code> but may
	 *            contain <code>null</code> values.
	 * @return a new {@link LinkedList} containing those elements
	 */
	@SafeVarargs
	@Pure
	public static <T> LinkedList<T> newLinkedList(T... initial) {
		if (initial.length > 0)
			return Lists.newLinkedList(Arrays.asList(initial));
		return newLinkedList();
	}

	/**
	 * Creates an empty mutable {@link HashSet} instance.
	 * 
	 * @return a new {@link HashSet}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <T> HashSet<T> newHashSet() {
		return new HashSet<T>();
	}

	/**
	 * Creates a mutable {@link HashSet} instance containing the given initial elements.
	 * 
	 * @param initial
	 *            the initial elements that the set should contain, in order. May not be <code>null</code> but may
	 *            contain <code>null</code> values.
	 * @return a new {@link HashSet} containing those elements
	 */
	@SafeVarargs
	@Pure
	public static <T> HashSet<T> newHashSet(T... initial) {
		if (initial.length > 0)
			return Sets.newHashSet(initial);
		return newHashSet();
	}

	/**
	 * Creates an empty mutable {@link LinkedHashSet} instance.
	 * 
	 * @return a new {@link LinkedHashSet}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <T> LinkedHashSet<T> newLinkedHashSet() {
		return new LinkedHashSet<T>();
	}

	/**
	 * Creates a mutable {@link LinkedHashSet} instance containing the given initial elements.
	 * 
	 * @param initial
	 *            the initial elements that the set should contain, in order. May not be <code>null</code> but may
	 *            contain <code>null</code> values.
	 * @return a new {@link LinkedHashSet} containing those elements
	 */
	@SafeVarargs
	@Pure
	public static <T> LinkedHashSet<T> newLinkedHashSet(T... initial) {
		if (initial.length > 0)
			return Sets.newLinkedHashSet(Arrays.asList(initial));
		return newLinkedHashSet();
	}

	/**
	 * Creates an empty mutable {@link TreeSet} instance.
	 * 
	 * @param comparator
	 *            the comparator that should be used. May be <code>null</code> which indicates that the natural ordering
	 *            of the items should be used.
	 * @return a new {@link TreeSet}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <T> TreeSet<T> newTreeSet(Comparator<? super T> comparator) {
		return new TreeSet<T>(comparator);
	}

	/**
	 * Creates a mutable {@link TreeSet} instance containing the given initial elements.
	 * 
	 * @param initial
	 *            the initial elements that the set should contain, in order. May not be <code>null</code> but may
	 *            contain <code>null</code> values.
	 * @param comparator
	 *            the comparator that should be used. May be <code>null</code> which indicates that the natural ordering
	 *            of the items should be used.
	 * @return a new {@link TreeSet} containing those elements
	 */
	@SafeVarargs
	@Pure
	public static <T> TreeSet<T> newTreeSet(Comparator<? super T> comparator, T... initial) {
		TreeSet<T> result = new TreeSet<T>(comparator);
		if (initial.length > 0)
			result.addAll(Arrays.asList(initial));
		return result;
	}

	/**
	 * Creates an empty mutable {@link HashMap} instance.
	 * 
	 * @return a new {@link HashMap}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * Creates a mutable {@link HashMap} instance containing the given initial entries. Repeated occurrences of a keys
	 * will cause an {@link IllegalArgumentException}.
	 * 
	 * @param initial
	 *            the entries that should be contained in the map. May not be <code>null</code> but may contain
	 *            <code>null</code> keys or values.
	 * @return a new {@link HashMap} containing those elements
	 * @throws IllegalArgumentException
	 *             if duplicate keys are contained the {@code initial} entries.
	 */
	@SafeVarargs
	@Pure
	public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... initial) {
		if (initial.length > 0) {
			HashMap<K, V> result = new HashMap<K, V>(capacity(initial.length));
			putAll(result, initial);
			return result;
		}
		return newHashMap();
	}

	/**
	 * Creates an empty mutable {@link LinkedHashMap} instance.
	 * 
	 * @return a new {@link LinkedHashMap}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
		return new LinkedHashMap<K, V>();
	}

	/**
	 * Creates a mutable {@link LinkedHashMap} instance containing the given initial entries. Repeated occurrences of a
	 * keys will cause an {@link IllegalArgumentException}.
	 * 
	 * @param initial
	 *            the entries that should be contained in the map. May not be <code>null</code> but may contain
	 *            <code>null</code> keys or values.
	 * @return a new {@link LinkedHashMap} containing those elements
	 * @throws IllegalArgumentException
	 *             if duplicate keys are contained the {@code initial} entries.
	 */
	@SafeVarargs
	@Pure
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Pair<? extends K, ? extends V>... initial) {
		if (initial.length > 0) {
			LinkedHashMap<K, V> result = new LinkedHashMap<K, V>(capacity(initial.length));
			putAll(result, initial);
			return result;
		}
		return newLinkedHashMap();
	}
	
	private static int capacity(int initialSize) {
		if (initialSize < 3)
			return initialSize + 1;
		else if (initialSize < Ints.MAX_POWER_OF_TWO)
			return initialSize + initialSize / 3;
		else
			return Integer.MAX_VALUE;
	}

	/**
	 * Creates an empty mutable {@link TreeMap} instance.
	 * 
	 * @param comparator
	 *            the comparator that should be used. May be <code>null</code> which indicates that the natural ordering
	 *            of the keys should be used.
	 * @return a new {@link TreeMap}
	 * 
	 * @since 2.13
	 */
	@Pure
	public static <K, V> TreeMap<K, V> newTreeMap(Comparator<? super K> comparator) {
		return new TreeMap<K, V>(comparator);
	}

	/**
	 * Creates a mutable {@link TreeMap} instance containing the given initial entries. Repeated occurrences of a keys
	 * will cause an {@link IllegalArgumentException}.
	 * 
	 * @param initial
	 *            the entries that should be contained in the map. May not be <code>null</code> but may contain
	 *            <code>null</code> keys or values.
	 * @param comparator
	 *            the comparator that should be used. May be <code>null</code> which indicates that the natural ordering
	 *            of the keys should be used.
	 * @return a new {@link TreeMap} containing those elements
	 * @throws IllegalArgumentException
	 *             if duplicate keys are contained the {@code initial} entries.
	 */
	@SafeVarargs
	@Pure
	public static <K, V> TreeMap<K, V> newTreeMap(Comparator<? super K> comparator, Pair<? extends K, ? extends V>... initial) {
		TreeMap<K, V> result = new TreeMap<K, V>(comparator);
		putAll(result, initial);
		return result;
	}

	@SafeVarargs
	private static <K, V> void putAll(Map<K, V> result, Pair<? extends K, ? extends V>... entries) {
		for (Pair<? extends K, ? extends V> entry : entries) {
			if (result.containsKey(entry.getKey()))
				throw new IllegalArgumentException("duplicate key: " + entry.getKey());
			result.put(entry.getKey(), entry.getValue());
		}
	}

}
