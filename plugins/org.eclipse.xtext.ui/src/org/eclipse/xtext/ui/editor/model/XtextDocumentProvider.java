/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.xtext.ui.MarkerUtil;
import org.eclipse.xtext.ui.editor.quickfix.XtextResourceMarkerAnnotationModel;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.IssueResolutionProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 * @author Heiko Behrens
 */
public class XtextDocumentProvider extends FileDocumentProvider {
	@Inject
	private Provider<XtextDocument> document;
	@Inject
	private IResourceValidator resourceValidator;
	
	// TODO use a provider for objects that depend on issueResolitionProvider+markerUtil when guice2 is available
	@Inject
	private IssueResolutionProvider issueResolutionProvider;
	
	@Inject
	private MarkerUtil markerUtil;

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
		AnnotationIssueProcessor annotationIssueProcessor = new AnnotationIssueProcessor(doc, info.fModel, issueResolutionProvider);
		ValidationJob job = new ValidationJob(resourceValidator, doc, annotationIssueProcessor,CheckMode.FAST_ONLY);
		doc.setValidationJob(job);
		return info;
	}
	
	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		if (element instanceof IFileEditorInput) {
			IFileEditorInput input= (IFileEditorInput) element;
			return new XtextResourceMarkerAnnotationModel(input.getFile(), issueResolutionProvider, markerUtil);
		}

		return super.createAnnotationModel(element);
	}

}
