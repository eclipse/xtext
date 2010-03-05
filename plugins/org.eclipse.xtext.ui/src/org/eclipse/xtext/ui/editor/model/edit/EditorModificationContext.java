/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EditorModificationContext implements IModificationContext {

	@Inject
	private IURIEditorOpener editorOpener;

	private Issue issue;

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public IXtextDocument getXtextDocument() {
		IEditorPart editor = editorOpener.open(issue.getUriToProblem(), false);
		if (editor instanceof XtextEditor) {
			XtextEditor xtextEditor = (XtextEditor) editor;
			return xtextEditor.getDocument();
		}
		return null;
	}
	
}