/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	@Override
	public boolean hasNext() {
		if (nextComputed)
			return next != null;

		if (lastNextReturned == null) {
			next = lastPreviousReturned != null ? lastPreviousReturned : root;
		} else if (!pruned && lastNextReturned instanceof ICompositeNode && ((ICompositeNode) lastNextReturned).hasChildren()) {
			next = ((ICompositeNode) lastNextReturned).getFirstChild();
		} else if (root.equals(lastNextReturned)) {
			next = null;
		} else if ((next = lastNextReturned.getNextSibling()) != null) {
			// next found
		} else {
			for (INode parent = lastNextReturned.getParent(); next == null && !root.equals(parent); parent = parent.getParent()) {
				next = parent.getNextSibling();
			}
		}
		nextComputed = true;
		return next != null;
	}

	@Override
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

	@Override
	public boolean hasPrevious() {
		if (previousComputed)
			return previous != null;

		if (lastPreviousReturned == null) {
			previous = lastNextReturned != null ? lastNextReturned : root;
		} else if (!pruned && lastPreviousReturned instanceof ICompositeNode && ((ICompositeNode) lastPreviousReturned).hasChildren()) {
			previous = ((ICompositeNode) lastPreviousReturned).getLastChild();
		} else if (root.equals(lastPreviousReturned)) {
			previous = null;
		} else if ((previous = lastPreviousReturned.getPreviousSibling()) != null) {
			// previous found
		} else {
			for (INode parent = lastPreviousReturned.getParent(); previous == null && !root.equals(parent); parent = parent.getParent()) {
				previous = parent.getPreviousSibling();
			}
		}
		previousComputed = true;
		return previous != null;
	}

	@Override
	public INode previous() {
		if (previous == null && !hasPrevious())
			throw new NoSuchElementException();
		lastPreviousReturned = previous;
		lastNextReturned = null;
		afterAdvance();
		return lastPreviousReturned;
	}
	
	@Override
	public void prune() {
		if (lastPreviousReturned == null && lastNextReturned == null)
			throw new IllegalStateException("Cannot prune before #next or #previous");
		pruned = true;
	}
	
}
