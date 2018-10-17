/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtext.ui.graph.actions.RailroadSelectionLinker;
import org.eclipse.xtext.xtext.ui.graph.trafo.Xtext2RailroadTransformer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Synchronizes the railroad diagram view with the active editor.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class RailroadSynchronizer implements IPartListener, IXtextModelListener {

	@Inject
	private RailroadView view;

	@Inject
	private Xtext2RailroadTransformer transformer;

	@Inject
	private RailroadSelectionLinker selectionLinker;

	private IXtextDocument lastActiveDocument;

	public void start(IWorkbenchPartSite site) {
		updateView(site.getPage().getActiveEditor());
		site.getWorkbenchWindow().getPartService().addPartListener(this);
	}

	public void stop(IWorkbenchPartSite site) {
		site.getWorkbenchWindow().getPartService().removePartListener(this);
		lastActiveDocument = null;
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		updateView(part);
	}

	private void updateView(IWorkbenchPart part) {
		if (part instanceof XtextEditor) {
			XtextEditor xtextEditor = (XtextEditor) part;
			IXtextDocument xtextDocument = xtextEditor.getDocument();
			if (xtextDocument != lastActiveDocument) {
				selectionLinker.setXtextEditor(xtextEditor);
				final IFigure contents = xtextDocument.tryReadOnly(new IUnitOfWork<IFigure, XtextResource>() {
					@Override
					public IFigure exec(XtextResource resource) throws Exception {
						return createFigure(resource);
					}
				});
				if (contents != null) {
					view.setContents(contents);
					if (lastActiveDocument != null) {
						lastActiveDocument.removeModelListener(this);
					}
					lastActiveDocument = xtextDocument;
					lastActiveDocument.addModelListener(this);
				}
			}
		}
	}

	private IFigure createFigure(XtextResource state) {
		EList<EObject> contents = state.getContents();
		if (!contents.isEmpty()) {
			EObject rootObject = contents.get(0);
			return transformer.transform(rootObject);
		}
		return null;
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
	}

	@Override
	public void modelChanged(XtextResource resource) {
		view.setContents(createFigure(resource));
	}

	/**
	 * Deprecated because never used. Will be removed in 3.0.0
	 * 
	 * @return <code>null</code>
	 */
	@Deprecated
	public Font getFont() {
		return null;
	}
}
