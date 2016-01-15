package org.eclipse.xpect.expectation.impl;

import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.expectation.IExpectationRegion;
import org.eclipse.xpect.parameter.StatementRelatedRegion;

public abstract class AbstractExpectationRegion extends StatementRelatedRegion implements IExpectationRegion {
	private final CharSequence document;

	public AbstractExpectationRegion(XpectInvocation statement, CharSequence document, int offset, int length, String separator, int openingSeparatorOffset) {
		super(statement, offset, length);
		this.document = document;
		this.separator = separator;
		this.opeingSeparatorOffset = openingSeparatorOffset;
	}

	public String getDocument() {
		return document.toString();
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