/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenUtil {
	@Inject
	protected IHiddenTokenHelper hiddenTokenHelper;

	public Pair<List<LeafNode>, List<LeafNode>> getLeadingAndTrailingHiddenTokens(AbstractNode node) {
		Pair<List<LeafNode>, List<LeafNode>> result = Tuples.<List<LeafNode>, List<LeafNode>> create(Lists
				.<LeafNode> newArrayList(), Lists.<LeafNode> newArrayList());
		List<LeafNode> leafNodes = node.getLeafNodes();
		int begin = 0, end = leafNodes.size() - 1;
		while (begin <= end && leafNodes.get(begin).isHidden())
			result.getFirst().add(leafNodes.get(begin++));
		while (begin <= end && leafNodes.get(end).isHidden())
			result.getSecond().add(0, leafNodes.get(end--));
		return result;
	}

	public EObject getTokenOwner(AbstractNode node) {
		if (node.getElement() != null)
			return node.getElement();
		if (node.getParent() != null) {
			if (node.getParent().getElement() != null)
				return node.getParent().getElement();
			boolean isParser = node.getParent().getGrammarElement() instanceof ParserRule
					|| (node.getParent().getGrammarElement() instanceof RuleCall && ((RuleCall) node.getParent()
							.getGrammarElement()).getRule().getType().getClassifier() instanceof EClass);
			for (AbstractNode sibling : node.getParent().getChildren())
				if (sibling.getElement() != null && (isParser || sibling.getGrammarElement() instanceof Action))
					return sibling.getElement();
		}
		return NodeUtil.findASTElement(node);
	}

	public AbstractRule getTokenRule(AbstractNode node) {
		if (node == null)
			return null;
		EObject element = node.getGrammarElement();
		if (element instanceof AbstractRule)
			return (AbstractRule) element;
		if (element instanceof CrossReference)
			element = ((CrossReference) element).getTerminal();
		if (element instanceof RuleCall)
			return ((RuleCall) element).getRule();
		return null;
	}

	public boolean isCommentNode(AbstractNode node) {
		if (node instanceof LeafNode && ((LeafNode) node).isHidden()
				&& node.getGrammarElement() instanceof AbstractRule)
			return hiddenTokenHelper.isComment((AbstractRule) node.getGrammarElement());
		return false;
	}

	public boolean isToken(AbstractNode node) {
		if (node instanceof LeafNode)
			return !((LeafNode) node).isHidden();
		AbstractRule rule;
		if (node.getGrammarElement() instanceof AbstractRule)
			rule = (AbstractRule) node.getGrammarElement();
		else if (node.getGrammarElement() instanceof RuleCall)
			rule = ((RuleCall) node.getGrammarElement()).getRule();
		else if (node.getGrammarElement() instanceof CrossReference
				&& ((CrossReference) node.getGrammarElement()).getTerminal() instanceof RuleCall)
			rule = ((RuleCall) ((CrossReference) node.getGrammarElement()).getTerminal()).getRule();
		else
			rule = null;
		if (rule instanceof ParserRule)
			return GrammarUtil.isDatatypeRule((ParserRule) rule);
		if (rule instanceof EnumRule)
			return true;
		return false;
	}

	public boolean isWhitespaceNode(AbstractNode node) {
		if (node instanceof LeafNode && ((LeafNode) node).isHidden()
				&& node.getGrammarElement() instanceof AbstractRule)
			return hiddenTokenHelper.isWhitespace((AbstractRule) node.getGrammarElement());
		return false;
	}
	
	public boolean isWhitespaceOrCommentNode(AbstractNode node) {
		return isWhitespaceNode(node) || isCommentNode(node);
	}

	public String serializeNode(AbstractNode node) {
		if (node instanceof LeafNode)
			return ((LeafNode) node).getText();
		List<LeafNode> leafNodes = node.getLeafNodes();
		int begin = 0, end = leafNodes.size() - 1;
		while (begin <= end && isWhitespaceOrCommentNode(leafNodes.get(begin)))
			begin++;
		while (begin <= end && isWhitespaceOrCommentNode(leafNodes.get(end)))
			end--;
		if (begin == end)
			return isWhitespaceOrCommentNode(leafNodes.get(begin)) ? "" : leafNodes.get(begin).getText();
		StringBuilder b = new StringBuilder();
		for (int i = begin; i <= end; i++)
			b.append(leafNodes.get(i).getText());
		return b.toString();
	}
}
