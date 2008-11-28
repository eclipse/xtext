package org.eclipse.xtext.util;

import java.util.Iterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <T>
 */
public class ChainedIterator<T> implements Iterator<T>, Iterable<T> {
	private Iterator<T> thisIterator;
	private Iterator<T> nextIterator;
	
	public ChainedIterator(Iterator<T> first, Iterator<T> next) {
		if (first==null)
			throw new NullPointerException("The first iterator may not be null");
		this.thisIterator = first;
		this.nextIterator = next;
	}

	private Iterator<T> getIter() {
		if (thisIterator.hasNext())
			return thisIterator;
		return nextIterator!=null?nextIterator:thisIterator;
	}

	public boolean hasNext() {
		return getIter().hasNext();
	}

	public T next() {
		return getIter().next();
	}

	public void remove() {
		getIter().remove();
	}

	public Iterator<T> iterator() {
		return this;
	}

}
