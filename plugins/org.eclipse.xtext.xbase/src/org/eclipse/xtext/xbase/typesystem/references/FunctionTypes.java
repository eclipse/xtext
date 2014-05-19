/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class FunctionTypes {
	
	@Inject
	private TypeReferences typeReferences;

	public List<JvmTypeParameter> collectAllTypeParameters(LightweightTypeReference closureType,
			JvmOperation operation) {
		// common case is worthy optimizing
		List<JvmType> rawTypes = closureType.getRawTypes();
		if (rawTypes.size() == 1 && operation.getTypeParameters().isEmpty()) {
			JvmType type = rawTypes.get(0);
			if (type instanceof JvmTypeParameterDeclarator) {
				return ((JvmTypeParameterDeclarator) type).getTypeParameters();
			}
			return Collections.emptyList();
		} else {
			List<JvmTypeParameter> allTypeParameters = Lists.newArrayList();
			for(JvmType rawType: rawTypes) {
				if (rawType instanceof JvmTypeParameterDeclarator) {
					allTypeParameters.addAll(((JvmTypeParameterDeclarator) rawType).getTypeParameters());
				}
			}
			allTypeParameters.addAll(operation.getTypeParameters());
			return allTypeParameters;
		}
	}
	
	public Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> getFunctionTypeParameterMapping(
			LightweightTypeReference functionType, JvmOperation operation,
			ActualTypeArgumentCollector typeArgumentCollector, ITypeReferenceOwner owner) {
		/* 
		 * The mapping is populated by means of the function type to declarator mapping, though a method
		 * 
		 * m(Zonk zonk) { .. }
		 * 
		 * with
		 * 
		 * interface Foo<X> {
		 *   void bar(X x);
		 * }
		 * interface Zonk extends Foo<CharSequence> {}
		 * 
		 * infers the parameter type CharSequence for the lamba param
		 */
		JvmParameterizedTypeReference operationTypeDeclarator = typeReferences.createTypeRef(operation.getDeclaringType());
		LightweightTypeReference lightweightTypeReference = new OwnedConverter(owner).toLightweightReference(operationTypeDeclarator);
		typeArgumentCollector.populateTypeParameterMapping(lightweightTypeReference, functionType);
		Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> typeParameterMapping = typeArgumentCollector.rawGetTypeParameterMapping();
		return typeParameterMapping;
	}
	
	/* @Nullable */
	public JvmOperation findImplementingOperation(LightweightTypeReference functionType) {
		// TODO use org.eclipse.xtext.xbase.typesystem.override.ResolvedOperations instead (if fast enough)
		List<JvmType> rawTypes = functionType.getRawTypes();
		if (rawTypes.size() == 1) {
			JvmType rawType = rawTypes.get(0);
			if (rawType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
				JvmGenericType castedRawType = (JvmGenericType) rawType;
				if (!castedRawType.isFinal()) {
					Iterable<JvmFeature> features = castedRawType.getAllFeatures();
					JvmOperation result = null;
					for (JvmFeature feature : features) {
						if (feature.eClass() == TypesPackage.Literals.JVM_OPERATION) {
							JvmOperation op = (JvmOperation) feature;
							if (isValidFunction(op)) {
								if (result == null)
									result = op;
								else {
									return null;
								}
							}
						}
					}
					return result;
				}
			}
		}
		return null;
	}

	private boolean isValidFunction(JvmOperation op) {
		// TODO we need context here - the op has to be visible
		if (op.isAbstract()) {
			if (Object.class.getName().equals(op.getDeclaringType().getIdentifier()))
				return false;
			final String name = op.getSimpleName();
			if (name.equals("toString") && op.getParameters().isEmpty())
				return false;
			if (name.equals("equals") && op.getParameters().size() == 1)
				return false;
			if (name.equals("hashCode") && op.getParameters().isEmpty())
				return false;
			return true;
		}
		return false;
	}
	
	public boolean isFunctionAndProcedureAvailable(ITypeReferenceOwner owner) {
		JvmType type = typeReferences.findDeclaredType(Procedures.Procedure1.class, owner.getContextResourceSet());
		if (type == null) {
			return false;
		}
		if (type instanceof JvmTypeParameterDeclarator) {
			return !((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty();
		}
		return false;
	}

	public FunctionTypeReference createRawFunctionTypeRef(ITypeReferenceOwner owner, EObject context, int parameterCount, boolean procedure) {
		String simpleClassName = (procedure ? "Procedure" : "Function") + Math.min(6, parameterCount);
		final Class<?> loadFunctionClass = loadFunctionClass(simpleClassName, procedure);
		JvmType declaredType = typeReferences.findDeclaredType(loadFunctionClass, context);
		if (declaredType == null || !(declaredType instanceof JvmTypeParameterDeclarator))
			throw new IllegalStateException("Cannot load raw function type ref");
		FunctionTypeReference result = new FunctionTypeReference(owner, declaredType);
		return result;
	}
	
	public FunctionTypeReference createFunctionTypeRef(
			ITypeReferenceOwner owner,
			LightweightTypeReference functionType, 
			List<LightweightTypeReference> parameterTypes,
			/* @Nullable */ LightweightTypeReference returnType) {
		JvmType type = functionType.getType();
		if (type == null)
			throw new IllegalArgumentException("type may not be null");
		FunctionTypeReference result = new FunctionTypeReference(owner, type);
		if (functionType instanceof ParameterizedTypeReference) {
			for(LightweightTypeReference typeArgument: ((ParameterizedTypeReference) functionType).getTypeArguments()) {
				result.addTypeArgument(typeArgument.copyInto(owner));
			}
		}
		for(LightweightTypeReference parameterType: parameterTypes) {
			result.addParameterType(parameterType.copyInto(owner));
		}
		if (returnType != null) {
			result.setReturnType(returnType.copyInto(owner));
		}
		return result;
	}
	
	private Class<?> loadFunctionClass(String simpleFunctionName, boolean procedure) {
		try {
			if (!procedure) {
				return Functions.class.getClassLoader().loadClass(
						Functions.class.getCanonicalName() + "$" + simpleFunctionName);
			} else {
				return Procedures.class.getClassLoader().loadClass(
						Procedures.class.getCanonicalName() + "$" + simpleFunctionName);
			}
		} catch (ClassNotFoundException e) {
			throw new WrappedException(e);
		}
	}
	
	public FunctionTypeKind getFunctionTypeKind(ParameterizedTypeReference typeReference) {
		JvmType type = typeReference.getType();
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			JvmDeclaredType outerType = ((JvmGenericType) type).getDeclaringType();
			if (outerType != null) {
				if (Procedures.class.getName().equals(outerType.getIdentifier())) {
					return FunctionTypeKind.PROCEDURE;
				}
				if (Functions.class.getName().equals(outerType.getIdentifier())) {
					return FunctionTypeKind.FUNCTION;
				}
			}
		}
		return FunctionTypeKind.NONE;
	}

	/**
	 * Converts the given reference to a {@link FunctionTypeReference} if the referenced type is a SAM type.
	 * Returns <code>null</code> if this reference does not point to a valid function type.
	 * This is the externalized and thereby
	 * exchangeable implementation of {@link ParameterizedTypeReference#tryConvertToFunctionTypeReference(boolean)}.
	 * @see #getAsFunctionTypeReference(ParameterizedTypeReference)
	 */
	/* @Nullable */
	protected FunctionTypeReference tryConvertToFunctionTypeReference(ParameterizedTypeReference typeReference, boolean rawType) {
		JvmOperation operation = findImplementingOperation(typeReference);
		if (operation == null)
			return null;
		OwnedConverter converter = new OwnedConverter(typeReference.getOwner());
		LightweightTypeReference declaredReturnType = converter.toLightweightReference(operation.getReturnType());
		if (rawType) {
			FunctionTypeReference result = createRawFunctionTypeRef(typeReference.getOwner(), operation, operation.getParameters().size(), declaredReturnType.isPrimitiveVoid());
			TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(
					Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), typeReference.getOwner());
			for(JvmFormalParameter parameter: operation.getParameters()) {
				LightweightTypeReference lightweight = substitutor.substitute(converter.toLightweightReference(parameter.getParameterType()));
				LightweightTypeReference lowerBound = lightweight.getLowerBoundSubstitute();
				if (lowerBound instanceof AnyTypeReference)
					return null;
				result.addParameterType(lowerBound);
			}
			result.setReturnType(substitutor.substitute(declaredReturnType));
			return result;
		}
		List<JvmTypeParameter> allTypeParameters = collectAllTypeParameters(typeReference, operation);
		ActualTypeArgumentCollector typeArgumentCollector = new UnboundTypeParameterAwareTypeArgumentCollector(allTypeParameters, BoundTypeArgumentSource.CONSTRAINT, typeReference.getOwner());
		Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> typeParameterMapping = getFunctionTypeParameterMapping(
				typeReference, operation, typeArgumentCollector, typeReference.getOwner());
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mergedTypeParameterMapping = Maps.newLinkedHashMap();
		for(Map.Entry<JvmTypeParameter, List<LightweightBoundTypeArgument>> mapping: typeParameterMapping.entrySet()) {
			mergedTypeParameterMapping.put(mapping.getKey(), typeReference.getServices().getBoundTypeArgumentMerger().merge(mapping.getValue(), typeReference.getOwner()));			
		}
		UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(mergedTypeParameterMapping, typeReference.getOwner()) {
			@Override
			/* @Nullable */
			protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type,
					Set<JvmTypeParameter> visiting) {
				LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(type);
				if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
					LightweightTypeReference boundReference = boundTypeArgument.getTypeReference();
					if (boundTypeArgument.getVariance() == VarianceInfo.OUT) {
						WildcardTypeReference wildcard = new WildcardTypeReference(getOwner());
						wildcard.addUpperBound(boundReference);
						boundReference = wildcard;
					}
					return boundReference.accept(this, visiting);
				}
				return null;
			}
		};
		List<LightweightTypeReference> parameterTypes = Lists.newArrayListWithCapacity(operation.getParameters().size());
		for(JvmFormalParameter parameter: operation.getParameters()) {
			LightweightTypeReference lightweight = substitutor.substitute(converter.toLightweightReference(parameter.getParameterType()));
			LightweightTypeReference lowerBound = lightweight.getLowerBoundSubstitute();
			if (lowerBound instanceof AnyTypeReference)
				return null;
			parameterTypes.add(lowerBound);
		}
		LightweightTypeReference returnType = substitutor.substitute(declaredReturnType);
		FunctionTypeReference result = createFunctionTypeRef(typeReference.getOwner(), typeReference, parameterTypes, returnType.getUpperBoundSubstitute());
		return result;
	}

	/**
	 * Returns the equivalent {@link FunctionTypeReference} if this reference
	 * points to a {@link Functions function} or {@link Procedures procedure}.
	 * Otherwise returns <code>null</code>. This is the externalized and thereby
	 * exchangeable implementation of {@link ParameterizedTypeReference#getAsFunctionTypeReference()}.
	 * @see #tryConvertToFunctionTypeReference(ParameterizedTypeReference, boolean)
	 */
	/* @Nullable */
	public FunctionTypeReference getAsFunctionTypeReference(ParameterizedTypeReference typeReference) {
		FunctionTypeKind functionTypeKind = typeReference.getFunctionTypeKind();
		if (functionTypeKind == FunctionTypeKind.PROCEDURE) {
			return getAsProcedureOrNull(typeReference);
		} else if (functionTypeKind == FunctionTypeKind.FUNCTION) {
			return getAsFunctionOrNull(typeReference);
		}
		return null;
	}

	/* @Nullable */
	protected FunctionTypeReference getAsFunctionOrNull(ParameterizedTypeReference typeReference) {
		if (typeReference.isRawType())
			return null;
		FunctionTypeReference functionType = new FunctionTypeReference(typeReference.getOwner(), typeReference.getType());
		List<LightweightTypeReference> allTypeArguments = typeReference.getTypeArguments();
		if (!tryAssignTypeArguments(allTypeArguments.subList(0, allTypeArguments.size() - 1), functionType))
			return null;
		LightweightTypeReference lastTypeArgument = allTypeArguments.get(allTypeArguments.size() - 1);
		functionType.addTypeArgument(lastTypeArgument);
		LightweightTypeReference returnType = lastTypeArgument.getUpperBoundSubstitute();
		functionType.setReturnType(returnType);
		return functionType;
	}

	/* @Nullable */
	protected FunctionTypeReference getAsProcedureOrNull(ParameterizedTypeReference typeReference) {
		ITypeReferenceOwner owner = typeReference.getOwner();
		JvmType type = typeReference.getType();
		FunctionTypeReference functionType = new FunctionTypeReference(owner, type);
		if (!tryAssignTypeArguments(typeReference.getTypeArguments(), functionType))
			return null;
		JvmType voidType = (JvmType) owner.getContextResourceSet().getEObject(URIHelperConstants.PRIMITIVES_URI.appendFragment("void"), true);
		functionType.setReturnType(new ParameterizedTypeReference(owner, voidType));
		return functionType;
	}
	
	protected boolean tryAssignTypeArguments(List<LightweightTypeReference> typeArguments, FunctionTypeReference result) {
		for(LightweightTypeReference typeArgument: typeArguments) {
			result.addTypeArgument(typeArgument);
			LightweightTypeReference lowerBound = typeArgument.getLowerBoundSubstitute();
			if (lowerBound instanceof AnyTypeReference) {
				return false;
			}
			result.addParameterType(lowerBound);
		}
		return true;
	}
}
