/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.xtext.ui.core.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.core.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 */
public class XtextDocumentProvider extends FileDocumentProvider {
	@Inject
	private Provider<XtextDocument> document;
	@Inject
	private IResourceValidator resourceValidator;

	@Override
	protected XtextDocument createEmptyDocument() {
		XtextDocument xtextDocument = document.get();
		return xtextDocument;
	}

	@Override
	protected void setupDocument(Object element, IDocument document) {
		XtextDocument xtextDocument = (XtextDocument) document;
		IEditorInput input = (IEditorInput) element;
		xtextDocument.setInput(input);
	}
	
	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		ElementInfo info = super.createElementInfo(element);
		XtextDocument doc = (XtextDocument) info.fDocument;
		AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(doc, info.fModel);
		ValidationJob job = new ValidationJob(resourceValidator, doc, annotationIssueProcessor,CheckMode.FAST_ONLY);
		doc.setValidationJob(job);
		return info;
	}

}
