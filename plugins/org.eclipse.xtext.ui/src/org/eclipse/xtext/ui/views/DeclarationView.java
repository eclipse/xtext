/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.views;

import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.3
 */
public class DeclarationView extends AbstractSourceView {
	@Inject
	protected Provider<XtextDocument> documentProvider;
	@Inject
	protected Provider<IDocumentPartitioner> documentPartitioner;
	@Inject
	private ReadOnlySourceViewerConfiguration sourceViewerConfiguration;

	@Override
	protected SourceViewer createSourceViewer(Composite parent) {
		XtextSourceViewer viewer = new XtextSourceViewer(parent, null, null, false, SWT.V_SCROLL | SWT.H_SCROLL);
		viewer.configure(sourceViewerConfiguration);
		viewer.setEditable(false);
		return viewer;
	}

	@Override
	protected String getBackgroundColorKey() {
		return getLanguageName() + "ui.DeclarationView.backgroundColor"; //$NON-NLS-1$
	}

	@Override
	protected String getViewerFontName() {
		return getLanguageName() + ".ui.editors.textfont"; //$NON-NLS-1$
	}

	@Override
	protected XtextDocument createDocument(String input) {
		XtextDocument xtextDocument = documentProvider.get();
		xtextDocument.set(input);
		IDocumentPartitioner partitioner = documentPartitioner.get();
		partitioner.connect(xtextDocument);
		xtextDocument.setDocumentPartitioner(partitioner);
		return xtextDocument;
	}

}
