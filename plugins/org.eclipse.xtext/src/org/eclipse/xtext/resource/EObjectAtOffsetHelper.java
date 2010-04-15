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
import org.eclipse.xtext.util.TextLocation;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EObjectAtOffsetHelper {

	public static EObject resolveElementAt(XtextResource resource, int offset, TextLocation location) {
		return internalResolveElementAt(resource, offset, true, true, location);
	}

	public static EObject resolveContainedElementAt(XtextResource resource, int offset, TextLocation location) {
		return internalResolveElementAt(resource, offset, true, false, location);
	}

	public static EObject resolveCrossReferencedElementAt(XtextResource resource, int offset, TextLocation location) {
		return internalResolveElementAt(resource, offset, false, true, location);
	}
	
	public static TextLocation getLocation(EObject sourceEObject, EReference eReference, int indexInList) {
		List<AbstractNode> result = NodeUtil.findNodesForFeature(sourceEObject, eReference);
		if (result.isEmpty())
			return new TextLocation();
		if (result.size() == 1) {
			AbstractNode node = result.get(0);
			return new TextLocation(node.getOffset(), node.getLength());
		}
		if (indexInList == -1 || indexInList > result.size())
			return new TextLocation();
		AbstractNode node = result.get(indexInList);
		return new TextLocation(node.getOffset(), node.getLength());
	}

	private static EObject internalResolveElementAt(XtextResource resource, int offset, boolean isContainment,
			boolean isCrossReference, TextLocation location) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			AbstractNode node = ParseTreeUtil.getCurrentOrFollowingNodeByOffset(parseResult.getRootNode(), offset);
			while (node != null) {
				if (isCrossReference && node.getGrammarElement() instanceof CrossReference) {
					updateLocation(location, node);
					return resolveCrossReferencedElement(node);
				} else if (isContainment && node.getElement() != null) {
					updateLocation(location, node);
					return node.getElement();
				} else {
					node = node.getParent();
				}
			}
		}
		return null;
	}

	private static void updateLocation(TextLocation location, AbstractNode node) {
		if (location != null) {
			location.setOffset(node.getOffset());
			location.setLength(node.getLength());
		}
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
