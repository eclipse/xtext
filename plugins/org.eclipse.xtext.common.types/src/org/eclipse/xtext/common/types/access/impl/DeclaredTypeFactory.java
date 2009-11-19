/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.AnnotationType;
import org.eclipse.xtext.common.types.ComponentType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.EnumerationType;
import org.eclipse.xtext.common.types.Executable;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.LowerBound;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.ReferenceTypeArgument;
import org.eclipse.xtext.common.types.TypeArgument;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.Visibility;
import org.eclipse.xtext.common.types.Wildcard;
import org.eclipse.xtext.common.types.WildcardTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclaredTypeFactory implements ITypeFactory<Class<?>> {

	private final ClassURIHelper uriHelper;

	public DeclaredTypeFactory(ClassURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}

	public DeclaredType createType(Class<?> clazz) {
		if (clazz.isAnonymousClass())
			throw new IllegalStateException("Cannot create type for anonymous class");
		if (clazz.isAnnotation())
			return createAnnotationType(clazz);
		if (clazz.isEnum())
			return createEnumerationType(clazz);

		GenericType result = TypesFactory.eINSTANCE.createGenericType();
		result.setAbstract(Modifier.isAbstract(clazz.getModifiers()));
		result.setFinal(Modifier.isFinal(clazz.getModifiers()));
		result.setInterface(clazz.isInterface());
		result.setStatic(Modifier.isStatic(clazz.getModifiers()));
		if (Modifier.isPrivate(clazz.getModifiers()))
			result.setVisibility(Visibility.PRIVATE);
		else if (Modifier.isProtected(clazz.getModifiers()))
			result.setVisibility(Visibility.PROTECTED);
		else if (Modifier.isPublic(clazz.getModifiers()))
			result.setVisibility(Visibility.PUBLIC);
		result.setFullyQualifiedName(clazz.getName());
		for (Class<?> declaredClass : clazz.getDeclaredClasses()) {
			if (!declaredClass.isAnonymousClass()) {
				result.getMembers().add(createType(declaredClass));
			}
		}
		for (Method method : clazz.getDeclaredMethods()) {
			result.getMembers().add(createOperation(method));
		}
		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			result.getMembers().add(createConstructor(constructor));
		}
		for (Field field : clazz.getDeclaredFields()) {
			result.getMembers().add(createField(field));
		}
		if (clazz.getGenericSuperclass() != null)
			result.getSuperTypes().add(createReferencedType(clazz.getGenericSuperclass(), result));
		for (Type type : clazz.getGenericInterfaces()) {
			result.getSuperTypes().add(createReferencedType(type, result));
		}
		for (TypeVariable<?> variable : clazz.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
		return result;
	}

	public org.eclipse.xtext.common.types.TypeParameter createTypeParameter(TypeVariable<?> variable,
			org.eclipse.xtext.common.types.Member container) {
		org.eclipse.xtext.common.types.TypeParameter result = TypesFactory.eINSTANCE.createTypeParameter();
		result.setName(variable.getName());
		if (variable.getBounds().length != 0) {
			for (Type bound : variable.getBounds()) {
				UpperBound upperBound = TypesFactory.eINSTANCE.createUpperBound();
				upperBound.setReferencedType(createReferencedType(bound, container));
				result.getConstraints().add(upperBound);
			}
		}
		return result;
	}

	public org.eclipse.xtext.common.types.Type createReferencedType(Type type,
			org.eclipse.xtext.common.types.Member container) {
		org.eclipse.xtext.common.types.Type result = createReferencedTypeForParameterizedOrReturnNull(type, container);
		if (result == null)
			result = createProxy(type);
		return result;
	}

	public org.eclipse.xtext.common.types.Type createReferencedTypeForParameterizedOrReturnNull(Type type,
			org.eclipse.xtext.common.types.Member container) {
		if (type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType) type;
			Type componentType = arrayType.getGenericComponentType();
			org.eclipse.xtext.common.types.Type result = createReferencedTypeForParameterizedOrReturnNull(
					componentType, container);
			if (result != null) {
				ComponentType resultComponentType = (ComponentType) result;
				if (resultComponentType.getArrayType() == null) {
					resultComponentType.setArrayType(TypesFactory.eINSTANCE.createArrayType());
				}
				return resultComponentType.getArrayType();
			}
			else {
				return null;
			}
		}
		else if (type instanceof ParameterizedType) {
			String name = uriHelper.computeParameterizedTypeName(type);
			for (org.eclipse.xtext.common.types.ParameterizedType existingType : container
					.getDeclaredParameterizedTypes()) {
				if (name.equals(existingType.getCanonicalName())) {
					return existingType;
				}
			}
			ParameterizedType parameterizedType = (ParameterizedType) type;
			org.eclipse.xtext.common.types.ParameterizedType newParameterizedType = TypesFactory.eINSTANCE
					.createParameterizedType();
			newParameterizedType.setFullyQualifiedName(name);
			newParameterizedType.setRawType(createReferencedType(parameterizedType.getRawType(), container));
			for (int i = 0; i < parameterizedType.getActualTypeArguments().length; i++) {
				TypeArgument argument = createTypeArgument(parameterizedType.getActualTypeArguments()[i], container,
						parameterizedType.getRawType(), i);
				newParameterizedType.getArguments().add(argument);
			}
			container.getDeclaredParameterizedTypes().add(newParameterizedType);
			return newParameterizedType;
		}
		else {
			return null;
		}
	}

	public TypeArgument createTypeArgument(Type actualTypeArgument, org.eclipse.xtext.common.types.Member container,
			Type rawType, int i) {
		if (actualTypeArgument instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType) actualTypeArgument;
			WildcardTypeArgument result = TypesFactory.eINSTANCE.createWildcardTypeArgument();
			Wildcard wildcard = TypesFactory.eINSTANCE.createWildcard();
			if (wildcardType.getUpperBounds().length != 0) {
				UpperBound upperBound = TypesFactory.eINSTANCE.createUpperBound();
				for (Type boundType : wildcardType.getUpperBounds()) {
					org.eclipse.xtext.common.types.Type upperBoundType = createReferencedType(boundType, container);
					upperBound.setReferencedType(upperBoundType);
				}
				wildcard.getConstraints().add(upperBound);
			}
			if (wildcardType.getLowerBounds().length != 0) {
				LowerBound lowerBound = TypesFactory.eINSTANCE.createLowerBound();
				for (Type boundType : wildcardType.getLowerBounds()) {
					org.eclipse.xtext.common.types.Type lowerBoundType = createReferencedType(boundType, container);
					lowerBound.setReferencedType(lowerBoundType);
				}
				wildcard.getConstraints().add(lowerBound);
			}
			result.setWildcard(wildcard);
			return result;
		}
		else {
			ReferenceTypeArgument result = TypesFactory.eINSTANCE.createReferenceTypeArgument();
			org.eclipse.xtext.common.types.Type typeReference = createReferencedType(actualTypeArgument, container);
			result.setType(typeReference);
			return result;
		}
	}

	public org.eclipse.xtext.common.types.Type createProxy(Type type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createVoid();
		URI uri = uriHelper.getFullURI(type);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.Type) proxy;
	}

	public AnnotationType createAnnotationType(Class<?> clazz) {
		throw new UnsupportedOperationException();
	}

	public EnumerationType createEnumerationType(Class<?> clazz) {
		throw new UnsupportedOperationException();
	}

	public org.eclipse.xtext.common.types.Field createField(Field field) {
		org.eclipse.xtext.common.types.Field result = TypesFactory.eINSTANCE.createField();
		result.setFullyQualifiedName(field.getDeclaringClass().getName() + "." + field.getName());
		result.setFinal(Modifier.isFinal(field.getModifiers()));
		result.setStatic(Modifier.isStatic(field.getModifiers()));
		setVisibility(result, field.getModifiers());
		result.setType(createReferencedType(field.getGenericType(), result));
		return result;
	}

	public <T> org.eclipse.xtext.common.types.Constructor createConstructor(Constructor<T> constructor) {
		org.eclipse.xtext.common.types.Constructor result = TypesFactory.eINSTANCE.createConstructor();
		enhanceExecutable(result, constructor, constructor.getGenericParameterTypes());
		enhanceGenericDeclaration(result, constructor);
		for (Type parameterType : constructor.getGenericExceptionTypes()) {
			result.getExceptions().add(createReferencedType(parameterType, result));
		}
		return result;
	}
	
	public void setVisibility(org.eclipse.xtext.common.types.Member result, int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(Visibility.PRIVATE);
		else if (Modifier.isProtected(modifiers))
			result.setVisibility(Visibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(Visibility.PUBLIC);
		else
			result.setVisibility(Visibility.DEFAULT);
	}

	public void enhanceExecutable(Executable result, Member member, Type[] parameterTypes) {
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(member.getDeclaringClass().getName());
		fqName.append('.');
		fqName.append(member.getName());
		fqName.append('(');
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0)
				fqName.append(',');
			uriHelper.computeTypeName(parameterTypes[i], fqName);
		}
		fqName.append(')');
		result.setFullyQualifiedName(fqName.toString());
		setVisibility(result, member.getModifiers());
		int i = 0;
		for (Type parameterType : parameterTypes) {
			result.getParameters().add(createFormalParameter(parameterType, "p" + i, result));
			i++;
		}
	}

	public void enhanceGenericDeclaration(Executable result, GenericDeclaration declaration) {
		for (TypeVariable<?> variable : declaration.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
	}

	public Operation createOperation(Method method) {
		Operation result = TypesFactory.eINSTANCE.createOperation();
		enhanceExecutable(result, method, method.getGenericParameterTypes());
		enhanceGenericDeclaration(result, method);
		result.setFinal(Modifier.isFinal(method.getModifiers()));
		result.setStatic(Modifier.isStatic(method.getModifiers()));
		result.setReturnType(createReferencedType(method.getGenericReturnType(), result));
		for (Type parameterType : method.getGenericExceptionTypes()) {
			result.getExceptions().add(createReferencedType(parameterType, result));
		}
		return result;
	}

	public FormalParameter createFormalParameter(Type parameterType, String paramName,
			org.eclipse.xtext.common.types.Member container) {
		FormalParameter result = TypesFactory.eINSTANCE.createFormalParameter();
		result.setName(paramName);
		result.setParameterType(createReferencedType(parameterType, container));
		return result;
	}

}
