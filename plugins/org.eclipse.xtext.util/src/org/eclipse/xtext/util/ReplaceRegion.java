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
 * @author Sebastian Zarnekow
 */
public class ReplaceRegion {

	private final int offset;
	private final int length;
	private final String text;

	public ReplaceRegion(ITextRegion region, String text) {
		this(region.getOffset(), region.getLength(), text);
	}
	
	public ReplaceRegion(int offset, int length, String text) {
		this.offset = offset;
		this.length = length;
		this.text = text;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}
	
	/**
	 * @return the end offset of the replace region (exclusive).
	 */
	public int getEndOffset() {
		return offset + length;
	}

	public String getText() {
		return text;
	}
	
	public ReplaceRegion shiftBy(int offset) {
		if (offset == 0)
			return this;
		return new ReplaceRegion(this.offset + offset, length, text);
	}
	
	public void applyTo(StringBuilder builder) {
		builder.replace(offset, getEndOffset(), text);
	}
	
	@Override
	public String toString() {
		return "replace region [" + offset + " / length: " + length + "] '" + text + "'";
	}

}
