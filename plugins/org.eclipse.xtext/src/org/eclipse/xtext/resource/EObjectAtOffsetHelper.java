/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EObjectAtOffsetHelper {

	public EObject resolveElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, true);
	}

	public EObject resolveCrossReferencedElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, false);
	}

	protected EObject internalResolveElementAt(XtextResource resource, int offset, boolean isContainment) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			INode node = leaf;
			while (node != null) {
				if (node.getGrammarElement() instanceof CrossReference) {
					return resolveCrossReferencedElement(node);
				} else if (isContainment && node.hasDirectSemanticElement()) {
					return node.getSemanticElement();
				} else {
					node = node.getParent();
				}
			}
		}
		return null;
	}

	protected EObject resolveCrossReferencedElement(INode node) {
		EObject referenceOwner = NodeModelUtils.findActualSemanticObjectFor(node);
		EReference crossReference = GrammarUtil.getReference((CrossReference) node.getGrammarElement(),
				referenceOwner.eClass());
		if (!crossReference.isMany()) {
			return (EObject) referenceOwner.eGet(crossReference);
		} else {
			List<?> listValue = (List<?>) referenceOwner.eGet(crossReference);
			List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(referenceOwner, crossReference);
			int currentIndex = 0;
			for(INode nodeForFeature: nodesForFeature) {
				if (nodeForFeature.getTotalOffset() <= node.getTotalOffset() && nodeForFeature.getTotalEndOffset() >= node.getTotalEndOffset())
					return (EObject) listValue.get(currentIndex);
				currentIndex++;
			}
		}
		return null;
	}
	
}
