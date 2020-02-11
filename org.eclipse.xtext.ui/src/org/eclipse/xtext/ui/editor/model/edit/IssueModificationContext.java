/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IssueModificationContext implements IModificationContext {

	@Inject
	private IURIEditorOpener editorOpener;

	private Issue issue;

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	public Issue getIssue() {
		return issue;
	}

	@Override
	public IXtextDocument getXtextDocument() {
		return getXtextDocument(issue.getUriToProblem());
	}

	@Override
	public IXtextDocument getXtextDocument(URI uri) {
		IEditorPart editor = editorOpener.open(uri, false);
		if (editor instanceof XtextEditor) {
			XtextEditor xtextEditor = (XtextEditor) editor;
			return xtextEditor.getDocument();
		}
		return null;
	}

	@ImplementedBy(Factory.Default.class)
	public static interface Factory {
		IModificationContext createModificationContext(Issue issue);
		
		public static class Default implements Factory {
			
			@Inject
			private Provider<IssueModificationContext> provider;
			
			@Override
			public IModificationContext createModificationContext(Issue issue) {
				IssueModificationContext modificationContext = provider.get();
				modificationContext.setIssue(issue);
				return modificationContext;
			}

		}
	}
}