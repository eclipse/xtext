package org.xpect.runner;

import org.xpect.XpectInvocation;
import org.xpect.parameter.StatementRelatedRegion;

public class TestTitleRegion extends StatementRelatedRegion {

	public TestTitleRegion(XpectInvocation statement, int offset, int length) {
		super(statement, offset, length);
	}

	public String getTitle() {
		String text = getRegionText();
		return text != null ? text.trim() : null;
	}

}
