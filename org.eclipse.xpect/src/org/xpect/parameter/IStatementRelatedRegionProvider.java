package org.xpect.parameter;

import java.util.Collection;

import org.xpect.XpectInvocation;

public interface IStatementRelatedRegionProvider {
	IStatementRelatedRegion getRegion(XpectInvocation invocation);

	public interface IRefinableStatementRelatedRegion extends IStatementRelatedRegion {
		IStatementRelatedRegion refine(Collection<IStatementRelatedRegion> allRegions);
	}
}