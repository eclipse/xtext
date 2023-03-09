/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmitterNodeUtil {

	public static List<INode> collectEmitterNodes(INode from, INode to) {
		List<INode> actual = collectEmitterNodesInternal(from, to);
		// helpful code to test this implementation
		// List<INode> expected = Lists.newArrayList(new
		// EmitterNodeIterator(from, to, false, false));
		// if (!expected.equals(actual))
		// throw new IllegalStateException();
		return actual;
	}

	private static List<INode> collectEmitterNodesInternal(INode from, INode to) {
		if (from == null) {
			return Collections.emptyList();
		}
		INode current = findNext(from, to);
		List<INode> result = null;
		while (current != null) {
			if (current == to)
				break;
			EObject grammarElement = current.getGrammarElement();
			if (isEmitter(current, grammarElement)) {
				if (isAbsorber(grammarElement))
					break;
				if (result == null) {
					result = Lists.newArrayList();
				}
				result.add(current);
				current = findNextSibling(current, to);
			} else {
				current = findNext(current, to);
			}
		}
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	private static INode findNext(INode node, INode to) {
		if (node instanceof ICompositeNode) {
			INode firstChild = ((ICompositeNode) node).getFirstChild();
			if (firstChild != null) {
				if (firstChild == to) {
					return null;
				}
				return firstChild;
			}
		}
		return findNextSibling(node, to);
	}

	private static INode findNextSibling(INode node, INode to) {
		INode successor = node.getNextSibling();
		if (successor != null) {
			if (successor == to) {
				return null;
			}
			return successor;
		}
		ICompositeNode parent = node.getParent();
		if (parent == null || parent == to) {
			return null;
		}
		return findNextSibling(parent, to);
	}

	private static boolean isAbsorber(EObject grammarElement) {
		return grammarElement != null && GrammarUtil.isAssigned(grammarElement);
	}

	private static boolean isEmitter(INode node, EObject grammarElement) {
		if (node instanceof ILeafNode) {
			ILeafNode leaf = (ILeafNode) node;
			if (leaf.isHidden())
				return false;
			return true;
		} else if (node instanceof ICompositeNode) {
			return GrammarUtil.isDatatypeRuleCall(grammarElement) || grammarElement instanceof CrossReference;
		}
		return false;
	}

}
