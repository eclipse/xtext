/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.bracketmatching;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CharacterPairMatcher implements ICharacterPairMatcher, IDocumentListener, IXtextModelListener {

	public void dispose() {
		clear();
	}

	public void clear() {
		this.document.removeDocumentListener(this);
		this.document.removeModelListener(this);
		this.changes = false;
	}

	private IXtextDocument document;

	@Inject
	private IBracketMatcher bracketMatcher;

	public IRegion match(IDocument iDocument, final int offset) {
		IXtextDocument doc = getDocument(iDocument);
		if (!changes) {
			return BracketMatchingUnitOfWork.match(doc, bracketMatcher, offset);
		}
		return null;
	}

	protected IXtextDocument getDocument(IDocument iDocument) {
		if (this.document == null) {
			this.document = (IXtextDocument) iDocument;
			this.document.addDocumentListener(this);
			this.document.addModelListener(this);
		}
		if (this.document != iDocument)
			throw new IllegalStateException();
		return this.document;
	}

	public int getAnchor() {
		return ICharacterPairMatcher.LEFT;
	}

	private boolean changes = false;

	public void documentAboutToBeChanged(DocumentEvent event) {
	}

	public void documentChanged(DocumentEvent event) {
		changes = true;
	}

	public void modelChanged(XtextResource resource) {
		changes = false;
	}

}
