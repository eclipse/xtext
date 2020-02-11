/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.internal.util.WrapperTypeLookup;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParameterizedTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> typeArguments;
	private JvmType type;
	protected boolean resolved;
	
	public ParameterizedTypeReference(ITypeReferenceOwner owner, JvmType type) {
		super(owner);
		if (type == null) {
			throw new NullPointerException("type may not be null");
		}
		if (type instanceof JvmArrayType) {
			throw new IllegalArgumentException("type may not be an array type");
		}
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			EObject container = type.eContainer();
			if (container instanceof JvmDeclaredType) {
				checkStaticFlag((JvmDeclaredType)type);
			}
		}
		this.type = type;
		this.resolved = !(type instanceof JvmTypeParameter);
	}
	
	protected void checkStaticFlag(JvmDeclaredType type) {
		if (!type.isStatic()) {
			throw new IllegalArgumentException("type may not be an inner class");
		}
	}

	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_PARAMETERIZED_TYPE_REFERENCE;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmParameterizedTypeReference result = getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		if (typeArguments != null) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.getArguments().add(typeArgument.toTypeReference());
			}
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference getRawTypeReference() {
		if (typeArguments == null && type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			return this;
		}
		if (type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			return getOwner().newParameterizedTypeReference(type);
		}
		// TODO optimize
		return super.getRawTypeReference();
	}
	
	@Override
	public LightweightTypeReference getConstraintSubstitute() {
		if (type.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			List<LightweightTypeReference> superTypes = getSuperTypes();
			if (superTypes.size() == 1) {
				return superTypes.get(0).getConstraintSubstitute();
			} else {
				CompoundTypeReference compoundTypeReference = getOwner().newCompoundTypeReference(false);
				for(LightweightTypeReference superType: superTypes) {
					compoundTypeReference.addComponent(superType.getConstraintSubstitute());	
				}
				return compoundTypeReference;
			}
		}
		return this;
	}
	
	@Override
	public List<JvmType> getRawTypes() {
		if (type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			return Collections.singletonList(type);
		}
		// TODO optimize
		return super.getRawTypes();
	}
	
	protected boolean isTypeVisible(IVisibilityHelper visibilityHelper) {
		return !(type instanceof JvmDeclaredType) || visibilityHelper.isVisible((JvmDeclaredType)type);
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		if (isTypeVisible(visibilityHelper)) {
			if (typeArguments != null) {
				for(LightweightTypeReference typeArgument: typeArguments) {
					if (!typeArgument.isVisible(visibilityHelper)) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper) {
		if (isTypeVisible(visibilityHelper)) {
			JvmParameterizedTypeReference result = getTypesFactory().createJvmParameterizedTypeReference();
			result.setType(type);
			if (typeArguments != null) {
				for(LightweightTypeReference typeArgument: typeArguments) {
					result.getArguments().add(typeArgument.toJavaCompliantTypeReference());
				}
			}
			return result;
		} else {
			return toJavaCompliantTypeReference(getSuperTypes(), visibilityHelper);
		}
	}
	
	@Override
	public JvmType getType() {
		return type;
	}
	
	@Override
	public boolean isRawType() {
		EClass typeClass = type.eClass();
		if (typeClass == TypesPackage.Literals.JVM_GENERIC_TYPE && typeArguments == null) {
			return ((InternalEObject)type).eIsSet(TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS);
		} else if (typeClass == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) type;
			return isRawType(typeParameter, new RecursionGuard<JvmTypeParameter>());
		}
		return false;
	}
	
	// Here we already know that we don't have type arguments
	private boolean isRawType(JvmTypeParameter current, RecursionGuard<JvmTypeParameter> guard) {
		if (guard.tryNext(current)) {
			List<JvmTypeConstraint> constraints = current.getConstraints();
			for(int i = 0, size = constraints.size(); i < size; i++) {
				JvmTypeConstraint constraint = constraints.get(i);
				if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND && constraint.getTypeReference() != null) {
					JvmTypeReference superType = constraint.getTypeReference();
					JvmType rawSuperType = superType.getType();
					if (rawSuperType != null) {
						if (rawSuperType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
							if (isRawType((JvmTypeParameter) rawSuperType, guard)) {
								return true;
							}
						}
						if (rawSuperType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
							if (!((JvmGenericType) rawSuperType).getTypeParameters().isEmpty()) {
								if (superType.eClass() == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE) {
									JvmParameterizedTypeReference casted = (JvmParameterizedTypeReference) superType;
									if (casted.getArguments().isEmpty()) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (super.isOwnedBy(owner)) {
			if (typeArguments != null) {
				for(LightweightTypeReference typeArgument: typeArguments) {
					if (!typeArgument.isOwnedBy(owner))
						return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		Primitive primitiveKind = getPrimitiveKind();
		if (primitiveKind == null)
			return this;
		LightweightTypeReference result = WrapperTypeLookup.getWrapperType(this, primitiveKind);
		if (result == null)
			return this;
		return result;
	}
	
	@Override
	public LightweightTypeReference getPrimitiveIfWrapperType() {
		Primitive primitive = getPrimitiveKindIfWrapperType();
		if (primitive != null) {
			switch(primitive) {
				case Boolean:
					return findPrimitive("boolean");
				case Byte:
					return findPrimitive("byte");
				case Char:
					return findPrimitive("char");
				case Double:
					return findPrimitive("double");
				case Float:
					return findPrimitive("float");
				case Int:
					return findPrimitive("int");
				case Long:
					return findPrimitive("long");
				case Short:
					return findPrimitive("short");
				case Void:
					return findPrimitive("void");
				default:
					throw new IllegalStateException("Unknown primitive kind " + primitive);
			}
		}
		return this;
	}
	
	private LightweightTypeReference findPrimitive(String primitive) {
		JvmType result = (JvmType) getOwner().getContextResourceSet().getEObject(URIHelperConstants.PRIMITIVES_URI.appendFragment(primitive), true);
		if (result != null) {
			return getOwner().newParameterizedTypeReference(result);
		}
		throw new IllegalStateException("Cannot find primitive type: " + primitive);
	}
	
	@Override
	public boolean isAnonymous() {
		return type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) type).isAnonymous();
	}

	@Override
	public boolean isPrimitive() {
		return type.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE;
	}
	
	@Override
	/* @Nullable */
	public Primitive getPrimitiveKind() {
		if (type.eIsProxy())
			return null;
		if (type.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			String name = type.getSimpleName();
			switch (name.length()) {
				case 3:
					if ("int".equals(name)) {
						return Primitive.Int;
					}
					break;
				case 4:
					if ("long".equals(name)) {
						return Primitive.Long;
					} else if ("char".equals(name)) {
						return Primitive.Char;
					} else if ("byte".equals(name)) {
						return Primitive.Byte;
					}
					break;
				case 5:
					if ("short".equals(name)) {
						return Primitive.Short;
					} else if ("float".equals(name)) {
						return Primitive.Float;
					}
					break;
				case 6:
					if ("double".equals(name)) {
						return Primitive.Double;
					}
					break;
				case 7:
					if ("boolean".equals(name)) {
						return Primitive.Boolean;
					}
					break;
			}
		} else if (type.eClass() == TypesPackage.Literals.JVM_VOID) {
			return Primitive.Void;
		}
		return null;
	}
	
	@Override
	/* @Nullable */
	public Primitive getPrimitiveKindIfWrapperType() {
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			JvmGenericType casted = (JvmGenericType) type;
			return getPrimitiveKind(casted);
		} else if (type.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) type;
			return getPrimitiveKind(typeParameter, null);
		}
		return null;
	}
	
	/* @Nullable */
	private Primitive getPrimitiveKind(JvmTypeParameter type, /* @Nullable */ RecursionGuard<JvmTypeParameter> guard) {
		if (type.eIsProxy())
			return null;
		for(JvmTypeConstraint constraint: type.getConstraints()) {
			if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND) {
				JvmTypeReference upperBound = constraint.getTypeReference();
				if (upperBound != null) {
					JvmType upperBoundType = upperBound.getType();
					if (upperBoundType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
						return getPrimitiveKind((JvmGenericType) upperBoundType);
					}
					if (type == upperBoundType) {
						return null;
					}
					// guard against recursive deps
					if (upperBoundType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
						JvmTypeParameter upperBoundTypeParameter = (JvmTypeParameter) upperBoundType;
						if (guard == null) {
							guard = new RecursionGuard<JvmTypeParameter>();
							guard.tryNext(type);
						}
						if (guard.tryNext(upperBoundTypeParameter)) {
							return getPrimitiveKind(upperBoundTypeParameter, guard);
						}
						return null;
					}
				}
			}
		}
		return null;
	}
	
	/* @Nullable */
	private Primitive getPrimitiveKind(JvmGenericType type) {
		if (type.eIsProxy())
			return null;
		String name = type.getIdentifier();
		switch (name.length()) {
			case 17:
				if ("java.lang.Integer".equals(name)) {
					return Primitive.Int;
				} else if ("java.lang.Boolean".equals(name)) {
					return Primitive.Boolean;
				}
				break;
			case 14:
				if ("java.lang.Long".equals(name)) {
					return Primitive.Long;
				} else if ("java.lang.Byte".equals(name)) {
					return Primitive.Byte;
				} else if ("java.lang.Void".equals(name)) {
					return Primitive.Void;
				}
				break;
			case 15:
				if ("java.lang.Short".equals(name)) {
					return Primitive.Short;
				} else if ("java.lang.Float".equals(name)) {
					return Primitive.Float;
				}
				break;
			case 16:
				if ("java.lang.Double".equals(name)) {
					return Primitive.Double;
				}
				break;
			case 19:
				if ("java.lang.Character".equals(name)) {
					return Primitive.Char;
				}
				break;
		}
		return null;
	}
	
	@Override
	public boolean isPrimitiveVoid() {
		return type.eClass() == TypesPackage.Literals.JVM_VOID && !type.eIsProxy();
	}
	
	@Override
	public boolean isInterfaceType() {
		return type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) type).isInterface();
	}
	
	@Override
	public boolean isWrapper() {
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			JvmGenericType casted = (JvmGenericType) type;
			return isWrapper(casted);
		} else if (type.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) type;
			return isWrapper(typeParameter, null);
		}
		return false;
	}
	
	private boolean isWrapper(JvmTypeParameter typeParameter, /* @Nullable */ RecursionGuard<JvmTypeParameter> stack) {
		for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
			if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND) {
				JvmTypeReference upperBound = constraint.getTypeReference();
				if (upperBound != null) {
					JvmType upperBoundType = upperBound.getType();
					if (upperBoundType == null) {
						return false;
					}
					if (upperBoundType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
						return isWrapper((JvmGenericType)upperBoundType);
					}
					// guard against recursive deps
					if (upperBoundType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
						if (typeParameter == upperBoundType || stack != null && !stack.tryNext((JvmTypeParameter) upperBoundType)) {
							return false;
						}
						if (stack == null) {
							stack = new RecursionGuard<JvmTypeParameter>();
							stack.tryNext(typeParameter);
							stack.tryNext((JvmTypeParameter) upperBoundType);
						}
						return isWrapper((JvmTypeParameter) upperBoundType, stack);
					}
				}
			}
		}
		return false;
	}
	private boolean isWrapper(JvmGenericType type) {
		return getPrimitiveKind(type) != null;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		if (type instanceof JvmDeclaredType) {
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			if (!superTypes.isEmpty()) {
				ITypeReferenceOwner owner = getOwner();
				List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(superTypes.size());
				boolean isRawType = isRawType();
				for (JvmTypeReference superType : superTypes) {
					LightweightTypeReference lightweightSuperType = owner.toLightweightTypeReference(superType);
					if (!lightweightSuperType.isType(Object.class) || superTypes.size() == 1) {
						if (!lightweightSuperType.isUnknown()) {
							if (!isRawType) {
								result.add(substitutor.substitute(lightweightSuperType));
							} else {
								result.add(substitutor.substitute(lightweightSuperType).getRawTypeReference());
							}
						} else if (superTypes.size() == 1) {
							LightweightTypeReference topLevelType = internalFindTopLevelType(Object.class);
							if (topLevelType != null)
								result.add(topLevelType);
						}
					}
				}
				return result;
			}
		} else if (type instanceof JvmTypeParameter) {
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
			if (!constraints.isEmpty()) {
				ITypeReferenceOwner owner = getOwner();
				List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(constraints.size());
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
						LightweightTypeReference upperBound = owner.toLightweightTypeReference(constraint.getTypeReference());
						result.add(substitutor.substitute(upperBound));
					}
				}
				return result;
			}
		}
		return Collections.emptyList();
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSuperType(Class<?> rawType) {
		if (isType(rawType)) {
			return this;
		}
		if (isPrimitive() || isPrimitiveVoid() || rawType.isPrimitive() || rawType.isArray()) {
			return null;
		}
		if (type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER && Modifier.isFinal(rawType.getModifiers())) {
			return null;
		}
		if (Object.class.equals(rawType)) {
			// TODO: we know java.lang.Object is in the super type list
			// if it is still a proxy or one of the super types is a proxy,
			// it's faster to look it up in the resource set
			// otherwise it's faster to traverse the model directly to the root
			try {
				ResourceSet resourceSet = getOwner().getContextResourceSet();
				Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(rawType.getName()), true);
				JvmType type = (JvmType) typeResource.getContents().get(0);
				if (type == null)
					return null;
				return getOwner().newParameterizedTypeReference(type);
			} catch(WrappedException e) {
				/* no java project available */
				return null;
			}
		}
		boolean interfaceType = Modifier.isInterface(rawType.getModifiers());
		if (isInterfaceType() && !interfaceType) {
			// only Object can be a super class of an interface
			return null;
		}
		String typeName = rawType.getName();
		return getSuperTypeByName(typeName, interfaceType);
	}
	
	/* @Nullable */
	private LightweightTypeReference getSuperTypeByName(String typeName, boolean interfaceType) {
		JvmTypeReference superType = getSuperTypeByName(typeName, interfaceType, type, new RecursionGuard<JvmType>());
		if (superType != null) {
			JvmType rawType = superType.getType();
			if (isRawType()) {
				return createRawTypeReference(rawType);
			}
			if (superType.eClass() == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE) {
				if (((JvmParameterizedTypeReference) superType).getArguments().isEmpty()) {
					return getOwner().newParameterizedTypeReference(rawType);
				}
			}
			LightweightTypeReference unresolved = getOwner().toLightweightTypeReference(rawType);
			TypeParameterSubstitutor<?> substitutor = createSubstitutor();
			LightweightTypeReference result = substitutor.substitute(unresolved);
			return result;
		}
		return null;
	}
	
	/* @Nullable */
	private JvmTypeReference getSuperTypeByName(String typeName, boolean interfaceType, JvmType thisType, RecursionGuard<JvmType> guard) {
		EClass thisTypeEClass = thisType.eClass();
		if (!interfaceType && thisTypeEClass == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) thisType).isInterface()) {
			return null;
		}
		if (thisTypeEClass == TypesPackage.Literals.JVM_VOID || thisTypeEClass == TypesPackage.Literals.JVM_PRIMITIVE_TYPE) {
			return null;
		}
		if (typeName.equals(thisType.getIdentifier()) || !guard.tryNext(thisType)) {
			return null;
		}
		if (thisTypeEClass != TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			if (thisTypeEClass != TypesPackage.Literals.JVM_ARRAY_TYPE) {
				List<JvmTypeReference> superTypes = ((JvmDeclaredType) thisType).getSuperTypes();
				for(int i = 0, size = superTypes.size(); i < size; i++) {
					JvmTypeReference superType = superTypes.get(i);
					JvmType rawSuperType = superType.getType();
					if (rawSuperType != null) {
						if (typeName.equals(rawSuperType.getIdentifier()))
							return superType;
						JvmTypeReference result = getSuperTypeByName(typeName, interfaceType, rawSuperType, guard);
						if (result != null)
							return result;
					}
				}
			}
		} else {
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) thisType).getConstraints();
			for(int i = 0, size = constraints.size(); i < size; i++) {
				JvmTypeConstraint constraint = constraints.get(i);
				if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND && constraint.getTypeReference() != null) {
					JvmTypeReference superType = constraint.getTypeReference();
					JvmType rawSuperType = superType.getType();
					if (rawSuperType != null) {
						if (rawSuperType.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER && typeName.equals(rawSuperType.getIdentifier())) {
							return superType;
						}
						JvmTypeReference result = getSuperTypeByName(typeName, interfaceType, rawSuperType, guard);
						if (result != null)
							return result;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference getSuperType(JvmType rawType) {
		Object rawResult = internalGetSuperType(rawType);
		if (rawResult instanceof ParameterizedTypeReference) {
			return (LightweightTypeReference) rawResult;
		} else if (rawResult != null) {
			JvmTypeReference superType = (JvmTypeReference) rawResult;
			if (isRawType()) {
				return createRawTypeReference(rawType);
			}
			if (superType.eClass() == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE) {
				if (((JvmParameterizedTypeReference) superType).getArguments().isEmpty()) {
					return getOwner().newParameterizedTypeReference(rawType);
				}
			}
			LightweightTypeReference unresolved = getOwner().toLightweightTypeReference(rawType);
			TypeParameterSubstitutor<?> substitutor = createSubstitutor();
			LightweightTypeReference result = substitutor.substitute(unresolved);
			return result;
		}
		return null;
	}
	
	/* @Nullable */
	public LightweightTypeReference getRawSuperType(JvmType rawType) {
		Object result = internalGetSuperType(rawType);
		if (result instanceof ParameterizedTypeReference) {
			return (LightweightTypeReference) result;
		} else if (result != null) {
			return  createRawTypeReference(rawType);
		}
		return null;
	}
	
	protected LightweightTypeReference createRawTypeReference(JvmType rawType) {
		return getOwner().toPlainTypeReference(rawType);
	}
	
	protected boolean isInner(JvmType type) {
		if (type.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			if (type.eContainer() instanceof JvmDeclaredType) {
				return !((JvmGenericType) type).isStatic();
			}
		}
		return false;
	}
	
	/**
	 * Returns <code>null</code> if no such super type exists, a {@link LightweightTypeReference}
	 * if it is more efficient to create it directly, or a {@link JvmTypeReference} with or without unresolved
	 * type arguments that can be processed later on.
	 */
	/* @Nullable */
	private Object internalGetSuperType(JvmType rawType) {
		if (rawType == type) {
			return this;
		}
		if (isPrimitive() || isPrimitiveVoid()) {
			return null;
		}
		EClass otherEClass = rawType.eClass();
		if (otherEClass == TypesPackage.Literals.JVM_PRIMITIVE_TYPE || otherEClass == TypesPackage.Literals.JVM_VOID) {
			return null;
		}
		boolean interfaceType = false;
		if (otherEClass != TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			if (Object.class.getName().equals(rawType.getIdentifier())) {
				return getOwner().newParameterizedTypeReference(rawType);
			}
			if (otherEClass != TypesPackage.Literals.JVM_ARRAY_TYPE) {
				// declared type
				JvmDeclaredType declaredType = (JvmDeclaredType) rawType;
				if (type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER && declaredType.isFinal()) {
					return null;
				}
			} else if (isInterfaceType()) {
				return null;
			}
			if (otherEClass == TypesPackage.Literals.JVM_GENERIC_TYPE && !(interfaceType = ((JvmGenericType) rawType).isInterface()) && isInterfaceType()) {
				return null;
			}
		}
		JvmTypeReference superType = getSuperType(rawType, interfaceType, type, new RecursionGuard<JvmType>());
		return superType;
	}

	/* @Nullable */
	private JvmTypeReference getSuperType(JvmType rawType, boolean interfaceType, JvmType thisType, RecursionGuard<JvmType> guard) {
		if (thisType == rawType || !interfaceType && thisType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE && ((JvmGenericType) thisType).isInterface()) {
			return null;
		}
		if (!guard.tryNext(thisType)) {
			return null;
		}
		if (thisType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) thisType).getConstraints();
			for(int i = 0, size = constraints.size(); i < size; i++) {
				JvmTypeConstraint constraint = constraints.get(i);
				JvmTypeReference superType = constraint.getTypeReference();
				if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND && superType != null) {
					JvmType rawSuperType = superType.getType();
					if (rawSuperType != null) {
						if (rawType == rawSuperType) {
							return superType;
						}
						JvmTypeReference result = getSuperType(rawType, interfaceType, rawSuperType, guard);
						if (result != null)
							return result;
					}
				}
			}
		} else if (thisType.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			String identifier = rawType.getIdentifier();
			if (Cloneable.class.getName().equals(identifier)
					|| Serializable.class.getName().equals(identifier)
					|| Object.class.getName().equals(identifier)) {
				return getServices().getTypeReferences().createTypeRef(rawType);
			}
		} else if (thisType.eClass() != TypesPackage.Literals.JVM_VOID) {
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) thisType).getSuperTypes();
			for(int i = 0, size = superTypes.size(); i < size; i++) {
				JvmTypeReference superType = superTypes.get(i);
				JvmType rawSuperType = superType.getType();
				if (rawSuperType != null) {
					if (rawType == rawSuperType)
						return superType;
					JvmTypeReference result = getSuperType(rawType, interfaceType, rawSuperType, guard);
					if (result != null)
						return result;
				}
			}
		}
		return null;
	}
	
	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		return expose(typeArguments);
	}
	
	@Override
	protected ParameterizedTypeReference doCopyInto(ITypeReferenceOwner owner) {
		ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
		copyTypeArguments(result, owner);
		return result;
	}

	protected void copyTypeArguments(ParameterizedTypeReference result, ITypeReferenceOwner owner) {
		if (typeArguments != null && !typeArguments.isEmpty()) {
			for(LightweightTypeReference typeArgument: typeArguments) {
				result.addTypeArgument(typeArgument.copyInto(owner));
			}
		}
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}

	public void addTypeArgument(LightweightTypeReference argument) {
		if (argument == null) {
			throw new NullPointerException("argument may not be null");
		}
		if (!argument.isOwnedBy(getOwner())) {
			throw new IllegalArgumentException("argument is not valid in current context");
		}
		if (typeArguments == null)
			typeArguments = Lists.newArrayListWithCapacity(2);
		typeArguments.add(argument);
		resolved = resolved && argument.isResolved();
	}
	
	@Override
	public String getSimpleName() {
		return getAsString(type.getSimpleName(), SimpleNameFunction.INSTANCE);
	}
	
	@Override
	public String getIdentifier() {
		return getAsString(type.getIdentifier(), IdentifierFunction.INSTANCE);
	}
	
	@Override
	public String getUniqueIdentifier() {
		return getAsString(getUniqueIdentifier(type), UniqueIdentifierFunction.INSTANCE);
	}

	@Override
	public String getJavaIdentifier() {
		return getAsString(type.getIdentifier(), JavaIdentifierFunction.INSTANCE);
	}
	
	protected String getAsString(String type, Function<LightweightTypeReference, String> format) {
		if (typeArguments != null)
			return type + "<" + Joiner.on(", ").join(Iterables.transform(typeArguments, format)) + ">";
		return type;
	}

	@Override
	public boolean isType(Class<?> clazz) {
		return type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER && 
				clazz.getName().equals(type.getIdentifier());
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitParameterizedTypeReference(this, param);
	}
	
	@Override
	/* @Nullable */
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	/* @Nullable */
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitParameterizedTypeReference(this, param);
	}

	@Override
	public FunctionTypeKind getFunctionTypeKind() {
		FunctionTypes functionTypes = getServices().getFunctionTypes();
		return functionTypes.getFunctionTypeKind(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see FunctionTypes#getAsFunctionTypeReference(ParameterizedTypeReference)
	 */
	@Override
	/* @Nullable */
	public FunctionTypeReference getAsFunctionTypeReference() {
		FunctionTypes functionTypes = getServices().getFunctionTypes();
		return functionTypes.getAsFunctionTypeReference(this);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see FunctionTypes#tryConvertToFunctionTypeReference(ParameterizedTypeReference, boolean)
	 */
	@Override
	/* @Nullable */
	public FunctionTypeReference tryConvertToFunctionTypeReference(boolean rawType) {
		FunctionTypes functionTypes = getServices().getFunctionTypes();
		return functionTypes.tryConvertToFunctionTypeReference(this, rawType);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ArrayTypes#tryConvertToArray(ParameterizedTypeReference)
	 */
	@Override
	/* @Nullable */
	public ArrayTypeReference tryConvertToArray() {
		ArrayTypes arrayTypes = getServices().getArrayTypes();
		return arrayTypes.tryConvertToArray(this);
	}
	
	@Override
	/* @Nullable */
	public LightweightTypeReference tryConvertToListType() {
		if (isAssignableFrom(List.class))
			return this;
		return super.tryConvertToListType();
	}
	
	/**
	 * Returns a projection of this type to the instance level. That is, type arguments will 
	 * be replaced by their invariant bounds.
	 * 
	 * The instance projection of <code>ArrayList&lt;? extends Iterable&lt;? extends String&gt;&gt;</code>
	 * is <code>ArrayList&lt;Iterable&lt;? extends String&gt;&gt;</code> since it is possible to create instances
	 * of <code>ArrayList&lt;Iterable&lt;? extends String&gt;&gt;</code>.
	 */
	public ParameterizedTypeReference toInstanceTypeReference() {
		ParameterizedTypeReference result = getOwner().newParameterizedTypeReference(getType());
		for(LightweightTypeReference typeArgument: getTypeArguments()) {
			result.addTypeArgument(typeArgument.getInvariantBoundSubstitute());
		}
		return result;
	}
}
