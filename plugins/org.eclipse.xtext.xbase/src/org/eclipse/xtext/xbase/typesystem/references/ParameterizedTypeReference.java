/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.Primitives;
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
@NonNullByDefault
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
		this.type = type;
		// TODO check against owner or specialized representation of the owner
		this.resolved = !(type instanceof JvmTypeParameter);
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
		// TODO optimize
		return super.getRawTypeReference();
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
		if (isPrimitive()) {
			Primitives primitives = getOwner().getServices().getPrimitives();
			JvmType wrapperType = primitives.getWrapperType((JvmPrimitiveType) type);
			return new ParameterizedTypeReference(getOwner(), wrapperType);
		}
		return this;
	}
	
	@Override
	public LightweightTypeReference getPrimitiveIfWrapperType() {
		if (type.eClass() != TypesPackage.Literals.JVM_TYPE_PARAMETER && isWrapper()) {
			Primitives primitives = getOwner().getServices().getPrimitives();
			JvmType primitiveType = primitives.getPrimitiveTypeIfWrapper((JvmDeclaredType) type);
			if (primitiveType != null) {
				return new ParameterizedTypeReference(getOwner(), primitiveType);
			}
		}
		return this;
	}
	
	@Override
	public boolean isPrimitive() {
		return type.eClass() == TypesPackage.Literals.JVM_PRIMITIVE_TYPE;
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
	
	private boolean isWrapper(JvmTypeParameter typeParameter, @Nullable List<JvmTypeParameter> stack) {
		for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
			if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND) {
				JvmTypeReference upperBound = constraint.getTypeReference();
				if (upperBound != null) {
					JvmType upperBoundType = upperBound.getType();
					if (upperBoundType.eClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
						return isWrapper((JvmGenericType)upperBoundType);
					}
					// guard against recursive deps
					if (upperBoundType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
						if (typeParameter == upperBoundType || stack != null && stack.contains(upperBoundType)) {
							return false;
						}
						if (stack == null) {
							stack = new ArrayList<JvmTypeParameter>(4);
							stack.add(typeParameter);
						}
						stack.add((JvmTypeParameter) upperBoundType);
						return isWrapper((JvmTypeParameter) upperBoundType, stack);
					}
				}
			}
		}
		return false;
	}
	private boolean isWrapper(JvmGenericType type) {
		// all wrapper types are concrete, final top level types
		if (type.isInterface() || !type.isFinal() || type.getDeclaringType() != null) {
			return false;
		}
		// and all wrapper types are defined in java.lang
		if ("java.lang".equals(type.getPackageName())) {
			String simpleName = type.getSimpleName();
			return "Integer".equals(simpleName) 
					|| "Boolean".equals(simpleName)
					|| "Long".equals(simpleName)
					|| "Double".equals(simpleName)
					|| "Character".equals(simpleName)
					|| "Byte".equals(simpleName)
					|| "Float".equals(simpleName)
					|| "Short".equals(simpleName)
					|| "Void".equals(simpleName);
		}
		return false;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		if (type instanceof JvmDeclaredType) {
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			if (!superTypes.isEmpty()) {
				if (!isRawType()) {
					OwnedConverter converter = new OwnedConverter(getOwner());
					List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(superTypes.size());
					for(JvmTypeReference superType: superTypes) {
						LightweightTypeReference lightweightSuperType = converter.toLightweightReference(superType);
						if (!lightweightSuperType.isType(Object.class) || superTypes.size() == 1)
							result.add(substitutor.substitute(lightweightSuperType));
					}
					return result;
				} else {
					OwnedConverter converter = new OwnedConverter(getOwner());
					List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(superTypes.size());
					for(JvmTypeReference superType: superTypes) {
						LightweightTypeReference lightweightSuperType = converter.toLightweightReference(superType);
						if (!lightweightSuperType.isType(Object.class) || superTypes.size() == 1)
							result.add(substitutor.substitute(lightweightSuperType).getRawTypeReference());
					}
					return result;
				}
			}
		} else if (type instanceof JvmTypeParameter) {
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
			if (!constraints.isEmpty()) {
				List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(constraints.size());
				OwnedConverter converter = new OwnedConverter(getOwner());
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
						LightweightTypeReference upperBound = converter.toLightweightReference(constraint.getTypeReference());
						result.add(substitutor.substitute(upperBound));
					}
				}
				return result;
			}
		}
		return Collections.emptyList();
	}
	
	@Override
	@Nullable
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
			ResourceSet resourceSet = getOwner().getContextResourceSet();
			Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(rawType.getName()), true);
			JvmType type = (JvmType) typeResource.getContents().get(0);
			if (type == null)
				return null;
			return new ParameterizedTypeReference(getOwner(), type);
		}
		boolean interfaceType = Modifier.isInterface(rawType.getModifiers());
		if (isInterfaceType() && !interfaceType) {
			// only Object can be a super class of an interface
			return null;
		}
		String typeName = rawType.getName();
		return getSuperTypeByName(typeName, interfaceType);
	}
	
	@Nullable
	private LightweightTypeReference getSuperTypeByName(String typeName, boolean interfaceType) {
		JvmTypeReference superType = getSuperTypeByName(typeName, interfaceType, type, new RecursionGuard<JvmType>());
		if (superType != null) {
			JvmType rawType = superType.getType();
			if (isRawType()) {
				return new ParameterizedTypeReference(getOwner(), rawType);
			}
			if (superType instanceof JvmParameterizedTypeReference) {
				if (((JvmParameterizedTypeReference) superType).getArguments().isEmpty()) {
					return new ParameterizedTypeReference(getOwner(), rawType);
				}
			}
			JvmParameterizedTypeReference plainSuperType = getServices().getTypeReferences().createTypeRef(rawType);
			OwnedConverter converter = new OwnedConverter(getOwner());
			LightweightTypeReference unresolved = converter.toLightweightReference(plainSuperType);
			TypeParameterSubstitutor<?> substitutor = createSubstitutor();
			LightweightTypeReference result = substitutor.substitute(unresolved);
			return result;
		}
		return null;
	}
	
	@Nullable
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
	@Nullable
	public LightweightTypeReference getSuperType(JvmType rawType) {
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
				return new ParameterizedTypeReference(getOwner(), rawType);
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
		if (superType != null) {
			if (isRawType()) {
				return new ParameterizedTypeReference(getOwner(), rawType);
			}
			if (superType instanceof JvmParameterizedTypeReference) {
				if (((JvmParameterizedTypeReference) superType).getArguments().isEmpty()) {
					return new ParameterizedTypeReference(getOwner(), rawType);
				}
			}
			JvmParameterizedTypeReference plainSuperType = getServices().getTypeReferences().createTypeRef(rawType);
			OwnedConverter converter = new OwnedConverter(getOwner());
			LightweightTypeReference unresolved = converter.toLightweightReference(plainSuperType);
			TypeParameterSubstitutor<?> substitutor = createSubstitutor();
			LightweightTypeReference result = substitutor.substitute(unresolved);
			return result;
		}
		return null;
	}

	@Nullable
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
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
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
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitParameterizedTypeReference(this);
	}
	
	@Override
	@Nullable
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
	@Nullable
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
	@Nullable
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
	@Nullable
	public ArrayTypeReference tryConvertToArray() {
		ArrayTypes arrayTypes = getServices().getArrayTypes();
		return arrayTypes.tryConvertToArray(this);
	}
	
	@Override
	@Nullable
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
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), getType());
		for(LightweightTypeReference typeArgument: getTypeArguments()) {
			result.addTypeArgument(typeArgument.getInvariantBoundSubstitute());
		}
		return result;
	}
}
