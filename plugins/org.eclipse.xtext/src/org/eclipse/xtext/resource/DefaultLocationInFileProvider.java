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
import org.eclipse.xtext.parsetree.util.ParsetreeSwitch;
import org.eclipse.xtext.util.TextLocation;

/**
 * @author Peter Friese - Implementation
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultLocationInFileProvider implements ILocationInFileProvider {

	public TextLocation getLocation(final EObject owner, EStructuralFeature feature, final int indexInList) {
		return new EcoreSwitch<TextLocation>() {
			@Override
			public TextLocation caseEAttribute(EAttribute feature) {
				return getLocationOfAttribute(owner, feature, indexInList);
			}

			@Override
			public TextLocation caseEReference(EReference feature) {
				if (feature.isContainment() || feature.isContainer()) {
					return getLocationOfContainmentReference(owner, feature, indexInList);
				} else {
					return getLocationOfCrossReference(owner, feature, indexInList);
				}
			}

		}.doSwitch(feature);
	}

	protected TextLocation getLocationOfContainmentReference(final EObject owner, EReference feature,
			final int indexInList) {
		Object referencedElement = (feature.isMany()) ? ((List<?>) owner.eGet(feature)).get(indexInList) : owner
				.eGet(feature);
		return getLocation((EObject) referencedElement);
	}

	protected TextLocation getLocationOfCrossReference(EObject owner, EReference reference, int indexInList) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(owner);
		if (nodeAdapter != null) {
			CompositeNode parserNode = nodeAdapter.getParserNode();
			if (parserNode != null) {
				int currentIndex = 0;
				for (TreeIterator<EObject> childrenIterator = parserNode.eAllContents(); childrenIterator.hasNext();) {
					AbstractNode ownerChildNode = (AbstractNode) childrenIterator.next();
					EObject grammarElement = ownerChildNode.getGrammarElement();
					if (grammarElement instanceof CrossReference) {
						EReference crossReference2 = GrammarUtil.getReference((CrossReference) grammarElement, owner
								.eClass());
						if (reference == crossReference2) {
							if (currentIndex == indexInList || !reference.isMany()) {
								return new TextLocation(ownerChildNode.getOffset(), ownerChildNode.getLength());
							}
							++currentIndex;
						}
						childrenIterator.prune();
					}
					if (grammarElement instanceof TypeRef || grammarElement instanceof RuleCall) {
						childrenIterator.prune();
					}
				}
				return getLocation(owner);
			}
		}
		return null;
	}

	protected TextLocation getLocationOfAttribute(EObject owner, EAttribute attribute, int indexInList) {
		if (indexInList >= 0) {
			List<AbstractNode> findNodesForFeature = NodeUtil.findNodesForFeature(owner, attribute);
			if (indexInList < findNodesForFeature.size()) {
				AbstractNode node = findNodesForFeature.get(indexInList);
				return new TextLocation(node.getOffset(), node.getLength());
			}
			return getLocation(owner);
		}
		return null;
	}

	public TextLocation getLocation(EObject obj) {
		final NodeAdapter adapter = NodeUtil.getNodeAdapter(obj);
		if (adapter == null) {
			if (obj.eContainer() == null)
				return new TextLocation(0, 0);
			return getLocation(obj.eContainer());
		}

		List<AbstractNode> nodes = getLocationNodes(obj);
		if (nodes == null || nodes.isEmpty())
			nodes = Collections.<AbstractNode> singletonList(adapter.getParserNode());

		return createRegion(nodes);
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

	protected static class OffsetCalculator extends ParsetreeSwitch<LeafNode> {

		private boolean forward = true;

		public AbstractNode handle(List<AbstractNode> nodes, boolean forward) {
			this.forward = forward;
			AbstractNode result = handleImpl(nodes);
			if (result == null) {
				if (forward)
					result = nodes.get(0);
				else
					result = nodes.get(nodes.size() - 1);
			}
			return result;
		}

		public LeafNode handleImpl(List<AbstractNode> nodes) {
			if (forward) {
				for (AbstractNode node : nodes) {
					LeafNode result = doSwitch(node);
					if (result != null)
						return result;
				}
			} else {
				for (int i = nodes.size() - 1; i >= 0; i--) {
					AbstractNode node = nodes.get(i);
					LeafNode result = doSwitch(node);
					if (result != null)
						return result;
				}
			}
			return null;
		}

		@Override
		public LeafNode caseCompositeNode(CompositeNode object) {
			return handleImpl(object.getChildren());
		}

		@Override
		public LeafNode caseLeafNode(LeafNode object) {
			if (!object.isHidden())
				return object;
			return null;
		}
	}

	protected TextLocation createRegion(final List<AbstractNode> nodes) {
		// if we've got more than one ID elements, we want to select them all
		OffsetCalculator calculator = createCalculator();
		AbstractNode firstNode = calculator.handle(nodes, true);
		AbstractNode lastNode = calculator.handle(nodes, false);
		int length = (lastNode.getOffset() - firstNode.getOffset()) + lastNode.getLength();
		return new TextLocation(firstNode.getOffset(), length);
	}

	protected OffsetCalculator createCalculator() {
		return new OffsetCalculator();
	}

}
