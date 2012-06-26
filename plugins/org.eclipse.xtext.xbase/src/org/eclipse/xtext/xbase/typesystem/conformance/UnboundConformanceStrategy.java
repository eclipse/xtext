/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
class UnboundConformanceStrategy extends TypeConformanceStrategy<UnboundTypeReference> {
	protected UnboundConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(UnboundTypeReference left, LightweightTypeReference reference, TypeConformanceComputationArgument.Internal<UnboundTypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	public TypeConformanceResult doVisitUnboundTypeReference(UnboundTypeReference left, UnboundTypeReference right,
			TypeConformanceComputationArgument.Internal<UnboundTypeReference> param) {
		if (left.getTypeParameter() == right.getTypeParameter())
			return TypeConformanceResult.SUCCESS;
		return TypeConformanceResult.FAILED;
	}
}