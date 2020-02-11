/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

/**
 * <p>Return value of data type rules.</p><p>DatatypeRuleTokens can be merged with
 * other DatatypeRuleTokens.
 * We insert spaces on merge, if the merged token did not follow immediately, so
 * we don't mess some corner cases up, e.g.:
 * <code>
 * <ul>
 * <li>Dots returns EString: '.' '.' | '..';</li>
 * <li>Vector returns EString: INT INT;</li>
 * <li>NumbersOrReal returns EString: INT '.' INT | REAL;</li>
 * <li>REAL: "('0'..'9')+'.'('0'..'9')+";</li>
 * </ul>
 * </code>
 * </p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class DatatypeRuleToken {

	public static final int INITIAL_OFFSET = -1;
	protected final StringBuilder buffer;
	protected int expectedOffset;
	protected int startOffset;

	protected DatatypeRuleToken() {
		this.buffer = new StringBuilder();
		expectedOffset = INITIAL_OFFSET;
		startOffset = INITIAL_OFFSET;
	}

	public void merge(DatatypeRuleToken token) {
		internalMerge(token.getText(), token.startOffset);
	}

	protected void internalMerge(String text, int offset) {
		if (text == null) {
			return;
		}
		if (startOffset == INITIAL_OFFSET) {
			startOffset = offset;
		}
		if (expectedOffset != INITIAL_OFFSET && offset > expectedOffset) {
			buffer.append(' ');
		}
		buffer.append(text);
		expectedOffset = offset + text.length();
	}

	public String getText() {
		if (buffer.length() > 0)
			return buffer.toString();
		return null;
	}

	public void setText(String text) {
		buffer.replace(0, buffer.length(), text);
	}

	public int getExpectedOffset() {
		return expectedOffset;
	}

	public void setExpectedOffset(int expectedOffset) {
		this.expectedOffset = expectedOffset;
	}

	public int getStartOffset() {
		return startOffset;
	}

	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getSimpleName()).append("{\n\t");
		result.append("startOffset: ").append(startOffset).append("\n\t");
		result.append("expectedOffset: ").append(expectedOffset).append("\n\t");
		result.append("bufferValue: '").append(buffer.toString()).append("'\n}");
		return result.toString();
	}

}