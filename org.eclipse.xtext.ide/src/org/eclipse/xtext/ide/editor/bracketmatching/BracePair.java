/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * Defines a single pair of braces which need to be matched when editing code.
 * 
 * @author kosyakov - Initial contribution and API
 */
public class BracePair {
	/**
	 * The length of a left brace should be one character for Eclipse.
	 */
	private final String leftBrace;

	/**
	 * The length of a right brace should be one character for Eclipse.
	 */
	private final String rightBrace;

	/**
	 * True if the brace is structural. Structural braces have higher priority than regular braces: they are matched
	 * with each other even if there are unmatched braces of other types between them. An opening non-structural
	 * brace is not matched with a closing one if one of them is outside a pair of matched structural braces and another
	 * is inside. In Java code, the curly braces are structural.
	 * 
	 * It is ignored by Eclipse.
	 */
	private final boolean structural;

	public BracePair(String leftBrace, String rightBrace, boolean structural) {
		Preconditions.checkArgument(leftBrace.length() == 1);
		Preconditions.checkArgument(rightBrace.length() == 1);
		this.leftBrace = leftBrace;
		this.rightBrace = rightBrace;
		this.structural = structural;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (leftBrace == null ? 0 : leftBrace.hashCode());
		result = prime * result + (rightBrace == null ? 0 : rightBrace.hashCode());
		result = prime * result + (structural ? 1231 : 1237);
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
		BracePair other = (BracePair) obj;
		if (leftBrace == null) {
			if (other.leftBrace != null)
				return false;
		} else if (!leftBrace.equals(other.leftBrace))
			return false;
		if (rightBrace == null) {
			if (other.rightBrace != null)
				return false;
		} else if (!rightBrace.equals(other.rightBrace))
			return false;
		if (structural != other.structural)
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("leftBrace", this.leftBrace);
		b.add("rightBrace", this.rightBrace);
		b.add("structural", this.structural);
		return b.toString();
	}

	public String getLeftBrace() {
		return leftBrace;
	}

	public String getRightBrace() {
		return rightBrace;
	}

	public boolean isStructural() {
		return structural;
	}
}
