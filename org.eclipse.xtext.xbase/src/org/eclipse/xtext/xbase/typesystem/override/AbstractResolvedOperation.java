/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.common.collect.Lists;

/**
 * Base class for resolved representation of a {@link JvmOperation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractResolvedOperation extends AbstractResolvedExecutable<JvmOperation> implements IResolvedOperation {
	
	private List<IResolvedOperation> validOverrides;
	private List<JvmOperation> overrideCandidates;
	private LightweightTypeReference returnType;

	protected AbstractResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType) {
		super(declaration, contextType);
	}
	
	@Override
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
	
	/* @Nullable */
	@Override
	public IResolvedOperation getOverriddenMethod() {
		if (!getDeclaration().isAbstract() && getDeclaration().getVisibility() != JvmVisibility.PRIVATE) {
			List<IResolvedOperation> overriddenAndImplemented = getOverriddenAndImplementedMethods();
			for(IResolvedOperation candidate: overriddenAndImplemented) {
				if (!candidate.getDeclaration().isAbstract()) {
					return candidate;
				}
			}
		}
		return null;
	}
	
	@Override
	public List<LightweightTypeReference> getIllegallyDeclaredExceptions() {
		if (getDeclaration().getExceptions().isEmpty())
			return Collections.emptyList();
		List<IResolvedOperation> overriddenAndImplemented = getOverriddenAndImplementedMethods();
		if (overriddenAndImplemented.isEmpty())
			return Collections.emptyList();
		List<LightweightTypeReference> exceptions = getResolvedExceptions();
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(exceptions.size());
		for(LightweightTypeReference exception: exceptions) {
			if (!exception.isSubtypeOf(RuntimeException.class) && !exception.isSubtypeOf(Error.class)) {
				if (isIllegallyDeclaredException(exception, overriddenAndImplemented)) {
					result.add(exception);
				}
			}
		}
		return result;
	}

	protected boolean isIllegallyDeclaredException(LightweightTypeReference exception, List<IResolvedOperation> overriddenAndImplemented) {
		for(IResolvedOperation operation: overriddenAndImplemented) {
			if (operation.getOverrideCheckResult().getDetails().contains(OverrideCheckDetails.EXCEPTION_MISMATCH)) {
				List<LightweightTypeReference> inheritedExceptions = operation.getResolvedExceptions();
				if (inheritedExceptions.isEmpty()) {
					return true;
				}
				boolean isDeclared = false;
				for(LightweightTypeReference inheritedException: inheritedExceptions) {
					if (inheritedException.isAssignableFrom(exception)) {
						isDeclared = true;
						break;
					}
				}
				if (!isDeclared) {
					return true;
				}
			}
		}
		return false;
	}

	protected ResolvedOperationInHierarchy createResolvedOperationInHierarchy(JvmOperation candidate, IOverrideCheckResult checkResult) {
		ResolvedOperationInHierarchy result = new ResolvedOperationInHierarchy(candidate, getBottom());
		result.setCheckResult(checkResult);
		return result;
	}

	@Override
	public List<JvmOperation> getOverriddenAndImplementedMethodCandidates() {
		if (overrideCandidates != null)
			return overrideCandidates;
		// here we are only interested in the raw type thus the declarator is not substituted
		// the found operation will be put in the right context by clients, e.g. #getOverriddenAndImplementedMethods
		ParameterizedTypeReference currentDeclarator = getContextType().getOwner().newParameterizedTypeReference(getDeclaration().getDeclaringType());
		List<LightweightTypeReference> superTypes = currentDeclarator.getSuperTypes();
		List<JvmOperation> result = Lists.newArrayListWithCapacity(5);
		for(LightweightTypeReference superType: superTypes) {
			if (superType.getType() instanceof JvmDeclaredType) {
				JvmDeclaredType declaredSuperType = (JvmDeclaredType) superType.getType();
				if (declaredSuperType != null) {
					Iterable<JvmFeature> equallyNamedFeatures = declaredSuperType.findAllFeaturesByName(getDeclaration().getSimpleName());
					for(JvmFeature equallyNamedFeature: equallyNamedFeatures) {
						if (equallyNamedFeature instanceof JvmOperation) {
							result.add((JvmOperation) equallyNamedFeature);
						}
					}
				}
			}
		}
		return overrideCandidates = Collections.unmodifiableList(result);
	}
	
	@Override
	public IOverrideCheckResult isOverridingOrImplementing(final JvmOperation operation) {
		return getOverrideTester().isSubsignature(this, operation, true);
	}
	
	@Override
	public List<JvmTypeParameter> getResolvedTypeParameters() {
		return getBottom().getTypeParameters();
	}
	
	@Override
	public List<LightweightTypeReference> getResolvedTypeParameterConstraints(int idx) throws IndexOutOfBoundsException {
		JvmTypeParameter typeParameter = getResolvedTypeParameters().get(idx);
		List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
		List<JvmTypeReference> constraintReferences = Lists.newArrayListWithCapacity(constraints.size());
		for(JvmTypeConstraint constraint: constraints) {
			constraintReferences.add(constraint.getTypeReference());
		}
		List<LightweightTypeReference> result = getResolvedReferences(constraintReferences);
		return result;
	}

	@Override
	public LightweightTypeReference getResolvedReturnType() {
		if (returnType != null)
			return returnType;
		return returnType = getResolvedReference(getDeclaration().getReturnType());
	}
	
	@Override
	protected boolean isRawTypeInheritance() {
		if (getDeclaration().isStatic()) {
			return false;
		}
		return super.isRawTypeInheritance();
	}
	
	@Override
	protected boolean isResolvedTypeParameter(JvmTypeParameter typeParameter) {
		if (getResolvedTypeParameters().contains(typeParameter)) {
			return true;
		}
		return super.isResolvedTypeParameter(typeParameter);
	}
	
	protected abstract BottomResolvedOperation getBottom();
	
	protected OverrideTester getOverrideTester() {
		return getBottom().getOverrideTester();
	}
	
}
