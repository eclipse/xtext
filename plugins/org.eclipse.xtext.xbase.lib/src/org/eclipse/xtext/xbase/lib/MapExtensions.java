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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

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
	
	private static <K, V> Map<K, V> newMapInstance(Map<K, V> oldMap) {
		if (oldMap instanceof TreeMap<?, ?>) {
			Comparator<? super K> cmp = ((TreeMap<K, V>) oldMap).comparator();
			if (cmp != null) {
				return Maps.newTreeMap(cmp);
			}
			return (Map<K, V>) Maps.newTreeMap();
		}
		if (oldMap instanceof LinkedHashMap<?, ?>) {
			return Maps.newLinkedHashMap();
		}
		if (oldMap instanceof ConcurrentMap<?, ?>) {
			return Maps.newConcurrentMap();
		}
		return Maps.newHashMap();
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
	@Inline(value = "($1.put($2.getKey(), $2.getValue()))", statementExpression=true)
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
	 * If the pair key already exists in the map, its value is replaced
	 * by the value in the pair, and the old value in the map is returned.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to consider.
	 * @param entry - the entry (key, value) to add into the map.
	 * @return a map with the content of the map and with the given entry.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_plus(Map<K, V> map, Pair<? extends K, ? extends V> entry) {
		Map<K, V> newMap = newMapInstance(map);
		newMap.putAll(map);
		newMap.put(entry.getKey(), entry.getValue());
		return newMap;
	}

	/** Add the given pair to a given map for obtaining a new map.
	 *
	 * If the pair key already exists in the map, its value is replaced
	 * by the value in the pair, and the old value in the map is returned.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param entry - the entry (key, value) to add into the map.
	 * @param map - the map to consider.
	 * @return a map with the content of the map and with the given entry.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_plus(Pair<? extends K, ? extends V> entry, Map<K, V> map) {
		Map<K, V> newMap = newMapInstance(map);
		newMap.putAll(map);
		newMap.put(entry.getKey(), entry.getValue());
		return newMap;
	}

	/** Merge the given maps.
	 *
	 * If a key in the map2 already exists in the map2, its value is
	 * replaced in the map1 by the value from the map2.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map1 - the first map.
	 * @param map2 - the second map.
	 * @return a map with the merged contents from the two maps.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_plus(Map<K, V> map1, Map<? extends K, ? extends V> map2) {
		Map<K, V> newMap = newMapInstance(map1);
		newMap.putAll(map1);
		newMap.putAll(map2);
		return newMap;
	}

	/** Remove a pair from the given map.
	 *
	 * The pair is removed only if the key and the value are associated in the map.
	 * If the key exists in the map, but it is not associated with the given value,
	 * then the map stays unchanged.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param pair - the pair to remove.
	 * @return the map.
	 * @since 2.8
	 */
	public static <K, V> Map<K, V> operator_remove(Map<K, V> map, Pair<? super K, ? super V> pair) {
		V value = map.get(pair.getKey());
		if (Objects.equal(value, pair.getValue())) {
			map.remove(pair.getKey());
		}
		return map;
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
	@Inline(value="($1.remove($2))", statementExpression=true)
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
		for (K key : keysToRemove) {
			map.remove(key);
		}
		return map;
	}

	/** Create a copy of the given map without the pair with given key.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param key - the key to remove.
	 * @return the map with the content of the map except the key.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, K key) {
		Map<K, V> newMap = newMapInstance(map);
		for (Entry<K, V> pair : map.entrySet()) {
			if (!Objects.equal(key, pair.getKey())) {
				newMap.put(pair.getKey(), pair.getValue());
			}
		}
		return newMap;
	}
	
	/** Create a copy of the given map without the given pair.
	 *
	 * The pair is removed only if the key and the value are associated in the map.
	 * If the key exists in the map, but it is not associated with the given value,
	 * then the map stays unchanged.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param pair - the pair to remove.
	 * @return the map with the content of the map except the pair.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, Pair<? super K, ? super V> pair) {
		Map<K, V> newMap = newMapInstance(map);
		for (Entry<K, V> opair : map.entrySet()) {
			if (!Objects.equal(pair.getKey(), opair.getKey())
				|| !Objects.equal(pair.getValue(), opair.getValue())) {
				newMap.put(opair.getKey(), opair.getValue());
			}
		}
		return newMap;
	}

	/** Create a copy of the given map without the given pairs.
	 *
	 * The pair is removed only if the key and the value are associated in the map.
	 * If the key exists in the map, but it is not associated with the given value,
	 * then the map stays unchanged.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map1 - the map to update.
	 * @param map2 - the pairs to remove.
	 * @return the map with the content of the map except the pairs.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map1, Map<? super K, ? super V> map2) {
		Map<K, V> newMap = newMapInstance(map1);
		for (Entry<K, V> opair : map1.entrySet()) {
			V value = map2.get(opair.getKey());
			if (!Objects.equal(value, opair.getValue())) {
				newMap.put(opair.getKey(), opair.getValue());
			}
		}
		return newMap;
	}

	/** Create a copy of the given map without the given pairs.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param pairs - the pairs to remove.
	 * @return the map with the content of the map except the pairs.
	 * @since 2.8
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, Iterable<? super K> pairs) {
		Map<K, V> newMap = newMapInstance(map);
		Set<K> keys = null;
		for (Entry<K, V> opair : map.entrySet()) {
			if (keys == null) {
				boolean isFound = false;
				for (K key : pairs) {
					keys.add(key);
					if (Objects.equal(key, opair.getKey())) {
						isFound = true;
					}
				}
				if (!isFound) {
					newMap.put(opair.getKey(), opair.getValue());
				}
			} else if (!keys.contains(opair.getKey())) {
				newMap.put(opair.getKey(), opair.getValue());
			}
		}
		return newMap;
	}

}
