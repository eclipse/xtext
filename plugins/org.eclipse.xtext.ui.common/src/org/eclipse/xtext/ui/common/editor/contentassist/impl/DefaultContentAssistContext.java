/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.core.editor.IXtextSourceViewer;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;

/**
 * Provides a default implementation of interface {@link IContentAssistContext}.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see IContentAssistContext
 */
public class DefaultContentAssistContext implements IContentAssistContext {

	private IXtextSourceViewer xtextSourceViewer;
	private IXtextDocument xtextDocument;
	private ITextViewer textViewer;
	private String matchString;
	private int offset;

	public DefaultContentAssistContext(ITextViewer textViewer, int offset) {
		this.xtextSourceViewer = ((IXtextSourceViewer) textViewer);
		this.xtextDocument = (IXtextDocument) textViewer.getDocument();
		this.textViewer = textViewer;
		this.offset = offset;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getDocument()
	 */
	public IXtextDocument getDocument() {
		return this.xtextDocument;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getMatchString()
	 */
	public String getMatchString() {
		if (this.matchString == null) {
			this.matchString = calculateMatchString(this.textViewer, this.offset);
		}
		return this.matchString;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getModel()
	 */
	public EObject getModel() {
		return this.xtextSourceViewer.getModel(this.offset);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getReferenceNode()
	 */
	public AbstractNode getReferenceNode() {
		return this.xtextSourceViewer.getReferenceNode(this.offset);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getNode()
	 */
	public AbstractNode getNode() {
		return this.xtextSourceViewer.getNode(this.offset);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getOffSet()
	 */
	public int getOffSet() {
		return this.offset;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext#getRootNode()
	 */
	public CompositeNode getRootNode() {
		return this.xtextSourceViewer.getRootNode();
	}

	protected String calculateMatchString(ITextViewer viewer, final int offset) {

		if (getNode() == null)
			return "";

		String prefix = "";
		
		StyledText textWidget = viewer.getTextWidget();
		
		if (textWidget.getCharCount() > 0) {
			int boundedOffset = Math.min(offset, textWidget.getCharCount()) - 1;
			if (getNode().getTotalOffset() <= boundedOffset)
				prefix = textWidget.getText(getNode().getTotalOffset(), boundedOffset).trim();
		}

		// if cursor is behind a complete keyword, accept any input => empty
		// prefix
		// TODO: Find a way to distinguish between keywords like "+" or "-"
		// and"extends" or "class" in the latter case,
		// the prefix "" would not always be sufficient
		if (getNode().getGrammarElement() instanceof Keyword
				&& (getNode() instanceof LeafNode && ((LeafNode) getNode()).getText().equals(prefix))) {
			prefix = "";
		}

		return prefix;
	}

}
