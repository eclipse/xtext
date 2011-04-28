/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.collect.Lists;

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
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		if (node == null) {
			if (obj.eContainer() == null)
				return ITextRegion.EMPTY_REGION;
			return getTextRegion(obj.eContainer(), isSignificant);
		}
		List<INode> nodes = null;
		if (isSignificant)
			nodes = getLocationNodes(obj);
		if (nodes == null || nodes.isEmpty())
			nodes = Collections.<INode>singletonList(node);
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
		return doGetLocationOfFeature(owner, reference, indexInList, isSignificant);
	}

	protected ITextRegion getLocationOfAttribute(EObject owner, EAttribute attribute, int indexInList,
			boolean isSignificant) {
		return doGetLocationOfFeature(owner, attribute, indexInList, isSignificant);
	}

	protected ITextRegion doGetLocationOfFeature(EObject owner, EStructuralFeature feature, int indexInList,
			boolean isSignificant) {
		if (!feature.isMany())
			indexInList = 0;
		if (indexInList >= 0) {
			List<INode> findNodesForFeature = NodeModelUtils.findNodesForFeature(owner, feature);
			if (indexInList < findNodesForFeature.size()) {
				INode node = findNodesForFeature.get(indexInList);
				return new TextRegion(node.getOffset(), node.getLength());
			}
			return getTextRegion(owner, isSignificant);
		}
		return null;
	}

	protected List<INode> getLocationNodes(EObject obj) {
		final EStructuralFeature nameFeature = getIdentifierFeature(obj);
		if (nameFeature != null)
			return NodeModelUtils.findNodesForFeature(obj, nameFeature);

		List<INode> resultNodes = Lists.newArrayList();
		final ICompositeNode startNode = NodeModelUtils.getNode(obj);
		INode keywordNode = null;
		// use LeafNodes instead of children?
		for (INode child : startNode.getChildren()) {
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

	protected ITextRegion createRegion(final List<INode> nodes) {
		// if we've got more than one ID elements, we want to select them all
		ITextRegion result = ITextRegion.EMPTY_REGION;
		for (INode node : nodes) {
			if (!isHidden(node))
				result = result.merge(new TextRegion(node.getOffset(), node.getLength()));
		}
		return result;
	}

	protected boolean isHidden(INode node) {
		return node instanceof ILeafNode && ((ILeafNode) node).isHidden();
	}
}
