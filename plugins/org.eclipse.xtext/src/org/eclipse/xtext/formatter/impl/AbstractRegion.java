/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import org.eclipse.xtext.formatter.ITextRegion;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractRegion implements ITextRegion {

	public int compareTo(ITextRegion o) {
		int cmp1 = getOffset() - o.getOffset();
		if (cmp1 != 0)
			return cmp1;
		int cmp2 = getLength() - o.getLength();
		if (cmp2 != 0)
			return cmp2;
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		AbstractRegion other = (AbstractRegion) obj;
		return getOffset() == other.getOffset() && getLength() == other.getLength();
	}

	public int getEndOffset() {
		return getOffset() + getLength();
	}

	public int getLineCount() {
		return Strings.countLines(getText());
	}

	@Override
	public int hashCode() {
		return getOffset() + (31 * getLength());
	}

	public boolean isMultiline() {
		return getText().contains("\n");
	}

	public String getText() {
		return getTokenAccess().getText(getOffset(), getLength());
	}
}
