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
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.AnnotationType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.EnumerationType;
import org.eclipse.xtext.common.types.Executable;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.UpperBound;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclaredTypeProvider implements IClasspathTypeProvider {

	private final ClassURIHelper uriHelper;

	public DeclaredTypeProvider(ClassURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}
	
	public <T> DeclaredType createType(Class<T> clazz) {
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
			result.setVisibility("private");
		else if (Modifier.isProtected(clazz.getModifiers()))
			result.setVisibility("protected");
		else if (Modifier.isPublic(clazz.getModifiers()))
			result.setVisibility("public");
		result.setFullyQualifiedName(clazz.getName());
		for(Class<?> declaredClass: clazz.getDeclaredClasses()) {
			if (!declaredClass.isAnonymousClass()) {
				result.getMembers().add(createType(declaredClass));
			}
		}
		for(Method method: clazz.getDeclaredMethods()) {
			result.getMembers().add(createOperation(method));
		}
		for(Constructor<T> constructor: clazz.getDeclaredConstructors()) {
			result.getMembers().add(createConstructor(constructor));
		}
		for(Field field: clazz.getDeclaredFields()) {
			result.getMembers().add(createField(field));
		}
		if (clazz.getGenericSuperclass() != null)
			result.getSuperTypes().add(createTypeReference(clazz.getGenericSuperclass()));
		for(Type type: clazz.getGenericInterfaces()) {
			result.getSuperTypes().add(createTypeReference(type));
		}
		for(TypeVariable<?> variable: clazz.getTypeParameters()) {
			result.getTypeVariables().add(createTypeVariable(variable));
		}
		return result;
	}

	public org.eclipse.xtext.common.types.TypeVariable createTypeVariable(TypeVariable<?> variable) {
		org.eclipse.xtext.common.types.TypeVariable result = TypesFactory.eINSTANCE.createTypeVariable();
		result.setName(variable.getName());
		if (variable.getBounds().length != 0) {
			UpperBound upperBound = TypesFactory.eINSTANCE.createUpperBound();
			for(Type bound: variable.getBounds()) {
				upperBound.getReferencedTypes().add(createTypeReference(bound));
			}
			result.getConstraints().add(upperBound);
		}
		return result;
	}
	
	public TypeReference createTypeReference(Type type) {
		TypeReference result = TypesFactory.eINSTANCE.createTypeReference();
		result.setType(createProxy(type));
		return result;
	}
	
	public org.eclipse.xtext.common.types.Type createProxy(Type type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createVoid();
		if (type instanceof Class<?>) {
			Class<?> classType = (Class<?>) type;
			URI resourceURI = uriHelper.createResourceURI(classType);
			proxy.eSetProxyURI(resourceURI.appendFragment(uriHelper.getFragment(classType)));
		} else {
			return null;
		}
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
		result.setName(field.getName());
		result.setFinal(Modifier.isFinal(field.getModifiers()));
		result.setStatic(Modifier.isStatic(field.getModifiers()));
		if (Modifier.isPrivate(field.getModifiers()))
			result.setVisibility("private");
		else if (Modifier.isProtected(field.getModifiers()))
			result.setVisibility("protected");
		else if (Modifier.isPublic(field.getModifiers()))
			result.setVisibility("public");
		result.setType(createTypeReference(field.getGenericType()));
		return result;
	}

	public <T> org.eclipse.xtext.common.types.Constructor createConstructor(Constructor<T> constructor) {
		org.eclipse.xtext.common.types.Constructor result = TypesFactory.eINSTANCE.createConstructor();
		enhanceExecutable(result, constructor);
		enhanceGenericDeclaration(result, constructor);
		int i = 0;
		for(Type parameterType : constructor.getGenericParameterTypes()) {
			result.getParameters().add(createFormalParameter(parameterType, "p" + i));
			i++;
		}
		return result;
	}

	public void enhanceExecutable(Executable result, Member member) {
		result.setName(member.getName());
		if (Modifier.isPrivate(member.getModifiers()))
			result.setVisibility("private");
		else if (Modifier.isProtected(member.getModifiers()))
			result.setVisibility("protected");
		else if (Modifier.isPublic(member.getModifiers()))
			result.setVisibility("public");
	}
	
	public void enhanceGenericDeclaration(Executable result, GenericDeclaration declaration) {
		for(TypeVariable<?> variable: declaration.getTypeParameters()) {
			result.getTypeVariables().add(createTypeVariable(variable));
		}
	}

	public Operation createOperation(Method method) {
		Operation result = TypesFactory.eINSTANCE.createOperation();
		enhanceExecutable(result, method);
		result.setFinal(Modifier.isFinal(method.getModifiers()));
		result.setStatic(Modifier.isStatic(method.getModifiers()));
		result.setReturnType(createTypeReference(method.getGenericReturnType()));
		int i = 0;
		for(Type parameterType : method.getGenericParameterTypes()) {
			result.getParameters().add(createFormalParameter(parameterType, "p" + i));
			i++;
		}
		return result;
	}

	public FormalParameter createFormalParameter(Type parameterType, String paramName) {
		FormalParameter result = TypesFactory.eINSTANCE.createFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType));
		return result;
	}

}
