/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

/**
 * A reconciler strategy that fully resolves a {@link BatchLinkableResource}, i.e. infers the JVM model and resolves all
 * types. This avoids race conditions in model listeners. To get type shadowing right, the {@link DirtyStateEditorSupport} must
 * be triggered with a phase one inferred model before resolving the cross references.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @see XbaseDirtyStateEditorSupport
 * @see XbaseDirtyStateResourceDescription
 */
public class XbaseDocumentReconcileStrategy extends XtextDocumentReconcileStrategy {

	private XtextEditor editor;

	@Override
	public void setEditor(XtextEditor editor) {
		this.editor = editor;
	}

	@Override
	protected void postParse(XtextResource resource, final IProgressMonitor monitor) {
		if (resource instanceof BatchLinkableResource) {
			BatchLinkableResource batchLinkableResource = (BatchLinkableResource) resource;
			CompoundXtextEditorCallback xtextEditorCallback = editor.getXtextEditorCallback();
			DirtyStateEditorSupport dirtyStateEditorSupport = xtextEditorCallback
					.getDirtyStateEditorSupport();
			if (dirtyStateEditorSupport instanceof XbaseDirtyStateEditorSupport)
				((XbaseDirtyStateEditorSupport) dirtyStateEditorSupport).announceDirtyState(batchLinkableResource);
			batchLinkableResource.installDerivedState(false);
			batchLinkableResource.resolveLazyCrossReferences(new CancelIndicator() {
				public boolean isCanceled() {
					return monitor.isCanceled();
				}
			});
		}
	}

	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		super.setSourceViewer(sourceViewer);
	}
}
