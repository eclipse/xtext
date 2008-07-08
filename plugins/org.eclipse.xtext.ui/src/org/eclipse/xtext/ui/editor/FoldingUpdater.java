/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent;
import org.eclipse.xtext.ui.service.IFoldingStructureProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class FoldingUpdater {

	/**
	 * @author Dennis Hübner - Initial contribution and API
	 * 
	 */
	private class InternalListener implements IXtextEditorModelListener {

		public void modelChanged(XtextEditorModelChangeEvent event) {
			foldingStructureProvider.updateFoldingStructure(model, viewer);
		}

	}

	private IXtextEditorModelListener editorModelListener;
	private IEditorModel model;
	private final IFoldingStructureProvider foldingStructureProvider;
	private ProjectionViewer viewer;

	/**
	 * Creates new FoldingUpdater user should call bind() to connect Editor
	 * model with an Annotation model and unbind() to disconnect.
	 */
	public FoldingUpdater(IFoldingStructureProvider foldingStructureProvider) {
		Assert.isLegal(foldingStructureProvider != null);
		this.foldingStructureProvider = foldingStructureProvider;
		this.editorModelListener = new InternalListener();
	}

	/**
	 * Binds Editor model with Annotation model contained in ProjectionViewer
	 * 
	 * @param model
	 * @param viewer
	 */
	public void bind(IEditorModel model, ProjectionViewer viewer) {
		Assert.isLegal(model != null);
		Assert.isLegal(viewer != null);
		Assert.isLegal(viewer.getAnnotationModel() != null);
		Assert.isLegal(viewer.getDocument() != null);
		this.model = model;
		this.viewer = viewer;
		this.foldingStructureProvider.updateFoldingStructure(model, viewer);
		this.model.addModelListener(editorModelListener);
	}

	/**
	 * Unbinds Editor model and Annotation model
	 */
	public void unbind() {
		if (model != null)
			model.removeModelListener(editorModelListener);
	}

}
