/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.Signature;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeURIHelper {

	public static final String PRIMITIVES = "/Primitives";
	public static final String OBJECTS = "/Objects/";
	public static final String PROTOCOL = "java";

	public String getFragment(String signature) {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(signature, null, uriBuilder);
		return uriBuilder.toString();
	}

	public URI createResourceURI(String signature) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, null, uriBuilder);
		return createURI(uriBuilder);
	}

	public URI createResourceURIFromString(String withoutProtocol) {
		StringBuilder uriBuilder = new StringBuilder(TypeURIHelper.PROTOCOL.length() + 1 + withoutProtocol.length());
		uriBuilder.append(TypeURIHelper.PROTOCOL).append(":").append(withoutProtocol);
		return createURI(uriBuilder);
	}

	private StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(TypeURIHelper.PROTOCOL);
		builder.append(':');
		return builder;
	}

	private URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(String signature, IMember declarator) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, declarator, uriBuilder);
		uriBuilder.append('#');
		createFragment(signature, declarator, uriBuilder);
		return createURI(uriBuilder);
	}

	private void createFragment(String signature, IMember declarator, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.BASE_TYPE_SIGNATURE:
				createFragmentForPrimitive(signature, uriBuilder);
				return;
			case Signature.CLASS_TYPE_SIGNATURE:
				createFragmentForClass(signature, uriBuilder);
				return;
			case Signature.ARRAY_TYPE_SIGNATURE:
				createFragmentForArray(signature, declarator, uriBuilder);
				return;
			case Signature.TYPE_VARIABLE_SIGNATURE:
				createFragmentForTypeVariable(signature, declarator, uriBuilder);
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}

	private void createFragmentForTypeVariable(String signature, IMember declarator, StringBuilder uriBuilder) {
		if (declarator instanceof IType) {
			IType declaringType = (IType) declarator;
			String typeSignature = Signature.createTypeSignature(declaringType.getFullyQualifiedName(), true);
			createFragment(typeSignature, declarator, uriBuilder);
		}
		else if (declarator instanceof IMethod) {
			IMethod member = (IMethod) declarator;
			createFragmentForMethod(member, uriBuilder);
		}
		else {
			throw new IllegalArgumentException(signature + " / " + declarator.getElementName());
		}
		uriBuilder.append('/');
		uriBuilder.append(Signature.toString(signature));
	}

	private void createFragmentForMethod(IMethod method, StringBuilder uriBuilder) {
		IType declaringType = method.getDeclaringType();
		createFragmentForClass(Signature.createTypeSignature(declaringType.getFullyQualifiedName(), true), uriBuilder);
		uriBuilder.append('.');
		uriBuilder.append(method.getElementName());
		uriBuilder.append('(');
		String[] parameterTypes = null;
		parameterTypes = method.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0) {
				uriBuilder.append(',');
			}
			computeTypeName(parameterTypes[i], uriBuilder);
		}
		uriBuilder.append(')');
	}

	public String computeTypeName(String signature) {
		StringBuilder result = new StringBuilder(64);
		computeTypeName(signature, result);
		return result.toString();
	}

	public void computeTypeName(String signature, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.CLASS_TYPE_SIGNATURE:
			case Signature.BASE_TYPE_SIGNATURE:
			case Signature.ARRAY_TYPE_SIGNATURE:
			case Signature.TYPE_VARIABLE_SIGNATURE:
				String erased = Signature.getTypeErasure(signature);
				uriBuilder.append(Signature.toString(erased));
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}

	public String computeParameterizedTypeName(String signature) {
		StringBuilder result = new StringBuilder(64);
		computeParameterizedTypeName(signature, result);
		return result.toString();
	}

	public void computeParameterizedTypeName(String signature, StringBuilder uriBuilder) {
		computeTypeName(signature, uriBuilder);
		String[] typeArguments = Signature.getTypeArguments(signature);
		if (typeArguments.length != 0) {
			uriBuilder.append('<');
			for (int i = 0; i < typeArguments.length; i++) {
				if (i != 0)
					uriBuilder.append(',');
				computeParameter(typeArguments[i], uriBuilder);
			}
			uriBuilder.append('>');
		}
	}

	public void computeParameter(String signature, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		if (signatureKind == Signature.WILDCARD_TYPE_SIGNATURE) {
			switch (signature.charAt(0)) {
				case '*': {
					uriBuilder.append("? extends java.lang.Object");
				}
					break;
				case '+': {
					uriBuilder.append("? extends ");
					String upperBoundSignature = signature.substring(1);
					computeParameterizedTypeName(upperBoundSignature, uriBuilder);
				}
					break;
				case '-': {
					uriBuilder.append("? super ");
					String lowerBoundSignature = signature.substring(1);
					computeParameterizedTypeName(lowerBoundSignature, uriBuilder);
				}
					break;
				default:
					throw new IllegalArgumentException("Signature: " + signature);
			}
		}
		else {
			computeParameterizedTypeName(signature, uriBuilder);
		}
	}

	private void createFragmentForPrimitive(String signature, StringBuilder uriBuilder) {
		uriBuilder.append(Signature.toString(signature));
	}

	private void createFragmentForArray(String signature, IMember declarator, StringBuilder uriBuilder) {
		String elementType = Signature.getElementType(signature);
		createFragment(elementType, declarator, uriBuilder);
		int dim = Signature.getArrayCount(signature);
		for (int i = 0; i < dim; i++) {
			uriBuilder.append("[]");
		}
	}

	private void createFragmentForClass(String signature, StringBuilder uriBuilder) {
		String fragment = Signature.toString(signature);
		int start = signature.length();
		int lastDot = fragment.length();
		while ((start = signature.lastIndexOf('$', start)) >= 0) {
			lastDot = fragment.lastIndexOf('.', lastDot);
			fragment = fragment.substring(0, lastDot) + '$' + fragment.substring(lastDot + 1);
			start--;
		}
		uriBuilder.append(fragment);
	}

	private void createResourceURI(String signature, IMember declarator, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.BASE_TYPE_SIGNATURE:
				createResourceURIForPrimitive(signature, uriBuilder);
				return;
			case Signature.CLASS_TYPE_SIGNATURE:
				createResourceURIForClass(signature, uriBuilder);
				return;
			case Signature.ARRAY_TYPE_SIGNATURE:
				createResourceURIForArray(signature, declarator, uriBuilder);
				return;
			case Signature.TYPE_VARIABLE_SIGNATURE:
				createResourceURIForTypeVariable(signature, declarator, uriBuilder);
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}

	private void createResourceURIForPrimitive(String signature, StringBuilder uriBuilder) {
		uriBuilder.append(TypeURIHelper.PRIMITIVES);
	}

	private void createResourceURIForArray(String signature, IMember declarator, StringBuilder uriBuilder) {
		String elementType = Signature.getElementType(signature);
		createResourceURI(elementType, declarator, uriBuilder);
	}

	private void createResourceURIForClass(String signature, StringBuilder uriBuilder) {
		String topLevel = signature;
		int idx = topLevel.indexOf('$');
		if (idx != -1)
			topLevel = topLevel.substring(0, idx) + ';';
		uriBuilder.append(TypeURIHelper.OBJECTS).append(Signature.toString(topLevel));
	}

	private void createResourceURIForTypeVariable(String signature, IMember declarator, StringBuilder uriBuilder) {
		if (declarator instanceof IType) {
			IType declaringClass = (IType) declarator;
			createResourceURIForClass(Signature.createTypeSignature(declaringClass.getFullyQualifiedName(), true),
					uriBuilder);
		}
		else if (declarator instanceof IMethod) {
			IMethod member = (IMethod) declarator;
			IType declaringClass = member.getDeclaringType();
			createResourceURIForClass(Signature.createTypeSignature(declaringClass.getFullyQualifiedName(), true),
					uriBuilder);
		}
		else {
			throw new IllegalArgumentException(signature + " / " + declarator.getElementName());
		}
	}

}
