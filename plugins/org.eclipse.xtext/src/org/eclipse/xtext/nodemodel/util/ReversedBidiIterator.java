/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiIterator;

public class ReversedBidiIterator<T> implements BidiIterator<T> {
	private final BidiIterator<T> delegate;

	public ReversedBidiIterator(BidiIterator<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public boolean hasNext() {
		return delegate.hasPrevious();
	}

	@Override
	public T next() {
		return delegate.previous();
	}

	@Override
	public void remove() {
		delegate.remove();
	}

	@Override
	public boolean hasPrevious() {
		return delegate.hasNext();
	}

	@Override
	public T previous() {
		return delegate.next();
	}
	
	protected BidiIterator<T> getDelegate() {
		return delegate;
	}
}