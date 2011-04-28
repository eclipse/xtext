/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * An iterator that can traverse a parse tree in forward and backward direction 
 * starting from any element in the tree. Also allows pruning of nodes. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NodeIterator implements TreeIterator<INode> {

	private INode current;

	private INode next;

	private Set<ICompositeNode> prunedComposites;

	public NodeIterator(INode node) {
		prunedComposites = Sets.newHashSet();
		current = node;
		next = findNext(node);
	}

	private INode findPrevious(INode node) {
		ICompositeNode parent = node.getParent();
		if (parent == null) {
			return null;
		}
		List<INode> siblings = Lists.newArrayList(parent.getChildren());
		int index = siblings.indexOf(node);
		if (index > 0) {
			INode predecessor = siblings.get(index - 1);
			while (predecessor instanceof ICompositeNode && !prunedComposites.contains(predecessor)) {
				List<INode> predecessorChildren = Lists.newArrayList(((ICompositeNode) predecessor).getChildren());
				if (predecessorChildren.isEmpty()) {
					return predecessor;
				}
				predecessor = predecessorChildren.get(predecessorChildren.size() - 1);
			}
			return predecessor;
		}
		return parent;
	}

	private INode findNext(INode node) {
		if (node instanceof ICompositeNode && ! prunedComposites.contains(node)) {
			List<INode> children = Lists.newArrayList(((ICompositeNode) node).getChildren());
			if (!children.isEmpty()) {
				return children.get(0);
			}
		}
		return findNextSibling(node);
	}

	protected INode findNextSibling(INode node) {
		ICompositeNode parent = node.getParent();
		if (parent == null) {
			return null;
		}
		List<INode> siblings = Lists.newArrayList(parent.getChildren());
		int index = siblings.indexOf(node);
		if (index < siblings.size() - 1) {
			return siblings.get(index + 1);
		}
		return findNextSibling(parent);
	}

	public boolean hasNext() {
		return next != null;
	}

	public INode next() {
		current = next;
		next = findNext(next);
		return current;
	}

	public boolean hasPrevious() {
		return current != null;
	}

	public INode previous() {
		next = current;
		current = findPrevious(current);
		return next;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void prune() {
		if (current instanceof ICompositeNode) {
			prunedComposites.add((ICompositeNode) current);
			next = findNext(current);
		}
	}
}
