/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;


public class TextRegion implements ITextRegion {
	private final int offset;

	private final int length;

	public TextRegion(int offset, int length) {
		if (offset < 0)
			throw new IllegalArgumentException("offset " + offset + " is < 0");
		if (length < 0)
			throw new IllegalArgumentException("length " + length + " is < 0");
		this.offset = offset;
		this.length = length;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public ITextRegion merge(ITextRegion other) {
		if (contains(other))
			return this;
		if (other.contains(this))
			return other;
		int newOffset = Math.min(offset, other.getOffset());
		int newLength = Math.max(offset + length, other.getOffset() + other.getLength()) - newOffset;
		return new TextRegion(newOffset, newLength);
	}
	
	public boolean contains(ITextRegion other) {
		return other == EMPTY_REGION || (other.getOffset() + other.getLength() <= offset + length && other.getOffset() >= offset); 
	}

	public boolean contains(int offset) {
		return offset >= this.offset && offset < this.offset + length;
	}
	
	@Override
	public boolean equals(/* @Nullable */ Object obj) {
		return obj instanceof ITextRegion && ((ITextRegion)obj).getOffset() == offset && ((ITextRegion)obj).getLength() ==length;
	}
	
	@Override
	public int hashCode() {
		return offset - 37 * length;
	}
	
	@Override
	public String toString() {
		return "[" + offset + ":" + length + "]";
	}
}