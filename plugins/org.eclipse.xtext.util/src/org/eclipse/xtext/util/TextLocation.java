/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TextLocation {

	private int offset;

	private int length;

	private boolean isEmpty;
	
	public TextLocation() {
		isEmpty = true;
	}

	public TextLocation(int offset, int length) {
		this.offset = offset;
		this.length = length;
		isEmpty = false;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
		isEmpty = false;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
		isEmpty = false;
	}

	public void merge(int newOffset, int newLength) {
		if (isEmpty) {
			offset = newOffset;
			length = newLength;
			isEmpty = false;
			return;
		}
		int end = offset + length;
		int newEnd = newOffset + newLength;
		offset = Math.min(offset, newOffset);
		length = Math.max(end, newEnd) - offset;
	}
	
	public boolean contains(TextLocation other) {
		return !isEmpty && other.length <= length - (other.offset - offset) && other.offset >= offset; 
	}
	
	public boolean contains(int offset) {
		return offset >= this.offset && offset < this.offset + length;
	}

}
