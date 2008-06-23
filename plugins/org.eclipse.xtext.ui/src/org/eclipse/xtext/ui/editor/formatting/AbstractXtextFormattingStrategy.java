/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import java.util.LinkedList;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.formatter.ContextBasedFormattingStrategy;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.service.IFormatterService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractXtextFormattingStrategy extends ContextBasedFormattingStrategy {

	private final IFormatterService formatter;

	private IEditorModelProvider editorModelProvider;
	private LinkedList<IDocument> documents = new LinkedList<IDocument>();

	private LinkedList<IRegion> regions = new LinkedList<IRegion>();

	public AbstractXtextFormattingStrategy(IEditorModelProvider editorModelProvider, IFormatterService formatter) {
		this.editorModelProvider = editorModelProvider;
		this.formatter = formatter;
	}

	protected IEditorModelProvider getEditorModelProvider() {
		return editorModelProvider;
	}

	@Override
	public void formatterStarts(IFormattingContext context) {
		super.formatterStarts(context);
		documents.addLast((IDocument) context.getProperty(FormattingContextProperties.CONTEXT_MEDIUM));
		regions.addLast((IRegion) context.getProperty(FormattingContextProperties.CONTEXT_REGION));
	}

	@Override
	public void format() {
		super.format();

		final IDocument document = (IDocument) documents.removeFirst();
		IRegion region = regions.removeFirst();
		if (document != null) {
			if (region == null)
				region = new Region(0, document.getLength());
			format(document, region);
		}
	}

	protected abstract void format(IDocument document, IRegion region);

	protected IFormatterService getFormatterService() {
		return formatter;
	}

	@Override
	public void formatterStops() {
		super.formatterStops();
		regions.clear();
		documents.clear();
	}
}
