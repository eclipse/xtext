/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.core.builder.AddMarkersOperation;
import org.eclipse.xtext.ui.core.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.core.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ValidatingEditorCallback implements IXtextEditorCallback {
	
	@Inject
	private IXtextResourceChecker checker;
	
	static class MarkerAddingValidationJob extends ValidationJob {

		private XtextEditor editor;

		public MarkerAddingValidationJob(IXtextResourceChecker xtextResourceChecker,
				XtextEditor editor) {
			super(xtextResourceChecker, editor.getDocument());
			this.editor = editor;
		}

		@Override
		protected void processIssues(List<Map<String, Object>> issues) {
			AddMarkersOperation.run(editor.getResource(), issues, true, new NullProgressMonitor());
		}
	}


	public void afterCreatePartControl(XtextEditor editor) {
		new MarkerAddingValidationJob(checker, editor).schedule();
	}

	public void afterSave(XtextEditor editor) {
		new MarkerAddingValidationJob(checker, editor).schedule();
	}

}
