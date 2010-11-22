/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.NoSuchElementException;

import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeTreeIterator extends UnmodifiableIterator<INode> implements BidiTreeIterator<INode>{

	private final INode root;
	private INode lastReturned;
	private INode next;
	private boolean nextComputed = false;
	private boolean pruned = false;
	private INode previous;
	private boolean previousComputed = false;
	
	public NodeTreeIterator(INode root) {
		this.root = root;
	}

	public boolean hasNext() {
		if (nextComputed)
			return next != null;
		if (lastReturned == null) {
			next = root;
		} else if (!pruned && lastReturned instanceof ICompositeNode && ((ICompositeNode) lastReturned).hasChildren()) {
			next = ((ICompositeNode) lastReturned).getFirstChild();
		} else if (lastReturned.hasNextSibling()) {
			next = lastReturned.getNextSibling();
		} else {
			ICompositeNode parent = lastReturned.getParent();
			while (next == null && parent != root && parent.getParent() != null) {
				if (parent.hasNextSibling()) {
					next = parent.getNextSibling();
				} else {
					parent = parent.getParent();
				}
			}
		}
		nextComputed = true;
		return next != null;
	}

	public INode next() {
		if (!hasNext())
			throw new NoSuchElementException();
		lastReturned = next;
		afterAdvance();
		return lastReturned;
	}

	protected void afterAdvance() {
		next = null;
		previous = null;
		nextComputed = false;
		previousComputed = false;
		pruned = false;
	}

	public boolean hasPrevious() {
		if (previousComputed)
			return previous != null;
		if (lastReturned == null) {
			previous = root;
		} else if (!pruned && lastReturned instanceof ICompositeNode && ((ICompositeNode) lastReturned).hasChildren()) {
			previous = ((ICompositeNode) lastReturned).getLastChild();
		} else if (lastReturned.hasPreviousSibling()) {
			previous = lastReturned.getPreviousSibling();
		} else {
			ICompositeNode parent = lastReturned.getParent();
			while (previous == null && parent != root && parent.getParent() != null) {
				if (parent.hasPreviousSibling()) {
					previous = parent.getPreviousSibling();
				} else {
					parent = parent.getParent();
				}
			}
		}
		previousComputed = true;
		return previous != null;
	}

	public INode previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		lastReturned = previous;
		afterAdvance();
		return lastReturned;
	}
	
	public void prune() {
		if (lastReturned == null)
			throw new IllegalStateException("Cannot prune before #next or #previous");
		pruned = true;
	}
	
}
