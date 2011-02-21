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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

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
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class IterableExtensions {

	public static <T> Iterable<T> operator_plus(Iterable<? extends T> a, Iterable<? extends T> b) {
		return Iterables.concat(a, b);
	}
	
	/**
	 * @return the first element from the iterable for which the given predicate returns <code>true</code>, returns null
	 *         if no element matches the predicate or the iterable is empty.
	 */
	public static <T> T findFirst(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		for (T t : iterable) {
			if (predicate.apply(t))
				return t;
		}
		return null;
	}
	
	public static <T> T findLast(Iterable<T> iterable, Functions.Function1<? super T, Boolean> predicate) {
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
					return result = t;
			}
			return result;
		}
	}
	
	public static <T> T head(Iterable<T> iterable) {
		Iterator<T> iterator = iterable.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}
	
	public static <T> Iterable<T> tail(final Iterable<T> iterable) {
		return drop(iterable, 1);
	}
	
	public static <T> T last(Iterable<T> iterable) {
		if (iterable instanceof List<?>) {
			List<T> list = (List<T>) iterable;
			ListIterator<T> iterator = list.listIterator(list.size());
			if(iterator.hasPrevious())
				return iterator.previous();
			return null;
		} else {
			T result = null;
			for (T t : iterable) {
				result = t;
			}
			return result;
		}
	}
	
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
							i++;
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
	
	public static <T> boolean exists(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		for (T t : iterable) {
			if (predicate.apply(t))
				return true;
		}
		return false;
	}
	
	public static <T> boolean forall(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		for (T t : iterable) {
			if (!predicate.apply(t))
				return false;
		}
		return true;
	}
	
	public static final <T> Iterable<T> filter(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		return Iterables.filter(iterable, new BooleanFunctionDelegate<T>(predicate));
	}
	
	public static final <T, R> Iterable<R> map(Iterable<T> iterable, Function1<? super T, R> transformation) {
		return Iterables.transform(iterable, new FunctionDelegate<T, R>(transformation));
	}
	
	public static final <T> Iterable<T> flatten(Iterable<? extends Iterable<? extends T>> iterables) {
		return Iterables.concat(iterables);
	}
	
	public static final <T> void forEach(Iterable<T> iterable, Function1<? super T, ?> function) {
		for(T t: iterable) {
			function.apply(t);
		}
	}
	
	public static final String elementsToString(Iterable<?> iterable, String separator) {
		return Joiner.on(separator).join(iterable);
	}
	
	public static final boolean elementsEqual(Iterable<?> iterable, Iterable<?> other) {
		return Iterables.elementsEqual(iterable, other);
	}
	
	public static final boolean isNullOrEmpty(Iterable<?> iterable) {
		return iterable == null || isEmpty(iterable);
	}
	
	public static final boolean isEmpty(Iterable<?> iterable) {
		if (iterable instanceof Collection<?>)
			return ((Collection<?>) iterable).isEmpty();
		return !iterable.iterator().hasNext();
	}
	
	public static final int size(Iterable<?> iterable) {
		return Iterables.size(iterable);
	}
	
	public static <T> T reduce(Iterable<T> iterable, Function2<? super T, ? super T, ? extends T> function) {
		Iterator<T> iterator = iterable.iterator();
		if (iterator.hasNext()) {
			T result = iterator.next();
			while(iterator.hasNext()) {
				result = function.apply(iterator.next(), result);
			}
			return result;
		} else {
			return null;
		}
	}
	
	public static <T, R> R fold(Iterable<T> iterable, R seed, Function2<? super T, ? super R, ? extends R> function) {
		R result = seed;
		Iterator<T> iterator = iterable.iterator();
		while(iterator.hasNext()) {
			result = function.apply(iterator.next(), result);
		}
		return result;
	}
	
	public static <T> List<T> toList(Iterable<T> iterable) {
		if (iterable instanceof List<?>) {
			List<T> result = (List<T>) iterable;
			return result;
		}
		return Lists.newArrayList(iterable);
	}
	
	public static <T> Set<T> toSet(Iterable<T> iterable) {
		if (iterable instanceof Set<?>) {
			Set<T> result = (Set<T>) iterable;
			return result;
		}
		return Sets.newHashSet(iterable);
	}
	
	public static <K, V> Map<K, V> toInvertedMap(Iterable<K> iterable, Function1<? super K, V> computeValues) {
		Map<K, V> result = Maps.newHashMap();
		for(K k: iterable) {
			result.put(k, computeValues.apply(k));
		}
		return result;
	}
	
	public static <K, V> Map<K, V> toMap(Iterable<V> iterable, Function1<? super V, K> computeKeys) {
		Map<K, V> result = Maps.newHashMap();
		for(V v: iterable) {
			result.put(computeKeys.apply(v), v);
		}
		return result;
	}
	
	protected static class BooleanFunctionDelegate<T> implements Predicate<T> {

		private final Function1<? super T, Boolean> delegate;

		protected BooleanFunctionDelegate(Function1<? super T, Boolean> delegate) {
			this.delegate = delegate;
		}
		
		public boolean apply(T input) {
			Boolean result = delegate.apply(input);
			return result.booleanValue();
		}
		
	}
	
	protected static class FunctionDelegate<P, R> implements Function<P, R> {

		private final Function1<? super P, R> delegate;

		protected FunctionDelegate(Function1<? super P, R> delegate) {
			this.delegate = delegate;
		}
		
		public R apply(P input) {
			R result = delegate.apply(input);
			return result;
		}
		
	}
	
}
