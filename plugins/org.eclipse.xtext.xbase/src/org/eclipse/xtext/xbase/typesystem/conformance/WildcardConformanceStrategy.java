/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class WildcardConformanceStrategy extends TypeConformanceStrategy<WildcardTypeReference> {
	
	public WildcardConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(WildcardTypeReference leftWildcard, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<WildcardTypeReference> param) {
		if (param.asTypeArgument) {
			LightweightTypeReference lowerBound = leftWildcard.getLowerBound();
			if (lowerBound != null) {
				TypeConformanceResult result = conformanceComputer.isConformant(right, lowerBound, new TypeConformanceComputationArgument(
						false, false, false, false, param.unboundComputationAddsHints));
				if (!result.isConformant()) {
					return result;
				}
				return TypeConformanceResult.SUCCESS;
			}
			for(LightweightTypeReference upperBound: leftWildcard.getUpperBounds()) {
				TypeConformanceResult result = conformanceComputer.isConformant(upperBound, right, new TypeConformanceComputationArgument(
						false, false, false, false, param.unboundComputationAddsHints));
				if (!result.isConformant()) {
					return result;
				}
			}
			return TypeConformanceResult.SUCCESS;
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	protected TypeConformanceResult doVisitMultiTypeReference(WildcardTypeReference left, CompoundTypeReference right,
			TypeConformanceComputationArgument.Internal<WildcardTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}

	@Override
	protected TypeConformanceResult doVisitWildcardTypeReference(WildcardTypeReference leftWildcard, WildcardTypeReference rightWildcard, TypeConformanceComputationArgument.Internal<WildcardTypeReference> param) {
		if (param.asTypeArgument) {
			LightweightTypeReference leftLowerBound = leftWildcard.getLowerBound();
			if (leftLowerBound != null) {
				LightweightTypeReference rightLowerBound = rightWildcard.getLowerBound();
				if (rightLowerBound != null) {
					TypeConformanceResult result = conformanceComputer.isConformant(rightLowerBound, leftLowerBound, new TypeConformanceComputationArgument(
							false, false, false, false, param.unboundComputationAddsHints));
					if (!result.isConformant()) {
						return TypeConformanceResult.FAILED;
					}
				} else {
					for(LightweightTypeReference rightUpperBound: rightWildcard.getUpperBounds()) {
						if (!rightUpperBound.isType(Object.class)) {
							return TypeConformanceResult.FAILED;
						}
					}
				}
				return TypeConformanceResult.SUCCESS;
			}
			for(LightweightTypeReference upperBound: leftWildcard.getUpperBounds()) {
				TypeConformanceResult result = conformanceComputer.isConformant(upperBound, rightWildcard, new TypeConformanceComputationArgument(
						false, false, false, false, param.unboundComputationAddsHints));
				if (!result.isConformant()) {
					return result;
				}
			}
			return TypeConformanceResult.SUCCESS;
		}
		return TypeConformanceResult.FAILED;
	}
}