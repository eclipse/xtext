/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.NoSuchElementException;

import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeListIterator extends UnmodifiableIterator<INode> implements BidiIterator<INode>{

	private final AbstractNode startWith;
	private AbstractNode lastReturned;

	protected NodeListIterator(AbstractNode startWith) {
		this.startWith = startWith;
	}

	public boolean hasNext() {
		return lastReturned == null || lastReturned.getNext() != lastReturned.getParent().getFirstChild();
	}

	public INode next() {
		if (!hasNext())
			throw new NoSuchElementException();
		if (lastReturned == null) {
			lastReturned = startWith;
		} else {
			lastReturned = lastReturned.getNext();
		}
		return lastReturned;
	}

	public boolean hasPrevious() {
		return lastReturned == null || lastReturned != lastReturned.getParent().getFirstChild();
	}

	public INode previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		if (lastReturned == null) {
			lastReturned = startWith.getPrevious();
		} else {
			lastReturned = lastReturned.getPrevious();
		}
		return lastReturned;
	}
	
}
