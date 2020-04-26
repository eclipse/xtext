/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Deprecated
public abstract class LeafInfo {
	private final HiddenLeafs container;

	private final ILeafNode node;

	private final int newLines;

	public LeafInfo(HiddenLeafs container, ILeafNode node, int newLines) {
		this.container = container;
		this.node = node;
		this.newLines = newLines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((container == null) ? 0 : container.hashCode());
		result = prime * result + newLines;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeafInfo other = (LeafInfo) obj;
		if (container == null) {
			if (other.container != null)
				return false;
		} else if (!container.equals(other.container))
			return false;
		if (newLines != other.newLines)
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("container", container);
		b.add("node", node);
		b.add("newLines", newLines);
		return b.toString();
	}

	public HiddenLeafs getContainer() {
		return container;
	}

	public ILeafNode getNode() {
		return node;
	}

	public int getNewLines() {
		return newLines;
	}
}
