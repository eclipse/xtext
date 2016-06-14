/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractRootTypeExpectation extends AbstractTypeExpectation {

	public AbstractRootTypeExpectation(AbstractTypeComputationState state) {
		super(state);
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, int flags) {
		if ((flags & ConformanceFlags.NO_IMPLICIT_RETURN) == 0)
			getState().acceptType(getResolvedTypes(), this, type, true, flags);
		if ((flags & ConformanceFlags.EXPLICIT_VOID_RETURN) == 0)
			getState().acceptType(getResolvedTypes(), this, type, false, flags);
	}

}
