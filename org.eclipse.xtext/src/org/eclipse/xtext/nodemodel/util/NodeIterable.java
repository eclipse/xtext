/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.Objects;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeIterable implements BidiIterable<INode> {
	
	private final INode startWith;

	public NodeIterable(INode startWith) {
		Objects.requireNonNull(startWith);
		this.startWith = startWith;
	}

	@Override
	public BidiIterator<INode> iterator() {
		return new NodeIterator(startWith);
	}
	
	@Override
	public BidiIterable<INode> reverse() {
		return new ReversedBidiIterable<INode>(this);
	}
}