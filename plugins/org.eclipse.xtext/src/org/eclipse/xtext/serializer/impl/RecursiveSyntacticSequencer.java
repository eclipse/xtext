/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.serializer.IRecursiveSyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.IRecursiveSyntacticSequencer;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISyntacticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecursiveSyntacticSequencer implements IRecursiveSyntacticSequencer {

	protected static class SemanitcAcceptor implements ISyntacticSequenceAcceptor {

		protected IRecursiveSyntacticSequenceAcceptor delegateAcceptor;
		protected ISemanticSequencer delegateSemSequencer;

		protected ISyntacticSequencer delegateSynSequencer;

		protected Acceptor errorAcceptor;

		public SemanitcAcceptor(ISyntacticSequencer syndelegate, ISemanticSequencer semdelegate,
				IRecursiveSyntacticSequenceAcceptor acceptor, Acceptor errors) {
			this.delegateAcceptor = acceptor;
			this.delegateSynSequencer = syndelegate;
			this.delegateSemSequencer = semdelegate;
			this.errorAcceptor = errors;
		}

		public void acceptAssignedAction(Action action, EObject eobject) {
			delegateAcceptor.enterAssignedAction(action, eobject);
			ISemanticSequenceAcceptor acc = delegateSynSequencer.createAcceptor(action, eobject, this, errorAcceptor);
			delegateSemSequencer.createSequence(action, eobject, acc, errorAcceptor);
			delegateAcceptor.leaveAssignedAction(action, eobject);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, EObject value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedCrossRefDatatype(datatypeRC, value, node);
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, EObject value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedCrossRefEnum(enumRC, value, node);
		}

		public void acceptAssignedCrossRefKeyword(Keyword keyword, EObject value, ILeafNode node) {
			delegateAcceptor.acceptAssignedCrossRefKeyword(keyword, value, node);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, EObject value, ILeafNode node) {
			delegateAcceptor.acceptAssignedCrossRefTerminal(terminalRC, value, node);
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, Object value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedDatatype(datatypeRC, value, node);
		}

		public void acceptAssignedEnum(RuleCall enumRC, Object value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedEnum(enumRC, value, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, Boolean value, ILeafNode node) {
			delegateAcceptor.acceptAssignedKeyword(keyword, value, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String value, ILeafNode node) {
			delegateAcceptor.acceptAssignedKeyword(keyword, value, node);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild) {
			ParserRule pr = (ParserRule) ruleCall.getRule();
			delegateAcceptor.enterAssignedParserRuleCall(ruleCall, semanticChild);
			ISemanticSequenceAcceptor acc = delegateSynSequencer.createAcceptor(pr, semanticChild, this, errorAcceptor);
			delegateSemSequencer.createSequence(pr, semanticChild, acc, errorAcceptor);
			delegateAcceptor.leaveAssignedParserRuleCall(ruleCall);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, Object value, ILeafNode node) {
			delegateAcceptor.acceptAssignedTerminal(terminalRC, value, node);
		}

		public void acceptUnassignedAction(Action action) {
			delegateAcceptor.acceptUnassignedAction(action);
		}

		public void acceptUnassignedDatatype(RuleCall datatypeRC, Object value) {
			delegateAcceptor.acceptUnassignedDatatype(datatypeRC, value);
		}

		public void acceptUnassignedEnum(RuleCall enumRC, Object value) {
			delegateAcceptor.acceptUnassignedEnum(enumRC, value);
		}

		public void acceptUnassignedKeyword(Keyword keyword) {
			delegateAcceptor.acceptUnassignedKeyword(keyword);
		}

		public void acceptUnassignedTerminal(RuleCall terminalRC, Object value) {
			delegateAcceptor.acceptUnassignedTerminal(terminalRC, value);
		}

		public void enterUnassignedParserRuleCall(RuleCall rc) {
			delegateAcceptor.enterUnassignedParserRuleCall(rc);
		}

		public void finish() {
		}

		public void leaveUnssignedParserRuleCall(RuleCall rc) {
			delegateAcceptor.leaveUnssignedParserRuleCall(rc);
		}

	}

	public void createSequence(ISyntacticSequencer syndelegate, ISemanticSequencer semdelegate, EObject context,
			EObject semanticObject, IRecursiveSyntacticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		SemanitcAcceptor acceptor = new SemanitcAcceptor(syndelegate, semdelegate, sequenceAcceptor, errorAcceptor);
		ISemanticSequenceAcceptor acc = syndelegate.createAcceptor(context, semanticObject, acceptor, errorAcceptor);
		semdelegate.createSequence(context, semanticObject, acc, errorAcceptor);
	}

}
