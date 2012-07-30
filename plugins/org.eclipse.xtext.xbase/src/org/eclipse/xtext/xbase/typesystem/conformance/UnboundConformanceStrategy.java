/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
class UnboundConformanceStrategy extends TypeConformanceStrategy<UnboundTypeReference> {
	protected UnboundConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(UnboundTypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<UnboundTypeReference> param) {
		List<LightweightBoundTypeArgument> hints = left.getAllHints();
		for(LightweightBoundTypeArgument hint: hints) {
			VarianceInfo varianceInfo = hint.getDeclaredVariance().mergeDeclaredWithActual(hint.getActualVariance());
			if (varianceInfo == VarianceInfo.INVARIANT) {
				return conformanceComputer.isConformant(hint.getTypeReference(), right, param);
			} else if (varianceInfo == VarianceInfo.OUT) {
				
			}
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	protected TypeConformanceResult doVisitUnboundTypeReference(UnboundTypeReference left, UnboundTypeReference right,
			TypeConformanceComputationArgument.Internal<UnboundTypeReference> param) {
		if (left.getTypeParameter() == right.getTypeParameter())
			return TypeConformanceResult.SUCCESS;
		if (left.getAllHints().equals(right.getAllHints()))
			return TypeConformanceResult.SUCCESS;
		return TypeConformanceResult.FAILED;
	}
}