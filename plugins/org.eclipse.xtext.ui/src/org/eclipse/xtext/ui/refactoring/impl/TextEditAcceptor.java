/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.UndoEdit;
import org.eclipse.xtext.ui.refactoring.fixes.UndoDocumentChange;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author koehnlein - Initial contribution and API
 */
public class TextEditAcceptor {

	private Multimap<RefactoringDocument, TextEdit> doc2edits = HashMultimap.create();

	public void accept(RefactoringDocument document, TextEdit textEdit) {
		doc2edits.put(document, textEdit);
	}

	public Change getChange(String name) {
		CompositeChange compositeChange = new CompositeChange(name);
		for (RefactoringDocument document : doc2edits.keySet()) {
			TextChange textChange = createTextChange(name, document);
			compositeChange.add(textChange);
		}
		return new DisplayChangeWrapper(compositeChange);
	}

	protected TextChange createTextChange(String name, RefactoringDocument document) {
		TextChange documentChange;
		if (document.isOpenEditor())
			documentChange = new DocumentChange(name, document.getXtextDocument()) {
				/**
				 * Fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=296794
				 */
				@Override
				protected Change createUndoChange(UndoEdit edit) {
					return new UndoDocumentChange(getName(), (IDocument) getModifiedElement(), edit);
				}
			};
		else
			documentChange = new TextFileChange(name, document.getFileToSave());
		MultiTextEdit multiEdit = new MultiTextEdit();
		documentChange.setEdit(multiEdit);
		for (TextEdit edit : doc2edits.get(document)) {
			documentChange.addEdit(edit);
		}
		return documentChange;
	}

	protected class DisplayChangeWrapper extends Change {

		private Change delegate;

		public DisplayChangeWrapper(Change delegate) {
			this.delegate = delegate;
		}

		@Override
		public ChangeDescriptor getDescriptor() {
			return delegate.getDescriptor();
		}

		@Override
		public String getName() {
			return delegate.getName();
		}

		@Override
		public void setEnabled(boolean enabled) {
			delegate.setEnabled(enabled);
		}

		@Override
		public Change getParent() {
			return delegate.getParent();
		}

		@Override
		public void dispose() {
			delegate.dispose();
		}

		@Override
		public boolean equals(Object obj) {
			return delegate.equals(obj);
		}

		@Override
		public Object getModifiedElement() {
			return delegate.getModifiedElement();
		}

		@Override
		public Object[] getAffectedObjects() {
			return delegate.getAffectedObjects();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Object getAdapter(Class adapter) {
			return delegate.getAdapter(adapter);
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}

		@Override
		public boolean isEnabled() {
			return delegate.isEnabled();
		}

		@Override
		public void initializeValidationData(IProgressMonitor pm) {
			delegate.initializeValidationData(pm);
		}

		@Override
		public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
			return delegate.isValid(pm);
		}

		@Override
		public Change perform(final IProgressMonitor pm) throws CoreException {
			Change undoChange = new DisplayRunnableWithResult<Change>() {
				@Override
				protected Change run() throws Exception {
					return delegate.perform(pm);
				}
			}.syncExec();
			return new DisplayChangeWrapper(undoChange);
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

	}

}
