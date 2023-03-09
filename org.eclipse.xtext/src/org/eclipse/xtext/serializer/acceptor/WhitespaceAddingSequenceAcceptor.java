/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class WhitespaceAddingSequenceAcceptor extends DelegatingSequenceAcceptor {

	protected AbstractRule lastWhitespace = null;

	protected Stack<RuleCall> ruleCalls = new Stack<RuleCall>();

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		writeWhitespace(rc);
		super.acceptAssignedCrossRefDatatype(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		writeWhitespace(enumRC);
		super.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		writeWhitespace(kw);
		super.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		writeWhitespace(rc);
		super.acceptAssignedCrossRefTerminal(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		writeWhitespace(datatypeRC);
		super.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		writeWhitespace(enumRC);
		super.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		writeWhitespace(keyword);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		writeWhitespace(terminalRC);
		super.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptUnassignedAction(Action action) {
		writeWhitespace(action);
		super.acceptUnassignedAction(action);
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node) {
		writeWhitespace(datatypeRC);
		super.acceptUnassignedDatatype(datatypeRC, value, node);
	}

	@Override
	public void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node) {
		writeWhitespace(enumRC);
		super.acceptUnassignedEnum(enumRC, value, node);
	}

	@Override
	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		writeWhitespace(keyword);
		super.acceptUnassignedKeyword(keyword, token, node);
	}

	@Override
	public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
		writeWhitespace(terminalRC);
		super.acceptUnassignedTerminal(terminalRC, value, node);
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent, ICompositeNode node) {
		ruleCalls.push(rc);
		return super.enterAssignedParserRuleCall(rc, newCurrent, node);
	}

	@Override
	@Deprecated
	public void enterUnassignedParserRuleCall(RuleCall rc) {
		ruleCalls.push(rc);
		super.enterUnassignedParserRuleCall(rc);
	}

	protected AbstractRule findWhitespaceRule(AbstractElement ele) {
		for (int i = ruleCalls.size() - 1; i >= 0; i--) {
			AbstractRule rule = ruleCalls.get(i).getRule();
			if (rule instanceof ParserRule) {
				ParserRule pr = (ParserRule) rule;
				if (pr.isDefinesHiddenTokens()) {
					for (AbstractRule hidden : pr.getHiddenTokens())
						if (isWhitespaceRule(hidden))
							return hidden;
					return null;
				}
			}
		}
		if (ruleCalls.isEmpty())
			return findWhitespaceRule(GrammarUtil.getGrammar(ele));
		return findWhitespaceRule(GrammarUtil.getGrammar(ruleCalls.get(0)));
	}

	protected AbstractRule findWhitespaceRule(Grammar grammar) {
		for (AbstractRule hidden : grammar.getHiddenTokens())
			if (isWhitespaceRule(hidden))
				return hidden;
		if (!grammar.getUsedGrammars().isEmpty())
			return findWhitespaceRule(grammar.getUsedGrammars().get(0));
		return null;
	}

	protected boolean isWhitespaceRule(AbstractRule rule) {
		return "WS".equals(rule.getName());
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		ruleCalls.pop();
		super.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	@Override
	@Deprecated
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		ruleCalls.pop();
		super.leaveUnssignedParserRuleCall(rc);
	}

	protected void writeWhitespace(AbstractElement ele) {
		if (lastWhitespace != null) {
			lastWhitespace = findWhitespaceRule(ele);
			if (lastWhitespace != null)
				((ISequenceAcceptor) getDelegate()).acceptWhitespace(lastWhitespace, " ", null);
		} else
			lastWhitespace = findWhitespaceRule(ele);
	}

}
