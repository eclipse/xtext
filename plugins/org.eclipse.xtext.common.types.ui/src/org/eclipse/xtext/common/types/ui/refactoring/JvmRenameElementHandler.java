/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import static java.util.Collections.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler;

import com.google.inject.Inject;

/**
 * Creates a {@link DelegateToJavaRefactoringContext} if a reference to a JVM element is being refactored.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmRenameElementHandler extends DefaultRenameElementHandler {

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Override
	public IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if (isRealJvmMember(targetElement)) {
			IJavaElement javaElement = getJavaElementFinder().findElementFor((JvmMember) targetElement);
			if (javaElement != null)
				return new DelegateToJavaRefactoringContext(targetElement, singletonList(javaElement), editor,
						selection, resource, true);
		}
		return super.createRenameElementContext(targetElement, editor, selection, resource);
	}

	protected boolean isRealJvmMember(EObject targetElement) {
		return targetElement.eClass() != null && targetElement.eClass().getEPackage() == TypesPackage.eINSTANCE
				&& targetElement instanceof JvmMember;
	}
	
	protected IJavaElementFinder getJavaElementFinder() {
		return javaElementFinder;
	}

}
