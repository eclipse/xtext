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

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;

import static com.google.common.collect.Sets.*;

/**
 * This is an extension library for {@link Collection collections}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@GwtCompatible public class CollectionExtensions {

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
	@Inline(value="$1.add($2)")
	public static <E> boolean operator_add(Collection<? super E> collection, E value) {
		return collection.add(value);
	}

	/**
	 * The operator mapping from {@code +=} to {@link #addAll(Collection, Iterable)}. Returns <code>true</code> if the
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
	@Inline(value="$3.$4addAll($1, $2)", imported=Iterables.class)
	public static <E> boolean operator_add(Collection<E> collection, Iterable<? extends E> newElements) {
		return addAll(collection, newElements);
	}

	/**
	 * The operator mapping from {@code -=} to {@link Collection#remove(Object)}. Returns <code>true</code> if the
	 * collection changed due to this operation.
	 * 
	 * @param collection
	 *            the to-be-changed collection. May not be <code>null</code>.
	 * @param value
	 *            the value that should be removed from the collection.
	 * @return <code>true</code> if the collection changed due to this operation.
	 * @see Collection#remove(Object)
	 * @since 2.4
	 */
	@Inline(value="$1.remove($2)")
	public static <E> boolean operator_remove(Collection<? super E> collection, E value) {
		return collection.remove(value);
	}

	/**
	 * The operator mapping from {@code -=} to {@link #removeAll(Collection, Collection)}. Returns <code>true</code> if the
	 * collection changed due to this operation.
	 * 
	 * @param collection
	 *            the to-be-changed collection. May not be <code>null</code>.
	 * @param newElements
	 *            elements to be removed from the collection. May not be <code>null</code> but may contain
	 *            <code>null</code> elements if the the target collection supports <code>null</code> elements.
	 * @return <code>true</code> if the collection changed due to this operation.
	 * @see #removeAll(Collection, Collection)
	 * @since 2.4
	 */
	@Inline(value="$3.removeAll($1, $2)", imported=Iterables.class)
	public static <E> boolean operator_remove(Collection<E> collection, Collection<? extends E> newElements) {
		return removeAll(collection, newElements);
	}

	/**
	 * Returns an unmodifiable view of the specified {@code list}.
	 * 
	 * @param list
	 *            the list for which an unmodifiable view is to be returned. May not be <code>null</code>.
	 * @return an unmodifiable view of the specified list.
	 * @see Collections#unmodifiableList(List)
	 */
	@Inline(value="$2.$3unmodifiableList($1)", imported=Collections.class)
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
	@Inline(value="$2.$3unmodifiableCollection($1)", imported=Collections.class)
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
	@Inline(value="$2.$3unmodifiableSet($1)", imported=Collections.class)
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
	@Inline(value="$2.$3unmodifiableSortedSet($1)", imported=Collections.class)
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
	@Inline(value="$2.$3unmodifiableMap($1)", imported=Collections.class)
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
	@Inline(value="$2.$3unmodifiableSortedMap($1)", imported=Collections.class)
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
	@Inline(value="$2.$3copyOf($1)", imported=ImmutableList.class)
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
	@Inline(value="$2.$3copyOf($1)", imported=ImmutableSet.class)
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
	@Inline(value="$2.$3copyOfSorted($1)", imported=ImmutableSortedSet.class)
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
	@Inline(value="$2.$3copyOf($1)", imported=ImmutableMap.class)
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
	@Inline(value="$2.$3copyOfSorted($1)", imported=ImmutableSortedMap.class)
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
	@Inline(value="$3.$4addAll($1, $2)", imported=Iterables.class)
	public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> elements) {
		return Iterables.addAll(collection, elements);
	}
	
	/**
	 * Removes all of the specified elements from the specified collection.
	 * 
	 * @param collection
	 *            the collection from which the {@code elements} are to be removed. May not be <code>null</code>.
	 * @param elements
	 *            the elements be remove from the {@code collection}. May not be <code>null</code> but may contain
	 *            <code>null</code> entries if the {@code collection} allows that.
	 * @return <code>true</code> if the collection changed as a result of the call
	 * @since 2.4
	 */
	public static <T> boolean removeAll(Collection<? super T> collection, T... elements) {
		return collection.removeAll(Arrays.asList(elements));
	}

	/**
	 * Removes all of the specified elements from the specified collection.
	 *
	 * @param collection
	 *            the collection from which the {@code elements} are to be removed. May not be <code>null</code>.
	 * @param elements
	 *            the elements to remove from the {@code collection}. May not be <code>null</code> but may contain
	 *            <code>null</code> entries if the {@code collection} allows that.
	 * @return <code>true</code> if the collection changed as a result of the call
	 * @since 2.4
	 */
	@Inline(value="$3.$4removeAll($1, $2)", imported=Iterables.class)
	public static <T> boolean removeAll(Collection<T> collection, Collection<? extends T> elements) {
		return Iterables.removeAll(collection, elements);
	}

	/**
	 * Removes all of the specified elements from the specified collection.
	 * 
	 * @param collection
	 *            the collection from which the {@code elements} are to be removed. May not be <code>null</code>.
	 * @param elements
	 *            the elements to remove from the {@code collection}. May not be <code>null</code> but may contain
	 *            <code>null</code> entries if the {@code collection} allows that.
	 * @return <code>true</code> if the collection changed as a result of the call
	 * @since 2.4
	 */
	public static <T> boolean removeAll(Collection<T> collection, Iterable<? extends T> elements) {
		return Iterables.removeAll(collection, newHashSet(elements));
	}
}
