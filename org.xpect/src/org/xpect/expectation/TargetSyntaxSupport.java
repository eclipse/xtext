package org.xpect.expectation;

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
