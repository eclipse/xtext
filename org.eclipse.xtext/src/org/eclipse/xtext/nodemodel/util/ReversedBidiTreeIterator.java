/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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