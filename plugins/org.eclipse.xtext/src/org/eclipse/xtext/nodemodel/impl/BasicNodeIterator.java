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

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public class BasicNodeIterator extends UnmodifiableIterator<AbstractNode> implements BidiIterator<AbstractNode>{

	private final AbstractNode startWith;
	private AbstractNode lastReturned;

	protected BasicNodeIterator(AbstractNode startWith) {
		this.startWith = startWith;
	}

	@Override
	public boolean hasNext() {
		return lastReturned == null || lastReturned.basicHasNextSibling();
	}

	@Override
	public AbstractNode next() {
		if (!hasNext())
			throw new NoSuchElementException();
		if (lastReturned == null) {
			lastReturned = startWith;
		} else {
			lastReturned = lastReturned.basicGetNextSibling();
		}
		return lastReturned;
	}

	@Override
	public boolean hasPrevious() {
		return lastReturned == null || lastReturned.basicHasPreviousSibling();
	}

	@Override
	public AbstractNode previous() {
		if (!hasPrevious())
			throw new NoSuchElementException();
		if (lastReturned == null) {
			lastReturned = startWith.basicGetPreviousSibling();
		} else {
			lastReturned = lastReturned.basicGetPreviousSibling();
		}
		return lastReturned;
	}
	
}
