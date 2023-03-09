/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.InnerFunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndResult;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 * TODO implement as member function on LightweightTypeReference
 */
public abstract class TypeParameterSubstitutor<Visiting> extends TypeReferenceVisitorWithParameterAndResult<Visiting, LightweightTypeReference> {
		
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	private final ITypeReferenceOwner owner;

	public TypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping, ITypeReferenceOwner owner) {
		this.owner = owner;
		this.typeParameterMapping = Maps.newLinkedHashMap(typeParameterMapping);
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	public void enhanceMapping(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping) {
		this.typeParameterMapping.putAll(typeParameterMapping);
	}
	
	protected ITypeReferenceOwner getOwner() {
		return owner;
	}
	
	@Override
	protected LightweightTypeReference doVisitFunctionTypeReference(FunctionTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		FunctionTypeReference result = getOwner().newFunctionTypeReference(reference.getType());
		enhanceFunctionType(reference, result, visiting);
		return result;
	}

	protected void enhanceFunctionType(FunctionTypeReference reference, FunctionTypeReference result, Visiting visiting) {
		for(LightweightTypeReference parameterType: reference.getParameterTypes()) {
			result.addParameterType(visitTypeArgument(parameterType, visiting, true));
		}
		for(LightweightTypeReference typeArgument: reference.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(typeArgument, visiting));
		}
		LightweightTypeReference returnType = reference.getReturnType();
		if (returnType != null) {
			result.setReturnType(visitTypeArgument(returnType, visiting));
		}
	}
	
	@Override
	protected LightweightTypeReference doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		LightweightTypeReference outer = reference.getOuter().accept(this, visiting);
		InnerFunctionTypeReference result = getOwner().newFunctionTypeReference(outer, reference.getType());
		enhanceFunctionType(reference, result, visiting);
		return result;
	}

	/**
	 * This is equivalent to {@code visitTypeArgument(reference, visiting, false)}.
	 * 
	 * @see #visitTypeArgument(LightweightTypeReference, Object, boolean)
	 */
	protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, Visiting visiting) {
		return visitTypeArgument(reference, visiting, false);
	}
	
	/**
	 * @param lowerBound if the given reference was used as the lower bound of a wildcard
	 */
	protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, Visiting visiting, boolean lowerBound) {
		return reference.accept(this, visiting);
	}
	
	@Override
	protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			LightweightTypeReference boundTypeArgument = getBoundTypeArgument(reference, (JvmTypeParameter) type, visiting);
			if (boundTypeArgument != null)
				return boundTypeArgument;
		}
		return doVisitParameterizedTypeReference(reference, type, visiting);
	}
	
	@Override
	protected LightweightTypeReference doVisitInnerTypeReference(InnerTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		
		LightweightTypeReference outer = reference.getOuter().accept(this, visiting);
		ParameterizedTypeReference result = getOwner().newParameterizedTypeReference(outer, reference.getType());
		for(LightweightTypeReference argument: reference.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(argument, visiting));
		}
		return result;
	}
	
	protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, JvmType type, Visiting visiting) {
		ParameterizedTypeReference result = getOwner().newParameterizedTypeReference(type);
		return enhanceParameterizedTypeReference(reference, type, result, visiting);
	}

	/**
	 * @param type the type of the reference. May be used by subtypes. 
	 */
	protected LightweightTypeReference enhanceParameterizedTypeReference(ParameterizedTypeReference origin, JvmType type, ParameterizedTypeReference result, Visiting visiting) {
		for(LightweightTypeReference argument: origin.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(argument, visiting));
		}
		return result;
	}

	/* @Nullable */
	protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type,
			Visiting visiting) {
		LightweightMergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(type);
		if (boundTypeArgument != null) {
			LightweightTypeReference boundReference = boundTypeArgument.getTypeReference();
			if (boundReference != null && reference != boundReference && boundReference.getType() != type) {
				return boundReference.accept(this, visiting);
			}
		}
		return null;
	}
	
	@Override
	protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		WildcardTypeReference result = getOwner().newWildcardTypeReference();
		LightweightTypeReference lowerBound = reference.getLowerBound();
		if (lowerBound != null) {
			LightweightTypeReference visited = visitTypeArgument(lowerBound, visiting, true);
			if (visited.isWildcard()) {
				LightweightTypeReference lowerBoundSubstitute = visited.getLowerBoundSubstitute();
				if (lowerBoundSubstitute.isAny()) {
					result.addUpperBound(getOwner().newReferenceToObject());
					return result;
				} else {
					result.setLowerBound(lowerBoundSubstitute);
				}
			} else {
				result.setLowerBound(visited.copyInto(result.getOwner()));
			}
		} 
		for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
			LightweightTypeReference visitedArgument = visitTypeArgument(upperBound, visiting);
			LightweightTypeReference upperBoundSubstitute = visitedArgument.getUpperBoundSubstitute();
			result.addUpperBound(upperBoundSubstitute);
		}
		if (result.getUpperBounds().isEmpty()) {
			throw new IllegalStateException("UpperBounds may not be empty");
		}
		return result;
	}
	
	@Override
	protected LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		LightweightTypeReference component = visitTypeArgument(reference.getComponentType(), visiting);
		component = component.getUpperBoundSubstitute();
		return getOwner().newArrayTypeReference(component);
	}
	
	@Override
	protected LightweightTypeReference doVisitAnyTypeReference(AnyTypeReference reference, Visiting visiting) {
		return reference;
	}
	
	@Override
	protected LightweightTypeReference doVisitUnknownTypeReference(UnknownTypeReference reference, Visiting param) {
		return reference;
	}
	
	@Override
	protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		CompoundTypeReference result = getOwner().newCompoundTypeReference(reference.isSynonym());
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			result.addComponent(visitTypeArgument(component, visiting));
		}
		return result;
	}

	public LightweightTypeReference substitute(LightweightTypeReference original) {
		if (typeParameterMapping.isEmpty())
			return original;
		return original.accept(this, createVisiting());
	}
	
	public LightweightTypeReference substitute(JvmTypeReference original) {
		LightweightTypeReference lightweightReference = getOwner().toLightweightTypeReference(original);
		return substitute(lightweightReference);
	}
	
	protected abstract Visiting createVisiting();
	
	protected LightweightTypeReference copy(LightweightTypeReference reference) {
		return reference.copyInto(getOwner());
	}
	
	@Override
	public String toString() {
		return String.format("%s with mapping: %s", getClass().getSimpleName(), getTypeParameterMapping());
	}
}