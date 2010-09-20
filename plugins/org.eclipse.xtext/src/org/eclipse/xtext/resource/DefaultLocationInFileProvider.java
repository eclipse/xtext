/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Peter Friese - Implementation
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultLocationInFileProvider implements ILocationInFileProvider {

	public ITextRegion getSignificantTextRegion(EObject obj) {
		return getTextRegion(obj, true);
	}

	public ITextRegion getFullTextRegion(EObject obj) {
		return getTextRegion(obj, false);
	}

	protected ITextRegion getTextRegion(EObject obj, boolean isSignificant) {
		final NodeAdapter adapter = NodeUtil.getNodeAdapter(obj);
		if (adapter == null) {
			if (obj.eContainer() == null)
				return ITextRegion.EMPTY_REGION;
			return getTextRegion(obj.eContainer(), isSignificant);
		}
		List<AbstractNode> nodes = null;
		if (isSignificant)
			nodes = getLocationNodes(obj);
		if (nodes == null || nodes.isEmpty())
			nodes = Collections.<AbstractNode> singletonList(adapter.getParserNode());
		return createRegion(nodes);
	}

	public ITextRegion getSignificantTextRegion(final EObject owner, EStructuralFeature feature, final int indexInList) {
		return getTextRegion(owner, feature, indexInList, true);
	}

	public ITextRegion getFullTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		return getTextRegion(owner, feature, indexInList, false);
	}

	private ITextRegion getTextRegion(final EObject owner, EStructuralFeature feature, final int indexInList,
			final boolean isSignificant) {
		return new EcoreSwitch<ITextRegion>() {
			@Override
			public ITextRegion caseEAttribute(EAttribute feature) {
				return getLocationOfAttribute(owner, feature, indexInList, isSignificant);
			}

			@Override
			public ITextRegion caseEReference(EReference feature) {
				if (feature.isContainment() || feature.isContainer()) {
					return getLocationOfContainmentReference(owner, feature, indexInList, isSignificant);
				} else {
					return getLocationOfCrossReference(owner, feature, indexInList, isSignificant);
				}
			}

		}.doSwitch(feature);
	}

	protected ITextRegion getLocationOfContainmentReference(final EObject owner, EReference feature,
			final int indexInList, boolean isSignificant) {
		Object referencedElement = null;
		if(feature.isMany()) {
			List<?> values = (List<?>) owner.eGet(feature);
			if(indexInList >= values.size())
				referencedElement = owner;
			else
				referencedElement = values.get(indexInList);
		}
		else {
			referencedElement = owner.eGet(feature);
		}
		return getTextRegion((EObject) referencedElement, isSignificant);
	}

	protected ITextRegion getLocationOfCrossReference(EObject owner, EReference reference, int indexInList,
			boolean isSignificant) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(owner);
		if (nodeAdapter != null) {
			CompositeNode parserNode = nodeAdapter.getParserNode();
			if (parserNode != null) {
				int currentIndex = 0;
				for (TreeIterator<EObject> childrenIterator = parserNode.eAllContents(); childrenIterator.hasNext();) {
					AbstractNode ownerChildNode = (AbstractNode) childrenIterator.next();
					EObject grammarElement = ownerChildNode.getGrammarElement();
					if (grammarElement instanceof CrossReference) {
						EReference crossReference2 = GrammarUtil.getReference((CrossReference) grammarElement,
								owner.eClass());
						if (reference == crossReference2) {
							if (currentIndex == indexInList || !reference.isMany()) {
								return new TextRegion(ownerChildNode.getOffset(), ownerChildNode.getLength());
							}
							++currentIndex;
						}
						childrenIterator.prune();
					}
					if (grammarElement instanceof TypeRef || grammarElement instanceof RuleCall) {
						childrenIterator.prune();
					}
				}
				return getTextRegion(owner, isSignificant);
			}
		}
		return null;
	}

	protected ITextRegion getLocationOfAttribute(EObject owner, EAttribute attribute, int indexInList,
			boolean isSignificant) {
		if (indexInList >= 0) {
			List<AbstractNode> findNodesForFeature = NodeUtil.findNodesForFeature(owner, attribute);
			if (indexInList < findNodesForFeature.size()) {
				AbstractNode node = findNodesForFeature.get(indexInList);
				return new TextRegion(node.getOffset(), node.getLength());
			}
			return getTextRegion(owner, isSignificant);
		}
		return null;
	}

	protected List<AbstractNode> getLocationNodes(EObject obj) {
		final EStructuralFeature nameFeature = getIdentifierFeature(obj);
		if (nameFeature != null)
			return NodeUtil.findNodesForFeature(obj, nameFeature);

		List<AbstractNode> resultNodes = new ArrayList<AbstractNode>();
		final NodeAdapter adapter = NodeUtil.getNodeAdapter(obj);
		final CompositeNode startNode = adapter.getParserNode();
		AbstractNode keywordNode = null;
		// use LeafNodes instead of children?
		EList<AbstractNode> children = startNode.getChildren();
		for (AbstractNode child : children) {
			EObject grammarElement = child.getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) grammarElement;
				String ruleName = ruleCall.getRule().getName();
				if (ruleName.equals("ID")) {
					resultNodes.add(child);
				}
			} else if (grammarElement instanceof Keyword) {
				// TODO use only keywords, that aren't symbols like '=' ?
				if (keywordNode == null && useKeyword((Keyword) grammarElement, obj)) {
					keywordNode = child;
				}
			}
		}
		if (resultNodes.isEmpty() && keywordNode != null)
			resultNodes.add(keywordNode);
		return resultNodes;
	}

	protected boolean useKeyword(Keyword keyword, EObject context) {
		return true;
	}

	protected EStructuralFeature getIdentifierFeature(EObject obj) {
		final EClass eClass = obj.eClass();
		final EStructuralFeature result = eClass.getEStructuralFeature("name");
		return result != null ? result : eClass.getEStructuralFeature("id");
	}

	protected ITextRegion createRegion(final List<AbstractNode> nodes) {
		// if we've got more than one ID elements, we want to select them all
		ITextRegion result = ITextRegion.EMPTY_REGION;
		for (AbstractNode node : nodes) {
			if (!isHidden(node))
				result = result.merge(new TextRegion(node.getOffset(), node.getLength()));
		}
		return result;
	}

	protected boolean isHidden(AbstractNode node) {
		return node instanceof LeafNode && ((LeafNode) node).isHidden();
	}
}
