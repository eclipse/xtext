/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class FilteringIterator<T> implements Iterator<T>, Iterable<T> {

	private final Filter<T> matcher;

	private final Iterator<? extends T> base;

	private T next;
	
	public FilteringIterator(final Iterable<? extends T> origin, final Filter<T> matcher) {
		this(origin.iterator(), matcher);
	}

	public FilteringIterator(final Iterator<? extends T> iterator, final Filter<T> matcher) {
		this.base = iterator;
		this.matcher = matcher;
	}

	public boolean hasNext() {
		while (next == null && base.hasNext()) {
			final T nextCandidate = base.next();
			if (matcher.matches(nextCandidate))
				next = nextCandidate;
		}
		return next != null;
	}

	public T next() {
		if (!hasNext())
			throw new NoSuchElementException("call hasNext first");
		final T res = next;
		next = null;
		return res;
	}

	public void remove() {
		throw new UnsupportedOperationException("remove is not supported by this implementation");
	}

	public Iterator<T> iterator() {
		return this;
	}
}
