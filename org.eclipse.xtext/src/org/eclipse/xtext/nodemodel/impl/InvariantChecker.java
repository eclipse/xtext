/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Iterator;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public class InvariantChecker {

	public static class InconsistentNodeModelException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public InconsistentNodeModelException(String message, Throwable cause) {
			super(message, cause);
		}

		public InconsistentNodeModelException(String message) {
			super(message);
		}
		
	}
	
	/**
	 * Whether we have already passed an exception.
	 */
	private boolean exceptionSeen;
	
	/**
	 * Assert the invariant of completely build node model.
	 * Checks that every pointer is correct, e.g.
	 * <ul>
	 *   <li>a parent points to its first child,</li> 
	 *   <li>siblings point to the very same parent,</li>
	 *   <li>the offset and length data is in sync, and</li>
	 *   <li>no null fields are present (besides some empty first child pointers).</li>
	 * </ul>
	 * @param node an arbitrary node of the complete node model that should be checked.
	 * @throws InconsistentNodeModelException if the node is part of an inconsistent node tree.
	 */
	public void checkInvariant(INode node) throws InconsistentNodeModelException {
		try {
			doCheckInvariant(node.getRootNode());
		} catch(ClassCastException e) {
			throw new InconsistentNodeModelException("node has no root node", e);
		} catch(NullPointerException e) {
			throw new InconsistentNodeModelException("node's pointer is null", e);
		}
	}

	protected void doCheckInvariant(ICompositeNode rootNode) {
		int length = doCheckChildNodeAndReturnTotalLength(rootNode, null, 0);
		if (length != rootNode.getTotalLength())
			throw new InconsistentNodeModelException("node's computed length differs from actual total length");
	}
	
	protected int doCheckCompositeNodeAndReturnTotalLength(ICompositeNode node, int startsAt) {
		if (node.getTotalOffset() != startsAt)
			throw new InconsistentNodeModelException("node with unexpected offset");
		int length = 0;
		Iterator<AbstractNode> iter = ((CompositeNode) node).basicGetChildren().iterator();
		while(iter.hasNext()) {
			INode child = iter.next();
			length += doCheckChildNodeAndReturnTotalLength(child, node, startsAt + length);
		}
		if (length != node.getTotalLength())
			throw new InconsistentNodeModelException("node's computed length differs from actual total length");
		return length;
	}
	
	protected int doCheckChildNodeAndReturnTotalLength(INode child, ICompositeNode parent, int startsAt) {
		exceptionSeen |= child.getSyntaxErrorMessage() != null;
		if (((AbstractNode) child).basicGetNextSibling().basicGetPreviousSibling() != child)
			throw new InconsistentNodeModelException("child.next.previous != child");
		if (((AbstractNode) child).basicGetPreviousSibling().basicGetNextSibling() != child)
			throw new InconsistentNodeModelException("child.previous.next != child");
		if (((AbstractNode) child).basicGetPreviousSibling().basicGetParent() != ((AbstractNode) child).basicGetParent())
			throw new InconsistentNodeModelException("child.previous.parent != child.parent");
		if (((AbstractNode) child).basicGetNextSibling().basicGetParent() != ((AbstractNode) child).basicGetParent())
			throw new InconsistentNodeModelException("child.next.parent != child.parent");
		if (((AbstractNode) child).basicGetParent() != parent) {
			throw new InconsistentNodeModelException("node does not point to its parent");
		}
		if (child instanceof ILeafNode) {
			if (child.getGrammarElement() == null) {
				if (!exceptionSeen) {
					throw new InconsistentNodeModelException("leaf node without grammar element");
				}
			}
			return doCheckLeafNodeAndReturnLength((ILeafNode) child, startsAt);
		} else {
			if (child.getGrammarElement() == null) {
				throw new InconsistentNodeModelException("node without grammar element");
			}
			return doCheckCompositeNodeAndReturnTotalLength((ICompositeNode) child, startsAt);
		}
	}
	
	protected int doCheckLeafNodeAndReturnLength(ILeafNode leafNode, int startsAt) {
		if (leafNode.getTotalOffset() != startsAt)
			throw new InconsistentNodeModelException("node with unexpected offset");
		return leafNode.getTotalLength();
	}
	
}
