/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

/**
 * Provides {@link #newLinkedHashMapWithExpectedSize(int)}. Everything else should be obtained from {@link Maps}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Stephane Galland - Add {@link #union(Map, Map)}
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

	/**
	 * Merge the given maps.
	 *
	 * The replied map is a view on the given two maps.
	 * If a key exists in the two maps, the replied value is the value of the right operand.
	 * 
	 * The replied map is unmodifiable.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the left map.
	 * @param right - the right map.
	 * @return a map with the merged contents from the two maps.
	 */
	public static <K, V> Map<K, V> union(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
		return new MergingMap<K, V>(left, right);
	}
	
	/**
	 * @author Stephane Galland - Initial contribution and API
	 */
	private static class MergingMap<K, V> implements Map<K, V> {

		private final Map<? extends K, ? extends V> left;
		private final Map<? extends K, ? extends V> filteredLeft;
		private final Map<? extends K, ? extends V> right;

		/**
		 * @param left - the left operand to merge.
		 * @param right - the right operand to merge.
		 */
		public MergingMap(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
			this.left = left;
			this.right = right;
			this.filteredLeft = Maps.filterKeys(this.left, new Predicate<K>() {
				@SuppressWarnings("synthetic-access")
				public boolean apply(K input) {
					return !MergingMap.this.right.containsKey(input);
				}
				
			});
		}

		public int size() {
			return this.right.size() + this.filteredLeft.size();
		}

		public boolean isEmpty() {
			return this.right.isEmpty() && this.left.isEmpty();
		}

		public boolean containsKey(Object key) {
			return this.right.containsKey(key) || this.left.containsKey(key);
		}

		public boolean containsValue(Object value) {
			if (this.right.containsValue(value)) {
				return true;
			}
			return this.filteredLeft.containsValue(value);
		}

		public V get(Object key) {
			if (this.right.containsKey(key)) {
				return this.right.get(key);
			}
			return this.left.get(key);
		}

		public V put(K key, V value) {
			throw new UnsupportedOperationException();
		}

		public V remove(Object key) {
			throw new UnsupportedOperationException();
		}

		public void putAll(Map<? extends K, ? extends V> m) {
			throw new UnsupportedOperationException();
		}

		public void clear() {
			throw new UnsupportedOperationException();
		}

		public Set<K> keySet() {
			return Sets.union(this.right.keySet(), this.filteredLeft.keySet());
		}

		public Collection<V> values() {
			return new MergingCollection();
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Set<Entry<K, V>> entrySet() {
			Set ks1 = this.right.entrySet();
			Set ks2 = this.filteredLeft.entrySet();
			return Sets.union(ks1, ks2);
		}

		/**
		 * @author Stephane Galland - Initial contribution and API
		 */
		@SuppressWarnings("synthetic-access")
		private class MergingCollection implements Collection<V> {

			public MergingCollection() {
				//
			}

			public int size() {
				return MergingMap.this.size();
			}

			public boolean isEmpty() {
				return MergingMap.this.isEmpty();
			}

			public boolean contains(Object o) {
				return MergingMap.this.containsValue(o);
			}

			public Iterator<V> iterator() {
				return Iterators.concat(
						MergingMap.this.right.values().iterator(),
						MergingMap.this.filteredLeft.values().iterator());
			}

			public Object[] toArray() {
				Object[] tab = new Object[MergingMap.this.size()];
				Iterator<?> iterator = iterator();
				for(int i = 0; i < tab.length; ++i) {
					tab[i] = iterator.next();
				}
				return tab;
			}

			@SuppressWarnings("unchecked")
			public <T> T[] toArray(T[] a) {
				T[] tab = a;
				int size = MergingMap.this.size();
				if (tab == null || tab.length < size) {
					tab = (T[])Array.newInstance(Object.class, size);
				}
				Iterator<?> iterator = iterator();
				for(int i = 0; i < tab.length; ++i) {
					tab[i] = (T)iterator.next();
				}
				return tab;
			}

			public boolean containsAll(Collection<?> c) {
				for(Object o : c) {
					if (!MergingMap.this.containsValue(o)) {
						return false;
					}
				}
				return true;
			}

			public boolean add(V e) {
				throw new UnsupportedOperationException();
			}

			public boolean remove(Object o) {
				throw new UnsupportedOperationException();
			}

			public boolean addAll(Collection<? extends V> c) {
				throw new UnsupportedOperationException();
			}

			public boolean removeAll(Collection<?> c) {
				throw new UnsupportedOperationException();
			}

			public boolean retainAll(Collection<?> c) {
				throw new UnsupportedOperationException();
			}

			public void clear() {
				throw new UnsupportedOperationException();
			}
			
		}

	}

}
