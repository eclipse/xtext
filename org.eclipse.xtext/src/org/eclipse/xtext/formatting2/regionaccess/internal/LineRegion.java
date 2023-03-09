/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LineRegion extends TextSegment implements ILineRegion {

	public LineRegion(ITextRegionAccess regionAccess, int offset, int length) {
		super(regionAccess, offset, length);
	}

	@Override
	public ITextSegment getIndentation() {
		String text = getText();
		for (int i = 0; i < text.length(); i++)
			if (!Character.isWhitespace(text.charAt(i)))
				return new TextSegment(this.getTextRegionAccess(), getOffset(), i);
		return new TextSegment(this.getTextRegionAccess(), getOffset(), 0);
	}

	@Override
	public ILineRegion getNextLine() {
		ITextRegionAccess access = getTextRegionAccess();
		int start = getEndOffset() + 1;
		String text = access.regionForDocument().getText();
		while (true) {
			if (start > text.length())
				return null;
			if (start == text.length())
				return new LineRegion(access, start, 0);
			char c = text.charAt(start);
			if (c == '\n' || c == '\r')
				start++;
			else
				break;
		}
		int end = text.indexOf('\n', start);
		if (end > 0) {
			if (text.charAt(end - 1) == '\r')
				end = end - 1;
		} else
			end = text.length();
		return new LineRegion(access, start, end - start);
	}

	@Override
	public ILineRegion getPreviousLine() {
		ITextRegionAccess access = getTextRegionAccess();
		int end = getOffset() - 1;
		String text = access.regionForDocument().getText();
		while (true) {
			if (end < 0)
				return null;
			char c = text.charAt(end);
			if (c == '\n' || c == '\r')
				end--;
			else
				break;
		}
		int start = text.lastIndexOf('\n', end);
		if (start < 0)
			start = 0;
		return new LineRegion(access, start, end - start);
	}
}
