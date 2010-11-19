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
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RefactoringDocumentProvider implements IRefactoringDocument.Provider {

	@Inject
	private IWorkbench workbench;

	@Inject
	private IWorkspace workspace;

	@Inject
	private XtextDocumentProvider xtextDocumentProvider;

	private static final Logger LOG = Logger.getLogger(RefactoringDocumentProvider.class);

	public IRefactoringDocument get(final URI uri, final RefactoringStatus status) {
		URI resourceURI = uri.trimFragment();
		IRefactoringDocument result = null;
		final IFileEditorInput fileEditorInput = getEditorInput(resourceURI, status);
		IXtextDocument openDocument = new DisplayRunnableWithResult<IXtextDocument>() {
			@Override
			protected IXtextDocument run() throws Exception {
				IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				IEditorPart editor = activePage.findEditor(fileEditorInput);
				if (editor instanceof XtextEditor) {
					if (((XtextEditor) editor).isEditorInputReadOnly())
						status.addError("Editor " + fileEditorInput.getName() + " is read only");
					return ((XtextEditor) editor).getDocument();
				}
				return null;
			}
		}.syncExec();
		if (openDocument != null) {
			result = new EditorDocument(openDocument);
		} else {
			try {
				xtextDocumentProvider.connect(fileEditorInput);
				IXtextDocument document = (IXtextDocument) xtextDocumentProvider.getDocument(fileEditorInput);
				if (!(document instanceof XtextDocument)) {
					status.addError("Could not get an XtextDocument for " + fileEditorInput.getName());
				} else {
					result = new FileDocument(fileEditorInput.getFile(), (XtextDocument) document);
				}
			} catch (CoreException e) {
				status.addError("Error getting XtextDocument for " + fileEditorInput.getName() + ": " + e.getMessage());
				LOG.error(e);
			}
		}
		return result;
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

	public static class EditorDocument implements IRefactoringDocument {

		private IXtextDocument document;

		public EditorDocument(IXtextDocument document) {
			this.document = document;
		}

		public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
			return document.readOnly(work);
		}

		public TextEdit apply(TextEdit edit) {
			final TextEdit editToBeApplied = edit.copy();
			TextEdit undoEdit = new DisplayRunnableWithResult<TextEdit>() {
				@Override
				public TextEdit run() throws Exception {
					return editToBeApplied.apply(document);
				}
			}.syncExec();
			return undoEdit;
		}

		public Change createChange(String name, TextEdit textEdit) {
			DocumentChange documentChange = new DocumentChange(name, document);
			documentChange.setEdit(textEdit);
			return new DisplayChangeWrapper(documentChange);
		}

		public IXtextDocument getXtextDocument() {
			return document;
		}
		
		@Override
		public boolean equals(Object other) {
			return other instanceof EditorDocument && ((EditorDocument)other).getXtextDocument().equals(document);
		}
		
		@Override
		public int hashCode() {
			return document == null ? 0 : document.hashCode();
		}
	}

	// TODO: lazily load and release document
	public static class FileDocument implements IRefactoringDocument {

		private IFile file;
		private final XtextDocument document;

		public FileDocument(IFile file, XtextDocument document) {
			this.file = file;
			this.document = document;
		}

		public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
			return document.readOnly(work);
		}

		public TextEdit apply(TextEdit edit) {
			final TextEdit editToBeApplied = edit.copy();
			document.internalModify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					editToBeApplied.apply(document);
					state.reparse(document.get());
				}
			});
			// no undo needed for non-editor documents
			return null;
		}

		public Change createChange(String name, TextEdit textEdit) {
			TextChange textChange = new TextFileChange(name, file);
			textChange.setEdit(textEdit);
			return textChange;
		}

		public IFile getFile() {
			return file;
		}
		
		@Override
		public boolean equals(Object other) {
			return other instanceof FileDocument && ((FileDocument)other).getFile().equals(file);
		}
		
		@Override
		public int hashCode() {
			return file == null ? 0 : file.hashCode();
		}
	}
}
