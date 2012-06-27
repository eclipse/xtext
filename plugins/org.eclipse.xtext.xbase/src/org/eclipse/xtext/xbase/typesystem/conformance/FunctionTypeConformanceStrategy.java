/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument.Internal;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FunctionTypeConformanceStrategy extends
		ParameterizedTypeConformanceStrategy<FunctionTypeReference> {
	public FunctionTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitParameterizedTypeReference(FunctionTypeReference leftReference,
			ParameterizedTypeReference rightReference,
			TypeConformanceComputationArgument.Internal<FunctionTypeReference> param) {
		throw new UnsupportedOperationException("Implement me");
	}
	
	@Override
	protected TypeConformanceResult doVisitFunctionTypeReference(FunctionTypeReference left, FunctionTypeReference right,
			Internal<FunctionTypeReference> param) {
		throw new UnsupportedOperationException("Implement me");
	}

}