/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * @deprecated use {@link ITextRegionAccess}
 */
@Deprecated
public class HiddenLeafAccess {
	@Inject
	private NodeModelAccess nodeModelAccess;

	public HiddenLeafs getHiddenLeafsBefore(INode node) {
		ILeafNode start = nodeModelAccess.findNextLeaf(node, l -> !l.isHidden());
		List<ILeafNode> nodes = this.findPreviousHiddenLeafs(start);
		int offset = 0;
		if (start != null) {
			if (nodes.isEmpty()) {
				offset = start.getOffset();
			} else {
				offset = IterableExtensions.head(nodes).getOffset();
			}
			return newHiddenLeafs(offset, nodes);
		} else {
			if (node != null) {
				offset = node.getOffset();
			}
			return new HiddenLeafs(offset);
		}
	}

	protected HiddenLeafs newHiddenLeafs(int offset, List<ILeafNode> nodes) {
		HiddenLeafs result = new HiddenLeafs(offset);
		boolean trailing = true;
		for (ILeafNode node : nodes) {
			boolean comment = false;
			int newLines = 0;
			if (!Strings.isNullOrEmpty(node.getText())) {
				for (int i = 0; i < node.getText().length(); i++) {
					char c = node.getText().charAt(i);
					if ('\n' == c) {
						newLines = newLines + 1;
					} else if (!Character.isWhitespace(c)) {
						comment = true;
					}
				}
			}
			if (comment) {
				if (!(IterableExtensions.last(result.getLeafs()) instanceof WhitespaceInfo)) {
					result.getLeafs().add(new WhitespaceInfo(result, null, 0, node.getOffset()));
				}
				result.getLeafs().add(new CommentInfo(result, node, newLines, trailing));
			} else {
				result.getLeafs().add(new WhitespaceInfo(result, node, newLines, node.getOffset()));
			}
			if (newLines > 0) {
				trailing = false;
			}
		}
		if (!(IterableExtensions.last(result.getLeafs()) instanceof WhitespaceInfo)) {
			int whitespaceOffset = 0;
			if (result.getLeafs().isEmpty()) {
				whitespaceOffset = offset;
			} else {
				whitespaceOffset = IterableExtensions.last(result.getLeafs()).getNode().getEndOffset();
			}
			result.getLeafs().add(new WhitespaceInfo(result, null, 0, whitespaceOffset));
		}
		return result;
	}

	public HiddenLeafs getHiddenLeafsAfter(INode node) {
		ILeafNode start = findPreviousLeaf(node, l -> !l.isHidden());
		if (start != null) {
			return newHiddenLeafs(start.getEndOffset(), findNextHiddenLeafs(start));
		} else {
			int offset = 0;
			if (node != null) {
				offset = node.getOffset();
			}
			return new HiddenLeafs(offset);
		}
	}

	protected List<ILeafNode> findNextHiddenLeafs(INode node) {
		List<ILeafNode> result = new ArrayList<>();
		NodeIterator ni = new NodeIterator(node);
		while (ni.hasNext()) {
			INode next = ni.next();
			if (next instanceof ILeafNode) {
				if (((ILeafNode) next).isHidden()) {
					result.add((ILeafNode) next);
				} else {
					return result;
				}
			}
		}
		return result;
	}

	protected ILeafNode findPreviousLeaf(INode node, Function1<? super ILeafNode, ? extends Boolean> matches) {
		INode current = node;
		while (current instanceof ICompositeNode) {
			current = ((ICompositeNode) current).getLastChild();
		}
		if (current instanceof ILeafNode && matches.apply((ILeafNode) current)) {
			return (ILeafNode) current;
		}
		if (current != null) {
			NodeIterator ni = new NodeIterator(current);
			while (ni.hasPrevious()) {
				INode previous = ni.previous();
				if (previous instanceof ILeafNode && matches.apply((ILeafNode) previous)) {
					return (ILeafNode) previous;
				}
			}
		}
		return null;
	}

	protected List<ILeafNode> findPreviousHiddenLeafs(INode node) {
		INode current = node;
		while (current instanceof ICompositeNode) {
			current = ((ICompositeNode) current).getLastChild();
		}
		List<ILeafNode> result = new ArrayList<>();
		if (current != null) {
			NodeIterator ni = new NodeIterator(current);
			while (ni.hasPrevious()) {
				INode previous = ni.previous();
				if (!Objects.equal(previous, current) && previous instanceof ILeafNode) {
					if (((ILeafNode) previous).isHidden()) {
						result.add((ILeafNode) previous);
					} else { // if(!result.empty)
						return ListExtensions.reverse(result);
					}
				}
			}
		}
		return ListExtensions.reverse(result);
	}
}
