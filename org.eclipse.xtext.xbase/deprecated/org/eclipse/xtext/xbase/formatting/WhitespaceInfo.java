/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ILeafNode;

@Deprecated
public class WhitespaceInfo extends LeafInfo {
	private final int offset;

	public int getLength() {
		if (getNode() != null) {
			return getNode().getLength();
		}
		return 0;
	}

	public CommentInfo leadingComment() {
		int i = getContainer().getLeafs().indexOf(this) - 1;
		if (i >= 0) {
			return (CommentInfo) getContainer().getLeafs().get(i);
		}
		return null;
	}

	public CommentInfo trailingComment() {
		int i = getContainer().getLeafs().indexOf(this) + 1;
		if (i < getContainer().getLeafs().size()) {
			return (CommentInfo) getContainer().getLeafs().get(i);
		}
		return null;
	}

	@Override
	public String toString() {
		StringConcatenation builder = new StringConcatenation();
		builder.append("WS: \"");
		if (getNode() != null) {
			builder.append(getNode().getText());
		}
		builder.append("\"");
		builder.newLineIfNotEmpty();
		return builder.toString();
	}

	public WhitespaceInfo(HiddenLeafs container, ILeafNode node, int newLines, int offset) {
		super(container, node, newLines);
		this.offset = offset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + offset;
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
		WhitespaceInfo other = (WhitespaceInfo) obj;
		if (offset != other.offset)
			return false;
		return true;
	}

	public int getOffset() {
		return offset;
	}
}
