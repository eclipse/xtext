/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.serializer;

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.serializer.acceptor.DelegatingSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.3
 * @deprecated Use org.eclipse.xtext.testing.serializer.AssertStructureAcceptor instead
 */
@Deprecated(forRemoval = true)
public class AssertStructureAcceptor extends DelegatingSequenceAcceptor {

	protected Stack<RuleCall> stack = new Stack<RuleCall>();

	public AssertStructureAcceptor() {
		this(null);
	}

	public AssertStructureAcceptor(ISemanticSequenceAcceptor delegate) {
		super(delegate);
	}

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
			ICompositeNode node) {
		assertElement(datatypeRC);
		super.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		assertElement(enumRC);
		super.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		assertElement(kw);
		super.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
			ILeafNode node) {
		assertElement(terminalRC);
		super.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		assertElement(datatypeRC);
		super.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		assertElement(enumRC);
		super.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		assertElement(keyword);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		assertElement(keyword);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		assertElement(keyword);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		assertElement(terminalRC);
		super.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		super.acceptComment(rule, token, node);
	}

	@Override
	public void acceptUnassignedAction(Action action) {
		assertElement(action);
		super.acceptUnassignedAction(action);
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		assertElement(datatypeRC);
		super.acceptUnassignedDatatype(datatypeRC, token, node);
	}

	@Override
	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		assertElement(enumRC);
		super.acceptUnassignedEnum(enumRC, token, node);
	}

	@Override
	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		assertElement(keyword);
		super.acceptUnassignedKeyword(keyword, token, node);
	}

	@Override
	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		assertElement(terminalRC);
		super.acceptUnassignedTerminal(terminalRC, token, node);
	}

	@Override
	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		super.acceptWhitespace(rule, token, node);
	}

	protected void assertElement(AbstractElement element) {
		AbstractRule expectedRule = null;
		if (stack.isEmpty()) {
			// FIXME: this doesn't work if the serialized EObject is not the model's root. 
			// expectedRule = EcoreUtil2.getContainerOfType(element, Grammar.class).getRules().get(0);
			return;
		} else
			expectedRule = stack.peek().getRule();
		AbstractRule actualRule = EcoreUtil2.getContainerOfType(element, AbstractRule.class);
		if (expectedRule != actualRule) {
			GrammarElementTitleSwitch formatter = new GrammarElementTitleSwitch().showQualified().showRule();
			String elementName = formatter.apply(element);
			String expName = expectedRule.getName();
			String actualName = actualRule.getName();
			String msg = "Element " + elementName + " should be in rule " + expName + " but it is in " + actualName;
			throw new IllegalStateException(msg);
		}
	}

	protected void assertPop(RuleCall call) {
		RuleCall expected = stack.pop();
		if (call != expected) {
			GrammarElementTitleSwitch formatter = new GrammarElementTitleSwitch().showQualified().showRule();
			String expectedName = formatter.apply(expected);
			String actualName = formatter.apply(call);
			throw new IllegalStateException("Expected rule call " + expectedName + " but got " + actualName);
		}
	}

	protected void assertPush(RuleCall call) {
		assertElement(call);
		stack.push(call);
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		return super.enterAssignedAction(action, semanticChild, node);
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		assertPush(rc);
		return super.enterAssignedParserRuleCall(rc, semanticChild, node);
	}

	@Override
	public void enterUnassignedParserRuleCall(RuleCall rc) {
		assertPush(rc);
		super.enterUnassignedParserRuleCall(rc);
	}

	@Override
	public void finish() {
		super.finish();
	}

	@Override
	public void leaveAssignedAction(Action action, EObject semanticChild) {
		super.leaveAssignedAction(action, semanticChild);
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		assertPop(rc);
		super.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	@Override
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		assertPop(rc);
		super.leaveUnssignedParserRuleCall(rc);
	}

}
