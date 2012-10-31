package org.xpect.runner;

import java.util.List;

import org.xpect.util.IRegion;
import org.xpect.util.ITypedProvider;

public interface IXpectParameterProvider {

	public interface IClaimedRegion extends IRegion {
		IXpectParameterProvider getClaminer();
	}

	public interface IXpectSingleParameterProvider extends IXpectParameterProvider {
		IRegion claimRegion(XpectTestRunner invocation, int paramIndex);

		ITypedProvider parseRegion(XpectTestRunner invocation, int paramIndex, List<IClaimedRegion> claims);
	}

	public interface IXpectMultiParameterProvider extends IXpectParameterProvider {
		IRegion claimRegion(XpectTestRunner invocation);

		List<ITypedProvider> parseRegion(XpectTestRunner invocation, List<IClaimedRegion> claims);
	}
}
