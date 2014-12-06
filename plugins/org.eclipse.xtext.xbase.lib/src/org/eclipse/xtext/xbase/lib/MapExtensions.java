/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This is an extension library for {@link Map maps}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Stephane Galland - Add operator definitions.
 */
@GwtCompatible public class MapExtensions {

	/**
	 * Applies the given {@code procedure} for each {@link java.util.Map.Entry key value pair} of the given {@code map}. 
	 * 
	 * @param map
	 *            the map. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 */
	public static <K, V> void forEach(Map<K, V> map, Procedure2<? super K, ? super V> procedure) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		for (Map.Entry<K, V> entry : map.entrySet()) {
			procedure.apply(entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * Applies the given {@code procedure} for each {@link java.util.Map.Entry key value pair} of the given {@code map}. 
	 * The procedure takes the key, the value and a loop counter. If the counter would overflow, {@link Integer#MAX_VALUE}
	 * is returned for all subsequent pairs. The first pair is at index zero.
	 * 
	 * @param map
	 *            the map. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 */
	public static <K, V> void forEach(Map<K, V> map, Procedure3<? super K, ? super V, ? super Integer> procedure) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		int i = 0;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			procedure.apply(entry.getKey(), entry.getValue(), i);
			if (i != Integer.MAX_VALUE)
				i++;
		}
	}
	
	/**
	 * <p>
	 * Returns a filtered live view on top of the original map. Changes to one affect the other.
	 * </p>
	 * 
	 * <p>
	 * The mapping is done lazily. That is, subsequent access of the values in the map will repeatedly apply the
	 * transformation. Characteristics of the original map, such as iteration order, are left intact. Changes in the
	 * original map are reflected in the result map. The results supports removal if the original map supports removal.
	 * </p>
	 * 
	 * @param original
	 *            the original map. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return a filtered view on top of the original map. Never <code>null</code>.
	 */
	public static <K, V> Map<K, V> filter(Map<K, V> original, final Function2<? super K, ? super V, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		return Maps.filterEntries(original, new Predicate<Map.Entry<K, V>>() {
			public boolean apply(Map.Entry<K, V> input) {
				Boolean result = predicate.apply(input.getKey(), input.getValue());
				return result.booleanValue();
			}
		});
	}
	
	/**
	 * <p>Returns a map that performs the given {@code transformation} for each value of {@code original} when requested.</p>
	 * 
	 * <p>The mapping is done lazily. That is, subsequent access of the values in the map will repeatedly apply the
	 * transformation. Characteristics of the original map, such as iteration order, are left intact. Changes in the
	 * original map are reflected in the result map. The results supports removal if the original map supports removal.</p>
	 * 
	 * @param original
	 *            the original map. May not be <code>null</code>.
	 * @param transformation
	 *            the transformation. May not be <code>null</code>.
	 * @return a map with equal keys but transformed values. Never <code>null</code>.
	 * @since 2.4
	 */
	public static <K, V1, V2> Map<K, V2> mapValues(Map<K, V1> original, Function1<? super V1, ? extends V2> transformation) {
		return Maps.transformValues(original, new FunctionDelegate<V1, V2>(transformation));
	}
	
	/**
	 * Add the given pair into the map.
	 *
	 * If the pair key already exists in the map, its value is replaced
	 * by the value in the pair, and the old value in the map is returned.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param map
	 * 				the map to update.
	 * @param entry
	 * 				the entry (key, value) to add into the map.
	 * @return the value previously associated to the key, or <code>null</code>
	 * if the key was not present in the map before the addition.
	 * @see Map#put(Object, Object)
	 * @since 2.8
	 */
	@Inline(value = "$1.put($2.getKey(), $2.getValue())")
	public static <K, V> V operator_add(Map<K, V> map, Pair<? extends K, ? extends V> entry) {
		return map.put(entry.getKey(), entry.getValue());
	}

	/**
	 * Add the given entries of the input map into the output map.
	 *
	 * If a key in the inputMap already exists in the outputMap, its value is
	 * replaced in the outputMap by the value from the inputMap.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param outputMap
	 * 					the map to update.
	 * @param inputMap
	 * 					the entries to add.
	 * @since 2.8
	 * @see Map#putAll(Map)
	 */
	@Inline(value = "$1.putAll($2)")
	public static <K, V> void operator_add(Map<K, V> outputMap, Map<? extends K, ? extends V> inputMap) {
		outputMap.putAll(inputMap);
	}

	/**
	 * Add the given pair to a given map for obtaining a new map.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * Even if the key of the right operand exists in the left operand, the value in the right operand is preferred.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param left
	 * 				the map to consider.
	 * @param right
	 * 				the entry (key, value) to add into the map.
	 * @return a map view to the content of the map and with the given entry.
	 * @since 2.8
	 * @see #union(Map, Map)
	 */
	@Pure
	@Inline(value = "MapExtensions.union($1, Collections.singletonMap($2.getKey(), $2.getValue()))",
			imported = { MapExtensions.class, Collections.class })
	public static <K, V> Map<K, V> operator_plus(Map<? extends K, ? extends V> left, final Pair<? extends K, ? extends V> right) {
		return union(left, Collections.singletonMap(right.getKey(), right.getValue()));
	}

	/**
	 * Merge the two maps.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * If a key exists in the left and right operands, the value in the right operand is preferred.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param left
	 * 				the left map.
	 * @param right
	 * 				the right map.
	 * @return a map view to the merged contents from the two maps.
	 * @since 2.8
	 * @see #union(Map, Map)
	 */
	@Pure
	@Inline(value = "MapExtensions.union($1, $2)")
	public static <K, V> Map<K, V> operator_plus(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
		return union(left, right);
	}

	/**
	 * Remove a key from the given map.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
					type of the map values.
	 * @param map
	 * 				the map to update.
	 * @param key
	 * 				the key to remove.
	 * @return the removed value, or <code>null</code> if the key was not
	 * present in the map.
	 * @since 2.8
	 * @see Map#remove(Object)
	 */
	@Inline(value = "$1.remove($2)")
	public static <K, V> V operator_remove(Map<K, V> map, K key) {
		return map.remove(key);
	}

	/**
	 * Remove pairs with the given keys from the map.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param map
	 * 				the map to update.
	 * @param keysToRemove
	 * 				the keys of the pairs to remove.
	 * @since 2.8
	 * @see Map#remove(Object)
	 */
	public static <K, V> void operator_remove(Map<K, V> map, Iterable<?> keysToRemove) {
		for (Object key : keysToRemove) {
			map.remove(key);
		}
	}

	/**
	 * Replies the elements of the given map except the pair with the given key.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param map
	 * 				the map to update.
	 * @param key
	 * 				the key to remove.
	 * @return the map with the content of the map except the key.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, final K key) {
		return Maps.filterKeys(map, new Predicate<K>() {
			public boolean apply(K input) {
				return !Objects.equal(input, key);
			}
		});
	}

	/**
	 * Replies the elements of the left map without the pairs in the right map.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param left
	 * 				the map to update.
	 * @param right
	 * 				the pairs to remove.
	 * @return the map with the content of the left map except the pairs of the right map.
	 * @since 2.8
	 */
	@Pure
	@Inline(value = "MapExtensions.operator_minus(left, right.keySet())", imported = MapExtensions.class)
	public static <K, V> Map<K, V> operator_minus(Map<K, V> left, Map<?, ?> right) {
		return operator_minus(left, right.keySet());
	}

	/**
	 * Replies the elements of the given map except the pairs with the given keys.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param map
	 * 				the map to update.
	 * @param keys
	 * 				the keys of the pairs to remove.
	 * @return the map with the content of the map except the pairs.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, final Iterable<?> keys) {
		return Maps.filterKeys(map, new Predicate<K>() {
			public boolean apply(K input) {
				return !Iterables.contains(keys, input);
			}
		});
	}

	/**
	 * Merge the given maps.
	 *
	 * The replied map is a view on the given two maps.
	 * If a key exists in the two maps, the replied value is the value of the right operand.
	 * 
	 * The replied map is unmodifiable.
	 *
	 * @param <K>
	 * 				type of the map keys.
	 * @param <V>
	 * 				type of the map values.
	 * @param left
	 * 				the left map.
	 * @param right
	 * 				the right map.
	 * @return a map with the merged contents from the two maps.
	 * @since 2.8
	 */
	public static <K, V> Map<K, V> union(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
		return new MergingMap<K, V>(left, right);
	}
	
	/**
	 * Create a map which merges two other maps.
	 *
	 * If a key exists in the two merged maps, the value in the "right" map is preferred.
	 *
	 * @author Stephane Galland - Initial contribution and API
	 * @since 2.8
	 */
	private static class MergingMap<K, V> implements Map<K, V> {

		private final Map<? extends K, ? extends V> left;
		private final Map<? extends K, ? extends V> filteredLeft;
		private final Map<? extends K, ? extends V> right;
		
		private Set<Entry<K, V>> entriesBuffer;
		private Set<K> keySetBuffer;
		private Collection<V> valuesBuffer;

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
			if (this.keySetBuffer == null) {
				this.keySetBuffer = Sets.union(this.right.keySet(), this.filteredLeft.keySet());
			}
			return this.keySetBuffer;
		}

		public Collection<V> values() {
			if (this.valuesBuffer == null) {
				this.valuesBuffer = new MergingCollection();
			}
			return this.valuesBuffer;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Set<Entry<K, V>> entrySet() {
			if (this.entriesBuffer == null) {
				Set ks1 = this.right.entrySet();
				Set ks2 = this.filteredLeft.entrySet();
				this.entriesBuffer = Sets.union(ks1, ks2);
			}
			return this.entriesBuffer;
		}

		/**
		 * @author Stephane Galland - Initial contribution and API
		 * @since 2.8
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
