/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.refactoring.IChangeRedirector;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.internal.Nullable;

import com.google.inject.Inject;

/**
 * Unifies the creation of {@link Change}s from {@link TextEdit}s on {@link IFile}s and {@link IDocument}s.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultRefactoringDocumentProvider implements IRefactoringDocument.Provider, IChangeRedirector.Aware {

	@Inject(optional = true)
	@Nullable
	private IWorkbench workbench;

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private RefactoringPreferences preferences;
	
	private IChangeRedirector changeRedirector = IChangeRedirector.NULL;
	
	protected IFileEditorInput getEditorInput(URI resourceURI, StatusWrapper status) {
		IFile file = projectUtil.findFileStorage(resourceURI, true);
		if (file == null) {
			status.add(ERROR, "No suitable storage found for resource {0}.", resourceURI);
			return null;
		}
		return new FileEditorInput(file);
	}

	@Override
	public IRefactoringDocument get(URI uri, final StatusWrapper status) {
		URI resourceURI = uri.trimFragment();
		final IFileEditorInput fileEditorInput = getEditorInput(resourceURI, status);
		if (fileEditorInput != null) {
			IFile file = fileEditorInput.getFile();
			IPath redirectedPath = changeRedirector.getRedirectedPath(file.getFullPath());
			IFile redirectedFile = file.getWorkspace().getRoot().getFile(redirectedPath);
			if(redirectedFile.equals(file)) {
				if (workbench != null) {
					ITextEditor editor = new DisplayRunnableWithResult<ITextEditor>() {
						@Override
						protected ITextEditor run() throws Exception {
							IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
							IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
							ITextEditor editor = Adapters.adapt(activePage.findEditor(fileEditorInput), ITextEditor.class);
							if (editor != null) {
								if (editor instanceof ITextEditorExtension && ((ITextEditorExtension) editor).isEditorInputReadOnly())
									status.add(ERROR, "Editor for {0} is read only", fileEditorInput.getName());
								return (editor);
							}
							return null;
						}
					}.syncExec();
					if (editor != null) {
						IDocument document = editor.getDocumentProvider().getDocument(fileEditorInput);
						if (document != null)
							return new EditorDocument(resourceURI, editor, document, 
									preferences.isSaveAllBeforeRefactoring() || !editor.isDirty());
					}
				}
				return new FileDocument(resourceURI, file, getEncodingProvider(resourceURI));
			} else {
				return new RedirectedFileDocument(resourceURI, file, redirectedFile, getEncodingProvider(resourceURI));
			}
		}
		return null;
	}

	protected IEncodingProvider getEncodingProvider(URI resourceURI) {
		return globalServiceProvider.findService(
				resourceURI, IEncodingProvider.class);
	}

	@Override
	public IChangeRedirector getChangeRedirector() {
		return changeRedirector;
	}
	
	@Override
	public void setChangeRedirector(IChangeRedirector changeRedirector) {
		this.changeRedirector  = changeRedirector;
	}

	public static abstract class AbstractRefactoringDocument implements IRefactoringDocument {
		private URI resourceURI;

		public AbstractRefactoringDocument(URI resourceURI) {
			this.resourceURI = resourceURI;
		}

		@Override
		public abstract Change createChange(String name, TextEdit textEdit);

		@Override
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
		
		private ITextEditor editor;

		private boolean doSave;

		public EditorDocument(URI resourceURI, ITextEditor editor, IDocument document, boolean doSave) {
			super(resourceURI);
			this.editor = editor;
			this.document = document;
			this.doSave = doSave;
		}

		public ITextEditor getEditor() {
			return editor;
		}

		public IDocument getDocument() {
			return document;
		}
		
		public boolean isDoSave() {
			return doSave;
		}

		@Override
		public Change createChange(String name, TextEdit textEdit) {
			EditorDocumentChange documentChange = new EditorDocumentChange(getName(), editor, doSave);
			documentChange.setEdit(textEdit);
			documentChange.setTextType(getURI().fileExtension());
			return documentChange;
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

		@Override
		public String getOriginalContents() {
			return document.get();
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

		@Override
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
	
	public static class RedirectedFileDocument extends FileDocument {

		private IFile redirectedFile;

		public RedirectedFileDocument(URI resourceURI, IFile file, IFile redirectedFile, 
				IEncodingProvider encodingProvider) {
			super(resourceURI, file, encodingProvider);
			this.redirectedFile = redirectedFile;
		}
		
		@Override
		public Change createChange(String name, TextEdit textEdit) {
			TextFileChange textFileChange = new TextFileChange(name, redirectedFile);
			textFileChange.setSaveMode(TextFileChange.FORCE_SAVE);
			textFileChange.setEdit(textEdit);
			textFileChange.setTextType(getURI().fileExtension());
			return textFileChange;
		}
	}

}
