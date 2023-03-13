/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.richstring;

/**
 * Implementation {@link CharSequence} that is tailored to line-per-line processing of text
 * and supports special handling of whitespace.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TextLine implements CharSequence {

	protected static class LeadingWSTextLinePart extends TextLine {

		public LeadingWSTextLinePart(String completeText, int offset, int length) {
			super(completeText, offset, length, 0);
		}
		
		@Override
		public CharSequence getLeadingWhiteSpace() {
			return this;
		}
		
		@Override
		public boolean hasLeadingWhiteSpace() {
			return length() > 0;
		}
		
		@Override
		public boolean containsOnlyWhitespace() {
			return true;
		}
	}
	
	private final String completeText;
	private final int offset;
	private final int length;
	private final int delimiterLength;

	public TextLine(String completeText, int offset, int length, int delimiterLength) {
		this.completeText = completeText;
		this.offset = offset;
		this.length = length;
		this.delimiterLength = delimiterLength;
	}

	public String getCompleteText() {
		return completeText;
	}
	
	public boolean hasLeadingWhiteSpace() {
		if (length == 0)
			return false;
		boolean result = Character.isWhitespace(charAt(0));
		return result;
	}
	
	public boolean containsOnlyWhitespace() {
		for(int i=0; i < length(); i++) {
			if (!Character.isWhitespace(charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public CharSequence getLeadingWhiteSpace() {
		for(int i=0; i < length(); i++) {
			if (!Character.isWhitespace(charAt(i))) {
				if (i == 0)
					return "";
				return new LeadingWSTextLinePart(completeText, offset, i); 
			}
		}
		return new LeadingWSTextLinePart(completeText, offset, length);
	}
	
	public boolean hasTrailingLineBreak() {
		return delimiterLength > 0;
	}
	
	public int getRelativeOffset() {
		return offset;
	}
	
	@Override
	public int length() {
		return length;
	}

	@Override
	public char charAt(int index) {
		return completeText.charAt(index + offset);
	}
	
	public int getDelimiterLength() {
		return delimiterLength;
	}
	
	@Override
	public String toString() {
		return completeText.substring(offset, offset + length);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + toString().hashCode();
		result = prime * result + delimiterLength;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextLine other = (TextLine) obj;
		if (length != other.length)
			return false;
		if (delimiterLength != other.delimiterLength)
			return false;
		if (!completeText.regionMatches(offset, other.completeText, other.offset, length))
			return false;
		return true;
	}

	/**
     * @throws  IndexOutOfBoundsException
     *          if <tt>start</tt> or <tt>end</tt> are negative,
     *          if <tt>end</tt> is greater than <tt>length()</tt>,
     *          or if <tt>start</tt> is greater than <tt>end</tt>
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0 || start > end) {
			throwIndexOutOfBounds(start);
		}
		if (end < 0 || end > length) {
			throwIndexOutOfBounds(end);
		}
		if (start > end) {
			throwIndexOutOfBounds(end - start);
		}
		return completeText.subSequence(start + offset, end + offset);
	}

	protected void throwIndexOutOfBounds(int offset) {
		throw new IndexOutOfBoundsException(("Index out of range: " + offset));
	}

}