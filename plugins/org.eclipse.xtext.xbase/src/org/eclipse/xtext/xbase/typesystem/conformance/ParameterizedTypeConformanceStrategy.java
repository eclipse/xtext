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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
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
			return areArgumentsConformant(leftReference, rightReference, param.unboundComputationAddsHints);
		}
		if (leftReference.isType(Void.TYPE) || rightReference.isType(Void.TYPE)) {
			return TypeConformanceResult.FAILED;
		}
		if (param.allowPrimitiveConversion || param.allowPrimitiveWidening) {
			if (leftReference.isPrimitive()) {
				CommonTypeComputationServices services = leftReference.getOwner().getServices();
				Primitives primitives = services.getPrimitives();
				JvmPrimitiveType leftType = (JvmPrimitiveType) leftReference.getType();
				JvmType rightType = rightReference.getType();
				if (rightReference.isPrimitive()) {
					if (param.allowPrimitiveWidening && isWideningConversion(primitives, leftType, (JvmPrimitiveType) rightType)) {
						return new TypeConformanceResult(ConformanceHint.PRIMITIVE_WIDENING);
					}
					return TypeConformanceResult.FAILED;
				} else if (param.allowPrimitiveConversion){
					LightweightTypeReference primitive = rightReference.getPrimitiveIfWrapperType();
					if (primitive.isPrimitive()) {
						JvmPrimitiveType rightPrimitiveType = (JvmPrimitiveType) primitive.getType();
						if (rightPrimitiveType != null && (rightPrimitiveType == leftType || isWideningConversion(primitives, leftType, rightPrimitiveType))) {
							return new TypeConformanceResult(ConformanceHint.UNBOXING);
						}
						return TypeConformanceResult.FAILED;
					}
				} else {
					return TypeConformanceResult.FAILED;
				}
			} else if (param.allowPrimitiveConversion && rightReference.isPrimitive()) {
				if (leftReference.isType(Object.class))
					return new TypeConformanceResult(ConformanceHint.BOXING);
				if (leftReference.isType(String.class))
					return TypeConformanceResult.FAILED;
				LightweightTypeReference wrapper = rightReference.getWrapperTypeIfPrimitive();
				TypeConformanceResult result = conformanceComputer.isConformant(leftReference, wrapper, param);
				if (result.isConformant()) {
					return new TypeConformanceResult(ConformanceHint.BOXING);
				}
			}
		}
		if (!param.asTypeArgument) {
			// early exit - remaining cases are all compatible to java.lang.Object
			if (leftReference.isType(Object.class))
				return TypeConformanceResult.SUCCESS;
			TypeConformanceComputationArgument paramWithoutSuperTypeCheck = new TypeConformanceComputationArgument(
					param.rawType, true, param.allowPrimitiveConversion, param.allowPrimitiveWidening, param.unboundComputationAddsHints);
			for(LightweightTypeReference rightSuperType: rightReference.getAllSuperTypes()) {
				TypeConformanceResult result = conformanceComputer.isConformant(leftReference, rightSuperType, paramWithoutSuperTypeCheck);
				if (result.isConformant()) {
					return TypeConformanceResult.merge(result, new TypeConformanceResult(ConformanceHint.SUBTYPE));
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
					return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(ConformanceHint.DEMAND_CONVERSION));
				}
			}
		} else {
			FunctionTypeReference rightFunctionType = getFunctionTypeReference(rightReference);
			if (rightFunctionType != null) {
				leftFunctionType = convertToFunctionTypeReference(leftReference, param.rawType);
				if (leftFunctionType != null) {
					TypeConformanceResult functionsAreConformant = conformanceComputer.isConformant(leftFunctionType, rightFunctionType, param);
					if (functionsAreConformant.isConformant()) {
						return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(ConformanceHint.DEMAND_CONVERSION));
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
			if (conformanceComputer.isFunctionType(right) != TypeConformanceComputer.FunctionTypeKind.NONE) {
				FunctionTypeReference converted = convertToFunctionTypeReference(left, param.rawType);
				if (converted != null) {
					TypeConformanceResult functionsAreConformant = conformanceComputer.isConformant(converted, right, param);
					if (functionsAreConformant.isConformant()) {
						return TypeConformanceResult.merge(functionsAreConformant, new TypeConformanceResult(ConformanceHint.DEMAND_CONVERSION));
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
				LightweightTypeReference lowerBound = lightweight.getLowerBoundSubstitute();
				if (lowerBound instanceof AnyTypeReference)
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
			LightweightTypeReference lowerBound = lightweight.getLowerBoundSubstitute();
			if (lowerBound instanceof AnyTypeReference)
				return null;
			parameterTypes.add(lowerBound);
		}
		LightweightTypeReference returnType = substitutor.substitute(declaredReturnType);
		FunctionTypeReference result = functionTypes.createFunctionTypeRef(reference.getOwner(), reference, parameterTypes, returnType.getUpperBoundSubstitute());
		return result;
	}
	
	@Nullable
	protected FunctionTypeReference getFunctionTypeReference(ParameterizedTypeReference reference) {
		ParameterizedTypeReference result = conformanceComputer.getFunctionTypeReference(reference);
		if (result instanceof FunctionTypeReference)
			return (FunctionTypeReference) result;
		return null;
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
			ParameterizedTypeReference rightReference, boolean unboundAddsHints) {
		if (leftReference.getType() != rightReference.getType())
			throw new IllegalArgumentException("cannot compare type arguments for different base types");
		List<LightweightTypeReference> leftTypeArguments = leftReference.getTypeArguments();
		List<LightweightTypeReference> rightTypeArguments = rightReference.getTypeArguments();
		if (leftTypeArguments.size() != rightTypeArguments.size()) {
			return TypeConformanceResult.FAILED;
		}
		TypeConformanceComputationArgument argument = new TypeConformanceComputationArgument(false, true, false, false, unboundAddsHints);
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
	protected TypeConformanceResult doVisitUnboundTypeReference(TypeReference left, UnboundTypeReference right,
			TypeConformanceComputationArgument.Internal<TypeReference> param) {
		if (left.getType() == right.getType())
			return TypeConformanceResult.SUCCESS;
		if (left.isType(Object.class))
			return TypeConformanceResult.SUCCESS;
		right.tryResolve();
		LightweightTypeReference resolvedTo = right.getResolvedTo();
		if (resolvedTo != null) {
			return conformanceComputer.isConformant(left, right, param);
		}
		return TypeConformanceResult.FAILED;
	}

	@Override
	protected TypeConformanceResult doVisitTypeReference(TypeReference left, LightweightTypeReference right, TypeConformanceComputationArgument.Internal<TypeReference> param) {
		return TypeConformanceResult.FAILED;
	}
}