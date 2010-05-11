/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Lists;

/**
 * Delivers token nodes, comments and whitespaces in the order needed by the
 * {@link AbstractParseTreeConstructor.WsMergerStream}, i.e. whitespaces within token nodes 
 * before or after the token node itself.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class HiddenAndTokenNodeIterator implements Iterator<AbstractNode> {

	private TokenUtil tokenUtil;

	private NodeIterator nodeIterator;

	private Queue<AbstractNode> nextNodes = Lists.newLinkedList();

	private AbstractNode next;

	public HiddenAndTokenNodeIterator(AbstractNode startNode, TokenUtil tokenUtil) {
		this.nodeIterator = new NodeIterator(startNode);
		this.tokenUtil = tokenUtil;
		this.next = findNext();
	}

	private AbstractNode findNext() {
		if (nextNodes.isEmpty()) {
			while (nodeIterator.hasNext()) {
				AbstractNode candidate = nodeIterator.next();
				if (tokenUtil.isToken(candidate)) {
					nodeIterator.prune();
					Pair<List<LeafNode>, List<LeafNode>> leadingAndTrailingHiddenTokens = tokenUtil
							.getLeadingAndTrailingHiddenTokens(candidate);
					nextNodes.addAll(leadingAndTrailingHiddenTokens.getFirst());
					nextNodes.add(candidate);
					nextNodes.addAll(leadingAndTrailingHiddenTokens.getSecond());
					return nextNodes.poll();
				} else if (tokenUtil.isWhitespaceOrCommentNode(candidate)) {
					return candidate;
				}
			}
			return null;
		}
		return nextNodes.poll();
	}

	public boolean hasNext() {
		return next != null;
	}

	public AbstractNode next() {
		AbstractNode result = next;
		next = findNext();
		return result;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
