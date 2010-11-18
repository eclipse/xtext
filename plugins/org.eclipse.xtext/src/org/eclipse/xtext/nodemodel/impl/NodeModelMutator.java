/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelMutator {

	public void addChild(ICompositeNode node, AbstractNode child) {
		if ((INode.ROOT & node.getNodeType()) != 0) {
			RootNode root = (RootNode) node;
			if (root.getFirstChild() == null) {
				checkValidNewChild(child);
				root.basicSetFirstChild(child);
				initializeFirstChildInvariant(node, child);
			} else {
				addPrevious(root.getFirstChild(), child);
			}
		} else {
			CompositeNode composite = (CompositeNode) node;
			if (composite.getFirstChild() == null) {
				checkValidNewChild(child);
				composite.basicSetFirstChild(child);
				initializeFirstChildInvariant(node, child);
			} else {
				addPrevious(composite.getFirstChild(), child);
			}
		}
	}

	protected void initializeFirstChildInvariant(ICompositeNode node, AbstractNode child) {
		child.basicSetParent(node);
		child.basicSetNext(child);
		child.basicSetPrevious(child);
	}

	protected void checkValidNewChild(AbstractNode child) {
		if (child == null)
			throw new IllegalArgumentException("child may not be null");
		if (child.getNext() != null || child.getPrevious() != null)
			throw new IllegalStateException("prev has already a next or prev");
	}
	
	public void addPrevious(AbstractNode node, AbstractNode prev) {
		checkValidNewChild(prev);
		prev.basicSetPrevious(node.getPrevious());
		prev.basicSetParent(node.getParent());
		prev.basicSetNext(node);
		if (node.getPrevious() != null) {
			node.getPrevious().basicSetNext(prev);
		}
		node.basicSetPrevious(prev);
	}
	
	public void addNext(AbstractNode node, AbstractNode next) {
		checkValidNewChild(next);
		next.basicSetNext(node.getNext());
		next.basicSetParent(node.getParent());
		next.basicSetNext(node);
		if (node.getNext() != null) {
			node.getNext().basicSetNext(next);
		}
		node.basicSetNext(next);
	}
	
	
}
