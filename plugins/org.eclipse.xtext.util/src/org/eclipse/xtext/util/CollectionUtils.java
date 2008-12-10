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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CollectionUtils {

	public static <T> Iterable<T> flatten(Iterable<? extends Iterable<T>> nested) {
		final Collection<T> result = new ArrayList<T>();
		final Iterator<? extends Iterable<T>> iter = nested.iterator();
		while(iter.hasNext())
			addAll(result, iter.next());
		return result;
	}
	
	public static <T> void switchContent(Iterable<T> candidates, Collection<T> matches, Collection<T> refuses, Filter<T> filter) {
		if (matches == refuses) {
			if (matches == null)
				return;
			addAll(matches, candidates);
			return;
		}
		final Iterator<T> iter = candidates.iterator();
		while(iter.hasNext()) {
			T t = iter.next();
			if (filter.matches(t)) {
				if (matches != null) matches.add(t);
			} else {
				if (refuses != null) refuses.add(t);
			}
		}
	}
	
	public static <T, R> Iterable<R> map(Iterable<T> input, Function<T, R> mapper) {
		return map(input.iterator(), mapper);
	}
	
	public static <T, R> Iterable<R> map(Iterator<T> input, Function<T, R> mapper) {
		return new MappingIterator<T, R>(input, mapper);
	}
	
	public static <T> Iterable<T> filter(Iterable<T> input, Filter<T> filter) {
		return filter(input.iterator(), filter);
	}
	
	public static <T> Iterable<T> filter(Iterator<T> input, Filter<T> filter) {
		return new FilteringIterator<T>(input, filter);
	}
	
	public static <T> boolean addAll(Collection<T> target, Iterable<T> source) {
		final Iterator<T> iter = source.iterator();
		boolean result = false;
		while(iter.hasNext()) {
			result |= target.add(iter.next());
		}
		return result;
	}
}
