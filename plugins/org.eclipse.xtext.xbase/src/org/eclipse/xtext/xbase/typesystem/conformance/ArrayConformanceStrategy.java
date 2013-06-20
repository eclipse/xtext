/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument.Internal;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ArrayConformanceStrategy extends TypeConformanceStrategy<ArrayTypeReference> {
	
	public ArrayConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}
	
	@Override
	protected TypeConformanceResult doVisitArrayTypeReference(ArrayTypeReference left,
			ArrayTypeReference right,
			TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		LightweightTypeReference leftComponent = left.getComponentType();
		LightweightTypeReference rightComponent = right.getComponentType();
		return conformanceComputer.isConformant(leftComponent, rightComponent, 
				new TypeConformanceComputationArgument(param.rawType, param.asTypeArgument, false, false, param.unboundComputationAddsHints, false));
	}
	
	@Override
	protected TypeConformanceResult doVisitWildcardTypeReference(ArrayTypeReference left,
			WildcardTypeReference right, TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		if (!param.isAsTypeArgument()) {
			for(LightweightTypeReference upperBound: right.getUpperBounds()) {
				TypeConformanceResult result = conformanceComputer.isConformant(left, upperBound, param);
				if (result.isConformant()) {
					return result;
				}
			}
		}
		return TypeConformanceResult.create(param, ConformanceHint.INCOMPATIBLE);
	}
	
	@Override
	protected TypeConformanceResult doVisitParameterizedTypeReference(ArrayTypeReference left,
			ParameterizedTypeReference right, Internal<ArrayTypeReference> param) {
		if (!param.asTypeArgument) {
			JvmType type = right.getType();
			if (type instanceof JvmTypeParameter) {
				TypeConformanceComputationArgument paramWithoutSuperTypeCheck = new TypeConformanceComputationArgument(
						param.rawType, true, param.allowPrimitiveConversion, param.allowPrimitiveWidening, param.unboundComputationAddsHints, param.allowSynonyms);
				for(LightweightTypeReference rightSuperTypes: right.getAllSuperTypes()) {
					TypeConformanceResult result = conformanceComputer.isConformant(left, rightSuperTypes, paramWithoutSuperTypeCheck);
					if (result.isConformant()) {
						return TypeConformanceResult.merge(result, TypeConformanceResult.create(param, ConformanceHint.SUBTYPE));
					}
				}
			} else if (param.allowSynonyms){
				ArrayTypeReference rightAsArray = right.tryConvertToArray();
				if (rightAsArray != null) {
					if (left.getComponentType().isPrimitive()) {
						if (rightAsArray.getComponentType().isWrapper()) {
							LightweightTypeReference primitive = rightAsArray.getComponentType().getPrimitiveIfWrapperType();
							rightAsArray = new ArrayTypeReference(rightAsArray.getOwner(), primitive);
						}
					}
					TypeConformanceResult result = conformanceComputer.isConformant(left, rightAsArray, param);
					if (result.isConformant()) {
						return TypeConformanceResult.merge(result, TypeConformanceResult.create(param, ConformanceHint.DEMAND_CONVERSION, ConformanceHint.SYNONYM));
					}
				}
			}
		}
		return TypeConformanceResult.create(param, ConformanceHint.INCOMPATIBLE);
	}

	@Override
	protected TypeConformanceResult doVisitAnyTypeReference(ArrayTypeReference left, AnyTypeReference reference, TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		return TypeConformanceResult.create(param, ConformanceHint.SUCCESS);
	}
	
	@Override
	protected TypeConformanceResult doVisitUnboundTypeReference(ArrayTypeReference left, UnboundTypeReference right, Internal<ArrayTypeReference> param) {
		if (right.canResolveTo(left)) {
			return TypeConformanceResult.create(param, ConformanceHint.SUCCESS);
		}
		return TypeConformanceResult.create(param, ConformanceHint.INCOMPATIBLE);
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(ArrayTypeReference left, LightweightTypeReference reference, TypeConformanceComputationArgument.Internal<ArrayTypeReference> param) {
		return TypeConformanceResult.create(param, ConformanceHint.INCOMPATIBLE);
	}
}