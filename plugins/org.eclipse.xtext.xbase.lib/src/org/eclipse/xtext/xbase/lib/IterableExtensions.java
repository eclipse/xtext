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
 * 
 * To be discussed:
 * #foldLeft / #foldRight vs #fold
 * #reduceLeft / #reduceRight vs #reduce
 * #min / #max as convenience variant for #reduce((T,T)=>Boolean)
 */
public class IterableExtensions {

	public static <T> Iterable<T> _operator_plus(Iterable<? extends T> a, Iterable<? extends T> b) {
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
	
	public static <T> T first(Iterable<T> iterable) {
		Iterator<T> iterator = iterable.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
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
	
	/**
	 * Returns an iterable with the first <code>count</code> entries of the given iterable.
	 * If <code>count</code> is negative, the last <code>count</code> entries will be skipped.
	 * E.g. a head that is obtained for an <code>iterable</code> with 10 entries by means of
	 * <code>head(iterable, -3)</code> with yield a view on the first 7 entries of the original
	 * iterable.
	 * @param iterable the original iterable. May not be <code>null</code>.
	 */
	public static <T> Iterable<T> head(final Iterable<T> iterable, final int count) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (count == 0)
			return Collections.emptyList();
		if (count > 0) {
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
		// count < 0
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new AbstractIterator<T>() {

					private Object[] buffer = new Object[-count];
					
					private int bufferIdx = 0;
					
					private Iterator<T> delegate = iterable.iterator();
					
					{
						int i = 0;
						while(i < buffer.length && delegate.hasNext()) {
							T t = delegate.next();
							buffer[i] = t;
							i++;
						}
					}
					
					@Override
					protected T computeNext() {
						if (!delegate.hasNext())
							return endOfData();
						T newBufferEntry = delegate.next();
						@SuppressWarnings("unchecked")
						T result = (T) buffer[bufferIdx];
						buffer[bufferIdx] = newBufferEntry;
						bufferIdx++;
						if (bufferIdx >= buffer.length)
							bufferIdx = 0;
						return result;
					}
				};
			}
		};
	}
	
	public static <T> Iterable<T> tail(final Iterable<T> iterable, final int count) {
		if (iterable == null)
			throw new NullPointerException("iterable");
		if (count == 0)
			return Collections.emptyList();
		if (count > 0) {
			return new Iterable<T>() {
				public Iterator<T> iterator() {
					return new AbstractIterator<T>() {

						private Object[] buffer = new Object[count];
						
						private int bufferIdx = 0;
						
						private int remaining = 0;
						
						private Iterator<T> delegate = iterable.iterator();
						
						{
							while(delegate.hasNext()) {
								T t = delegate.next();
								buffer[bufferIdx] = t;
								bufferIdx++;
								if (bufferIdx >= buffer.length)
									bufferIdx = 0;
								if (remaining < count)
									remaining++;
							}
						}
						
						@Override
						protected T computeNext() {
							if (remaining <= 0)
								return endOfData();
							@SuppressWarnings("unchecked")
							T result = (T) buffer[bufferIdx];
							bufferIdx++;
							if (bufferIdx >= buffer.length)
								bufferIdx = 0;
							remaining--;
							return result;
						}
					};
				}
			};
		}
		// count < 0
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new AbstractIterator<T>() {

					private Iterator<T> delegate = iterable.iterator();
					
					{
						int i = 0;
						while(i < -count && delegate.hasNext()) {
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
	
	public static <T> boolean contains(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		for (T t : iterable) {
			if (predicate.apply(t))
				return true;
		}
		return false;
	}
	
	public static <T> boolean containsOnly(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		for (T t : iterable) {
			if (!predicate.apply(t))
				return false;
		}
		return true;
	}
	
	public static final <T> Iterable<T> filter(Iterable<T> iterable, Function1<? super T, Boolean> predicate) {
		return Iterables.filter(iterable, new BooleanFunctionDelegate<T>(predicate));
	}
	
	public static final <T, R> Iterable<R> select(Iterable<T> iterable, Function1<? super T, R> transformation) {
		return Iterables.transform(iterable, new FunctionDelegate<T, R>(transformation));
	}
	
	public static final <T> Iterable<T> flatten(Iterable<? extends Iterable<? extends T>> iterables) {
		return Iterables.concat(iterables);
	}
	
	public static final <T> void each(Iterable<T> iterable, Function1<? super T, ?> function) {
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
	
	public static <K, V> Map<K, V> toKeys(Iterable<K> iterable, Function1<? super K, V> computeValues) {
		Map<K, V> result = Maps.newHashMap();
		for(K k: iterable) {
			result.put(k, computeValues.apply(k));
		}
		return result;
	}
	
	public static <K, V> Map<K, V> toValues(Iterable<V> iterable, Function1<? super V, K> computeKeys) {
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
