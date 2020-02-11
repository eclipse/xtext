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
import java.util.Objects;

import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeIterator extends UnmodifiableIterator<INode> implements BidiIterator<INode>{

	private final INode startWith;
	private INode lastReturned;

	public NodeIterator(INode startWith) {
		Objects.requireNonNull(startWith);
		this.startWith = startWith;
	}

	@Override
	public boolean hasNext() {
		return lastReturned == null || lastReturned.hasNextSibling();
	}

	@Override
	public INode next() {
		if (!hasNext())
			throw new NoSuchElementException();
		if (lastReturned == null) {
			lastReturned = startWith;
		} else {
			lastReturned = lastReturned.getNextSibling();
		}
		return lastReturned;
	}

	@Override
	public boolean hasPrevious() {
		return lastReturned == null || lastReturned.hasPreviousSibling();
	}

	@Override
	public INode previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		if (lastReturned == null) {
			if (startWith.getParent() != null) {
				lastReturned = startWith.getParent().getLastChild();
			} else {
				lastReturned = startWith;
			}
		} else {
			lastReturned = lastReturned.getPreviousSibling();
		}
		return lastReturned;
	}
	
}
