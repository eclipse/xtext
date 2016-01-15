package org.eclipse.xpect.expectation.impl;

import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.expectation.ISingleLineExpectationRegion;

public class SingleLineExpectationRegion extends AbstractExpectationRegion implements ISingleLineExpectationRegion {
	public SingleLineExpectationRegion(XpectInvocation statement, CharSequence document, int offset, int length, String separator, int openingSeparatorOffset) {
		super(statement, document, offset, length, separator, openingSeparatorOffset);
	}
}