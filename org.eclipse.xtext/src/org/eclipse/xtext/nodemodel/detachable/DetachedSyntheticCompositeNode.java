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

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;

/**
 * @since 2.35
 */
public class DetachedSyntheticCompositeNode extends DetachedCompositeNode {
	
	private final int grammarElementIdx;

	public DetachedSyntheticCompositeNode(AbstractDetachableParseResult<?, ?> parseResult, int id, int grammarElementIdx) {
		super(parseResult, id);
		this.grammarElementIdx = grammarElementIdx;
	}
	
	@Override
	protected ICompositeNode delegate() {
		return new SyntheticCompositeNode((CompositeNode) super.delegate(), grammarElementIdx);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(grammarElementIdx);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetachedSyntheticCompositeNode other = (DetachedSyntheticCompositeNode) obj;
		return grammarElementIdx == other.grammarElementIdx;
	}
	
}
