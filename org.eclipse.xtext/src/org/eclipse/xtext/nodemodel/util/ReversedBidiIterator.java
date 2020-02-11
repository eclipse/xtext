/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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