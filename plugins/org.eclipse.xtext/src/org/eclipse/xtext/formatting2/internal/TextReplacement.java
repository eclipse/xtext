/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

public class TextReplacement extends AbstractTextSegment implements ITextReplacement {
	private final int length;
	private final int offset;
	private final String replacement;
	private final ITextRegionAccess tokens;

	public TextReplacement(ITextRegionAccess tokens, int offset, int length, String text) {
		super();
		this.tokens = tokens;
		this.offset = offset;
		this.length = length;
		this.replacement = text;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public String getReplacementText() {
		return replacement;
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return tokens;
	}

	@Override
	public String toString() {
		return "[" + getText() + "|" + getReplacementText() + "]";
	}

}