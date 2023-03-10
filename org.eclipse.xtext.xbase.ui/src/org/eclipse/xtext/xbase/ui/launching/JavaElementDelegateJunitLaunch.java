/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.launching;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.Modifier;

public class JavaElementDelegateJunitLaunch extends JavaElementDelegate {
	
	private final static Logger log = Logger.getLogger(JavaElementDelegateJunitLaunch.class);
	
	@Override
	protected boolean containsElementsSearchedFor(IFile file) {
		IJavaElement element = JavaCore.create(file);
		if (element == null || !element.exists() || ! (element instanceof ICompilationUnit)) {
			return false;
		}
		try {
			ICompilationUnit cu = (ICompilationUnit) element;
			
			IType[] allTypes = cu.getAllTypes();
			
			for (IType type : allTypes) {
				if(containsJUnitTestMethod(type)) {
					return true;
				}
			}
			
			for (IType type : allTypes) {
				for(IType superType : getAllSuperTypes(type)) {
					if(containsJUnitTestMethod(superType)) {
						return true;
					}
				}
			}
			
		} catch (JavaModelException e) {
			log.error(e.getMessage() ,e);
		}
		return super.containsElementsSearchedFor(file);
	}
	
	protected boolean containsJUnitTestMethod(IType type) throws JavaModelException {
		for (IMethod method : type.getMethods()) {
			int flags = method.getFlags();
			if (Modifier.isPublic(flags) && !Modifier.isStatic(flags) &&
					method.getNumberOfParameters() == 0 && Signature.SIG_VOID.equals(method.getReturnType()) &&
					method.getElementName().startsWith("test")) { //$NON-NLS-1$
				return true;
			}
			IAnnotation annotation= method.getAnnotation("Test"); //$NON-NLS-1$
			if (annotation.exists())
				return true;
		}
		return false;
	}
	
	protected IType[] getAllSuperTypes(IType type) throws JavaModelException {
		/*
		 * https://stackoverflow.com/questions/49611587/developing-a-eclipse-how-to-get-all-inherited-methods-from-a-icompilationunit
		 */
		ITypeHierarchy th = type.newTypeHierarchy(new NullProgressMonitor());
		IType[] superTypes = th.getAllSuperclasses(type);
		return superTypes;
	}
}