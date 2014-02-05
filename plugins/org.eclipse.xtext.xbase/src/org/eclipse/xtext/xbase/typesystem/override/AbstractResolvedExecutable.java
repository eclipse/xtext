/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Lists;

/**
 * Base class for resolved representation of a {@link JvmExecutable}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractResolvedExecutable implements IResolvedExecutable {

	private final LightweightTypeReference contextType;
	private List<LightweightTypeReference> parameterTypes;
	private List<LightweightTypeReference> declaredExceptions;
	
	protected AbstractResolvedExecutable(LightweightTypeReference contextType) {
		this.contextType = contextType;
	}
	
	public LightweightTypeReference getContextType() {
		return contextType;
	}
	
	public LightweightTypeReference getResolvedDeclarator() {
		JvmExecutable declaration = getDeclaration();
		JvmDeclaredType declarator = declaration.getDeclaringType();
		return getContextType().getSuperType(declarator);
	}
	
	public List<JvmTypeParameter> getTypeParameters() {
		return Collections.unmodifiableList(getDeclaration().getTypeParameters());
	}
	
	public List<LightweightTypeReference> getResolvedParameterTypes() {
		JvmExecutable declaration = getDeclaration();
		if (declaration.getParameters().isEmpty())
			return Collections.emptyList();
		if (parameterTypes != null)
			return parameterTypes;
		List<JvmFormalParameter> parameters = declaration.getParameters();
		List<JvmTypeReference> unresolvedParameterTypes = Lists.newArrayListWithCapacity(parameters.size());
		for(JvmFormalParameter parameter: parameters) {
			unresolvedParameterTypes.add(parameter.getParameterType());
		}
		return parameterTypes = getResolvedReferences(unresolvedParameterTypes);
	}
	
	public String getResolvedErasureSignature() {
		JvmExecutable declaration = getDeclaration();
		List<LightweightTypeReference> parameterTypes = getResolvedParameterTypes();
		StringBuilder result = new StringBuilder(declaration.getSimpleName().length() + 2 + 20 * parameterTypes.size());
		result.append(declaration.getSimpleName());
		result.append('(');
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(',');
			}
			result.append(parameterTypes.get(i).getRawTypeReference().getJavaIdentifier());
		}
		result.append(')');
		return result.toString();
	}
	
	public String getResolvedSignature() {
		JvmExecutable declaration = getDeclaration();
		List<LightweightTypeReference> parameterTypes = getResolvedParameterTypes();
		StringBuilder result = new StringBuilder(declaration.getSimpleName().length() + 2 + 30 * parameterTypes.size());
		result.append(declaration.getSimpleName());
		result.append('(');
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(',');
			}
			result.append(parameterTypes.get(i).getJavaIdentifier());
		}
		result.append(')');
		return result.toString();
	}
	
	public String getSimpleSignature() {
		JvmExecutable declaration = getDeclaration();
		List<LightweightTypeReference> parameterTypes = getResolvedParameterTypes();
		StringBuilder result = new StringBuilder(declaration.getSimpleName().length() + 2 + 10 * parameterTypes.size());
		result.append(declaration.getSimpleName());
		result.append('(');
		for(int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(", ");
			}
			result.append(parameterTypes.get(i).getSimpleName());
		}
		result.append(')');
		return result.toString();
	}
	
	protected LightweightTypeReference getResolvedReference(@Nullable JvmTypeReference unresolved) {
		if (unresolved == null) {
			ITypeReferenceOwner owner = getContextType().getOwner();
			JvmType objectType = owner.getServices().getTypeReferences().findDeclaredType(Object.class, owner.getContextResourceSet());
			return new ParameterizedTypeReference(owner, objectType);
		}
		OwnedConverter converter = new OwnedConverter(getContextType().getOwner());
		LightweightTypeReference unresolvedLightweight = converter.toLightweightReference(unresolved);
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

	public List<LightweightTypeReference> getResolvedExceptions() {
		JvmExecutable declaration = getDeclaration();
		if (declaration.getExceptions().isEmpty())
			return Collections.emptyList();
		if (declaredExceptions != null)
			return declaredExceptions;
		return declaredExceptions = getResolvedReferences(declaration.getExceptions());
	}
	
	protected abstract Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping();
	
	/**
	 * Allows to refuse a certain type parameter to be substituted.
	 * @param typeParameter the type parameter that should be substituted.
	 * @return <code>false</code> if the parameter may be substituted. <code>true</code> if it should be preserved.
	 */
	protected boolean isResolvedTypeParameter(JvmTypeParameter typeParameter) {
		return false;
	}
	
	protected TypeParameterSubstitutor<?> getSubstitutor() {
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
			@Nullable
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
	
	@Override
	public String toString() {
		return String.format("%s in context of %s", getDeclaration().getIdentifier(), getContextType().getSimpleName());
	}
}
