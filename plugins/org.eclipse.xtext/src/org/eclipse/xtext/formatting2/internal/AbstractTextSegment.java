/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.ImmutableList;
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
	public ITextSegment getIndentation() {
		return getTextRegionAccess().indentationRegion(getOffset());
	}

	@Override
	public int getLineCount() {
		return Strings.countLines(getText());
	}

	@Override
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

	@Override
	public boolean isMultiline() {
		return getText().contains("\n");
	}

	@Override
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

	@Override
	public List<ITextSegment> splitIntoLines() {
		ITextRegionAccess access = getTextRegionAccess();
		List<ITextSegment> result = Lists.newArrayList();
		String text = getText();
		int index, lastIndex = 0, offset = getOffset();
		while ((index = text.indexOf('\n', lastIndex)) >= 0) {
			int end = index > 0 && text.charAt(index - 1) == '\r' ? index - 1 : index;
			result.add(new TextSegment(access, offset + lastIndex, end - lastIndex));
			lastIndex = index + 1;
		}
		result.add(new TextSegment(access, offset + lastIndex, text.length() - lastIndex));
		return ImmutableList.copyOf(result);
	}
}
