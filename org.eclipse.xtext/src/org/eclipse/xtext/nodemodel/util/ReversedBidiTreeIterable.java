/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;

public class ReversedBidiTreeIterable<T> extends ReversedBidiIterable<T> implements BidiTreeIterable<T> {

	public ReversedBidiTreeIterable(BidiTreeIterable<T> delegate) {
		super(delegate);
	}

	@Override
	public BidiTreeIterator<T> iterator() {
		BidiTreeIterator<T> delegate = getDelegate().iterator(); 
		return new ReversedBidiTreeIterator<T>(delegate);
	}

	@Override
	public BidiTreeIterable<T> reverse() {
		return getDelegate();
	}
	
	@Override
	protected BidiTreeIterable<T> getDelegate() {
		return (BidiTreeIterable<T>) super.getDelegate();
	}
}