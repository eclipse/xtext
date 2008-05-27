/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.core.editor.XtextModelManager.ParseError;
import org.eclipse.xtext.ui.core.internal.XtextMarkerManager;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

	private IDocument document;
	private IProgressMonitor monitor;
	private XtextModelManager manager;
	private IEditorPart editor;

	public XtextReconcilingStrategy(XtextModelManager manager, IEditorPart resource) {
		this.manager = manager;
		this.editor = resource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.
	 * eclipse.jface.text.IRegion)
	 */
	public void reconcile(IRegion partition) {
		IResource resource = (IResource) editor.getEditorInput().getAdapter(IFile.class);
		XtextMarkerManager.clearXtextMarker(resource, monitor);
		if (manager.hasErrors()) {
			for (ParseError error : manager.getErrors()) {
				XtextMarkerManager.createMarker(resource, collectMarkerAttributes(error), monitor);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.
	 * eclipse.jface.text.reconciler.DirtyRegion,
	 * org.eclipse.jface.text.IRegion)
	 */
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(dirtyRegion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.reconciler.IReconcilingStrategy#setDocument(org
	 * .eclipse.jface.text.IDocument)
	 */
	public void setDocument(IDocument document) {
		Assert.isLegal(document != null);
		this.document = document;
	}

	public void initialReconcile() {
		reconcile(new Region(0, document.getLength()));
	}

	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	private Map<String, Object> collectMarkerAttributes(ParseError error) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
		if (error.getNode() != null) {
			map.put(IMarker.LINE_NUMBER, new Integer(error.line()));
			map.put(IMarker.CHAR_START, new Integer(error.offset()));
			map.put(IMarker.CHAR_END, new Integer(error.offset() + error.length()));
		}
		map.put(IMarker.MESSAGE, error.getMessage());
		map.put(IMarker.PRIORITY, new Integer(IMarker.PRIORITY_LOW));

		return map;

	}

}
