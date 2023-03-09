/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link ITextReplacement}
 */
@Deprecated
public class TextReplacement {
	private final int offset;

	private final int length;

	private final String text;

	public TextReplacement(int offset, int length, String text) {
		this.offset = offset;
		this.length = length;
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + offset;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		TextReplacement other = (TextReplacement) obj;
		if (length != other.length)
			return false;
		if (offset != other.offset)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("offset", offset);
		b.add("length", length);
		b.add("text", text);
		return b.toString();
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	public String getText() {
		return text;
	}
}
