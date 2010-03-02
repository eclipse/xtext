/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeParameter;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
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
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

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
			result.setAbstract(Flags.isAbstract(jdtType.getFlags()));
			result.setFinal(Flags.isFinal(jdtType.getFlags()));
			result.setInterface(jdtType.isInterface());
			result.setStatic(Flags.isStatic(jdtType.getFlags()));
			setVisibility(result, jdtType.getFlags());
			result.setFullyQualifiedName(jdtType.getFullyQualifiedName());
			for (IType declaredType : jdtType.getTypes()) {
				if (!declaredType.isAnonymous() && !Flags.isSynthetic(declaredType.getFlags())) {
					result.getMembers().add(createType(declaredType));
				}
			}
			for (IMethod method : jdtType.getMethods()) {
				if (!Flags.isSynthetic(method.getFlags()) && !"<clinit>".equals(method.getElementName())) {
					if (method.isConstructor()) {
						result.getMembers().add(createConstructor(method));
					}
					else {
						result.getMembers().add(createOperation(method));
					}
				}
			}
			for (IField field : jdtType.getFields()) {
				if (!Flags.isSynthetic(field.getFlags()))
					result.getMembers().add(createField(field));
			}
			if (!jdtType.isInterface() && jdtType.getSuperclassTypeSignature() != null)
				result.getSuperTypes().add(createTypeReference(jdtType.getSuperclassTypeSignature(), jdtType, result));
			for (String interfaceSignature : jdtType.getSuperInterfaceTypeSignatures()) {
				result.getSuperTypes().add(createTypeReference(interfaceSignature, jdtType, result));
			}
			for (ITypeParameter variable : jdtType.getTypeParameters()) {
				result.getTypeParameters().add(createTypeParameter(variable, result));
			}
			return result;
		}
		catch (JavaModelException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public JvmAnnotationType createAnnotationType(IType clazz) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.setFullyQualifiedName(clazz.getFullyQualifiedName());
		try {
			setVisibility(result, clazz.getFlags());
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
		log.error("Annotation types are not yet fully supported.");
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
								// Signature.createJvmTypeParameterSignature(typeParameter.getElementName(), typeParameter.getBounds());
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
