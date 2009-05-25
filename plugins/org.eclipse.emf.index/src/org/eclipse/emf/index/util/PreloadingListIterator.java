/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * An iterator that remembers already iterated values to support ListIterator operations.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 * @param <T>
 */
public class PreloadingListIterator<T> implements ListIterator<T> {

	private List<T> elementHistory = new ArrayList<T>();

	private int pointer;

	private Iterator<T> wrappedIterator;

	public PreloadingListIterator(Iterator<T> wrappedIterator) {
		pointer = 0;
		this.wrappedIterator = wrappedIterator;
	}

	public boolean hasNext() {
		if (!isPointerInHistory())
			return wrappedIterator.hasNext();
		return true;
	}

	public T next() {
		T next = null;
		if (hasNext()) {
			if (isPointerInHistory()) {
				next = elementHistory.get(pointer);
			}
			else {
				next = wrappedIterator.next();
				elementHistory.add(next);
			}
			++pointer;
		}
		return next;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void add(T o) {
		throw new UnsupportedOperationException();
	}

	public int preloadNext(int count) {
		int oldPointer = pointer;
		while(count > 0 && hasNext()) {
			next();
			--count;
		}
		int loadedElements =  pointer - oldPointer;
		pointer = oldPointer;
		return loadedElements;
	}
	
	public boolean hasPrevious() {
		return pointer != 0;
	}

	public int nextIndex() {
		return pointer;
	}

	public T previous() {
		if(hasPrevious()) {
			--pointer;
			return elementHistory.get(pointer);
		}
		return null;
	}

	public int previousIndex() {
		return pointer - 1;
	}

	public void set(T o) {
		throw new UnsupportedOperationException();
	}

	private boolean isPointerInHistory() {
		return pointer < elementHistory.size();
	}

}
