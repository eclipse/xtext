/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class NodeModelBasedRegionAccessBuilder {

	private Map<EObject, NodeEObjectRegion> eObjToTokens;
	private NodeHiddenRegion firstHidden;
	private NodeHiddenRegion lastHidden;
	private XtextResource resource;
	private LinkedList<NodeEObjectRegion> stack = new LinkedList<NodeEObjectRegion>();

	protected void add(NodeModelBasedRegionAccess access, INode node) {
		if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()) {
			ILeafNode leafNode = (ILeafNode) node;
			lastHidden.addPart(createHidden(lastHidden, leafNode));
		} else if (node.getLength() > 0) {
			NodeEObjectRegion eObjectTokens = stack.peek();
			NodeSemanticRegion newSemantic = createSemanticRegion(access, node);
			NodeHiddenRegion newHidden = createHiddenRegion(access);
			newSemantic.setTrailingHiddenRegion(newHidden);
			newHidden.setPrevious(newSemantic);
			newSemantic.setLeadingHiddenRegion(lastHidden);
			lastHidden.setNext(newSemantic);
			eObjectTokens.getSemanticRegions().add(newSemantic);
			newSemantic.setEObjectTokens(eObjectTokens);
			lastHidden = newHidden;
		}
	}

	public NodeModelBasedRegionAccess create() {
		NodeModelBasedRegionAccess access = new NodeModelBasedRegionAccess(this);
		return access;
	}

	protected NodeHidden createHidden(NodeHiddenRegion hidden, ILeafNode node) {
		if (isComment(node))
			return new NodeComment(hidden, node);
		else
			return new NodeWhitespace(hidden, node);
	}

	protected NodeHiddenRegion createHiddenRegion(ITextRegionAccess access) {
		return new NodeHiddenRegion(access);
	}

	protected NodeSemanticRegion createSemanticRegion(NodeModelBasedRegionAccess access, INode node) {
		return new NodeSemanticRegion(access, node);
	}

	protected NodeEObjectRegion createTokens(NodeModelBasedRegionAccess access, INode node) {
		return new NodeEObjectRegion(access, node);
	}

	protected Map<EObject, AbstractEObjectRegion> getEObjectToTokensMap(ITextRegionAccess regionAccess) {
		this.eObjToTokens = Maps.newHashMap();
		this.firstHidden = createHiddenRegion(regionAccess);
		this.lastHidden = this.firstHidden;
		NodeModelBasedRegionAccess access = (NodeModelBasedRegionAccess) regionAccess;
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		process(rootNode, access);
		return ImmutableMap.<EObject, AbstractEObjectRegion> copyOf(this.eObjToTokens);
	}

	protected XtextResource getXtextResource() {
		return resource;
	}

	protected boolean include(INode node) {
		if (node instanceof ILeafNode) {
			return true;
		} else if (node instanceof ICompositeNode) {
			EObject element = node.getGrammarElement();
			return GrammarUtil.isDatatypeRuleCall(element) || element instanceof CrossReference || GrammarUtil.isEnumRuleCall(element);
		}
		return false;
	}

	protected boolean isComment(ILeafNode leaf) {
		String text = leaf.getText();
		for (int i = 0; i < text.length(); i++)
			if (!Character.isWhitespace(text.charAt(i)))
				return true;
		return false;
	}

	protected boolean isEObjectRoot(INode node) {
		if (node instanceof ICompositeNode) {
			ICompositeNode parent = node.getParent();
			while (parent != null && GrammarUtil.isEObjectFragmentRuleCall(parent.getGrammarElement()))
				parent = parent.getParent();
			if (parent == null)
				return true;
			INode root = parent;
			while (root != null && !root.hasDirectSemanticElement())
				root = root.getParent();
			if (root == null)
				return false;
			EObject element = node.getGrammarElement();
			if (GrammarUtil.isEObjectRuleCall(element) && !GrammarUtil.isEObjectFragmentRuleCall(element)) {
				if (!parent.hasDirectSemanticElement())
					return false;
				BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
				iterator.next();
				while (iterator.hasNext()) {
					INode next = iterator.next();
					if (next.hasDirectSemanticElement())
						return true;
					EObject ge = next.getGrammarElement();
					if (ge instanceof Action)
						return true;
					if (ge instanceof RuleCall && GrammarUtil.isAssigned(ge)
							&& ((RuleCall) ge).getRule().getType().getClassifier() instanceof EDataType)
						return true;
					if (ge instanceof CrossReference)
						return true;
				}
			}
			if (element instanceof Action) {
				return parent.hasDirectSemanticElement();
			}
		}
		return false;
	}

	protected EObject findGrammarElement(INode node, EObject obj) {
		INode current = node;
		String feature = obj.eContainingFeature().getName();
		while (current != null) {
			EObject grammarElement = current.getGrammarElement();
			Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
			if (assignment != null && feature.equals(assignment.getFeature()))
				return grammarElement;
			if (grammarElement instanceof Action) {
				Action action = (Action) grammarElement;
				if (feature.equals(action.getFeature()))
					return grammarElement;
				else if (current == node && current instanceof ICompositeNode) {
					INode child = ((ICompositeNode) current).getFirstChild();
					while (child instanceof ICompositeNode) {
						EObject grammarElement2 = child.getGrammarElement();
						Assignment assignment2 = GrammarUtil.containingAssignment(grammarElement2);
						if (assignment2 != null && feature.equals(assignment2.getFeature()))
							return grammarElement2;
						//						if (child.hasDirectSemanticElement() && child.getSemanticElement() != obj)
						//							break;
						child = ((ICompositeNode) child).getFirstChild();
					}
				}
			}
			if (current.hasDirectSemanticElement() && current.getSemanticElement() != obj)
				return null;
			current = current.getParent();
		}
		return null;
	}

	protected void process(INode node, NodeModelBasedRegionAccess access) {
		NodeEObjectRegion tokens = stack.peek();
		boolean creator = isEObjectRoot(node);
		if (creator || tokens == null) {
			tokens = new NodeEObjectRegion(access, node);
			tokens.setLeadingHiddenRegion(lastHidden);
			stack.push(tokens);
		}
		if (tokens.getSemanticElement() == null) {
			if (node.getParent() == null) {
				tokens.setSemantcElement(resource.getContents().get(0));
				tokens.setGrammarElement(node.getGrammarElement());
			} else if (node.hasDirectSemanticElement()) {
				tokens.setSemantcElement(node.getSemanticElement());
				tokens.setGrammarElement(findGrammarElement(node, tokens.getSemanticElement()));
			}
		}
		if (include(node)) {
			if (node instanceof ICompositeNode) {
				for (ILeafNode leaf : node.getLeafNodes())
					if (leaf.isHidden())
						this.add(access, leaf);
					else
						break;
			}
			this.add(access, node);
		} else if (node instanceof ICompositeNode) {
			for (INode child : ((ICompositeNode) node).getChildren())
				process(child, access);
		}
		if (creator) {
			NodeEObjectRegion popped = stack.pop();
			popped.setTrailingHiddenRegion(lastHidden);
			EObject semanticElement = popped.getSemanticElement();
			if (semanticElement == null)
				throw new IllegalStateException();
			if (!stack.isEmpty() && semanticElement.eContainer() != stack.peek().getSemanticElement())
				throw new IllegalStateException();
			EObject grammarElement = popped.getGrammarElement();
			if (grammarElement == null) {
				throw new IllegalStateException();
			}
			NodeEObjectRegion old = eObjToTokens.put(semanticElement, popped);
			if (old != null)
				throw new IllegalStateException();
		}
	}

	public NodeModelBasedRegionAccessBuilder withResource(XtextResource resource) {
		this.resource = resource;
		return this;
	}
}