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
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
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
		if (!rightReference.isRawType()) {
			FunctionTypeReference functionType = rightReference.getAsFunctionTypeReference();
			if (functionType != null) {
				return conformanceComputer.isConformant(leftReference, functionType, param);
			}
			if (leftReference.isFunctionType()) {
				FunctionTypeReference converted = rightReference.tryConvertToFunctionTypeReference(param.rawType);
				if (converted != null) {
					TypeConformanceResult functionsAreConformant = conformanceComputer.isConformant(leftReference, converted, param);
					if (functionsAreConformant.isConformant()) {
						return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(ConformanceHint.DEMAND_CONVERSION));
					}
				}
			}
		}
		return super.doVisitParameterizedTypeReference(leftReference, rightReference, param);
	}
	
	@Override
	protected TypeConformanceResult doVisitFunctionTypeReference(FunctionTypeReference left, FunctionTypeReference right,
			TypeConformanceComputationArgument.Internal<FunctionTypeReference> param) {
		List<LightweightTypeReference> leftParameterTypes = left.getParameterTypes();
		List<LightweightTypeReference> rightParameterTypes = right.getParameterTypes();
		if (leftParameterTypes.size() != rightParameterTypes.size()) {
			return TypeConformanceResult.FAILED;
		}
		LightweightTypeReference leftReturnType = left.getReturnType();
		LightweightTypeReference rightReturnType = right.getReturnType();
		boolean leftIsVoid = leftReturnType != null && leftReturnType.isPrimitiveVoid();
		boolean rightIsVoid = rightReturnType != null && rightReturnType.isPrimitiveVoid();
		if (leftIsVoid) {
			if (rightIsVoid) {
				if (param.rawType)
					return TypeConformanceResult.SUCCESS;
			} else {
				return TypeConformanceResult.FAILED;
			}
		} else if (rightIsVoid) {
			return TypeConformanceResult.FAILED;
		} else if (param.rawType) {
			return TypeConformanceResult.SUCCESS;
		}
		if (param.rawType) {
			throw new IllegalStateException("rawTypeComputation should have exited earlier");
		}
		TypeConformanceComputationArgument argument = new TypeConformanceComputationArgument(false, false, true, false, param.unboundComputationAddsHints);
		if (!conformanceComputer.isConformant(leftReturnType, rightReturnType, argument).isConformant()) {
			return TypeConformanceResult.FAILED;
		}
		for(int i = 0; i < leftParameterTypes.size(); i++) {
			if (!conformanceComputer.isConformant(rightParameterTypes.get(i), leftParameterTypes.get(i), argument).isConformant()) {
				return TypeConformanceResult.FAILED;
			} 
		}
		return TypeConformanceResult.SUCCESS;
	}

}