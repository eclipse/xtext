/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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