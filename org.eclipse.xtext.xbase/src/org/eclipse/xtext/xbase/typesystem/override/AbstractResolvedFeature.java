/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.RawTypeSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResolvedFeature<T extends JvmFeature> implements IResolvedFeature {

	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	private final LightweightTypeReference contextType;
	private final T declaration;

	public AbstractResolvedFeature(T declaration, LightweightTypeReference contextType) {
		this.contextType = contextType;
		this.declaration = declaration;
	}
	
	@Override
	public T getDeclaration() {
		return declaration;
	}
	
	@Override
	public LightweightTypeReference getContextType() {
		return contextType;
	}
	
	@Override
	public LightweightTypeReference getResolvedDeclarator() {
		JvmFeature declaration = getDeclaration();
		JvmDeclaredType declarator = declaration.getDeclaringType();
		return getContextType().getSuperType(declarator);
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping() {
		if (typeParameterMapping != null)
			return typeParameterMapping;
		return typeParameterMapping = Collections.unmodifiableMap(computeContextTypeParameterMapping());
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> computeContextTypeParameterMapping() {
		if (getDeclaration().isStatic() && !(getDeclaration() instanceof JvmConstructor)) {
			return Collections.emptyMap();
		}
		return new DeclaratorTypeArgumentCollector().getTypeParameterMapping(getContextType());
	}

	protected LightweightTypeReference getResolvedReference(/* @Nullable */ JvmTypeReference unresolved) {
		ITypeReferenceOwner owner = getContextType().getOwner();
		if (unresolved == null) {
			return owner.newReferenceToObject();
		}
		LightweightTypeReference unresolvedLightweight = owner.toLightweightTypeReference(unresolved);
		if (unresolvedLightweight.isPrimitive() || unresolvedLightweight.isPrimitiveVoid())
			return unresolvedLightweight;
		TypeParameterSubstitutor<?> substitutor = getSubstitutor();
		LightweightTypeReference result = substitutor.substitute(unresolvedLightweight);
		return result;
	}

	protected List<LightweightTypeReference> getResolvedReferences(List<JvmTypeReference> unresolved) {
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(unresolved.size());
		for(JvmTypeReference resolveMe: unresolved) {
			result.add(getResolvedReference(resolveMe));
		}
		return result;
	}

	/**
	 * Allows to refuse a certain type parameter to be substituted.
	 * @param typeParameter the type parameter that should be substituted.
	 * @return <code>false</code> if the parameter may be substituted. <code>true</code> if it should be preserved.
	 */
	protected boolean isResolvedTypeParameter(JvmTypeParameter typeParameter) {
		return isResolvedTypeParameter(getContextType(), typeParameter);
	}

	protected boolean isResolvedTypeParameter(LightweightTypeReference typeReference, JvmTypeParameter typeParameter) {
		List<LightweightTypeReference> typeArguments = typeReference.getTypeArguments();
		for(int i = 0, size = typeArguments.size(); i < size; i++) {
			LightweightTypeReference typeArgument = typeArguments.get(i);
			if (typeParameter.equals(typeArgument.getType()) || isResolvedTypeParameter(typeArgument, typeParameter)) {
				return true;
			}
		}
		LightweightTypeReference outer = typeReference.getOuter();
		if (outer != null) {
			if (isResolvedTypeParameter(outer, typeParameter)) {
				return true;
			}
		}
		return false;
	}

	protected TypeParameterSubstitutor<?> getSubstitutor() {
		if (getContextType().getType() != getDeclaration().getDeclaringType()) {
			if (isRawTypeInheritance()) {
				return new RawTypeSubstitutor(getContextType().getOwner());
			}
		}
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = getContextTypeParameterMapping();
		TypeParameterSubstitutor<?> result = new TypeParameterByConstraintSubstitutor(mapping, getContextType().getOwner()) {
			@Override
			protected boolean isDeclaredTypeParameter(JvmTypeParameter typeParameter) {
				if (super.isDeclaredTypeParameter(typeParameter) 
						|| isResolvedTypeParameter(typeParameter)
						|| getTypeParameterMapping().containsKey(typeParameter))
					return true;
				return false;
			}
			@Override
			/* @Nullable */
			protected LightweightMergedBoundTypeArgument getBoundTypeArgument(JvmTypeParameter type,
					ConstraintVisitingInfo info) {
				LightweightMergedBoundTypeArgument result = super.getBoundTypeArgument(type, info);
				if (result != null && result.getTypeReference().getType() == type) {
					return null;
				}
				return result; 
			}
		};
		return result;
	}

	protected boolean isRawTypeInheritance() {
		List<LightweightTypeReference> superTypes = getContextType().getAllSuperTypes();
		JvmDeclaredType declaringType = getDeclaration().getDeclaringType();
		for(LightweightTypeReference superType: superTypes) {
			if (superType.getType() == declaringType && superType.isRawType()) {
				return true;
			}
		}
		return false;
	}
}
