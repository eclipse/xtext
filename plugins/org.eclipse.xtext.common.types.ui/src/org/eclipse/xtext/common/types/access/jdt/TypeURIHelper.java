/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeURIHelper implements URIHelperConstants {

	public String getFragment(String signature) {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(signature, uriBuilder);
		return uriBuilder.toString();
	}

	public URI createResourceURI(String signature) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, uriBuilder);
		return createURI(uriBuilder);
	}

	public URI createResourceURIFromString(String withoutProtocol) {
		StringBuilder uriBuilder = new StringBuilder(URIHelperConstants.PROTOCOL.length() + 1 + withoutProtocol.length());
		uriBuilder.append(URIHelperConstants.PROTOCOL).append(":").append(withoutProtocol);
		return createURI(uriBuilder);
	}

	public StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(URIHelperConstants.PROTOCOL);
		builder.append(':');
		return builder;
	}

	protected URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(ITypeBinding typeBinding) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(typeBinding, uriBuilder);
		uriBuilder.append('#');
		createFragment(typeBinding, uriBuilder);
		return createURI(uriBuilder);
	}
	
	public URI getFullURIForClass(String fqn) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURIForClassImpl2(fqn, uriBuilder);
		uriBuilder.append('#');
		createFragmentForClass2(fqn, uriBuilder);
		return createURI(uriBuilder);
	}
	
	public URI getFullURI(ITypeBinding typeBinding, String method) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(typeBinding, uriBuilder);
		uriBuilder.append('#');
		createFragment(typeBinding, uriBuilder);
		uriBuilder.append('.').append(method).append("()");
		return createURI(uriBuilder);
	}
	
	protected void createFragment(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.isPrimitive()) {
			createFragmentForPrimitive(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isArray()) {
			createFragmentForArray(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isTypeVariable()) {
			createFragmentForTypeVariable(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isAnnotation() || typeBinding.isClass() || typeBinding.isInterface() || typeBinding.isEnum()) {
			createFragmentForClass(typeBinding, uriBuilder);
			return;
		}
		throw new IllegalStateException("Unexpected type binding: " + typeBinding);
	}

	protected void createFragment(String signature, StringBuilder uriBuilder) {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.BASE_TYPE_SIGNATURE:
				createFragmentForPrimitive(signature, uriBuilder);
				return;
			case Signature.CLASS_TYPE_SIGNATURE:
				createFragmentForClass(signature, uriBuilder);
				return;
			case Signature.ARRAY_TYPE_SIGNATURE:
				createFragmentForArray(signature, uriBuilder);
				return;
			case Signature.TYPE_VARIABLE_SIGNATURE:
				createFragmentForTypeVariable(signature, uriBuilder);
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}
	
	protected void createFragmentForTypeVariable(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.getDeclaringMethod() != null) {
			createFragmentForMethod(typeBinding.getDeclaringMethod(), uriBuilder);
		} else {
			createFragment(typeBinding.getDeclaringClass(), uriBuilder);
		}
		uriBuilder.append('/');
		uriBuilder.append(typeBinding.getName());
	}

	protected void createFragmentForTypeVariable(String signature, StringBuilder uriBuilder) {
		String readable = Signature.toString(signature);
		uriBuilder.append('/');
		uriBuilder.append(readable);
	}

	protected void createFragmentForMethod(IMethodBinding method, StringBuilder uriBuilder) {
		ITypeBinding declaringType = method.getDeclaringClass();
		createFragmentForClass(declaringType, uriBuilder);
		uriBuilder.append('.');
		uriBuilder.append(method.getName());
		uriBuilder.append('(');
		ITypeBinding[] parameterTypes = method.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			if (i != 0) {
				uriBuilder.append(',');
			}
			uriBuilder.append(getQualifiedName(parameterTypes[i]));
		}
		uriBuilder.append(')');
	}
	
	public String getQualifiedName(ITypeBinding binding) {
		if (binding.isParameterizedType()) {
			return getQualifiedName(binding.getErasure());
		}
		if (binding.isArray()) {
			return getQualifiedName(binding.getComponentType()) + "[]";
		}
		if (binding.isTopLevel() || binding.isTypeVariable() || binding.isPrimitive())
			return binding.getQualifiedName();
		return getQualifiedName(binding.getDeclaringClass()) + "$" + binding.getName();
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
				String erased = getTypeErasure(signature);
				uriBuilder.append(Signature.toString(erased));
				return;
			default:
				throw new IllegalStateException("Unexpected Signature: " + signature);
		}
	}

	public String getTypeErasure(String signature) {
		String fixedSignature = signature.replaceAll(">\\.", ">\\$");
		return Signature.getTypeErasure(fixedSignature);
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
					uriBuilder.append("? extends java.lang.Object & super ");
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

	protected void createFragmentForPrimitive(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		uriBuilder.append(typeBinding.getName());
	}
	
	protected void createFragmentForPrimitive(String signature, StringBuilder uriBuilder) {
		uriBuilder.append(Signature.toString(signature));
	}

	protected void createFragmentForArray(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		createFragment(typeBinding.getComponentType(), uriBuilder);
		uriBuilder.append("[]");
	}
	
	protected void createFragmentForArray(String signature, StringBuilder uriBuilder) {
		String elementType = Signature.getElementType(signature);
		createFragment(elementType, uriBuilder);
		int dim = Signature.getArrayCount(signature);
		for (int i = 0; i < dim; i++) {
			uriBuilder.append("[]");
		}
	}

	protected void createFragmentForClass(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		createFragmentForClass2(getQualifiedName(typeBinding), uriBuilder);
	}
	
	protected void createFragmentForClass2(String fqn, StringBuilder uriBuilder) {
		uriBuilder.append(fqn);
	}
	
	protected void createFragmentForClass(String signature, StringBuilder uriBuilder) {
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

	protected void createResourceURI(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.isPrimitive()) {
			createResourceURIForPrimitive(uriBuilder);
			return;
		}
		if (typeBinding.isArray()) {
			createResourceURIForArray(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isTypeVariable()) {
			createResourceURIForTypeVariable(typeBinding, uriBuilder);
			return;
		}
		if (typeBinding.isClass() || typeBinding.isInterface() || typeBinding.isAnnotation() || typeBinding.isEnum()) {
			createResourceURIForClass(typeBinding, uriBuilder);
			return;
		}
		throw new IllegalStateException("Unexpected type: " + typeBinding);
	}
	
	protected void createResourceURI(String signature, StringBuilder uriBuilder) {
		try {
			int signatureKind = Signature.getTypeSignatureKind(signature);
			switch (signatureKind) {
				case Signature.BASE_TYPE_SIGNATURE:
					createResourceURIForPrimitive(uriBuilder);
					return;
				case Signature.CLASS_TYPE_SIGNATURE:
					createResourceURIForClass(signature, uriBuilder);
					return;
				case Signature.ARRAY_TYPE_SIGNATURE:
					createResourceURIForArray(signature, uriBuilder);
					return;
				default:
					throw new IllegalStateException("Unexpected Signature: " + signature);
			}
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage() + " was: " + signature, e);
		}
	}

	protected void createResourceURIForPrimitive(StringBuilder uriBuilder) {
		uriBuilder.append(URIHelperConstants.PRIMITIVES);
	}

	protected void createResourceURIForArray(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		ITypeBinding componentType = typeBinding.getComponentType();
		createResourceURI(componentType, uriBuilder);
	}
	
	protected void createResourceURIForArray(String signature, StringBuilder uriBuilder) {
		String elementType = Signature.getElementType(signature);
		createResourceURI(elementType, uriBuilder);
	}

	protected void createResourceURIForClass(ITypeBinding typeBinding, StringBuilder uriBuilder) { 
		if (typeBinding.getDeclaringClass() != null) {
			createResourceURIForClass(typeBinding.getDeclaringClass(), uriBuilder);
		} else {
			createResourceURIForClassImpl2(typeBinding.getQualifiedName(), uriBuilder);
		}
	}
	
	protected void createResourceURIForClass(String signature, StringBuilder uriBuilder) {
		createResourceURIForClassImpl(signature, uriBuilder);
	}

	protected void createResourceURIForClassImpl2(String fqn, StringBuilder uriBuilder) {
		uriBuilder.append(URIHelperConstants.OBJECTS).append(fqn);
	}
	
	protected void createResourceURIForClassImpl(String signature, StringBuilder uriBuilder) {
		String topLevel = signature;
		int idx = topLevel.indexOf('$');
		if (idx != -1)
			topLevel = topLevel.substring(0, idx) + ';';
		uriBuilder.append(URIHelperConstants.OBJECTS).append(Signature.toString(topLevel));
	}
	
	protected void createResourceURIForTypeVariable(ITypeBinding typeBinding, StringBuilder uriBuilder) {
		if (typeBinding.getDeclaringClass() != null) {
			ITypeBinding declaringClass = typeBinding.getDeclaringClass();
			createResourceURIForClass(declaringClass, uriBuilder);
		}
		else {
			IMethodBinding declaringMethod = typeBinding.getDeclaringMethod();
			ITypeBinding declaringClass = declaringMethod.getDeclaringClass();
			createResourceURIForClass(declaringClass, uriBuilder);
		}
	}

}
