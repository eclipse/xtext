/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.internal.core.refactoring.Changes;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.UndoEdit;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

/**
 * The reverse of an {@link EditorDocumentChange}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EditorDocumentUndoChange extends Change {

	private static final Logger LOG = Logger.getLogger(EditorDocumentUndoChange.class);
	
	private String name;
	private UndoEdit undoEdit;
	private String editorID;
	private IEditorInput editorInput;
	private IWorkbenchPage page;
	private boolean doSave;

	public EditorDocumentUndoChange(String name, ITextEditor editor, UndoEdit undoEdit, boolean doSave) {
		this.name = name;
		IWorkbenchPartSite site = editor.getSite();
		this.page = site.getPage();
		this.editorID = site.getId();
		this.editorInput = editor.getEditorInput();
		this.undoEdit = undoEdit;
		this.doSave = doSave;
	}

	@Override
	public String getName() {
		return name;
	}

	protected ITextEditor getEditor() {
		try {
			IEditorPart editor = page.findEditor(editorInput);
			if(editor != null && editor.getSite().getId() == editorID)
				return (ITextEditor) editor;
			else 
				return (ITextEditor) page.openEditor(editorInput, editorID);
		} catch(Exception exc) {
			LOG.error("Error restoring editor", exc);
			return null;
		}
	}
	
	@Override
	public Object getModifiedElement() {
		return null;
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException {
		return new RefactoringStatus();
	}

	@Override
	public Change perform(final IProgressMonitor pm) throws CoreException {
		return new DisplayRunnableWithResult<Change>() {
			@Override
			protected Change run() throws Exception {
				pm.beginTask("", 3); //$NON-NLS-1$
				IDocument document= null;

				try {
					document= acquireDocument(new SubProgressMonitor(pm, 1));
					UndoEdit undo= performEdits(document);
					commit(document, new SubProgressMonitor(pm, 1));
					return createUndoChange(undo);
				} catch (BadLocationException e) {
					throw Changes.asCoreException(e);
				} catch (MalformedTreeException e) {
					throw Changes.asCoreException(e);
				} finally {
					releaseDocument(document, new SubProgressMonitor(pm, 1));
					pm.done();
				}
			}
		}.syncExec();
	}

	protected UndoEdit performEdits(IDocument document) throws BadLocationException, MalformedTreeException {
		DocumentRewriteSession session= null;
		try {
			if (document instanceof IDocumentExtension4) {
				session= ((IDocumentExtension4)document).startRewriteSession(
					DocumentRewriteSessionType.UNRESTRICTED);
			}
			return undoEdit.apply(document);
		} finally {
			if (session != null) {
				((IDocumentExtension4)document).stopRewriteSession(session);
			}
		}
	}

	protected IDocument acquireDocument(final IProgressMonitor pm) {
		return new DisplayRunnableWithResult<IDocument>() {
			@Override
			protected IDocument run() throws Exception {
				ITextEditor editor = getEditor();
				return editor != null ? editor.getDocumentProvider().getDocument(editorInput) : null;
			}
		}.syncExec();
	}

	protected void commit(IDocument document, IProgressMonitor pm) throws CoreException {
		if (doSave)
			getEditor().doSave(pm);
	}

	protected void releaseDocument(IDocument document, IProgressMonitor pm) throws CoreException {
	}

	protected Change createUndoChange(UndoEdit edit) {
		return new EditorDocumentUndoChange(getName(), getEditor(), edit, doSave);
	}

}
