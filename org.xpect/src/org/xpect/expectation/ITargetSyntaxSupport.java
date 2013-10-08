package org.xpect.expectation;

import org.xpect.text.IReplacement;

/**
 * 
 * @author Moritz Eysholdt
 */
public interface ITargetSyntaxSupport {

	boolean supportsMultiLineLiteral();

	ITargetLiteralSupport getLiteralSupport(int offset);

	interface ITargetLiteralSupport {
		String escape(String value);

		public IReplacement adoptToTargetSyntax(IReplacement replacement, boolean enforceMultilineLiteral);
	}
}
