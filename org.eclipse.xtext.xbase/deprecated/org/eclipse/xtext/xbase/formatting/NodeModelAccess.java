/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @deprecated use {@link ITextRegionAccess}
 */
@Deprecated
public class NodeModelAccess {
	public INode nodeForEObject(EObject obj) {
		return NodeModelUtils.findActualNodeFor(obj);
	}

	public ILeafNode nodeForKeyword(EObject obj, String kw) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		return (ILeafNode) IterableExtensions.findFirst(node.getAsTreeIterable(),
				(INode it) -> Objects.equal(it.getSemanticElement(), obj) && it.getGrammarElement() instanceof Keyword
						&& Objects.equal(it.getText(), kw));
	}

	public Iterable<ILeafNode> nodesForKeyword(EObject obj, String kw) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		Iterable<ILeafNode> leafNodes = Iterables.filter(node.getAsTreeIterable(), ILeafNode.class);
		return Iterables.filter(leafNodes, n -> Objects.equal(n.getSemanticElement(), obj)
				&& n.getGrammarElement() instanceof Keyword && Objects.equal(n.getText(), kw));
	}

	public INode nodeForFeature(EObject obj, EStructuralFeature feature) {
		return Iterables.getFirst(NodeModelUtils.findNodesForFeature(obj, feature), null);
	}

	public Iterable<INode> nodesForFeature(EObject obj, EStructuralFeature feature) {
		return NodeModelUtils.findNodesForFeature(obj, feature);
	}

	public ILeafNode immediatelyFollowingKeyword(EObject obj, String kw) {
		return immediatelyFollowingKeyword(nodeForEObject(obj), kw);
	}

	public ILeafNode immediatelyFollowingKeyword(INode node, String kw) {
		INode current = node;
		while (current instanceof ICompositeNode) {
			current = ((ICompositeNode) current).getLastChild();
		}
		INode current1 = current;
		ILeafNode result = findNextLeaf(current1,
				n -> !Objects.equal(current1, n) && n.getGrammarElement() instanceof Keyword);
		if (result != null && Objects.equal(result.getText(), kw)) {
			return result;
		}
		return null;
	}

	public ILeafNode findNextLeaf(INode node, Function1<? super ILeafNode, ? extends Boolean> matches) {
		if (node != null) {
			if (node instanceof ILeafNode && matches.apply((ILeafNode) node)) {
				return (ILeafNode) node;
			}
			NodeIterator ni = new NodeIterator(node);
			while (ni.hasNext()) {
				INode next = ni.next();
				if (next instanceof ILeafNode && matches.apply((ILeafNode) next)) {
					return (ILeafNode) next;
				}
			}
		}
		return null;
	}
}
