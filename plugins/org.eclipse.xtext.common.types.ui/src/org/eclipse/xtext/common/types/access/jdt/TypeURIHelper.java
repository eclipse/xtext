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
import org.eclipse.jdt.core.ITypeParameter;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeURIHelper {

	public static final String PRIMITIVES = "/Primitives";
	public static final String OBJECTS = "/Objects/";
	public static final String PROTOCOL = "java";

	public String getFragment(String signature) throws JavaModelException {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(signature, null, uriBuilder);
		return uriBuilder.toString();
	}

	public URI createResourceURI(String signature) throws JavaModelException {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, null, uriBuilder);
		return createURI(uriBuilder);
	}

	public URI createResourceURIFromString(String withoutProtocol) {
		StringBuilder uriBuilder = new StringBuilder(TypeURIHelper.PROTOCOL.length() + 1 + withoutProtocol.length());
		uriBuilder.append(TypeURIHelper.PROTOCOL).append(":").append(withoutProtocol);
		return createURI(uriBuilder);
	}

	public StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(TypeURIHelper.PROTOCOL);
		builder.append(':');
		return builder;
	}

	protected URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(String signature, IMember declarator) throws JavaModelException {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, declarator, uriBuilder);
		uriBuilder.append('#');
		createFragment(signature, declarator, uriBuilder);
		return createURI(uriBuilder);
	}

	protected void createFragment(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.BASE_TYPE_SIGNATURE:
				createFragmentForPrimitive(signature, uriBuilder);
				return;
			case Signature.CLASS_TYPE_SIGNATURE:
				createFragmentForClass(signature, declarator, uriBuilder);
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

	protected void createFragmentForTypeVariable(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		String readable = Signature.toString(signature);
		IMember localDeclarator = declarator;
		while(localDeclarator != null) {
			if (localDeclarator instanceof IType) {
				IType declaringType = (IType) localDeclarator;
				ITypeParameter typeParameter = findTypeParameterByName(readable, declaringType.getTypeParameters());
				if (typeParameter != null) {
					String typeSignature = Signature.createTypeSignature(declaringType.getFullyQualifiedName(), true);
					createFragment(typeSignature, declarator, uriBuilder);
					break;
				}
			}
			else if (localDeclarator instanceof IMethod) {
				IMethod method = (IMethod) localDeclarator;
				ITypeParameter typeParameter = findTypeParameterByName(readable, method.getTypeParameters());
				if (typeParameter != null) {
					createFragmentForMethod(method, uriBuilder);
					break;
				}
			}
			localDeclarator = localDeclarator.getDeclaringType();
		}
		uriBuilder.append('/');
		uriBuilder.append(readable);
	}

	protected ITypeParameter findTypeParameterByName(String readable, ITypeParameter[] typeParameters) {
		if (typeParameters != null) {
			for(ITypeParameter parameter: typeParameters) {
				if (readable.equals(parameter.getElementName())) {
					return parameter;
				}
			}
		}
		return null;
	}

	protected void createFragmentForMethod(IMethod method, StringBuilder uriBuilder) throws JavaModelException {
		IType declaringType = method.getDeclaringType();
		createFragmentForClass(Signature.createTypeSignature(declaringType.getFullyQualifiedName(), true), null, uriBuilder);
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

	protected void createFragmentForPrimitive(String signature, StringBuilder uriBuilder) {
		uriBuilder.append(Signature.toString(signature));
	}

	protected void createFragmentForArray(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		String elementType = Signature.getElementType(signature);
		createFragment(elementType, declarator, uriBuilder);
		int dim = Signature.getArrayCount(signature);
		for (int i = 0; i < dim; i++) {
			uriBuilder.append("[]");
		}
	}

	protected void createFragmentForClass(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		signature = resolveSourceReference(signature, declarator);
		if (declarator != null && signature.indexOf('.') == -1) {
			String readable = Signature.toString(signature);
			IMember localDeclarator = declarator;
			while(localDeclarator != null) {
				ITypeParameter[] typeParameters = null;
				if (localDeclarator instanceof IMethod) {
					IMethod method = (IMethod) localDeclarator;
					typeParameters = method.getTypeParameters();
				} else if (localDeclarator instanceof IType) {
					IType type = (IType) localDeclarator;
					typeParameters = type.getTypeParameters();
				}
				if (typeParameters != null && typeParameters.length != 0) {
					for(ITypeParameter typeParameter: typeParameters) {
						if (readable.equals(typeParameter.getElementName())) {
							createFragment("T" + readable + ";", localDeclarator, uriBuilder);
							return;
						}
					}
				}
				localDeclarator = localDeclarator.getDeclaringType();
			}
		}
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

	protected void createResourceURI(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		int signatureKind = Signature.getTypeSignatureKind(signature);
		switch (signatureKind) {
			case Signature.BASE_TYPE_SIGNATURE:
				createResourceURIForPrimitive(signature, uriBuilder);
				return;
			case Signature.CLASS_TYPE_SIGNATURE:
				createResourceURIForClass(signature, declarator, uriBuilder);
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

	protected void createResourceURIForPrimitive(String signature, StringBuilder uriBuilder) {
		uriBuilder.append(TypeURIHelper.PRIMITIVES);
	}

	protected void createResourceURIForArray(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		String elementType = Signature.getElementType(signature);
		createResourceURI(elementType, declarator, uriBuilder);
	}

	protected void createResourceURIForClass(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		signature = resolveSourceReference(signature, declarator);
		if (declarator != null && signature.indexOf('.') == -1) {
			String readable = Signature.toString(signature);
			IMember localDeclarator = declarator;
			while(localDeclarator != null) {
				ITypeParameter[] typeParameters = null;
				if (localDeclarator instanceof IMethod) {
					IMethod method = (IMethod) localDeclarator;
					typeParameters = method.getTypeParameters();
				} else if (localDeclarator instanceof IType) {
					IType type = (IType) localDeclarator;
					typeParameters = type.getTypeParameters();
				}
				if (typeParameters != null && typeParameters.length != 0) {
					for(ITypeParameter typeParameter: typeParameters) {
						if (readable.equals(typeParameter.getElementName())) {
							IType type = null;
							if (localDeclarator instanceof IType) {
								type = (IType) localDeclarator;
							} else {
								type = localDeclarator.getDeclaringType();
							}
							String typeSignature = Signature.createTypeSignature(type.getFullyQualifiedName(), true);
							createResourceURIForClassImpl(typeSignature, uriBuilder);
							return;
						}
					}
				}
				localDeclarator = localDeclarator.getDeclaringType();
			}
		} else {
			createResourceURIForClassImpl(signature, uriBuilder);
		}
	}

	protected String resolveSourceReference(String signature, IMember declarator) throws JavaModelException {
		if (signature.startsWith("Q")) {
			String readable = Signature.toString(signature);
			IType resolveContext = declarator.getDeclaringType();
			if (declarator instanceof IType) {
				resolveContext = (IType) declarator;
			}
			String[][] resolved = resolveContext.resolveType(readable);
			if (resolved != null && resolved.length == 1) {
				readable = resolved[0][0];
				if (readable != null && readable.length() >= 1) {
					readable = readable + '.' + resolved[0][1];
				} else {
					readable = resolved[0][1];
				}
				signature = Signature.createTypeSignature(readable, true);
			}
		}
		return signature;
	}

	protected void createResourceURIForClassImpl(String signature, StringBuilder uriBuilder) {
		String topLevel = signature;
		int idx = topLevel.indexOf('$');
		if (idx != -1)
			topLevel = topLevel.substring(0, idx) + ';';
		uriBuilder.append(TypeURIHelper.OBJECTS).append(Signature.toString(topLevel));
	}

	protected void createResourceURIForTypeVariable(String signature, IMember declarator, StringBuilder uriBuilder) throws JavaModelException {
		if (declarator instanceof IType) {
			IType declaringClass = (IType) declarator;
			createResourceURIForClass(Signature.createTypeSignature(declaringClass.getFullyQualifiedName(), true),
					declarator, uriBuilder);
		}
		else {
			IType declaringClass = declarator.getDeclaringType();
			createResourceURIForClass(Signature.createTypeSignature(declaringClass.getFullyQualifiedName(), true),
					declarator, uriBuilder);
		}
	}

}
