/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTextSegment implements ITextSegment {

	@Override
	public int compareTo(ITextSegment o) {
		int cmp1 = getOffset() - o.getOffset();
		if (cmp1 != 0)
			return cmp1;
		int cmp2 = getLength() - o.getLength();
		if (cmp2 != 0)
			return cmp2;
		return 0;
	}

	@Override
	public boolean contains(int offset) {
		int thisOffset = this.getOffset();
		return offset >= thisOffset && offset < thisOffset + this.getLength();
	}

	@Override
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

	@Override
	public int getEndOffset() {
		return getOffset() + getLength();
	}

	@Override
	public int getLineCount() {
		return Strings.countLineBreaks(getText()) + 1;
	}

	@Override
	public List<ILineRegion> getLineRegions() {
		ILineRegion current = getTextRegionAccess().regionForLineAtOffset(getOffset());
		List<ILineRegion> result = Lists.newArrayList();
		int endOffset = getEndOffset();
		while (current != null) {
			result.add(current);
			if (current.getEndOffset() >= endOffset)
				return result;
			current = current.getNextLine();
			if (current == null || current.getOffset() >= endOffset)
				return result;
		}
		return result;
	}

	@Override
	public String getText() {
		ITextRegionAccess access = getTextRegionAccess();
		if (access != null)
			return ((AbstractRegionAccess) access).textForOffset(getOffset(), getLength());
		return null;
	}

	@Override
	public int hashCode() {
		return getOffset() + (31 * getLength());
	}

	@Override
	public boolean isMultiline() {
		return getText().contains("\n");
	}

	@Override
	public ITextSegment merge(ITextRegion other) {
		if (contains(other))
			return this;
		if (other instanceof ITextSegment && other.contains(this))
			return (ITextSegment) other;
		int offset = getOffset();
		int length = getLength();
		int newOffset = Math.min(offset, other.getOffset());
		int newLength = Math.max(offset + length, other.getOffset() + other.getLength()) - newOffset;
		return new TextSegment(getTextRegionAccess(), newOffset, newLength);
	}

	@Override
	public ITextReplacement replaceWith(String text) {
		return getTextRegionAccess().getRewriter().createReplacement(getOffset(), getLength(), text);
	}
}
