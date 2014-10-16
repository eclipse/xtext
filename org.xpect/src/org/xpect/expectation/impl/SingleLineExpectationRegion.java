package org.xpect.expectation.impl;

import org.xpect.XpectInvocation;
import org.xpect.expectation.ISingleLineExpectationRegion;

public class SingleLineExpectationRegion extends AbstractExpectationRegion implements ISingleLineExpectationRegion {
	public SingleLineExpectationRegion(XpectInvocation statement, CharSequence document, int offset, int length, String separator, int openingSeparatorOffset) {
		super(statement, document, offset, length, separator, openingSeparatorOffset);
	}
}