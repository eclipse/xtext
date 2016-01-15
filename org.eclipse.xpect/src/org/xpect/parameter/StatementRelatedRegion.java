package org.xpect.parameter;

import org.xpect.XpectInvocation;
import org.xpect.text.Region;

public class StatementRelatedRegion extends Region implements IStatementRelatedRegion {

	private final XpectInvocation statement;

	public StatementRelatedRegion(XpectInvocation statement, int offset, int length) {
		super(statement.getFile().getDocument(), offset, length);
		this.statement = statement;
	}

	public XpectInvocation getStatement() {
		return statement;
	}

}
