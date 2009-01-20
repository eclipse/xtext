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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class MappingIterator<T, R> implements Iterator<R>, Iterable<R> {

	private final Iterator<? extends T> delegate;
	private final Function<T, R> mapper;

	public MappingIterator(Iterator<? extends T> delegate, Function<T,R> mapper) {
		if (delegate == null || mapper == null)
			throw new NullPointerException("neither delegate nor mapper may be null. Delegate: " + delegate + "/ Mapper: " + mapper);
		this.delegate = delegate;
		this.mapper = mapper;
	}
	
	public Iterator<R> iterator() {
		return this;
	}

	public boolean hasNext() {
		return delegate.hasNext();
	}

	public R next() {
		return mapper.exec(delegate.next());
	}

	public void remove() {
		delegate.remove();
	}

}
