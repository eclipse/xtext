/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.acceptor.DelegatingSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssertNodeModelAcceptor extends DelegatingSequenceAcceptor {

	public AssertNodeModelAcceptor() {
		this(null);
	}

	public AssertNodeModelAcceptor(ISemanticSequenceAcceptor delegate) {
		super(delegate);
	}

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
			ICompositeNode node) {
		assertNode(node);
		super.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		assertNode(node);
		super.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		assertNode(node);
		super.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
			ILeafNode node) {
		assertNode(node);
		super.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		assertNode(node);
		super.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		assertNode(node);
		super.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		assertNode(node);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}
	
	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		assertNode(node);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		assertNode(node);
		super.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		assertNode(node);
		super.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		assertNode(node);
		super.acceptComment(rule, token, node);
	}

	@Override
	public void acceptUnassignedAction(Action action) {
		super.acceptUnassignedAction(action);
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		assertNode(node);
		super.acceptUnassignedDatatype(datatypeRC, token, node);
	}

	@Override
	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		assertNode(node);
		super.acceptUnassignedEnum(enumRC, token, node);
	}

	@Override
	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		assertNode(node);
		super.acceptUnassignedKeyword(keyword, token, node);
	}

	@Override
	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		assertNode(node);
		super.acceptUnassignedTerminal(terminalRC, token, node);
	}

	@Override
	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		if (!"".equals(token))
			assertNode(node);
		super.acceptWhitespace(rule, token, node);
	}

	protected void assertNode(INode node) {
		if (node == null)
			throw new NullPointerException("Node is null");
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		assertNode(node);
		return super.enterAssignedAction(action, semanticChild, node);
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		assertNode(node);
		return super.enterAssignedParserRuleCall(rc, semanticChild, node);
	}

	@Override
	@Deprecated
	public void enterUnassignedParserRuleCall(RuleCall rc) {
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
		super.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	@Override
	@Deprecated
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		super.leaveUnssignedParserRuleCall(rc);
	}

}
