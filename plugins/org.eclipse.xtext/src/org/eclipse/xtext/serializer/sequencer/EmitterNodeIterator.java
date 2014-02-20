/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmitterNodeIterator implements Iterator<INode> {

	protected NodeIterator iterator;
	protected List<INode> next = Lists.newArrayList();
	protected int end;
	protected boolean passAbsorber;
	protected boolean allowHidden;

	public EmitterNodeIterator(INode fromNode) {
		this(fromNode, null, true, false);
	}

	public EmitterNodeIterator(INode fromNode, INode toNode, boolean passAbsorber, boolean allowHidden) {
		if (fromNode != null) {
			this.iterator = new NodeIterator(fromNode);
			this.passAbsorber = passAbsorber;
			if (toNode != null) {
				if (toNode.getOffset() < fromNode.getOffset())
					this.end = toNode.getOffset() + toNode.getLength();
				else
					this.end = toNode.getOffset();
			} else
				this.end = Integer.MAX_VALUE;
			this.allowHidden = allowHidden;
			next();
		}
	}

	public boolean hasNext() {
		return !next.isEmpty();
	}

	protected boolean include(INode node) {
		if (node instanceof ILeafNode) {
			ILeafNode leaf = (ILeafNode) node;
			if (!allowHidden && leaf.isHidden())
				return false;
			return true;
		} else if (node instanceof ICompositeNode) {
			return GrammarUtil.isDatatypeRuleCall(node.getGrammarElement())
					|| node.getGrammarElement() instanceof CrossReference;
		}
		return false;
	}

	protected boolean isAbsorber(INode node) {
		return node.getGrammarElement() != null && GrammarUtil.isAssigned(node.getGrammarElement());
	}

	public INode next() {
		INode result;
		if (!next.isEmpty()) {
			result = next.get(0);
			next.remove(0);
		} else
			result = null;
		if (next.isEmpty())
			while (iterator.hasNext()) {
				INode next = iterator.next();
				if (next.getOffset() >= end)
					break;
				if (include(next)) {
					if (!passAbsorber && isAbsorber(next))
						break;
					if (allowHidden
							&& next instanceof ICompositeNode
							&& (GrammarUtil.isDatatypeRuleCall(next.getGrammarElement())
									|| GrammarUtil.isEnumRuleCall(next.getGrammarElement()) || next.getGrammarElement() instanceof CrossReference)) {
						NodeIterator ni = new NodeIterator(next);
						while (ni.hasNext()) {
							INode next2 = ni.next();
							if (next2 instanceof ILeafNode && ((ILeafNode) next2).isHidden())
								this.next.add(next2);
							else
								break;
						}
					}
					iterator.prune();
					this.next.add(next);
					return result;
				}
			}
		return result;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
