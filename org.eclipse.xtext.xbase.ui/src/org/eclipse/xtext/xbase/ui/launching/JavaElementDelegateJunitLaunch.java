/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.launching;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
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
			for (IType type : cu.getAllTypes()) {
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
			}
		} catch (JavaModelException e) {
			log.error(e.getMessage() ,e);
		}
		return super.containsElementsSearchedFor(file);
	}
}