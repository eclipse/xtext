/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

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
	public TypeConformanceResult doVisitArrayTypeReference(TypeReference left, ArrayTypeReference right,
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
	public TypeConformanceResult doVisitParameterizedTypeReference(TypeReference leftReference,
			ParameterizedTypeReference rightReference,
			TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (leftReference.getType() == rightReference.getType()) {
			if (leftReference.isRawType() || rightReference.isRawType() || leftReference.getTypeArguments().isEmpty() || rightReference.getTypeArguments().isEmpty())
				return TypeConformanceResult.SUCCESS;
			return areArgumentsConformant(leftReference, rightReference);
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
						if (isWideningConversion(primitives, leftType, (JvmPrimitiveType) rightType)) {
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
			// TODO avoid infinite recursion - fetch all superTypes at once
			for(LightweightTypeReference rightSuperTypes: rightReference.getSuperTypes()) {
				TypeConformanceResult result = conformanceComputer.isConformant(leftReference, rightSuperTypes, param);
				if (result.isConformant()) {
					return TypeConformanceResult.merge(result, new TypeConformanceResult(TypeConformanceResult.Kind.SUBTYPE));
				}
			}
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	public TypeConformanceResult doVisitWildcardTypeReference(TypeReference left,
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
	public TypeConformanceResult doVisitAnyTypeReference(TypeReference left, AnyTypeReference right, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (left.isPrimitive() || left.isPrimitiveVoid())
			return TypeConformanceResult.FAILED;
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(TypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}