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
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.Constructor;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.Field;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.IdentifyableElement;
import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.TypesSwitch;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementFinder implements IJavaElementFinder {

	@Inject
	private IJavaProjectProvider projectProvider;
	
	public IJavaElement findElementFor(IdentifyableElement element) {
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
		public IJavaElement casePrimitiveType(PrimitiveType object) {
			return null;
		}
		
		@Override
		public IJavaElement caseArrayType(ArrayType object) {
			return doSwitch(object.getComponentType());
		}
		
		@Override
		public IJavaElement caseMember(Member object) {
			IJavaElement typeElement = doSwitch(object.getDeclaringType());
			return typeElement;
		}
		
		@Override
		public IJavaElement caseField(Field object) {
			IJavaElement parent = caseMember(object);
			if (parent instanceof IType) {
				IType type = (IType) parent;
				IField result = type.getField(object.getSimpleName());
				if (result != null)
					return result;
			}
			return parent;
		}
		
		@Override
		public IJavaElement caseOperation(Operation object) {
			IJavaElement parent = caseMember(object);
			if (parent instanceof IType) {
				IType type = (IType) parent;
				try {
					for(IMethod method: type.getMethods()) {
						if (!method.isConstructor()) {
							if (object.getSimpleName().equals(method.getElementName()) && object.getParameters().size() == method.getNumberOfParameters()) {
								int numberOfParameters = method.getNumberOfParameters();
								String[] parameterTypes = method.getParameterTypes();
								boolean match = true;
								for (int i = 0; i < numberOfParameters && match; i++) {
									FormalParameter formalParameter = object.getParameters().get(i);
									String parameterType = parameterTypes[i];
									String readable = Signature.toString(parameterType);
									if (!readable.equals(formalParameter.getParameterType().getCanonicalName()))
										match = false;
								}
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
		
		@Override
		public IJavaElement caseConstructor(Constructor object) {
			IJavaElement parent = caseMember(object);
			if (parent instanceof IType) {
				IType type = (IType) parent;
				try {
					for(IMethod method: type.getMethods()) {
						if (method.isConstructor()) {
							int numberOfParameters = method.getNumberOfParameters();
							String[] parameterTypes = method.getParameterTypes();
							boolean match = true;
							for (int i = 0; i < numberOfParameters && match; i++) {
								FormalParameter formalParameter = object.getParameters().get(i);
								String parameterType = parameterTypes[i];
								String readable = Signature.toString(parameterType);
								if (!readable.equals(formalParameter.getParameterType().getCanonicalName()))
									match = false;
							}
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
		public IJavaElement caseDeclaredType(DeclaredType object) {
			try {
				String fullyQualifiedName = object.getFullyQualifiedName();
				IType result = javaProject.findType(fullyQualifiedName);
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
