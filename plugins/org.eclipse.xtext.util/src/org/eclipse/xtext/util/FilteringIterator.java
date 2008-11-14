package org.eclipse.xtext.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class FilteringIterator<T> implements Iterator<T>, Iterable<T> {

	private final Filter<T> matcher;

	private final Iterator<T> base;

	private T next;

	public FilteringIterator(final Iterable<T> origin, final Filter<T> matcher) {
		this(origin.iterator(), matcher);
	}

	public FilteringIterator(final Iterator<T> iterator, final Filter<T> matcher) {
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
