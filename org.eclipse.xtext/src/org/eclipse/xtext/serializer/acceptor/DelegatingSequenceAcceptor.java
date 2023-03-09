/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DelegatingSequenceAcceptor implements ISequenceAcceptor {

	private ISemanticSequenceAcceptor delegate;

	public DelegatingSequenceAcceptor() {
		this(null);
	}

	public DelegatingSequenceAcceptor(ISemanticSequenceAcceptor delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		if (delegate != null)
			delegate.acceptAssignedCrossRefDatatype(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		if (delegate != null)
			delegate.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		if (delegate != null)
			delegate.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		if (delegate != null)
			delegate.acceptAssignedCrossRefTerminal(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		if (delegate != null)
			delegate.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		if (delegate != null)
			delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		if (delegate != null)
			delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		if (delegate != null)
			delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		if (delegate != null)
			((ISequenceAcceptor) delegate).acceptComment(rule, token, node);
	}

	@Override
	public void acceptUnassignedAction(Action action) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedAction(action);
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedDatatype(datatypeRC, value, node);
	}

	@Override
	public void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedEnum(enumRC, value, node);
	}

	@Override
	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedKeyword(keyword, token, node);
	}

	@Override
	public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).acceptUnassignedTerminal(terminalRC, value, node);
	}

	@Override
	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		if (delegate != null)
			((ISequenceAcceptor) delegate).acceptWhitespace(rule, token, node);
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		if (delegate != null)
			return delegate.enterAssignedAction(action, semanticChild, node);
		return true;
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject newCurrent, ICompositeNode node) {
		if (delegate != null)
			return delegate.enterAssignedParserRuleCall(rc, newCurrent, node);
		return true;
	}

	@Override
	@Deprecated
	public void enterUnassignedParserRuleCall(RuleCall rc) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).enterUnassignedParserRuleCall(rc);
	}

	@Override
	public void finish() {
		if (delegate != null)
			delegate.finish();
	}

	public ISemanticSequenceAcceptor getDelegate() {
		return delegate;
	}

	@Override
	public void leaveAssignedAction(Action action, EObject semanticChild) {
		if (delegate != null)
			delegate.leaveAssignedAction(action, semanticChild);
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		if (delegate != null)
			delegate.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	@Override
	@Deprecated
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		if (delegate != null)
			((ISyntacticSequenceAcceptor) delegate).leaveUnssignedParserRuleCall(rc);
	}

	public void setDelegate(ISequenceAcceptor delegate) {
		this.delegate = delegate;
	}

}
