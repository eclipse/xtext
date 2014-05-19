/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndNonNullResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LegacyFeatureOverridesService extends FeatureOverridesService {

	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private TypeReferences typeReferences;
	
	/**
	 * Returns all operations, the declared constructors and the inherited constructors
	 * of the given type.
	 */
	@Override
	public Iterable<JvmFeature> getAllJvmFeatures(JvmTypeReference type) {
		ITypeReferenceOwner owner = createTypeReferenceOwner(type.getType());
		LightweightTypeReference lightweightReference = new OwnedConverter(owner).toLightweightReference(type);
		List<JvmFeature> result = Lists.<JvmFeature>newArrayList(getAllOperations(lightweightReference, IVisibilityHelper.ALL));
		// add constructors from super types and own constructors
		addDeclaredConstructors(lightweightReference, result);
		for(LightweightTypeReference superType: lightweightReference.getSuperTypes()) {
			addDeclaredConstructors(superType, result);
		}
		return result;
	}

	protected void addDeclaredConstructors(LightweightTypeReference lightweightReference, List<JvmFeature> result) {
		JvmType rawType = lightweightReference.getRawTypeReference().getType();
		if (rawType instanceof JvmGenericType) {
			Iterables.addAll(result, ((JvmGenericType) rawType).getDeclaredConstructors());
		}
	}

	public ITypeReferenceOwner createTypeReferenceOwner(EObject context) {
		Resource resource = context.eResource();
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resource.getResourceSet());
		return owner;
	}
	
	@Override
	public Iterable<JvmFeature> getAllJvmFeatures(JvmDeclaredType type, ITypeArgumentContext ctx) {
		// we want to use the declared type parameters of the given type thus we use the factory here
		JvmParameterizedTypeReference typeReference = typeReferences.createTypeRef(type);
		return getAllJvmFeatures(typeReference);
	}
	
	@Override
	protected boolean isInheritanceRelation(JvmMember overriding, JvmMember overridden) {
		JvmDeclaredType subType = overridden.getDeclaringType();
		JvmDeclaredType superType = overridden.getDeclaringType();
		Resource resource = subType.eResource();
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resource.getResourceSet());
		return new ParameterizedTypeReference(owner, subType).isSubtypeOf(superType);
	}
	
	@Override
	protected boolean hasSameTypeParameters(JvmOperation overriding, JvmOperation overridden,
			ITypeArgumentContext context) {
		List<JvmTypeParameter> overridingTypeParameters = overriding.getTypeParameters();
		List<JvmTypeParameter> overriddenTypeParameters = overridden.getTypeParameters();
		if(!(overridingTypeParameters.size() == overriddenTypeParameters.size()))
			return false;
		ITypeReferenceOwner owner = createTypeReferenceOwner(overriding);
		TypeParameterSubstitutor<?> substitutor = createSubstitutor(owner, overriding.getDeclaringType(), context);
		for(int i = 0; i < overridingTypeParameters.size(); i++) {
			JvmTypeParameter overridingTypeParameter = overridingTypeParameters.get(i);
			JvmTypeParameter overriddenTypeParameter = overriddenTypeParameters.get(i);
			SubstitutingOperationTypeParameterVisitor visitor = new SubstitutingOperationTypeParameterVisitor(overriding, overridden, i, owner, substitutor);
			if (!new ParameterizedTypeReference(owner, overridingTypeParameter).accept(visitor, new ParameterizedTypeReference(owner, overriddenTypeParameter))) {
				return false;
			}
		}
		return true;
	}
	
	protected TypeParameterSubstitutor<?> createSubstitutor(ITypeReferenceOwner owner,
			JvmDeclaredType declaringType, ITypeArgumentContext context) {
		LightweightTypeReference declaringTypeReference = getDeclaringTypeReference(declaringType, owner, context);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaringTypeReference);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(parameterMapping, owner);
		return substitutor;
	}

	public LightweightTypeReference getDeclaringTypeReference(JvmDeclaredType declaringType, ITypeReferenceOwner owner,
			ITypeArgumentContext context) {
		LightweightTypeReference declaringTypeReference = null;
		if (context instanceof LegacyTypeArgumentContext) {
			TypeArgumentContextProvider.Request request = ((LegacyTypeArgumentContext) context).getRequest();
			JvmTypeReference receiverType = request.getReceiverType();
			declaringTypeReference = new OwnedConverter(owner).toLightweightReference(receiverType);
		} else {
			// we want to use the declared type parameters of the given type
			JvmParameterizedTypeReference typeReference = typeReferences.createTypeRef(declaringType);
			declaringTypeReference = new OwnedConverter(owner).toLightweightReference(typeReference);
		}
		return declaringTypeReference;
	}
	
	@Override
	protected boolean isSameArgumentTypes(JvmOperation overriding, JvmOperation overridden, ITypeArgumentContext context) {
		ITypeReferenceOwner owner = createTypeReferenceOwner(overriding);
		OwnedConverter converter = new OwnedConverter(owner);
		LightweightTypeReference declaringTypeReference = getDeclaringTypeReference(overriding.getDeclaringType(), owner, context);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaringTypeReference);
		TypeParameterByConstraintSubstitutor substitur = new TypeParameterByConstraintSubstitutor(parameterMapping, owner);
		for (int i = 0; i < overriding.getParameters().size(); i++) {
			JvmFormalParameter overridingParam = overriding.getParameters().get(i);
			JvmFormalParameter overriddenParam = overridden.getParameters().get(i);
			LightweightTypeReference overridingParamType = converter.toLightweightReference(overridingParam.getParameterType());
			LightweightTypeReference overriddenParamType = converter.toLightweightReference(overriddenParam.getParameterType());
			LightweightTypeReference resolvedOverridingType = substitur.substitute(overridingParamType);
			LightweightTypeReference resolvedOverriddenType = substitur.substitute(overriddenParamType);
			if (!resolvedOverridingType.getIdentifier().equals(resolvedOverriddenType.getIdentifier())) {
				return Boolean.FALSE;
			}
		}
		return true;
	}
	
	public static class SubstitutingOperationTypeParameterVisitor extends TypeReferenceVisitorWithParameterAndNonNullResult<LightweightTypeReference, Boolean> {

		private JvmOperation overriding;
		private JvmOperation overridden;
		private int seed;
		private TypeParameterSubstitutor<?> substitutor;
		private ITypeReferenceOwner owner;

		public SubstitutingOperationTypeParameterVisitor(JvmOperation overriding, JvmOperation overridden, int seed, ITypeReferenceOwner owner, TypeParameterSubstitutor<?> substitutor) {
			this.overriding = overriding;
			this.overridden = overridden;
			this.seed = seed;
			this.owner = owner;
			this.substitutor = substitutor;
		}
		
		@Override
		protected Boolean doVisitArrayTypeReference(ArrayTypeReference reference, LightweightTypeReference param) {
			LightweightTypeReference componentType = param.getComponentType();
			if (componentType != null) {
				return reference.getComponentType().accept(this, componentType);
			}
			return Boolean.FALSE;
		}
		
		@Override
		protected Boolean doVisitAnyTypeReference(AnyTypeReference reference, LightweightTypeReference param) {
			return param.isAny();
		}
		
		@Override
		protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference,
				LightweightTypeReference param) {
			if (param instanceof ParameterizedTypeReference) {
				JvmType type = reference.getType();
				JvmType otherType = param.getType();
				if (type instanceof JvmTypeParameter) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					if (otherType instanceof JvmTypeParameter) {
						if (type == otherType) {
							return Boolean.TRUE;
						}
						JvmTypeParameter otherTypeParameter = (JvmTypeParameter) otherType;
						if (typeParameter.getDeclarator() == overriding) {
							int index = overriding.getTypeParameters().indexOf(typeParameter);
							if (index < 0) {
								throw new IllegalStateException("declarator has to contain its type parameters");
							}
							if (index == seed) {
								seed = -seed - 1;
								if (overridden.getTypeParameters().indexOf(otherTypeParameter) != index) {
									return Boolean.FALSE;
								}
								return doVisitConstraints(typeParameter.getConstraints(), otherTypeParameter.getConstraints());
							} else if (seed == -index - 1) {
								return Boolean.FALSE;
							}
						}
					}
				} else if (type == otherType) {
					List<LightweightTypeReference> typeArguments = reference.getTypeArguments();
					List<LightweightTypeReference> otherTypeArguments = ((ParameterizedTypeReference) param).getTypeArguments();
					return doVisitTypeArguments(typeArguments, otherTypeArguments);
				} 
			}
			return Boolean.FALSE;
		}

		public Boolean doVisitTypeArguments(List<LightweightTypeReference> typeArguments,
				List<LightweightTypeReference> otherTypeArguments) {
			if (typeArguments.size() != otherTypeArguments.size()) {
				return Boolean.FALSE;
			}
			for(int i = 0; i < typeArguments.size(); i++) {
				LightweightTypeReference typeArgument = typeArguments.get(i);
				LightweightTypeReference otherTypeArgument = otherTypeArguments.get(i);
				if (!typeArgument.accept(this, otherTypeArgument)) {
					return Boolean.FALSE;
				}
			}
			return Boolean.TRUE;
		}
		
		protected Boolean doVisitConstraints(List<JvmTypeConstraint> constraints, List<JvmTypeConstraint> otherConstraints) {
			if (constraints.size() != otherConstraints.size()) {
				return Boolean.FALSE;
			}
			OwnedConverter converter = new OwnedConverter(owner);
			for(int i = 0; i < constraints.size(); i++) {
				JvmTypeConstraint constraint = constraints.get(i);
				JvmTypeConstraint otherConstraint = otherConstraints.get(i);
				LightweightTypeReference constraintType = substitutor.substitute(converter.toLightweightReference(constraint.getTypeReference()));
				LightweightTypeReference otherConstraintType = substitutor.substitute(converter.toLightweightReference(otherConstraint.getTypeReference()));
				if (!constraintType.accept(this, otherConstraintType)) {
					return Boolean.FALSE;
				}
			}
			return Boolean.TRUE;
		}
		
		@Override
		protected Boolean doVisitWildcardTypeReference(WildcardTypeReference reference, LightweightTypeReference param) {
			if (param.isWildcard()) {
				WildcardTypeReference otherWildcard = (WildcardTypeReference) param;
				LightweightTypeReference lowerBound = reference.getLowerBound();
				if (lowerBound != null) {
					LightweightTypeReference otherLowerBound = otherWildcard.getLowerBound();
					if (otherLowerBound == null) {
						return Boolean.FALSE;
					}
					if (!lowerBound.accept(this, otherLowerBound)) {
						return Boolean.FALSE;
					}
				}
				return doVisitTypeArguments(reference.getUpperBounds(), otherWildcard.getUpperBounds());
			}
			return Boolean.FALSE;
		}
		
		@Override
		protected Boolean doVisitTypeReference(LightweightTypeReference reference, LightweightTypeReference param) {
			return Boolean.FALSE;
		}
		
	}
	
	public List<JvmOperation> getAllOperations(JvmDeclaredType type, ITypeReferenceOwner owner, IVisibilityHelper visibilityHelper) {
		LightweightTypeReference declaringType = new ParameterizedTypeReference(owner, type);
		return getAllOperations(declaringType, visibilityHelper);
	}

	public List<JvmOperation> getAllOperations(LightweightTypeReference declaringType, IVisibilityHelper visibilityHelper) {
		if (!(declaringType.getType() instanceof JvmDeclaredType)) {
			return Collections.emptyList();
		}
		Iterable<JvmFeature> allFeatures = ((JvmDeclaredType) declaringType.getType()).getAllFeatures();
		TypeParameterSubstitutor<?> substitutor = createSubstitutor(declaringType.getOwner(), declaringType);
		OwnedConverter converter = new OwnedConverter(declaringType.getOwner());
		List<JvmOperation> result = Lists.newArrayList();
		Set<String> signatures = Sets.newHashSet();
		for(JvmFeature feature: allFeatures) {
			if (feature instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) feature;
				if (visibilityHelper.isVisible(operation)) {
					if (!operation.isStatic()) {
						List<JvmFormalParameter> parameters = operation.getParameters();
						StringBuilder signature = new StringBuilder(operation.getSimpleName());
						if (parameters.isEmpty()) {
							signature.append("()");
						} else {
							signature.append("(");
							for(JvmFormalParameter parameter: parameters) {
								JvmTypeReference pType = parameter.getParameterType();
								if (pType != null) {
									LightweightTypeReference parameterType =
											substitutor.substitute(converter.toLightweightReference(pType));
									signature.append(parameterType.getJavaIdentifier());
								} else {
									signature.append("<Unknown>");
								}
								signature.append(",");
							}
							signature.replace(signature.length() - 1, signature.length(), ")");
						}
						if (signatures.add(signature.toString())) {
							result.add(operation);
						}
					} else {
						result.add(operation);
					}
				}
			}
		}
		return result;
	}

	protected TypeParameterSubstitutor<?> createSubstitutor(ITypeReferenceOwner owner,
			LightweightTypeReference declaringType) {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaringType);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(parameterMapping, owner);
		return substitutor;
	}
	
}
