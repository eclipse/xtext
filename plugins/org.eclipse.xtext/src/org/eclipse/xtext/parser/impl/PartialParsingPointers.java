/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import static org.eclipse.xtext.parsetree.NodeUtil.dumpCompositeNodeInfo;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class PartialParsingPointers {

	private static final Logger logger = Logger.getLogger(PartialParsingPointers.class);

	private CompositeNode rootNode;
	private int length;
	private int offset;
	private final List<CompositeNode> validReplaceRootNodes;
	private final List<CompositeNode> nodesEnclosingChangeRegion;

	public PartialParsingPointers(CompositeNode rootNode, int offset, int length,
			List<CompositeNode> validReplaceRootNodes, List<CompositeNode> nodesEnclosingRegion) {
		if (validReplaceRootNodes == null || validReplaceRootNodes.isEmpty()) {
			throw new IllegalArgumentException("validReplaceRootNodes cannot be empty");
		}
		if (nodesEnclosingRegion == null || nodesEnclosingRegion.isEmpty()) {
			throw new IllegalArgumentException("nodesEnclosingChangeRegion cannot be empty");
		}
		this.rootNode = rootNode;
		this.offset = offset;
		this.length = length;
		this.validReplaceRootNodes = validReplaceRootNodes;
		this.nodesEnclosingChangeRegion = nodesEnclosingRegion;
	}

	public String findReparseRegion() {
		return findReparseRegion(getDefaultReplaceRootNode());
	}

	public String findReparseRegion(CompositeNode replaceRootNode) {
		return replaceRootNode.serialize();
	}

	public String findEntryRuleName() {
		return findEntryRuleName(getDefaultReplaceRootNode());
	}

	public String findEntryRuleName(CompositeNode replaceRootNode) {
		EObject grammarElement = replaceRootNode.getGrammarElement();
		if (grammarElement instanceof CrossReference) {
			grammarElement = ((CrossReference) grammarElement).getTerminal();
		}
		if (GrammarUtil.isParserRuleCall(grammarElement)) {
			return ((RuleCall) grammarElement).getRule().getName();
		}
		else if (grammarElement instanceof ParserRule) {
			return ((ParserRule) grammarElement).getName();
		}
		else if (grammarElement instanceof Action) {
			EList<AbstractNode> children = replaceRootNode.getChildren();
			for (AbstractNode abstractNode : children) {
				if (abstractNode instanceof CompositeNode) {
					return findEntryRuleName((CompositeNode) abstractNode);
				}
			}
			throw new IllegalArgumentException("Invalid parsetree: Action node does not have a Composite child");
		}
		else
			throw new IllegalArgumentException(
					"Entry rule can only be resolved for parser rules, rule calls, cross-references or actions, but tried to resolve for: "
					+ replaceRootNode.getGrammarElement().eClass().getName());
	}

	public EObject findASTReplaceElement() {
		return findASTReplaceElement(getDefaultReplaceRootNode());
	}

	public EObject findASTReplaceElement(CompositeNode replaceRootNode) {
		boolean foundReplaceNode = false;
		for (int i = 0; i < nodesEnclosingChangeRegion.size(); ++i) {
			CompositeNode nodeEnclosingRegion = nodesEnclosingChangeRegion.get(i);
			if (nodeEnclosingRegion == replaceRootNode) {
				foundReplaceNode = true;
			}
			if (foundReplaceNode) {
				EObject currentASTElement = nodesEnclosingChangeRegion.get(i).getElement();
				if (currentASTElement != null) {
					return currentASTElement;
				}
			}
		}
		// AST element is attached to a child not enclosing the region.
		// In this case, there must not be any composite nodes with
		// multiple composite children on the way down.
		return NodeUtil.getASTElementForRootNode(nodesEnclosingChangeRegion.get(nodesEnclosingChangeRegion.size() - 1));
	}

	public String findASTContainmentFeatureName() {
		return findASTContainmentFeatureName(getDefaultReplaceRootNode());
	}

	public String findASTContainmentFeatureName(CompositeNode replaceRootNode) {
		if (replaceRootNode != null) {
			EObject grammarElement = replaceRootNode.getGrammarElement();
			if (grammarElement instanceof Action) {
				// we want the feature the action's AST element has been
				// assigned to, not the feature of the action itself
				return internalFindASTContainmentFeatureName(replaceRootNode.getParent());
			}
			return internalFindASTContainmentFeatureName(replaceRootNode);
		}
		return null;
	}

	private String internalFindASTContainmentFeatureName(CompositeNode replaceRootNode) {
		if (replaceRootNode != null) {
			EObject grammarElement = replaceRootNode.getGrammarElement();
			for (EObject container = grammarElement; container != null; container = container.eContainer()) {
				if (container instanceof Action) {
					return ((Action) container).getFeature();
				}
				else if (container instanceof Assignment) {
					return ((Assignment) container).getFeature();
				}
			}
			return internalFindASTContainmentFeatureName(replaceRootNode.getParent());
		}
		return null;
	}

	public EObject findASTParentElement() {
		return findASTParentElement(getDefaultReplaceRootNode());
	}

	public EObject findASTParentElement(CompositeNode replaceRootNode) {
		CompositeNode parent = replaceRootNode.getParent();
		if (parent == null) {
			return null;
		}
		if (parent.getElement() != null) {
			return parent.getElement();
		}
		return findASTParentElement(parent);
	}

	public List<CompositeNode> getValidReplaceRootNodes() {
		return validReplaceRootNodes;
	}

	public CompositeNode getDefaultReplaceRootNode() {
		return validReplaceRootNodes.get(validReplaceRootNodes.size() - 1);
	}

	public CompositeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(CompositeNode rootNode) {
		this.rootNode = rootNode;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void dump() {
		dump(getDefaultReplaceRootNode());
	}

	public void dump(CompositeNode replaceRootNode) {
		if (!logger.isDebugEnabled())
			return;

		logger.debug("Parsing " + findReparseRegion(replaceRootNode));
		logger.debug("with rule " + findEntryRuleName(replaceRootNode));
		dumpCompositeNodeInfo("Replacing node ", replaceRootNode);
		logger.debug("Replacing AST element " + findASTReplaceElement(replaceRootNode).eClass().getName());
		EObject astParentElement = findASTParentElement(replaceRootNode);
		String astParentElementClassName = astParentElement != null ? astParentElement.eClass().getName() : "null";
		logger.debug("in AST parent reference " + astParentElementClassName + "."
				+ Strings.notNull(findASTContainmentFeatureName(replaceRootNode)));
		logger.debug("");
	}

}
