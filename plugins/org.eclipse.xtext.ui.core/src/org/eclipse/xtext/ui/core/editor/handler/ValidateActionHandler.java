/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.core.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.core.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 */
public class ValidateActionHandler extends AbstractHandler {
	@Inject
	private IResourceValidator resourceValidator;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = (XtextEditor) HandlerUtil.getActiveEditor(event);
		IXtextDocument xtextDocument = XtextDocumentUtil.get(xtextEditor);
		IDocumentProvider documentProvider = xtextEditor.getDocumentProvider();
		IAnnotationModel annotationModel = documentProvider.getAnnotationModel(xtextEditor.getEditorInput());
		ValidationJob validationJob = new ValidationJob(resourceValidator, xtextDocument,
				new AnnotationIssueProcessor(xtextDocument, annotationModel), CheckMode.ALL);
		validationJob.schedule();
		return this;
	}
}
