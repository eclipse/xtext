/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

/**
 * Creates a {@link JdtRefactoringContext} if a reference to a JVM element is the target to be refactored.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmRenameElementHandler extends DefaultRenameElementHandler {

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Override
	public IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if (isPlainJavaMember(targetElement)) {
			IJavaElement javaElement;
			if(targetElement instanceof JvmConstructor)
				javaElement = getJavaElementFinder().findExactElementFor(((JvmConstructor) targetElement).getDeclaringType());
			else 
				javaElement = getJavaElementFinder().findExactElementFor((JvmMember) targetElement);
			if (javaElement != null)
				return new JdtRefactoringContext(targetElement, javaElement, editor,
						selection, resource, true);
		}
		return super.createRenameElementContext(targetElement, editor, selection, resource);
	}

	/** 
	 * @return true, iff the targetElement belongs to an IMember in a Java resource. 
	 */
	protected boolean isPlainJavaMember(EObject targetElement) {
		return targetElement.eClass() != null && targetElement.eClass().getEPackage() == TypesPackage.eINSTANCE
				&& targetElement instanceof JvmMember && equal("java", targetElement.eResource().getURI().scheme());
	}
	
	protected IJavaElementFinder getJavaElementFinder() {
		return javaElementFinder;
	}

}
