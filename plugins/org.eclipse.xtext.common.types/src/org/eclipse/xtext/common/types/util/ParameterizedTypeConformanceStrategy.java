/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParameterizedTypeConformanceStrategy extends
		TypeConformanceStrategy<JvmParameterizedTypeReference> {
	public ParameterizedTypeConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitGenericArrayTypeReference(JvmParameterizedTypeReference left, JvmGenericArrayTypeReference right,
			TypeConformanceComputationArgument.Internal<JvmParameterizedTypeReference> param) {
		if (conformanceComputer.getTypeReferences().is(left, Object.class))
			return TypeConformanceResult.SUBTYPE;
		if (conformanceComputer.getTypeReferences().is(left, Serializable.class))
			return TypeConformanceResult.SUBTYPE;
		if (conformanceComputer.getTypeReferences().is(left, Cloneable.class))
			return TypeConformanceResult.SUBTYPE;
		return TypeConformanceResult.FAILED;
	}

	@Override
	public TypeConformanceResult doVisitParameterizedTypeReference(JvmParameterizedTypeReference leftReference,
			JvmParameterizedTypeReference rightReference,
			TypeConformanceComputationArgument.Internal<JvmParameterizedTypeReference> param) {
		JvmType leftType = leftReference.getType();
		if (isUnresolved(leftType))
			return TypeConformanceResult.FAILED;
		JvmType rightType = rightReference.getType();
		if (isUnresolved(rightType))
			return TypeConformanceResult.FAILED;
		if (isPrimitiveVoid(leftType)) {
			if (isPrimitiveVoid(rightType)) {
				return TypeConformanceResult.SUCCESS;
			}
			return TypeConformanceResult.FAILED;
		}
		if (isPrimitiveVoid(rightType)) {
			return TypeConformanceResult.FAILED;
		}
		return isConformant(leftType, rightType, leftReference, rightReference, param);
	}

	protected boolean isPrimitiveVoid(JvmType type) {
		return type instanceof JvmVoid;
	}

	protected TypeConformanceResult isConformant(JvmType leftType, JvmType rightType,
			JvmParameterizedTypeReference leftReference, JvmParameterizedTypeReference rightReference,
			TypeConformanceComputationArgument.Internal<JvmParameterizedTypeReference> param) {
		if (leftType == rightType) {
			if (param.rawType)
				return TypeConformanceResult.SUCCESS;
			if (!leftReference.getArguments().isEmpty() || !rightReference.getArguments().isEmpty())
				return areArgumentsConformant(leftReference, rightReference);
			return TypeConformanceResult.SUCCESS;
		}
		if (param.allowPrimitiveConversion) {
			if (leftType instanceof JvmPrimitiveType) {
				if (rightType instanceof JvmPrimitiveType) {
					if (isWideningConversion((JvmPrimitiveType)leftType, (JvmPrimitiveType) rightType)) {
						return new TypeConformanceResult(TypeConformanceResult.Kind.PRIMITIVE_WIDENING);
					}
				} else if (rightType instanceof JvmGenericType) {
					JvmTypeReference potentialPrimitive = conformanceComputer.getPrimitives().asPrimitiveIfWrapperType(rightReference);
					if (potentialPrimitive != rightReference) {
						if (leftType == potentialPrimitive.getType() || isWideningConversion((JvmPrimitiveType)leftType, (JvmPrimitiveType) potentialPrimitive.getType())) {
							return new TypeConformanceResult(TypeConformanceResult.Kind.UNBOXING);
						}
					}
				}
			} else if (rightType instanceof JvmPrimitiveType) {
				if (leftType instanceof JvmGenericType) {
					JvmTypeReference potentialWrapper = conformanceComputer.getPrimitives().asWrapperTypeIfPrimitive(rightReference);
					if (potentialWrapper != rightReference) {
						TypeConformanceResult result = conformanceComputer.isConformant(leftReference, potentialWrapper, param);
						if (result.isConformant()) {
							return new TypeConformanceResult(TypeConformanceResult.Kind.BOXING);
						}
					}
				}
			}
		}
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
		if (!param.asTypeArgument) {
			// early exit - remaining cases are all compatible to java.lang.Object
			if (leftType instanceof JvmDeclaredType) {
				if (conformanceComputer.getTypeReferences().is(leftReference, Object.class))
					return TypeConformanceResult.SUBTYPE;
			}
			if (rightType instanceof JvmTypeParameter) {
				List<JvmTypeConstraint> rightConstraints = ((JvmTypeParameter) rightType).getConstraints();
				if (!rightConstraints.isEmpty()) {
					for(JvmTypeConstraint rightConstraint: rightConstraints) {
						if (rightConstraint instanceof JvmUpperBound) {
							TypeConformanceResult candidate = conformanceComputer.isConformant(leftReference, rightConstraint.getTypeReference(), param);
							if (candidate.isConformant())
								return candidate;
						} else {
							return TypeConformanceResult.FAILED;
						}
					}
				} 
				return TypeConformanceResult.FAILED;
			}
			if (leftType instanceof JvmTypeParameter) {
				return TypeConformanceResult.FAILED;
			}
			if (leftType instanceof JvmDeclaredType && rightType instanceof JvmDeclaredType) {
				if (conformanceComputer.getSuperTypeCollector().isSuperType((JvmDeclaredType)rightType, (JvmDeclaredType)leftType)) {
					if (param.rawType)
						return TypeConformanceResult.SUBTYPE;
					// check for raw type references - since we are a subtype, type argument can 
					// considered to be compatible if the reference itself does not define own arguments
					if (leftReference.getArguments().isEmpty() || rightReference.getArguments().isEmpty())
						return TypeConformanceResult.SUBTYPE;
					return areArgumentsConformant(leftReference, rightReference);
				}
			}
		}
		return TypeConformanceResult.FAILED;
	}

	/**
	 * See Java Language Specification <a href="http://java.sun.com/docs/books/jls/third_edition/html/conversions.html#5.1.2">§{5.1.2} Widening Primitive Conversion</a>
	 */
	protected boolean isWideningConversion(JvmPrimitiveType leftType, JvmPrimitiveType rightType) {
		final Primitive left = primitiveKind(leftType);
		final Primitive right = primitiveKind(rightType);
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

	protected Primitive primitiveKind(JvmPrimitiveType primitiveType) {
		return conformanceComputer.getPrimitives().primitiveKind(primitiveType);
	}

	protected TypeConformanceResult areArgumentsConformant(JvmParameterizedTypeReference leftReference,
			JvmParameterizedTypeReference rightReference) {
		TypeArgumentContext leftArgumentContext = getBoundTypeParameters(leftReference);
		if (leftArgumentContext != null && !leftArgumentContext.isRawTypeContext()) {
			Collection<JvmTypeParameter> boundParameters = leftArgumentContext.getBoundParameters();
			Set<Pair<JvmTypeReference, JvmTypeReference>> tested = Sets.newHashSet();
			if (!boundParameters.isEmpty()) {
				TypeArgumentContext rightArgumentContext = getBoundTypeParameters(rightReference);
				if (rightArgumentContext == null) {
					return TypeConformanceResult.FAILED;
				}
				if (!rightArgumentContext.isRawTypeContext()) {
					for(JvmTypeParameter leftTypeParameter: boundParameters) {
						JvmTypeReference leftBound = leftArgumentContext.getBoundArgument(leftTypeParameter);
						JvmTypeReference rightBound = rightArgumentContext.getBoundArgument(leftTypeParameter);
						if (leftBound != rightBound && rightBound != null) {
							if (tested.add(Tuples.create(leftBound, rightBound))) {
								TypeConformanceResult result = conformanceComputer.isConformant(leftBound, rightBound, new TypeConformanceComputationArgument(false, true, false));
								if (!result.isConformant()) {
									return result;
								}
							}
						}
					}
				}
			}
		}
		return TypeConformanceResult.SUCCESS;
	}

	protected TypeArgumentContext getBoundTypeParameters(JvmParameterizedTypeReference reference) {
		return conformanceComputer.getTypeArgumentContextProvider().getReceiverContext(reference);
	}

	protected boolean isUnresolved(JvmType leftType) {
		return leftType == null || leftType.eIsProxy();
	}

	@Override
	public TypeConformanceResult doVisitAnyTypeReference(JvmParameterizedTypeReference left, JvmAnyTypeReference right, TypeConformanceComputationArgument.Internal<JvmParameterizedTypeReference> param) {
		JvmType leftType = left.getType();
		if (isUnresolved(leftType)) {
			return TypeConformanceResult.FAILED;
		}
		if (leftType instanceof JvmPrimitiveType) {
			return TypeConformanceResult.FAILED;
		}
		if (isPrimitiveVoid(leftType)) {
			return TypeConformanceResult.FAILED;
		}
		return TypeConformanceResult.SUCCESS;
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmParameterizedTypeReference left, JvmTypeReference right, TypeConformanceComputationArgument.Internal<JvmParameterizedTypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}