/*******************************************************************************
 * Copyright (c) 2008, 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 * @author Peter Friese
 */
public class ValidateActionHandler extends AbstractHandler {
	@Inject
	private IResourceValidator resourceValidator;

	// TODO use a provider for objects that depend on annotationIssueProcessor when guice2 is available
	@Inject
	private IssueResolutionProvider issueResolutionProvider;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (xtextEditor != null) {
			IXtextDocument xtextDocument = XtextDocumentUtil.get(xtextEditor);
			IDocumentProvider documentProvider = xtextEditor.getDocumentProvider();
			IAnnotationModel annotationModel = documentProvider.getAnnotationModel(xtextEditor.getEditorInput());
			ValidationJob validationJob = new ValidationJob(resourceValidator, xtextDocument,
					new AnnotationIssueProcessor(xtextDocument, annotationModel, issueResolutionProvider), CheckMode.ALL);
			validationJob.schedule();
		}
		return this;
	}
}
