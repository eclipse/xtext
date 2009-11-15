/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import org.eclipse.xtext.ui.core.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class ValidatingEditorCallback extends AbstractDirtyStateAwareEditorCallback {
	@Inject
	private IXtextResourceChecker checker;

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
		MarkerIssueProcessor markerIssueProcessor = new MarkerIssueProcessor(editor.getResource());
		ValidationJob validationJob = new ValidationJob(checker, editor.getDocument(), markerIssueProcessor);
		return validationJob;
	}
}
