/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem.newImpl;

import static org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class NewTypeConformanceComputer {

	public final static int rawType = 1 << 0;
	public final static int asTypeArgument = rawType << 1;
	public final static int allowRawTypeConversion = asTypeArgument << 1;
	public final static int allowPrimitiveConversion = allowRawTypeConversion << 1;
	public final static int allowPrimitiveWidening = allowPrimitiveConversion << 1;
	public final static int unboundComputationAddsHints = allowPrimitiveWidening << 1;
	public final static int allowSynonyms = unboundComputationAddsHints << 1;
	public final static int success = allowSynonyms << 1;
	public final static int demandConversion = success << 1;
	public final static int subtype = demandConversion << 1;
	public final static int primitiveWidening = subtype << 1;
	public final static int unboxing = primitiveWidening << 1;
	public final static int boxing = unboxing << 1;
	public final static int rawTypeConversion = boxing << 1;
	public final static int synonym = rawTypeConversion << 1;
	
	public boolean isConformant(LightweightTypeReference left, LightweightTypeReference right) {
		return (isConformant(left, right, allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms | allowRawTypeConversion) & success) != 0;
	}
	
	public int isConformant(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		if (left == right && left != null) // TODO handle null
			return success;
		if ((flags & rawType) != 0 || left.isRawType() || right.isRawType()) {
			return doIsConformant(left.getRawTypeReference(), right.getRawTypeReference(), flags | rawType);
		}
		return doIsConformant(left, right, flags);
	}
	
	public int doIsConformant(LightweightTypeReference left, LightweightTypeReference right, int flags) {
		int rightKind = right.getKind();
		if (rightKind == KIND_UNKNOWN_TYPE_REFERENCE) {
			return flags | success;
		} else if (rightKind == KIND_UNBOUND_TYPE_REFERENCE) {
			return doIsConformant(left, (UnboundTypeReference) right, flags);
		}
		switch(left.getKind()) {
			case KIND_UNKNOWN_TYPE_REFERENCE: {
				return flags | success;
			}
			case KIND_FUNCTION_TYPE_REFERENCE: {
				switch(rightKind) {
					case KIND_FUNCTION_TYPE_REFERENCE: {
						return doIsConformant((FunctionTypeReference)left, (FunctionTypeReference)right, flags);
					}
					case KIND_PARAMETERIZED_TYPE_REFERENCE: {
						return doIsConformant((FunctionTypeReference)left, (ParameterizedTypeReference)right, flags);
					}
				}
				// missing break is intentional
			}
			case KIND_PARAMETERIZED_TYPE_REFERENCE: {
				switch(rightKind) {
					case KIND_ARRAY_TYPE_REFERENCE: {
						return doIsConformant((ParameterizedTypeReference)left, (ArrayTypeReference)right, flags);
					}
					case KIND_FUNCTION_TYPE_REFERENCE: {
						return doIsConformant((ParameterizedTypeReference)left, (FunctionTypeReference)right, flags);
					}
					case KIND_PARAMETERIZED_TYPE_REFERENCE: {
						return doIsConformant((ParameterizedTypeReference)left, (ParameterizedTypeReference)right, flags);
					}
					case KIND_ANY_TYPE_REFERENCE: {
						return doIsConformant((ParameterizedTypeReference)left, (AnyTypeReference)right, flags);
					}
					case KIND_WILDCARD_TYPE_REFERENCE: {
						return doIsConformant(left, (WildcardTypeReference) right, flags);
					}
				}
				return flags;
			}
			case KIND_ARRAY_TYPE_REFERENCE: {
				switch(rightKind) {
					case KIND_ARRAY_TYPE_REFERENCE: {
						return doIsConformant((ArrayTypeReference)left, (ArrayTypeReference)right, flags);
					}
					case KIND_FUNCTION_TYPE_REFERENCE:
					case KIND_PARAMETERIZED_TYPE_REFERENCE: {
						return doIsConformant((ArrayTypeReference)left, (ParameterizedTypeReference)right, flags);
					}
					case KIND_ANY_TYPE_REFERENCE: {
						return doIsConformant((ArrayTypeReference)left, (AnyTypeReference)right, flags);
					}
					case KIND_WILDCARD_TYPE_REFERENCE: {
						return doIsConformant(left, (WildcardTypeReference) right, flags);
					}
				}
				return flags;
			}
			case KIND_COMPOUND_TYPE_REFERENCE: {
				return flags;
			}
			case KIND_ANY_TYPE_REFERENCE: {
				switch(rightKind) {
					case KIND_ANY_TYPE_REFERENCE:
						return flags | success;
					case KIND_WILDCARD_TYPE_REFERENCE: {
						return doIsConformant(left, (WildcardTypeReference) right, flags);
					}
				}
				return flags;
				
			}
			case KIND_UNBOUND_TYPE_REFERENCE: {
				
			}
			case KIND_WILDCARD_TYPE_REFERENCE: {
				switch(rightKind) {
					case KIND_WILDCARD_TYPE_REFERENCE: {
						return doIsConformant((WildcardTypeReference) left, (WildcardTypeReference) right, flags);
					}
					default: {
						return doIsConformant((WildcardTypeReference) left, right, flags);
					}
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, ArrayTypeReference right, int flags) {
		if (left.isType(Object.class) || left.isType(Serializable.class) || left.isType(Cloneable.class)) {
			return flags | success | subtype;
		}
		// Arrays are generally assignable to List and its supertypes
		if (left.isType(List.class) || left.isType(Collection.class) || left.isType(Iterable.class)) {
			List<LightweightTypeReference> arguments = left.getTypeArguments();
			if (arguments.isEmpty()) { // type argument is bound to Object
				return flags | success | demandConversion;
			}
			LightweightTypeReference componentType = getWrapperTypeIfPrimitive(right.getComponentType());
			int result = doIsConformant(arguments.get(0), componentType, flags);
			if ((result & success) != 0) {
				return result | demandConversion;
			}
		}
		return flags;
	}
	
	protected int doIsConformant(ArrayTypeReference left, ArrayTypeReference right, int flags) {
		LightweightTypeReference leftComponent = left.getComponentType();
		LightweightTypeReference rightComponent = right.getComponentType();
		return doIsConformant(leftComponent, rightComponent, flags & ~(allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms));
	}
	
	protected int doIsConformant(ArrayTypeReference left, AnyTypeReference right, int flags) {
		return flags | success;
	}
	
	protected int doIsConformant(ArrayTypeReference left, ParameterizedTypeReference right, int flags) {
		if ((flags & asTypeArgument) == 0 && (flags & allowSynonyms) != 0) {
			ArrayTypeReference rightAsArray = right.tryConvertToArray();
			if (rightAsArray != null) {
				LightweightTypeReference leftComponent = getWrapperTypeIfPrimitive(left.getComponentType());
				LightweightTypeReference rightComponent = rightAsArray.getComponentType();
				int result = doIsConformant(leftComponent, rightComponent, flags & ~(allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms));
				if ((result & success) != 0) {
					return result | demandConversion | synonym;
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(LightweightTypeReference left, WildcardTypeReference right, int flags) {
		if ((flags & asTypeArgument) == 0) {
			for(LightweightTypeReference upperBound: right.getUpperBounds()) {
				int result = doIsConformant(left, upperBound, flags);
				if ((result & success) != 0) {
					return result;
				}
			}
		}
		return flags;
	}
	
	protected int doIsConformant(WildcardTypeReference left, LightweightTypeReference right, int flags) {
		if ((flags & asTypeArgument) != 0) {
			LightweightTypeReference lowerBound = left.getLowerBound();
			if (lowerBound != null) {
				int result = doIsConformant(right, lowerBound, flags & ~(allowRawTypeConversion | asTypeArgument | allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms));
				if ((result & success) == 0) {
					return result;
				}
			}
			for(LightweightTypeReference leftUpperBound: left.getUpperBounds()) {
				int result = doIsConformant(leftUpperBound, right, flags & ~(allowRawTypeConversion | asTypeArgument | allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms));
				if ((result & success) == 0) {
					return result;
				}
			}
			return flags | success | subtype;
		}
		return flags;
	}
	
	protected int doIsConformant(WildcardTypeReference left, WildcardTypeReference right, int flags) {
		if ((flags & asTypeArgument) != 0) {
			LightweightTypeReference leftLowerBound = left.getLowerBound();
			if (leftLowerBound != null) {
				LightweightTypeReference rightLowerBound = right.getLowerBound();
				if (rightLowerBound != null) {
					int result = doIsConformant(rightLowerBound, leftLowerBound, flags & ~(allowRawTypeConversion | asTypeArgument | allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms));
					return result;
				}
				return flags;
			}
			int rightIsSubtype = 0;
			for(LightweightTypeReference leftUpperBound: left.getUpperBounds()) {
				int result = doIsConformant(leftUpperBound, right, flags & ~(allowRawTypeConversion | asTypeArgument | allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms));
				if ((result & success) == 0) {
					return result;
				}
				rightIsSubtype = rightIsSubtype | (result & subtype);
			}
			return flags | success | rightIsSubtype;
		}
		return flags;
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, AnyTypeReference right, int flags) {
		if (left.isPrimitive() || left.isPrimitiveVoid())
			return flags;
		return flags | success;
	}

	protected int doIsConformant(LightweightTypeReference left, UnboundTypeReference right, int flags) {
		if (left.getType() == right.getType() || left.isType(Object.class)) {
			return flags | success;
		}
		boolean doesNotHaveSignificantHints = false;
		if (right.canResolveTo(left) || (flags & asTypeArgument) != 0 && (doesNotHaveSignificantHints = !right.hasSignificantHints())) {
			if ((flags & unboundComputationAddsHints) != 0 && doesNotHaveSignificantHints) {
				right.acceptHint(left, BoundTypeArgumentSource.INFERRED_LATER, left, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
			}
			return flags | success;
		}
		right.tryResolve();
		LightweightTypeReference resolvedTo = right.getResolvedTo();
		if (resolvedTo != null) {
			return doIsConformant(left, resolvedTo, flags);
		}
		return flags;
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, FunctionTypeReference right, int flags) {
		FunctionTypeReference convertedLeft = left.getAsFunctionTypeReference();
		if (convertedLeft != null) {
			return doIsConformant(convertedLeft, right, flags);
		}
		if (right.isFunctionType()) {
			convertedLeft = left.tryConvertToFunctionTypeReference(false);
			if (convertedLeft != null) {
				int result = doIsConformant(convertedLeft, right, flags);
				if ((result & success) != 0) {
					return result | demandConversion;
				}
			}
		}
		return doIsConformant(left, (ParameterizedTypeReference) right, flags);
	}
	
	protected int doIsConformant(FunctionTypeReference left, FunctionTypeReference right, int flags) {
		List<LightweightTypeReference> leftParameterTypes = left.getParameterTypes();
		List<LightweightTypeReference> rightParameterTypes = right.getParameterTypes();
		if (leftParameterTypes.size() != rightParameterTypes.size()) {
			return flags;
		}
		LightweightTypeReference leftReturnType = left.getReturnType();
		LightweightTypeReference rightReturnType = right.getReturnType();
		if (leftReturnType!=rightReturnType && (leftReturnType == null || rightReturnType == null)) {
			return flags;
		}
		boolean leftIsVoid = leftReturnType != null && leftReturnType.isPrimitiveVoid();
		boolean rightIsVoid = rightReturnType != null && rightReturnType.isPrimitiveVoid();
		if (leftIsVoid) {
			if (!rightIsVoid) {
				return flags;
			}
		} else if (rightIsVoid) {
			return flags;
		}
		if (leftReturnType != rightReturnType && !leftIsVoid && (doIsConformant(leftReturnType, rightReturnType, flags & ~allowPrimitiveWidening) & success) == 0) {
			return flags;
		}
		for(int i = 0; i < leftParameterTypes.size(); i++) {
			LightweightTypeReference leftParameterType = leftParameterTypes.get(i);
			LightweightTypeReference rightParameterType = rightParameterTypes.get(i);
			if (leftParameterType!=rightParameterType && (leftParameterType == null || rightParameterType == null)) {
				return flags;
			}
			if ((doIsConformant(rightParameterType, leftParameterType, flags & ~allowPrimitiveWidening) & success) == 0) {
				return flags;
			} 
		}
		return flags | success;
	}
	
	protected int doIsConformant(FunctionTypeReference left, ParameterizedTypeReference right, int flags) {
		FunctionTypeReference convertedRight = right.getAsFunctionTypeReference();
		if (convertedRight != null) {
			return doIsConformant(left, convertedRight, flags);
		}
		if (left.isFunctionType()) {
			convertedRight = right.tryConvertToFunctionTypeReference(false);
			if (convertedRight != null) {
				int result = doIsConformant(left, convertedRight, flags);
				if ((result & success) != 0) {
					return result | demandConversion;
				}
			}
		}
		return doIsConformant((ParameterizedTypeReference) left, right, flags);
	}
	
	protected int doIsConformant(ParameterizedTypeReference left, ParameterizedTypeReference right, int flags) {
		if (left.getType() == right.getType()) {
			return doIsConformantTypeArguments(left, right, flags);
		}
		if (left.isPrimitiveVoid() || right.isPrimitiveVoid()) {
			return flags;
		}
		if ((flags & (allowPrimitiveConversion | allowPrimitiveWidening)) != 0) {
			Primitive leftPrimitiveKind = getPrimitiveKind(left);
			if (leftPrimitiveKind != null) {
				Primitive rightPrimitiveKind = getPrimitiveKind(right);
				if (rightPrimitiveKind != null) {
					if ((flags & allowPrimitiveWidening) != 0) {
						if (isWideningConversion(leftPrimitiveKind, rightPrimitiveKind)) {
							return flags | success | primitiveWidening;
						}
					}
				} else if ((flags & allowPrimitiveConversion) != 0) {
					rightPrimitiveKind = getPrimitiveKindFromWrapper(right);
					if (rightPrimitiveKind != null) {
						if (rightPrimitiveKind == leftPrimitiveKind || isWideningConversion(leftPrimitiveKind, rightPrimitiveKind)) {
							return flags | success | unboxing;
						}
					}
				}
				if (!(right.getType().eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER))
					return flags;
			} else if ((flags & allowPrimitiveConversion) != 0) {
				Primitive rightPrimitiveKind = getPrimitiveKind(right);
				if (rightPrimitiveKind != null) {
					if (left.isType(Object.class)) {
						return flags | success | boxing;
					}
					if (left.isType(String.class)) {
						return flags;
					}
					LightweightTypeReference wrapper = getWrapperType(right, rightPrimitiveKind);
					int result = doIsConformant(left, (ParameterizedTypeReference) wrapper, flags);
					if ((result & success) != 0)
						return result | boxing;
					return flags;
				}
			}
		} else if (left.isPrimitive() || right.isPrimitive()) {
			return flags;
		}
		if ((flags & asTypeArgument) != 0)
			return flags;
		if (left.isType(Object.class)) {
			return flags | success | subtype;
		}
		JvmType leftType = left.getType();
		JvmType rightType = right.getType();
		if (leftType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			JvmGenericType castedLeftType = (JvmGenericType) leftType;
			if (castedLeftType.isFinal()) {
				if (rightType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER && right.getSuperType(castedLeftType) != null) {
					return flags | success | subtype;
				}
				return flags;
			}
			if (!castedLeftType.isInterface() && rightType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) rightType).isInterface()) {
				return flags;
			}
		} else if (leftType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			if (rightType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER && right.getSuperType(leftType) != null) {
				return flags | success | subtype;
			}
			return flags;
		} else if (leftType.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			leftType = getWrapperTypeIfPrimitive(left).getType();
		}
		ParameterizedTypeReference rightSuperType = (ParameterizedTypeReference) right.getSuperType(leftType);
		if (rightSuperType != null) {
			return doIsConformantTypeArguments(left, rightSuperType, flags); 
		}
		return isAssignableAsFunctionType(left, right, flags);
	}
	
	protected int isAssignableAsFunctionType(ParameterizedTypeReference left,
			ParameterizedTypeReference right, int flags) {
		// TODO only if param allows conversion, e.g. not param.asTypeArgument or better !param.javaConformance?
		FunctionTypeReference leftFunctionType = left.getAsFunctionTypeReference();
		if (leftFunctionType != null) {
			FunctionTypeReference rightFunctionType = right.getAsFunctionTypeReference();
			if (rightFunctionType != null) {
				return flags;
			}
			rightFunctionType = right.tryConvertToFunctionTypeReference(false);
			if (rightFunctionType != null) {
				int result = doIsConformant(leftFunctionType, rightFunctionType, flags);
				if ((result & success) != 0) {
					return result | demandConversion;
				}
			}
		} else {
			FunctionTypeReference rightFunctionType = right.getAsFunctionTypeReference();
			if (rightFunctionType != null) {
				leftFunctionType = left.tryConvertToFunctionTypeReference(false);
				if (leftFunctionType != null) {
					int result = doIsConformant(leftFunctionType, rightFunctionType, flags);
					if ((result & success) != 0) {
						return result | demandConversion;
					}
				}
			}
		}
		return flags;
	}
	
	private boolean isWideningConversion(Primitive leftPrimitiveKind, Primitive rightPrimitiveKind) {
		switch (rightPrimitiveKind) {
			case Byte :
				switch (leftPrimitiveKind) { 
					case Void:
					case Byte:
						return false;
					default:
						return true;
				}
			case Short :
			case Char :
				switch (leftPrimitiveKind) { 
					case Void:
					case Byte:
					case Short:
					case Char:
						return false;
					default:
						return true;
				}
			case Int :
				switch (leftPrimitiveKind) { 
					case Long:
					case Float:
					case Double:
						return true;
					default:
						return false;
				}
			case Long :
				switch (leftPrimitiveKind) { 
					case Float:
					case Double:
						return true;
					default:
						return false;
				}
			case Float :
				return leftPrimitiveKind == Primitive.Double;
			default :
				return false;
		}
	}
	
	protected LightweightTypeReference getWrapperTypeIfPrimitive(LightweightTypeReference type) {
		Primitive primitiveKind = getPrimitiveKind(type);
		return getWrapperType(type, primitiveKind);
	}

	protected LightweightTypeReference getWrapperType(LightweightTypeReference type, Primitive primitiveKind) {
		if (primitiveKind != null) {
			switch(primitiveKind) {
				case Boolean:
					return findTopLevelType(type, "java.lang.Boolean");
				case Byte:
					return findTopLevelType(type, "java.lang.Byte");
				case Char:
					return findTopLevelType(type, "java.lang.Character");
				case Double:
					return findTopLevelType(type, "java.lang.Double");
				case Float:
					return findTopLevelType(type, "java.lang.Float");
				case Int:
					return findTopLevelType(type, "java.lang.Integer");
				case Long:
					return findTopLevelType(type, "java.lang.Long");
				case Short:
					return findTopLevelType(type, "java.lang.Short");
				case Void:
					return findTopLevelType(type, "java.lang.Void");
			}
		}
		return type;
	}

	private LightweightTypeReference findTopLevelType(LightweightTypeReference typeReference, String typeName) {
		ITypeReferenceOwner owner = typeReference.getOwner();
		ResourceSet resourceSet = owner.getContextResourceSet();
		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(typeName), true);
		JvmType type = (JvmType) typeResource.getContents().get(0);
		if (type == null)
			return typeReference;
		return new ParameterizedTypeReference(owner, type);
	}

	protected Primitive getPrimitiveKind(LightweightTypeReference reference) {
		JvmType type = reference.getType();
		if (type.eIsProxy())
			return null;
		if (type.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			String name = type.getSimpleName();
			if ("boolean".equals(name)) {
				return Primitive.Boolean;
			} else if ("int".equals(name)) {
				return Primitive.Int;
			} else if ("long".equals(name)) {
				return Primitive.Long;
			} else if ("double".equals(name)) {
				return Primitive.Double;
			} else if ("char".equals(name)) {
				return Primitive.Char;
			} else if ("byte".equals(name)) {
				return Primitive.Byte;
			} else if ("short".equals(name)) {
				return Primitive.Short;
			} else if ("float".equals(name)) {
				return Primitive.Float;
			}
		} else if (type.eClass() == TypesPackage.Literals.JVM_VOID) {
			return Primitive.Void;
		}
		return null;
	}
	
	protected Primitive getPrimitiveKindFromWrapper(LightweightTypeReference reference) {
		JvmType type = reference.getType();
		if (type.eIsProxy())
			return null;
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			String name = type.getIdentifier();
			if ("java.lang.Boolean".equals(name)) {
				return Primitive.Boolean;
			} else if ("java.lang.Integer".equals(name)) {
				return Primitive.Int;
			} else if ("java.lang.Long".equals(name)) {
				return Primitive.Long;
			} else if ("java.lang.Double".equals(name)) {
				return Primitive.Double;
			} else if ("java.lang.Character".equals(name)) {
				return Primitive.Char;
			} else if ("java.lang.Byte".equals(name)) {
				return Primitive.Byte;
			} else if ("java.lang.Short".equals(name)) {
				return Primitive.Short;
			} else if ("java.lang.Float".equals(name)) {
				return Primitive.Float;
			} else if ("java.lang.Void".equals(name)) {
				return Primitive.Void;
			}
		}
		return null;
	}
	
	protected int doIsConformantTypeArguments(ParameterizedTypeReference left, ParameterizedTypeReference right, int flags) {
		List<LightweightTypeReference> leftTypeArguments = left.getTypeArguments();
		List<LightweightTypeReference> rightTypeArguments = right.getTypeArguments();
		int size = leftTypeArguments.size();
		int argumentFlags = (flags | asTypeArgument) & ~(allowPrimitiveConversion | allowPrimitiveWidening | allowSynonyms | allowRawTypeConversion);  
		if (size == rightTypeArguments.size()) {
			for(int i = 0; i < size; i++) {
				if ((doIsConformant(leftTypeArguments.get(i), rightTypeArguments.get(i), argumentFlags) & success) == 0) {
					return flags;
				}
			}
		} else if ((flags & allowRawTypeConversion) != 0) {
			if (size == 0 || rightTypeArguments.isEmpty()) {
				return flags | success | rawTypeConversion;
			}
		} else {
			return flags;
		}
		return flags | success;
	}
	
}