/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Iterator;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmitterNodeIterator implements Iterator<INode> {

	protected NodeIterator iterator;
	protected INode next;
	protected INode end;
	protected boolean passAbsorber;

	public EmitterNodeIterator(INode fromNode) {
		this(fromNode, null, true);
	}

	public EmitterNodeIterator(INode fromNode, INode toNode, boolean passAbsorber) {
		if (fromNode != null) {
			this.iterator = new NodeIterator(fromNode);
			this.passAbsorber = passAbsorber;
			this.end = toNode;
			next();
		}
	}

	public boolean hasNext() {
		return next != null;
	}

	protected boolean include(INode node) {
		if (node instanceof ILeafNode) {
			ILeafNode leaf = (ILeafNode) node;
			if (leaf.isHidden())
				return false;
			return true;
		} else if (node instanceof ICompositeNode) {
			return GrammarUtil.isDatatypeRuleCall(node.getGrammarElement())
					|| node.getGrammarElement() instanceof CrossReference;
		}
		return false;
	}

	protected boolean isAbsorber(INode node) {
		return GrammarUtil.isAssigned(node.getGrammarElement())
		/*|| GrammarUtil.isAssignedAction(node.getGrammarElement())*/;
	}

	public INode next() {
		INode result = this.next;
		while (iterator.hasNext()) {
			INode next = iterator.next();
			if (end == next)
				break;
			if (include(next)) {
				if (!passAbsorber && isAbsorber(next))
					break;
				iterator.prune();
				this.next = next;
				return result;
			}
		}
		this.next = null;
		return result;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
