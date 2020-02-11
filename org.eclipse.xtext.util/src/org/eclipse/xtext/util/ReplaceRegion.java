/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		ReplaceRegion other = (ReplaceRegion) object;
		if (this.offset != other.offset) {
			return false;
		}
		if (this.length != other.length) {
			return false;
		}
		if (this.text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!this.text.equals(other.text)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offset;
		result = prime * result + length;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "replace region [" + offset + " / length: " + length + "] '" + text + "'";
	}

}
