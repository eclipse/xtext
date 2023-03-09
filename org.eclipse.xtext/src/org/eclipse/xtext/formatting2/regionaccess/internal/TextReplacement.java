/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;

import com.google.common.base.Preconditions;

public class TextReplacement extends AbstractTextSegment implements ITextReplacement {
	private final int length;
	private final int offset;
	private final String replacement;
	private final ITextRegionAccess access;

	public TextReplacement(ITextRegionAccess access, int offset, int length, String text) {
		super();
		Preconditions.checkArgument(offset >= 0, "offset must be >= 0");
		Preconditions.checkArgument(length >= 0, "length must be >= 0");
		this.access = access;
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
		return access;
	}

	@Override
	public String toString() {
		return "[" + getText() + "|" + getReplacementText() + "]";
	}

}