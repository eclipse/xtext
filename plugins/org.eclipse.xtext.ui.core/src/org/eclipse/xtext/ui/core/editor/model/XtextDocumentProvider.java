/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextDocumentProvider extends FileDocumentProvider implements IDocumentProvider {

	@Override
	protected IDocument createEmptyDocument() {
		return new XtextDocument(new Document());
	}
	
	@Override
	public IDocument getDocument(Object element) {
		XtextDocument document = (XtextDocument) super.getDocument(element);
		document.setURI((IURIEditorInput) element);
		return document;
	}

}
