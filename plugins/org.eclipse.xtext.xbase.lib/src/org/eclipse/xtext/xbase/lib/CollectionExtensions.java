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

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class CollectionExtensions {

	/**
	 * operator mapping for {@link Collection#add(Object)} to +=
	 */
	public static <E> boolean operator_add(Collection<? super E> a, E b) {
		return a.add(b);
	}
	
	/**
	 * operator mapping for {@link Collection#addAll(Collection)} to +=
	 */
	public static <E> boolean operator_add(Collection<? super E> a, Collection<? extends E> b) {
		return a.addAll(b);
	}
	
	public static <T> List<T> unmodifiableView(List<? extends T> list) {
		return Collections.unmodifiableList(list);
	}
	
	public static <T> Collection<T> unmodifiableView(Collection<? extends T> collection) {
		return Collections.unmodifiableCollection(collection);
	}
	
	public static <T> Set<T> unmodifiableView(Set<? extends T> set) {
		return Collections.unmodifiableSet(set);
	}
	
	public static <T> SortedSet<T> unmodifiableView(SortedSet<T> set) {
		return Collections.unmodifiableSortedSet(set);
	}
	
	public static <K, V> Map<K, V> unmodifiableView(Map<? extends K, ? extends V> map) {
		return Collections.unmodifiableMap(map);
	}
	
	public static <K, V> SortedMap<K, V> unmodifiableView(SortedMap<K, ? extends V> map) {
		return Collections.unmodifiableSortedMap(map);
	}
	
	public static <T> List<T> immutableCopy(List<? extends T> list) {
		return ImmutableList.copyOf(list);
	}
	
	public static <T> Set<T> immutableCopy(Set<? extends T> set) {
		return ImmutableSet.copyOf(set);
	}
	
	public static <T> SortedSet<T> immutableCopy(SortedSet<T> set) {
		return ImmutableSortedSet.copyOfSorted(set);
	}
	
	public static <K, V> Map<K, V> immutableCopy(Map<? extends K, ? extends V> map) {
		return ImmutableMap.copyOf(map);
	}
	
	public static <K, V> SortedMap<K, V> immutableCopy(SortedMap<K, ? extends V> map) {
		return ImmutableSortedMap.copyOfSorted(map);
	}
	
	public static <T> boolean addAll(Collection<? super T> collection, T... elements) {
		return collection.addAll(Arrays.asList(elements));
	}
	
}
