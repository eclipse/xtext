/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

/**
 * Creates a {@link JdtRefactoringContext} if a reference to a JVM element is the target to be refactored.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JdtRefactoringContextFactory extends IRenameContextFactory.Default {

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Override
	public IRenameElementContext createExternalRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if (isJvmMember(targetElement) && isTypeResource(targetElement)) {
			IJavaElement javaElement;
			if(targetElement instanceof JvmConstructor)
				javaElement = getJavaElementFinder().findExactElementFor(((JvmConstructor) targetElement).getDeclaringType());
			else 
				javaElement = getJavaElementFinder().findExactElementFor((JvmMember) targetElement);
			if (javaElement != null)
				return new JdtRefactoringContext(targetElement, javaElement, editor,
						selection, resource, true);
		}
		return super.createExternalRenameElementContext(targetElement, editor, selection, resource);
	}

	/** 
	 * @return true, iff the targetElement is a JvmMember.
	 */
	protected boolean isJvmMember(EObject targetElement) {
		return targetElement.eClass() != null && targetElement.eClass().getEPackage() == TypesPackage.eINSTANCE
				&& targetElement instanceof JvmMember;
	}
	
	protected boolean isTypeResource(EObject jvmElement) {
		Resource eResource = jvmElement.eResource();
		if(eResource != null)
			return equal("java", eResource.getURI().scheme());
		else 
			return false;
	}

	protected IJavaElementFinder getJavaElementFinder() {
		return javaElementFinder;
	}

}
