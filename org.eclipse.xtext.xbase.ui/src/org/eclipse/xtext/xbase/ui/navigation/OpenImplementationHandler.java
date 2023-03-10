/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.ui.editor.AbstractJvmElementHandler;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class OpenImplementationHandler extends AbstractJvmElementHandler {

	@Inject
	private JvmImplementationOpener opener;

	@Override
	protected void openPresentation(XtextEditor editor, IJavaElement javaElement, EObject selectedElement) {
		if (editor != null) {
			final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
			@SuppressWarnings("restriction")
			IRegion region = org.eclipse.jdt.internal.ui.text.JavaWordFinder.findWord(editor.getDocument(), selection.getOffset());
			opener.openImplementations(javaElement, editor.getInternalSourceViewer(), region);
		}
	}
}
