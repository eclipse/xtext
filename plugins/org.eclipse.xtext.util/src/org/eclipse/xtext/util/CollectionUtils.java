/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Various utilities for iterables and iterators.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CollectionUtils {

	/**
	 * Merge two iterators into one iterable. The iterators are lazy evaluated.
	 * @param <T>
	 * @param first the first iterator. May not be <code>null</code>.
	 * @param second the second iterator. May be <code>null</code>
	 * @return an iterable, that provides an iterator with the values of both given iterators.
	 */
	public static <T> Iterable<T> join(Iterator<? extends T> first, Iterator<? extends T> second) {
		return new ChainedIterator<T>(first, second);
	}

	/**
	 * Merge two iterables into one. The iterables are lazy iterated.
	 * @param <T>
	 * @param first the first iterable. May not be <code>null</code>.
	 * @param second the second iterable. May not be <code>null</code>
	 * @return an iterable, that provides an iterator with the values of both given iterables.
	 */
	public static <T> Iterable<T> join(Iterable<? extends T> first, Iterable<? extends T> second) {
		return join(first.iterator(), second.iterator());
	}

	public static <T> Iterable<T> flatten(Iterable<? extends Iterable<T>> nested) {
		return flatten(nested.iterator());
	}

	public static <T> Iterable<T> flatten(Iterator<? extends Iterable<T>> nested) {
		final Collection<T> result = new ArrayList<T>();
		while(nested.hasNext())
			addAll(result, nested.next());
		return result;
	}

	public static <T> void switchContent(Iterator<T> candidates, Collection<T> matches, Collection<T> refuses, Filter<T> filter) {
		if (matches == refuses) {
			if (matches == null)
				return;
			addAll(matches, candidates);
			return;
		}
		while(candidates.hasNext()) {
			T t = candidates.next();
			if (filter.matches(t)) {
				if (matches != null) matches.add(t);
			} else {
				if (refuses != null) refuses.add(t);
			}
		}
	}

	public static <T> void switchContent(Iterable<T> candidates, Collection<T> matches, Collection<T> refuses, Filter<T> filter) {
		switchContent(candidates.iterator(), matches, refuses, filter);
	}

	public static <T, R> Iterable<R> map(Iterator<? extends T> input, Function<T, R> mapper) {
		return new MappingIterator<T, R>(input, mapper);
	}

	public static <T, R> Iterable<R> map(Iterable<? extends T> input, Function<T, R> mapper) {
		return map(input.iterator(), mapper);
	}

	public static <T> Iterable<T> filter(Iterator<? extends T> input, Filter<T> filter) {
		return new FilteringIterator<T>(input, filter);
	}

	public static <T> Iterable<T> filter(Iterable<? extends T> input, Filter<T> filter) {
		return filter(input.iterator(), filter);
	}

	public static <T, R extends T> Iterable<R> typeFilter(Iterator<T> input, final Class<R> type) {
		return map(filter(input, Filter.Util.<T>instanceOf(type)), new Function<T, R>() {
			public R exec(T param) {
				return type.cast(param);
			}
		});
	}

	public static <T, R extends T> Iterable<R> typeFilter(Iterable<T> input, final Class<R> type) {
		return typeFilter(input, type);
	}

	public static <T> Iterable<T> each(Iterator<? extends T> input, final Function.WithoutResult<T> fun) {
		return map(input, new Function<T, T>() {
			public T exec(T param) {
				fun.exec(param);
				return param;
			}
		});
	}

	public static <T> Iterable<T> each(Iterable<? extends T> input, Function.WithoutResult<T> fun) {
		return each(input.iterator(), fun);
	}

	public static <T> boolean addAll(Collection<T> target, Iterator<T> source) {
		boolean result = false;
		while(source.hasNext()) {
			result |= target.add(source.next());
		}
		return result;
	}

	public static <T> boolean addAll(Collection<T> target, Iterable<T> source) {
		return addAll(target, source.iterator());
	}

	public static <T, R> Iterable<T> unique(Iterator<? extends T> input, final Function<T, R> mapper) {
		return filter(input, new Filter<T>() {
			private final Set<R> values = new HashSet<R>();
			public boolean matches(T param) {
				return values.add(mapper.exec(param));
			}
		});
	}

	public static <T, R> Iterable<T> unique(Iterable<? extends T> input, Function<T, R> mapper) {
		return unique(input.iterator(), mapper);
	}

	public static <T> Iterable<T> unique(Iterator<? extends T> input) {
		return unique(input, new Function<T, T>() {
			public T exec(T param) {
				return param;
			}
		});
	}

	public static <T> Iterable<T> unique(Iterable<? extends T> input) {
		return unique(input.iterator());
	}

	public static <T> void clear(Iterator<T> iterator) {
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}

	public static <T> void clear(Iterable<T> iterable) {
		clear(iterable.iterator());
	}

	public static void loop(Iterator<?> iterator) {
		while(iterator.hasNext())
			iterator.next();
	}

	public static void loop(Iterable<?> iterable) {
		loop(iterable.iterator());
	}

	public static <T> T next(Iterator<T> iterator) {
		if (iterator.hasNext())
			return iterator.next();
		throw new NoSuchElementException();
	}

	public static <T> T next(Iterable<T> iterable) {
		return next(iterable.iterator());
	}

	public static <T> T nextOrNull(Iterator<T> iterator) {
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public static <T> T nextOrNull(Iterable<T> iterable) {
		return nextOrNull(iterable.iterator());
	}

	public static <T> Iterable<Integer> indexes(Iterator<? extends T> input, final Filter<T> filter) {
		return map(filter(map(input, new Function<T, Pair<T, Integer>>() {
			private int index = 0;
			public Pair<T, Integer> exec(T param) {
				return Tuples.create(param, index++);
			}
		}), new Filter<Pair<T, Integer>>() {
			public boolean matches(Pair<T, Integer> param) {
				return filter.matches(param.getFirst());
			}
		}), new Function<Pair<T, Integer>, Integer>() {
			public Integer exec(Pair<T, Integer> param) {
				return param.getSecond();
			}
		});
	}

	public static <T> Iterable<Integer> indexes(Iterable<? extends T> input, Filter<T> filter) {
		return indexes(input.iterator(), filter);
	}

	public static <T> List<T> list(Iterator<T> iterator) {
		final List<T> result = new ArrayList<T>();
		addAll(result, iterator);
		return result;
	}

	public static <T> List<T> list(Iterable<T> iterable) {
		return list(iterable.iterator());
	}

	public static <T> boolean addAllIfNotNull(Collection<T> target, Collection<? extends T> toBeAdded) {
		if(toBeAdded != null && !toBeAdded.isEmpty()) {
			return target.addAll(toBeAdded);
		}
		return false;
	}

	public static <T> boolean addIfNotNull(Collection<T> target, T toBeAdded) {
		if(toBeAdded != null) {
			return target.add(toBeAdded);
		}
		return false;
	}

	public static <T> int count(Iterable<T> iterable, Filter<T> selector) {
		return count(iterable.iterator(), selector);
	}

	public static <T> int count(Iterator<T> iterator, Filter<T> selector) {
		final Wrapper<Integer> result = Wrapper.wrap(0);
		loop(each(filter(iterator, selector), new Function.WithoutResult<T>(){
			public void exec(T param) {
				result.set(result.get() + 1);
			}
		}));
		return result.get();
	}
}
