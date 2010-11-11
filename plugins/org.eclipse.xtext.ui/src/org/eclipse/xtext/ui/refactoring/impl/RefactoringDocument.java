/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RefactoringDocument {

	private IXtextDocument document;

	private IFile fileToSave;

	private final boolean isOpenEditor;

	public RefactoringDocument(IXtextDocument document, IFile fileToSave) {
		this(document, fileToSave, false);
	}

	public RefactoringDocument(IXtextDocument document, IFile fileToSave, boolean isOpenEditor) {
		this.document = document;
		this.fileToSave = fileToSave;
		this.isOpenEditor = isOpenEditor;
	}

	public IXtextDocument getXtextDocument() {
		return document;
	}

	public IFile getFileToSave() {
		return fileToSave;
	}
	
	public boolean isOpenEditor() {
		return isOpenEditor;
	}
	
	public static class Factory {
		@Inject
		private IWorkbench workbench;

		@Inject
		private IWorkspace workspace;

		@Inject
		private XtextDocumentProvider xtextDocumentProvider;

		private static final Logger LOG = Logger.getLogger(RefactoringDocument.Factory.class);

		public RefactoringDocument create(final URI uri, final RefactoringStatus status) {
			final IFileEditorInput fileEditorInput = getEditorInput(uri, status);
			RefactoringDocument openDocument = new DisplayRunnableWithResult<RefactoringDocument>() {
				@Override
				protected RefactoringDocument run() throws Exception {
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					IEditorPart editor = activePage.findEditor(fileEditorInput);
					if (editor instanceof XtextEditor) {
						if(((XtextEditor) editor).isEditorInputReadOnly())
							status.addError("Editor " + fileEditorInput.getName() + " is read only");
						return new RefactoringDocument(((XtextEditor) editor).getDocument(), fileEditorInput.getFile(), true);
					}
					return null;
				}
			}.syncExec();
			if (openDocument != null)
				return openDocument;
			try {
				xtextDocumentProvider.connect(fileEditorInput);
				IXtextDocument document = (IXtextDocument) xtextDocumentProvider.getDocument(fileEditorInput);
				if (document == null) {
					status.addError("Could not get an XtextDocument for " + fileEditorInput.getName());
				} else {
					return new RefactoringDocument(document, fileEditorInput.getFile());
				}
			} catch (CoreException e) {
				status.addError("Error getting XtextDocument for " + fileEditorInput.getName() + ": " + e.getMessage());
				LOG.error(e);
			}
			return null;
		}

		protected IFileEditorInput getEditorInput(URI resourceURI, RefactoringStatus status) {
			if (!resourceURI.isPlatformResource()) {
				status.addError("Cannot change resource " + resourceURI.toString());
				return null;
			} else {
				IFile file = workspace.getRoot().getFile(new Path(resourceURI.toPlatformString(true)));
				if (!file.isAccessible()) {
					status.addError("File " + file.getName() + " does not exist");
					return null;
				}
				if (file.isReadOnly()) {
					status.addError("File " + file.getName() + " is read only");
				}
				FileEditorInput fileEditorInput = new FileEditorInput(file);
				return fileEditorInput;
			}
		}

	}

}
