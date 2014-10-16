package org.xpect.expectation;

import org.xpect.parameter.IStatementRelatedRegion;

/**
 * @author Moritz Eysholdt
 */
public interface IExpectationRegion extends IStatementRelatedRegion {

	String getSeparator();

	int getOpeningSeparatorOffset();
}
