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
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;

import com.google.common.collect.Sets;

/**
 * An iterator that can traverse a parse tree in forward and backward direction 
 * starting from any element in the tree. Also allows pruning of nodes. 
 * 
 * @author koehnlein - Initial contribution and API
 */
public class NodeIterator implements TreeIterator<AbstractNode> {

	private AbstractNode current;

	private AbstractNode next;

	private Set<CompositeNode> prunedComposites;

	public NodeIterator(AbstractNode node) {
		prunedComposites = Sets.newHashSet();
		current = node;
		next = findNext(node);
	}

	private AbstractNode findPrevious(AbstractNode node) {
		CompositeNode parent = node.getParent();
		if (parent == null) {
			return null;
		}
		List<AbstractNode> siblings = parent.getChildren();
		int index = siblings.indexOf(node);
		if (index > 0) {
			AbstractNode predecessor = siblings.get(index - 1);
			while (predecessor instanceof CompositeNode && !prunedComposites.contains(predecessor)) {
				List<AbstractNode> predecessorChildren = ((CompositeNode) predecessor).getChildren();
				if (predecessorChildren.isEmpty()) {
					return predecessor;
				}
				predecessor = predecessorChildren.get(predecessorChildren.size() - 1);
			}
			return predecessor;
		}
		return parent;
	}

	private AbstractNode findNext(AbstractNode node) {
		if (node instanceof CompositeNode && ! prunedComposites.contains(node)) {
			List<AbstractNode> children = ((CompositeNode) node).getChildren();
			if (!children.isEmpty()) {
				return children.get(0);
			}
		}
		return findNextSibling(node);
	}

	protected AbstractNode findNextSibling(AbstractNode node) {
		CompositeNode parent = node.getParent();
		if (parent == null) {
			return null;
		}
		List<AbstractNode> siblings = parent.getChildren();
		int index = siblings.indexOf(node);
		if (index < siblings.size() - 1) {
			return siblings.get(index + 1);
		}
		return findNextSibling(parent);
	}

	public boolean hasNext() {
		return next != null;
	}

	public AbstractNode next() {
		current = next;
		next = findNext(next);
		return current;
	}

	public boolean hasPrevious() {
		return current != null;
	}

	public AbstractNode previous() {
		next = current;
		current = findPrevious(current);
		return next;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void prune() {
		if (current instanceof CompositeNode) {
			prunedComposites.add((CompositeNode) current);
			next = findNext(current);
		}
	}
}
