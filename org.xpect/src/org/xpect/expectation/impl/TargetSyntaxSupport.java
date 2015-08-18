package org.xpect.expectation.impl;

import org.xpect.XpectInvocation;
import org.xpect.parameter.IStatementRelatedRegion;
import org.xpect.state.Creates;
import org.xpect.text.IReplacement;

/**
 * 
 * @author Moritz Eysholdt
 */
public class TargetSyntaxSupport {

	public boolean supportsMultiLineLiteral() {
		return false;
	}

	public TargetLiteralSupport getLiteralSupport(int offset) {
		return new TargetLiteralSupport();
	}

	public int findFirstSemanticCharAfterStatement(XpectInvocation statement) {
		String text = statement.getFile().getDocument();
		int result;
		do {
			IStatementRelatedRegion region = statement.getExtendedRegion();
			result = region.getOffset() + region.getLength();
			while (result < text.length() && Character.isWhitespace(text.charAt(result)))
				result++;
			statement = statement.getFile().getInvocationAt(result);
		} while (statement != null && result < text.length());
		if (result < text.length())
			return result;
		throw new RuntimeException("Reached end of the file before finding a value for OFFSET.");
	}

	public static class TargetLiteralSupport {
		public String escape(String value) {
			return value;
		}

		public IReplacement adoptToTargetSyntax(IReplacement replacement, boolean enforceMultilineLiteral) {
			return replacement;
		}
	}

	@Creates
	public TargetSyntaxSupport create() {
		return this;
	}
}
