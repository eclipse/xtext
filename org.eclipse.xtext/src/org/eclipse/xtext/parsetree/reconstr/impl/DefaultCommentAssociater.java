/*******************************************************************************
 * Copyright (c) 2010, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author meysholdt - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DefaultCommentAssociater extends AbstractCommentAssociater {

	@Inject
	protected TokenUtil tokenUtil;

	@Override
	public Map<ILeafNode, EObject> associateCommentsWithSemanticEObjects(EObject model, Set<ICompositeNode> roots) {
		Map<ILeafNode, EObject> mapping = new HashMap<ILeafNode, EObject>();
		for (ICompositeNode rootNode : roots)
			associateCommentsWithSemanticEObjects(mapping, rootNode);
		return mapping;
	}

	/**
	 * This implementation associates each comment with the next following semantic token's EObject, except for the
	 * case, where a line of the document ends by a semantic element followed by a comment. Then, the comment is
	 * associated with this preceding semantic token.
	 */
	protected void associateCommentsWithSemanticEObjects(Map<ILeafNode, EObject> mapping, ICompositeNode rootNode) {
		//		System.out.println(EmfFormatter.objToStr(rootNode));
		EObject currentEObject = null;
		List<ILeafNode> currentComments = new ArrayList<ILeafNode>();

		NodeIterator nodeIterator = new NodeIterator(rootNode);
		// rewind to previous token with token owner 
		while (nodeIterator.hasPrevious() && currentEObject == null) {
			INode node = nodeIterator.previous();
			if (tokenUtil.isToken(node)) {
				currentEObject = tokenUtil.getTokenOwner(node);
			}
		}
		while (nodeIterator.hasNext()) {
			INode node = nodeIterator.next();
			if (tokenUtil.isCommentNode(node)) {
				currentComments.add((ILeafNode) node);
			}
			boolean isToken = tokenUtil.isToken(node);
			if ((node instanceof ILeafNode || isToken) && currentEObject != null) {
				ITextRegionWithLineInformation textRegion = node.getTextRegionWithLineInformation();
				if (textRegion.getLineNumber() != textRegion.getEndLineNumber()) {
					// found a newline -> associating existing comments with currentEObject
					addMapping(mapping, currentComments, currentEObject);
					currentEObject = null;
				}
			}
			if (isToken) {
				Pair<List<ILeafNode>, List<ILeafNode>> leadingAndTrailingHiddenTokens = tokenUtil
						.getLeadingAndTrailingHiddenTokens(node);
				for (ILeafNode leadingHiddenNode : leadingAndTrailingHiddenTokens.getFirst()) {
					if (tokenUtil.isCommentNode(leadingHiddenNode)) {
						currentComments.add(leadingHiddenNode);
					}
				}
				nodeIterator.prune();
				currentEObject = tokenUtil.getTokenOwner(node);
				if (currentEObject != null) {
					addMapping(mapping, currentComments, currentEObject);
					if (node.getOffset() > rootNode.getEndOffset()) {
						// found next EObject outside rootNode
						break;
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

	protected void addMapping(Map<ILeafNode, EObject> mapping, List<ILeafNode> currentComments, EObject currentEObject) {
		for (ILeafNode l : currentComments)
			mapping.put(l, currentEObject);
		currentComments.clear();
	}

	protected EObject getEObjectForRemainingComments(ICompositeNode rootNode) {
		TreeIterator<INode> i = rootNode.getAsTreeIterable().iterator();
		while (i.hasNext()) {
			INode o = i.next();
			if (o.hasDirectSemanticElement())
				return o.getSemanticElement();
		}
		return null;
	}
}
