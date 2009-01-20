/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.StatefulService;
import org.eclipse.xtext.ui.core.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

/**
 * @author Peter Friese - Initial contribution and API
 */
@StatefulService
public class XtextContentOutlinePage extends LazyVirtualContentOutlinePage implements ISourceViewerAware {

	static final Logger logger = Logger.getLogger(XtextContentOutlinePage.class);

	private ISourceViewer sourceViewer;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		configureViewer();
		configureProviders();
		configureDocument();
	}

	private void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(2);
	}

	private void configureProviders() {
		getTreeViewer().setContentProvider(new LazyTransformingTreeProvider());
		getTreeViewer().setLabelProvider(new LazyTransformingTreeProvider());
	}

	private void configureDocument() {
		if (sourceViewer != null) {
			IDocument document = sourceViewer.getDocument();
			IXtextDocument xtextDocument = XtextDocumentUtil.get(document);
			xtextDocument.addModelListener(new IXtextModelListener() {
				public void modelChanged(XtextResource resource) {
					if (logger.isDebugEnabled())
						logger.debug("Document has been changed. Triggering update of outline.");
					runInSWTThread(new Runnable() {
						public void run() {
							TreeViewer viewer = getTreeViewer();
							IDocument document = sourceViewer.getDocument();
							internalSetInput(XtextDocumentUtil.get(document));
							viewer.refresh();
						}
					});
				}
			});
			internalSetInput(xtextDocument);
		}
	}

	/**
	 * Runs the runnable in the SWT thread. (Simply runs the runnable if the
	 * current thread is the UI thread, otherwise calls the runnable in
	 * asyncexec.)
	 */
	public void runInSWTThread(Runnable runnable) {
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(runnable);
		}
		else {
			runnable.run();
		}
	}

	private void internalSetInput(IXtextDocument xtextDocument) {
		TreeViewer tree = getTreeViewer();
		if (tree != null) {
			Object[] expandedElements = tree.getExpandedElements();
			tree.setInput(xtextDocument);
			tree.setExpandedElements(expandedElements);
		}
	}

	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
	}

}
