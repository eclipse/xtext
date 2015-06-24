/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.internal.BooleanFunctionDelegate;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;
import org.eclipse.xtext.xbase.lib.internal.KeyComparator;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

/**
 * This is an extension library for {@link Iterator iterators}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@GwtCompatible public class IteratorExtensions {

	/**
	 * Wraps an {@link Iterator} in an {@link Iterable}.
	 * @param iterator the {@link Iterator} to wrap in an {@link Iterable}. May not be <code>null</code>.
	 * @return an {@link Iterable} providing the given {@link Iterator}. Never <code>null</code>.
	 */
	@Pure
	public static <T> Iterable<T> toIterable(final Iterator<T> iterator) {
		if (iterator == null)
			throw new NullPointerException("iterator");
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}
	
	/**
	 * <p>
	 * Concatenates two iterators into a single iterator. The returned iterator traverses the
	 * elements in {@code a}, followed by the elements in {@code b}. The resulting iterator is effectivly a view on the
	 * source iterators. That is, the source iterators are not polled until necessary and the result will reflect
	 * changes in the sources.
	 * </p>
	 * <p>
	 * The returned iterator supports {@code remove()} when the corresponding input iterator supports it.
	 * </p>
	 * 
	 * @param a
	 *            the first iterator. May not be <code>null</code>.
	 * @param b
	 *            the second iterator. May not be <code>null</code>.
	 * @return a combined iterator. Never <code>null</code>.
	 */
	@Pure
	@Inline(value="$3.$4concat($1, $2)", imported=Iterators.class)
	public static <T> Iterator<T> operator_plus(Iterator<? extends T> a, Iterator<? extends T> b) {
		return Iterators.concat(a, b);
	}

	/**
	 * Finds the first element in the given iterator that fulfills the predicate. If none is found or the iterator is
	 * empty, <code>null</code> is returned.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return the first element in the iterator for which the given predicate returns <code>true</code>, returns
	 *         <code>null</code> if no element matches the predicate or the iterator is empty.
	 */
	public static <T> T findFirst(Iterator<T> iterator, Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		while(iterator.hasNext()) {
			T t = iterator.next();
			if (predicate.apply(t))
				return t;
		}
		return null;
	}

	/**
	 * Finds the last element in the given iterator that fulfills the predicate. If none is found or the iterator is
	 * empty, <code>null</code> is returned.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return the last element in the iterator for which the given predicate returns <code>true</code>, returns
	 *         <code>null</code> if no element matches the predicate or the iterator is empty.
	 */
	public static <T> T findLast(Iterator<T> iterator, Functions.Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		T result = null;
		while(iterator.hasNext()) {
			T t = iterator.next();
			if (predicate.apply(t))
				result = t;
		}
		return result;
	}

	/**
	 * Returns the first element in the given iterator or <code>null</code> if empty.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return the first element in the iterator or <code>null</code>.
	 */
	public static <T> T head(Iterator<T> iterator) {
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	/**
	 * Returns a view on this iterator that contains all the elements except the first.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return an iterator with all elements except the first. Never <code>null</code>.
	 * @see #drop(Iterator, int)
	 */
	public static <T> Iterator<T> tail(final Iterator<T> iterator) {
		return drop(iterator, 1);
	}

	/**
	 * Returns the last element in the given iterator or <code>null</code> if empty.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return the last element in the iterator or <code>null</code>.
	 */
	public static <T> T last(Iterator<T> iterator) {
		T result = null;
		while(iterator.hasNext()) {
			result = iterator.next();
		}
		return result;
	}

	/**
	 * Returns a view on this iterator that provides at most the first <code>count</code> entries.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param count
	 *            the number of elements that should be returned at most.
	 * @return an iterator with <code>count</code> elements. Never <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>count</code> is negative.
	 */
	@Pure
	public static <T> Iterator<T> take(final Iterator<T> iterator, final int count) {
		if (iterator == null)
			throw new NullPointerException("iterator");
		if (count < 0)
			throw new IllegalArgumentException("Cannot take a negative number of elements. Argument 'count' was: "
					+ count);
		if (count == 0)
			return ImmutableSet.<T>of().iterator();
		return new AbstractIterator<T>() {

			private int remaining = count;

			@Override
			protected T computeNext() {
				if (remaining <= 0)
					return endOfData();
				if (!iterator.hasNext())
					return endOfData();
				remaining--;
				return iterator.next();
			}
		};
	}

	/**
	 * Returns a view on this iterator that provides all elements except the first <code>count</code> entries.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param count
	 *            the number of elements that should be dropped.
	 * @return an iterator without the first <code>count</code> elements. Never <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if <code>count</code> is negative.
	 */
	public static <T> Iterator<T> drop(final Iterator<T> iterator, final int count) {
		if (iterator == null)
			throw new NullPointerException("iterator");
		if (count == 0)
			return iterator;
		if (count < 0)
			throw new IllegalArgumentException("Cannot drop a negative number of elements. Argument 'count' was: "
					+ count);
		return new AbstractIterator<T>() {
			{
				int i = count;
				while (i > 0 && iterator.hasNext()) {
					iterator.next();
					i--;
				}
			}

			@Override
			protected T computeNext() {
				if (!iterator.hasNext())
					return endOfData();
				return iterator.next();
			}
		};
	}

	/**
	 * Returns {@code true} if one or more elements in {@code iterator} satisfy the predicate.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return <code>true</code> if one or more elements in {@code iterator} satisfy the predicate.
	 */
	public static <T> boolean exists(Iterator<T> iterator, Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		while(iterator.hasNext()) {
			if (predicate.apply(iterator.next()))
				return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if every element in {@code iterator} satisfies the predicate. If {@code iterator} is empty,
	 * {@code true} is returned. In other words, <code>false</code> is returned if at least one element fails to fulfill
	 * the predicate.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return <code>true</code> if every element in {@code iterator} satisfies the predicate and also if there is no element.
	 */
	public static <T> boolean forall(Iterator<T> iterator, Function1<? super T, Boolean> predicate) {
		if (predicate == null)
			throw new NullPointerException("predicate");
		while(iterator.hasNext()) {
			if (!predicate.apply(iterator.next()))
				return false;
		}
		return true;
	}

	/**
	 * Returns the elements of {@code unfiltered} that satisfy a predicate. The resulting iterator does not
	 * support {@code remove()}. The returned iterator is a view on the original elements. Changes in the unfiltered
	 * original are reflected in the view.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterator. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return an iterator that contains only the elements that fulfill the predicate. Never <code>null</code>.
	 */
	@Pure
	public static <T> Iterator<T> filter(Iterator<T> unfiltered, Function1<? super T, Boolean> predicate) {
		return Iterators.filter(unfiltered, new BooleanFunctionDelegate<T>(predicate));
	}

	/**
	 * Returns all instances of class {@code type} in {@code unfiltered}. The returned iterator has elements whose class
	 * is {@code type} or a subclass of {@code type}. The returned iterator does not support {@code remove()}.
	 * The returned iterator is a view on the original elements. Changes in the unfiltered original are reflected in
	 * the view.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterator. May not be <code>null</code>.
	 * @param type
	 *            the type of elements desired
	 * @return an unmodifiable iterator containing all elements of the original iterator that were of the requested
	 *         type. Never <code>null</code>.
	 */
	@Pure
	@GwtIncompatible("Class.isInstance")
	@Inline(value="$3.$4filter($1, $2)", imported=Iterators.class)
	public static <T> Iterator<T> filter(Iterator<?> unfiltered, Class<T> type) {
		return Iterators.filter(unfiltered, type);
	}
	
	/**
	 * Returns a new iterator filtering any null references.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterator. May not be <code>null</code>.
	 * @return an unmodifiable iterator containing all elements of the original iterator without any <code>null</code>
	 *         references. Never <code>null</code>.
	 */
	@Pure
	public static <T> Iterator<T> filterNull(Iterator<T> unfiltered) {
		return Iterators.filter(unfiltered, Predicates.notNull());
	}

	/**
	 * Returns an iterator that performs the given {@code transformation} for each element of {@code original} when
	 * requested. The mapping is done lazily. 
	 * 
	 * The returned iterator's iterator supports {@code remove()} if the provided iterator does. After a successful
	 * {@code remove()} call, {@code original} no longer contains the corresponding element.
	 * 
	 * @param original
	 *            the original iterator. May not be <code>null</code>.
	 * @param transformation
	 *            the transformation. May not be <code>null</code>.
	 * @return an iterator that provides the result of the transformation. Never <code>null</code>.
	 */
	@Pure
	public static <T, R> Iterator<R> map(Iterator<T> original, Function1<? super T, ? extends R> transformation) {
		return Iterators.transform(original, new FunctionDelegate<T, R>(transformation));
	}

	/**
	 * Applies {@code procedure} for each element of the given iterator.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 */
	public static <T> void forEach(Iterator<T> iterator, Procedure1<? super T> procedure) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		while(iterator.hasNext()) {
			procedure.apply(iterator.next());
		}
	}
	
	/**
	 * Applies {@code procedure} for each element of the given iterator.
	 * The procedure takes the element and a loop counter. If the counter would overflow, {@link Integer#MAX_VALUE}
	 * is returned for all subsequent elements. The first element is at index zero.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 */
	public static <T> void forEach(Iterator<T> iterator, Procedure2<? super T, ? super Integer> procedure) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		int i = 0;
		while(iterator.hasNext()) {
			procedure.apply(iterator.next(), i);
			if (i != Integer.MAX_VALUE)
				i++;
		}
	}

	/**
	 * Returns the concatenated string representation of the elements in the given iterator. No delimiter is used.
	 * The given iterator is left exhausted.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return the string representation of the iterator's elements. Never <code>null</code>.
	 * @see #join(Iterator, CharSequence, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 */
	public static String join(Iterator<?> iterator) {
		return join(iterator, "");
	}

	/**
	 * Returns the concatenated string representation of the elements in the given iterator. The {@code separator} is
	 * used to between each pair of entries in the input. The string <code>null</code> is used for <code>null</code>
	 * entries in the input. The given iterator is left exhausted.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @return the string representation of the iterator's elements. Never <code>null</code>.
	 * @see #join(Iterator, CharSequence, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 */
	public static String join(Iterator<?> iterator, CharSequence separator) {
		return Joiner.on(separator.toString()).useForNull("null").join(toIterable(iterator));
	}

	/**
	 * Returns the concatenated string representation of the elements in the given iterator. The {@code function} is
	 * used to compute the string for each element. The {@code separator} is used to between each pair of entries in the
	 * input. The string <code>null</code> is used if the function yields <code>null</code> as the string representation
	 * for an entry. The given iterator is left exhausted.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @param function
	 *            the function that is used to compute the string representation of a single element. May not be
	 *            <code>null</code>.
	 * @return the string representation of the iterator's elements. Never <code>null</code>.
	 */
	public static <T> String join(Iterator<T> iterator, CharSequence separator,
			Functions.Function1<? super T, ? extends CharSequence> function) {
		if (separator == null)
			throw new NullPointerException("separator");
		if (function == null)
			throw new NullPointerException("function");
		StringBuilder result = new StringBuilder();
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
	 * Returns the concatenated string representation of the elements in the given iterator. The {@code function} is
	 * used to compute the string for each element. The {@code separator} is used to between each pair of entries in the
	 * input. The string <code>null</code> is used if the function yields <code>null</code> as the string representation
	 * for an entry. The given iterator is left exhausted.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @param before
	 *            prepends the resulting string if the iterator contains at least one element. May be <code>null</code> which is equivalent to passing an empty string.
	 * @param separator
	 *            the separator. May be <code>null</code> which is equivalent to passing an empty string.
	 * @param after
	 *            appended to the resulting string if the iterator contain at least one element. May be <code>null</code> which is equivalent to passing an empty string.
	 * @param function
	 *            the function that is used to compute the string representation of a single element. May not be
	 *            <code>null</code>.
	 * @return the string representation of the iterator's elements. Never <code>null</code>.
	 */
	public static <T> String join(Iterator<T> iterator, CharSequence before, CharSequence separator, CharSequence after,
			Functions.Function1<? super T, ? extends CharSequence> function) {
		if (function == null)
			throw new NullPointerException("function");
		StringBuilder result = new StringBuilder();
		boolean notEmpty = iterator.hasNext(); 
		if (notEmpty && before != null)
			result.append(before);
		while (iterator.hasNext()) {
			T next = iterator.next();
			CharSequence elementToString = function.apply(next);
			result.append(elementToString);
			if (iterator.hasNext() && separator != null)
				result.append(separator);
		}
		if (notEmpty && after != null)
			result.append(after);
		return result.toString();
	}

	/**
	 * Determines whether two iterators contain equal elements in the same order. More specifically, this method returns
	 * {@code true} if {@code iterator} and {@code other} contain the same number of elements and every element of
	 * {@code iterator} is equal to the corresponding element of {@code other}.
	 * 
	 * @param iterator
	 *            an iterator. May not be <code>null</code>.
	 * @param other
	 *            an iterator. May not be <code>null</code>.
	 * @return <code>true</code> if the two iterators contain equal elements in the same order.
	 */
	public static boolean elementsEqual(Iterator<?> iterator, Iterator<?> other) {
		return Iterators.elementsEqual(iterator, other);
	}
	
	/**
	 * Determines whether two iterators contain equal elements in the same order. More specifically, this method returns
	 * {@code true} if {@code iterator} and {@code iterable} contain the same number of elements and every element of
	 * {@code iterator} is equal to the corresponding element of {@code iterable}.
	 * 
	 * @param iterator
	 *            an iterator. May not be <code>null</code>.
	 * @param iterable
	 *            an iterable. May not be <code>null</code>.
	 * @return <code>true</code> if the two iterators contain equal elements in the same order.
	 */
	public static boolean elementsEqual(Iterator<?> iterator, Iterable<?> iterable) {
		return Iterators.elementsEqual(iterator, iterable.iterator());
	}

	/**
	 * Determines if the given iterator is <code>null</code> or contains no elements.
	 * 
	 * @param iterator
	 *            the to-be-queried iterator. May be <code>null</code>.
	 * @return {@code true} if the iterator is <code>null</code> or contains no elements
	 */
	public static boolean isNullOrEmpty(Iterator<?> iterator) {
		return iterator == null || isEmpty(iterator);
	}

	/**
	 * Determines if the given iterator contains no elements.
	 * 
	 * @param iterator
	 *            the to-be-queried iterator. May not be <code>null</code>.
	 * @return {@code true} if the iterator contains no elements
	 * @see #isNullOrEmpty(Iterator)
	 */
	public static boolean isEmpty(Iterator<?> iterator) {
		return !iterator.hasNext();
	}

	/**
	 * Returns the number of elements in {@code iterator}.
	 * The given iterator is left exhausted.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return the number of elements in {@code iterator}.
	 */
	public static int size(Iterator<?> iterator) {
		return Iterators.size(iterator);
	}

	/**
	 * <p>
	 * Applies the combinator {@code function} to all elements of the iterator in turn.
	 * </p>
	 * <p>
	 * One of the function parameters is an element of the iterator, and the other is the result of previous application
	 * of the function. The seed of the operation is the first element in the iterator. The second value is computed by
	 * applying the function to the seed together with the second element of the iterator. The third value is computed
	 * from the previous result together with the third element and so on. In other words, the previous result of each
	 * step is taken and passed together with the next element to the combinator function.
	 * </p>
	 * <p>
	 * If the iterator is empty, <code>null</code> is returned.
	 * </p>
	 * <p>
	 * More formally, given an iterator {@code [a, b, c, d]} and a function {@code f}, the result of {@code reduce} is
	 * <code>f(f(f(a, b), c), d)</code>
	 * </p>
	 * 
	 * @param iterator
	 *            the to-be-reduced iterator. May not be <code>null</code>.
	 * @param function
	 *            the combinator function. May not be <code>null</code>.
	 * @return the last result of the applied combinator function or <code>null</code> for the empty input.
	 */
	public static <T> T reduce(Iterator<? extends T> iterator, Function2<? super T, ? super T, ? extends T> function) {
		if (function == null)
			throw new NullPointerException("function");
		if (iterator.hasNext()) {
			T result = iterator.next();
			while (iterator.hasNext()) {
				result = function.apply(result, iterator.next());
			}
			return result;
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Applies the combinator {@code function} to all elements of the iterator in turn and uses {@code seed} as the
	 * start value.
	 * </p>
	 * <p>
	 * One of the function parameters is an element of the iterator, and the other is the result of previous application
	 * of the function. The seed of the operation is explicitly passed to {@link #fold(Iterator, Object, org.eclipse.xtext.xbase.lib.Functions.Function2)
	 * fold}. The first computed value is the result of the applied function for {@code seed} and the first element of
	 * the iterator. This intermediate result together with the second element of the iterator produced the next result
	 * and so on.
	 * </p>
	 * <p>
	 * {@link #fold(Iterator, Object, org.eclipse.xtext.xbase.lib.Functions.Function2) fold} is similar to {@link #reduce(Iterator, org.eclipse.xtext.xbase.lib.Functions.Function2) reduce} but
	 * allows a {@code seed} value and the combinator {@code function} may be asymmetric. It takes {@code T and R} and
	 * returns {@code R}.
	 * <p>
	 * If the iterator is empty, <code>seed</code> is returned.
	 * </p>
	 * <p>
	 * More formally, given an iterator {@code [a, b, c, d]}, a seed {@code initial} and a function {@code f}, the
	 * result of {@code fold} is <code>f(f(f(f(initial, a), b), c), d)</code>
	 * </p>
	 * 
	 * @param iterator
	 *            the to-be-folded iterator. May not be <code>null</code>.
	 * @param seed
	 *            the initial value. May be <code>null</code>.
	 * @param function
	 *            the combinator function. May not be <code>null</code>.
	 * @return the last result of the applied combinator function or <code>seed</code> for the empty input.
	 */
	public static <T, R> R fold(Iterator<T> iterator, R seed, Function2<? super R, ? super T, ? extends R> function) {
		R result = seed;
		while (iterator.hasNext()) {
			result = function.apply(result, iterator.next());
		}
		return result;
	}

	/**
	 * Returns a list that contains all the entries of the given iterator in the same order. 
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return a list with the same entries as the given iterator. Never <code>null</code>.
	 */
	public static <T> List<T> toList(Iterator<? extends T> iterator) {
		return Lists.newArrayList(iterator);
	}

	/**
	 * Returns a set that contains all the unique entries of the given iterator in the order of their appearance. 
	 * The result set is a copy of the iterator with stable order.
	 * 
	 * @param iterator
	 *            the iterator. May not be <code>null</code>.
	 * @return a set with the unique entries of the given iterator. Never <code>null</code>.
	 */
	public static <T> Set<T> toSet(Iterator<? extends T> iterator) {
		return Sets.newLinkedHashSet(toIterable(iterator));
	}

	/**
	 * Returns a map for which the {@link Map#values} are computed by the given function, and each key is an element in
	 * the given {@code keys}. If the iterator contains equal keys more than once, the last one will be contained in the
	 * map. The map is computed eagerly. That is, subsequent changes in the keys are not reflected by the map.
	 * The key iterator is left exhausted.
	 * 
	 * @param keys
	 *            the keys to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeValues
	 *            the function used to produce the values for each key. May not be <code>null</code>.
	 * @return a map mapping each entry in the given iterator to the corresponding result when evaluating the function
	 *         {@code computeValues}.
	 */
	public static <K, V> Map<K, V> toInvertedMap(Iterator<? extends K> keys, Function1<? super K, V> computeValues) {
		Map<K, V> result = Maps.newLinkedHashMap();
		while(keys.hasNext()) {
			K k = keys.next();
			result.put(k, computeValues.apply(k));
		}
		return result;
	}

	/**
	 * Returns a map for which the {@link Map#values} are the given elements in the given order, and each key is the
	 * product of invoking a supplied function {@code computeKeys} on its corresponding value. If the function produces
	 * the same key for different values, the last one will be contained in the map. The value iterator is left exhausted.
	 * 
	 * @param values
	 *            the values to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeKeys
	 *            the function used to produce the key for each value. May not be <code>null</code>.
	 * @return a map mapping the result of evaluating the function {@code keyFunction} on each value in the input
	 *         iterator to that value
	 */
	public static <K, V> Map<K, V> toMap(Iterator<? extends V> values, Function1<? super V, K> computeKeys) {
		if (computeKeys == null)
			throw new NullPointerException("computeKeys");
		Map<K, V> result = Maps.newLinkedHashMap();
		while(values.hasNext()) {
			V v = values.next();
			result.put(computeKeys.apply(v), v);
		}
		return result;
	}
	
	/**
	 * Returns a map for which the {@link Map#values} is a collection of lists, where the elements in the list will 
	 * appear in the order as they appeared in the iterator. Each key is the product of invoking the supplied 
	 * function {@code computeKeys} on its corresponding value. So a key of that map groups a list of values for 
	 * which the function produced exactly that key. The value iterator is left exhausted.
	 * 
	 * @param values
	 *            the values to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeKeys
	 *            the function used to produce the key for each value. May not be <code>null</code>.
	 * @return a map mapping the result of evaluating the function {@code keyFunction} on each value in the input
	 *         iterator to that value. As there can be more than one value mapped by a key, the mapping result is is a
	 *         list of values.
	 * @since 2.7
	 */
	public static <K, V> Map<K, List<V>> groupBy(Iterator<? extends V> values,
			Function1<? super V, ? extends K> computeKeys) {
		if (computeKeys == null)
			throw new NullPointerException("computeKeys");
		Map<K, List<V>> result = Maps.newLinkedHashMap();
		while(values.hasNext()) {
			V v = values.next();
			K key = computeKeys.apply(v);
			List<V> grouped = result.get(key);
			if (grouped == null) {
				grouped = new ArrayList<V>();
				result.put(key, grouped);
			}
			grouped.add(v);
		}
		return result;
	}	

	/**
	 * Returns an Iterator containing all elements starting from the head of the source up to and excluding the first
	 * element that violates the predicate. The resulting Iterator is a lazily computed view, so any modifications to the
	 * underlying Iterators will be reflected on iteration. The result does not support {@link Iterator#remove()}
	 * 
	 * @param iterator
	 *            the elements from which to take. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate which decides whether to keep taking elements. May not be <code>null</code>.
	 * @return the taken elements
	 * @since 2.7
	 */
	public static <T> Iterator<T> takeWhile(final Iterator<? extends T> iterator, final Function1<? super T, Boolean> predicate) {
		if (iterator == null)
			throw new NullPointerException("iterator");
		if (predicate == null)
			throw new NullPointerException("predicate");
		return new AbstractIterator<T>() {
			@Override
			protected T computeNext() {
				if (!iterator.hasNext())
					return endOfData();
				T next = iterator.next();
				if (predicate.apply(next)) {
					return next;
				} else {
					return endOfData();
				}
			}
		};
	}

	/**
	 * Returns an Iterator containing all elements starting from the first element for which the drop-predicate returned
	 * false. The resulting Iterator is a lazily computed view, so any modifications to the
	 * underlying Iterators will be reflected on iteration. The result does not support {@link Iterator#remove()}
	 * 
	 * @param iterator
	 *            the elements from which to drop. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate which decides whether to keep dropping elements. May not be <code>null</code>.
	 * @return the remaining elements after dropping
	 * @since 2.7
	 */
	public static <T> Iterator<T> dropWhile(final Iterator<? extends T> iterator, final Function1<? super T, Boolean> predicate) {
		if (iterator == null)
			throw new NullPointerException("iterator");
		if (predicate == null)
			throw new NullPointerException("predicate");
		return new AbstractIterator<T>() {
			private boolean headFound = false;

			@Override
			protected T computeNext() {
				while (!headFound) {
					if (!iterator.hasNext())
						return endOfData();
					T next = iterator.next();
					if (!predicate.apply(next)) {
						headFound = true;
						return next;
					}
				}
				if (iterator.hasNext()) {
					return iterator.next();
				} else {
					return endOfData();
				}
			}
		};
	}

	/**
	 * Returns an Iterator of Pairs where the nth pair is created by taking the nth element of the source as the value
	 * and its 0-based index as the key. E.g.
	 * <code>zipWitIndex(#["a", "b", "c"]) == #[(0, "a"), (1, "b"), (2, "c")]</code>
	 * 
	 * If the index would overflow, {@link Integer#MAX_VALUE} is returned for all subsequent elements.
	 * 
	 * The resulting Iterator is a lazily computed view, so any modifications to the underlying Iterator will be
	 * reflected on iteration. The result does not support {@link Iterator#remove()}
	 * 
	 * @param iterator
	 *            the elements. May not be <code>null</code>.
	 * @return the zipped result
	 * @since 2.7
	 */
	public static <A> Iterator<Pair<Integer, A>> indexed(final Iterator<? extends A> iterator) {
		if (iterator == null)
			throw new NullPointerException("iterator");
		return new AbstractIterator<Pair<Integer, A>>() {
			int i = 0;
			@Override
			protected Pair<Integer, A> computeNext() {
				if (iterator.hasNext()) {
					Pair<Integer, A> next = new Pair<Integer, A>(i, iterator.next());
					if (i != Integer.MAX_VALUE)
						i++;
					return next;
				} else {
					return endOfData();
				}
			}
		};
	}

	/**
	 * Finds the minimum of the given elements according to their natural ordering. If there are several mimina, the
	 * first one will be returned.
	 * 
	 * @param iterator
	 *            the mutually comparable elements. May not be <code>null</code>.
	 * @return the minimum
	 * @throws NoSuchElementException
	 *             if the iterator is empty
	 * @since 2.7
	 */
	public static <T extends Comparable<? super T>> T min(final Iterator<T> iterator) {
		return min(iterator, Ordering.natural());
	}

	/**
	 * Finds the element that yields the minimum value when passed to <code>compareBy</code>. If there are several
	 * maxima, the first one will be returned.
	 * 
	 * @param iterator
	 *            the elements to find the minimum of. May not be <code>null</code>.
	 * @param compareBy
	 *            a function that returns a comparable characteristic to compare the elements by. May not be <code>null</code>.
	 * @return the minimum
	 * @throws NoSuchElementException
	 *             if the iterator is empty
	 * @since 2.7
	 */
	public static <T, C extends Comparable<? super C>> T minBy(final Iterator<T> iterator, final Function1<? super T, C> compareBy) {
		if (compareBy == null)
			throw new NullPointerException("compareBy");
		return min(iterator, new KeyComparator<T, C>(compareBy));
	}
	
	/**
	 * Finds the mininmum element according to <code>comparator</code>. If there are several minima, the first one will
	 * be returned.
	 * 
	 * @param iterator
	 *            the elements to find the minimum of. May not be <code>null</code>.
	 * @param comparator
	 *            the comparison function. May not be <code>null</code>.
	 * @return the minimum
	 * @throws NoSuchElementException
	 *             if the iterator is empty
	 * @since 2.7
	 */
	public static <T> T min(final Iterator<T> iterator, Comparator<? super T> comparator) {
		if (comparator == null)
			throw new NullPointerException("comparator");
		T min = iterator.next();
		while (iterator.hasNext()) {
			T element = iterator.next();
			min = comparator.compare(min, element) <= 0 ? min : element;
		}
		return min;
	}

	/**
	 * Finds the maximum of the elements according to their natural ordering. If there are several maxima, the first one
	 * will be returned.
	 * 
	 * @param iterator
	 *            the mutually comparable elements. May not be <code>null</code>.
	 * @return the maximum
	 * @throws NoSuchElementException
	 *             if the iterator is empty
	 * @since 2.7
	 */
	public static <T extends Comparable<? super T>> T max(final Iterator<T> iterator) {
		return max(iterator, Ordering.natural());
	}

	/**
	 * Finds the element that yields the maximum value when passed to <code>compareBy</code> If there are several
	 * maxima, the first one will be returned.
	 * 
	 * @param iterator
	 *            the elements to find the maximum of. May not be <code>null</code>.
	 * @param compareBy
	 *            a function that returns a comparable characteristic to compare the elements by. May not be <code>null</code>.
	 * @return the maximum
	 * @throws NoSuchElementException
	 *             if the iterator is empty
	 * @since 2.7
	 */
	public static <T, C extends Comparable<? super C>> T maxBy(final Iterator<T> iterator, final Function1<? super T, C> compareBy) {
		if (compareBy == null)
			throw new NullPointerException("compareBy");
		return max(iterator, new KeyComparator<T, C>(compareBy));
	}

	/**
	 * Finds the maximum element according to <code>comparator</code>. If there are several maxima, the first one will
	 * be returned.
	 * 
	 * @param iterator
	 *            the elements to find the maximum of. May not be <code>null</code>.
	 * @param comparator
	 *            the comparison function. May not be <code>null</code>.
	 * @return the maximum
	 * @throws NoSuchElementException
	 *             if the iterator is empty
	 * @since 2.7
	 */
	public static <T> T max(final Iterator<T> iterator, Comparator<? super T> comparator) {
		if (comparator == null)
			throw new NullPointerException("comparator");
		T max = iterator.next();
		while (iterator.hasNext()) {
			T element = iterator.next();
			max = comparator.compare(max, element) >= 0 ? max : element;
		}
		return max;
	}
}
