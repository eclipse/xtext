/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EObjectAtOffsetHelper {

	public static EObject resolveElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, true, true);
	}

	public static EObject resolveContainedElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, true, false);
	}

	public static EObject resolveCrossReferencedElementAt(XtextResource resource, int offset) {
		return internalResolveElementAt(resource, offset, false, true);
	}

	private static EObject internalResolveElementAt(XtextResource resource, int offset, boolean isContainment, boolean isCrossReference) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(), offset);
			while (node != null) {
				if (isCrossReference && node.getGrammarElement() instanceof CrossReference) {
					return resolveCrossReferencedElement(node);
				} else if (isContainment && node.getElement() != null) {
					return node.getElement();
				} else {
					node = node.getParent();
				}
			}
		}
		return null;
	}

	private static EObject resolveCrossReferencedElement(AbstractNode node) {
		EObject referenceOwner = NodeUtil.getNearestSemanticObject(node);
		EReference crossReference = GrammarUtil.getReference((CrossReference) node.getGrammarElement(), referenceOwner
				.eClass());
		if (!crossReference.isMany()) {
			return (EObject) referenceOwner.eGet(crossReference);
		} else {
			List<?> listValue = (List<?>) referenceOwner.eGet(crossReference);
			CompositeNode ownerNode = NodeUtil.getNodeAdapter(referenceOwner).getParserNode();
			int currentIndex = 0;
			for (TreeIterator<EObject> childrenIterator = ownerNode.eAllContents(); childrenIterator.hasNext();) {
				AbstractNode ownerChildNode = (AbstractNode) childrenIterator.next();
				if (ownerChildNode == node) {
					return (EObject) listValue.get(currentIndex);
				}
				EObject grammarElement = ownerChildNode.getGrammarElement();
				if (grammarElement instanceof CrossReference) {
					EReference crossReference2 = GrammarUtil.getReference((CrossReference) grammarElement,
							referenceOwner.eClass());
					if (crossReference == crossReference2) {
						++currentIndex;
					}
					childrenIterator.prune();
				}
				if (grammarElement instanceof TypeRef || grammarElement instanceof RuleCall) {
					childrenIterator.prune();
				}
			}
		}
		return null;
	}
}
