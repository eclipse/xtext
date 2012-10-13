/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndNonNullResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 * TODO implement as member function on LightweightTypeReference
 */
@NonNullByDefault
public abstract class TypeParameterSubstitutor<Visiting> extends TypeReferenceVisitorWithParameterAndNonNullResult<Visiting, LightweightTypeReference> {
		
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
		FunctionTypeReference result = new FunctionTypeReference(getOwner(), reference.getType());
		for(LightweightTypeReference parameterType: reference.getParameterTypes()) {
			result.addParameterType(visitTypeArgument(parameterType, visiting));
		}
		for(LightweightTypeReference typeArgument: reference.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(typeArgument, visiting));
		}
		LightweightTypeReference returnType = reference.getReturnType();
		if (returnType != null) {
			result.setReturnType(visitTypeArgument(returnType, visiting));
		}
		return result;
	}

	protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, Visiting visiting) {
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
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), reference.getType());
		for(LightweightTypeReference argument: reference.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(argument, visiting));
		}
		return result;
	}

	@Nullable
	protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type,
			Visiting visiting) {
		LightweightMergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(type);
		if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
			return boundTypeArgument.getTypeReference().accept(this, visiting);
		}
		return null;
	}
		
	@Override
	protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		WildcardTypeReference result = new WildcardTypeReference(getOwner());
		LightweightTypeReference lowerBound = reference.getLowerBound();
		if (lowerBound != null) {
			result.setLowerBound(visitTypeArgument(lowerBound, visiting));
		}
		for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
			result.addUpperBound(visitTypeArgument(upperBound, visiting));
		}
		return result;
	}
	
	@Override
	protected LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		LightweightTypeReference component = visitTypeArgument(reference.getComponentType(), visiting);
		return new ArrayTypeReference(getOwner(), component);
	}
	
	@Override
	protected LightweightTypeReference doVisitAnyTypeReference(AnyTypeReference reference, Visiting visiting) {
		return reference;
	}
	
	@Override
	protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		CompoundTypeReference result = new CompoundTypeReference(getOwner(), reference.isSynonym());
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			reference.addComponent(visitTypeArgument(component, visiting));
		}
		return result;
	}

	public LightweightTypeReference substitute(LightweightTypeReference original) {
		if (typeParameterMapping.isEmpty())
			return original;
		return original.accept(this, createVisiting());
	}
	
	protected abstract Visiting createVisiting();
	
	protected LightweightTypeReference copy(LightweightTypeReference reference) {
		return reference.copyInto(getOwner());
	}
}