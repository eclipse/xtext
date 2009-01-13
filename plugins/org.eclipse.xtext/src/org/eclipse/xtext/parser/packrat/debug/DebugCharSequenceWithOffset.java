/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugCharSequenceWithOffset implements ICharSequenceWithOffset {
	
	private final ICharSequenceWithOffset delegate;
	
	public DebugCharSequenceWithOffset(ICharSequenceWithOffset delegate) {
		this.delegate = delegate;
	}

	public char charAt(int index) {
		return delegate.charAt(index);
	}

	public int getOffset() {
		return delegate.getOffset();
	}

	public void incOffset() {
		delegate.incOffset();
	}

	public void incOffset(int amount) {
		delegate.incOffset(amount);
	}

	public int length() {
		return delegate.length();
	}

	public void setOffset(int offset) {
		delegate.setOffset(offset);
	}

	public CharSequence subSequence(int start, int end) {
		return delegate.subSequence(start, end);
	}

	public String toString() {
		return delegate.toString();
	}

	
}
