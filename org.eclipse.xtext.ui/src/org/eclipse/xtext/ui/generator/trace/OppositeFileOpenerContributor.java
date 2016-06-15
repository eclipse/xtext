/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class OppositeFileOpenerContributor {
	private final static Logger LOG = Logger.getLogger(OpenOppositeFileHandler.class);

	public abstract boolean collectGeneratedFileOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor);

	public abstract boolean collectSourceFileOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor);

	protected ITextRegion getSelectedRegion(IEditorPart editor) {
		if (editor instanceof ITextEditor) {
			ISelection selection = ((ITextEditor) editor).getSelectionProvider().getSelection();
			if (selection instanceof ITextSelection) {
				ITextSelection textSelection = (ITextSelection) selection;
				return new TextRegion(textSelection.getOffset(), textSelection.getLength());
			}
		}
		return null;
	}

	protected IStorage getStorage(IEditorPart editor) {
		try {
			if (editor.getEditorInput() instanceof IStorageEditorInput)
				return ((IStorageEditorInput) editor.getEditorInput()).getStorage();
			return null;
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}

	protected StorageBasedTextEditorOpener createOpener(IStorage storage) {
		return new StorageBasedTextEditorOpener(storage);
	}

}
