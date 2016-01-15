package org.eclipse.xpect.parameter;

import org.eclipse.xpect.XpectInvocation;

public class ParameterRegion extends StatementRelatedRegion {

	public ParameterRegion(XpectInvocation statement, int offset, int length) {
		super(statement, offset, length);
	}

}
