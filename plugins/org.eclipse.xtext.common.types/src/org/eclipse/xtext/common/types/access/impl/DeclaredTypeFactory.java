/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Internal implementation that allows to convert Java top-level classes to {@link JvmType types}.
 * 
 * Clients are not supposed to use this class directly but the {@link IJvmTypeProvider}
 * or {@link TypeReferences} instead. Those will take care of types that are requested more than
 * once and therefore should return the very same {@link JvmType type} on subsequent queries.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DeclaredTypeFactory implements ITypeFactory<Class<?>> {

	private final static Logger log = Logger.getLogger(DeclaredTypeFactory.class);
	private final ClassURIHelper uriHelper;

	@Inject
	public DeclaredTypeFactory(ClassURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}

	/**
	 * Creates a new {@link JvmDeclaredType type} from the given class.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmDeclaredType createType(final Class<?> clazz) {
		if (clazz.isAnonymousClass() || clazz.isSynthetic())
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
		if (clazz.isAnnotation())
			return createAnnotationType(clazz);
		if (clazz.isEnum())
			return createEnumerationType(clazz);

		final JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
		result.setInterface(clazz.isInterface());
		setTypeModifiers(clazz, result);
		setVisibility(clazz, result);
		result.internalSetIdentifier(clazz.getName());
		result.setSimpleName(clazz.getSimpleName());
		if (clazz.getDeclaringClass() == null && clazz.getPackage() != null)
			result.setPackageName(clazz.getPackage().getName());
		
		createNestedTypes(clazz, result);
		createMethods(clazz, result);
		createConstructors(clazz, result);
		createFields(clazz, result);
		
		setSuperTypes(clazz, result);
		try {
			for (TypeVariable<?> variable : clazz.getTypeParameters()) {
				result.getTypeParameters().add(createTypeParameter(variable, result));
			}
		} catch(GenericSignatureFormatError error) {
			if (log.isDebugEnabled())
				log.debug("Invalid class file for: " + result.getIdentifier(), error);
		}
		createAnnotationValues(clazz, result);
		return result;
	}
	
	private static final Object[] EMPTY_ARRAY = new Object[0];

	protected void createAnnotationValues(final AnnotatedElement annotated, final JvmAnnotationTarget result) {
		for (Annotation annotation : annotated.getDeclaredAnnotations()) {
			result.getAnnotations().add(createAnnotationReference(annotation));
		}
	}

	protected JvmAnnotationReference createAnnotationReference(Annotation annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		Class<? extends Annotation> type = annotation.annotationType();
		annotationReference.setAnnotation(createAnnotationProxy(type));
		for (Method method : type.getDeclaredMethods()) {
			try {
				Object value = method.invoke(annotation, EMPTY_ARRAY);
				if (method.getReturnType().isArray()) {
					JvmAnnotationValue annotationValue = createArrayAnnotationValue(value, method.getReturnType());
					annotationReference.getValues().add(annotationValue);
					annotationValue.setOperation(createMethodProxy(method));
				} else {
					JvmAnnotationValue annotationValue = createAnnotationValue(value, method.getReturnType());
					annotationReference.getValues().add(annotationValue);
					annotationValue.setOperation(createMethodProxy(method));
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return annotationReference;
	}

	protected JvmEnumerationLiteral createEnumLiteralProxy(Enum<?> e) {
		JvmEnumerationLiteral enumLiteralProxy = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		InternalEObject internalEObject = (InternalEObject) enumLiteralProxy;
		Class<?> type = e.getDeclaringClass();
		try {
			Field field = type.getDeclaredField(e.toString());
			internalEObject.eSetProxyURI(uriHelper.getFullURI(field));
		} catch (Exception exception) {
			log.error(exception.getMessage(), exception);
			return null;
		}
		return enumLiteralProxy;
	}

	protected JvmAnnotationValue createArrayAnnotationValue(Object value, Class<?> type) {
		if (!type.isArray())
			throw new IllegalArgumentException("type is not an array type: " + type.getCanonicalName());
		Class<?> componentType = type.getComponentType();
		JvmAnnotationValue result = createAnnotationValue(componentType);
		int length = Array.getLength(value);
		if (length > 0) {
			List<Object> valuesAsList = Lists.newArrayListWithExpectedSize(length);
			if (componentType.isPrimitive() || String.class.equals(componentType)) {
				for (int i = 0; i < length; i++) {
					valuesAsList.add(Array.get(value, i));
				}
			} else if (componentType.equals(Class.class)) {
				for (int i = 0; i < length; i++) {
					Class<?> referencedClass = (Class<?>) Array.get(value, i);
					valuesAsList.add(createTypeReference(referencedClass));
				}
			} else if (componentType.isAnnotation()) {
				for (int i = 0; i < length; i++) {
					Annotation nestedAnnotation = (Annotation) Array.get(value, i);
					((JvmAnnotationAnnotationValue)result).getValues().add(createAnnotationReference(nestedAnnotation));
				}
			} else if (componentType.isEnum()) {
				for (int i = 0; i < length; i++) {
					Enum<?> e = (Enum<?>) Array.get(value, i);
					JvmEnumerationLiteral proxy = createEnumLiteralProxy(e);
					valuesAsList.add(proxy);
				}
			}
			if (!componentType.isAnnotation())
				result.eSet(result.eClass().getEStructuralFeature("values"), valuesAsList);
		}
		return result;
	}

	protected JvmAnnotationValue createAnnotationValue(Object value, Class<?> type) {
		JvmAnnotationValue result = createAnnotationValue(type);
		if (type.isPrimitive() || String.class.equals(type)) {
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(value));
		} else if (type.equals(Class.class)) {
			Class<?> referencedClass = (Class<?>) value;
			JvmTypeReference reference = createTypeReference(referencedClass);
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(reference));
		} else if (type.isAnnotation()) {
			Annotation nestedAnnotation = (Annotation) value;
			((JvmAnnotationAnnotationValue)result).getValues().add(createAnnotationReference(nestedAnnotation));
		} else if (type.isEnum()) {
			Enum<?> e = (Enum<?>) value;
			JvmEnumerationLiteral proxy = createEnumLiteralProxy(e);
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(proxy));
		}
		return result;
	}

	protected JvmAnnotationValue createAnnotationValue(Class<?> type) {
		if (String.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
		} else if (Class.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
		} else if (type.isAnnotation()) {
			return TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
		} else if (type.isEnum()) {
			return TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		} else if (int.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
		} else if (boolean.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
		} else if (long.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
		} else if (byte.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
		} else if (short.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
		} else if (float.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
		} else if (double.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
		} else if (char.class.equals(type)) {
			return TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
		} else
			throw new IllegalArgumentException("Unexpected type: " + type.getCanonicalName());
	}

	protected JvmAnnotationType createAnnotationProxy(Class<? extends Annotation> type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmAnnotationType();
		URI uri = uriHelper.getFullURI(type);
		proxy.eSetProxyURI(uri);
		return (JvmAnnotationType) proxy;
	}

	protected JvmOperation createMethodProxy(Method method) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmOperation();
		URI uri = uriHelper.getFullURI(method);
		proxy.eSetProxyURI(uri);
		return (JvmOperation) proxy;
	}

	protected void setTypeModifiers(Class<?> clazz, JvmDeclaredType result) {
		result.setAbstract(Modifier.isAbstract(clazz.getModifiers()));
		result.setStatic(Modifier.isStatic(clazz.getModifiers()));
		if (!(result instanceof JvmEnumerationType))
			result.setFinal(Modifier.isFinal(clazz.getModifiers()));
	}

	protected void createNestedTypes(Class<?> clazz, JvmDeclaredType result) {
		for (Class<?> declaredClass : clazz.getDeclaredClasses()) {
			if (!declaredClass.isAnonymousClass() && !declaredClass.isSynthetic()) {
				result.getMembers().add(createType(declaredClass));
			}
		}
	}

	protected JvmAnnotationType createAnnotationType(Class<?> clazz) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.internalSetIdentifier(clazz.getName());
		result.setSimpleName(clazz.getSimpleName());
		if (clazz.getDeclaringClass() == null)
			result.setPackageName(clazz.getPackage().getName());
		setVisibility(clazz, result);
		setTypeModifiers(clazz, result);
		createNestedTypes(clazz, result);
		createMethods(clazz, result);
		setSuperTypes(clazz, result);
		createAnnotationValues(clazz, result);
		return result;
	}

	protected void setSuperTypes(Class<?> clazz, JvmDeclaredType result) {
		try {
			if (clazz.getGenericSuperclass() != null) {
				result.getSuperTypes().add(createTypeReference(clazz.getGenericSuperclass()));
			}
		} catch(GenericSignatureFormatError error) {
			if (clazz.getSuperclass() != null) {
				result.getSuperTypes().add(createTypeReference(clazz.getSuperclass()));
			}
		}
		Type[] interfaces = null;
		try {
			interfaces = clazz.getGenericInterfaces();
		} catch(GenericSignatureFormatError error) {
			interfaces = clazz.getInterfaces();
		}
		for (Type type : interfaces) {
			result.getSuperTypes().add(createTypeReference(type));
		}
		if (result.getSuperTypes().isEmpty() && !Object.class.equals(clazz)) {
			result.getSuperTypes().add(createTypeReference(Object.class));
		}
	}

	protected void createFields(Class<?> clazz, JvmDeclaredType result) {
		for (Field field : clazz.getDeclaredFields()) {
			if (!field.isSynthetic())
				result.getMembers().add(createField(field));
		}
	}

	protected void createConstructors(Class<?> clazz, JvmDeclaredType result) {
		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			if (!constructor.isSynthetic())
				result.getMembers().add(createConstructor(constructor));
		}
	}

	protected void createMethods(Class<?> clazz, JvmDeclaredType result) {
		for (Method method : clazz.getDeclaredMethods()) {
			if (!method.isSynthetic()) {
				JvmOperation operation = createOperation(method);
				if (clazz.isAnnotation()) {
					setDefaultValue(operation, method);
				}
				result.getMembers().add(operation);
			}
		}
	}

	private void setDefaultValue(JvmOperation operation, Method method) {
		Object defaultValue = method.getDefaultValue();
		if (defaultValue != null) {
			if (method.getReturnType().isArray()) {
				JvmAnnotationValue annotationValue = createArrayAnnotationValue(defaultValue, method.getReturnType());
				operation.setDefaultValue(annotationValue);
				annotationValue.setOperation(operation);
			} else {
				JvmAnnotationValue annotationValue = createAnnotationValue(defaultValue, method.getReturnType());
				operation.setDefaultValue(annotationValue);
				annotationValue.setOperation(operation);
			}
		}
	}

	protected JvmEnumerationType createEnumerationType(Class<?> clazz) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();
		result.internalSetIdentifier(clazz.getName());
		result.setSimpleName(clazz.getSimpleName());
		if (clazz.getDeclaringClass() == null)
			result.setPackageName(clazz.getPackage().getName());
		setVisibility(clazz, result);
		setTypeModifiers(clazz, result);
		createNestedTypes(clazz, result);
		createMethods(clazz, result);
		createFields(clazz, result);
		createConstructors(clazz, result);
		setSuperTypes(clazz, result);
		createAnnotationValues(clazz, result);
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

	protected JvmTypeParameter createTypeParameter(TypeVariable<?> variable,
			org.eclipse.xtext.common.types.JvmMember container) {
		JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
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

	protected JvmTypeReference createTypeReference(Type type) {
		if (type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType) type;
			Type componentType = arrayType.getGenericComponentType();
			return createArrayTypeReference(componentType);
		} else if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(parameterizedType.getRawType()));
			for (int i = 0; i < parameterizedType.getActualTypeArguments().length; i++) {
				JvmTypeReference argument = createTypeArgument(parameterizedType.getActualTypeArguments()[i],
						parameterizedType.getRawType(), i);
				result.getArguments().add(argument);
			}
			return result;
		} else if (type instanceof Class<?> && ((Class<?>) type).isArray()){
			Class<?> arrayType = (Class<?>) type;
			Type componentType = arrayType.getComponentType();
			return createArrayTypeReference(componentType);
		} else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(type));
			return result;
		}
	}

	protected JvmTypeReference createArrayTypeReference(Type componentType) {
		JvmTypeReference componentTypeReference = createTypeReference(componentType);
		if (componentTypeReference != null) {
			JvmGenericArrayTypeReference result = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
			result.setComponentType(componentTypeReference);
			return result;
		} else {
			return null;
		}
	}

	protected JvmTypeReference createTypeArgument(Type actualTypeArgument, Type rawType, int i) {
		if (actualTypeArgument instanceof WildcardType) {
			WildcardType wildcardType = (WildcardType) actualTypeArgument;
			JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
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
		} else {
			JvmTypeReference result = createTypeReference(actualTypeArgument);
			return result;
		}
	}

	protected JvmType createProxy(Type type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmVoid();
		URI uri = uriHelper.getFullURI(type);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.JvmType) proxy;
	}

	protected JvmField createField(Field field) {
		JvmField result;
		if (!field.isEnumConstant())
			result = TypesFactory.eINSTANCE.createJvmField();
		else
			result = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		result.internalSetIdentifier(field.getDeclaringClass().getName() + "." + field.getName());
		result.setSimpleName(field.getName());
		result.setFinal(Modifier.isFinal(field.getModifiers()));
		result.setStatic(Modifier.isStatic(field.getModifiers()));
		setVisibility(result, field.getModifiers());
		result.setType(createTypeReference(field.getGenericType()));
		createAnnotationValues(field, result);
		return result;
	}

	protected <T> org.eclipse.xtext.common.types.JvmConstructor createConstructor(Constructor<T> constructor) {
		JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		Class<T> declaringClass = constructor.getDeclaringClass();
		int offset = 0;
		if (declaringClass.isEnum()) {
			offset = 2;
		} else if (declaringClass.isMemberClass() && !Modifier.isStatic(declaringClass.getModifiers())) {
			offset = 1;
		}
		Type[] genericParameterTypes = null;
		try {
			genericParameterTypes = constructor.getGenericParameterTypes();
		} catch(GenericSignatureFormatError error) {
			genericParameterTypes = constructor.getParameterTypes();
		}
		if (offset != 0) {
			/*
			 * #getGenericParameterTypes may return a different number of parameters
			 * for inner classes then #getParameterTypes does. This happens for
			 * signatures that are parameterized, e.g.
			 * 
			 * <pre>
			 * 
			 * class WrappedCollection<V> .. {
			 *   class WrappedIterator implements Iterator<V> {
			 *     WrappedIterator(Iterator<V> iterator) { .. }
			 *   }
			 * }
			 * 
			 * </pre>
			 * 
			 * Therefore we adjust the offset here
			 */
			if (constructor.getParameterTypes().length != genericParameterTypes.length) {
				offset = 0;
			}
		}
		enhanceGenericDeclaration(result, constructor);
		enhanceExecutable(result, constructor, constructor.getDeclaringClass().getSimpleName(),
				genericParameterTypes, constructor.getParameterAnnotations(), offset);
		result.setVarArgs(constructor.isVarArgs());
		for (Type parameterType : constructor.getGenericExceptionTypes()) {
			result.getExceptions().add(createTypeReference(parameterType));
		}
		createAnnotationValues(constructor, result);
		return result;
	}

	protected void setVisibility(org.eclipse.xtext.common.types.JvmMember result, int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(modifiers))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	protected <T extends Member & GenericDeclaration> void enhanceExecutable(JvmExecutable result, T member, String simpleName, Type[] parameterTypes,
			Annotation[][] annotations, int offset) {
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(member.getDeclaringClass().getName());
		fqName.append('.');
		fqName.append(simpleName);
		fqName.append('(');
		for (int typeIdx = offset, annotationIdx = annotations.length - parameterTypes.length + offset; 
				typeIdx < parameterTypes.length; 
				typeIdx++, annotationIdx++) {
			if (typeIdx != offset)
				fqName.append(',');
			Type parameterType = parameterTypes[typeIdx];
			uriHelper.computeTypeName(parameterType, fqName);
			result.getParameters().add(createFormalParameter(parameterType, "arg" + (typeIdx - offset), result, member, annotations[annotationIdx]));
		}
		fqName.append(')');
		result.internalSetIdentifier(fqName.toString());
		result.setSimpleName(simpleName);
		setVisibility(result, member.getModifiers());
	}

	protected void enhanceGenericDeclaration(JvmExecutable result, GenericDeclaration declaration) {
		for (TypeVariable<?> variable : declaration.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
	}

	protected JvmOperation createOperation(Method method) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		Type[] genericParameterTypes = null;
		try {
			genericParameterTypes = method.getGenericParameterTypes();
		} catch(GenericSignatureFormatError error) {
			genericParameterTypes = method.getParameterTypes();
		}
		enhanceGenericDeclaration(result, method);
		enhanceExecutable(result, method, method.getName(), genericParameterTypes, method.getParameterAnnotations(), 0);
		result.setVarArgs(method.isVarArgs());
		result.setAbstract(Modifier.isAbstract(method.getModifiers()));
		result.setFinal(Modifier.isFinal(method.getModifiers()));
		result.setStatic(Modifier.isStatic(method.getModifiers()));
		Type returnType = null;
		try {
			returnType = method.getGenericReturnType();
		} catch(GenericSignatureFormatError error) {
			returnType = method.getReturnType();
		}
		result.setReturnType(createTypeReference(returnType));
		for (Type parameterType : method.getGenericExceptionTypes()) {
			result.getExceptions().add(createTypeReference(parameterType));
		}
		createAnnotationValues(method, result);
		return result;
	}

	protected JvmFormalParameter createFormalParameter(Type parameterType, String paramName,
			org.eclipse.xtext.common.types.JvmMember container,
			GenericDeclaration member, Annotation[] annotations) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		if (isLocal(parameterType, member)) {
			result.setParameterType(createLocalTypeReference(parameterType, (JvmTypeParameterDeclarator) container, member));
		} else {
			result.setParameterType(createTypeReference(parameterType));
		}
		for (Annotation annotation : annotations) {
			result.getAnnotations().add(createAnnotationReference(annotation));
		}
		return result;
	}
	
	protected JvmTypeReference createLocalTypeReference(Type type, JvmTypeParameterDeclarator container, GenericDeclaration member) {
		if (type instanceof GenericArrayType) {
			GenericArrayType arrayType = (GenericArrayType) type;
			Type componentType = arrayType.getGenericComponentType();
			return createLocalArrayTypeReference(componentType, container, member);
		} else if (type instanceof TypeVariable<?>) {
			TypeVariable<?> typeVariable = (TypeVariable<?>) type;
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			int idx = Arrays.asList(member.getTypeParameters()).indexOf(typeVariable);
			result.setType(container.getTypeParameters().get(idx));
			return result;
		}
		throw new IllegalArgumentException(type.toString());
	}
	
	protected JvmTypeReference createLocalArrayTypeReference(Type componentType, JvmTypeParameterDeclarator container, GenericDeclaration member) {
		JvmTypeReference componentTypeReference = createLocalTypeReference(componentType, container, member);
		if (componentTypeReference != null) {
			JvmGenericArrayTypeReference result = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
			result.setComponentType(componentTypeReference);
			return result;
		} else {
			return null;
		}
	}

	protected boolean isLocal(Type parameterType, GenericDeclaration member) {
		if (parameterType instanceof TypeVariable<?>) {
			return member.equals(((TypeVariable<?>) parameterType).getGenericDeclaration());
		} else if (parameterType instanceof GenericArrayType) {
			return isLocal(((GenericArrayType) parameterType).getGenericComponentType(), member);
		}
		return false;
	}

	protected ClassURIHelper getUriHelper() {
		return uriHelper;
	}

}
