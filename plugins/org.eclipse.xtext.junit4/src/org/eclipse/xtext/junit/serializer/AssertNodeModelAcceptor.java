/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssertNodeModelAcceptor implements ISequenceAcceptor {

	protected ISemanticSequenceAcceptor delegate;

	public AssertNodeModelAcceptor() {
		this(null);
	}

	public AssertNodeModelAcceptor(ISemanticSequenceAcceptor delegate) {
		super();
		this.delegate = delegate;
	}

	public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
			ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
			ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			((ISequenceAcceptor) delegate).acceptComment(rule, token, node);
	}

	public void acceptUnassignedAction(Action action) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedAction(action);
	}

	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedDatatype(datatypeRC, token, node);
	}

	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedEnum(enumRC, token, node);
	}

	public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedKeyword(keyword, node);
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		assertNode(node);
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedTerminal(terminalRC, token, node);
	}

	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		if (!"".equals(token))
			assertNode(node);
		if (delegate != null)
			((ISequenceAcceptor) delegate).acceptWhitespace(rule, token, node);
	}

	protected void assertNode(INode node) {
		if (node == null)
			throw new NullPointerException("Node is null");
	}

	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			return delegate.enterAssignedAction(action, semanticChild, node);
		return true;
	}

	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		assertNode(node);
		if (delegate != null)
			return delegate.enterAssignedParserRuleCall(rc, semanticChild, node);
		return true;
	}

	public void enterUnassignedParserRuleCall(RuleCall rc) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).enterUnassignedParserRuleCall(rc);
	}

	public void finish() {
		if (delegate != null)
			delegate.finish();
	}

	public void leaveAssignedAction(Action action, EObject semanticChild) {
		if (delegate != null)
			delegate.leaveAssignedAction(action, semanticChild);
	}

	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		if (delegate != null)
			delegate.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).leaveUnssignedParserRuleCall(rc);
	}

}
