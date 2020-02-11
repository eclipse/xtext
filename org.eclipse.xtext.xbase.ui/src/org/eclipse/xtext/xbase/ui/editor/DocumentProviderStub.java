/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IElementStateListener;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DocumentProviderStub implements IDocumentProvider {

	@Override
	public void connect(Object element) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void disconnect(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IDocument getDocument(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void resetDocument(Object element) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void saveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
			throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getModificationStamp(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getSynchronizationStamp(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDeleted(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean mustSaveDocument(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean canSaveDocument(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IAnnotationModel getAnnotationModel(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void aboutToChange(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changed(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addElementStateListener(IElementStateListener listener) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeElementStateListener(IElementStateListener listener) {
		throw new UnsupportedOperationException();
	}

}
