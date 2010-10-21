/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;

public class SourceViewerHandle {
	private IValidationIssueProcessor issueProcessor;
	private final XtextSourceViewer viewer;
	private final ISyntheticResourceProvider resourceProvider;
	private final XtextDocument document;
	private final XtextSourceViewerConfiguration configuration;

	SourceViewerHandle(XtextDocument document, XtextSourceViewer viewer, XtextSourceViewerConfiguration configuration, ISyntheticResourceProvider resourceProvider) {
		this.document = document;
		this.viewer = viewer;
		this.configuration = configuration;
		this.resourceProvider = resourceProvider;
	}

	public void setIssueProcessor(IValidationIssueProcessor issueProcessor) {
		this.issueProcessor = issueProcessor;
	}
	
	public IValidationIssueProcessor getIssueProcessor() {
		return issueProcessor;
	}
	
	public XtextSourceViewer getViewer() {
		return viewer;
	}
	
	public XtextDocument getDocument() {
		return document;
	}
	
	public XtextSourceViewerConfiguration getConfiguration() {
		return configuration;
	}
	
	public PartialModelEditor createPartialEditor(String prefix, String editablePart, String suffix) {
		PartialModelEditor result = new PartialModelEditor(viewer, resourceProvider, true);
		result.setModel(getDocument(), prefix, editablePart, suffix);
		return result;
	}
	
	public PartialModelEditor createPartialEditor() {
		return createPartialEditor("", "", "");
	}
}