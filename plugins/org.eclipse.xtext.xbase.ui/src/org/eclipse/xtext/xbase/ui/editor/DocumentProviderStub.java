/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	public void connect(Object element) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public void disconnect(Object element) {
		throw new UnsupportedOperationException();
	}

	public IDocument getDocument(Object element) {
		throw new UnsupportedOperationException();
	}

	public void resetDocument(Object element) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public void saveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
			throws CoreException {
		throw new UnsupportedOperationException();
	}

	public long getModificationStamp(Object element) {
		throw new UnsupportedOperationException();
	}

	public long getSynchronizationStamp(Object element) {
		throw new UnsupportedOperationException();
	}

	public boolean isDeleted(Object element) {
		throw new UnsupportedOperationException();
	}

	public boolean mustSaveDocument(Object element) {
		throw new UnsupportedOperationException();
	}

	public boolean canSaveDocument(Object element) {
		throw new UnsupportedOperationException();
	}

	public IAnnotationModel getAnnotationModel(Object element) {
		throw new UnsupportedOperationException();
	}

	public void aboutToChange(Object element) {
		throw new UnsupportedOperationException();
	}

	public void changed(Object element) {
		throw new UnsupportedOperationException();
	}

	public void addElementStateListener(IElementStateListener listener) {
		throw new UnsupportedOperationException();
	}

	public void removeElementStateListener(IElementStateListener listener) {
		throw new UnsupportedOperationException();
	}

}
