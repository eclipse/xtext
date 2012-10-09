/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ImplicitFirstArgument extends AbstractImplicitFeature {

	protected ImplicitFirstArgument(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicit,
			ExpressionTypeComputationState state) {
		super(featureCall, implicit, state);
	}

	public void resolveLinkingProxy() {
		getOwner().setImplicitFirstArgument(getFeatureCall());
	}

}
