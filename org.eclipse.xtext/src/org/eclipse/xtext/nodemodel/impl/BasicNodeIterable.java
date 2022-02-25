/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Objects;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.util.ReversedBidiIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public class BasicNodeIterable implements BidiIterable<AbstractNode> {
	private final AbstractNode startWith;

	protected BasicNodeIterable(AbstractNode startWith) {
		Objects.requireNonNull(startWith);
		this.startWith = startWith;
	}

	@Override
	public BidiIterator<AbstractNode> iterator() {
		return new BasicNodeIterator(startWith);
	}
	
	@Override
	public BidiIterable<AbstractNode> reverse() {
		return new BidiIterable<AbstractNode>() {

			@Override
			public BidiIterator<AbstractNode> iterator() {
				BidiIterator<AbstractNode> delegate = BasicNodeIterable.this.iterator(); 
				return new ReversedBidiIterator<AbstractNode>(delegate);
			}

			@Override
			public BidiIterable<AbstractNode> reverse() {
				return BasicNodeIterable.this;
			}
		};
	}
}