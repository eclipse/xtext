/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import java.util.List;

import org.xpect.util.IRegion;
import org.xpect.util.ITypedProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IParameterParser {

	public interface IClaimedRegion extends IRegion {
		IParameterParser getClaminer();
	}

	public interface ISingleParameterParser extends IParameterParser {
		IRegion claimRegion(XpectTestRunner invocation, int paramIndex);

		ITypedProvider parseRegion(XpectTestRunner invocation, int paramIndex, List<IClaimedRegion> claims);
	}

	public interface IMultiParameterParser extends IParameterParser {
		IRegion claimRegion(XpectTestRunner invocation);

		List<ITypedProvider> parseRegion(XpectTestRunner invocation, List<IClaimedRegion> claims);
	}
}
