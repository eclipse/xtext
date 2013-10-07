package org.xpect.expectation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.xpect.text.IReplacement;

/**
 * 
 * @author Moritz Eysholdt
 */
public interface ITargetSyntaxSupport {
	@Retention(RetentionPolicy.RUNTIME)
	@interface Annotation {
	}

	boolean supportsMultiLineLiteral();

	IReplacement adoptToTargetSyntax(IReplacement replacement, boolean enforceMultilineLiteral);
}
