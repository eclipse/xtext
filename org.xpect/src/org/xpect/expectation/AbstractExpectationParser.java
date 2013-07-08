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
import org.xpect.util.Region;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractExpectationParser {
	public static class SingleLineExpectationRegion extends Region implements ISingleLineExpectationRegion {
		public SingleLineExpectationRegion(int offset, int length) {
			super(offset, length);
		}
	}

	public static class MultiLineExpectationRegion extends Region implements IMultiLineExpectationRegion {
		private final String indentation;
		private final String separator;
		private final int opeingSeparatorOffset;
		private final int closingSeparatorOffset;

		public MultiLineExpectationRegion(int offset, int length, String indentation, String separator, int openingSeparatorOffset,
				int closingSeparatorOffset) {
			super(offset, length);
			this.indentation = indentation;
			this.separator = separator;
			this.opeingSeparatorOffset = openingSeparatorOffset;
			this.closingSeparatorOffset = closingSeparatorOffset;
		}

		public String getIndentation() {
			return indentation;
		}

		public boolean isSingleLine() {
			return indentation == null;
		}

		public String getSeparator() {
			return separator;
		}

		public int getOpeningSeparatorOffset() {
			return opeingSeparatorOffset;
		}

		public int getClosingSeparatorOffset() {
			return closingSeparatorOffset;
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
		int slStart = param.indexOf("-->");
		if (slStart >= 0) {
			slStart += "-->".length();
			if (Character.isWhitespace(document.charAt(slStart)))
				slStart++;
			int start = paramStart + slStart;
			return new SingleLineExpectationRegion(start, paramEnd - start);
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
				String indentation = getIndentation(document, expectationStart);
				return new MultiLineExpectationRegion(expectationStart, expectationEnd - expectationStart, indentation, separator,
						(openingSeparatorEnd + 1) - separator.length(), closingSepStart);
			}
		}
		return null;
	}

	protected String getIndentation(String document, int offset) {
		int nl = document.lastIndexOf("\n", offset);
		if (nl < 0)
			nl = 0;
		StringBuilder result = new StringBuilder();
		for (int i = nl + 1; i < document.length() && Character.isWhitespace(document.charAt(i)) && document.charAt(i) != '\n'; i++)
			result.append(document.charAt(i));
		return result.toString();
	}

}
