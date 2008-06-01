/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.xtext.ui.core.editor.BaseTextEditor;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextEditorModelReconcileStrategy implements IReconcilingStrategy {

	private final BaseTextEditor editor;

	public XtextEditorModelReconcileStrategy(BaseTextEditor editor) {
		this.editor = editor;
	}

	private void internalReconcile() {
		XtextEditorModel model = editor.getModel();
		if (model != null) {
			model.reconcile();
		}
	}

	public void reconcile(IRegion partition) {
		internalReconcile();
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		internalReconcile();
	}

	public void setDocument(IDocument document) {
	}

}
