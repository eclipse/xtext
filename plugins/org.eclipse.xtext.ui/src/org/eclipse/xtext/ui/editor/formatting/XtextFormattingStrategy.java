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
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IFormatter;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextFormattingStrategy extends ContextBasedFormattingStrategy {

	private final IFormatter formatter;
	private static long time = 0;
	private IEditorModelProvider editorModelProvider;
	private LinkedList<IDocument> documents = new LinkedList<IDocument>();

	private LinkedList<IRegion> regions = new LinkedList<IRegion>();

	public XtextFormattingStrategy(IEditorModelProvider editorModelProvider, IFormatter formatter) {
		this.editorModelProvider = editorModelProvider;
		this.formatter = formatter;
	}

	protected IEditorModelProvider getEditorModelProvider() {
		return editorModelProvider;
	}

	@Override
	public void formatterStarts(IFormattingContext context) {
		if (Activator.DEBUG_FORMATTER)
			time = System.currentTimeMillis();
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
			formatter.format(editorModelProvider.getModel(), document, region);
		}
	}

	@Override
	public void formatterStops() {
		super.formatterStops();
		regions.clear();
		documents.clear();
		if (Activator.DEBUG_FORMATTER) {
			System.out.println("XtextFormattingStrategy.formatterStops(): Formatting took "
					+ (System.currentTimeMillis() - time) + " ms");
		}
	}
}
