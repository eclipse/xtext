/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.InnerFunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocalTypeSubstitutor extends TypeReferenceVisitorWithParameterAndResult<VarianceInfo, LocalTypeSubstitutor.SubstitutionResult> {
	
	static class SubstitutionResult {
		final LightweightTypeReference typeReference;
		final boolean didSubstitute;
		SubstitutionResult(LightweightTypeReference typeReference, boolean didSubstitute) {
			this.typeReference = typeReference;
			this.didSubstitute = didSubstitute;
		}
	}
	
	private final ITypeReferenceOwner owner;
	private final JvmIdentifiableElement boundary;

	public LocalTypeSubstitutor(ITypeReferenceOwner owner, JvmIdentifiableElement boundary) {
		this.owner = owner;
		this.boundary = boundary;
	}
	
	protected ITypeReferenceOwner getOwner() {
		return owner;
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitFunctionTypeReference(FunctionTypeReference reference, VarianceInfo varianceInfo) {
		FunctionTypeReference result = owner.newFunctionTypeReference(reference.getType());
		return doSubstituteFunctionType(reference, result, false);
	}

	protected LocalTypeSubstitutor.SubstitutionResult doSubstituteFunctionType(FunctionTypeReference reference, FunctionTypeReference result,
			boolean didSubstitute) {
		for(LightweightTypeReference parameterType: reference.getParameterTypes()) {
			SubstitutionResult visited = visitTypeArgument(parameterType, VarianceInfo.IN);
			didSubstitute = didSubstitute || visited.didSubstitute;
			result.addParameterType(visited.typeReference);
		}
		for(LightweightTypeReference typeArgument: reference.getTypeArguments()) {
			SubstitutionResult visited = visitTypeArgument(typeArgument, VarianceInfo.INVARIANT);
			didSubstitute = didSubstitute || visited.didSubstitute;
			result.addTypeArgument(visited.typeReference);
		}
		LightweightTypeReference returnType = reference.getReturnType();
		if (returnType != null) {
			SubstitutionResult visited = visitTypeArgument(returnType, VarianceInfo.OUT);
			didSubstitute = didSubstitute || visited.didSubstitute;
			result.setReturnType(visited.typeReference);
		}
		return new SubstitutionResult(result, didSubstitute);
	}
	
	@Override
	protected SubstitutionResult doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference, VarianceInfo varianceInfo) {
		SubstitutionResult visitedOuter = reference.getOuter().accept(this, varianceInfo);
		InnerFunctionTypeReference result = owner.newFunctionTypeReference(visitedOuter.typeReference, reference.getType());
		return doSubstituteFunctionType(reference, result, visitedOuter.didSubstitute);
	}

	protected LocalTypeSubstitutor.SubstitutionResult visitTypeArgument(LightweightTypeReference reference, VarianceInfo varianceInfo) {
		return reference.accept(this, varianceInfo);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitParameterizedTypeReference(ParameterizedTypeReference reference, VarianceInfo varianceInfo) {
		JvmType type = reference.getType();
		if (!(type instanceof JvmTypeParameter) && EcoreUtil.isAncestor(boundary, type)) {
			SubstitutionResult visited = reference.getSuperTypes().get(0).accept(this, varianceInfo);
			switch(varianceInfo) {
				case IN:
				case OUT:
					return new SubstitutionResult(visited.typeReference, true);
				case INVARIANT:
					WildcardTypeReference wc = owner.newWildcardTypeReference();
					wc.addUpperBound(visited.typeReference);
					return new SubstitutionResult(wc, true);
				default:
					throw new IllegalStateException();
				
			}
		}
		ParameterizedTypeReference result = owner.newParameterizedTypeReference(reference.getType());
		boolean didSubstitute = false;
		for(LightweightTypeReference argument: reference.getTypeArguments()) {
			SubstitutionResult visited = visitTypeArgument(argument, VarianceInfo.INVARIANT);
			result.addTypeArgument(visited.typeReference);
			didSubstitute = didSubstitute || visited.didSubstitute;
		}
		if (didSubstitute) {
			switch(varianceInfo) {
				case IN:
				case OUT:
					return new SubstitutionResult(result, true);
				case INVARIANT:
					WildcardTypeReference wc = owner.newWildcardTypeReference();
					wc.addUpperBound(result);
					return new SubstitutionResult(wc, true);
				default:
					throw new IllegalStateException();
				
			}
		}
		return new SubstitutionResult(reference, false);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitWildcardTypeReference(WildcardTypeReference reference, VarianceInfo varianceInfo) {
		WildcardTypeReference result = owner.newWildcardTypeReference();
		LightweightTypeReference lowerBound = reference.getLowerBound();
		boolean didSubstitute = false;
		if (lowerBound != null) {
			SubstitutionResult visited = lowerBound.accept(this, VarianceInfo.IN);
			result.setLowerBound(visited.typeReference);
			didSubstitute = didSubstitute || visited.didSubstitute;
		} 
		for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
			SubstitutionResult visited = upperBound.accept(this, VarianceInfo.OUT);
			result.addUpperBound(visited.typeReference);
			didSubstitute = didSubstitute || visited.didSubstitute;
		}
		if (result.getUpperBounds().isEmpty()) {
			throw new IllegalStateException("UpperBounds may not be empty");
		}
		return new SubstitutionResult(result, didSubstitute);
	}
	
	@Override
	protected SubstitutionResult doVisitInnerTypeReference(InnerTypeReference reference, VarianceInfo varianceInfo) {
		JvmType type = reference.getType();
		if (!(type instanceof JvmTypeParameter) && EcoreUtil.isAncestor(boundary, type)) {
			SubstitutionResult visited = reference.getSuperTypes().get(0).accept(this, varianceInfo);
			switch(varianceInfo) {
				case IN:
				case OUT:
					return new SubstitutionResult(visited.typeReference, true);
				case INVARIANT:
					WildcardTypeReference wc = owner.newWildcardTypeReference();
					wc.addUpperBound(visited.typeReference);
					return new SubstitutionResult(wc, true);
				default:
					throw new IllegalStateException();
				
			}
		}
		
		SubstitutionResult visitedOuter = reference.getOuter().accept(this, varianceInfo);
		InnerTypeReference result = owner.newParameterizedTypeReference(visitedOuter.typeReference, reference.getType());
		boolean didSubstitute = visitedOuter.didSubstitute;
		for(LightweightTypeReference argument: reference.getTypeArguments()) {
			SubstitutionResult visited = visitTypeArgument(argument, VarianceInfo.INVARIANT);
			result.addTypeArgument(visited.typeReference);
			didSubstitute = didSubstitute || visited.didSubstitute;
		}
		if (didSubstitute) {
			switch(varianceInfo) {
				case IN:
				case OUT:
					return new SubstitutionResult(result, true);
				case INVARIANT:
					WildcardTypeReference wc = owner.newWildcardTypeReference();
					wc.addUpperBound(result);
					return new SubstitutionResult(wc, true);
				default:
					throw new IllegalStateException();
				
			}
		}
		return new SubstitutionResult(reference, false);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitArrayTypeReference(ArrayTypeReference reference, VarianceInfo varianceInfo) {
		SubstitutionResult visited = reference.getComponentType().accept(this, varianceInfo);
		if (visited.didSubstitute) {
			return new SubstitutionResult(owner.newArrayTypeReference(visited.typeReference), true);
		}
		return new SubstitutionResult(reference, false);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitTypeReference(LightweightTypeReference reference, VarianceInfo param) {
		return new SubstitutionResult(reference, false);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitCompoundTypeReference(CompoundTypeReference reference, VarianceInfo varianceInfo) {
		CompoundTypeReference result = owner.newCompoundTypeReference(reference.isSynonym());
		boolean didSubstitute = false;
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			SubstitutionResult visited = visitTypeArgument(component, varianceInfo);
			result.addComponent(visited.typeReference);
			didSubstitute = didSubstitute || visited.didSubstitute;
		}
		return new SubstitutionResult(result, didSubstitute);
	}

	public LightweightTypeReference withoutLocalTypes(LightweightTypeReference original) {
		return original.accept(this, VarianceInfo.OUT).typeReference;
	}
	
}