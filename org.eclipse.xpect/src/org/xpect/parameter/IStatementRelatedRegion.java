package org.xpect.parameter;

import org.xpect.XpectInvocation;
import org.xpect.text.IRegion;

public interface IStatementRelatedRegion extends IRegion {

	XpectInvocation getStatement();

}
