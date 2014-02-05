/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
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
@NonNullByDefault
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
	@Nullable
	public LightweightTypeReference getReturnTypeOfOverriddenOperation(JvmOperation operation, ITypeReferenceOwner owner, IVisibilityHelper visibilityHelper) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE || !InferredTypeIndicator.isInferred(operation.getReturnType())) {
			return null;
		}
		LightweightTypeReference declaringType = new ParameterizedTypeReference(owner, operation.getDeclaringType());
		TypeParameterSubstitutor<?> substitutor = createSubstitutor(owner, declaringType);
		OwnedConverter converter = new OwnedConverter(owner);
		JvmOperation overriddenOperation = findOverriddenOperation(operation, declaringType, substitutor, converter, visibilityHelper);
		if (overriddenOperation != null) {
			return substitutor.substitute(converter.toLightweightReference(overriddenOperation.getReturnType()));
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
	@Nullable
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

	@Nullable
	protected JvmOperation findOverriddenOperation(JvmOperation operation, LightweightTypeReference declaringType,
			TypeParameterSubstitutor<?> substitutor, OwnedConverter converter, IVisibilityHelper visibilityHelper) {
		int parameterSize = operation.getParameters().size();
		List<LightweightTypeReference> superTypes = declaringType.getSuperTypes();
		for(LightweightTypeReference superType: superTypes) {
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
									String identifier = parameter.getParameterType().getIdentifier();
									JvmFormalParameter candidateParameter = candidate.getParameters().get(i);
									LightweightTypeReference candidateParameterType =
											substitutor.substitute(converter.toLightweightReference(candidateParameter.getParameterType()));
									if (!identifier.equals(candidateParameterType.getJavaIdentifier())) {
										matchesSignature = false;
									}
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
		return null;
	}

	protected TypeParameterSubstitutor<?> createSubstitutor(ITypeReferenceOwner owner,
			LightweightTypeReference declaringType) {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaringType);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(parameterMapping, owner);
		return substitutor;
	}
	
	@Nullable
	public JvmOperation findOverriddenOperation(JvmOperation operation) {
		if (operation.getVisibility() == JvmVisibility.PRIVATE) {
			return null;
		}
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, operation.eResource().getResourceSet());
		ParameterizedTypeReference declaringType = new ParameterizedTypeReference(owner, operation.getDeclaringType());
		if (declaringType.isRawType()) {
			JvmGenericType genericType = (JvmGenericType) declaringType.getType();
			for(JvmTypeParameter typeParameter: genericType.getTypeParameters()) {
				declaringType.addTypeArgument(new ParameterizedTypeReference(owner, typeParameter));
			}
		}
		TypeParameterSubstitutor<?> substitutor = createSubstitutor(owner, declaringType);
		OwnedConverter converter = new OwnedConverter(owner);
		return findOverriddenOperation(operation, declaringType, substitutor, converter, new ContextualVisibilityHelper(visibilityHelper, declaringType));
	}

	/**
	 * Returns the resolved operations that are defined in the given <code>type</code> and its supertypes.
	 * Considers private methods of super types, too.
	 * @param type the type. Has to be contained in a resource.
	 * @return the resolved operations. 
	 */
	public ResolvedOperations getResolvedOperations(JvmDeclaredType type) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type.eResource().getResourceSet());
		ParameterizedTypeReference contextType = new ParameterizedTypeReference(owner, type);
		if (type instanceof JvmGenericType) {
			for(JvmTypeParameter typeParameter: ((JvmGenericType) type).getTypeParameters()) {
				contextType.addTypeArgument(new ParameterizedTypeReference(owner, typeParameter));
			}
		}
		return getResolvedOperations(contextType);
	}
	
	/**
	 * Returns the resolved operations that are defined in the given <code>context type</code> and its supertypes.
	 * Considers private methods of super types, too.
	 * @param contextType the context type. Has to be contained in a resource.
	 * @return the resolved operations. 
	 */
	public ResolvedOperations getResolvedOperations(JvmTypeReference contextType) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, contextType.eResource().getResourceSet());
		return getResolvedOperations(new OwnedConverter(owner).toLightweightReference(contextType));
	}

	/**
	 * Returns the resolved operations that are defined in the given <code>context type</code> and its supertypes.
	 * Considers private methods of super types, too.
	 * @return the resolved operations. 
	 */
	public ResolvedOperations getResolvedOperations(LightweightTypeReference contextType) {
		return new ResolvedOperations(contextType, overrideTester);
	}
	
}

