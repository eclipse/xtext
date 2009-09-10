/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassURIHelper {

	public static final String PRIMITIVES = "/Primitives";
	public static final String OBJECTS = "/Objects/";
	public static final String PROTOCOL = "java";
	
	public URI createResourceURI(Type type) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(type, uriBuilder);
		return createURI(uriBuilder);
	}
	
	public URI createResourceURI(String withoutProtocol) {
		StringBuilder uriBuilder = new StringBuilder(ClassURIHelper.PROTOCOL.length() + 1 + withoutProtocol.length());
		uriBuilder.append(ClassURIHelper.PROTOCOL).append(":").append(withoutProtocol);
		return createURI(uriBuilder);
	}
	
	private StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(ClassURIHelper.PROTOCOL);
		builder.append(':');
		return builder;
	}

	private URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(Type type) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(type, uriBuilder);
		uriBuilder.append('#');
		createFragment(type, uriBuilder);
		return createURI(uriBuilder);
	}
	
	public String getFragment(Type type) {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(type, uriBuilder);
		return uriBuilder.toString();
	}
	
	private void createFragment(Type type, StringBuilder uriBuilder) {
		if (type instanceof Class<?>) {
			Class<?> clazz = (Class<?>) type;
			createFragmentForClass(clazz, uriBuilder);
		} else if (type instanceof TypeVariable<?>) {
			TypeVariable<?> variable = (TypeVariable<?>) type;
			createFragmentForTypeVariable(variable, uriBuilder);
		} else if (type instanceof GenericArrayType) {
			createFragment(((GenericArrayType) type).getGenericComponentType(), uriBuilder);
			uriBuilder.append("[]");
		} else {
			throw new IllegalStateException("Unexpected type: " + type);
		}
	}

	private void createFragmentForTypeVariable(TypeVariable<?> variable, StringBuilder uriBuilder) {
		Object declaration = variable.getGenericDeclaration();
		if (declaration instanceof Type) {
			Type declaringType = (Type) declaration;
			createFragment(declaringType, uriBuilder);
		} else if (declaration instanceof Member) {
			Member member = (Member) declaration;
			createFragmentForMember(member, uriBuilder);
		} else {
			throw new IllegalArgumentException(variable + " / " + declaration);
		}
		uriBuilder.append('/');
		uriBuilder.append(variable.getName());
	}

	private void createFragmentForMember(Member member, StringBuilder uriBuilder) {
		Class<?> declaringClass = member.getDeclaringClass();
		createFragmentForClass(declaringClass, uriBuilder);
		uriBuilder.append('.');
		uriBuilder.append(member.getName());
		uriBuilder.append('(');
		Type[] parameterTypes = null;
		if (member instanceof java.lang.reflect.Constructor<?>) {
			parameterTypes = ((java.lang.reflect.Constructor<?>) member).getGenericParameterTypes();
		} else if (member instanceof Method) {
			parameterTypes = ((Method) member).getGenericParameterTypes();
		} else {
			throw new IllegalStateException("unknown member type: " + member);
		}
		for(int i = 0; i < parameterTypes.length; i++) {
			if ( i!=0 ) {
				uriBuilder.append(',');
			}
			computeTypeName(parameterTypes[i], uriBuilder);
		}
		uriBuilder.append(')');
	}
	
	public String computeTypeName(Type type) {
		StringBuilder result = new StringBuilder(64);
		computeTypeName(type, result);
		return result.toString();
	}
	
	public void computeTypeName(Type type, StringBuilder uriBuilder) {
		if (type instanceof Class<?>) {
			Class<?> clazz = (Class<?>) type;
			if (clazz.isArray()) {
				computeTypeName(clazz.getComponentType(), uriBuilder);
				uriBuilder.append("[]");				
			} else {
				uriBuilder.append(clazz.getName());	
			}
		} else if (type instanceof GenericArrayType) {
			computeTypeName(((GenericArrayType) type).getGenericComponentType(), uriBuilder);
			uriBuilder.append("[]");
		} else if (type instanceof TypeVariable<?>) {
			uriBuilder.append(((TypeVariable<?>) type).getName());
		} else if (type instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) type).getRawType();
			computeTypeName(rawType, uriBuilder);
		} else {
			throw new IllegalStateException("unknown type: " + type);
		}
	}

	private void createFragmentForClass(Class<?> clazz, StringBuilder uriBuilder) {
		if (clazz.isArray()) {
			createFragmentForClass(clazz.getComponentType(), uriBuilder);
			uriBuilder.append("[]");
		} else if (clazz.isMemberClass()){
			uriBuilder.append(clazz.getName());
		} else {
			uriBuilder.append(clazz.getName());
		}
	}

	private void createResourceURI(Type type, StringBuilder uriBuilder) {
		if (type instanceof Class<?>) {
			Class<?> clazz = (Class<?>) type;
			createResourceURIForClass(clazz, uriBuilder);
		} else if (type instanceof TypeVariable<?>) {
			TypeVariable<?> variable = (TypeVariable<?>) type;
			createResourceURIForTypeVariable(variable, uriBuilder);
		} else if (type instanceof GenericArrayType) {
			createResourceURI(((GenericArrayType) type).getGenericComponentType(), uriBuilder);
		} else {
			throw new IllegalStateException("unexpected type: " + type);
		}
	}

	private void createResourceURIForTypeVariable(TypeVariable<?> variable, StringBuilder uriBuilder) {
		Object declaration = variable.getGenericDeclaration();
		if (declaration instanceof Class<?>) {
			Class<?> declaringClass = (Class<?>) declaration;
			createResourceURIForClass(declaringClass, uriBuilder);
		} else if (declaration instanceof Member) {
			Member member = (Member) declaration;
			Class<?> declaringClass = member.getDeclaringClass();
			createResourceURIForClass(declaringClass, uriBuilder);
		} else {
			throw new IllegalArgumentException(variable + " / " + declaration);
		}
	}

	private void createResourceURIForClass(Class<?> clazz, StringBuilder uriBuilder) {
		if (clazz.isArray()) {
			createResourceURIForClass(clazz.getComponentType(), uriBuilder);
		} else if (clazz.isMemberClass()) {
			createResourceURIForClass(clazz.getDeclaringClass(), uriBuilder);
		} else if (clazz.isPrimitive()) {
			uriBuilder.append(ClassURIHelper.PRIMITIVES); 
		} else {
			uriBuilder.append(ClassURIHelper.OBJECTS).append(clazz.getName());
		}
	}

}
