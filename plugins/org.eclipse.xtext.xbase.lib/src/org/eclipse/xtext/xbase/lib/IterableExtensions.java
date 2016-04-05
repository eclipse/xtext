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
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.internal.BooleanFunctionDelegate;
import org.eclipse.xtext.xbase.lib.internal.FunctionDelegate;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * This is an extension library for {@link Iterable iterables}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@GwtCompatible
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
	@Pure
	@Inline(value="$3.$4concat($1, $2)", imported=Iterables.class)
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
		return IteratorExtensions.findFirst(iterable.iterator(), predicate);
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
			while (iterator.hasPrevious()) {
				T t = iterator.previous();
				if (predicate.apply(t))
					return t;
			}
			return null;
		} else {
			return IteratorExtensions.findLast(iterable.iterator(), predicate);
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
		return IteratorExtensions.head(iterable.iterator());
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
			return IteratorExtensions.last(iterable.iterator());
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
			throw new IllegalArgumentException("Cannot take a negative number of elements. Argument 'count' was: "
					+ count);
		if (count == 0)
			return Collections.emptyList();
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return IteratorExtensions.take(iterable.iterator(), count);
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
	@Pure
	public static <T> Iterable<T> drop(final Iterable<T> iterable, final int count) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (count == 0)
			return iterable;
		if (count < 0)
			throw new IllegalArgumentException("Cannot drop a negative number of elements. Argument 'count' was: "
					+ count);
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return IteratorExtensions.drop(iterable.iterator(), count);
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
		return IteratorExtensions.exists(iterable.iterator(), predicate);
	}

	/**
	 * Returns {@code true} if every element in {@code iterable} satisfies the predicate. If {@code iterable} is empty,
	 * {@code true} is returned. In other words, <code>false</code> is returned if at least one element fails to fulfill
	 * the predicate.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate. May not be <code>null</code>.
	 * @return <code>true</code> if every element in {@code iterable} satisfies the predicate and also if there is no element.
	 */
	public static <T> boolean forall(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		return IteratorExtensions.forall(iterable.iterator(), predicate);
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
	@Pure
	public static <T> Iterable<T> filter(Iterable<T> unfiltered, Function1<? super T, Boolean> predicate) {
		return Iterables.filter(unfiltered, new BooleanFunctionDelegate<T>(predicate));
	}

	/**
	 * Returns all instances of class {@code type} in {@code unfiltered}. The returned iterable has elements whose class
	 * is {@code type} or a subclass of {@code type}. The returned iterable's iterator does not support {@code remove()}
	 * . The returned iterable is a view on the original elements. Changes in the unfiltered original are reflected in
	 * the view.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterable. May not be <code>null</code>.
	 * @param type
	 *            the type of elements desired
	 * @return an unmodifiable iterable containing all elements of the original iterable that were of the requested
	 *         type. Never <code>null</code>.
	 */
	@GwtIncompatible("Class.isInstance")
	@Pure
	@Inline(value="$3.$4filter($1, $2)", imported=Iterables.class)
	public static <T> Iterable<T> filter(Iterable<?> unfiltered, Class<T> type) {
		return Iterables.filter(unfiltered, type);
	}
	
	/**
	 * Returns a new iterable filtering any null references.
	 * 
	 * @param unfiltered
	 *            the unfiltered iterable. May not be <code>null</code>.
	 * @return an unmodifiable iterable containing all elements of the original iterable without any <code>null</code> references. Never <code>null</code>.
	 */
	@Pure
	public static <T> Iterable<T> filterNull(Iterable<T> unfiltered) {
		return Iterables.filter(unfiltered, Predicates.notNull());
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
	@Pure
	public static <T, R> Iterable<R> map(Iterable<T> original, Function1<? super T, ? extends R> transformation) {
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
	@Inline(value="$2.$3concat($1)", imported=Iterables.class)
	public static <T> Iterable<T> flatten(Iterable<? extends Iterable<? extends T>> inputs) {
		return Iterables.concat(inputs);
	}

	/**
	 * Applies {@code procedure} for each element of the given iterable.
	 * 
	 * This method has been deprecated because calls such as myIterable.forEach[] will call
	 * org.eclipse.xtext.xbase.lib.IterableExtensions.forEach(Iterable<T>, Procedure1<? super T>) when using Java 7 (or older) and
	 * java.lang.Iterable.forEach(Consumer<? super T>) when using Java 8 or newer.
	 * 
	 * Since this "magic" change in the Xtend-compilers output (the transpiled Java code) is undesirable, it is reommended to use
	 * 
	 * myIterable.forEach[] for java.lang.Iterable.forEach(Consumer<? super T>) and
	 * 
	 * myIterable.forach[] for org.eclipse.xtext.xbase.lib.IterableExtensions.foreach(Iterable<T>, Procedure1<? super T>)
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 * 
	 * @deprecated use java.lang.Iterable.forEach(Consumer<? super T>) from Java 8 or {@link #foreach(Iterable, Procedure1)} from this file.
	 */
	@Deprecated
	public static <T> void forEach(Iterable<T> iterable, Procedure1<? super T> procedure) {
		IteratorExtensions.forEach(iterable.iterator(), procedure);
	}
	
	/**
	 * Applies {@code procedure} for each element of the given iterable.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 */
	public static <T> void foreach(Iterable<T> iterable, Procedure1<? super T> procedure) {
		IteratorExtensions.forEach(iterable.iterator(), procedure);
	}
	
	/**
	 * Applies {@code procedure} for each element of the given iterable.
	 * The procedure takes the element and a loop counter. If the counter would overflow, {@link Integer#MAX_VALUE}
	 * is returned for all subsequent elements. The first element is at index zero.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param procedure
	 *            the procedure. May not be <code>null</code>.
	 * @since 2.3
	 */
	public static <T> void forEach(Iterable<T> iterable, Procedure2<? super T, ? super Integer> procedure) {
		IteratorExtensions.forEach(iterable.iterator(), procedure);
	}

	/**
	 * Returns the concatenated string representation of the elements in the given iterable. No delimiter is used.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return the string representation of the iterable's elements. Never <code>null</code>.
	 * @see #join(Iterable, CharSequence, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 */
	public static String join(Iterable<?> iterable) {
		return IteratorExtensions.join(iterable.iterator());
	}

	/**
	 * Returns the concatenated string representation of the elements in the given iterable. The {@code separator} is
	 * used to between each pair of entries in the input. The string <code>null</code> is used for <code>null</code>
	 * entries in the input.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @return the string representation of the iterable's elements. Never <code>null</code>.
	 * @see #join(Iterable, CharSequence, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 */
	public static String join(Iterable<?> iterable, CharSequence separator) {
		return IteratorExtensions.join(iterable.iterator(), separator);
	}

	/**
	 * Returns the concatenated string representation of the elements in the given iterable. The {@code function} is
	 * used to compute the string for each element. The {@code separator} is used to between each pair of entries in the
	 * input. The string <code>null</code> is used if the function yields <code>null</code> as the string representation
	 * for an entry.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param separator
	 *            the separator. May not be <code>null</code>.
	 * @param function
	 *            the function that is used to compute the string representation of a single element. May not be
	 *            <code>null</code>.
	 * @return the string representation of the iterable's elements. Never <code>null</code>.
	 */
	public static <T> String join(Iterable<T> iterable, CharSequence separator,
			Functions.Function1<? super T, ? extends CharSequence> function) {
		return IteratorExtensions.join(iterable.iterator(), separator, function);
	}
	
	/**
	 * Returns the concatenated string representation of the elements in the given iterable. The {@code function} is
	 * used to compute the string for each element. The {@code separator} is used to between each pair of entries in the
	 * input. The string <code>null</code> is used if the function yields <code>null</code> as the string representation
	 * for an entry.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @param before
	 *            prepends the resulting string if the iterable contains at least one element. May be <code>null</code> which is equivalent to passing an empty string.
	 * @param separator
	 *            the separator. May be <code>null</code> which is equivalent to passing an empty string.
	 * @param after
	 *            appended to the resulting string if the iterable contain at least one element. May be <code>null</code> which is equivalent to passing an empty string.
	 * @param function
	 *            the function that is used to compute the string representation of a single element. May not be
	 *            <code>null</code>.
	 * @return the string representation of the iterable's elements. Never <code>null</code>.
	 */
	public static <T> String join(Iterable<T> iterable, CharSequence before, CharSequence separator, CharSequence after,
			Functions.Function1<? super T, ? extends CharSequence> function) {
		return IteratorExtensions.join(iterable.iterator(), before, separator, after, function);
	}

	/**
	 * Determines whether two iterables contain equal elements in the same order. More specifically, this method returns
	 * {@code true} if {@code iterable} and {@code other} contain the same number of elements and every element of
	 * {@code iterable} is equal to the corresponding element of {@code other}.
	 * 
	 * @param iterable
	 *            an iterable. May not be <code>null</code>.
	 * @param other
	 *            an iterable. May not be <code>null</code>.
	 * @return <code>true</code> if the two iterables contain equal elements in the same order.
	 */
	public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> other) {
		return Iterables.elementsEqual(iterable, other);
	}

	/**
	 * Determines if the given iterable is <code>null</code> or contains no elements.
	 * 
	 * @param iterable
	 *            the to-be-queried iterable. May be <code>null</code>.
	 * @return {@code true} if the iterable is <code>null</code> or contains no elements
	 */
	public static boolean isNullOrEmpty(Iterable<?> iterable) {
		return iterable == null || isEmpty(iterable);
	}

	/**
	 * Determines if the given iterable contains no elements.
	 * 
	 * @param iterable
	 *            the to-be-queried iterable. May not be <code>null</code>.
	 * @return {@code true} if the iterable contains no elements
	 * @see #isNullOrEmpty(Iterable)
	 */
	public static boolean isEmpty(Iterable<?> iterable) {
		if (iterable instanceof Collection<?>)
			return ((Collection<?>) iterable).isEmpty();
		return !iterable.iterator().hasNext();
	}

	/**
	 * Returns the number of elements in {@code iterable}.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return the number of elements in {@code iterable}.
	 */
	public static int size(Iterable<?> iterable) {
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
	public static <T> T reduce(Iterable<? extends T> iterable, Function2<? super T, ? super T, ? extends T> function) {
		return IteratorExtensions.reduce(iterable.iterator(), function);
	}

	/**
	 * <p>
	 * Applies the combinator {@code function} to all elements of the iterable in turn and uses {@code seed} as the
	 * start value.
	 * </p>
	 * <p>
	 * One of the function parameters is an element of the iterable, and the other is the result of previous application
	 * of the function. The seed of the operation is explicitly passed to
	 * {@link #fold(Iterable, Object, org.eclipse.xtext.xbase.lib.Functions.Function2) fold}. The first computed value
	 * is the result of the applied function for {@code seed} and the first element of the iterable. This intermediate
	 * result together with the second element of the iterable produced the next result and so on.
	 * </p>
	 * <p>
	 * {@link #fold(Iterable, Object, org.eclipse.xtext.xbase.lib.Functions.Function2) fold} is similar to
	 * {@link #reduce(Iterable, org.eclipse.xtext.xbase.lib.Functions.Function2) reduce} but allows a {@code seed} value
	 * and the combinator {@code function} may be asymmetric. It takes {@code T and R} and returns {@code R}.
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
		return IteratorExtensions.fold(iterable.iterator(), seed, function);
	}

	/**
	 * Returns a list that contains all the entries of the given iterable in the same order. If the iterable is of type
	 * {@link List}, itself is returned. Therefore an unchecked cast is performed. 
	 * In all other cases, the result list is a copy of the iterable.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return a list with the same entries as the given iterable. May be the same as the given iterable iff it
	 *         implements {@link List}, otherwise a copy is returned. Never <code>null</code>.
	 */
	@Beta
	public static <T> List<T> toList(Iterable<T> iterable) {
		if (iterable instanceof List<?>) {
			List<T> result = (List<T>) iterable;
			return result;
		}
		return Lists.newArrayList(iterable);
	}

	/**
	 * Returns a set that contains all the unique entries of the given iterable in the order of their appearance. If the
	 * iterable is of type {@link Set}, itself is returned. Therefore an unchecked cast is performed.
	 * In all other cases, the result set is a copy of the iterable with stable order.
	 * 
	 * @param iterable
	 *            the iterable. May not be <code>null</code>.
	 * @return a set with the unique entries of the given iterable. May be the same as the given iterable iff it
	 *         implements {@link Set}, otherwise a copy is returned. Never <code>null</code>.
	 */
	@Beta
	public static <T> Set<T> toSet(Iterable<T> iterable) {
		if (iterable instanceof Set<?>) {
			Set<T> result = (Set<T>) iterable;
			return result;
		}
		return Sets.newLinkedHashSet(iterable);
	}

	/**
	 * Returns a map for which the {@link Map#values} are computed by the given function, and each key is an element in
	 * the given {@code keys}. If the iterable contains equal keys more than once, the last one will be contained in the
	 * map. The map is computed eagerly. That is, subsequent changes in the keys are not reflected by the map.
	 * 
	 * @param keys
	 *            the keys to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeValues
	 *            the function used to produce the values for each key. May not be <code>null</code>.
	 * @return a map mapping each entry in the given iterable to the corresponding result when evaluating the function
	 *         {@code computeValues}.
	 */
	public static <K, V> Map<K, V> toInvertedMap(Iterable<? extends K> keys, Function1<? super K, V> computeValues) {
		return IteratorExtensions.toInvertedMap(keys.iterator(), computeValues);
	}

	/**
	 * Returns a map for which the {@link Map#values} are the given elements in the given order, and each key is the
	 * product of invoking a supplied function {@code computeKeys} on its corresponding value. If the function produces
	 * the same key for different values, the last one will be contained in the map.
	 * 
	 * @param values
	 *            the values to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeKeys
	 *            the function used to produce the key for each value. May not be <code>null</code>.
	 * @return a map mapping the result of evaluating the function {@code keyFunction} on each value in the input
	 *         collection to that value
	 */
	public static <K, V> Map<K, V> toMap(Iterable<? extends V> values, Function1<? super V, K> computeKeys) {
		return IteratorExtensions.toMap(values.iterator(), computeKeys);
	}
	
	/**
	 * Returns a map for which the {@link Map#values} is a collection of lists, where the elements in the list will 
	 * appear in the order as they appeared in the iterable. Each key is the product of invoking the supplied 
	 * function {@code computeKeys} on its corresponding value. So a key of that map groups a list of values for 
	 * which the function produced exactly that key.  
	 * 
	 * @param values
	 *            the values to use when constructing the {@code Map}. May not be <code>null</code>.
	 * @param computeKeys
	 *            the function used to produce the key for each value. May not be <code>null</code>.
	 * @return a map mapping the result of evaluating the function {@code keyFunction} on each value in the input
	 *         iterable to that value. As there can be more than one value mapped by a key, the mapping result is is a
	 *         list of values.
	 * @since 2.7
	 */
	public static <K, V> Map<K, List<V>> groupBy(Iterable<? extends V> values,
			Function1<? super V, ? extends K> computeKeys) {
		return IteratorExtensions.groupBy(values.iterator(), computeKeys);
   }

	/**
	 * Creates a sorted list that contains the items of the given iterable. The resulting list is in ascending order,
	 * according to the natural ordering of the elements in the iterable.
	 * 
	 * @param iterable
	 *            the items to be sorted. May not be <code>null</code>.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see Collections#sort(List)
	 * @see #sort(Iterable, Comparator)
	 * @see #sortBy(Iterable, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 * @see ListExtensions#sortInplace(List)
	 */
	public static <T extends Comparable<? super T>> List<T> sort(Iterable<T> iterable) {
		List<T> asList = Lists.newArrayList(iterable);
		if (iterable instanceof SortedSet<?>) {
			if (((SortedSet<T>) iterable).comparator() == null) {
				return asList;
			}
		}
		return ListExtensions.sortInplace(asList);
	}

	/**
	 * This method is deprecated in favor of {@link #sortWith(Iterable, Comparator)}.
	 * 
	 * Creates a sorted list that contains the items of the given iterable. The resulting list is sorted according to
	 * the order induced by the specified comparator.
	 * 
	 * @param iterable
	 *            the items to be sorted. May not be <code>null</code>.
	 * @param comparator
	 *            the comparator to be used. May be <code>null</code> to indicate that the natural ordering of the
	 *            elements should be used.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see IterableExtensions#sortWith(Iterable, Comparator)
	 * @deprecated Use {@link #sortWith(Iterable, Comparator)} instead.
	 */
	@Deprecated
	@Inline(value="$3.$4sortWith($1, $2)", imported=IterableExtensions.class)
	public static <T> List<T> sort(Iterable<T> iterable, Comparator<? super T> comparator) {
		return sortWith(iterable, comparator);
	}
	
	/**
	 * Creates a sorted list that contains the items of the given iterable. The resulting list is sorted according to
	 * the order induced by the specified comparator.
	 * 
	 * @param iterable
	 *            the items to be sorted. May not be <code>null</code>.
	 * @param comparator
	 *            the comparator to be used. May be <code>null</code> to indicate that the natural ordering of the
	 *            elements should be used.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see Collections#sort(List, Comparator)
	 * @see #sort(Iterable)
	 * @see #sortBy(Iterable, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 * @see ListExtensions#sortInplace(List, Comparator)
	 * @since 2.7
	 */
	public static <T> List<T> sortWith(Iterable<T> iterable, Comparator<? super T> comparator) {
		return ListExtensions.sortInplace(Lists.newArrayList(iterable), comparator);
	}

	/**
	 * Creates a sorted list that contains the items of the given iterable. The resulting list is sorted according to
	 * the order induced by applying a key function to each element which yields a comparable criteria.
	 * 
	 * @param iterable
	 *            the elements to be sorted. May not be <code>null</code>.
	 * @param key
	 *            the key function to-be-used. May not be <code>null</code>.
	 * @return a sorted list as a shallow copy of the given iterable.
	 * @see #sort(Iterable)
	 * @see #sort(Iterable, Comparator)
	 * @see ListExtensions#sortInplaceBy(List, org.eclipse.xtext.xbase.lib.Functions.Function1)
	 */
	public static <T, C extends Comparable<? super C>> List<T> sortBy(Iterable<T> iterable,
			final Functions.Function1<? super T, C> key) {
		return ListExtensions.sortInplaceBy(Lists.newArrayList(iterable), key);
	}
	


	/**
	 * Returns an Iterable containing all elements starting from the head of the source up to and excluding the first
	 * element that violates the predicate The resulting Iterable is a lazily computed view, so any modifications to the
	 * underlying Iterables will be reflected on subsequent iterations. The result's Iterator does not support
	 * {@link Iterator#remove()}
	 * 
	 * @param iterable
	 *            the elements from which to take. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate which decides whether to keep taking elements. May not be <code>null</code>.
	 * @return the taken elements
	 * @since 2.7
	 */
	public static <T> Iterable<T> takeWhile(final Iterable<? extends T> iterable, final Function1<? super T, Boolean> predicate) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (predicate == null)
			throw new NullPointerException("predicate");
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return IteratorExtensions.takeWhile(iterable.iterator(), predicate);
			}
		};
	}

	/**
	 * Returns an Iterable containing all elements starting from the first element for which the drop-predicate returned
	 * false. The resulting Iterable is a lazily computed view, so any modifications to the underlying Iterables will be
	 * reflected on subsequent iterations. The result's Iterator does not support {@link Iterator#remove()}
	 * 
	 * @param iterable
	 *            the elements from which to drop. May not be <code>null</code>.
	 * @param predicate
	 *            the predicate which decides whether to keep dropping elements. May not be <code>null</code>.
	 * @return the remaining elements after dropping
	 * @since 2.7
	 */
	public static <T> Iterable<T> dropWhile(final Iterable<? extends T> iterable, final Function1<? super T, Boolean> predicate) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (predicate == null)
			throw new NullPointerException("predicate");
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return IteratorExtensions.dropWhile(iterable.iterator(), predicate);
			}
		};
	}

	/**
	 * Returns an Iterable of Pairs where the nth pair is created by taking the nth element of the source as the value
	 * its 0-based index as the key. E.g. <code>zipWitIndex(#["a", "b", "c"]) == #[(0, "a"), (1, "b"), (2, "c")]</code>
	 * 
	 * If the index would overflow, {@link Integer#MAX_VALUE} is returned for all subsequent elements.
	 * 
	 * The resulting Iterable is a lazily computed view, so any modifications to the underlying Iterable will be
	 * reflected on iteration. The result's Iterator does not support {@link Iterator#remove()}
	 * 
	 * @param iterable
	 *            the elements. May not be <code>null</code>.
	 * @return the zipped result
	 * @since 2.7
	 */
	public static <A> Iterable<Pair<Integer, A>> indexed(final Iterable<? extends A> iterable) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		return new Iterable<Pair<Integer, A>>() {
			@Override
			public Iterator<Pair<Integer, A>> iterator() {
				return IteratorExtensions.indexed(iterable.iterator());
			}
		};
	}

	/**
	 * Finds the minimum of the given elements according to their natural ordering. If there are several mimina, the
	 * first one will be returned.
	 * 
	 * @param iterable
	 *            the mutually comparable elements. May not be <code>null</code>.
	 * @return the minimum
	 * @throws NoSuchElementException
	 *             if the iterable is empty
	 * @since 2.7
	 */
	public static <T extends Comparable<? super T>> T min(final Iterable<T> iterable) {
		if (iterable instanceof SortedSet<?>) {
			SortedSet<T> asSet = (SortedSet<T>) iterable;
			// only use the set-semantic if we can be absolutely sure that the set uses the natural order
			if (asSet.comparator() == null)
				return asSet.first();
		}
		return IteratorExtensions.min(iterable.iterator());
	}

	/**
	 * Finds the element that yields the minimum value when passed to <code>compareBy</code>. If there are several
	 * minima, the first one will be returned.
	 * 
	 * @param iterable
	 *            the elements to find the minimum of. May not be <code>null</code>.
	 * @param compareBy
	 *            a function that returns a comparable characteristic to compare the elements by. May not be <code>null</code>.
	 * @return the minimum
	 * @throws NoSuchElementException
	 *             if the iterable is empty
	 * @since 2.7
	 */
	public static <T, C extends Comparable<? super C>> T minBy(final Iterable<T> iterable,
			final Function1<? super T, C> compareBy) {
		return IteratorExtensions.minBy(iterable.iterator(), compareBy);
	}

	/**
	 * Finds the mininmum element according to <code>comparator</code>. If there are several minima, the first one will
	 * be returned.
	 * 
	 * @param iterable
	 *            the elements to find the minimum of. May not be <code>null</code>.
	 * @param comparator
	 *            the comparison function. May not be <code>null</code>.
	 * @return the minimum
	 * @throws NoSuchElementException
	 *             if the iterable is empty
	 * @since 2.7
	 */
	public static <T> T min(final Iterable<T> iterable, Comparator<? super T> comparator) {
		return IteratorExtensions.min(iterable.iterator(), comparator);
	}

	/**
	 * Finds the maximum of the elements according to their natural ordering. If there are several maxima, the first one
	 * will be returned.
	 * 
	 * @param iterable
	 *            the mutually comparable elements. May not be <code>null</code>.
	 * @return the maximum
	 * @throws NoSuchElementException
	 *             if the iterable is empty
	 * @since 2.7
	 */
	public static <T extends Comparable<? super T>> T max(final Iterable<T> iterable) {
		// cannot special-case for SortedSet since we want to find the first one that is a maximum
		// where Set.last would return the last of the seemingly equal maximum elements
		return IteratorExtensions.max(iterable.iterator());
	}

	/**
	 * Finds the element that yields the maximum value when passed to <code>compareBy</code> If there are several
	 * maxima, the first one will be returned.
	 * 
	 * @param iterable
	 *            the elements to find the maximum of. May not be <code>null</code>.
	 * @param compareBy
	 *            a function that returns a comparable characteristic to compare the elements by. May not be <code>null</code>.
	 * @return the maximum
	 * @throws NoSuchElementException
	 *             if the iterable is empty
	 * @since 2.7
	 */
	public static <T, C extends Comparable<? super C>> T maxBy(final Iterable<T> iterable,
			final Function1<? super T, C> compareBy) {
		return IteratorExtensions.maxBy(iterable.iterator(), compareBy);
	}

	/**
	 * Finds the maximum element according to <code>comparator</code>. If there are several maxima, the first one will
	 * be returned.
	 * 
	 * @param iterable
	 *            the elements to find the maximum of. May not be <code>null</code>.
	 * @param comparator
	 *            the comparison function. May not be <code>null</code>.
	 * @return the maximum
	 * @throws NoSuchElementException
	 *             if the iterable is empty
	 * @since 2.7
	 */
	public static <T> T max(final Iterable<T> iterable, Comparator<? super T> comparator) {
		return IteratorExtensions.max(iterable.iterator(), comparator);
	}
}
