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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.common.collect.Lists;

/**
 * Base class for resolved representation of a {@link JvmOperation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractResolvedOperation extends AbstractResolvedExecutable implements IResolvedOperation {
	
	private final JvmOperation declaration;
	private List<IResolvedOperation> validOverrides;
	private List<JvmOperation> overrideCandidates;
	private LightweightTypeReference returnType;

	protected AbstractResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType) {
		super(contextType);
		this.declaration = declaration;
	}
	
	public JvmOperation getDeclaration() {
		return declaration;
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

	public LightweightTypeReference getResolvedReturnType() {
		if (returnType != null)
			return returnType;
		return returnType = getResolvedReference(declaration.getReturnType());
	}
	
	@Override
	protected boolean isResolvedTypeParameter(JvmTypeParameter typeParameter) {
		return getResolvedTypeParameters().contains(typeParameter);
	}
	
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
	
}
