/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.expectation;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XpectInvocation;
import org.xpect.text.Region;
import org.xpect.text.Text;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractExpectationParser {

	public static class AbstractExpectationRegion extends Region implements IExpectationRegion {
		private final CharSequence document;

		public AbstractExpectationRegion(CharSequence document, int offset, int length, String separator, int openingSeparatorOffset) {
			super(offset, length);
			this.document = document;
			this.separator = separator;
			this.opeingSeparatorOffset = openingSeparatorOffset;
		}

		public CharSequence getDocument() {
			return document;
		}

		private final int opeingSeparatorOffset;
		private final String separator;

		public int getOpeningSeparatorOffset() {
			return opeingSeparatorOffset;
		}

		public String getSeparator() {
			return separator;
		}

	}

	public static class MultiLineExpectationRegion extends AbstractExpectationRegion implements IMultiLineExpectationRegion {
		private final int closingSeparatorOffset;
		private final String indentation;

		public MultiLineExpectationRegion(CharSequence document, int offset, int length, String indentation, String separator,
				int openingSeparatorOffset, int closingSeparatorOffset) {
			super(document, offset, length, separator, openingSeparatorOffset);
			this.indentation = indentation;
			this.closingSeparatorOffset = closingSeparatorOffset;
		}

		public int getClosingSeparatorOffset() {
			return closingSeparatorOffset;
		}

		public String getIndentation() {
			return indentation;
		}

		public boolean isSingleLine() {
			return indentation == null;
		}
	}

	public static class SingleLineExpectationRegion extends AbstractExpectationRegion implements ISingleLineExpectationRegion {
		public SingleLineExpectationRegion(CharSequence document, int offset, int length, String separator, int openingSeparatorOffset) {
			super(document, offset, length, separator, openingSeparatorOffset);
		}
	}

	public IExpectationRegion claimRegion(XpectInvocation invocation, int paramIndex) {
		INode node = NodeModelUtils.getNode(invocation);
		String document = node.getRootNode().getText();
		int paramStart = node.getOffset() + node.getLength();
		int paramEnd = document.indexOf('\n', paramStart);
		if (paramEnd < 0)
			paramEnd = document.length();
		String param = document.substring(paramStart, paramEnd);

		// try to match a single-line-expectation
		final String SEP = "-->";
		int slStart = param.indexOf(SEP);
		if (slStart >= 0) {
			int tokenStart = slStart + SEP.length();
			if (tokenStart < param.length() && Character.isWhitespace(param.charAt(tokenStart)))
				tokenStart++;
			int start = paramStart + tokenStart;
			return new SingleLineExpectationRegion(document, start, paramEnd - start, SEP, paramStart + slStart);
		}

		// try to match a multi-line-expectation
		int openingSeparatorEnd = paramEnd;
		while (Character.isWhitespace(document.charAt(openingSeparatorEnd)))
			openingSeparatorEnd--;
		char separatorChar = document.charAt(openingSeparatorEnd);
		String separator = String.valueOf(separatorChar);
		int i = openingSeparatorEnd - 1;
		while (i >= 0 && document.charAt(i--) == separatorChar)
			separator += separatorChar;
		if (separator.length() > 2) {
			int closingSepStart = document.indexOf(separator, paramEnd);
			if (closingSepStart >= 0) {
				int expectationStart = paramEnd + 1;
				int expectationEnd = document.lastIndexOf('\n', closingSepStart);
				String indentation = new Text(document).findIndentation(expectationStart);
				return new MultiLineExpectationRegion(document, expectationStart, expectationEnd - expectationStart, indentation,
						separator, (openingSeparatorEnd + 1) - separator.length(), closingSepStart);
			}
		}
		return null;
	}
}
