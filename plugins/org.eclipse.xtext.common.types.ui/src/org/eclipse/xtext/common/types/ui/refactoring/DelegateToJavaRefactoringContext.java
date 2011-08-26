/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import static org.eclipse.xtext.EcoreUtil2.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * A {@link IRenameElementContext} that triggers a JDT rename refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class DelegateToJavaRefactoringContext extends IRenameElementContext.Impl {

	private List<IJavaElement> javaElements;
	private final boolean isRealJvmElement;

	public DelegateToJavaRefactoringContext(EObject targetJvmElement, List<IJavaElement> javaElements,
			IEditorPart editor, ISelection selection, XtextResource contextResource, boolean isRealJvmMember) {
		super(getNormalizedURI(targetJvmElement), targetJvmElement.eClass(), editor, selection,
				getNormalizedURI(contextResource));
		this.javaElements = javaElements;
		this.isRealJvmElement = isRealJvmMember;
	}

	public List<IJavaElement> getJavaElements() {
		return javaElements;
	}
	
	public boolean isRealJvmElement() {
		return isRealJvmElement;
	}
}
