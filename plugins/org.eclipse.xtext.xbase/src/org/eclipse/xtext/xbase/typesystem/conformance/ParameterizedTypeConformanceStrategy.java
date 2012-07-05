/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult.Kind;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferences;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterAwareTypeArgumentCollector;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ParameterizedTypeConformanceStrategy<TypeReference extends ParameterizedTypeReference> extends
		TypeConformanceStrategy<TypeReference> {
	
	public ParameterizedTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	protected TypeConformanceResult doVisitArrayTypeReference(TypeReference left, ArrayTypeReference right,
			TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (left.isType(Object.class))
			return TypeConformanceResult.SUBTYPE;
		if (left.isType(Serializable.class))
			return TypeConformanceResult.SUBTYPE;
		if (left.isType(Cloneable.class))
			return TypeConformanceResult.SUBTYPE;
		return TypeConformanceResult.FAILED;
	}

	@Override
	protected TypeConformanceResult doVisitParameterizedTypeReference(TypeReference leftReference,
			ParameterizedTypeReference rightReference,
			TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (leftReference.getType() == rightReference.getType()) {
			if (param.rawType || leftReference.isRawType() || rightReference.isRawType() || leftReference.getTypeArguments().isEmpty() || rightReference.getTypeArguments().isEmpty())
				return TypeConformanceResult.SUCCESS;
			return areArgumentsConformant(leftReference, rightReference);
		}
		if (leftReference.isType(Void.TYPE) || rightReference.isType(Void.TYPE)) {
			return TypeConformanceResult.FAILED;
		}
		if (param.allowPrimitiveConversion) {
			if (leftReference.isPrimitive()) {
				CommonTypeComputationServices services = leftReference.getOwner().getServices();
				Primitives primitives = services.getPrimitives();
				JvmPrimitiveType leftType = (JvmPrimitiveType) leftReference.getType();
				JvmType rightType = rightReference.getType();
				if (rightReference.isPrimitive()) {
					if (isWideningConversion(primitives, leftType, (JvmPrimitiveType) rightType)) {
						return new TypeConformanceResult(TypeConformanceResult.Kind.PRIMITIVE_WIDENING);
					}
					return TypeConformanceResult.FAILED;
				} else {
					LightweightTypeReference primitive = rightReference.getPrimitiveIfWrapperType();
					if (primitive.isPrimitive()) {
						JvmPrimitiveType rightPrimitiveType = (JvmPrimitiveType) primitive.getType();
						if (rightPrimitiveType != null && (rightPrimitiveType == leftType || isWideningConversion(primitives, leftType, rightPrimitiveType))) {
							return new TypeConformanceResult(TypeConformanceResult.Kind.UNBOXING);
						}
						return TypeConformanceResult.FAILED;
					}
				}
			} else if (rightReference.isPrimitive()) {
				LightweightTypeReference wrapper = rightReference.getWrapperTypeIfPrimitive();
				TypeConformanceResult result = conformanceComputer.isConformant(leftReference, wrapper, param);
				if (result.isConformant()) {
					return new TypeConformanceResult(TypeConformanceResult.Kind.BOXING);
				}
			}
		}
		if (!param.asTypeArgument) {
			// early exit - remaining cases are all compatible to java.lang.Object
			if (leftReference.isType(Object.class))
				return TypeConformanceResult.SUCCESS;
			TypeConformanceComputationArgument paramWithoutSuperTypeCheck = new TypeConformanceComputationArgument(param.rawType, true, param.allowPrimitiveConversion);
			for(LightweightTypeReference rightSuperTypes: rightReference.getAllSuperTypes()) {
				TypeConformanceResult result = conformanceComputer.isConformant(leftReference, rightSuperTypes, paramWithoutSuperTypeCheck);
				if (result.isConformant()) {
					return TypeConformanceResult.merge(result, new TypeConformanceResult(TypeConformanceResult.Kind.SUBTYPE));
				}
			}
		}
		return isAssignableAsFunctionType(leftReference, rightReference, param);
	}

	protected TypeConformanceResult isAssignableAsFunctionType(TypeReference leftReference,
			ParameterizedTypeReference rightReference, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		// TODO only if param allows conversion, e.g. not param.asTypeArgument?
		FunctionTypeReference leftFunctionType = getFunctionTypeReference(leftReference);
		if (leftFunctionType != null) {
			FunctionTypeReference rightFunctionType = getFunctionTypeReference(rightReference);
			if (rightFunctionType != null) {
				return TypeConformanceResult.FAILED;
			}
			rightFunctionType = convertToFunctionTypeReference(rightReference, param.rawType);
			if (rightFunctionType != null) {
				TypeConformanceResult functionsAreConformant = conformanceComputer.isConformant(leftFunctionType, rightFunctionType, param);
				if (functionsAreConformant.isConformant()) {
					return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(Kind.DEMAND_CONVERSION));
				}
			}
		} else {
			FunctionTypeReference rightFunctionType = getFunctionTypeReference(rightReference);
			if (rightFunctionType != null) {
				leftFunctionType = convertToFunctionTypeReference(leftReference, param.rawType);
				if (leftFunctionType != null) {
					TypeConformanceResult functionsAreConformant = conformanceComputer.isConformant(leftFunctionType, rightFunctionType, param);
					if (functionsAreConformant.isConformant()) {
						return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(Kind.DEMAND_CONVERSION));
					}
				}
			}
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	protected TypeConformanceResult doVisitFunctionTypeReference(TypeReference left, FunctionTypeReference right,
			TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (!left.isRawType()) {
			FunctionTypeReference functionType = getFunctionTypeReference(left);
			if (functionType != null) {
				return conformanceComputer.isConformant(functionType, right, param);
			}
			if (isFunctionType(right) != FunctionTypeKind.NONE) {
				FunctionTypeReference converted = convertToFunctionTypeReference(left, param.rawType);
				if (converted != null) {
					TypeConformanceResult functionsAreConformant = conformanceComputer.isConformant(converted, right, param);
					if (functionsAreConformant.isConformant()) {
						return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(Kind.DEMAND_CONVERSION));
					}
				}
			}
		}
		return super.doVisitFunctionTypeReference(left, right, param);
	}
	
	@Nullable
	protected FunctionTypeReference convertToFunctionTypeReference(ParameterizedTypeReference reference, boolean rawType) {
		CommonTypeComputationServices services = reference.getOwner().getServices();
		FunctionTypes functionTypes = services.getFunctionTypes();
		LightweightTypeReferences lightweightTypeReferences = services.getLightweightTypeReferences();
		JvmOperation operation = functionTypes.findImplementingOperation(reference);
		if (operation == null)
			return null;
		OwnedConverter converter = new OwnedConverter(reference.getOwner());
		LightweightTypeReference declaredReturnType = converter.toLightweightReference(operation.getReturnType());
		if (rawType) {
			FunctionTypeReference result = functionTypes.createRawFunctionTypeRef(reference.getOwner(), operation, operation.getParameters().size(), declaredReturnType.isPrimitiveVoid());
			TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(
					Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), reference.getOwner());
			for(JvmFormalParameter parameter: operation.getParameters()) {
				LightweightTypeReference lightweight = substitutor.substitute(converter.toLightweightReference(parameter.getParameterType()));
				LightweightTypeReference lowerBound = lightweightTypeReferences.getLowerBoundOrInvariant(lightweight);
				if (lowerBound == null)
					return null;
				result.addParameterType(lowerBound);
			}
			result.setReturnType(substitutor.substitute(declaredReturnType));
			return result;
		}
		List<JvmTypeParameter> allTypeParameters = functionTypes.collectAllTypeParameters(reference, operation);
		ActualTypeArgumentCollector typeArgumentCollector = new UnboundTypeParameterAwareTypeArgumentCollector(allTypeParameters, BoundTypeArgumentSource.CONSTRAINT, reference.getOwner());
		ListMultimap<JvmTypeParameter,LightweightBoundTypeArgument> typeParameterMapping = functionTypes.getFunctionTypeParameterMapping(
				reference, operation, typeArgumentCollector, reference.getOwner());
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mergedTypeParameterMapping = Maps.newLinkedHashMap();
		for(Map.Entry<JvmTypeParameter, Collection<LightweightBoundTypeArgument>> mapping: typeParameterMapping.asMap().entrySet()) {
			mergedTypeParameterMapping.put(mapping.getKey(), services.getBoundTypeArgumentMerger().merge(mapping.getValue(), reference.getOwner()));			
		}
		TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(mergedTypeParameterMapping, reference.getOwner());
		List<LightweightTypeReference> parameterTypes = Lists.newArrayListWithCapacity(operation.getParameters().size());
		for(JvmFormalParameter parameter: operation.getParameters()) {
			LightweightTypeReference lightweight = substitutor.substitute(converter.toLightweightReference(parameter.getParameterType()));
			LightweightTypeReference lowerBound = lightweightTypeReferences.getLowerBoundOrInvariant(lightweight);
			if (lowerBound == null)
				return null;
			parameterTypes.add(lowerBound);
		}
		LightweightTypeReference returnType = substitutor.substitute(declaredReturnType);
		FunctionTypeReference result = functionTypes.createFunctionTypeRef(reference.getOwner(), reference, parameterTypes, lightweightTypeReferences.getUpperBoundOrInvariant(returnType));
		return result;
	}
	
	@Nullable
	protected FunctionTypeReference getFunctionTypeReference(ParameterizedTypeReference reference) {
		FunctionTypeKind functionTypeKind = isFunctionType(reference);
		if (functionTypeKind == FunctionTypeKind.PROCEDURE) {
			FunctionTypeReference functionType = new FunctionTypeReference(reference.getOwner(), reference.getType());
			if (!setTypeArguments(reference.getTypeArguments(), functionType))
				return null;
			JvmGenericType type = (JvmGenericType) functionType.getType();
			JvmOperation applyOperation = (JvmOperation) type.findAllFeaturesByName("apply").iterator().next();
			JvmType voidType = applyOperation.getReturnType().getType();
			functionType.setReturnType(new ParameterizedTypeReference(reference.getOwner(), voidType));
			return functionType;
		} else if (functionTypeKind == FunctionTypeKind.FUNCTION) {
			CommonTypeComputationServices services = reference.getOwner().getServices();
			LightweightTypeReferences lightweightTypeReferences = services.getLightweightTypeReferences();
			FunctionTypeReference functionType = new FunctionTypeReference(reference.getOwner(), reference.getType());
			List<LightweightTypeReference> allTypeArguments = reference.getTypeArguments();
			if (!setTypeArguments(allTypeArguments.subList(0, allTypeArguments.size() - 1), functionType))
				return null;
			LightweightTypeReference lastTypeArgument = allTypeArguments.get(allTypeArguments.size() - 1);
			functionType.addTypeArgument(lastTypeArgument);
			LightweightTypeReference returnType = lightweightTypeReferences.getUpperBoundOrInvariant(lastTypeArgument);
			if (returnType == null) {
				return null;
			}
			functionType.setReturnType(returnType);
			return functionType;
		}
		return null;
	}
	
	protected boolean setTypeArguments(List<LightweightTypeReference> typeArguments, FunctionTypeReference result) {
		CommonTypeComputationServices services = result.getOwner().getServices();
		LightweightTypeReferences lightweightTypeReferences = services.getLightweightTypeReferences();
		for(LightweightTypeReference typeArgument: typeArguments) {
			result.addTypeArgument(typeArgument);
			LightweightTypeReference lowerBound = lightweightTypeReferences.getLowerBoundOrInvariant(typeArgument);
			if (lowerBound == null || lowerBound instanceof AnyTypeReference) {
				return false;
			}
			result.addParameterType(lowerBound);
		}
		return true;
	}
	
	protected enum FunctionTypeKind {
		FUNCTION, PROCEDURE, NONE
	}
	
	protected FunctionTypeKind isFunctionType(ParameterizedTypeReference reference) {
		JvmType type = reference.getType();
		if (type instanceof JvmGenericType) {
			JvmDeclaredType outerType = ((JvmGenericType) type).getDeclaringType();
			if (outerType != null) {
				if (Procedures.class.getCanonicalName().equals(outerType.getQualifiedName())) {
					return FunctionTypeKind.PROCEDURE;
				}
				if (Functions.class.getCanonicalName().equals(outerType.getQualifiedName())) {
					return FunctionTypeKind.FUNCTION;
				}
			}
		}
		return FunctionTypeKind.NONE;
	}
	
	@Override
	protected TypeConformanceResult doVisitWildcardTypeReference(TypeReference left,
			WildcardTypeReference right, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (!param.isAsTypeArgument()) {
			for(LightweightTypeReference upperBound: right.getUpperBounds()) {
				TypeConformanceResult result = conformanceComputer.isConformant(left, upperBound, param);
				if (result.isConformant()) {
					return result;
				}
			}
		}
		return TypeConformanceResult.FAILED;
	}

//	protected TypeConformanceResult isConformant(JvmType leftType, JvmType rightType,
//			ParameterizedTypeReference leftReference, ParameterizedTypeReference rightReference,
//			TypeConformanceComputationArgument.Internal<ParameterizedTypeReference> param) {
//		if (leftType == rightType) {
//			if (param.rawType)
//				return TypeConformanceResult.SUCCESS;
//			if (!leftReference.getArguments().isEmpty() || !rightReference.getArguments().isEmpty())
//				return areArgumentsConformant(leftReference, rightReference);
//			return TypeConformanceResult.SUCCESS;
//		}
//		if (param.allowPrimitiveConversion) {
//			if (leftType instanceof JvmPrimitiveType) {
//				if (rightType instanceof JvmPrimitiveType) {
//					if (isWideningConversion((JvmPrimitiveType)leftType, (JvmPrimitiveType) rightType)) {
//						return new TypeConformanceResult(TypeConformanceResult.Kind.PRIMITIVE_WIDENING);
//					}
//				} else if (rightType instanceof JvmGenericType) {
//					JvmTypeReference potentialPrimitive = conformanceComputer.getPrimitives().asPrimitiveIfWrapperType(rightReference);
//					if (potentialPrimitive != rightReference) {
//						if (leftType == potentialPrimitive.getType() || isWideningConversion((JvmPrimitiveType)leftType, (JvmPrimitiveType) potentialPrimitive.getType())) {
//							return new TypeConformanceResult(TypeConformanceResult.Kind.UNBOXING);
//						}
//					}
//				}
//			} else if (rightType instanceof JvmPrimitiveType) {
//				if (leftType instanceof JvmGenericType) {
//					JvmTypeReference potentialWrapper = conformanceComputer.getPrimitives().asWrapperTypeIfPrimitive(rightReference);
//					if (potentialWrapper != rightReference) {
//						TypeConformanceResult result = conformanceComputer.isConformant(leftReference, potentialWrapper, param);
//						if (result.isConformant()) {
//							return new TypeConformanceResult(TypeConformanceResult.Kind.BOXING);
//						}
//					}
//				}
//			}
//		}
//		class Foo<F1 extends CharSequence, F2> {
//			<T1, T2, T3 extends T2, T4 extends CharSequence, T5 extends CharSequence> void foo(T1 t1, T2 t2, T3 t3, List<? super T2> l) {
//				t1 = t2;
//				t1 = t3;
//				t2 = t3;
//				t3 = l.get(0);
//				t2 = l.get(0);
//				List<T2> lt2 = null;
//				List<T3> lt3 = null;
//				lt2 = lt3;
//				lt3 = lt2;
//				l.add(t1);
//				l.add(t2);
//				l.add(t3);
//				T4 t4 = null;
//				T5 t5 = null;
//				t4 = t5;
//				t5 = t4;
//				F1 f1 = null;
//				F2 f2 = null;
//				t1 = f1;
//				t1 = f2;
//				t4 = f1;
//				f1 = t4;
//				CharSequence c = t4;
//			}
//			<T> T foo() {
//				return null;
//			}
//			<T> void bar(T t) {
//				T t2 = foo();
//			}
//		}
//		if (!param.asTypeArgument) {
//			// early exit - remaining cases are all compatible to java.lang.Object
//			if (leftType instanceof JvmDeclaredType) {
//				if (leftReference.isType(Object.class))
//					return TypeConformanceResult.SUBTYPE;
//			}
//			if (rightType instanceof JvmTypeParameter) {
//				List<JvmTypeConstraint> rightConstraints = ((JvmTypeParameter) rightType).getConstraints();
//				if (!rightConstraints.isEmpty()) {
//					for(JvmTypeConstraint rightConstraint: rightConstraints) {
//						if (rightConstraint instanceof JvmUpperBound) {
//							TypeConformanceResult candidate = conformanceComputer.isConformant(leftReference, rightConstraint.getTypeReference(), param);
//							if (candidate.isConformant())
//								return candidate;
//						} else {
//							return TypeConformanceResult.FAILED;
//						}
//					}
//				} 
//				return TypeConformanceResult.FAILED;
//			}
//			if (leftType instanceof JvmTypeParameter) {
//				return TypeConformanceResult.FAILED;
//			}
//			if (leftType instanceof JvmDeclaredType && rightType instanceof JvmDeclaredType) {
//				if (conformanceComputer.getSuperTypeCollector().isSuperType((JvmDeclaredType)rightType, (JvmDeclaredType)leftType)) {
//					if (param.rawType)
//						return TypeConformanceResult.SUBTYPE;
//					// check for raw type references - since we are a subtype, type argument can 
//					// considered to be compatible if the reference itself does not define own arguments
//					if (leftReference.getArguments().isEmpty() || rightReference.getArguments().isEmpty())
//						return TypeConformanceResult.SUBTYPE;
//					return areArgumentsConformant(leftReference, rightReference);
//				}
//			}
//		}
//		return TypeConformanceResult.FAILED;
//	}

	/**
	 * See Java Language Specification <a href="http://java.sun.com/docs/books/jls/third_edition/html/conversions.html#5.1.2">§{5.1.2} Widening Primitive Conversion</a>
	 */
	protected boolean isWideningConversion(Primitives primitives, JvmPrimitiveType leftType, JvmPrimitiveType rightType) {
		final Primitive left = primitives.primitiveKind(leftType);
		final Primitive right = primitives.primitiveKind(rightType);
		switch (right) {
			case Byte :
				return left == Primitive.Short 
					|| left == Primitive.Char // listed in section 5.1.4
					|| left == Primitive.Int
					|| left == Primitive.Long
					|| left == Primitive.Float
					|| left == Primitive.Double;
			case Short :
				return left == Primitive.Int
					|| left == Primitive.Long
					|| left == Primitive.Float
					|| left == Primitive.Double;
			case Char :
				return left == Primitive.Int
					|| left == Primitive.Long
					|| left == Primitive.Float
					|| left == Primitive.Double;
			case Int :
				return left == Primitive.Long
					|| left == Primitive.Float
					|| left == Primitive.Double;
			case Long :
				return left == Primitive.Float
					|| left == Primitive.Double;
			case Float :
				return left == Primitive.Double;
			default :
				return false;
		}
	}

	protected TypeConformanceResult areArgumentsConformant(ParameterizedTypeReference leftReference,
			ParameterizedTypeReference rightReference) {
		if (leftReference.getType() != rightReference.getType())
			throw new IllegalArgumentException("cannot compare type arguments for different base types");
		List<LightweightTypeReference> leftTypeArguments = leftReference.getTypeArguments();
		List<LightweightTypeReference> rightTypeArguments = rightReference.getTypeArguments();
		if (leftTypeArguments.size() != rightTypeArguments.size()) {
			return TypeConformanceResult.FAILED;
		}
		TypeConformanceComputationArgument argument = new TypeConformanceComputationArgument(false, true, false);
		for(int i = 0; i < leftTypeArguments.size(); i++) {
			if (!conformanceComputer.isConformant(leftTypeArguments.get(i), rightTypeArguments.get(i), argument).isConformant()) {
				return TypeConformanceResult.FAILED;
			}
		}
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	protected TypeConformanceResult doVisitAnyTypeReference(TypeReference left, AnyTypeReference right, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (left.isPrimitive() || left.isPrimitiveVoid())
			return TypeConformanceResult.FAILED;
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(TypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}