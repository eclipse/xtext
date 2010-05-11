/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author meysholdt - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DefaultCommentAssociater extends AbstractCommentAssociater {

	@Inject
	protected TokenUtil tokenUtil;

	public Map<LeafNode, EObject> associateCommentsWithSemanticEObjects(EObject model, Set<CompositeNode> roots) {
		Map<LeafNode, EObject> mapping = new HashMap<LeafNode, EObject>();
		for (CompositeNode rootNode : roots)
			associateCommentsWithSemanticEObjects(mapping, rootNode);
//		for (Map.Entry<LeafNode, EObject> entry : mapping.entrySet()) {
//			System.out.println(entry.getKey().getText() + " " + entry.getValue());
//		}
		return mapping;
	}

	/**
	 * This implementation associates each comment with the next following semantic token's EObject, except for the
	 * case, where a line of the document end by a semantic element followed by a comment. Then, the the comment is
	 * associated with this preceding semantic token.
	 */
	protected void associateCommentsWithSemanticEObjects(Map<LeafNode, EObject> mapping, CompositeNode rootNode) {
		//		System.out.println(EmfFormatter.objToStr(rootNode));
		EObject currentEObject = null;
		List<LeafNode> currentComments = new ArrayList<LeafNode>();

		NodeIterator nodeIterator = new NodeIterator(rootNode);
		// rewind to previous token with token owner 
		while (nodeIterator.hasPrevious() && currentEObject == null) {
			AbstractNode node = nodeIterator.previous();
			if (tokenUtil.isToken(node)) {
				currentEObject = tokenUtil.getTokenOwner(node);
			}
		}
		while (nodeIterator.hasNext()) {
			EObject o = nodeIterator.next();
			if (o instanceof AbstractNode) {
				AbstractNode node = (AbstractNode) o;
				if (tokenUtil.isCommentNode(node)) {
					currentComments.add((LeafNode) node);
				}
				boolean isToken = tokenUtil.isToken(node);
				if ((node instanceof LeafNode || isToken) && node.getLine() != node.endLine() && currentEObject != null) {
					// found a newline -> associating existing comments with currentEObject
					addMapping(mapping, currentComments, currentEObject);
					currentEObject = null;
				}
				if (isToken) {
					Pair<List<LeafNode>, List<LeafNode>> leadingAndTrailingHiddenTokens = tokenUtil
							.getLeadingAndTrailingHiddenTokens(node);
					for (LeafNode leadingHiddenNode : leadingAndTrailingHiddenTokens.getFirst()) {
						if (tokenUtil.isCommentNode(leadingHiddenNode)) {
							currentComments.add(leadingHiddenNode);
						}
					}
					nodeIterator.prune();
					currentEObject = tokenUtil.getTokenOwner(node);
					if (currentEObject != null) {
						addMapping(mapping, currentComments, currentEObject);
						if (node.getOffset() > rootNode.getOffset() + rootNode.getLength()) {
							// found next EObject outside rootNode
							break;
						}
					}
				}
			}
		}
		if (!currentComments.isEmpty()) {
			if (currentEObject != null) {
				addMapping(mapping, currentComments, currentEObject);
			} else {
				EObject objectForRemainingComments = getEObjectForRemainingComments(rootNode);
				if (objectForRemainingComments != null) {
					addMapping(mapping, currentComments, objectForRemainingComments);
				}
			}
		}
	}

	protected void addMapping(Map<LeafNode, EObject> mapping, List<LeafNode> currentComments, EObject currentEObject) {
		for (LeafNode l : currentComments)
			mapping.put(l, currentEObject);
		currentComments.clear();
	}

	protected EObject getEObjectForRemainingComments(CompositeNode rootNode) {
		TreeIterator<EObject> i = rootNode.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof AbstractNode && ((AbstractNode) o).getElement() != null)
				return ((AbstractNode) o).getElement();
		}
		return null;
	}
}
