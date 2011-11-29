/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmbeddedEditor {
	private final XtextSourceViewer viewer;

	private final IEditedResourceProvider resourceProvider;

	private final XtextDocument document;

	private final XtextSourceViewerConfiguration configuration;

	private final Runnable afterSetDocument;

	public EmbeddedEditor(XtextDocument document, XtextSourceViewer viewer, XtextSourceViewerConfiguration configuration, IEditedResourceProvider resourceProvider, Runnable afterSetDocumet) {
		this.document = document;
		this.viewer = viewer;
		this.configuration = configuration;
		this.resourceProvider = resourceProvider;
		this.afterSetDocument = afterSetDocumet;
	}

	public XtextSourceViewer getViewer() {
		return this.viewer;
	}

	public XtextDocument getDocument() {
		return this.document;
	}

	public XtextSourceViewerConfiguration getConfiguration() {
		return this.configuration;
	}
	
	public EmbeddedEditorModelAccess createPartialEditor(String prefix, String editablePart, String suffix, boolean lineBreaks) {
		EmbeddedEditorModelAccess result = new EmbeddedEditorModelAccess(this.viewer, this.resourceProvider, lineBreaks);
		result.setModel(getDocument(), prefix, editablePart, suffix);
		afterSetDocument.run();
		return result;
	}

	public EmbeddedEditorModelAccess createPartialEditor(boolean insertLinebreaks) {
		return createPartialEditor("", "", "", insertLinebreaks);
	}
	
	public EmbeddedEditorModelAccess createPartialEditor() {
		return createPartialEditor("", "", "", false);
	}
}