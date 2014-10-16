package org.xpect.parameter;


public class StringRegion extends DerivedRegion {

	public StringRegion(IStatementRelatedRegion origin, int offset, int length) {
		super(origin, offset, length);
	}

	public String getStringValue() {
		String text = getRegionText();
		return text;
	}

}
