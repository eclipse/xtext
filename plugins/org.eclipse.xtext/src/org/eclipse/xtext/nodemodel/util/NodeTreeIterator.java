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
	private INode lastNextReturned;
	private INode lastPreviousReturned;
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

		if (lastNextReturned == null) {
			next = lastPreviousReturned != null ? lastPreviousReturned : root;
		} else if (!pruned && lastNextReturned instanceof ICompositeNode && ((ICompositeNode) lastNextReturned).hasChildren()) {
			next = ((ICompositeNode) lastNextReturned).getFirstChild();
		} else if (lastNextReturned == root) {
			next = null;
		} else if ((next = lastNextReturned.getNextSibling()) != null) {
			// next found
		} else {
			for (INode parent = lastNextReturned.getParent(); next == null && parent != root; parent = parent.getParent()) {
				next = parent.getNextSibling();
			}
		}
		nextComputed = true;
		return next != null;
	}

	public INode next() {
		if (next == null && !hasNext())
			throw new NoSuchElementException();
		lastNextReturned = next;
		lastPreviousReturned = null;
		afterAdvance();
		return lastNextReturned;
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

		if (lastPreviousReturned == null) {
			previous = lastNextReturned != null ? lastNextReturned : root;
		} else if (!pruned && lastPreviousReturned instanceof ICompositeNode && ((ICompositeNode) lastPreviousReturned).hasChildren()) {
			previous = ((ICompositeNode) lastPreviousReturned).getLastChild();
		} else if (lastPreviousReturned == root) {
			previous = null;
		} else if ((previous = lastPreviousReturned.getPreviousSibling()) != null) {
			// previous found
		} else {
			for (INode parent = lastPreviousReturned.getParent(); previous == null && parent != root; parent = parent.getParent()) {
				previous = parent.getPreviousSibling();
			}
		}
		previousComputed = true;
		return previous != null;
	}

	public INode previous() {
		if (previous == null && !hasPrevious())
			throw new NoSuchElementException();
		lastPreviousReturned = previous;
		lastNextReturned = null;
		afterAdvance();
		return lastPreviousReturned;
	}
	
	public void prune() {
		if (lastPreviousReturned == null && lastNextReturned == null)
			throw new IllegalStateException("Cannot prune before #next or #previous");
		pruned = true;
	}
	
}
