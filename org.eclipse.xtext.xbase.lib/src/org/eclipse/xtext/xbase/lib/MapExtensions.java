/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;
import org.eclipse.xtext.xbase.lib.internal.UnmodifiableMergingMapView;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;


/**
 * This is an extension library for {@link Map maps}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Stephane Galland - Add operators on map structures.
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
			@Override
			public boolean apply(Map.Entry<K, V> input) {
				Boolean result = predicate.apply(input.getKey(), input.getValue());
				return result.booleanValue();
			}
		});
	}
	
	/**
	 * Add the given pair into the map.
	 *
	 * <p>
	 * If the pair key already exists in the map, its value is replaced
	 * by the value in the pair, and the old value in the map is returned.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param map the map to update.
	 * @param entry the entry (key, value) to add into the map.
	 * @return the value previously associated to the key, or <code>null</code>
	 *     if the key was not present in the map before the addition.
	 * @since 2.15
	 */
	@Inline(value = "$1.put($2.getKey(), $2.getValue())", statementExpression = true)
	public static <K, V> V operator_add(Map<K, V> map, Pair<? extends K, ? extends V> entry) {
		return map.put(entry.getKey(), entry.getValue());
	}

	/**
	 * Add the given entries of the input map into the output map.
	 *
	 * <p>
	 * If a key in the inputMap already exists in the outputMap, its value is
	 * replaced in the outputMap by the value from the inputMap.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param outputMap the map to update.
	 * @param inputMap the entries to add.
	 * @since 2.15
	 */
	@Inline(value = "$1.putAll($2)", statementExpression = true)
	public static <K, V> void operator_add(Map<K, V> outputMap, Map<? extends K, ? extends V> inputMap) {
		outputMap.putAll(inputMap);
	}

	/**
	 * Add the given pair to a given map for obtaining a new map.
	 *
	 * <p>
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 * </p>
	 *
	 * <p>
	 * Even if the key of the right operand exists in the left operand, the value in the right operand is preferred.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param left the map to consider.
	 * @param right the entry (key, value) to add into the map.
	 * @return an immutable map with the content of the map and with the given entry.
	 * @throws IllegalArgumentException - when the right operand key exists in the left operand.
	 * @since 2.15
	 */
	@Pure
	@Inline(value = "$3.union($1, $4.singletonMap($2.getKey(), $2.getValue()))",
			imported = { MapExtensions.class, Collections.class })
	public static <K, V> Map<K, V> operator_plus(Map<K, V> left, final Pair<? extends K, ? extends V> right) {
		return union(left, Collections.singletonMap(right.getKey(), right.getValue()));
	}

	/**
	 * Merge the two maps.
	 *
	 * <p>
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 * </p>
	 *
	 * <p>
	 * If a key exists in the left and right operands, the value in the right operand is preferred.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param left the left map.
	 * @param right the right map.
	 * @return a map with the merged contents from the two maps.
	 * @throws IllegalArgumentException - when a right operand key exists in the left operand.
	 * @since 2.15
	 */
	@Pure
	@Inline(value = "$3.union($1, $2)", imported = MapExtensions.class)
	public static <K, V> Map<K, V> operator_plus(Map<K, V> left, Map<? extends K, ? extends V> right) {
		return union(left, right);
	}

	/**
	 * Remove a key from the given map.
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param map the map to update.
	 * @param key the key to remove.
	 * @return the removed value, or <code>null</code> if the key was not
	 *     present in the map.
	 * @since 2.15
	 */
	@Inline(value = "$1.remove($2)", statementExpression = true)
	public static <K, V> V operator_remove(Map<K, V> map, K key) {
		return map.remove(key);
	}

	/**
	 * Remove the given pair into the map.
	 *
	 * <p>
	 * If the given key is inside the map, but is not mapped to the given value, the
	 * map will not be changed.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param map the map to update.
	 * @param entry the entry (key, value) to remove from the map.
	 * @return {@code true} if the pair was removed.
	 * @since 2.15
	 */
	@Inline(value = "$1.remove($2.getKey(), $2.getValue())", statementExpression = true)
	public static <K, V> boolean operator_remove(Map<K, V> map, Pair<? extends K, ? extends V> entry) {
		//TODO use the JRE 1.8 API: map.remove(entry.getKey(), entry.getValue());
		final K key = entry.getKey();
		final V storedValue = map.get(entry.getKey());
	        if (!Objects.equals(storedValue, entry.getValue())
			|| (storedValue == null && !map.containsKey(key))) {
	            return false;
        	}
        	map.remove(key);
	        return true;
	}

	/**
	 * Remove pairs with the given keys from the map.
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param map the map to update.
	 * @param keysToRemove the keys of the pairs to remove.
	 * @since 2.15
	 */
	public static <K, V> void operator_remove(Map<K, V> map, Iterable<? super K> keysToRemove) {
		for (final Object key : keysToRemove) {
			map.remove(key);
		}
	}

	/**
	 * Remove the given pair from a given map for obtaining a new map.
	 *
	 * <p>
	 * If the given key is inside the map, but is not mapped to the given value, the
	 * map will not be changed.
	 * </p>
	 *
	 * <p>
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param left the map to consider.
	 * @param right the entry (key, value) to remove from the map.
	 * @return an immutable map with the content of the map and with the given entry.
	 * @throws IllegalArgumentException - when the right operand key exists in the left operand.
	 * @since 2.15
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> left, final Pair<? extends K, ? extends V> right) {
		return Maps.filterEntries(left, new Predicate<Entry<K, V>>() {
			@Override
			public boolean apply(Entry<K, V> input) {
				return !Objects.equals(input.getKey(), right.getKey()) || !Objects.equals(input.getValue(), right.getValue());
			}
		});
	}

	/**
	 * Replies the elements of the given map except the pair with the given key.
	 *
	 * <p>
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param map the map to update.
	 * @param key the key to remove.
	 * @return the map with the content of the map except the key.
	 * @since 2.15
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, final K key) {
		return Maps.filterKeys(map, new Predicate<K>() {
			@Override
			public boolean apply(K input) {
				return !Objects.equals(input, key);
			}
		});
	}

	/**
	 * Replies the elements of the left map without the pairs in the right map.
	 * If the pair's values differ from
	 * the value within the map, the map entry is not removed.
	 *
	 * <p>
	 * The difference is an immutable
	 * snapshot of the state of the maps at the time this method is called. It
	 * will never change, even if the maps change at a later time.
	 * </p>
	 *
	 * <p>
	 * Since this method uses {@code HashMap} instances internally, the keys of
	 * the supplied maps must be well-behaved with respect to
	 * {@link Object#equals} and {@link Object#hashCode}.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param left the map to update.
	 * @param right the pairs to remove.
	 * @return the map with the content of the left map except the pairs of the right map.
	 * @since 2.15
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> left, final Map<? extends K, ? extends V> right) {
		return Maps.filterEntries(left, new Predicate<Entry<K, V>>() {
			@Override
			public boolean apply(Entry<K, V> input) {
				final V value = right.get(input.getKey());
				if (value == null) {
					return input.getValue() == null && right.containsKey(input.getKey());
				}
				return !Objects.equals(input.getValue(), value);
			}
		});
	}

	/**
	 * Replies the elements of the given map except the pairs with the given keys.
	 *
	 * <p>
	 * The replied map is a view on the given map. It means that any change
	 * in the original map is reflected to the result of this operation.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param map the map to update.
	 * @param keys the keys of the pairs to remove.
	 * @return the map with the content of the map except the pairs.
	 * @since 2.15
	 */
	@Pure
	public static <K, V> Map<K, V> operator_minus(Map<K, V> map, final Iterable<?> keys) {
		return Maps.filterKeys(map, new Predicate<K>() {
			@Override
			public boolean apply(K input) {
				return !Iterables.contains(keys, input);
			}
		});
	}

	/**
	 * Merge the given maps.
	 *
	 * <p>
	 * The replied map is a view on the given two maps.
	 * If a key exists in the two maps, the replied value is the value of the right operand.
	 * </p>
	 *
	 * <p>
	 * Even if the key of the right operand exists in the left operand, the value in the right operand is preferred.
	 * </p>
	 *
	 * <p>
	 * The replied map is unmodifiable.
	 * </p>
	 *
	 * @param <K> type of the map keys.
	 * @param <V> type of the map values.
	 * @param left the left map.
	 * @param right the right map.
	 * @return a map with the merged contents from the two maps.
	 * @since 2.15
	 */
	@Pure
	@Inline(value = "(new $3<$5, $6>($1, $2))", imported = UnmodifiableMergingMapView.class, constantExpression = true)
	public static <K, V> Map<K, V> union(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
		return new UnmodifiableMergingMapView<K, V>(left, right);
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
	@Pure
	public static <K, V1, V2> Map<K, V2> mapValues(Map<K, V1> original, Function1<? super V1, ? extends V2> transformation) {
		return Maps.transformValues(original, new FunctionDelegate<V1, V2>(transformation));
	}

}
