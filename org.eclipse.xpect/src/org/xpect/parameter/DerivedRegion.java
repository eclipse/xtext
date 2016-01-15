package org.xpect.parameter;


public class DerivedRegion extends StatementRelatedRegion {
	private IStatementRelatedRegion origin;

	public DerivedRegion(IStatementRelatedRegion origin, int offset, int length) {
		super(origin.getStatement(), offset, length);
		this.origin = origin;
	}

	public IStatementRelatedRegion getOrigin() {
		return origin;
	}

}
