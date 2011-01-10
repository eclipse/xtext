/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.util.DisplayRunHelper;

import com.google.common.collect.Sets;

/**
 * Either stores the expansion/selection of a tree viewer or aggregates the new expansion/selection state.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineTreeState {

	private static final Logger LOG = Logger.getLogger(OutlineTreeState.class);

	private Set<IOutlineNode> expandedNodes;
	private Set<IOutlineNode> selectedNodes;

	public OutlineTreeState(TreeViewer treeViewer) {
		expandedNodes = Collections.unmodifiableSet(getExpandedNodes(treeViewer));
		selectedNodes = Collections.unmodifiableSet(getSelectedNodes(treeViewer));
	}

	public OutlineTreeState() {
		expandedNodes = Sets.newHashSet();
		selectedNodes = Sets.newHashSet();
	}

	protected Set<IOutlineNode> getExpandedNodes(final TreeViewer treeViewer) {
		final Set<IOutlineNode> expandedNodes = Sets.newHashSet();
		DisplayRunHelper.runSyncInDisplayThread(new Runnable() {
			public void run() {
				if (!treeViewer.getTree().isDisposed()) {
					Object[] expandedElements = treeViewer.getExpandedElements();
					for (Object expandedElement : expandedElements) {
						if (!(expandedElement instanceof IOutlineNode))
							LOG.error("Content outline contains illegal node " + expandedElement);
						else
							expandedNodes.add((IOutlineNode) expandedElement);
					}
				}
			}
		});
		return expandedNodes;
	}

	protected Set<IOutlineNode> getSelectedNodes(final TreeViewer treeViewer) {
		DisplayRunHelper.runSyncInDisplayThread(new Runnable() {
			public void run() {
				selectedNodes = Sets.newHashSet();
				ISelection selection = treeViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					for (Iterator<?> selectionIter = ((IStructuredSelection) selection).iterator(); selectionIter
							.hasNext();) {
						Object selectedElement = selectionIter.next();
						if (!(selectedElement instanceof IOutlineNode))
							LOG.error("Content outline contains illegal node " + selectedElement);
						else
							selectedNodes.add((IOutlineNode) selectedElement);
					}
				}
			}
		});
		return selectedNodes;
	}

	public Set<IOutlineNode> getSelectedNodes() {
		return selectedNodes;
	}

	public Set<IOutlineNode> getExpandedNodes() {
		return expandedNodes;
	}

	public boolean addExpandedNode(IOutlineNode node) {
		if (expandedNodes.contains(node))
			return false;
		return expandedNodes.add(node);
	}

	public boolean addSelectedNode(IOutlineNode node) {
		if (selectedNodes.contains(node))
			return false;
		return selectedNodes.add(node);
	}

}
