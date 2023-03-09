/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.text.edits.UndoEdit;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Copied and adapted {@link DocumentChange}.
 * 
 * The original implementation relies on the {@link ITextFileBuffer} API. Xtext doesn't and the fallback implementation
 * in {@link DocumentChange} will always yield an invalid thread access error.
 * 
 * In addition, we need a way to combine editor saving with document changes, as there is no way to tell JDT to save our
 * editors after a combined Xtext/JDT refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EditorDocumentChange extends TextChange {

	private long modificationStamp = -1l;

	private boolean doSave;

	private ITextEditor editor;
	
	private IDocument document;

	public EditorDocumentChange(String name, ITextEditor editor, boolean doSave) {
		super(name);
		this.editor = editor;
		this.doSave = doSave;
		this.document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
	}

	@Override
	public Object getModifiedElement() {
		return document;
	}
	
	public ITextEditor getEditor() {
		return editor;
	}
	
	public boolean isDoSave() {
		return doSave;
	}
	
	public void setDoSave(boolean doSave) {
		this.doSave = doSave;
	}
	
	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		if (document instanceof IDocumentExtension4)
			modificationStamp = ((IDocumentExtension4) document).getModificationStamp();
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException {
		RefactoringStatus refactoringStatus = new RefactoringStatus();
		if(document instanceof IDocumentExtension4 
				&& ((IDocumentExtension4) document).getModificationStamp() != modificationStamp)
			refactoringStatus.addFatalError("The content of the document has changed.");
		return refactoringStatus;
	}

	@Override
	protected IDocument acquireDocument(IProgressMonitor pm) throws CoreException {
		return document;
	}

	@Override
	protected void commit(IDocument document, IProgressMonitor pm) throws CoreException {
		if(doSave) 
			editor.doSave(pm);
	}

	@Override
	protected void releaseDocument(IDocument document, IProgressMonitor pm) throws CoreException {
	}
		
	@Override
	protected Change createUndoChange(UndoEdit edit) {
		return new EditorDocumentUndoChange(getName(), editor, edit, doSave);
	}
	
}