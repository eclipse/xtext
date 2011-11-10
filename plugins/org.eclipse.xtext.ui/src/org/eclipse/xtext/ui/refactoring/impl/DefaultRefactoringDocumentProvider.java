/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
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
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

import com.google.inject.Inject;

/**
 * Unifies the creation of {@link Change}s from {@link TextEdit}s on {@link IFile}s and {@link IDocument}s.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultRefactoringDocumentProvider implements IRefactoringDocument.Provider {

	@Inject(optional = true)
	private IWorkbench workbench;

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	protected IFileEditorInput getEditorInput(URI resourceURI, StatusWrapper status) {
		IFile file = projectUtil.findFileStorage(resourceURI, true);
		if (file == null) {
			status.add(ERROR, "No suitable storage found for resource {0}.", resourceURI);
			return null;
		}
		return new FileEditorInput(file);
	}

	public IRefactoringDocument get(URI uri, final StatusWrapper status) {
		URI resourceURI = uri.trimFragment();
		final IFileEditorInput fileEditorInput = getEditorInput(resourceURI, status);
		if (fileEditorInput != null) {
			ITextEditor editor = new DisplayRunnableWithResult<ITextEditor>() {
				@Override
				protected ITextEditor run() throws Exception {
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					IEditorPart editor = activePage.findEditor(fileEditorInput);
					if (editor instanceof ITextEditor) {
						if (editor instanceof ITextEditorExtension
								&& ((ITextEditorExtension) editor).isEditorInputReadOnly())
							status.add(ERROR, "Editor for {0} is read only", fileEditorInput.getName());
						return ((ITextEditor) editor);
					}
					return null;
				}
			}.syncExec();
			if (editor != null) {
				IDocument document = editor.getDocumentProvider().getDocument(fileEditorInput);
				if (document != null && editor.isDirty())
					return new EditorDocument(resourceURI, document);
			}
			return new FileDocument(resourceURI, fileEditorInput.getFile(), globalServiceProvider.findService(
					resourceURI, IEncodingProvider.class));
		}
		return null;
	}

	public static abstract class AbstractRefactoringDocument implements IRefactoringDocument {
		private URI resourceURI;

		public AbstractRefactoringDocument(URI resourceURI) {
			this.resourceURI = resourceURI;
		}

		public abstract Change createChange(String name, TextEdit textEdit);

		public URI getURI() {
			return resourceURI;
		}

		@Override
		public boolean equals(Object obj) {
			return getClass().isInstance(obj) && ((IRefactoringDocument) obj).getURI().equals(resourceURI);
		}

		@Override
		public int hashCode() {
			return resourceURI.hashCode();
		}
	}

	public static class EditorDocument extends AbstractRefactoringDocument {

		private IDocument document;

		public EditorDocument(URI resourceURI, IDocument document) {
			super(resourceURI);
			this.document = document;
		}

		public IDocument getDocument() {
			return document;
		}

		@Override
		public Change createChange(String name, TextEdit textEdit) {
			DocumentChange documentChange = new DocumentChange(getName(), document);
			documentChange.setEdit(textEdit);
			documentChange.setTextType(getURI().fileExtension());
			return new DisplayChangeWrapper(documentChange);
		}

		protected String getName() {
			StringBuilder buffer = new StringBuilder(getURI().lastSegment());
			buffer.append(" - ");
			buffer.append(getURI().segment(1));
			for (int i = 2; i < getURI().segmentCount() - 1; ++i) {
				buffer.append("/");
				buffer.append(getURI().segment(i));
			}
			return buffer.toString();
		}

		public String getOriginalContents() {
			return document.get();
		}
	}

	/**
	 * @depreacted Saving documents during changes causes unpredictable errors when the document is also renamed
	 */
	@Deprecated
	public static class SaveEditorDocument extends EditorDocument {

		private final ITextEditor editor;

		public SaveEditorDocument(URI uri, ITextEditor editor, IDocument document) {
			super(uri, document);
			this.editor = editor;
		}

		@Override
		public Change createChange(String name, TextEdit textEdit) {
			DocumentChange documentChange = new DocumentChange(getName(), getDocument());
			documentChange.setEdit(textEdit);
			documentChange.setTextType(getURI().fileExtension());
			return new DisplayChangeWrapper(documentChange, editor);
		}
	}

	public static class FileDocument extends AbstractRefactoringDocument {

		private IFile file;
		private IEncodingProvider encodingProvider;

		public FileDocument(URI resourceURI, IFile file, IEncodingProvider encodingProvider) {
			super(resourceURI);
			this.file = file;
			this.encodingProvider = encodingProvider;
		}

		public IFile getFile() {
			return file;
		}

		@Override
		public Change createChange(String name, TextEdit textEdit) {
			TextFileChange textFileChange = new TextFileChange(name, file);
			textFileChange.setSaveMode(TextFileChange.FORCE_SAVE);
			textFileChange.setEdit(textEdit);
			textFileChange.setTextType(getURI().fileExtension());
			return textFileChange;
		}

		public String getOriginalContents() {
			try {
				InputStream inputStream = file.getContents();
				try {
					String charset = (encodingProvider != null) ? encodingProvider.getEncoding(getURI()) : file
							.getCharset();
					InputStreamReader input = new InputStreamReader(inputStream, charset);
					final char[] buffer = new char[4096];
					StringBuilder output = new StringBuilder(4096);
					int read;
					while ((read = input.read(buffer, 0, buffer.length)) != -1) {
						output.append(buffer, 0, read);
					}
					return output.toString();
				} finally {
					inputStream.close();
				}
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		}

	}
}
