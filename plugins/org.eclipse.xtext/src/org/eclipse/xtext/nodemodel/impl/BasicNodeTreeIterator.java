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

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public class BasicNodeTreeIterator extends UnmodifiableIterator<AbstractNode> implements BidiTreeIterator<AbstractNode>{

	private final AbstractNode root;
	private AbstractNode lastReturned;
	private AbstractNode next;
	private boolean nextComputed = false;
	private boolean pruned = false;
	private AbstractNode previous;
	private boolean previousComputed = false;
	
	protected BasicNodeTreeIterator(AbstractNode root) {
		this.root = root;
	}

	public boolean hasNext() {
		if (nextComputed)
			return next != null;
		if (lastReturned == null) {
			next = root;
		} else if (!pruned && lastReturned instanceof CompositeNode && ((CompositeNode) lastReturned).basicGetFirstChild() != null) {
			next = ((CompositeNode) lastReturned).basicGetFirstChild();
		} else if (lastReturned != root && lastReturned.basicHasNextSibling()) {
			next = lastReturned.basicGetNextSibling();
		} else if (lastReturned != root) {
			CompositeNode parent = lastReturned.basicGetParent();
			while (next == null && parent != root && parent.basicGetParent() != null) {
				if (parent.basicHasNextSibling()) {
					next = parent.basicGetNextSibling();
				} else {
					parent = parent.basicGetParent();
				}
			}
		}
		nextComputed = true;
		return next != null;
	}

	public AbstractNode next() {
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
		} else if (!pruned && lastReturned instanceof CompositeNode && ((CompositeNode) lastReturned).basicGetFirstChild() != null) {
			previous = ((CompositeNode) lastReturned).basicGetLastChild();
		} else if (lastReturned != root && lastReturned.basicHasPreviousSibling()) {
			previous = lastReturned.basicGetPreviousSibling();
		} else if (lastReturned != root) {
			CompositeNode parent = lastReturned.basicGetParent();
			while (previous == null && parent != root && parent.basicGetParent() != null) {
				if (parent.basicHasPreviousSibling()) {
					previous = parent.basicGetPreviousSibling();
				} else {
					parent = parent.basicGetParent();
				}
			}
		}
		previousComputed = true;
		return previous != null;
	}

	public AbstractNode previous() {
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
