/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.NoSuchElementException;

import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeTreeIterator extends UnmodifiableIterator<INode> implements BidiTreeIterator<INode>{

	private final AbstractNode root;
	private AbstractNode lastReturned;
	private AbstractNode next;
	private boolean nextComputed = false;
	private boolean pruned = false;
	private AbstractNode previous;
	private boolean previousComputed = false;
	
	protected NodeTreeIterator(AbstractNode root) {
		this.root = root;
	}

	public boolean hasNext() {
		if (nextComputed)
			return next != null;
		if (lastReturned == null) {
			next = root;
		} else if (!pruned && lastReturned instanceof CompositeNode && ((CompositeNode) lastReturned).hasChildren()) {
			next = ((CompositeNode) lastReturned).getFirstChild();
		} else if (lastReturned.getNext() != lastReturned.getParent().getFirstChild()) {
			next = lastReturned.getNext();
		} else {
			AbstractNode parent = lastReturned.getParent();
			while (next == null && parent != root) {
				if (parent.getNext() != parent.getParent().getFirstChild()) {
					next = parent.getNext();
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
		} else if (!pruned && lastReturned instanceof CompositeNode && ((CompositeNode) lastReturned).hasChildren()) {
			previous = ((CompositeNode) lastReturned).getLastChild();
		} else if (lastReturned.getPrevious() != lastReturned.getParent().getLastChild()) {
			previous = lastReturned.getPrevious();
		} else {
			AbstractNode parent = lastReturned.getParent();
			while (previous == null && parent != root) {
				if (parent.getPrevious() != parent.getParent().getLastChild()) {
					previous = parent.getPrevious();
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
