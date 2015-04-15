/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		return getTextRegionAccess().lineForOffset(getEndOffset() + 1);
	}

	@Override
	public ILineRegion getPreviousLine() {
		return getTextRegionAccess().lineForOffset(getOffset() -1 );
	}
}
