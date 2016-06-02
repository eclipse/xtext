package org.eclipse.xpect.parameter;

import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.text.IRegion;

public interface IStatementRelatedRegion extends IRegion {

	XpectInvocation getStatement();

}
