/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;

import com.google.inject.internal.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelUtils {

	public static ILeafNode findLeafNodeAtOffset(INode node, int leafNodeOffset) {
		int offset = node.getTotalOffset();
		int length = node.getTotalLength();
		BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) node).basicTreeIterator();
		if (leafNodeOffset > (offset + length) / 2) {
			while(iterator.hasPrevious()) {
				AbstractNode previous = iterator.previous();
				int previousOffset = previous.getTotalOffset();
				int previousLength = previous.getTotalLength();
				if (!intersects(previousOffset, previousLength, leafNodeOffset)) {
					if (previousOffset + previousLength <= leafNodeOffset) {
						return null;
					}
					iterator.prune();
				} else {
					if (previous instanceof ILeafNode)
						return (ILeafNode) previous;
				}
			}
		} else {
			while(iterator.hasNext()) {
				AbstractNode next = iterator.next();
				int nextOffset = next.getTotalOffset();
				int nextLength = next.getTotalLength();
				if (!intersects(nextOffset, nextLength, leafNodeOffset)) {
					if (nextOffset > leafNodeOffset) {
						return null;
					}
					iterator.prune();
				} else {
					if (next instanceof ILeafNode)
						return (ILeafNode) next;
				}
			}
		}
		return null;
	}
	
	private static boolean intersects(int offset, int length, int lookupOffset) {
		if (offset <= lookupOffset && offset + length > lookupOffset)
			return true;
		return false;
	}

	public static ICompositeNode getNode(EObject object) {
		for(Adapter adapter: object.eAdapters()) {
			if (adapter instanceof ICompositeNode)
				return (ICompositeNode) adapter;
		}
		return null;
	}
	
	public static List<INode> findNodesForFeature(EObject semanticElement, EStructuralFeature structuralFeature) {
		ICompositeNode node = getNode(semanticElement);
		if (node != null) {
			return findNodesForFeature(semanticElement, node, structuralFeature);
		}
		return Collections.emptyList();
	}

	private static List<INode> findNodesForFeature(EObject semanticElement, INode node,
			EStructuralFeature structuralFeature) {
		List<INode> result = Lists.newArrayList();
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement != null) { // error node?
			Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
			if (assignment != null && assignment.getFeature().equals(structuralFeature.getName())) {
				result.add(node);
			} else {
				if (node instanceof ICompositeNode) {
					EObject nodeSemanticElement = node.getSemanticElement();
					if (semanticElement.equals(nodeSemanticElement)) {
						ICompositeNode composite = (ICompositeNode) node;
						// check whether it's the same element
						for (INode child : composite.getChildren()) {
							result.addAll(findNodesForFeature(semanticElement, child, structuralFeature));
						}
					}
				}
			}
		}
		return result;
	}
	
	public static final INode getLastCompleteNodeByOffset(INode node, int offsetPosition) {
		BidiTreeIterator<INode> iterator = node.getRootNode().treeIterator();
		INode result = null;
		while (iterator.hasNext()) {
			INode candidate = iterator.next();
			if (candidate.getOffset() >= offsetPosition ) {
				break;
			} else if ((candidate instanceof ILeafNode || null == result) &&
					   (candidate.getGrammarElement() == null ||
							   candidate.getGrammarElement() instanceof AbstractElement ||
							   candidate.getGrammarElement() instanceof ParserRule)) {
				result = candidate;
			}
		}
		return result;
	}
	
}
