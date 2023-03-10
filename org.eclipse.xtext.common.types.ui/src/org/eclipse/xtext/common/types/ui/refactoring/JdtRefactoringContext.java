/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import static org.eclipse.xtext.EcoreUtil2.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * A {@link IRenameElementContext} for a JDT rename refactoring.
 * 
 * Used when triggering a JDT refactoring from a reference to a JVM element in an Xtext -based language.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JdtRefactoringContext extends IRenameElementContext.Impl {

	private IJavaElement javaElement;
	private final boolean isRealJvmElement;

	public JdtRefactoringContext(EObject targetJvmElement, IJavaElement javaElement, IEditorPart editor,
			ISelection selection, XtextResource contextResource, boolean isRealJvmMember) {
		super(getPlatformResourceOrNormalizedURI(targetJvmElement), targetJvmElement.eClass(), editor, selection,
				getPlatformResourceOrNormalizedURI(contextResource));
		this.javaElement = javaElement;
		this.isRealJvmElement = isRealJvmMember;
	}

	public IJavaElement getJavaElement() {
		return javaElement;
	}

	public boolean isRealJvmElement() {
		return isRealJvmElement;
	}
	
}
