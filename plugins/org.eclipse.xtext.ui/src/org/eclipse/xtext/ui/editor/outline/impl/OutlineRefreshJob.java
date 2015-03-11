/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class OutlineRefreshJob extends Job {
	
	private final static Logger LOG = Logger.getLogger(OutlineRefreshJob.class);
	
	private OutlinePage outlinePage;
	
	@Inject
	private IOutlineNodeComparer nodeComparer;
	
	public OutlineRefreshJob() {
		super("Refreshing Outline");
	}

	public void setOutlinePage(OutlinePage outlinePage) {
		this.outlinePage = outlinePage;
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		if (outlinePage == null) {
			return Status.OK_STATUS;
		}
		try {
			OutlineTreeState formerState = new OutlineTreeState(outlinePage.getTreeViewer());
			OutlineTreeState newState = new OutlineTreeState();
			IOutlineNode rootNode = refreshOutlineModel(monitor, formerState, newState);
			if (!monitor.isCanceled())
				outlinePage.refreshViewer(rootNode, newState.getExpandedNodes(), newState.getSelectedNodes());
			else
				return Status.CANCEL_STATUS;
			return Status.OK_STATUS;
		} catch (OperationCanceledException oce) {
			return Status.CANCEL_STATUS;
		} catch (Exception e) {
			LOG.error("Error refreshing outline", e);
			return Status.OK_STATUS;
		}
	}

	protected IOutlineNode refreshOutlineModel(final IProgressMonitor monitor, final OutlineTreeState formerState,
			final OutlineTreeState newState) {
		final IOutlineTreeProvider treeProvider = outlinePage.getTreeProvider();
		if (treeProvider instanceof IOutlineTreeProvider.Background) {
			return internalRefreshOutlineModel(formerState, newState, treeProvider);
		} else {
			return new DisplayRunnableWithResult<IOutlineNode>() {
				@Override
				protected IOutlineNode run() throws Exception {
					return internalRefreshOutlineModel(formerState, newState, treeProvider);
				}
			}.syncExec();
		}
	}

	/**
	 * @since 2.7
	 */
	protected IOutlineNode internalRefreshOutlineModel(final OutlineTreeState formerState,
			final OutlineTreeState newState, final IOutlineTreeProvider treeProvider) {
		IOutlineNode rootNode = outlinePage.getXtextDocument().readOnly(new CancelableUnitOfWork<IOutlineNode, XtextResource>() {
			@Override
			public IOutlineNode exec(XtextResource resource, CancelIndicator cancelIndicator) throws Exception {
				IOutlineNode rootNode = createModel(treeProvider, cancelIndicator);
				restoreChildrenSelectionAndExpansion(rootNode, resource, formerState, newState, cancelIndicator);
				return rootNode;
			}

			private IOutlineNode createModel(final IOutlineTreeProvider treeProvider, CancelIndicator cancelIndicator) {
				if (treeProvider instanceof IOutlineTreeProvider.Cancelable)
					return ((IOutlineTreeProvider.Cancelable) treeProvider).createRoot(
							outlinePage.getXtextDocument(), cancelIndicator);
				else
					return treeProvider.createRoot(outlinePage.getXtextDocument());
			}
		});
		return rootNode;
	}
	
	/**
	 * @deprecated use {@link #restoreChildrenSelectionAndExpansion(IOutlineNode, Resource, OutlineTreeState, OutlineTreeState, CancelIndicator)} instead
	 */
	@Deprecated
	protected void restoreChildrenSelectionAndExpansion(IOutlineNode parent, Resource resource, OutlineTreeState formerState, OutlineTreeState newState) {
		restoreChildrenSelectionAndExpansion(parent, resource, formerState, newState, CancelIndicator.NullImpl);
	}
	
	/**
	 * @since 2.7
	 */
	protected void restoreChildrenSelectionAndExpansion(IOutlineNode parent, Resource resource, OutlineTreeState formerState, OutlineTreeState newState, CancelIndicator cancelIndicator) {
		List<IOutlineNode> children = parent.getChildren();
		for(IOutlineNode child: children) {
			if(cancelIndicator.isCanceled())
				throw new OperationCanceledException();
			if(containsUsingComparer(formerState.getExpandedNodes(), child)) {
				restoreChildrenSelectionAndExpansion(child, resource, formerState, newState, cancelIndicator);
				newState.addExpandedNode(child);
			}
			if(containsUsingComparer(formerState.getSelectedNodes(), child)) {
				newState.addSelectedNode(child);
			}
		}
	}
	
	protected boolean containsUsingComparer(Iterable<IOutlineNode> list, final IOutlineNode node) {
		return Iterables.any(list, new Predicate<IOutlineNode>() {
			@Override
			public boolean apply(IOutlineNode nodeFromList) {
				return nodeComparer.equals(node, nodeFromList);
			}
		});
	}
}