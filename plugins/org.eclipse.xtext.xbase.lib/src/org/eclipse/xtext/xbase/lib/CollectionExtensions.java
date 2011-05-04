/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;

/**
 * This is an extension library for {@link Collection collections}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class CollectionExtensions {

	/**
	 * The operator mapping from {@code +=} to {@link Collection#add(Object)}. Returns <code>true</code> if the
	 * collection changed due to this operation.
	 * 
	 * @param collection
	 *            the to-be-changed collection. May not be <code>null</code>.
	 * @param value
	 *            the value that should be added to the collection.
	 * @return <code>true</code> if the collection changed due to this operation.
	 * @see Collection#add(Object)
	 */
	public static <E> boolean operator_add(Collection<? super E> collection, E value) {
		return collection.add(value);
	}

	/**
	 * The operator mapping from {@code +=} to {@link #addAll(Collection)}. Returns <code>true</code> if the
	 * collection changed due to this operation.
	 * 
	 * @param collection
	 *            the to-be-changed collection. May not be <code>null</code>.
	 * @param newElements
	 *            elements to be inserted into the collection. May not be <code>null</code> but may contain
	 *            <code>null</code> elements if the the target collection supports <code>null</code> elements.
	 * @return <code>true</code> if the collection changed due to this operation.
	 * @see #addAll(Collection, Iterable)
	 */
	public static <E> boolean operator_add(Collection<E> collection, Iterable<? extends E> newElements) {
		return addAll(collection, newElements);
	}

	/**
	 * Returns an unmodifiable view of the specified {@code list}.
	 * 
	 * @param list
	 *            the list for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified list.
	 * @see Collections#unmodifiableList(List)
	 */
	public static <T> List<T> unmodifiableView(List<? extends T> list) {
		return Collections.unmodifiableList(list);
	}

	/**
	 * Returns an unmodifiable view of the specified {@code collection}.
	 * 
	 * @param collection
	 *            the collection for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified collection.
	 * @see Collections#unmodifiableCollection(Collection)
	 */
	public static <T> Collection<T> unmodifiableView(Collection<? extends T> collection) {
		return Collections.unmodifiableCollection(collection);
	}

	/**
	 * Returns an unmodifiable view of the specified {@code set}.
	 * 
	 * @param set
	 *            the set for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified set.
	 * @see Collections#unmodifiableSet(Set)
	 */
	public static <T> Set<T> unmodifiableView(Set<? extends T> set) {
		return Collections.unmodifiableSet(set);
	}

	/**
	 * Returns an unmodifiable view of the specified sorted {@code set}.
	 * 
	 * @param set
	 *            the sorted set for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified sorted set.
	 * @see Collections#unmodifiableSortedSet(SortedSet)
	 */
	public static <T> SortedSet<T> unmodifiableView(SortedSet<T> set) {
		return Collections.unmodifiableSortedSet(set);
	}

	/**
	 * Returns an unmodifiable view of the specified {@code map}.
	 * 
	 * @param map
	 *            the map for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified map.
	 * @see Collections#unmodifiableMap(Map)
	 */
	public static <K, V> Map<K, V> unmodifiableView(Map<? extends K, ? extends V> map) {
		return Collections.unmodifiableMap(map);
	}

	/**
	 * Returns an unmodifiable view of the specified sorted {@code map}.
	 * 
	 * @param map
	 *            the sorted map for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified sorted map.
	 * @see Collections#unmodifiableSortedMap(SortedMap)
	 */
	public static <K, V> SortedMap<K, V> unmodifiableView(SortedMap<K, ? extends V> map) {
		return Collections.unmodifiableSortedMap(map);
	}

	/**
	 * Returns an immutable copy of the specified {@code list}.
	 * 
	 * @param list
	 *            the list for which an immutable copy should be created. May not be <code>null</code>.
	 * @return an immutable copy of the specified list.
	 */
	public static <T> List<T> immutableCopy(List<? extends T> list) {
		return ImmutableList.copyOf(list);
	}

	/**
	 * Returns an immutable copy of the specified {@code set}.
	 * 
	 * @param set
	 *            the set for which an immutable copy should be created. May not be <code>null</code>.
	 * @return an immutable copy of the specified set.
	 */
	public static <T> Set<T> immutableCopy(Set<? extends T> set) {
		return ImmutableSet.copyOf(set);
	}

	/**
	 * Returns an immutable copy of the specified sorted {@code set}.
	 * 
	 * @param set
	 *            the sorted set for which an immutable copy should be created. May not be <code>null</code>.
	 * @return an immutable copy of the specified sorted set.
	 */
	public static <T> SortedSet<T> immutableCopy(SortedSet<T> set) {
		return ImmutableSortedSet.copyOfSorted(set);
	}

	/**
	 * Returns an immutable copy of the specified {@code map}.
	 * 
	 * @param map
	 *            the map for which an immutable copy should be created. May not be <code>null</code>.
	 * @return an immutable copy of the specified map.
	 */
	public static <K, V> Map<K, V> immutableCopy(Map<? extends K, ? extends V> map) {
		return ImmutableMap.copyOf(map);
	}

	/**
	 * Returns an immutable copy of the specified sorted {@code map}.
	 * 
	 * @param map
	 *            the sorted map for which an immutable copy should be created. May not be <code>null</code>.
	 * @return an immutable copy of the specified sorted map.
	 */
	public static <K, V> SortedMap<K, V> immutableCopy(SortedMap<K, ? extends V> map) {
		return ImmutableSortedMap.copyOfSorted(map);
	}

	/**
	 * Adds all of the specified elements to the specified collection.
	 * 
	 * @param collection
	 *            the collection into which the {@code elements} are to be inserted. May not be <code>null</code>.
	 * @param elements
	 *            the elements to insert into the {@code collection}. May not be <code>null</code> but may contain
	 *            <code>null</code> entries if the {@code collection} allows that.
	 * @return <code>true</code> if the collection changed as a result of the call
	 */
	public static <T> boolean addAll(Collection<? super T> collection, T... elements) {
		return collection.addAll(Arrays.asList(elements));
	}

	/**
	 * Adds all of the specified elements to the specified collection.
	 * 
	 * @param collection
	 *            the collection into which the {@code elements} are to be inserted. May not be <code>null</code>.
	 * @param elements
	 *            the elements to insert into the {@code collection}. May not be <code>null</code> but may contain
	 *            <code>null</code> entries if the {@code collection} allows that.
	 * @return <code>true</code> if the collection changed as a result of the call
	 */
	public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> elements) {
		return Iterables.addAll(collection, elements);
	}
}
