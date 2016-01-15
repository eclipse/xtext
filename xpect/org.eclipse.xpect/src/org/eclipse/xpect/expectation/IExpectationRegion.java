package org.eclipse.xpect.expectation;

import org.eclipse.xpect.parameter.IStatementRelatedRegion;

/**
 * @author Moritz Eysholdt
 */
public interface IExpectationRegion extends IStatementRelatedRegion {

	String getSeparator();

	int getOpeningSeparatorOffset();
}
