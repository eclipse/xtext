/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

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

	@Override
	public void acceptActualType(LightweightTypeReference type, int flags) {
		getState().acceptType(getResolvedTypes(), this, type, returnType, flags);
	}
	
	protected boolean isReturnType() {
		return returnType;
	}

}
