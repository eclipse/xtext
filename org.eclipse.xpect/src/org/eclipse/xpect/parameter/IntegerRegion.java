package org.eclipse.xpect.parameter;

public class IntegerRegion extends DerivedRegion {
	public IntegerRegion(IStatementRelatedRegion origin) {
		super(origin, -1, -1);
	}

	public IntegerRegion(IStatementRelatedRegion origin, int offset, int length) {
		super(origin, offset, length);
	}
}
