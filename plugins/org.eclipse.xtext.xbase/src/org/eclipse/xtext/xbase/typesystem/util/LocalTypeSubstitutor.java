/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndNonNullResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class LocalTypeSubstitutor extends TypeReferenceVisitorWithParameterAndNonNullResult<VarianceInfo, LocalTypeSubstitutor.SubstitutionResult> {
	
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
		FunctionTypeReference result = new FunctionTypeReference(getOwner(), reference.getType());
		boolean didSubstitute = false;
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
					WildcardTypeReference wc = new WildcardTypeReference(owner);
					wc.addUpperBound(visited.typeReference);
					return new SubstitutionResult(wc, true);
				default:
					throw new IllegalStateException();
				
			}
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), reference.getType());
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
					WildcardTypeReference wc = new WildcardTypeReference(owner);
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
		WildcardTypeReference result = new WildcardTypeReference(getOwner());
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
	protected LocalTypeSubstitutor.SubstitutionResult doVisitArrayTypeReference(ArrayTypeReference reference, VarianceInfo varianceInfo) {
		SubstitutionResult visited = reference.getComponentType().accept(this, varianceInfo);
		if (visited.didSubstitute) {
			new SubstitutionResult(new ArrayTypeReference(getOwner(), visited.typeReference), true);
		}
		return new SubstitutionResult(reference, false);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitTypeReference(LightweightTypeReference reference, VarianceInfo param) {
		return new SubstitutionResult(reference, false);
	}
	
	@Override
	protected LocalTypeSubstitutor.SubstitutionResult doVisitCompoundTypeReference(CompoundTypeReference reference, VarianceInfo varianceInfo) {
		CompoundTypeReference result = new CompoundTypeReference(getOwner(), reference.isSynonym());
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