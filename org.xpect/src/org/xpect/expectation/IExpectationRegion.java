package org.xpect.expectation;

import org.xpect.util.IRegion;

public interface IExpectationRegion extends IRegion {
	boolean isSingleLine();

	String getIndentation();
}
