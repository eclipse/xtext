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
import java.util.Iterator;

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
	
	public static <T, R> Iterable<R> map(Iterator<T> input, Function<T, R> mapper) {
		return new MappingIterator<T, R>(input, mapper);
	}
	
	public static <T, R> Iterable<R> map(Iterable<T> input, Function<T, R> mapper) {
		return map(input.iterator(), mapper);
	}
	
	public static <T> Iterable<T> filter(Iterator<? extends T> input, Filter<T> filter) {
		return new FilteringIterator<T>(input, filter);
	}

	public static <T> Iterable<T> filter(Iterable<? extends T> input, Filter<T> filter) {
		return filter(input.iterator(), filter);
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
}
