/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultRefactoringDocumentProvider implements IRefactoringDocument.Provider {

	@Inject
	private IWorkbench workbench;

	@Inject
	private IWorkspace workspace;

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

	public IRefactoringDocument get(URI uri, final RefactoringStatus status) {
		URI resourceURI = uri.trimFragment();
		final IFileEditorInput fileEditorInput = getEditorInput(resourceURI, status);
		if (fileEditorInput != null) {
			IXtextDocument openDocument = new DisplayRunnableWithResult<IXtextDocument>() {
				@Override
				protected IXtextDocument run() throws Exception {
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					IEditorPart editor = activePage.findEditor(fileEditorInput);
					if (editor instanceof ITextEditor) {
						if (editor instanceof ITextEditorExtension
								&& ((ITextEditorExtension) editor).isEditorInputReadOnly())
							status.addError("Editor " + fileEditorInput.getName() + " is read only");
						return ((XtextEditor) editor).getDocument();
					}
					return null;
				}
			}.syncExec();
			if (openDocument != null)
				return new EditorDocument(resourceURI, openDocument);
			else
				return new FileDocument(resourceURI, fileEditorInput.getFile());
		}
		return null;
	}

	public static class EditorDocument implements IRefactoringDocument {

		private URI resourceURI;
		private IDocument document;

		public EditorDocument(URI resourceURI, IDocument document) {
			this.resourceURI = resourceURI;
			this.document = document;
		}

		public Change createChange(String name, TextEdit textEdit) {
			DocumentChange documentChange = new DocumentChange(name, document);
			documentChange.setEdit(textEdit);
			return new DisplayChangeWrapper(documentChange);
		}

		public URI getURI() {
			return resourceURI;
		}
		
		public IDocument getDocument() {
			return document;
		}
	}

	public static class FileDocument implements IRefactoringDocument {

		private URI resourceURI;
		private IFile file;

		public FileDocument(URI resourceURI, IFile file) {
			this.resourceURI = resourceURI;
			this.file = file;
		}

		public Change createChange(String name, TextEdit textEdit) {
			TextFileChange textFileChange = new TextFileChange(name, file);
			textFileChange.setEdit(textEdit);
			return textFileChange;
		}

		public URI getURI() {
			return resourceURI;
		}
		
		public IFile getFile() {
			return file;
		}
	}
}
