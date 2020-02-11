/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import static org.eclipse.xtext.EcoreUtil2.*;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CombinedJvmJdtRenameContext extends IRenameElementContext.Impl {

	private final Map<URI, IJavaElement> jvm2javaElements;

	public CombinedJvmJdtRenameContext(EObject targetElement, Map<URI, IJavaElement> jvm2javaElements, XtextEditor editor,
			ITextSelection selection, XtextResource contextResource) {
		super(getPlatformResourceOrNormalizedURI(targetElement), targetElement.eClass(), editor, selection,
				getPlatformResourceOrNormalizedURI(contextResource));
		this.jvm2javaElements = jvm2javaElements;
	}

	public Map<URI, IJavaElement> getJvm2JavaElements() {
		return jvm2javaElements;
	}
}
