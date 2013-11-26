/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractRootTypeExpectation extends AbstractTypeExpectation {

	public AbstractRootTypeExpectation(AbstractTypeComputationState state) {
		super(state);
	}
	
	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		List<ConformanceHint> hintsAsList = Arrays.asList(hints);
		if (!hintsAsList.contains(ConformanceHint.NO_IMPLICIT_RETURN))
			getState().acceptType(getResolvedTypes(), this, type, true, hints);
		if (!hintsAsList.contains(ConformanceHint.EXPLICIT_VOID_RETURN))
			getState().acceptType(getResolvedTypes(), this, type, false, hints);
	}

}
