/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl;

import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTextSegment implements ITextSegment {

	public int compareTo(ITextSegment o) {
		int cmp1 = getOffset() - o.getOffset();
		if (cmp1 != 0)
			return cmp1;
		int cmp2 = getLength() - o.getLength();
		if (cmp2 != 0)
			return cmp2;
		return 0;
	}

	public boolean contains(int offset) {
		int thisOffset = this.getOffset();
		return offset >= thisOffset && offset < thisOffset + this.getLength();
	}

	public boolean contains(ITextRegion other) {
		int offset = getOffset();
		int length = getLength();
		return (other.getOffset() + other.getLength() <= offset + length && other.getOffset() >= offset);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		AbstractTextSegment other = (AbstractTextSegment) obj;
		return getOffset() == other.getOffset() && getLength() == other.getLength();
	}

	public int getEndOffset() {
		return getOffset() + getLength();
	}

	public int getLineCount() {
		return Strings.countLines(getText());
	}

	public String getText() {
		ITextRegionAccess tokenAccess = getTextRegionAccess();
		if (tokenAccess != null)
			return tokenAccess.getText(getOffset(), getLength());
		return null;
	}

	@Override
	public int hashCode() {
		return getOffset() + (31 * getLength());
	}

	public boolean isMultiline() {
		return getText().contains("\n");
	}

	public ITextRegion merge(ITextRegion other) {
		if (contains(other))
			return this;
		if (other.contains(this))
			return other;
		int offset = getOffset();
		int length = getLength();
		int newOffset = Math.min(offset, other.getOffset());
		int newLength = Math.max(offset + length, other.getOffset() + other.getLength()) - newOffset;
		return new TextRegion(newOffset, newLength);
	}
}
