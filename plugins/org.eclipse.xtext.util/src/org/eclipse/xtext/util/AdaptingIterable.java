/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Iterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class AdaptingIterable<T,U> implements Iterable<T>, Iterator<T>{
	
	public static <T,U> AdaptingIterable<T, U> create(Iterable<U> iter, Function<U,T> func) {
		return new AdaptingIterable<T, U>(iter.iterator(), func);
	}
	
	public static <T,U> AdaptingIterable<T, U> create(Iterator<U> iter, Function<U,T> func) {
		return new AdaptingIterable<T, U>(iter, func);
	}
	
	private Iterator<U> delegate;
	private Function<U, T> func;

	protected AdaptingIterable(Iterator<U> delegate, Function<U, T> func) {
		super();
		this.delegate = delegate;
		this.func = func;
	}

	public boolean hasNext() {
		return delegate.hasNext();
	}

	public T next() {
		return func.exec(delegate.next());
	}

	public void remove() {
		delegate.remove();
	}

	public Iterator<T> iterator() {
		return this;
	}

}
