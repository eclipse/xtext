package org.xpect.expectation.impl;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.xpect.XpectInvocation;
import org.xpect.expectation.IExpectationRegion;
import org.xpect.parameter.IStatementRelatedRegionProvider;
import org.xpect.parameter.StatementRelatedRegionProvider;
import org.xpect.text.Text;

@StatementRelatedRegionProvider
public class ExpectationRegionProvider implements IStatementRelatedRegionProvider {

	public IExpectationRegion getRegion(XpectInvocation invocation) {
		INode node = NodeModelUtils.getNode(invocation);
		Text document = new Text(node.getRootNode().getText());
		int paramStart = node.getOffset() + node.getLength();
		int paramEnd = document.currentLineEnd(paramStart);
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
			return new SingleLineExpectationRegion(invocation, document.toString(), start, paramEnd - start, SEP, paramStart + slStart);
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
				String indentationPrefix = document.substring(document.currentLineStart(node.getOffset()), node.getOffset());
				int expectationStart = document.nextLineStart(paramStart);
				int expectationEnd = document.previousLineEnd(closingSepStart);
				String indentation = document.findIndentation(indentationPrefix, expectationStart, expectationEnd);
				int lenght = expectationEnd - expectationStart;
				int openingSepOffset = (openingSeparatorEnd + 1) - separator.length();
				return new MultiLineExpectationRegion(invocation, document.toString(), expectationStart, lenght, indentation, separator, openingSepOffset, closingSepStart);
			}
		}
		return null;
	}

}
