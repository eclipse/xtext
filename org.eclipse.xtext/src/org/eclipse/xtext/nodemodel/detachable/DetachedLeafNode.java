/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.util.Objects;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.ForwardingLeafNode;

/**
 * @since 2.35
 */
public class DetachedLeafNode extends ForwardingLeafNode {
	
	private final AbstractDetachableParseResult<?, ?> parseResult;
	private final int id;

	public DetachedLeafNode(AbstractDetachableParseResult<?, ?> parseResult, int id) {
		this.parseResult = parseResult;
		this.id = id;
	}
	
	@Override
	protected ILeafNode delegate() {
		return parseResult.getLeafNode(id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, parseResult);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetachedLeafNode other = (DetachedLeafNode) obj;
		return id == other.id && Objects.equals(parseResult, other.parseResult);
	}
}
