/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
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
	
	/**
	 * Add the given pair into the map.
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
	 */
	@Inline(value = "$1.put($2.getKey(), $2.getValue())", statementExpression = true)
	public static <K, V> V operator_add(Map<K, V> map, Pair<? extends K, ? extends V> entry) {
		return map.put(entry.getKey(), entry.getValue());
	}

	/**
	 * Add the given entries of the input map into the output map.
	 *
	 * If a key in the inputMap already exists in the outputMap, its value is
	 * replaced in the outputMap by the value from the inputMap.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param outputMap - the map to update.
	 * @param inputMap - the entries to add.
	 */
	@Inline(value = "$1.putAll($2)", statementExpression = true)
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
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the map to consider.
	 * @param right - the entry (key, value) to add into the map.
	 * @return an immutable map with the content of the map and with the given entry.
	 * @throws IllegalArgumentException - when the right operand key exists in the left operand.
	 */
	@Pure
	@Inline(value = "Maps2.union($1, Collections.singletonMap($2.getKey(), $2.getValue()))",
			imported = { Maps2.class, Collections.class})
	public static <K, V> Map<K, V> operator_plus(Map<K, V> left, final Pair<? extends K, ? extends V> right) {
		return Maps2.union(left, Collections.singletonMap(right.getKey(), right.getValue()));
	}

	/**
	 * Merge the two maps.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * If a key exists in the left and right operands, the value in the right operand is preferred.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the left map.
	 * @param right - the right map.
	 * @return a map with the merged contents from the two maps.
	 * @throws IllegalArgumentException - when a right operand key exists in the left operand.
	 */
	@Pure
	@Inline(value = "Maps2.union($1, $2)", imported = Maps2.class)
	public static <K, V> Map<K, V> operator_plus(Map<K, V> left, Map<? extends K, ? extends V> right) {
		return Maps2.union(left, right);
	}

	/**
	 * Remove a key from the given map.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param key - the key to remove.
	 * @return the removed value, or <code>null</code> if the key was not
	 * present in the map.
	 * @since 2.8
	 */
	@Inline(value = "$1.remove($2)", statementExpression = true)
	public static <K, V> V operator_remove(Map<K, V> map, K key) {
		return map.remove(key);
	}

	/**
	 * Remove pairs with the given keys from the map.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param keysToRemove - the keys of the pairs to remove.
	 */
	public static <K, V> void operator_remove(Map<K, V> map, Iterable<? super K> keysToRemove) {
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
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param key - the key to remove.
	 * @return the map with the content of the map except the key.
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
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param left - the map to update.
	 * @param right - the pairs to remove.
	 * @return the map with the content of the left map except the pairs of the right map.
	 */
	@Pure
	@Inline(value = "MapExtensions.operator_minus(left, right.keySet())", imported = MapExtensions.class)
	public static <K, V> Map<K, V> operator_minus(Map<K, V> left, Map<? extends K, ? extends V> right) {
		return operator_minus(left, right.keySet());
	}

	/**
	 * Replies the elements of the given map except the pairs with the given keys.
	 *
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 *
	 * @param <K> - type of the map keys.
	 * @param <V> - type of the map values.
	 * @param map - the map to update.
	 * @param keys - the keys of the pairs to remove.
	 * @return the map with the content of the map except the pairs.
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, final Iterable<?> keys) {
		return Maps.filterKeys(map, new Predicate<K>() {
			public boolean apply(K input) {
				return !Iterables.contains(keys, input);
			}
		});
	}

}
