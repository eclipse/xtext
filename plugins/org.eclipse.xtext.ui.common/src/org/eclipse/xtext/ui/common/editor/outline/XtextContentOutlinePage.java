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
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.StatefulService;
import org.eclipse.xtext.ui.core.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

/**
 * An outline page for Xtext based editors.
 * 
 * @author Peter Friese - Initial contribution and API
 */
@StatefulService
public class XtextContentOutlinePage extends ContentOutlinePage implements IContentOutlinePage, ISourceViewerAware {

	static final Logger logger = Logger.getLogger(XtextContentOutlinePage.class);
	private ISourceViewer sourceViewer;

	public XtextContentOutlinePage() {
		logger.debug("Creating content outline page. Outline instance [" + this.toString() + "]");
	}

	private void configureDocument() {
		if (sourceViewer != null) {
			IDocument document = sourceViewer.getDocument();
			IXtextDocument xtextDocument = XtextDocumentUtil.get(document);
			xtextDocument.addModelListener(new IXtextModelListener() {
				public void modelChanged(XtextResource resource) {
					logger.debug("Document has been changed. Triggering update of outline.");
					runInSWTThread(new Runnable() {
						public void run() {
							TreeViewer viewer = getTreeViewer();
							viewer.refresh();
						}
					});
				}
			});
			internalSetInput(xtextDocument);
		}
	}

	private void configureProviders() {
		TreeViewer viewer = getTreeViewer();
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		XtextContentOutlineProvider provider = new XtextContentOutlineProvider(composedAdapterFactory);
		viewer.setContentProvider(provider);
		viewer.setLabelProvider(provider);
	}

	private void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(3);
		viewer.setUseHashlookup(true);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		configureViewer();
		configureProviders();
		configureDocument();
	}

	private void internalSetInput(IXtextDocument xtextDocument) {
		if (getTreeViewer() != null) {
			getTreeViewer().setInput(xtextDocument);
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
		} else {
			runnable.run();
		}
	}

	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
	}

}
