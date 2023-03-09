/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParsingPointers {

	private ICompositeNode rootNode;
	private int length;
	private int offset;
	private final List<ICompositeNode> validReplaceRootNodes;
	private final List<ICompositeNode> nodesEnclosingRegion;

	public PartialParsingPointers(ICompositeNode rootNode, int offset, int length,
			List<ICompositeNode> validReplaceRootNodes, List<ICompositeNode> nodesEnclosingRegion) {
		if (validReplaceRootNodes == null || validReplaceRootNodes.isEmpty()) {
			throw new IllegalArgumentException("validReplaceRootNodes cannot be empty");
		}
		this.rootNode = rootNode;
		this.offset = offset;
		this.length = length;
		this.validReplaceRootNodes = validReplaceRootNodes;
		this.nodesEnclosingRegion = nodesEnclosingRegion;
	}

	/**
	 * @return either a RuleCall or a ParserRule
	 */
	public EObject findEntryRuleOrRuleCall(ICompositeNode replaceRootNode) {
		EObject grammarElement = replaceRootNode.getGrammarElement();
		if (grammarElement instanceof CrossReference) {
			grammarElement = ((CrossReference) grammarElement).getTerminal();
		}
		if (GrammarUtil.isParserRuleCall(grammarElement)) {
			return grammarElement;
		}
		else if (grammarElement instanceof ParserRule) {
			return grammarElement;
		}
		else if (grammarElement instanceof Action) {
			BidiIterator<INode> iterator = replaceRootNode.getChildren().iterator();
			while(iterator.hasNext()) {
				INode next = iterator.next();
				if (next instanceof ICompositeNode) {
					return findEntryRuleOrRuleCall((ICompositeNode) next);
				}
			}
			throw new IllegalArgumentException("Invalid parsetree: Action node does not have a Composite child");
		}
		else
			throw new IllegalArgumentException(
					"Entry rule can only be resolved for parser rules, rule calls, cross-references or actions, but tried to resolve for: "
					+ replaceRootNode.getGrammarElement().eClass().getName());
	}

	public List<ICompositeNode> getValidReplaceRootNodes() {
		return validReplaceRootNodes;
	}
	
	public List<ICompositeNode> getNodesEnclosingRegion() {
		return nodesEnclosingRegion;
	}

	public ICompositeNode getDefaultReplaceRootNode() {
		return validReplaceRootNodes.get(validReplaceRootNodes.size() - 1);
	}

	public ICompositeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(ICompositeNode rootNode) {
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

}
