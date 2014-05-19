/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public class TextRegionWithLineInformation extends TextRegion implements ITextRegionWithLineInformation {

	private final int lineNumber;
	private final int endLineNumber;

	public TextRegionWithLineInformation(int offset, int length, int lineNumber, int endLineNumber) {
		super(offset, length);
		if (lineNumber < 0)
			throw new IllegalArgumentException("lineNumber " + lineNumber + " is < 0");
		if (endLineNumber < lineNumber)
			throw new IllegalArgumentException("endLineNumber " + endLineNumber + " is < lineNumber " + lineNumber);
		this.lineNumber = lineNumber;
		this.endLineNumber = endLineNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}
	
	public int getEndLineNumber() {
		return endLineNumber;
	}
	
	@Override
	public ITextRegion merge(ITextRegion other) {
		if (other instanceof ITextRegionWithLineInformation)
			return merge((ITextRegionWithLineInformation) other);
		return super.merge(other);
	}
	
	public ITextRegionWithLineInformation merge(ITextRegionWithLineInformation other) {
		if (contains(other))
			return this;
		if (other.contains(this))
			return other;
		int newOffset = Math.min(getOffset(), other.getOffset());
		int newLength = Math.max(getOffset() + getLength(), other.getOffset() + other.getLength()) - newOffset;
		int newLineNumber = Math.min(getLineNumber(), other.getLineNumber());
		int newEndLineNumber = Math.max(getEndLineNumber(), other.getEndLineNumber());
		return new TextRegionWithLineInformation(newOffset, newLength, newLineNumber, newEndLineNumber);
	}

	@Override
	public String toString() {
		return "TextRegionWithLineInformation " + super.toString() + "[lineNumber=" + lineNumber + ", endLineNumber=" + endLineNumber + "]";
	}
	
}
