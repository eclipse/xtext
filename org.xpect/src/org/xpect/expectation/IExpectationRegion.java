package org.xpect.expectation;

import org.xpect.text.IRegion;

/**
 * 
 * @author Moritz Eysholdt
 */
public interface IExpectationRegion extends IRegion {

	CharSequence getDocument();

	String getSeparator();

	int getOpeningSeparatorOffset();

}
