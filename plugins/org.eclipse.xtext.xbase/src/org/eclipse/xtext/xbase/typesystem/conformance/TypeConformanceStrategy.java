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
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument.Internal;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class TypeConformanceStrategy<T extends LightweightTypeReference> extends AbstractConformanceVisitor<T> {
	
	protected final TypeConformanceComputer conformanceComputer;
	
	protected TypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		this.conformanceComputer = conformanceComputer;
	}
	
	private T getLeft(TypeConformanceComputationArgument.Internal<T> param) {
		return param.reference;
	}

	@Override
	protected final TypeConformanceResult doVisitAnyTypeReference(AnyTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitAnyTypeReference(getLeft(param), right, param);
	}
	
	protected TypeConformanceResult doVisitAnyTypeReference(T left, AnyTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitCompoundTypeReference(CompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitCompoundTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitCompoundTypeReference(T left, CompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitArrayTypeReference(ArrayTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitArrayTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitArrayTypeReference(T left, ArrayTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitParameterizedTypeReference(ParameterizedTypeReference right,
			TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitParameterizedTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitParameterizedTypeReference(T left, ParameterizedTypeReference right,
			TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitFunctionTypeReference(FunctionTypeReference right, Internal<T> param) {
		return doVisitFunctionTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitFunctionTypeReference(T left, FunctionTypeReference right,
			TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitParameterizedTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitTypeReference(LightweightTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitTypeReference(T left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + left + " <= " + right);
	}
	
	@Override
	protected final TypeConformanceResult doVisitUnboundTypeReference(UnboundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitUnboundTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitUnboundTypeReference(T left, UnboundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitWildcardTypeReference(WildcardTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitWildcardTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitWildcardTypeReference(T left, WildcardTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	protected final TypeConformanceResult doVisitMultiTypeReference(CompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitMultiTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitMultiTypeReference(T left, CompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		for(LightweightTypeReference reference: right.getMultiTypeComponents()) {
			TypeConformanceResult result = reference.accept(this, param);
			if (result.isConformant())
				return result;
		}
		if (right.getMultiTypeComponents().isEmpty())
			return TypeConformanceResult.SUCCESS;
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	protected final TypeConformanceResult doVisitSynonymTypeReference(CompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitSynonymTypeReference(getLeft(param), right, param);
	}
	protected TypeConformanceResult doVisitSynonymTypeReference(T left, CompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		List<LightweightTypeReference> rightComponents = right.getMultiTypeComponents();
		if (rightComponents.isEmpty())
			return TypeConformanceResult.FAILED;
		for(int i = 0; i < rightComponents.size(); i++) {
			TypeConformanceResult candidate = rightComponents.get(i).accept(this, param);
			if (candidate.isConformant()) {
				if (i == 0)
					return candidate;
				TypeConformanceResult result = TypeConformanceResult.merge(candidate, new TypeConformanceResult(ConformanceHint.SYNONYM));
				result.setSynonymIndex(i);
				result.setConversion(rightComponents.get(0), rightComponents.get(i));
				return result;
			}
		}
		return TypeConformanceResult.FAILED;
	}
	
}