/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Iterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 * @param <T>
 */
public final class ChainedIterator<T> implements Iterator<T>, Iterable<T> {
	private Iterator<? extends T> thisIterator;
	private Iterator<? extends T> nextIterator;
	
	public ChainedIterator(Iterator<? extends T> first, Iterator<? extends T> second) {
		if (first==null)
			throw new NullPointerException("The first iterator may not be null");
		this.thisIterator = first;
		this.nextIterator = second;
	}

	private Iterator<? extends T> getIter() {
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
