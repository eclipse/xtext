package org.xpect.expectation;

import org.xpect.text.IReplacement;

/**
 * 
 * @author Moritz Eysholdt
 */
public interface ITargetSyntaxSupport {
	@interface Annotation {
	}

	boolean supportsMultiLineLiteral();

	IReplacement adoptToTargetSyntax(IReplacement replacement, boolean enforceMultilineLiteral);
}
