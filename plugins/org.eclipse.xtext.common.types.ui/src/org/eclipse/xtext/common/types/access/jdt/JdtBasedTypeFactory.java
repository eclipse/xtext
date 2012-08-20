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
import java.util.Set;

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
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jdt.internal.core.JavaElement;
import org.eclipse.jdt.internal.core.SourceMapper;
import org.eclipse.jdt.internal.core.SourceMethod;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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
		parser.setIgnoreMethodBodies(true);
		
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
		result.internalSetIdentifier(getQualifiedName(typeBinding));
		result.setSimpleName(typeBinding.getName());
		if (typeBinding.getDeclaringClass() == null && typeBinding.getPackage() != null)
			result.setPackageName(typeBinding.getPackage().getName());
		createNestedTypes(typeBinding, result);
		createMethods(typeBinding, result);
		createFields(typeBinding, result);
		setSuperTypes(typeBinding, result);
		for (ITypeBinding variable : typeBinding.getTypeParameters()) {
			result.getTypeParameters().add(createTypeParameter(variable, result));
		}
		createAnnotationValues(typeBinding, result);
		return result;
	}

	protected void createFields(ITypeBinding typeBinding, JvmDeclaredType result) {
		for (IVariableBinding field : typeBinding.getDeclaredFields()) {
			if (!field.isSynthetic())
				result.getMembers().add(createField(field));
		}
	}

	public String getQualifiedName(ITypeBinding binding) {
		return uriHelper.getQualifiedName(binding);
	}

	public void createAnnotationValues(IBinding annotated, JvmAnnotationTarget result) {
		try {
			if (annotated.getAnnotations().length == 0)
				return;
			for (IAnnotationBinding annotation : annotated.getAnnotations()) {
				createAnnotationReference(result, annotation);
			}
		} catch(AbortCompilation aborted) {
			log.info("Couldn't resolve annotations of "+annotated, aborted);
		}
	}

	public JvmAnnotationReference createAnnotationReference(JvmAnnotationTarget result, IAnnotationBinding annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		result.getAnnotations().add(annotationReference);
		annotationReference.setAnnotation(createAnnotationProxy(annotation.getAnnotationType()));
		try {
			IMemberValuePairBinding[] allMemberValuePairs = annotation.getAllMemberValuePairs();
			for (IMemberValuePairBinding memberValuePair : allMemberValuePairs) {
				IMethodBinding methodBinding = memberValuePair.getMethodBinding();
				createAnnotationValue(annotationReference, annotation, memberValuePair.getValue(), methodBinding);
			}
		} catch(NullPointerException npe) {
			log.debug("NPE in IAnnotationBinding#getAllMemberValuePairs ?", npe);
			IMemberValuePairBinding[] declaredMemberValuePairs = annotation.getDeclaredMemberValuePairs();
			Set<IMethodBinding> seenMethodBindings = Sets.newHashSet();
			for (IMemberValuePairBinding memberValuePair : declaredMemberValuePairs) {
				IMethodBinding methodBinding = memberValuePair.getMethodBinding();
				seenMethodBindings.add(methodBinding);
				createAnnotationValue(annotationReference, annotation, memberValuePair.getValue(), methodBinding);
			}
			ITypeBinding annotationType = annotation.getAnnotationType();
			IMethodBinding[] allAnnotationMethods = annotationType.getDeclaredMethods();
			for(IMethodBinding methodBinding: allAnnotationMethods) {
				if (seenMethodBindings.add(methodBinding)) {
					try {
						createAnnotationValue(annotationReference, annotation, methodBinding.getDefaultValue(), methodBinding);
					} catch(NullPointerException nestedNPE) {
						log.debug("NPE in IMethodBinding#getDefaultValue ?", npe);
					}
				}
			}
		}
		return annotationReference;
	}

	/**
	 * @since 2.3
	 */
	protected void createAnnotationValue(JvmAnnotationReference annotationReference, IAnnotationBinding annotation,
			Object value, IMethodBinding methodBinding) {
		ITypeBinding originalTypeBinding = methodBinding.getReturnType();
		ITypeBinding typeBinding = originalTypeBinding;
		if (typeBinding.isArray()) {
			typeBinding = typeBinding.getComponentType();
		}
		if (typeBinding.isParameterizedType())
			typeBinding = typeBinding.getErasure();
		JvmAnnotationValue annotationValue = originalTypeBinding.isArray() ? 
				createArrayAnnotationValue(value, createAnnotationValue(typeBinding)) : 
				createAnnotationValue(value, createAnnotationValue(typeBinding));
		annotationReference.getValues().add(annotationValue);
		annotationValue.setOperation(createMethodProxy(annotation.getAnnotationType(), methodBinding.getName()));
	}

	private JvmAnnotationValue createArrayAnnotationValue(Object value, JvmAnnotationValue result) {
		if (value == null)
			return result;
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
				for (int i = 0; i < length; i++) {
					IVariableBinding variableBinding = (IVariableBinding) (valueIsArray ? Array.get(value, i) : value);
					JvmEnumerationLiteral proxy = createEnumLiteralProxy(variableBinding);
					valuesAsList.add(proxy);
				}
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

	private JvmAnnotationValue createAnnotationValue(Object value, JvmAnnotationValue result) {
		if (value == null)
			return result;
		if (result instanceof JvmTypeAnnotationValue) {
			ITypeBinding referencedType = (ITypeBinding) value;
			JvmTypeReference typeReference = createTypeReference(referencedType);
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(typeReference));
		} else if (result instanceof JvmAnnotationAnnotationValue) {
			IAnnotationBinding nestedAnnotation = (IAnnotationBinding) value;
			createAnnotationReference((JvmAnnotationTarget) result, nestedAnnotation);
		} else if (result instanceof JvmEnumAnnotationValue) {
			IVariableBinding variableBinding = (IVariableBinding) value;
			JvmEnumerationLiteral proxy = createEnumLiteralProxy(variableBinding);
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(proxy));
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
	
	public JvmEnumerationLiteral createEnumLiteralProxy(IVariableBinding binding) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		URI uri = uriHelper.getFullURI(binding);
		proxy.eSetProxyURI(uri);
		return (JvmEnumerationLiteral) proxy;
	}

	public JvmAnnotationType createAnnotationProxy(ITypeBinding annotation) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmAnnotationType();
		URI uri = uriHelper.getFullURI(annotation);
		proxy.eSetProxyURI(uri);
		return (JvmAnnotationType) proxy;
	}

	public void setSuperTypes(ITypeBinding binding, JvmDeclaredType result) {
		if (binding.getSuperclass() != null) {
			result.getSuperTypes().add(createTypeReference(binding.getSuperclass()));
		} 
		for (ITypeBinding intf : binding.getInterfaces()) {
			result.getSuperTypes().add(createTypeReference(intf));
		}
		if (result.getSuperTypes().isEmpty() && !Object.class.getName().equals(binding.getQualifiedName())) {
			result.getSuperTypes().add(createTypeReference(Object.class.getName()));
		}
	}

	public void createMethods(ITypeBinding typeBinding, JvmDeclaredType result) {
		for (IMethodBinding method : typeBinding.getDeclaredMethods()) {
			if (!method.isSynthetic() && !"<clinit>".equals(method.getName())) {
				if (method.isConstructor()) {
					result.getMembers().add(createConstructor(method));
				} else {
					JvmOperation operation = createOperation(method);
					if (typeBinding.isAnnotation()) {
						setDefaultValue(operation, method);
					}
					result.getMembers().add(operation);
				}
			}
		}
	}
	
	private void setDefaultValue(JvmOperation operation, IMethodBinding method) {
		Object defaultValue = method.getDefaultValue();
		if (defaultValue != null) {
			ITypeBinding originalTypeBinding = method.getReturnType();
			ITypeBinding typeBinding = originalTypeBinding;
			if (typeBinding.isArray()) {
				typeBinding = typeBinding.getComponentType();
			}
			if (typeBinding.isParameterizedType())
				typeBinding = typeBinding.getErasure();
			JvmAnnotationValue annotationValue = originalTypeBinding.isArray() ? 
					createArrayAnnotationValue(defaultValue, createAnnotationValue(typeBinding)) : 
					createAnnotationValue(defaultValue, createAnnotationValue(typeBinding));
			operation.setDefaultValue(annotationValue);
			annotationValue.setOperation(operation);
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
		result.internalSetIdentifier(getQualifiedName(binding));
		result.setSimpleName(binding.getName());
		if (binding.getDeclaringClass() == null)
			result.setPackageName(binding.getPackage().getName());
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
		result.internalSetIdentifier(getQualifiedName(binding));
		result.setSimpleName(binding.getName());
		if (binding.getDeclaringClass() == null)
			result.setPackageName(binding.getPackage().getName());
		setVisibility(result, binding.getModifiers());
		setTypeModifiers(binding, result);
		createNestedTypes(binding, result);
		createMethods(binding, result);
		createFields(binding, result);
		setSuperTypes(binding, result);
		createAnnotationValues(binding, result);
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
			JvmGenericArrayTypeReference typeReference = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
			typeReference.setComponentType(componentTypeReference);
			return typeReference;
		}
		ITypeBinding[] typeArguments = typeBinding.getTypeArguments();
		if (typeArguments.length != 0) {
			ITypeBinding erasure = typeBinding.getErasure();
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(erasure));
			for (int i = 0; i < typeArguments.length; i++) {
				JvmTypeReference argument = createTypeArgument(typeArguments[i]);
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

	public JvmTypeReference createTypeArgument(ITypeBinding argument) {
		if (argument.isWildcardType()) {
			JvmWildcardTypeReference result = TypesFactory.eINSTANCE.createJvmWildcardTypeReference();
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
			return createTypeReference(argument);
		}
	}

	public JvmField createField(IVariableBinding field) {
		JvmField result;
		if (!field.isEnumConstant())
			result = TypesFactory.eINSTANCE.createJvmField();
		else
			result = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
		String typeName = getQualifiedName(field.getDeclaringClass());
		String fqn = typeName + "." + field.getName();
		result.internalSetIdentifier(fqn);
		result.setSimpleName(field.getName());
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
		result.internalSetIdentifier(fqName.toString());
		result.setSimpleName(method.getName());
		setVisibility(result, method.getModifiers());

		IMethod javaMethod = null;
		try {
			javaMethod = (IMethod) method.getJavaElement();
		} catch(IllegalArgumentException e) {
			log.debug("Cannot locate javaMethod for: " + fqName);
		}
		String[] parameterNames = fastGetParameterNames(javaMethod);
		result.setVarArgs(method.isVarargs());
		for (int i = 0; i < parameterTypes.length; i++) {
			String parameterName = parameterNames != null ? parameterNames[i] : "p" + i;
			IAnnotationBinding[] parameterAnnotations = null;
			try {
				parameterAnnotations = method.getParameterAnnotations(i);
			} catch(AbortCompilation aborted) {
				parameterAnnotations = null;
			}
			result.getParameters().add(createFormalParameter(parameterTypes[i], parameterName, parameterAnnotations));
		}
		for (ITypeBinding exceptionType : method.getExceptionTypes()) {
			result.getExceptions().add(createTypeReference(exceptionType));
		}
	}

	protected String[] fastGetParameterNames(IMethod javaMethod) {
		String[] parameterNames = null;
		if (javaMethod != null) {
			parameterNames = Strings.EMPTY_ARRAY;
			int numberOfParameters = javaMethod.getNumberOfParameters();
			if (numberOfParameters != 0) {
				if (javaMethod.exists()) {
					try {
						if (javaMethod instanceof SourceMethod) {
							parameterNames = javaMethod.getParameterNames();
							return parameterNames;
						}
						if (javaMethod instanceof JavaElement) {
							JavaElement casted = (JavaElement) javaMethod;
							SourceMapper mapper = casted.getSourceMapper();
							if (mapper != null) {
								char[][] parameterNamesAsChars = mapper.getMethodParameterNames(javaMethod);
								if (parameterNamesAsChars != null) {
									parameterNames = toStringArray(parameterNamesAsChars);
									return parameterNames;
								}
								IType type = (IType) javaMethod.getParent();
								IBinaryType info = (IBinaryType) ((BinaryType) javaMethod
										.getDeclaringType()).getElementInfo();
								char[] source = mapper.findSource(type, info);
								if (source != null) {
									mapper.mapSource(type, source, info);
									parameterNamesAsChars = mapper.getMethodParameterNames(javaMethod);
									if (parameterNamesAsChars != null) {
										parameterNames = toStringArray(parameterNamesAsChars);
										return parameterNames;
									}
								}
							}
						}
					} catch (JavaModelException ex) {
						if (!ex.isDoesNotExist())
							log.warn("IMethod.getParameterNames failed", ex);
					}
				}
				// same as #getRawParameterNames but without throwing a JavaModelException
				parameterNames = new String[numberOfParameters];
				for (int i = 0; i < numberOfParameters; i++) {
					parameterNames[i] = "arg" + i;
				}
			}
		}
		return parameterNames;
	}
	
	private String[] toStringArray(char[][] chars) {
		String[] result = new String[chars.length];
		for (int i = 0; i < chars.length; i++) {
			result[i] = new String(chars[i]);
		}
		return result;
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
		result.setAbstract(Modifier.isAbstract(method.getModifiers()));
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
		if (annotations != null) {
			for (IAnnotationBinding annotation : annotations) {
				createAnnotationReference(result, annotation);
			}
		}
		return result;
	}

}
