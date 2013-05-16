/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class OutlineRefreshJob extends Job {
	
	private OutlinePage outlinePage;
	
	@Inject
	private IOutlineNodeComparer nodeComparer;
	
	public OutlineRefreshJob() {
		super("Refreshing outline");
	}

	public void setOutlinePage(OutlinePage outlinePage) {
		this.outlinePage = outlinePage;
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			OutlineTreeState formerState = new OutlineTreeState(outlinePage.getTreeViewer());
			OutlineTreeState newState = new OutlineTreeState();
			IOutlineNode rootNode = refreshOutlineModel(monitor, formerState, newState);
			if (!monitor.isCanceled())
				outlinePage.refreshViewer(rootNode, newState.getExpandedNodes(), newState.getSelectedNodes());
			return Status.OK_STATUS;
		} catch (Throwable t) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error refreshing outline", t);
		}
	}

	protected IOutlineNode refreshOutlineModel(final IProgressMonitor monitor, final OutlineTreeState formerState,
			final OutlineTreeState newState) {
		final IOutlineTreeProvider treeProvider = outlinePage.getTreeProvider();
		if(treeProvider instanceof BackgroundOutlineTreeProvider) {
			return iternalRefreshOutlineModel(formerState, newState, treeProvider);
		} else {
			return new DisplayRunnableWithResult<IOutlineNode>() {
				@Override
				protected IOutlineNode run() throws Exception {
					return iternalRefreshOutlineModel(formerState, newState, treeProvider);
				}
			}.syncExec();
		}
	}

	/**
	 * @since 2.4
	 */
	protected IOutlineNode iternalRefreshOutlineModel(final OutlineTreeState formerState,
			final OutlineTreeState newState, final IOutlineTreeProvider treeProvider) {
		IOutlineNode rootNode = outlinePage.getXtextDocument().readOnly(new IUnitOfWork<IOutlineNode, XtextResource>() {
			public IOutlineNode exec(XtextResource resource) throws Exception {
				IOutlineNode rootNode = treeProvider.createRoot(outlinePage.getXtextDocument());
				restoreChildrenSelectionAndExpansion(rootNode, resource, formerState, newState);
				return rootNode;
			}
		});
		return rootNode;
	}
	
	protected void restoreChildrenSelectionAndExpansion(IOutlineNode parent, Resource resource, OutlineTreeState formerState, OutlineTreeState newState) {
		List<IOutlineNode> children = parent.getChildren();
		for(IOutlineNode child: children) {
			if(containsUsingComparer(formerState.getExpandedNodes(), child)) {
				restoreChildrenSelectionAndExpansion(child, resource, formerState, newState);
				newState.addExpandedNode(child);
			}
			if(containsUsingComparer(formerState.getSelectedNodes(), child)) {
				newState.addSelectedNode(child);
			}
		}
	}
	
	protected boolean containsUsingComparer(Iterable<IOutlineNode> list, final IOutlineNode node) {
		return Iterables.any(list, new Predicate<IOutlineNode>() {
			public boolean apply(IOutlineNode nodeFromList) {
				return nodeComparer.equals(node, nodeFromList);
			}
		});
	}
}