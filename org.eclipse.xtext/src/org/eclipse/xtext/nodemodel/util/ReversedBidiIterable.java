/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;

public class ReversedBidiIterable<T> implements BidiIterable<T> {
	private final BidiIterable<T> delegate;

	public ReversedBidiIterable(BidiIterable<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public BidiIterator<T> iterator() {
		BidiIterator<T> delegate = getDelegate().iterator(); 
		return new ReversedBidiIterator<T>(delegate);
	}

	@Override
	public BidiIterable<T> reverse() {
		return delegate;
	}
	
	protected BidiIterable<T> getDelegate() {
		return delegate;
	}
}