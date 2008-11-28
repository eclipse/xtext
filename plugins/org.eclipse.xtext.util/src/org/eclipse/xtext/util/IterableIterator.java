package org.eclipse.xtext.util;

import java.util.Iterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <T>
 */
public class IterableIterator<T> implements Iterable<T>,Iterator<T>{
	
	private Iterator<T> delegate;
	
	public IterableIterator(Iterator<T> delegate) {
		this.delegate = delegate;
	}

	public Iterator<T> iterator() {
		return this;
	}

	public boolean hasNext() {
		return delegate.hasNext();
	}

	public T next() {
		return delegate.next();
	}

	public void remove() {
		delegate.remove();
	}
	
}
