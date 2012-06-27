package org.eclipse.xpect.lib;

import java.util.List;

public interface IXpectParameterProvider {

	public interface IRegion {
		int getLength();

		int getOffset();
	}

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
