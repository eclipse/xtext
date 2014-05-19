/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractReturnAwareTypeExpectation extends AbstractTypeExpectation {

	private final boolean returnType;
	
	protected AbstractReturnAwareTypeExpectation(AbstractTypeComputationState state, boolean returnType) {
		super(state);
		this.returnType = returnType;
	}

	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		getState().acceptType(getResolvedTypes(), this, type, returnType, hints);
	}
	
	protected boolean isReturnType() {
		return returnType;
	}

}
