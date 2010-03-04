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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeParameter;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMemberValuePairBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
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
		try {
			if (jdtType.isAnonymous() || Flags.isSynthetic(jdtType.getFlags()))
				throw new IllegalStateException("Cannot create type for anonymous or synthetic classes");
			if (jdtType.isAnnotation())
				return createAnnotationType(jdtType);
			if (jdtType.isEnum())
				return createEnumerationType(jdtType);

			JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
			result.setInterface(jdtType.isInterface());
			setTypeModifiers(jdtType, result);
			setVisibility(result, jdtType.getFlags());
			result.setFullyQualifiedName(jdtType.getFullyQualifiedName());
			createNestedTypes(jdtType, result);
			boolean constructorCreated = createMethods(jdtType, result);
			if (!constructorCreated && !jdtType.isResolved()) {
				JvmConstructor defaultConstructor = TypesFactory.eINSTANCE.createJvmConstructor();
				StringBuilder fqName = new StringBuilder(48);
				fqName.append(jdtType.getFullyQualifiedName());
				fqName.append('.');
				fqName.append(jdtType.getElementName());
				fqName.append("()");
				defaultConstructor.setFullyQualifiedName(fqName.toString());
				defaultConstructor.setVisibility(JvmVisibility.PUBLIC);
				result.getMembers().add(defaultConstructor);
			}
			for (IField field : jdtType.getFields()) {
				if (!Flags.isSynthetic(field.getFlags()))
					result.getMembers().add(createField(field));
			}
			setSuperTypes(jdtType, result);
			for (ITypeParameter variable : jdtType.getTypeParameters()) {
				result.getTypeParameters().add(createTypeParameter(variable, result));
			}
			createAnnotationValues(jdtType, jdtType, result);
			return result;
		}
		catch (JavaModelException ex) {
			throw new RuntimeException(ex);
		}
	}

	protected void createAnnotationValues(IAnnotatable annotated, IMember declarator, JvmAnnotationTarget result) throws JavaModelException {
		if (annotated.getAnnotations().length == 0)
			return;
		ASTParser parser = ASTParser.newParser(ASTParser.K_STATEMENTS);
		parser.setProject(declarator.getJavaProject());
		IBinding[] bindings = parser.createBindings(new IJavaElement[] {declarator}, null);
		if (bindings[0] != null) {
			if (declarator instanceof IMethod && ((IMethod) declarator).isConstructor()) {
				ITypeBinding typeBinding = (ITypeBinding) bindings[0];
				IMethod method = (IMethod) declarator;
				String bindingKey = method.getKey();
				{
					int idx = bindingKey.indexOf('(');
					bindingKey = bindingKey.substring(idx);
				}
				for(IMethodBinding methodBinding: typeBinding.getDeclaredMethods()) {
					if (methodBinding.isConstructor()) {
						String actualKey = methodBinding.getKey();
						int idx = actualKey.indexOf('(');
						actualKey = actualKey.substring(idx);
						if (bindingKey.equals(actualKey)) {
							for(IAnnotationBinding annotation: methodBinding.getAnnotations()) {
								createAnnotationReference(result, declarator, annotation);
							}		
						}
					}
				}
			} else {
				for(IAnnotationBinding annotation: bindings[0].getAnnotations()) {
					createAnnotationReference(result, declarator, annotation);
				}
			}
		} 
	}
	
	protected JvmAnnotationReference createAnnotationReference(JvmAnnotationTarget result, IMember declarator, IAnnotationBinding annotation) throws JavaModelException {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE.createJvmAnnotationReference();
		result.getAnnotations().add(annotationReference);
		String annotationName = annotation.getAnnotationType().getQualifiedName();
		IType annotationType = (IType) annotation.getAnnotationType().getJavaElement();
		if (annotationType != null)
			annotationName = annotationType.getFullyQualifiedName();
		String annotationSignature = Signature.createTypeSignature(annotationName, true);
		annotationReference.setAnnotation(createAnnotationProxy(annotationSignature, declarator));
		for(IMemberValuePairBinding memberValuePair: annotation.getAllMemberValuePairs()) {
			ITypeBinding originalTypeBinding = memberValuePair.getMethodBinding().getReturnType();
			ITypeBinding typeBinding = originalTypeBinding;
			if (typeBinding.isArray()) {
				typeBinding = typeBinding.getComponentType();
			}
			if (typeBinding.isParameterizedType())
				typeBinding = typeBinding.getErasure();
			JvmAnnotationValue annotationValue = originalTypeBinding.isArray() ?
					createArrayAnnotationValue(memberValuePair, createAnnotationValue(typeBinding), declarator) :
					createAnnotationValue(memberValuePair,	createAnnotationValue(typeBinding), declarator);
			annotationReference.getValues().add(annotationValue);
			annotationValue.setOperation(createMethodProxy(annotationSignature, memberValuePair.getName(), declarator));
		}
		return annotationReference;
	}
	
	protected JvmAnnotationValue createArrayAnnotationValue(IMemberValuePairBinding memberValuePair, JvmAnnotationValue result, IMember declarator) throws JavaModelException {
		Object value = memberValuePair.getValue();
		int length = Array.getLength(value);
		if (length > 0) {
			List<Object> valuesAsList = Lists.newArrayListWithExpectedSize(length);
			if (result instanceof JvmTypeAnnotationValue) {
				for(int i = 0; i < length; i++) {
					ITypeBinding referencedType = (ITypeBinding) Array.get(value, i);
					JvmType proxy = createProxy(declarator, referencedType);
					valuesAsList.add(proxy);
				}
			} else if (result instanceof JvmAnnotationAnnotationValue) {
				for(int i = 0; i < length; i++) {
					IAnnotationBinding nestedAnnotation = (IAnnotationBinding) Array.get(value, i);
					createAnnotationReference((JvmAnnotationTarget) result, declarator, nestedAnnotation);
				}
			} else if (result instanceof JvmEnumAnnotationValue) {
				log.error("Enumeration types are not yet fully supported.");
			} else {
				for(int i = 0; i < length; i++) {
					valuesAsList.add(Array.get(value, i));
				}
			}
			if (!(result instanceof JvmAnnotationAnnotationValue))
				result.eSet(result.eClass().getEStructuralFeature("values"), valuesAsList);
		}
		return result;
	}
	
	public JvmType createProxy(IMember declarator, ITypeBinding referencedType) throws JavaModelException {
		String name = referencedType.getQualifiedName();
		IType bindingAsType = (IType) referencedType.getJavaElement();
		if (bindingAsType != null) {
			name = bindingAsType.getFullyQualifiedName();
		}
		String signature = Signature.createTypeSignature(name, true);
		JvmType proxy = createProxy(signature, declarator);
		return proxy;
	}
	
	protected JvmAnnotationValue createAnnotationValue(IMemberValuePairBinding memberValuePair, JvmAnnotationValue result, IMember declarator) throws JavaModelException {
		Object value = memberValuePair.getValue();
		if (result instanceof JvmTypeAnnotationValue) {
			ITypeBinding referencedType = (ITypeBinding) value;
			JvmType proxy = createProxy(declarator, referencedType);
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(proxy));
		} else if (result instanceof JvmAnnotationAnnotationValue) {
			IAnnotationBinding nestedAnnotation = (IAnnotationBinding) value;
			createAnnotationReference((JvmAnnotationTarget) result, declarator, nestedAnnotation);
		} else if (result instanceof JvmEnumAnnotationValue) {
			log.error("Enumeration types are not yet fully supported.");
		} else {
			result.eSet(result.eClass().getEStructuralFeature("values"), Collections.singleton(value));
		}
		return result;
	}
	
	protected JvmAnnotationValue createAnnotationValue(ITypeBinding type)  {
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
	
	protected JvmOperation createMethodProxy(String typeName, String methodName, IMember declarator) throws JavaModelException {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmOperation();
		URI uri = uriHelper.getFullURI(typeName, methodName, declarator);
		proxy.eSetProxyURI(uri);
		return (JvmOperation) proxy;
	}
	
	protected JvmAnnotationType createAnnotationProxy(String signature, IMember declarator) throws JavaModelException {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmAnnotationType();
		URI uri = uriHelper.getFullURI(signature, declarator);
		proxy.eSetProxyURI(uri);
		return (JvmAnnotationType) proxy;
	}
	
	protected void setSuperTypes(IType jdtType, JvmDeclaredType result) throws JavaModelException {
		if (!jdtType.isInterface() && jdtType.getSuperclassTypeSignature() != null)
			result.getSuperTypes().add(createTypeReference(jdtType.getSuperclassTypeSignature(), jdtType, result));
		for (String interfaceSignature : jdtType.getSuperInterfaceTypeSignatures()) {
			result.getSuperTypes().add(createTypeReference(interfaceSignature, jdtType, result));
		}
	}

	protected boolean createMethods(IType jdtType, JvmDeclaredType result) throws JavaModelException {
		boolean constructorCreated = false;
		for (IMethod method : jdtType.getMethods()) {
			if (!Flags.isSynthetic(method.getFlags()) && !"<clinit>".equals(method.getElementName())) {
				if (method.isConstructor()) {
					result.getMembers().add(createConstructor(method));
					constructorCreated = true;
				} else {
					result.getMembers().add(createOperation(method));
				}
			}
		}
		return constructorCreated;
	}

	protected void createNestedTypes(IType jdtType, JvmDeclaredType result) throws JavaModelException {
		for (IType declaredType : jdtType.getTypes()) {
			if (!declaredType.isAnonymous() && !Flags.isSynthetic(declaredType.getFlags())) {
				result.getMembers().add(createType(declaredType));
			}
		}
	}

	protected void setTypeModifiers(IType jdtType, JvmDeclaredType result) throws JavaModelException {
		result.setAbstract(Flags.isAbstract(jdtType.getFlags()));
		result.setFinal(Flags.isFinal(jdtType.getFlags()));
		result.setStatic(Flags.isStatic(jdtType.getFlags()));
	}
	
	public JvmAnnotationType createAnnotationType(IType clazz) throws JavaModelException {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.setFullyQualifiedName(clazz.getFullyQualifiedName());
		setVisibility(result, clazz.getFlags());
		setTypeModifiers(clazz, result);
		createNestedTypes(clazz, result);
		createMethods(clazz, result);
		setSuperTypes(clazz, result);
		createAnnotationValues(clazz, clazz, result);
		return result;
	}

	public JvmEnumerationType createEnumerationType(IType clazz) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();
		result.setFullyQualifiedName(clazz.getFullyQualifiedName());
		try {
			setVisibility(result, clazz.getFlags());
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
		log.error("Enumeration types are not yet fully supported.");
		return result;
	}

	public JvmTypeParameter createTypeParameter(ITypeParameter parameter, org.eclipse.xtext.common.types.JvmMember container)
			throws JavaModelException {
		JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
		result.setName(parameter.getElementName());
		if (parameter.getBounds().length != 0) {
			for (String bound : parameter.getBounds()) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
				String boundSignature = null;
				IMember parameterContainer = parameter.getDeclaringMember();
				while(parameterContainer != null && boundSignature == null) {
					ITypeParameter[] typeParameters = null;
					if (parameterContainer instanceof IMethod) {
						IMethod method = (IMethod) parameterContainer;
						typeParameters = method.getTypeParameters();
					} else if (parameterContainer instanceof IType) {
						IType type = (IType) parameterContainer;
						typeParameters = type.getTypeParameters();
					}
					if (typeParameters != null && typeParameters.length != 0) {
						for(ITypeParameter typeParameter: typeParameters) {
							if (bound.equals(typeParameter.getElementName())) {
								// does not work:
								// Signature.createTypeParameterSignature(typeParameter.getElementName(), typeParameter.getBounds());
								// create valid signature manually
								boundSignature = "T" + typeParameter.getElementName() + ";";
								break;
							}
						}
					}
					if (boundSignature == null)
						parameterContainer = parameterContainer.getDeclaringType();
				}
				if (boundSignature == null) {
					boundSignature = Signature.createTypeSignature(bound, true);
					parameterContainer = parameter.getDeclaringMember();
				}
				upperBound.setTypeReference(
						createTypeReference(boundSignature, parameterContainer, container));
				result.getConstraints().add(upperBound);
			}
		}
		return result;
	}

	private JvmTypeReference createTypeReference(String signature, IMember declarator,
			JvmMember container) throws JavaModelException {
		int arrayDim = Signature.getArrayCount(signature);
		if (arrayDim != 0) {
			String componentSignature = Signature.getElementType(signature);
			JvmTypeReference componentTypeReference = createTypeReference(componentSignature, declarator, container);
			if (componentTypeReference != null) {
				for (int i = 0; i < arrayDim; i++) {
					JvmArrayType resultArray = TypesFactory.eINSTANCE.createJvmArrayType();
					resultArray.setComponentType(componentTypeReference);
					
					JvmGenericArrayTypeReference typeReference = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
					typeReference.setType(resultArray);
					componentTypeReference = typeReference;
				}
				return componentTypeReference;
			}
			else {
				return null;
			}
		}
		String[] typeArguments = Signature.getTypeArguments(signature);
		if (typeArguments.length != 0) {
			String rawType = uriHelper.getTypeErasure(signature);
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(rawType, declarator));
			for (int i = 0; i < typeArguments.length; i++) {
				JvmTypeArgument argument = createTypeArgument(typeArguments[i], declarator, container, rawType, i);
				result.getArguments().add(argument);
			}
			return result;
		}
		else {
			JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			result.setType(createProxy(signature, declarator));
			return result;
		}
	}

	private JvmTypeArgument createTypeArgument(String actualTypeSignature, IMember declarator, JvmMember container,
			String rawTypeSignature, int i) throws JavaModelException {
		int signatureKind = Signature.getTypeSignatureKind(actualTypeSignature);
		if (signatureKind == Signature.WILDCARD_TYPE_SIGNATURE) {
			JvmWildcardTypeArgument result = TypesFactory.eINSTANCE.createJvmWildcardTypeArgument();
			switch (actualTypeSignature.charAt(0)) {
				case '*': 
					{
						JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
						JvmTypeReference reference = createTypeReference(
								Signature.createTypeSignature(Object.class.getName(), true), 
								declarator, container);
						upperBound.setTypeReference(reference);
						result.getConstraints().add(upperBound);
					}
					break;
				case '+': 
					{
						String upperBoundSignature = actualTypeSignature.substring(1);
						JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
						JvmTypeReference reference = createTypeReference(upperBoundSignature, declarator, container);
						upperBound.setTypeReference(reference);
						result.getConstraints().add(upperBound);
					}
					break;
				case '-': 
					{
						JvmUpperBound upperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
						JvmTypeReference objectReference = createTypeReference(
								Signature.createTypeSignature(Object.class.getName(), true), 
								declarator, container);
						upperBound.setTypeReference(objectReference);
						result.getConstraints().add(upperBound);
						String lowerBoundSignature = actualTypeSignature.substring(1);
						JvmLowerBound lowerBound = TypesFactory.eINSTANCE.createJvmLowerBound();
						JvmTypeReference reference = createTypeReference(lowerBoundSignature, declarator, container);
						lowerBound.setTypeReference(reference);
						result.getConstraints().add(lowerBound);
					}
					break;
				default:
					throw new IllegalArgumentException("Signature: " + actualTypeSignature);
			}
			return result;
		}
		else {
			JvmReferenceTypeArgument result = TypesFactory.eINSTANCE.createJvmReferenceTypeArgument();
			JvmTypeReference typeReference = createTypeReference(actualTypeSignature, declarator, container);
			result.setTypeReference(typeReference);
			return result;
		}
	}

	public org.eclipse.xtext.common.types.JvmType createProxy(String signature, IMember declarator) throws JavaModelException {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmVoid();
		URI uri = uriHelper.getFullURI(signature, declarator);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.JvmType) proxy;
	}

	public JvmField createField(IField field) throws JavaModelException {
		JvmField result = TypesFactory.eINSTANCE.createJvmField();
		result.setFullyQualifiedName(field.getDeclaringType().getFullyQualifiedName() + "." + field.getElementName());
		result.setFinal(Flags.isFinal(field.getFlags()));
		result.setStatic(Flags.isStatic(field.getFlags()));
		setVisibility(result, field.getFlags());
		result.setType(createTypeReference(field.getTypeSignature(), field, result));
		createAnnotationValues(field, field, result);
		return result;
	}
	
	public void setVisibility(org.eclipse.xtext.common.types.JvmMember result, int modifiers) {
		if (Flags.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Flags.isProtected(modifiers))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Flags.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	public JvmConstructor createConstructor(IMethod method) throws JavaModelException {
		JvmConstructor result = TypesFactory.eINSTANCE.createJvmConstructor();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(result, method, method.getParameterNames(), method.getParameterTypes());
		for (String exceptionType : method.getExceptionTypes()) {
			result.getExceptions().add(createTypeReference(exceptionType, method, result));
		}
		createAnnotationValues(method, method, result);
		return result;
	}

	public void enhanceExecutable(JvmExecutable result, IMember member, String[] parameterNames, String[] parameterTypes)
			throws JavaModelException {
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(member.getDeclaringType().getFullyQualifiedName());
		fqName.append('.');
		fqName.append(member.getElementName());
		fqName.append('(');
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0)
				fqName.append(',');
			uriHelper.computeTypeName(parameterTypes[i], fqName);
		}
		fqName.append(')');
		result.setFullyQualifiedName(fqName.toString());
		setVisibility(result, member.getFlags());
		for (int i = 0; i < parameterNames.length; i++) {
			result.getParameters().add(createFormalParameter(parameterTypes[i], parameterNames[i], member, result));
		}
	}

	public void enhanceGenericDeclaration(JvmExecutable result, ITypeParameter[] parameters) throws JavaModelException {
		for (ITypeParameter parameter : parameters) {
			result.getTypeParameters().add(createTypeParameter(parameter, result));
		}
	}

	public JvmOperation createOperation(IMethod method) throws JavaModelException {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(result, method, method.getParameterNames(), method.getParameterTypes());
		result.setFinal(Flags.isFinal(method.getFlags()));
		result.setStatic(Flags.isStatic(method.getFlags()));
		result.setReturnType(createTypeReference(method.getReturnType(), method, result));
		for (String exceptionTypes : method.getExceptionTypes()) {
			result.getExceptions().add(createTypeReference(exceptionTypes, method, result));
		}
		createAnnotationValues(method, method, result);
		return result;
	}

	public JvmFormalParameter createFormalParameter(String parameterType, String paramName, IMember declarator,
			org.eclipse.xtext.common.types.JvmMember container) throws JavaModelException {
		JvmFormalParameter result = TypesFactory.eINSTANCE.createJvmFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType, declarator, container));
		return result;
	}

}
