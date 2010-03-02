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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclaredTypeFactory implements ITypeFactory<Class<?>> {

	private final static Logger log = Logger.getLogger(DeclaredTypeFactory.class);
	private final ClassURIHelper uriHelper;

	public DeclaredTypeFactory(ClassURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}

	public JvmDeclaredType createType(Class<?> clazz) {
		if (clazz.isAnonymousClass() || clazz.isSynthetic())
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
		if (clazz.isAnnotation())
			return createAnnotationType(clazz);
		if (clazz.isEnum())
			return createEnumerationType(clazz);

		JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
		result.setAbstract(Modifier.isAbstract(clazz.getModifiers()));
		result.setFinal(Modifier.isFinal(clazz.getModifiers()));
		result.setInterface(clazz.isInterface());
		result.setStatic(Modifier.isStatic(clazz.getModifiers()));
		setVisibility(clazz, result);
		result.setFullyQualifiedName(clazz.getName());
		for (Class<?> declaredClass : clazz.getDeclaredClasses()) {
			if (!declaredClass.isAnonymousClass() && !declaredClass.isSynthetic()) {
				result.getMembers().add(createType(declaredClass));
			}
		}
		for (Method method : clazz.getDeclaredMethods()) {
			if (!method.isSynthetic())
				result.getMembers().add(createOperation(method));
		}
		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			if (!constructor.isSynthetic())
				result.getMembers().add(createConstructor(constructor));
		}
		for (Field field : clazz.getDeclaredFields()) {
			if (!field.isSynthetic())
				result.getMembers().add(createField(field));
		}
		if (clazz.getGenericSuperclass() != null)
			result.getSuperTypes().add(createTypeReference(clazz.getGenericSuperclass()));
		for (Type type : clazz.getGenericInterfaces()) {
			result.getSuperTypes().add(createTypeReference(type));
		}
		for (TypeVariable<?> variable : clazz.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
		return result;
	}
	
	public JvmAnnotationType createAnnotationType(Class<?> clazz) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.setFullyQualifiedName(clazz.getName());
		setVisibility(clazz, result);
		log.error("Annotation types are not yet fully supported.");
		return result;
	}

	public JvmEnumerationType createEnumerationType(Class<?> clazz) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();
		result.setFullyQualifiedName(clazz.getName());
		setVisibility(clazz, result);
		log.error("Enumeration types are not yet fully supported.");
		return result;
	}

	protected void setVisibility(Class<?> clazz, org.eclipse.xtext.common.types.JvmMember result) {
		if (Modifier.isPrivate(clazz.getModifiers()))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(clazz.getModifiers()))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(clazz.getModifiers()))
			result.setVisibility(JvmVisibility.PUBLIC);
	}

	public org.eclipse.xtext.common.types.JvmTypeParameter createTypeParameter(TypeVariable<?> variable,
			org.eclipse.xtext.common.types.JvmMember container) {
		org.eclipse.xtext.common.types.JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
		result.setName(variable.getName());
		if (variable.getBounds().length != 0) {
			for (Type bound : variable.getBounds()) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				upperBound.setTypeReference(createTypeReference(bound));
				result.getConstraints().add(upperBound);
			}
		}
		return result;
	}

	public JvmTypeReference createTypeReference(Type type) {
		if (type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType) type;
			Type componentType = arrayType.getGenericComponentType();
			JvmTypeReference componentTypeReference = createTypeReference(componentType);
			if (componentTypeReference != null) {
				JvmGenericArrayTypeReference result = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
				JvmArrayType resultArray = TypesFactory.eINSTANCE.createJvmArrayType();
				result.setType(resultArray);
				resultArray.setComponentType(componentTypeReference);
				return result;
			} else {
				return null;
			}
		} else if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(parameterizedType.getRawType()));
			for (int i = 0; i < parameterizedType.getActualTypeArguments().length; i++) {
				JvmTypeArgument argument = createTypeArgument(parameterizedType.getActualTypeArguments()[i],
						parameterizedType.getRawType(), i);
				result.getArguments().add(argument);
			}
			return result;
		} else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type));
			return result;
		}
	}

	public JvmTypeArgument createTypeArgument(Type actualTypeArgument,
			Type rawType, int i) {
		if (actualTypeArgument instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType) actualTypeArgument;
			JvmWildcardTypeArgument result = TypesFactory.eINSTANCE.createJvmWildcardTypeArgument();
			if (wildcardType.getUpperBounds().length != 0) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				for (Type boundType : wildcardType.getUpperBounds()) {
					JvmTypeReference upperBoundType = createTypeReference(boundType);
					upperBound.setTypeReference(upperBoundType);
				}
				result.getConstraints().add(upperBound);
			}
			if (wildcardType.getLowerBounds().length != 0) {
				JvmLowerBound lowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
				for (Type boundType : wildcardType.getLowerBounds()) {
					JvmTypeReference lowerBoundType = createTypeReference(boundType);
					lowerBound.setTypeReference(lowerBoundType);
				}
				result.getConstraints().add(lowerBound);
			}
			return result;
		}
		else {
			JvmReferenceTypeArgument result = TypesFactory.eINSTANCE.createJvmReferenceTypeArgument();
			JvmTypeReference typeReference = createTypeReference(actualTypeArgument);
			result.setTypeReference(typeReference);
			return result;
		}
	}

	public org.eclipse.xtext.common.types.JvmType createProxy(Type type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmVoid();
		URI uri = uriHelper.getFullURI(type);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.JvmType) proxy;
	}

	public org.eclipse.xtext.common.types.JvmField createField(Field field) {
		org.eclipse.xtext.common.types.JvmField result = TypesFactory.eINSTANCE.createJvmField();
		result.setFullyQualifiedName(field.getDeclaringClass().getName() + "." + field.getName());
		result.setFinal(Modifier.isFinal(field.getModifiers()));
		result.setStatic(Modifier.isStatic(field.getModifiers()));
		setVisibility(result, field.getModifiers());
		result.setType(createTypeReference(field.getGenericType()));
		return result;
	}

	public <T> org.eclipse.xtext.common.types.JvmConstructor createConstructor(Constructor<T> constructor) {
		org.eclipse.xtext.common.types.JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		enhanceExecutable(result, constructor, constructor.getGenericParameterTypes());
		enhanceGenericDeclaration(result, constructor);
		for (Type parameterType : constructor.getGenericExceptionTypes()) {
			result.getExceptions().add(createTypeReference(parameterType));
		}
		return result;
	}
	
	public void setVisibility(org.eclipse.xtext.common.types.JvmMember result, int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(modifiers))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	public void enhanceExecutable(JvmExecutable result, Member member, Type[] parameterTypes) {
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

	public void enhanceGenericDeclaration(JvmExecutable result, GenericDeclaration declaration) {
		for (TypeVariable<?> variable : declaration.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
	}

	public JvmOperation createOperation(Method method) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		enhanceExecutable(result, method, method.getGenericParameterTypes());
		enhanceGenericDeclaration(result, method);
		result.setFinal(Modifier.isFinal(method.getModifiers()));
		result.setStatic(Modifier.isStatic(method.getModifiers()));
		result.setReturnType(createTypeReference(method.getGenericReturnType()));
		for (Type parameterType : method.getGenericExceptionTypes()) {
			result.getExceptions().add(createTypeReference(parameterType));
		}
		return result;
	}

	public JvmFormalParameter createFormalParameter(Type parameterType, String paramName,
			org.eclipse.xtext.common.types.JvmMember container) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType));
		return result;
	}

}
