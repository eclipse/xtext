/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class RenameJvmReferenceContext extends IRenameElementContext.Impl {

	private final IJavaElement referencedJavaElement;

	public RenameJvmReferenceContext(JvmMember referencedJvmMember, IJavaElement referencedJavaElement,
			IEditorPart triggeringEditor, ISelection triggeringEditorSelection, URI contextResourceURI) {
		super(EcoreUtil.getURI(referencedJvmMember), referencedJvmMember.eClass(), triggeringEditor,
				triggeringEditorSelection, contextResourceURI);
		this.referencedJavaElement = referencedJavaElement;
	}

	public RenameJvmReferenceContext(JvmMember referencedJvmMember, IJavaElement referencedJavaElement) {
		this(referencedJvmMember, referencedJavaElement, null, null, null);
	}

	public IJavaElement getReferencedJavaElement() {
		return referencedJavaElement;
	}

}
