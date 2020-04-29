/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.collect.Iterables;

@Deprecated
public class HiddenLeafs {
	private final int offset;

	private final List<LeafInfo> leafs = new ArrayList<>();

	public boolean isSingleWhitespace() {
		return leafs.isEmpty() || leafs.size() == 1 && Iterables.getFirst(leafs, null) instanceof WhitespaceInfo;
	}

	public int getLenght() {
		return IterableExtensions.fold(leafs, 0, (x, i) -> {
			int length = 0;
			if (i.getNode() != null) {
				length = i.getNode().getLength();
			}
			return x + length;
		});
	}

	public int getNewLines() {
		return IterableExtensions.fold(leafs, 0, (x, i) -> x + i.getNewLines());
	}

	public int getNewLinesInComments() {
		return IterableExtensions.fold(Iterables.filter(leafs, CommentInfo.class), 0,
				(x, i) -> x + i.getNewLines());
	}

	public boolean containsComment() {
		return IterableExtensions.size(Iterables.filter(leafs, CommentInfo.class)) > 0;
	}

	public HiddenLeafs(int offset) {
		this.offset = offset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((leafs == null) ? 0 : leafs.hashCode());
		result = prime * result + offset;
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
		HiddenLeafs other = (HiddenLeafs) obj;
		if (leafs == null) {
			if (other.leafs != null)
				return false;
		} else if (!leafs.equals(other.leafs))
			return false;
		if (offset != other.offset)
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("offset", offset);
		b.add("leafs", leafs);
		return b.toString();
	}

	public int getOffset() {
		return offset;
	}

	public List<LeafInfo> getLeafs() {
		return leafs;
	}
}
