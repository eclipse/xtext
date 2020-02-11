/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class ValidatingEditorCallback extends IXtextEditorCallback.NullImpl {

	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private MarkerCreator markerCreator;

	@Inject
	private MarkerTypeProvider markerTypeProvider;
	@Inject
	private IssueResolutionProvider issueResolutionProvider;

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		if (editor.isEditable()) {
			ValidationJob validationJob = newValidationJob(editor);
			validationJob.schedule();
		}
	}

	@Override
	public void afterSave(XtextEditor editor) {
		super.afterSave(editor);
		if (editor.isEditable()) {
			ValidationJob validationJob = newValidationJob(editor);
			validationJob.schedule();
		}
	}

	private ValidationJob newValidationJob(XtextEditor editor) {
		IValidationIssueProcessor issueProcessor;
		if (editor.getResource() == null) {
			issueProcessor = new AnnotationIssueProcessor(editor.getDocument(), editor.getInternalSourceViewer().getAnnotationModel(),
					issueResolutionProvider);
		} else {
			issueProcessor = new MarkerIssueProcessor(editor.getResource(), editor.getInternalSourceViewer().getAnnotationModel(),
					markerCreator, markerTypeProvider);
		}
		ValidationJob validationJob = new ValidationJob(resourceValidator, editor.getDocument(), issueProcessor, CheckMode.NORMAL_AND_FAST);
		return validationJob;
	}
}
