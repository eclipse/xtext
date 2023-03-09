/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SemanticNodeIterator implements Iterator<Triple<INode, AbstractElement, EObject>> {

	protected Triple<INode, AbstractElement, EObject> next;

	public SemanticNodeIterator(EObject obj) {
		INode start = NodeModelUtils.findActualNodeFor(obj);
		if (start != null) {
			this.next = findNext(start, false);
			while (this.next != null && this.next.getThird() == obj)
				this.next = findNext(this.next.getFirst(), false);
		} else
			this.next = null;
	}

	public SemanticNodeIterator(INode start) {
		this.next = start != null ? findNext(start, true) : null;
	}

	protected Triple<INode, AbstractElement, EObject> findNext(INode node, boolean prune) {
		INode current = next(node, prune);
		while (current != null) {
			if (current instanceof ILeafNode && ((ILeafNode) current).isHidden()) {
				current = next(current, true);
				continue;
			}
			EObject ge = current.getGrammarElement();
			if (ge instanceof AbstractElement && isEObjectNode(current))
				return Tuples.create(current, (AbstractElement) ge, getEObjectNodeEObject(current));
			else if (GrammarUtil.isAssigned(ge) && !GrammarUtil.isEObjectRuleCall(ge)) {
				if (ge instanceof CrossReference)
					return Tuples.create(current, ((CrossReference) ge).getTerminal(), null);
				else
					return Tuples.create(current, (AbstractElement) ge, null);
			} else
				current = next(current, false);
		}
		return null;
	}

	protected EObject getEObjectNodeEObject(INode node) {
		if (node.hasDirectSemanticElement())
			return node.getSemanticElement();
		Iterator<INode> i = node.getAsTreeIterable().iterator();
		while (i.hasNext()) {
			INode n = i.next();
			if (n.hasDirectSemanticElement())
				return n.getSemanticElement();
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	protected boolean isEObjectNode(INode node) {
		if (node.getGrammarElement() instanceof AbstractRule)
			return true;
		if (node.getGrammarElement() instanceof Action)
			return true;
		if (GrammarUtil.isAssignedEObjectRuleCall(node.getGrammarElement())) {
			if (node.hasDirectSemanticElement())
				return true;
			AbstractRule rule = ((RuleCall) node.getGrammarElement()).getRule();
			node = node.getParent();
			while (node != null) {
				if (GrammarUtil.isAssigned(node.getGrammarElement()))
					return true;
				if (node.getGrammarElement() instanceof Action
						&& GrammarUtil.containingRule(node.getGrammarElement()) == rule)
					return false;
				node = node.getParent();
			}
			return true;
		}
		return false;
	}

	@Override
	public Triple<INode, AbstractElement, EObject> next() {
		Triple<INode, AbstractElement, EObject> oldNext = next;
		if (next != null)
			next = findNext(next.getFirst(), true);
		return oldNext;
	}

	protected INode next(INode node, boolean prune) {
		if (!prune && node instanceof ICompositeNode) {
			INode child = ((ICompositeNode) node).getFirstChild();
			if (child != null)
				return child;
		}
		INode n = node.getNextSibling();
		while (n == null) {
			node = node.getParent();
			if (node == null || isEObjectNode(node))
				return null;
			n = node.getNextSibling();
		}
		return n;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
