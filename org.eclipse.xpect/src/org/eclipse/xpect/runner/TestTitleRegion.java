package org.eclipse.xpect.runner;

import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.parameter.StatementRelatedRegion;

public class TestTitleRegion extends StatementRelatedRegion {

	public TestTitleRegion(XpectInvocation statement, int offset, int length) {
		super(statement, offset, length);
	}

	public String getTitle() {
		String text = getRegionText();
		return text != null ? text.trim() : null;
	}

}
