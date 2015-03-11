/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiTreeIterator;

public class ReversedBidiTreeIterator<T> extends ReversedBidiIterator<T> implements BidiTreeIterator<T> {

	public ReversedBidiTreeIterator(BidiTreeIterator<T> delegate) {
		super(delegate);
	}

	@Override
	public void prune() {
		getDelegate().prune();
	}
	
	@Override
	protected BidiTreeIterator<T> getDelegate() {
		return (BidiTreeIterator<T>) super.getDelegate();
	}
}