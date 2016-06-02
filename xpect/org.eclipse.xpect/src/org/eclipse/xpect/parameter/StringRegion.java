package org.eclipse.xpect.parameter;

public class StringRegion extends DerivedRegion {

	public StringRegion(IStatementRelatedRegion origin) {
		super(origin, -1, -1);
	}

	public StringRegion(IStatementRelatedRegion origin, int offset, int length) {
		super(origin, offset, length);
	}

	public String getStringValue() {
		String text = getRegionText();
		return text;
	}

}
