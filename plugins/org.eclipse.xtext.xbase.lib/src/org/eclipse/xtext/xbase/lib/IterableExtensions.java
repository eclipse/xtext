/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This is an extension library for {@link Iterable iterables}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class IterableExtensions {

	/**
	 * <p>
	 * Concatenates two iterables into a single iterable. The returned iterable has an iterator that traverses the
	 * elements in {@code a}, followed by the elements in {@code b}. The resulting iterable is effectivly a view on the
	 * source iterables. That is, the source iterators are not polled until necessary and the result will reflect
	 * changes in the sources.
	 * </p>
	 * <p>
	 * The returned iterable's iterator supports {@code remove()} when the corresponding input iterator supports it.
	 * </p>
	 * 
	 * @param a
	 *            the first iterable. May not be <code>null</code>.
	 * @param b
	 *            the second iterable. May not be <code>null</code>.
	 * @return a combined iterable. Never <code>null</code>.
	 */
	public static <T> Iterable<T> operator_plus(Iterable<? extends T> a, Iterable<? extends T> b) {
		return Iterables.concat(a, b);
	}
	
	/**
	 * Finds the first element in the given iterable that fulfills the predicate. If none is found or the iterable is
	 * empty, <code>null</code> is returned.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return the first element in the iterable for which the given predicate returns <code>true</code>, returns
	 *         <code>null</code> if no element matches the predicate or the iterable is empty.
	 */
	public static <T> T findFirst(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		for (T t : iterable) {
			if (predicate.apply(t))
				return t;
		}
		return null;
	}
	
	/**
	 * Finds the last element in the given iterable that fulfills the predicate. If none is found or the iterable is
	 * empty, <code>null</code> is returned.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return the last element in the iterable for which the given predicate returns <code>true</code>, returns
	 *         <code>null</code> if no element matches the predicate or the iterable is empty.
	 */
	public static <T> T findLast(Iterable<T> iterable, Functions.Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		if (iterable instanceof List<?>) {
			List<T> list = (List<T>) iterable;
			ListIterator<T> iterator = list.listIterator(list.size());
			while(iterator.hasPrevious()) {
				T t = iterator.previous();
				if (predicate.apply(t))
					return t;
			}
			return null;
		} else {
			T result = null;
			for (T t : iterable) {
				if (predicate.apply(t))
					result = t;
			}
			return result;
		}
	}
	
	/**
	 * Returns the first element in the given iterable or <code>null</code> if empty.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return the first element in the iterable or <code>null</code>.
	 */
	public static <T> T head(Iterable<T> iterable) {
		Iterator<T> iterator = iterable.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}
	
	/**
	 * Returns a view on this iterable that contains all the elements except the first.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return an iterable with all elements except the first. Never <code>null</code>.
	 * @see #drop(Iterable, int)
	 */
	public static <T> Iterable<T> tail(final Iterable<T> iterable) {
		return drop(iterable, 1);
	}
	
	/**
	 * Returns the last element in the given iterable or <code>null</code> if empty.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return the last element in the iterable or <code>null</code>.
	 */
	public static <T> T last(Iterable<T> iterable) {
		if (iterable instanceof List<?>) {
			List<T> list = (List<T>) iterable;
			if (list.isEmpty())
				return null;
			return list.get(list.size() - 1);
		} else if (iterable instanceof SortedSet) {
			SortedSet<T> sortedSet = (SortedSet<T>) iterable;
			if (sortedSet.isEmpty())
				return null;
			return sortedSet.last();
		} else {
			T result = null;
			for (T t : iterable) {
				result = t;
			}
			return result;
		}
	}
	
	/**
	 * Returns a view on this iterable that provides at most the first <code>count</code> entries.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param count
	 *            the number of elements that should be returned at most.
	 * @return an iterable with <code>count</code> elements. Never <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>count</code> is negative.
	 */
	public static <T> Iterable<T> take(final Iterable<T> iterable, final int count) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (count < 0)
			throw new IllegalArgumentException("Cannot take a negative number of elements. Argument 'count' was: " + count);
		if (count == 0)
			return Collections.emptyList();
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new AbstractIterator<T>() {

					private int remaining = count;
					
					private Iterator<T> delegate = iterable.iterator();
					
					@Override
					protected T computeNext() {
						if (remaining <= 0)
							return endOfData();
						if (!delegate.hasNext())
							return endOfData();
						remaining--;
						return delegate.next();
					}
				};
			}
		};
	}
	
	/**
	 * Returns a view on this iterable that provides all elements except the first <code>count</code> entries.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param count
	 *            the number of elements that should be dropped.
	 * @return an iterable without the first <code>count</code> elements. Never <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>count</code> is negative.
	 */
	public static <T> Iterable<T> drop(final Iterable<T> iterable, final int count) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (count == 0)
			return iterable;
		if (count < 0)
			throw new IllegalArgumentException("Cannot drop a negative number of elements. Argument 'count' was: " + count);
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new AbstractIterator<T>() {

					private Iterator<T> delegate = iterable.iterator();
					
					{
						int i = count;
						while(i > 0 && delegate.hasNext()) {
							delegate.next();
							i--;
						}
					}
					
					@Override
					protected T computeNext() {
						if (!delegate.hasNext())
							return endOfData();
						return delegate.next();
					}
				};
			}
		};
	}
	
	/**
	 * Returns {@code true} if one or more elements in {@code iterable} satisfy the predicate.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return <code>true</code> if one or more elements in {@code iterable} satisfy the predicate.
	 */
	public static <T> boolean exists(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		for (T t : iterable) {
			if (predicate.apply(t))
				return true;
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if every element in {@code iterable} satisfies the predicate. If {@code iterable} is empty,
	 * {@code true} is returned. In other words, <code>false</code> is returned if at least one element fails
	 * to fulfill the predicate.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return <code>true</code> if one or more elements in {@code iterable} satisfy the predicate. 
	 */
	public static <T> boolean forall(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		for (T t : iterable) {
			if (!predicate.apply(t))
				return false;
		}
		return true;
	}

	/**
	 * Returns the elements of {@code unfiltered} that satisfy a predicate. The resulting iterable's iterator does not
	 * support {@code remove()}. The returned iterable is a view on the original elements. Changes in the unfiltered 
	 * original are reflected in the view.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterable. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return an iterable that contains only the elements that fulfill the predicate. Never <code>null</code>.
	 */
	public static final <T> Iterable<T> filter(Iterable<T> unfiltered, Function1<? super T, Boolean> predicate) {
		return Iterables.filter(unfiltered, new BooleanFunctionDelegate<T>(predicate));
	}

	/**
	 * Returns all instances of class {@code type} in {@code unfiltered}. The returned iterable has elements whose class
	 * is {@code type} or a subclass of {@code type}. The returned iterable's iterator does not support {@code remove()}.
	 * The returned iterable is a view on the original elements. Changes in the unfiltered original are reflected in
	 * the view.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterable. May not be <code>null</code>.
	 * @param type
	 *            the type of elements desired
	 * @return an unmodifiable iterable containing all elements of the original iterable that were of the requested
	 *         type. Never <code>null</code>.
	 */
	public static final <T> Iterable<T> filter(Iterable<?> unfiltered, Class<T> type) {
		return Iterables.filter(unfiltered, type);
	}

	/**
	 * Returns an iterable that performs the given {@code transformation} for each element of {@code original} when
	 * requested. The mapping is done lazily. That is, subsequent iterations of the elements in the iterable will
	 * repeatedly apply the transformation.
	 * 
	 * The returned iterable's iterator supports {@code remove()} if the provided iterator does. After a successful
	 * {@code remove()} call, {@code original} no longer contains the corresponding element.
	 * 
	 * @param original
	 *            the original iterable. May not be <code>null</code>.
	 * @param transformation
	 *            the transformation. May not be <code>null</code>.
	 * @return an iterable that provides the result of the transformation. Never <code>null</code>.
	 */
	public static final <T, R> Iterable<R> map(Iterable<T> original, Function1<? super T, R> transformation) {
		return Iterables.transform(original, new FunctionDelegate<T, R>(transformation));
	}
	
	/**
	 * Combines multiple iterables into a single iterable. The returned iterable has an iterator that traverses the
	 * elements of each iterable in {@code inputs}. The input iterators are not polled until necessary.
	 * 
	 * <p>
	 * The returned iterable's iterator supports {@code remove()} when the corresponding input iterator supports it. The
	 * methods of the returned iterable may throw {@code NullPointerException} if any of the input iterators are null.
	 * 
	 * @param inputs
	 *            the to be flattened iterables. May not be <code>null</code>.
	 * @return an iterable that provides the concatenated values of the input elements. Never <code>null</code>.
	 */
	public static final <T> Iterable<T> flatten(Iterable<? extends Iterable<? extends T>> inputs) {
		return Iterables.concat(inputs);
	}
	
	/**
	 * Applies {@code function} with each element of the given iterable. The return value is ignored.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param function
	 *            the function. May not be <code>null</code>.
	 */
	public static final <T> void forEach(Iterable<T> iterable, Function1<? super T, ?> function) {
		if (function == null)
			throw new NullPointerException("function");
		for(T t: iterable) {
			function.apply(t);
		}
	}
	
	/**
	 * Returns the concatenated string representation of the elements in the given iterable. No delimiter is used.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param the string representation of the iterable's elements. Never <code>null</code>.
	 * @see #join(Iterable, CharSequence, Function1)
	 */
	public static final String join(Iterable<?> iterable) {
		return join(iterable, "");
	}
	
	/**
	 * Returns the concatenated string representation of the elements in the given iterable. 
	 * The {@code separator} is used to between each pair of entries in the input.
	 * The string <code>null</code> is used for <code>null</code> entries in the input.
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @param the string representation of the iterable's elements. Never <code>null</code>.
	 * @see #join(Iterable, CharSequence, Function1)
	 */
	public static final String join(Iterable<?> iterable, CharSequence separator) {
		return Joiner.on(separator.toString()).useForNull("null").join(iterable);
	}
	
	/**
	 * Returns the concatenated string representation of the elements in the given iterable.
	 * The {@code function} is used to compute the string for each element.
	 * The {@code separator} is used to between each pair of entries in the input.
	 * The string <code>null</code> is used if the function yields <code>null</code> as the 
	 * string representation for an entry.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @param the string representation of the iterable's elements. Never <code>null</code>.
	 */
	public static final <T> String join(Iterable<T> iterable, CharSequence separator, 
			Functions.Function1<? super T, ? extends CharSequence> function) {
		if (separator == null)
			throw new NullPointerException("separator");
		if (function == null)
			throw new NullPointerException("function");
		StringBuilder result = new StringBuilder();
		Iterator<T> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			CharSequence elementToString = function.apply(next);
			result.append(elementToString);
			if (iterator.hasNext())
				result.append(separator);
		}
		return result.toString();
	}
	

	/**
	 * Determines whether two iterables contain equal elements in the same order. More specifically, this method returns
	 * {@code true} if {@code iterable1} and {@code iterable2} contain the same number of elements and every element of
	 * {@code iterable1} is equal to the corresponding element of {@code iterable2}.
	 * @param iterable an iterable. May not be <code>null</code>.
	 * @param other an iterable. May not be <code>null</code>.
	 * @return <code>true</code> if the two iterables contain equal elements in the same order.
	 */
	public static final boolean elementsEqual(Iterable<?> iterable, Iterable<?> other) {
		return Iterables.elementsEqual(iterable, other);
	}
	
	/**
	 * Determines if the given iterable is <code>null</code> or contains no elements.
	 * 
	 * @param iterable the to-be-queried iterable. May be <code>null</code>.
	 * @return {@code true} if the iterable is <code>null</code> or contains no elements
	 */
	public static final boolean isNullOrEmpty(Iterable<?> iterable) {
		return iterable == null || isEmpty(iterable);
	}
	
	/**
	 * Determines if the given iterable contains no elements.
	 * 
	 * @param iterable the to-be-queried iterable. May not be <code>null</code>.
	 * @return {@code true} if the iterable contains no elements
	 * @see #isNullOrEmpty(Iterable)
	 */
	public static final boolean isEmpty(Iterable<?> iterable) {
		if (iterable instanceof Collection<?>)
			return ((Collection<?>) iterable).isEmpty();
		return !iterable.iterator().hasNext();
	}
	
	/**
	 * Returns the number of elements in {@code iterable}.
	 * @param iterable the iterable. May not be <code>null</code>.
	 * @return the number of elements in {@code iterable}.
	 */
	public static final int size(Iterable<?> iterable) {
		return Iterables.size(iterable);
	}

	/**
	 * <p>
	 * Applies the combinator {@code function} to all elements of the iterable in turn.
	 * </p>
	 * <p>
	 * One of the function parameters is an element of the iterable, and the other is the result of previous application
	 * of the function. The seed of the operation is the first element in the iterable. The second value is computed by
	 * applying the function to the seed together with the second element of the iterable. The third value is computed
	 * from the previous result together with the third element and so on. In other words, the previous result of each
	 * step is taken and passed together with the next element to the combinator function.
	 * </p>
	 * <p>
	 * If the iterable is empty, <code>null</code> is returned.
	 * </p>
	 * <p>
	 * More formally, given an iterable {@code [a, b, c, d]} and a function {@code f}, the result of {@code reduce} is
	 * <code>f(f(f(a, b), c), d)</code>
	 * </p>
	 * 
	 * @param iterable
	 *            the to-be-reduced iterable. May not be <code>null</code>.
	 * @param function
	 *            the combinator function. May not be <code>null</code>.
	 * @return the last result of the applied combinator function or <code>null</code> for the empty input.
	 */
	public static <T> T reduce(Iterable<T> iterable, Function2<? super T, ? super T, ? extends T> function) {
		if (function == null)
			throw new NullPointerException("function");
		Iterator<T> iterator = iterable.iterator();
		if (iterator.hasNext()) {
			T result = iterator.next();
			while(iterator.hasNext()) {
				result = function.apply(result, iterator.next());
			}
			return result;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>
	 * Applies the combinator {@code function} to all elements of the iterable in turn and uses {@code seed} as the
	 * start value.
	 * </p>
	 * <p>
	 * One of the function parameters is an element of the iterable, and the other is the result of previous application
	 * of the function. The seed of the operation is explicitly passed to {@link #fold(Iterable, Object, Function2)
	 * fold}. The first computed value is the result of the applied function for {@code seed} and the first element of
	 * the iterable. This intermediate result together with the second element of the iterable produced the next result
	 * and so on.
	 * </p>
	 * <p>
	 * {@link #fold(Iterable, Object, Function2) fold} is similar to {@link #reduce(Iterable, Function2) reduce} but
	 * allows a {@code seed} value and the combinator {@code function} may be asymmetric. It takes {@code T and R} and
	 * returns {@code R}.
	 * <p>
	 * If the iterable is empty, <code>seed</code> is returned.
	 * </p>
	 * <p>
	 * More formally, given an iterable {@code [a, b, c, d]}, a seed {@code initial} and a function {@code f}, the
	 * result of {@code fold} is <code>f(f(f(f(initial, a), b), c), d)</code>
	 * </p>
	 * 
	 * @param iterable
	 *            the to-be-folded iterable. May not be <code>null</code>.
	 * @param seed
	 *            the initial value. May be <code>null</code>.
	 * @param function
	 *            the combinator function. May not be <code>null</code>.
	 * @return the last result of the applied combinator function or <code>seed</code> for the empty input.
	 */
	public static <T, R> R fold(Iterable<T> iterable, R seed, Function2<? super R, ? super T, ? extends R> function) {
		R result = seed;
		Iterator<T> iterator = iterable.iterator();
		while(iterator.hasNext()) {
			result = function.apply(result, iterator.next());
		}
		return result;
	}
	
	/**
	 * Returns a list that contains all the entries of the given iterable in the same order. If the iterable is of type
	 * {@link List}, itself is returned. In all other cases, the result list is a copy of the iterable.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return a list with the same entries as the given iterable. May be the same as the given iterable iff it
	 *         implements {@link List}, otherwise a copy is returned. Never <code>null</code>.
	 */
	public static <T> List<T> toList(Iterable<T> iterable) {
		if (iterable instanceof List<?>) {
			List<T> result = (List<T>) iterable;
			return result;
		}
		return Lists.newArrayList(iterable);
	}
	
	/**
	 * Returns a set that contains all the unique entries of the given iterable in the order of their
	 * appearance. If the iterable is of type
	 * {@link Set}, itself is returned. In all other cases, the result set is a copy of the iterable with stable order.
	 * 
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return a set with the unique entries of the given iterable. May be the same as the given iterable iff it
	 *         implements {@link Set}, otherwise a copy is returned. Never <code>null</code>.
	 */
	public static <T> Set<T> toSet(Iterable<T> iterable) {
		if (iterable instanceof Set<?>) {
			Set<T> result = (Set<T>) iterable;
			return result;
		}
		return Sets.newLinkedHashSet(iterable);
	}
	
	/**
	 * Returns a map for which the {@link Map#values} are computed by the given function, and each key
	 * is an element in the given {@code keys}.
	 * If the iterable contains equal keys more than once, the last one will be contained in the map.
	 * The map is computed eagerly. That is, subsequent changes in the keys are not reflected by the map.
	 * 
	 * @param keys
	 *            the keys to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeValues
	 *            the function used to produce the values for each key. May not be <code>null</code>.
	 * @return a map mapping each entry in the given iterable to the corresponding result when evaluating the 
	 *         function {@code computeValues}.
	 */
	public static <K, V> Map<K, V> toInvertedMap(Iterable<K> keys, Function1<? super K, V> computeValues) {
		Map<K, V> result = Maps.newLinkedHashMap();
		for(K k: keys) {
			result.put(k, computeValues.apply(k));
		}
		return result;
	}
	
	/**
	 * Returns a map for which the {@link Map#values} are the given elements in the given order, and each key
	 * is the product of invoking a supplied function {@code computeKeys} on its corresponding value.
	 * If the function produces the same key for different values, the last one will be contained in the map.
	 * 
	 * @param values
	 *            the values to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeKeys
	 *            the function used to produce the key for each value. May not be <code>null</code>.
	 * @return a map mapping the result of evaluating the function {@code keyFunction} on each value in the input
	 *         collection to that value
	 */
	public static <K, V> Map<K, V> toMap(Iterable<V> values, Function1<? super V, K> computeKeys) {
		if (computeKeys == null)
			throw new NullPointerException("computeKeys");
		Map<K, V> result = Maps.newLinkedHashMap();
		for(V v: values) {
			result.put(computeKeys.apply(v), v);
		}
		return result;
	}
	
	/**
	 * Creates a sorted list that contains the items of the given iterable. 
	 * The resulting list is in ascending order, according to the natural ordering of the 
	 * elements in the iterable.
	 * 
	 * @param iterable
	 *            the items to be sorted. May not be <code>null</code>.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see Collections#sort(List)
	 * @see #sort(Iterable, Comparator)
	 * @see #sortBy(Iterable, Function1)
	 * @see ListExtensions#sortInplace(List)
	 */
	public static <T extends Comparable<? super T>> List<T> sort(Iterable<T> iterable) {
		return ListExtensions.sortInplace(Lists.newArrayList(iterable));
	}

	/**
	 * Creates a sorted list that contains the items of the given iterable. 
	 * The resulting list is sorted according to the order induced by the specified comparator.
	 * 
	 * @param iterable
	 *            the items to be sorted. May not be <code>null</code>.
	 * @param comparator
	 *            the comparator to be used. May be <code>null</code> to indicate that the natural ordering of the
	 *            elements should be used.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see Collections#sort(List, Comparator)
	 * @see #sort(Iterable)
	 * @see #sortBy(Iterable, Function1)
	 * @see ListExtensions#sortInplace(List, Comparator)
	 */
	public static <T> List<T> sort(Iterable<T> iterable, Comparator<? super T> comparator) {
		return ListExtensions.sortInplace(Lists.newArrayList(iterable), comparator);
	}

	/**
	 * Creates a sorted list that contains the items of the given iterable.
	 * The resulting list is sorted according to the order induced by applying a key function to each element which yields a
	 * comparable criteria.
	 * 
	 * @param iterable
	 *            the elements to be sorted. May not be <code>null</code>.
	 * @param key
	 *            the key function to-be-used. May not be <code>null</code>.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see #sort(Iterable)
	 * @see #sort(Iterable, Comparator)
	 * @see ListExtensions#sortInplaceBy(List, Function1)
	 */
	public static <T, C extends Comparable<? super C>> List<T> sortBy(Iterable<T> iterable, final Functions.Function1<? super T, C> key) {
		return ListExtensions.sortInplaceBy(Lists.newArrayList(iterable), key);
	}

	/*
	 * Internal wrapper to look like a google.collect predicate
	 */
	protected static class BooleanFunctionDelegate<T> implements Predicate<T> {

		private final Function1<? super T, Boolean> delegate;

		protected BooleanFunctionDelegate(Function1<? super T, Boolean> delegate) {
			if (delegate == null)
				throw new NullPointerException("delegate");
			this.delegate = delegate;
		}
		
		public boolean apply(T input) {
			Boolean result = delegate.apply(input);
			return result.booleanValue();
		}
		
	}
	
	/*
	 * Internal wrapper to look like a google.collect function
	 */
	protected static class FunctionDelegate<P, R> implements Function<P, R> {

		private final Function1<? super P, R> delegate;

		protected FunctionDelegate(Function1<? super P, R> delegate) {
			if (delegate == null)
				throw new NullPointerException("delegate");
			this.delegate = delegate;
		}
		
		public R apply(P input) {
			R result = delegate.apply(input);
			return result;
		}
		
	}
	
}
