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
public class CommentInfo extends LeafInfo {
	private final boolean trailing;

	public boolean endsWithNewLine() {
		return getNode().getText().endsWith("\n");
	}

	public boolean isMultiline() {
		return !endsWithNewLine() && getNode().getText().contains("\n");
	}

	@Override
	public String toString() {
		StringConcatenation builder = new StringConcatenation();
		builder.append("Comment: \"");
		builder.append(getNode().getText());
		builder.append("\"");
		builder.newLineIfNotEmpty();
		return builder.toString();
	}

	public CommentInfo(HiddenLeafs container, ILeafNode node, int newLines, boolean trailing) {
		super(container, node, newLines);
		this.trailing = trailing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (trailing ? 1231 : 1237);
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
		CommentInfo other = (CommentInfo) obj;
		if (trailing != other.trailing)
			return false;
		return true;
	}

	public boolean isTrailing() {
		return trailing;
	}
}
