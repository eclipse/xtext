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
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.editor.validation.MarkerIssueProcessor;
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
	@Inject 
	private MarkerCreator markerCreator;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (xtextEditor != null) {
			MarkerIssueProcessor markerIssueProcessor = new MarkerIssueProcessor(xtextEditor.getResource(),
					markerCreator);
			IXtextDocument xtextDocument = XtextDocumentUtil.get(xtextEditor);
			ValidationJob validationJob = new ValidationJob(resourceValidator, xtextDocument, markerIssueProcessor,
					CheckMode.ALL);
			validationJob.schedule();
		}
		return this;
	}
}
