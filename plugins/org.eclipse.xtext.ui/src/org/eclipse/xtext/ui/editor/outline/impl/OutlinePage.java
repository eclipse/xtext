/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collection;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.actions.ToggleLinkWithEditorAction;
import org.eclipse.xtext.ui.editor.outline.actions.ToggleSortingAction;
import org.eclipse.xtext.ui.util.DisplayRunHelper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutlinePage extends ContentOutlinePage implements ISourceViewerAware {

	private static final Logger LOG = Logger.getLogger(OutlinePage.class);

	@Inject
	private OutlineNodeLabelProvider labelProvider;

	@Inject
	private OutlineNodeContentProvider contentProvider;

	@Inject
	private IOutlineTreeProvider treeProvider;

	@Inject
	private ToggleLinkWithEditorAction linkWithEditorAction;
	
	@Inject 
	private ToggleSortingAction sortingAction;

	private IXtextModelListener modelListener;

	private IXtextDocument xtextDocument;

	private ISourceViewer sourceViewer;

	@Inject
	private OutlineRefreshJob refreshJob;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		configureTree();
		configureModelListener();
		configureActions();
		refreshJob.setOutlinePage(this);
	}

	protected void configureTree() {
		TreeViewer treeViewer = getTreeViewer();
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setUseHashlookup(true);
		IOutlineNode rootNode = xtextDocument.readOnly(new IUnitOfWork<IOutlineNode, XtextResource>() {
			public IOutlineNode exec(XtextResource resource) throws Exception {
				IOutlineNode rootNode = treeProvider.createRoot(xtextDocument);
				// precompute visible root nodes
				rootNode.getChildren();
				return rootNode;
			}
		});
		refreshViewer(rootNode, Collections.singleton(rootNode), Collections.<IOutlineNode> emptySet());
	}

	protected void configureModelListener() {
		modelListener = new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				try {
					scheduleRefresh();
				} catch (Throwable t) {
					LOG.error("Error refreshing outline", t);
				}
			}

		};
		xtextDocument.addModelListener(modelListener);
	}

	protected void configureActions() {
		IToolBarManager toolBarManager = getSite().getActionBars().getToolBarManager();
		toolBarManager.add(linkWithEditorAction);
		toolBarManager.add(sortingAction);
		linkWithEditorAction.activate(this);
		sortingAction.activate(this);
	}

	@Override
	public void dispose() {
		sortingAction.deactivate();
		linkWithEditorAction.deactivate();
		xtextDocument.removeModelListener(modelListener);
		contentProvider.dispose();
		super.dispose();
	}

	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer;
		IDocument document = sourceViewer.getDocument();
		xtextDocument = XtextDocumentUtil.get(document);
	}
	
	public ISourceViewer getSourceViewer() {
		return sourceViewer;
	}

	public IXtextDocument getXtextDocument() {
		return xtextDocument;
	}

	public void scheduleRefresh() {
		refreshJob.cancel();
		refreshJob.schedule();
	}

	@Override
	public TreeViewer getTreeViewer() {
		return super.getTreeViewer();
	}

	public IOutlineTreeProvider getTreeProvider() {
		return treeProvider;
	}

	protected void refreshViewer(final IOutlineNode rootNode, final Collection<IOutlineNode> nodesToBeExpanded,
			final Collection<IOutlineNode> selectedNodes) {
		DisplayRunHelper.runAsyncInDisplayThread(new Runnable() {
			public void run() {
				try {
					TreeViewer treeViewer = getTreeViewer();
					treeViewer.setInput(rootNode);
					treeViewer.expandToLevel(1);
					treeViewer.setExpandedElements(Iterables.toArray(nodesToBeExpanded, IOutlineNode.class));
					treeViewer.setSelection(new StructuredSelection(Iterables
							.toArray(selectedNodes, IOutlineNode.class)));
				} catch (Throwable t) {
					LOG.error("Error refreshing outline", t);
				}
			}
		});
	}

}
