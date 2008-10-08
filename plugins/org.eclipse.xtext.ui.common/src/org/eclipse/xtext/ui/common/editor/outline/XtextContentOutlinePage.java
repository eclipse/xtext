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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

/**
 * An outline page for Xtext based editors.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public class XtextContentOutlinePage extends ContentOutlinePage implements IContentOutlinePage, ISourceViewerAware {

	private static final Logger logger = Logger.getLogger(XtextContentOutlinePage.class);
	private ISourceViewer sourceViewer;

	public XtextContentOutlinePage() {
		logger.debug("Creating content outline page. Outline instance [" + this.toString() + "]");
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		configureViewer();
		configureProviders();
		configureDocument();
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
			internalSetInput(document);
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

	private void internalSetInput(IDocument document) {
		if (getTreeViewer() != null) {
			getTreeViewer().setInput(document);
		}
	}

	private void configureViewer() {
		TreeViewer viewer = getTreeViewer();
		viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
		viewer.setUseHashlookup(true);
	}

	private void configureProviders() {
		TreeViewer viewer = getTreeViewer();
		XtextContentOutlineProvider outlineProvider = new XtextContentOutlineProvider();
		viewer.setContentProvider(outlineProvider);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(new ReflectiveItemProviderAdapterFactory()));
	}

	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
	}

	private class XtextContentOutlineProvider implements ITreeContentProvider {

		private final Object[] EMPTY_ARRAY = new Object[0];

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof EObject) {
				EObject obj = (EObject) parentElement;

				EList<EObject> contents = obj.eContents();
				EObject[] array = contents.toArray(new EObject[contents.size()]);
				return array;
			}
			return EMPTY_ARRAY;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof EObject) {
				EObject obj = (EObject) element;
				return (obj.eContents().size() > 0);
			}
			return false;
		}

		public Object[] getElements(Object inputElement) {
			IXtextDocument xtextDocument = XtextDocumentUtil.get(inputElement);
			Object[] result = xtextDocument.readOnly(new UnitOfWork<Object[]>() {
				public Object[] exec(XtextResource resource) throws Exception {
					EObject root = resource.getParseResult().getRootASTElement();
					return root != null ? new Object[] { root } : new Object[] {};
				}
			});
			return result;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			logger.debug("Outline input has changed.");
		}

	}

}
