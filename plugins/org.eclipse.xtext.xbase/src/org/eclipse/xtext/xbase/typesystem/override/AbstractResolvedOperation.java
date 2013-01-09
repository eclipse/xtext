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
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Lists;

/**
 * Base class for resolved representation of a {@link JvmOperation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractResolvedOperation implements IResolvedOperation {
	
	private JvmOperation declaration;
	private LightweightTypeReference contextType;
	private List<IResolvedOperation> validOverrides;
	private List<JvmOperation> overrideCandidates;
	private List<LightweightTypeReference> parameterTypes;
	private LightweightTypeReference returnType;
	private List<LightweightTypeReference> declaredExceptions;

	protected AbstractResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType) {
		this.declaration = declaration;
		this.contextType = contextType;
	}
	
	public JvmOperation getDeclaration() {
		return declaration;
	}
	
	public LightweightTypeReference getContextType() {
		return contextType;
	}

	public List<IResolvedOperation> getOverriddenAndImplementedMethods() {
		if (validOverrides != null)
			return validOverrides;
		List<JvmOperation> candidates = getOverriddenAndImplementedMethodCandidates();
		if (candidates.isEmpty())
			return Collections.emptyList();
		List<IResolvedOperation> result = Lists.newArrayListWithCapacity(candidates.size());
		for(JvmOperation candidate: candidates) {
			// we know that our candidates are computed from the hierarchy
			// thus there is no need to check the declarator for inheritance
			IOverrideCheckResult checkResult = getOverrideTester().isSubsignature(this, candidate, false);
			if (checkResult.isOverridingOrImplementing()) {
				result.add(createResolvedOperationInHierarchy(candidate, checkResult));
			}
		}
		return validOverrides = Collections.unmodifiableList(result);
	}
	
	@Nullable
	public IResolvedOperation getOverriddenMethod() {
		if (!declaration.isAbstract() && declaration.getVisibility() != JvmVisibility.PRIVATE) {
			List<IResolvedOperation> overriddenAndImplemented = getOverriddenAndImplementedMethods();
			for(IResolvedOperation candidate: overriddenAndImplemented) {
				if (!candidate.getDeclaration().isAbstract()) {
					return candidate;
				}
			}
		}
		return null;
	}

	protected ResolvedOperationInHierarchy createResolvedOperationInHierarchy(JvmOperation candidate, IOverrideCheckResult checkResult) {
		ResolvedOperationInHierarchy result = new ResolvedOperationInHierarchy(candidate, getBottom());
		result.setCheckResult(checkResult);
		return result;
	}

	public List<JvmOperation> getOverriddenAndImplementedMethodCandidates() {
		if (overrideCandidates != null)
			return overrideCandidates;
		// here we are only interested in the raw type thus the declarator is not substituted
		// the found operation will be put in the right context by clients, e.g. #getOverriddenAndImplementedMethods
		ParameterizedTypeReference currentDeclarator = new ParameterizedTypeReference(getContextType().getOwner(), declaration.getDeclaringType());
		List<LightweightTypeReference> superTypes = currentDeclarator.getSuperTypes();
		List<JvmOperation> result = Lists.newArrayListWithCapacity(5);
		for(LightweightTypeReference superType: superTypes) {
			JvmDeclaredType declaredSuperType = (JvmDeclaredType) superType.getType();
			if (declaredSuperType != null) {
				Iterable<JvmFeature> equallyNamedFeatures = declaredSuperType.findAllFeaturesByName(declaration.getSimpleName());
				for(JvmFeature equallyNamedFeature: equallyNamedFeatures) {
					if (equallyNamedFeature instanceof JvmOperation) {
						result.add((JvmOperation) equallyNamedFeature);
					}
				}
			}
		}
		return overrideCandidates = Collections.unmodifiableList(result);
	}
	
	public IOverrideCheckResult isOverridingOrImplementing(final JvmOperation operation) {
		return getOverrideTester().isSubsignature(this, operation, true);
	}
	
	public List<JvmTypeParameter> getResolvedTypeParameters() {
		return getBottom().getTypeParameters();
	}

	public List<JvmTypeParameter> getTypeParameters() {
		return Collections.unmodifiableList(declaration.getTypeParameters());
	}

	public List<LightweightTypeReference> getParameterTypes() {
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
		List<LightweightTypeReference> parameterTypes = getParameterTypes();
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
		List<LightweightTypeReference> parameterTypes = getParameterTypes();
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
		List<LightweightTypeReference> parameterTypes = getParameterTypes();
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

	public LightweightTypeReference getResolvedReturnType() {
		if (returnType != null)
			return returnType;
		return returnType = getResolvedReference(declaration.getReturnType());
	}
	
	protected LightweightTypeReference getResolvedReference(JvmTypeReference unresolved) {
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

	public List<LightweightTypeReference> getDeclaredExceptions() {
		if (declaration.getExceptions().isEmpty())
			return Collections.emptyList();
		if (declaredExceptions != null)
			return declaredExceptions;
		return declaredExceptions = getResolvedReferences(declaration.getExceptions());
	}
	
	protected TypeParameterSubstitutor<?> getSubstitutor() {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = getContextTypeParameterMapping();
		JvmType contextType = getContextType().getType();
		final List<JvmTypeParameter> originalTypeParameters;
		if (contextType instanceof JvmGenericType) {
			List<JvmTypeParameter> declared = ((JvmGenericType) contextType).getTypeParameters();
			if (declared.isEmpty() || getContextType().isRawType()) {
				originalTypeParameters = Collections.emptyList();
			} else {
				originalTypeParameters = Lists.newArrayListWithCapacity(declared.size());
				for(LightweightTypeReference argument: getContextType().getTypeArguments()) {
					if (declared.contains(argument.getType())) {
						originalTypeParameters.add((JvmTypeParameter) argument.getType());
					}
				}
			}
		} else {
			originalTypeParameters = Collections.emptyList();
		}
		TypeParameterSubstitutor<?> result = new TypeParameterByConstraintSubstitutor(mapping, getContextType().getOwner()) {
			@Override
			protected boolean isDeclaredTypeParameter(JvmTypeParameter typeParameter) {
				return super.isDeclaredTypeParameter(typeParameter) 
						|| getResolvedTypeParameters().contains(typeParameter) 
						|| originalTypeParameters.contains(typeParameter);
			}
			@Override
			@Nullable
			protected LightweightMergedBoundTypeArgument getBoundTypeArgument(JvmTypeParameter type,
					ConstraintVisitingInfo info) {
				if (isDeclaredTypeParameter(type))
					return null;
				return super.getBoundTypeArgument(type, info);
			}
		};
		return result;
	}
	
	protected abstract Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping();
	
	protected abstract BottomResolvedOperation getBottom();
	
	protected OverrideTester getOverrideTester() {
		return getBottom().getOverrideTester();
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
	
	@Override
	public String toString() {
		return String.format("%s in context of %s", declaration.getIdentifier(), getContextType().getSimpleName());
	}
}
