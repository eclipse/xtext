/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextDocumentProvider extends FileDocumentProvider {

	@Inject
	private Provider<XtextDocument> document;


	@Override
	protected IDocument createEmptyDocument() {
		XtextDocument xtextDocument = document.get();
		return xtextDocument;
	}

	@Override
	protected void setupDocument(Object element, IDocument document) {
		((XtextDocument) document).setInput((IEditorInput) element);
	}

	@Override
	protected void disconnected() {
		super.disconnected();
	}

}
