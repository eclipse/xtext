/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @since 2.35
 */
public abstract class ForwardingCompositeNode extends ForwardingNode implements ICompositeNode {
	@Override
	protected abstract ICompositeNode delegate();

	@Override
	public BidiIterable<INode> getChildren() {
		return delegate().getChildren();
	}

	@Override
	public boolean hasChildren() {
		return delegate().hasChildren();
	}

	@Override
	public INode getFirstChild() {
		return delegate().getFirstChild();
	}

	@Override
	public INode getLastChild() {
		return delegate().getLastChild();
	}

	@Override
	public int getLookAhead() {
		return delegate().getLookAhead();
	}
	
	
}
