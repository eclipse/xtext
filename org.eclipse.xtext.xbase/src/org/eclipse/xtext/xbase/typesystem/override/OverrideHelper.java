/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Utilities to deal with overridden or implemented operations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class OverrideHelper {

	@Inject
	private IVisibilityHelper visibilityHelper;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private OverrideTester overrideTester;
	
	/**
	 * Returns <code>null</code> if the given operation declares it's own return type or if it does not override
	 * another operation.
	 * 
	 * TODO support this case:
	 * 
	 * <pre>
	 * interface I {
	 *   String m()
	 *   String m2()
	 * }
	 * class A {
	 *   CharSequence m()
	 *   int m2()
	 * }
	 * class B extends A implements I {
	 *   m() will expect String since this is the best choice
	 *   m2() will expect int since this is actually overridden and not compatible to String from I#m2
	 * }
	 * </pre>
	 */
	/* @Nullable */
	public LightweightTypeReference getReturnTypeOfOverriddenOperation(JvmOperation operation, ITypeReferenceOwner owner, IVisibilityHelper visibilityHelper) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE || !InferredTypeIndicator.isInferred(operation.getReturnType())) {
			return null;
		}
		LightweightTypeReference declaringType = owner.newParameterizedTypeReference(operation.getDeclaringType());
		TypeParameterSubstitutor<?> substitutor = createSubstitutor(owner, declaringType);
		JvmOperation overriddenOperation = findOverriddenOperation(operation, declaringType, substitutor, owner, visibilityHelper);
		if (overriddenOperation != null) {
			return substitutor.substitute(owner.toLightweightTypeReference(overriddenOperation.getReturnType()));
		}
		return null;
	}
	
	/**
	 * Returns <code>null</code> if the given operation declares it's own return type or if it does not override
	 * another operation.
	 * 
	 * TODO support this case:
	 * 
	 * <pre>
	 * interface I {
	 *   String m()
	 *   String m2()
	 * }
	 * class A {
	 *   CharSequence m()
	 *   int m2()
	 * }
	 * class B extends A implements I {
	 *   m() will expect String since this is the best choice
	 *   m2() will expect int since this is actually overridden and not compatible to String from I#m2
	 * }
	 * </pre>
	 */
	/* @Nullable */
	public LightweightTypeReference getReturnTypeOfOverriddenOperation(JvmOperation operation, LightweightTypeReference context) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE || !InferredTypeIndicator.isInferred(operation.getReturnType())) {
			return null;
		}
		BottomResolvedOperation resolvedOperation = new BottomResolvedOperation(operation, context, overrideTester);
		List<IResolvedOperation> overriddenMethods = resolvedOperation.getOverriddenAndImplementedMethods();
		if (overriddenMethods.isEmpty())
			return null;
		LightweightTypeReference result = overriddenMethods.get(0).getResolvedReturnType();
		return result;
	}

	/* @Nullable */
	protected JvmOperation findOverriddenOperation(JvmOperation operation, LightweightTypeReference declaringType,
			TypeParameterSubstitutor<?> substitutor, ITypeReferenceOwner owner, IVisibilityHelper visibilityHelper) {
		int parameterSize = operation.getParameters().size();
		List<LightweightTypeReference> superTypes = declaringType.getSuperTypes();
		for(LightweightTypeReference superType: superTypes) {
			if (superType.getType() instanceof JvmDeclaredType) {
				JvmDeclaredType declaredSuperType = (JvmDeclaredType) superType.getType();
				if (declaredSuperType != null) {
					Iterable<JvmFeature> equallyNamedFeatures = declaredSuperType.findAllFeaturesByName(operation.getSimpleName());
					for(JvmFeature feature: equallyNamedFeatures) {
						if (feature instanceof JvmOperation) {
							JvmOperation candidate = (JvmOperation) feature;
							if (parameterSize == candidate.getParameters().size()) {
								if (visibilityHelper.isVisible(feature)) {
									boolean matchesSignature = true;
									for(int i = 0; i < parameterSize && matchesSignature; i++) {
										JvmFormalParameter parameter = operation.getParameters().get(i);
										JvmFormalParameter candidateParameter = candidate.getParameters().get(i);
										matchesSignature = isMatchesSignature(parameter, candidateParameter, substitutor, owner);
									}
									if (matchesSignature) {
										return candidate;
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	protected boolean isMatchesSignature(JvmFormalParameter parameter, JvmFormalParameter candidateParameter, TypeParameterSubstitutor<?> substitutor, ITypeReferenceOwner owner) {
		JvmTypeReference parameterType = parameter.getParameterType();
		if (parameterType == null || parameterType.getType() == null) {
			return false;
		} 
		String identifier = parameterType.getIdentifier();
		LightweightTypeReference candidateParameterType = substitutor.substitute(owner.toLightweightTypeReference(candidateParameter.getParameterType()));
		return identifier.equals(candidateParameterType.getJavaIdentifier());
	}

	protected TypeParameterSubstitutor<?> createSubstitutor(ITypeReferenceOwner owner,
			LightweightTypeReference declaringType) {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaringType);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(parameterMapping, owner);
		return substitutor;
	}
	
	/* @Nullable */
	public JvmOperation findOverriddenOperation(JvmOperation operation) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE) {
			return null;
		}
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, operation.eResource().getResourceSet());
		LightweightTypeReference declaringType = owner.toLightweightTypeReference(operation.getDeclaringType());
		TypeParameterSubstitutor<?> substitutor = createSubstitutor(owner, declaringType);
		return findOverriddenOperation(operation, declaringType, substitutor, owner, new ContextualVisibilityHelper(visibilityHelper, declaringType));
	}

	/**
	 * Returns the resolved features that are defined in the given <code>type</code> and its supertypes.
	 * Considers private methods of super types, too.
	 * @param type the type. Has to be contained in a resource.
	 * @return the resolved features. 
	 */
	public ResolvedFeatures getResolvedFeatures(JvmDeclaredType type) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type.eResource().getResourceSet());
		LightweightTypeReference contextType = owner.toLightweightTypeReference(type);
		return getResolvedFeatures(contextType);
	}
	
	/**
	 * Returns the resolved features targeting a specific Java version in order to support new language features.
	 */
	public ResolvedFeatures getResolvedFeatures(JvmDeclaredType type, JavaVersion targetVersion) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type.eResource().getResourceSet());
		LightweightTypeReference contextType = owner.toLightweightTypeReference(type);
		return getResolvedFeatures(contextType, targetVersion);
	}
	
	/**
	 * Returns the resolved features that are defined in the given <code>context type</code> and its supertypes.
	 * Considers private methods of super types, too.
	 * @param contextType the context type. Has to be contained in a resource.
	 * @return the resolved features. 
	 */
	public ResolvedFeatures getResolvedFeatures(JvmTypeReference contextType) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, contextType.eResource().getResourceSet());
		return getResolvedFeatures(owner.toLightweightTypeReference(contextType));
	}
	
	/**
	 * Returns the resolved features targeting a specific Java version in order to support new language features.
	 */
	public ResolvedFeatures getResolvedFeatures(JvmTypeReference contextType, JavaVersion targetVersion) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, contextType.eResource().getResourceSet());
		return getResolvedFeatures(owner.toLightweightTypeReference(contextType), targetVersion);
	}

	/**
	 * Returns the resolved features that are defined in the given <code>context type</code> and its supertypes.
	 * Considers private methods of super types, too.
	 * @return the resolved features. 
	 */
	public ResolvedFeatures getResolvedFeatures(LightweightTypeReference contextType) {
		return new ResolvedFeatures(contextType, overrideTester);
	}
	
	/**
	 * Returns the resolved features targeting a specific Java version in order to support new language features.
	 */
	public ResolvedFeatures getResolvedFeatures(LightweightTypeReference contextType, JavaVersion targetVersion) {
		return new ResolvedFeatures(contextType, overrideTester, targetVersion);
	}
	
}
