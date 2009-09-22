/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

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
import org.eclipse.xtext.common.types.AnnotationType;
import org.eclipse.xtext.common.types.ComponentType;
import org.eclipse.xtext.common.types.Constructor;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.EnumerationType;
import org.eclipse.xtext.common.types.Executable;
import org.eclipse.xtext.common.types.Field;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.LowerBound;
import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.ReferenceTypeParameter;
import org.eclipse.xtext.common.types.TypeParameter;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.TypeVariable;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.Wildcard;
import org.eclipse.xtext.common.types.WildcardTypeParameter;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedTypeFactory implements ITypeFactory<IType> {

	private final TypeURIHelper uriHelper;

	public JdtBasedTypeFactory(TypeURIHelper uriHelper) {
		this.uriHelper = uriHelper;
	}

	public DeclaredType createType(IType jdtType) {
		try {
			if (jdtType.isAnonymous())
				throw new IllegalStateException("Cannot create type for anonymous class");
			if (jdtType.isAnnotation())
				return createAnnotationType(jdtType);
			if (jdtType.isEnum())
				return createEnumerationType(jdtType);

			GenericType result = TypesFactory.eINSTANCE.createGenericType();
			result.setAbstract(Flags.isAbstract(jdtType.getFlags()));
			result.setFinal(Flags.isFinal(jdtType.getFlags()));
			result.setInterface(jdtType.isInterface());
			result.setStatic(Flags.isStatic(jdtType.getFlags()));
			if (Flags.isPrivate(jdtType.getFlags()))
				result.setVisibility("private");
			else if (Flags.isProtected(jdtType.getFlags()))
				result.setVisibility("protected");
			else if (Flags.isPublic(jdtType.getFlags()))
				result.setVisibility("public");
			result.setFullyQualifiedName(jdtType.getFullyQualifiedName());
			for (IType declaredType : jdtType.getTypes()) {
				if (!declaredType.isAnonymous()) {
					result.getMembers().add(createType(declaredType));
				}
			}
			for (IMethod method : jdtType.getMethods()) {
				if (!Flags.isSynthetic(method.getFlags())) {
					if (method.isConstructor()) {
						result.getMembers().add(createConstructor(method));
					}
					else {
						result.getMembers().add(createOperation(method));
					}
				}
			}
			for (IField field : jdtType.getFields()) {
				result.getMembers().add(createField(field));
			}
			if (!jdtType.isInterface() && jdtType.getSuperclassTypeSignature() != null)
				result.getSuperTypes().add(createTypeReference(jdtType.getSuperclassTypeSignature(), jdtType, result));
			for (String interfaceSignature : jdtType.getSuperInterfaceTypeSignatures()) {
				result.getSuperTypes().add(createTypeReference(interfaceSignature, jdtType, result));
			}
			for (ITypeParameter variable : jdtType.getTypeParameters()) {
				result.getTypeVariables().add(createTypeVariable(variable, result));
			}
			return result;
		}
		catch (JavaModelException ex) {
			throw new RuntimeException(ex);
		}
	}

	public TypeVariable createTypeVariable(ITypeParameter parameter, org.eclipse.xtext.common.types.Member container)
			throws JavaModelException {
		TypeVariable result = TypesFactory.eINSTANCE.createTypeVariable();
		result.setName(parameter.getElementName());
		if (parameter.getBounds().length != 0) {
			UpperBound upperBound = TypesFactory.eINSTANCE.createUpperBound();
			for (String bound : parameter.getBounds()) {
				String boundSignature = Signature.createTypeSignature(bound, true);
				upperBound.getReferencedTypes().add(
						createTypeReference(boundSignature, parameter.getDeclaringMember(), container));
			}
			result.getConstraints().add(upperBound);
		}
		return result;
	}

	public TypeReference createTypeReference(String signature, IMember declarator, Member container) {
		TypeReference result = TypesFactory.eINSTANCE.createTypeReference();
		result.setType(createReferencedType(signature, declarator, container));
		return result;
	}

	private org.eclipse.xtext.common.types.Type createReferencedType(String signature, IMember declarator,
			Member container) {
		org.eclipse.xtext.common.types.Type result = createReferencedTypeForParameterizedOrReturnNull(signature,
				declarator, container);
		if (result == null)
			result = createProxy(signature, declarator);
		return result;
	}

	private org.eclipse.xtext.common.types.Type createReferencedTypeForParameterizedOrReturnNull(String signature,
			IMember declarator, Member container) {
		int arrayDim = Signature.getArrayCount(signature);
		if (arrayDim != 0) {
			String componentSignature = Signature.getElementType(signature);
			org.eclipse.xtext.common.types.Type result = createReferencedTypeForParameterizedOrReturnNull(
					componentSignature, declarator, container);
			if (result != null) {
				ComponentType resultComponentType = (ComponentType) result;
				for (int i = 0; i < arrayDim; i++) {
					if (resultComponentType.getArrayType() == null) {
						resultComponentType.setArrayType(TypesFactory.eINSTANCE.createArrayType());
					}
					resultComponentType = resultComponentType.getArrayType();
				}
				return resultComponentType;
			}
			else {
				return null;
			}
		}
		String[] typeArguments = Signature.getTypeArguments(signature);
		if (typeArguments.length != 0) {
			String name = uriHelper.computeParameterizedTypeName(signature);
			for (org.eclipse.xtext.common.types.ParameterizedType existingType : container
					.getDeclaredParameterizedTypes()) {
				if (name.equals(existingType.getCanonicalName())) {
					return existingType;
				}
			}
			String rawType = Signature.getTypeErasure(signature);
			ParameterizedType newParameterizedType = TypesFactory.eINSTANCE.createParameterizedType();
			newParameterizedType.setFullyQualifiedName(name);
			newParameterizedType.setRawType(createTypeReference(rawType, declarator, container));
			for (int i = 0; i < typeArguments.length; i++) {
				TypeParameter parameter = createTypeParameter(typeArguments[i], declarator, container, rawType, i);
				newParameterizedType.getParameters().add(parameter);
			}
			container.getDeclaredParameterizedTypes().add(newParameterizedType);
			return newParameterizedType;
		}
		else {
			return null;
		}
	}

	private TypeParameter createTypeParameter(String actualTypeSignature, IMember declarator, Member container,
			String rawTypeSignature, int i) {
		int signatureKind = Signature.getTypeSignatureKind(actualTypeSignature);
		if (signatureKind == Signature.WILDCARD_TYPE_SIGNATURE) {
			WildcardTypeParameter result = TypesFactory.eINSTANCE.createWildcardTypeParameter();
			Wildcard wildcard = TypesFactory.eINSTANCE.createWildcard();
			switch (actualTypeSignature.charAt(0)) {
				case '*': {
					UpperBound upperBound = TypesFactory.eINSTANCE.createUpperBound();
					TypeReference reference = createTypeReference(Signature.createTypeSignature(Object.class.getName(),
							true), declarator, container);
					upperBound.getReferencedTypes().add(reference);
					wildcard.getConstraints().add(upperBound);
				}
					break;
				case '+': {
					String upperBoundSignature = actualTypeSignature.substring(1);
					UpperBound upperBound = TypesFactory.eINSTANCE.createUpperBound();
					TypeReference reference = createTypeReference(upperBoundSignature, declarator, container);
					upperBound.getReferencedTypes().add(reference);
					wildcard.getConstraints().add(upperBound);
				}
					break;
				case '-': {
					String lowerBoundSignature = actualTypeSignature.substring(1);
					LowerBound lowerBound = TypesFactory.eINSTANCE.createLowerBound();
					TypeReference reference = createTypeReference(lowerBoundSignature, declarator, container);
					lowerBound.getReferencedTypes().add(reference);
					wildcard.getConstraints().add(lowerBound);
				}
					break;
				default:
					throw new IllegalArgumentException("Signature: " + actualTypeSignature);
			}
			result.setWildcard(wildcard);
			return result;
		}
		else {
			ReferenceTypeParameter result = TypesFactory.eINSTANCE.createReferenceTypeParameter();
			TypeReference typeReference = createTypeReference(actualTypeSignature, declarator, container);
			result.setReference(typeReference);
			return result;
		}
	}

	public org.eclipse.xtext.common.types.Type createProxy(String signature, IMember declarator) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createVoid();
		URI uri = uriHelper.getFullURI(signature, declarator);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.Type) proxy;
	}

	public AnnotationType createAnnotationType(IType jdtType) {
		throw new UnsupportedOperationException();
	}

	public EnumerationType createEnumerationType(IType jdtType) {
		throw new UnsupportedOperationException();
	}

	public Field createField(IField field) throws JavaModelException {
		Field result = TypesFactory.eINSTANCE.createField();
		result.setFullyQualifiedName(field.getDeclaringType().getFullyQualifiedName() + "." + field.getElementName());
		result.setFinal(Flags.isFinal(field.getFlags()));
		result.setStatic(Flags.isStatic(field.getFlags()));
		if (Flags.isPrivate(field.getFlags()))
			result.setVisibility("private");
		else if (Flags.isProtected(field.getFlags()))
			result.setVisibility("protected");
		else if (Flags.isPublic(field.getFlags()))
			result.setVisibility("public");
		result.setType(createTypeReference(field.getTypeSignature(), field, result));
		return result;
	}

	public Constructor createConstructor(IMethod method) throws JavaModelException {
		Constructor result = TypesFactory.eINSTANCE.createConstructor();
		enhanceGenericDeclaration(result, method.getTypeParameters());
		enhanceExecutable(result, method, method.getParameterNames(), method.getParameterTypes());
		for (String exceptionType : method.getExceptionTypes()) {
			result.getExceptions().add(createTypeReference(exceptionType, method, result));
		}
		return result;
	}

	public void enhanceExecutable(Executable result, IMember member, String[] parameterNames, String[] parameterTypes)
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
		if (Flags.isPrivate(member.getFlags()))
			result.setVisibility("private");
		else if (Flags.isProtected(member.getFlags()))
			result.setVisibility("protected");
		else if (Flags.isPublic(member.getFlags()))
			result.setVisibility("public");
		for (int i = 0; i < parameterNames.length; i++) {
			result.getParameters().add(createFormalParameter(parameterTypes[i], parameterNames[i], member, result));
		}
	}

	public void enhanceGenericDeclaration(Executable result, ITypeParameter[] parameters) throws JavaModelException {
		for (ITypeParameter parameter : parameters) {
			result.getTypeVariables().add(createTypeVariable(parameter, result));
		}
	}

	public Operation createOperation(IMethod method) throws JavaModelException {
		Operation result = TypesFactory.eINSTANCE.createOperation();
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

	public FormalParameter createFormalParameter(String parameterType, String paramName, IMember declarator,
			org.eclipse.xtext.common.types.Member container) {
		FormalParameter result = TypesFactory.eINSTANCE.createFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(parameterType, declarator, container));
		return result;
	}

}
