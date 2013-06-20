/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public abstract class TypeConformanceStrategy<T extends JvmTypeReference> extends AbstractConformanceVisitor<T> {
	
	protected final TypeConformanceComputer conformanceComputer;
	
	protected TypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		this.conformanceComputer = conformanceComputer;
	}
	
	private T getLeft(TypeConformanceComputationArgument.Internal<T> param) {
		return param.reference;
	}

	@Override
	public final TypeConformanceResult doVisitAnyTypeReference(JvmAnyTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitAnyTypeReference(getLeft(param), right, param);
	}
	
	public TypeConformanceResult doVisitAnyTypeReference(T left, JvmAnyTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public final TypeConformanceResult doVisitCompoundTypeReference(JvmCompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitCompoundTypeReference(getLeft(param), right, param);
	}
	
	public TypeConformanceResult doVisitCompoundTypeReference(T left, JvmCompoundTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public final TypeConformanceResult doVisitDelegateTypeReference(JvmDelegateTypeReference right, TypeConformanceComputationArgument.Internal<T> parameter) {
		return doVisitDelegateTypeReference(getLeft(parameter), right, parameter);
	}
	public TypeConformanceResult doVisitDelegateTypeReference(T left, JvmDelegateTypeReference right, TypeConformanceComputationArgument.Internal<T> parameter) {
		TypeConformanceResult result = visit(right.getDelegate(), parameter);
		return result;
	}
	
	@Override
	public final TypeConformanceResult doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitGenericArrayTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitGenericArrayTypeReference(T left, JvmGenericArrayTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public final TypeConformanceResult doVisitParameterizedTypeReference(JvmParameterizedTypeReference right,
			TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitParameterizedTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitParameterizedTypeReference(T left, JvmParameterizedTypeReference right,
			TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public final TypeConformanceResult doVisitSpecializedTypeReference(JvmSpecializedTypeReference right,
			TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitSpecializedTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitSpecializedTypeReference(T left, JvmSpecializedTypeReference right,
			TypeConformanceComputationArgument.Internal<T> parameter) {
		TypeConformanceResult result = visit(right.getEquivalent(), parameter);
		return result;
	}
	
	@Override
	public final TypeConformanceResult doVisitTypeReference(JvmTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitTypeReference(T left, JvmTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + left + " <= " + right);
	}
	
	@Override
	public final TypeConformanceResult doVisitUnknownTypeReference(JvmUnknownTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitUnknownTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitUnknownTypeReference(T left, JvmUnknownTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public final TypeConformanceResult doVisitWildcardTypeReference(JvmWildcardTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitWildcardTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitWildcardTypeReference(T left, JvmWildcardTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitTypeReference(left, right, param);
	}
	
	@Override
	public final TypeConformanceResult doVisitMultiTypeReference(JvmMultiTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitMultiTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitMultiTypeReference(T left, JvmMultiTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		for(JvmTypeReference reference: right.getReferences()) {
			TypeConformanceResult result = visit(reference, param);
			if (result.isConformant())
				return result;
		}
		if (right.getReferences().isEmpty())
			return TypeConformanceResult.SUCCESS;
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	public final TypeConformanceResult doVisitSynonymTypeReference(JvmSynonymTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		return doVisitSynonymTypeReference(getLeft(param), right, param);
	}
	public TypeConformanceResult doVisitSynonymTypeReference(T left, JvmSynonymTypeReference right, TypeConformanceComputationArgument.Internal<T> param) {
		List<JvmTypeReference> rightComponents = right.getReferences();
		if (rightComponents.isEmpty())
			return TypeConformanceResult.FAILED;
		for(int i = 0; i < rightComponents.size(); i++) {
			TypeConformanceResult candidate = visit(rightComponents.get(i), param);
			if (candidate.isConformant()) {
				if (i == 0)
					return candidate;
				TypeConformanceResult result = TypeConformanceResult.merge(candidate, new TypeConformanceResult(TypeConformanceResult.Kind.SYNONYM));
				result.setSynonymIndex(i);
				result.setConversion(rightComponents.get(0), rightComponents.get(i));
				return result;
			}
		}
		return TypeConformanceResult.FAILED;
	}
	
}