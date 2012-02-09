/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util.jdt;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.TypesSwitch;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementFinder implements IJavaElementFinder {

	@Inject
	private IJavaProjectProvider projectProvider;
	
	public IJavaElement findElementFor(JvmIdentifiableElement element) {
		if (element == null || element.eResource() == null)
			return null;
		Implementation implementation = new Implementation(projectProvider.getJavaProject(element.eResource().getResourceSet()));
		IJavaElement result = implementation.doSwitch(element);
		return result;
	}
	
	public void setProjectProvider(IJavaProjectProvider projectProvider) {
		this.projectProvider = projectProvider;
	}

	public IJavaProjectProvider getProjectProvider() {
		return projectProvider;
	}

	public static class Implementation extends TypesSwitch<IJavaElement> {
		private final IJavaProject javaProject;

		public Implementation(IJavaProject javaProject) {
			this.javaProject = javaProject;
		}

		@Override
		public IJavaElement caseJvmPrimitiveType(JvmPrimitiveType object) {
			return null;
		}
		
		@Override
		public IJavaElement caseJvmArrayType(JvmArrayType object) {
			return doSwitch(object.getComponentType());
		}
		
		@Override
		public IJavaElement caseJvmMember(JvmMember object) {
			if (object.getDeclaringType() != null) {
				IJavaElement typeElement = doSwitch(object.getDeclaringType());
				return typeElement;
			} 
			return null;
		}
		
		@Override
		public IJavaElement caseJvmField(JvmField object) {
			IJavaElement parent = caseJvmMember(object);
			if (parent instanceof IType) {
				IType type = (IType) parent;
				IField result = type.getField(object.getSimpleName());
				if (result != null)
					return result;
			}
			return parent;
		}
		
		@Override
		public IJavaElement caseJvmOperation(JvmOperation object) {
			IJavaElement parent = caseJvmMember(object);
			if (parent instanceof IType) {
				IType type = (IType) parent;
				try {
					for(IMethod method: type.getMethods()) {
						if (!method.isConstructor()) {
							if (object.getSimpleName().equals(method.getElementName()) && object.getParameters().size() == method.getNumberOfParameters()) {
								boolean match = doParametersMatch(object, method, type);
								if (match)
									return method;
							}
						}
					}
				}
				catch (JavaModelException e) {
					return parent;
				}
			}
			return parent;
		}

		private boolean doParametersMatch(JvmExecutable object, IMethod method, IType declaringType)
				throws JavaModelException {
			int numberOfParameters = method.getNumberOfParameters();
			String[] parameterTypes = method.getParameterTypes();
			boolean match = true;
			for (int i = 0; i < numberOfParameters && match; i++) {
				JvmFormalParameter formalParameter = object.getParameters().get(i);
				String parameterType = parameterTypes[i];
				String readable = toQualifiedRawTypeName(parameterType, declaringType);
				String qualifiedParameterType = formalParameter.getParameterType().getType().getQualifiedName('.');
				if (!readable.equals(qualifiedParameterType))
					match = false;
			}
			return match;
		}
		
		private String toQualifiedRawTypeName(String parameterType, IType context) throws JavaModelException {
			StringBuilder resultBuilder = new StringBuilder();
			toQualifiedTypeName(Signature.getTypeErasure(parameterType), context, resultBuilder);
			String result = resultBuilder.toString();
			return result;
		}
		
		private void toQualifiedTypeName(String signature, IType context, StringBuilder result) throws JavaModelException {
			switch(Signature.getTypeSignatureKind(signature)) {
				case Signature.ARRAY_TYPE_SIGNATURE:
					toQualifiedTypeName(Signature.getElementType(signature), context, result);
					for(int i = 0; i < Signature.getArrayCount(signature); i++) {
						result.append("[]");
					}
					return;
				case Signature.CLASS_TYPE_SIGNATURE:
					if (signature.charAt(0) == Signature.C_UNRESOLVED) {
						String[][] resolved = context.resolveType(Signature.toString(signature));
						if (resolved != null && resolved.length == 1) {
							if (resolved[0][0] != null)
								result.append(resolved[0][0]);
							if (result.length() > 0)
								result.append('.');
							result.append(resolved[0][1]);
						} else {
							result.append(Signature.toString(signature));
						}
					} else {
						result.append(Signature.toString(signature));
					}
					return;
				default:
					result.append(Signature.toString(signature));
			}
		}
		
		@Override
		public IJavaElement caseJvmConstructor(JvmConstructor object) {
			IJavaElement parent = caseJvmMember(object);
			if (parent instanceof IType) {
				IType type = (IType) parent;
				try {
					for(IMethod method: type.getMethods()) {
						if (method.isConstructor() && object.getParameters().size() == method.getNumberOfParameters()) {
							boolean match = doParametersMatch(object, method, type);
							if (match)
								return method;
						}
					}
				}
				catch (JavaModelException e) {
					return parent;
				}
			}
			return parent;
		}
		
		@Override
		public IJavaElement caseJvmDeclaredType(JvmDeclaredType object) {
			try {
				String canonicalName = object.getQualifiedName('.');
				IType result = javaProject.findType(canonicalName);
				return result;
			}
			catch (JavaModelException e) {
				return null;
			}
		}
		
		@Override
		public IJavaElement doSwitch(EObject theEObject) {
			if (javaProject == null)
				return null;
			return super.doSwitch(theEObject);
		}
	}

}
