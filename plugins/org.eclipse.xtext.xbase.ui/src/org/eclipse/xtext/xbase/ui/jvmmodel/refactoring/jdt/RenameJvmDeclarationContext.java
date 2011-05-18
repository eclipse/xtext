/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;


import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * A {@link IRenameElementContext} that triggers a JDT rename refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class RenameJvmDeclarationContext extends IRenameElementContext.Impl {

	private List<IJavaElement> javaElements;

	public RenameJvmDeclarationContext(URI targetElementURI, EClass targetElementEClass, List<IJavaElement> javaElements, IEditorPart editor,
			ISelection selection, URI contextResourceURI) {
		super(targetElementURI, targetElementEClass, editor, selection, contextResourceURI);
		this.javaElements = javaElements;
	}

	public List<IJavaElement> getJavaElements() {
		return javaElements;
	}
}
