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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

import com.google.inject.Inject;

/**
 * @author meysholdt - Initial contribution and API
 */
public class DefaultCommentAssociater extends AbstractCommentAssociater {

	@Inject
	protected TokenUtil tokenUtil;

	@Override
	public Map<LeafNode, EObject> associateCommentsWithSemanticEObjects(EObject model, Set<CompositeNode> roots) {
		Map<LeafNode, EObject> mapping = new HashMap<LeafNode, EObject>();
		for (CompositeNode rootNode : roots)
			associateCommentsWithSemanticEObjects(mapping, rootNode);
		//		System.out.println(mapping);
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
		TreeIterator<EObject> i = EcoreUtil2.eAll(rootNode);
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof AbstractNode) {
				AbstractNode node = (AbstractNode) o;
				if (tokenUtil.isCommentNode(node)) {
					currentComments.add((LeafNode) node);
				}
				boolean isToken = tokenUtil.isToken(node);
				if ((node instanceof LeafNode || isToken) && node.serialize().contains("\n") && currentEObject != null) {
					for (LeafNode l : currentComments)
						mapping.put(l, currentEObject);
					currentComments.clear();
					currentEObject = null;
				}
				if (isToken) {
					i.prune();
					currentEObject = tokenUtil.getTokenOwner(node);
					if (currentEObject != null) {
						for (LeafNode l : currentComments)
							mapping.put(l, currentEObject);
						currentComments.clear();
					}
				}
			}
		}
		if (!currentComments.isEmpty()) {
			EObject obj = getEObjectForRemainingComments(rootNode);
			if (obj != null)
				for (LeafNode l : currentComments)
					mapping.put(l, obj);
		}
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
