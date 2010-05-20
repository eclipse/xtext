/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedTypeFactory implements ITypeFactory<IType> {

	private final static Logger log = Logger.getLogger(JdtBasedTypeFactory.class);
	private final TypeURIHelper uriHelper;

	public JdtBasedTypeFactory(TypeURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}

	public JvmDeclaredType createType(IType jdtType) {
		if (jdtType.getDeclaringType() != null)
			throw new IllegalArgumentException("Cannot create type from non-toplevel-type: '"
					+ jdtType.getFullyQualifiedName() + "'.");
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setProject(jdtType.getJavaProject());
		IBinding[] bindings = parser.createBindings(new IJavaElement[] { jdtType }, null);
		if (bindings[0] == null)
			throw new IllegalStateException("Could not create binding for '" + jdtType.getFullyQualifiedName() + "'.");
		IBinding binding = bindings[0];
		if (binding instanceof ITypeBinding) {
			JvmDeclaredType result = createType((ITypeBinding) binding);
			return result;
		} else
			throw new IllegalStateException("Expected ITypeBinding for '" + jdtType.getFullyQualifiedName()
					+ "', but got '" + binding.toString() + "'.");
	}

	public JvmDeclaredType createType(ITypeBinding typeBinding) {
		if (typeBinding.isAnonymous() || typeBinding.isSynthetic())
			throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
		if (typeBinding.isAnnotation())
			return createAnnotationType(typeBinding);
		if (typeBinding.isEnum())
			return createEnumerationType(typeBinding);

		JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
		result.setInterface(typeBinding.isInterface());
		setTypeModifiers(typeBinding, result);
		setVisibility(result, typeBinding.getModifiers());
		result.setFullyQualifiedName(getQualifiedName(typeBinding));
		createNestedTypes(typeBinding, result);
		createMethods(typeBinding, result);
		for (IVariableBinding field : typeBinding.getDeclaredFields()) {
			if (!field.isSynthetic())
				result.getMembers().add(createField(field));
		}
		setSuperTypes(typeBinding, result);
		for (ITypeBinding variable : typeBinding.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
		createAnnotationValues(typeBinding, result);
		return result;
	}

	public String getQualifiedName(ITypeBinding binding) {
		return uriHelper.getQualifiedName(binding);
	}

	public void createAnnotationValues(IBinding annotated, JvmAnnotationTarget result) {
		if (annotated.getAnnotations().length == 0)
			return;
		for (IAnnotationBinding annotation : annotated.getAnnotations()) {
			createAnnotationReference(result, annotation);
		}
	}

	public JvmAnnotationReference createAnnotationReference(JvmAnnotationTarget result, IAnnotationBinding annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		result.getAnnotations().add(annotationReference);
		annotationReference.setAnnotation(createAnnotationProxy(annotation.getAnnotationType()));
		for (IMemberValuePairBinding memberValuePair : annotation.getAllMemberValuePairs()) {
			ITypeBinding originalTypeBinding = memberValuePair.getMethodBinding().getReturnType();
			ITypeBinding typeBinding = originalTypeBinding;
			if (typeBinding.isArray()) {
				typeBinding = typeBinding.getComponentType();
			}
			if (typeBinding.isParameterizedType())
				typeBinding = typeBinding.getErasure();
			JvmAnnotationValue annotationValue = originalTypeBinding.isArray() ? createArrayAnnotationValue(
					memberValuePair, createAnnotationValue(typeBinding)) : createAnnotationValue(memberValuePair,
					createAnnotationValue(typeBinding));
			annotationReference.getValues().add(annotationValue);
			annotationValue.setOperation(createMethodProxy(annotation.getAnnotationType(), memberValuePair.getName()));
		}
		return annotationReference;
	}

	public JvmAnnotationValue createArrayAnnotationValue(IMemberValuePairBinding memberValuePair,
			JvmAnnotationValue result) {
		Object value = memberValuePair.getValue();
		boolean valueIsArray = value.getClass().isArray();
		int length = valueIsArray ? Array.getLength(value) : 1;
		if (length > 0) {
			List<Object> valuesAsList = Lists.newArrayListWithExpectedSize(length);
			if (result instanceof JvmTypeAnnotationValue) {
				for (int i = 0; i < length; i++) {
					ITypeBinding referencedType = (ITypeBinding) (valueIsArray ? Array.get(value, i) : value);
					JvmTypeReference typeReference = createTypeReference(referencedType);
					valuesAsList.add(typeReference);
				}
			} else if (result instanceof JvmAnnotationAnnotationValue) {
				for (int i = 0; i < length; i++) {
					IAnnotationBinding nestedAnnotation = (IAnnotationBinding) (valueIsArray ? Array.get(value, i)
							: value);
					createAnnotationReference((JvmAnnotationTarget) result, nestedAnnotation);
				}
			} else if (result instanceof JvmEnumAnnotationValue) {
				log.error("Enumeration types are not yet fully supported.");
			} else {
				for (int i = 0; i < length; i++) {
					valuesAsList.add(valueIsArray ? Array.get(value, i) : value);
				}
			}
			if (!(result instanceof JvmAnnotationAnnotationValue)) {
				EStructuralFeature structuralFeature = result.eClass().getEStructuralFeature("values");
				if (structuralFeature.getEType() instanceof EDataType) {
					List<Object> convertedValues = Lists.newArrayListWithExpectedSize(valuesAsList.size());
					for (Object wrongType : valuesAsList) {
						Object convertedValue = EcoreFactory.eINSTANCE.createFromString((EDataType) structuralFeature
								.getEType(), wrongType.toString());
						convertedValues.add(convertedValue);
					}
					result.eSet(structuralFeature, convertedValues);
				} else {
					result.eSet(structuralFeature, valuesAsList);
				}
			}
		}
		return result;
	}

	public JvmType createProxy(ITypeBinding typeBinding) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmVoid();
		URI uri = uriHelper.getFullURI(typeBinding);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.JvmType) proxy;
	}

	public JvmType createProxyForType(String fqn) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmVoid();
		URI uri = uriHelper.getFullURIForClass(fqn);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.JvmType) proxy;
	}

	public JvmAnnotationValue createAnnotationValue(IMemberValuePairBinding memberValuePair, JvmAnnotationValue result) {
		Object value = memberValuePair.getValue();
		if (result instanceof JvmTypeAnnotationValue) {
			ITypeBinding referencedType = (ITypeBinding) value;
			JvmTypeReference typeReference = createTypeReference(referencedType);
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(typeReference));
		} else if (result instanceof JvmAnnotationAnnotationValue) {
			IAnnotationBinding nestedAnnotation = (IAnnotationBinding) value;
			createAnnotationReference((JvmAnnotationTarget) result, nestedAnnotation);
		} else if (result instanceof JvmEnumAnnotationValue) {
			log.error("Enumeration types are not yet fully supported.");
		} else {
			EStructuralFeature structuralFeature = result.eClass().getEStructuralFeature("values");
			Object convertedValue = EcoreFactory.eINSTANCE.createFromString((EDataType) structuralFeature.getEType(),
					value.toString());
			result.eSet(structuralFeature, Collections.singleton(convertedValue));
		}
		return result;
	}

	public JvmAnnotationValue createAnnotationValue(ITypeBinding type) {
		if (String.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
		} else if (Class.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
		} else if (type.isAnnotation()) {
			return TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
		} else if (type.isEnum()) {
			return TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
		} else if (int.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
		} else if (boolean.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
		} else if (long.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
		} else if (byte.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
		} else if (short.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
		} else if (float.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
		} else if (double.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
		} else if (char.class.getName().equals(type.getQualifiedName())) {
			return TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
		} else
			throw new IllegalArgumentException("Unexpected type: " + type);
	}

	public JvmOperation createMethodProxy(ITypeBinding typeBinding, String methodName) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmOperation();
		URI uri = uriHelper.getFullURI(typeBinding, methodName);
		proxy.eSetProxyURI(uri);
		return (JvmOperation) proxy;
	}

	public JvmAnnotationType createAnnotationProxy(ITypeBinding annotation) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmAnnotationType();
		URI uri = uriHelper.getFullURI(annotation);
		proxy.eSetProxyURI(uri);
		return (JvmAnnotationType) proxy;
	}

	public void setSuperTypes(ITypeBinding binding, JvmDeclaredType result) {
		if (!binding.isInterface()) {
			if (binding.getSuperclass() != null) {
				result.getSuperTypes().add(createTypeReference(binding.getSuperclass()));
			} else if (!Object.class.getName().equals(binding.getQualifiedName())) {
				result.getSuperTypes().add(createTypeReference(Object.class.getName()));
			}
		}
		for (ITypeBinding intf : binding.getInterfaces()) {
			result.getSuperTypes().add(createTypeReference(intf));
		}
	}

	public void createMethods(ITypeBinding typeBinding, JvmDeclaredType result) {
		for (IMethodBinding method : typeBinding.getDeclaredMethods()) {
			if (!method.isSynthetic() && !"<clinit>".equals(method.getName())) {
				if (method.isConstructor()) {
					result.getMembers().add(createConstructor(method));
				} else {
					result.getMembers().add(createOperation(method));
				}
			}
		}
	}

	public void createNestedTypes(ITypeBinding typeBinding, JvmDeclaredType result) {
		for (ITypeBinding declaredType : typeBinding.getDeclaredTypes()) {
			if (!declaredType.isAnonymous() && !declaredType.isSynthetic()) {
				result.getMembers().add(createType(declaredType));
			}
		}
	}

	public void setTypeModifiers(ITypeBinding binding, JvmDeclaredType result) {
		result.setAbstract(Modifier.isAbstract(binding.getModifiers()));
		result.setFinal(Modifier.isFinal(binding.getModifiers()));
		result.setStatic(Modifier.isStatic(binding.getModifiers()));
	}

	public JvmAnnotationType createAnnotationType(ITypeBinding binding) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.setFullyQualifiedName(getQualifiedName(binding));
		setVisibility(result, binding.getModifiers());
		setTypeModifiers(binding, result);
		createNestedTypes(binding, result);
		createMethods(binding, result);
		setSuperTypes(binding, result);
		createAnnotationValues(binding, result);
		return result;
	}

	public JvmEnumerationType createEnumerationType(ITypeBinding binding) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();
		result.setFullyQualifiedName(getQualifiedName(binding));
		setVisibility(result, binding.getModifiers());
		log.error("Enumeration types are not yet fully supported.");
		return result;
	}

	public JvmTypeParameter createTypeParameter(ITypeBinding parameter, JvmMember container) {
		JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
		result.setName(parameter.getName());
		if (parameter.getTypeBounds().length != 0) {
			for (ITypeBinding bound : parameter.getTypeBounds()) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				upperBound.setTypeReference(createTypeReference(bound));
				result.getConstraints().add(upperBound);
			}
		} else {
			JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
			upperBound.setTypeReference(createTypeReference(Object.class.getName()));
			result.getConstraints().add(upperBound);
		}
		return result;
	}

	public JvmTypeReference createTypeReference(ITypeBinding typeBinding) {
		if (typeBinding.isArray()) {
			ITypeBinding componentType = typeBinding.getComponentType();
			JvmTypeReference componentTypeReference = createTypeReference(componentType);
			JvmArrayType resultArray = TypesFactory.eINSTANCE.createJvmArrayType();
			resultArray.setComponentType(componentTypeReference);
			JvmGenericArrayTypeReference typeReference = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
			typeReference.setType(resultArray);
			return typeReference;
		}
		ITypeBinding[] typeArguments = typeBinding.getTypeArguments();
		if (typeArguments.length != 0) {
			ITypeBinding erasure = typeBinding.getErasure();
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(erasure));
			for (int i = 0; i < typeArguments.length; i++) {
				JvmTypeArgument argument = createTypeArgument(typeArguments[i]);
				result.getArguments().add(argument);
			}
			return result;
		} else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(typeBinding));
			return result;
		}
	}

	public JvmTypeReference createTypeReference(String qualifiedName) {
		JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		result.setType(createProxyForType(qualifiedName));
		return result;
	}

	public JvmTypeArgument createTypeArgument(ITypeBinding argument) {
		if (argument.isWildcardType()) {
			JvmWildcardTypeArgument result = TypesFactory.eINSTANCE.createJvmWildcardTypeArgument();
			if (argument.getBound() == null) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				JvmTypeReference reference = createTypeReference(Object.class.getName());
				upperBound.setTypeReference(reference);
				result.getConstraints().add(upperBound);
			} else {
				ITypeBinding bound = argument.getBound();
				if (argument.isUpperbound()) {
					JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
					JvmTypeReference reference = createTypeReference(bound);
					upperBound.setTypeReference(reference);
					result.getConstraints().add(upperBound);
				} else {
					JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
					JvmTypeReference objectReference = createTypeReference(Object.class.getName());
					upperBound.setTypeReference(objectReference);
					result.getConstraints().add(upperBound);
					JvmLowerBound lowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
					JvmTypeReference reference = createTypeReference(bound);
					lowerBound.setTypeReference(reference);
					result.getConstraints().add(lowerBound);
				}
			}
			return result;
		} else {
			JvmReferenceTypeArgument result = TypesFactory.eINSTANCE.createJvmReferenceTypeArgument();
			JvmTypeReference typeReference = createTypeReference(argument);
			result.setTypeReference(typeReference);
			return result;
		}
	}

	public JvmField createField(IVariableBinding field) {
		JvmField result = TypesFactory.eINSTANCE.createJvmField();
		String typeName = getQualifiedName(field.getDeclaringClass());
		String fqn = typeName + "." + field.getName();
		result.setFullyQualifiedName(fqn);
		result.setFinal(Modifier.isFinal(field.getModifiers()));
		result.setStatic(Modifier.isStatic(field.getModifiers()));
		setVisibility(result, field.getModifiers());
		result.setType(createTypeReference(field.getType()));
		createAnnotationValues(field, result);
		return result;
	}

	public void setVisibility(JvmMember result, int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(modifiers))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	public JvmConstructor createConstructor(IMethodBinding method) {
		JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(result, method);
		createAnnotationValues(method, result);
		return result;
	}

	public void enhanceExecutable(JvmExecutable result, IMethodBinding method) {
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(getQualifiedName(method.getDeclaringClass()));
		fqName.append('.');
		fqName.append(method.getName());
		fqName.append('(');
		ITypeBinding[] parameterTypes = method.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0)
				fqName.append(',');
			fqName.append(getQualifiedName(parameterTypes[i]));
		}
		fqName.append(')');
		result.setFullyQualifiedName(fqName.toString());
		setVisibility(result, method.getModifiers());

		IMethod javaMethod = (IMethod) method.getJavaElement();
		String[] parameterNames = null;
		if (javaMethod != null) {
			try {
				parameterNames = javaMethod.getParameterNames();
			} catch (JavaModelException ex) {
				if (!ex.isDoesNotExist())
					log.warn("IMethod.getParameterNames failed", ex);
			}
		}
		for (int i = 0; i < parameterTypes.length; i++) {
			String parameterName = parameterNames != null ? parameterNames[i] : "p" + i;
			IAnnotationBinding[] parameterAnnotations = method.getParameterAnnotations(i);
			result.getParameters().add(createFormalParameter(parameterTypes[i], parameterName, parameterAnnotations));
		}
		for (ITypeBinding exceptionType : method.getExceptionTypes()) {
			result.getExceptions().add(createTypeReference(exceptionType));
		}
	}

	public void enhanceGenericDeclaration(JvmExecutable result, ITypeBinding[] parameters) {
		for (ITypeBinding parameter : parameters) {
			result.getTypeParameters().add(createTypeParameter(parameter, result));
		}
	}

	public JvmOperation createOperation(IMethodBinding method) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(result, method);
		result.setFinal(Modifier.isFinal(method.getModifiers()));
		result.setStatic(Modifier.isStatic(method.getModifiers()));
		result.setReturnType(createTypeReference(method.getReturnType()));
		createAnnotationValues(method, result);
		return result;
	}

	public JvmFormalParameter createFormalParameter(ITypeBinding parameterType, String paramName, IAnnotationBinding[] annotations) {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType));
		for (IAnnotationBinding annotation : annotations) {
			createAnnotationReference(result, annotation);
		}
		return result;
	}

}
