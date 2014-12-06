/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
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
	
	/** Add the given pair into the map.
	 *
	 * If the pair key already exists in the map, its value is replaced
	 * by the value in the pair, and the old value in the map is returned.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param entry - the entry (key, value) to add into the map.
	 * @return the value previously associated to the key, or <code>null</code>
	 * if the key was not present in the map before the addition.
	 * @since 2.8
	 */
	@Inline(value = "$1.put($2.getKey(), $2.getValue())", statementExpression=true)
	public static <K, V> V operator_add(Map<K, V> map, Pair<? extends K, ? extends V> entry) {
		return map.put(entry.getKey(), entry.getValue());
	}

	/** Add the given entries of the input map into the output map.
	 *
	 * If a key in the inputMap already exists in the outputMap, its value is
	 * replaced in the outputMap by the value from the inputMap.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param outputMap - the map to update.
	 * @param inputMap - the entries to add.
	 * @return the outputMap
	 * @since 2.8
	 */
	public static <K, V> Map<K, V> operator_add(Map<K, V> outputMap, Map<? extends K, ? extends V> inputMap) {
		outputMap.putAll(inputMap);
		return outputMap;
	}

	/** Add the given pair to a given map for obtaining a new map.
	 *
	 * If the pair key already exists in the map, the exception
	 * {@link IllegalArgumentException} is thrown.
	 * 
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the map to consider.
	 * @param right - the entry (key, value) to add into the map.
	 * @return an immutable map with the content of the map and with the given entry.
	 * @since 2.8
	 * @throws IllegalArgumentException - when the right operand key exists in the left operand.
	 */
	@Pure
	@Inline(value = "(ImmutableMap.<K,V>builder().putAll(left).put(right.getKey(), right.getValue()).build())",
			imported=ImmutableMap.class)
	public static <K, V> Map<K, V> operator_plus(Map<K, V> left, Pair<? extends K, ? extends V> right) {
		return ImmutableMap.<K,V>builder().putAll(left).put(right.getKey(), right.getValue()).build();
	}

	/** Merge the given maps.
	 *
	 * Builder don't accept duplicate keys (throws {@link IllegalArgumentException} if duplicate keys were added).
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the left map.
	 * @param right - the right map.
	 * @return a map with the merged contents from the two maps.
	 * @since 2.8
	 * @throws IllegalArgumentException - when a right operand key exists in the left operand.
	 */
	@Pure
	@Inline(value = "(ImmutableMap.<K,V>builder().putAll(left).putAll(right).build())", imported=ImmutableMap.class)
	public static <K, V> Map<K, V> operator_plus(Map<K, V> left, Map<? extends K, ? extends V> right) {
		return ImmutableMap.<K,V>builder().putAll(left).putAll(right).build();
	}

	/** Remove a key from the given map.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param key - the key to remove.
	 * @return the removed value, or <code>null</code> if the key was not
	 * present in the map.
	 * @since 2.8
	 */
	@Inline(value="$1.remove($2)", statementExpression=true)
	public static <K, V> V operator_remove(Map<K, V> map, K key) {
		return map.remove(key);
	}

	/** Remove pairs from the given map.
	 *
	 * The pair is removed only if the key and the value are associated in the map.
	 * If the key exists in the map, but it is not associated with the given value,
	 * then the map stays unchanged.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param pairsToRemove - the pairs to remove.
	 * @return the map.
	 * @since 2.8
	 */
	public static <K, V> Map<K, V> operator_remove(Map<K, V> map, Map<? super K, ? super V> pairsToRemove) {
		for (Entry<? super K, ? super V> pair : pairsToRemove.entrySet()) {
			V value = map.get(pair.getKey());
			if (Objects.equal(value, pair.getValue())) {
				map.remove(pair.getKey());
			}
		}
		return map;
	}

	/** Remove pairs with the given keys from the map.
	 *
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param keysToRemove - the keys of the pairs to remove.
	 * @return the map.
	 * @since 2.8
	 */
	public static <K, V> Map<K, V> operator_remove(Map<K, V> map, Iterable<? super K> keysToRemove) {
		for (Object key : keysToRemove) {
			map.remove(key);
		}
		return map;
	}

	/** Replies the elements of the given map except the pair with the given key.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 * 
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param key - the key to remove.
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
	
	/** Replies the elements of the left map without the pairs in the right map.
	 *
	 * The difference is an immutable
	 * snapshot of the state of the maps at the time this method is called. It
	 * will never change, even if the maps change at a later time.
	 *
	 * Since this method uses {@code HashMap} instances internally, the keys of
	 * the supplied maps must be well-behaved with respect to
	 * {@link Object#equals} and {@link Object#hashCode}.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the map to update.
	 * @param right - the pairs to remove.
	 * @return the map with the content of the left map except the pairs of the right map.
	 * @since 2.8
	 */
	@Pure
	@Inline(value = "(Maps.difference($1, $2).entriesOnlyOnLeft())", imported=Maps.class)
	public static <K, V> Map<K, V> operator_minus(Map<K, V> left, Map<? extends K, ? extends V> right) {
		return Maps.difference(left, right).entriesOnlyOnLeft();
	}

	/** Replies the elements of the given map except the pairs with the given keys.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param keys - the keys of the pairs to remove.
	 * @return the map with the content of the map except the pairs.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, final Iterable<? super K> keys) {
		return Maps.filterKeys(map, new Predicate<K>() {
			private Set<Object> keySet = Sets.newHashSet(keys);
			public boolean apply(K input) {
				return !this.keySet.contains(input);
			}
		});
	}

}
